package rudko.fit.bstu.laba3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import rudko.fit.bstu.laba3.Dialogs;
import rudko.fit.bstu.laba3.ForJson;
import rudko.fit.bstu.laba3.ListAdapter;
import rudko.fit.bstu.laba3.R;
import rudko.fit.bstu.laba3.units.Listener;
import rudko.fit.bstu.laba3.units.Person;
import rudko.fit.bstu.laba3.units.Students;

public class AllStaff extends AppCompatActivity {

    private List<Person> persons = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_staff);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Person.class, new ForJson());
        Gson gson = builder.create();

        InputStreamReader streamReader = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(super.getFilesDir(), "Staff.txt"));
            streamReader = new InputStreamReader(fileInputStream);

            ArrayList<Person> dataItems;
            dataItems = gson.fromJson(streamReader, (Type) Person.class);
            for (Person p : dataItems) {
                persons.add(p);
            }
        } catch (FileNotFoundException e) {
            Dialogs.dialogs(e.getMessage(), this);
        }

        ListView listView=findViewById(R.id.outListView);
        ListAdapter adapter=new ListAdapter(this, R.layout.list_item, persons);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Person select = (Person) parent.getItemAtPosition(position);
                Intent intent=new Intent(AllStaff.this,Fullinfo.class);
                intent.putExtra("Name", select.getName());
                intent.putExtra("MiddleName", select.getMidName());
                intent.putExtra("SurName", select.getSurName());
                intent.putExtra("Type", select.getType());
                intent.putExtra("Mail", select.getMail());
                intent.putExtra("VK", select.getVK());
                intent.putExtra("Tel", select.getTel());

                if(select.getType()=="Student")
                    intent.putExtra("Mark",((Students)select).getMark());
                else
                    intent.putExtra("Organization",((Listener)select).getFullNameOrganizations());
                intent.putExtra("BDay", select.getBday());

                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(itemListener);
    }

    public void ToStart(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}