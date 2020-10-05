package rudko.fit.bstu.stpmslab3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import rudko.fit.bstu.stpmslab3.Dialogs;
import rudko.fit.bstu.stpmslab3.ForJson;
import rudko.fit.bstu.stpmslab3.R;
import rudko.fit.bstu.stpmslab3.staff.Staff;
import rudko.fit.bstu.stpmslab3.units.Listener;
import rudko.fit.bstu.stpmslab3.units.Person;
import rudko.fit.bstu.stpmslab3.units.Students;

public class Final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        int[] bday = arguments.getIntArray("BDay");

        ((TextView) super.findViewById(R.id.OutName)).setText(name);
        ((TextView) super.findViewById(R.id.OutSurName)).setText(surname);
        ((TextView) super.findViewById(R.id.OutMidName)).setText(midname);
        ((TextView) super.findViewById(R.id.OutBDay)).setText(bday[0] + ":" + (bday[1] + 1) + ":" + bday[2]);
        ((TextView) super.findViewById(R.id.OutType)).setText(type);
        TextView razn = super.findViewById(R.id.OutRazn);
        ImageView imageView=super.findViewById(R.id.Image);

        TextView textrazn = super.findViewById(R.id.OutTextRazn);
        if (arguments.getString("Organization") != null) {
            textrazn.setText("Organization");
            razn.setText(arguments.getString("Organization"));
            if((arguments.getString("Organization")).intern()=="EPAM")
                imageView.setImageResource(R.drawable.iconepam);
            if((arguments.getString("Organization")).intern()=="ITechArt")
                imageView.setImageResource(R.drawable.iconitechart);
            if((arguments.getString("Organization")).intern()=="Wargaming")
                imageView.setImageResource(R.drawable.iconwargaming);
        } else {
            textrazn.setText("Mark");
            razn.setText(arguments.getInt("Mark") + "");
            ViewGroup.LayoutParams layoutParams=imageView.getLayoutParams();
            layoutParams.height=0;
            imageView.setLayoutParams(layoutParams);
        }
    }

    public void Back(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        int[] bday = arguments.getIntArray("BDay");

        if (arguments.getString("Organization") != null) {
            Intent intent = new Intent(this, LisOrganiztion.class);
            intent.putExtra("Name", name);
            intent.putExtra("MiddleName", midname);
            intent.putExtra("SurName", surname);
            intent.putExtra("Type", type);
            intent.putExtra("Organization", arguments.getString("Organization"));
            intent.putExtra("BDay", bday);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, StuMark.class);
            intent.putExtra("Name", name);
            intent.putExtra("MiddleName", midname);
            intent.putExtra("SurName", surname);
            intent.putExtra("Type", type);
            intent.putExtra("Mark", arguments.getInt("Mark"));
            intent.putExtra("BDay", bday);
            startActivity(intent);
        }
    }

    public void Save(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        int[] bday = arguments.getIntArray("BDay");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Person.class, new ForJson());
        Gson gson = builder.create();

        Staff staff = new Staff();


        InputStreamReader streamReader = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(super.getFilesDir(), "Staff.txt"));
            streamReader = new InputStreamReader(fileInputStream);

            ArrayList<Person> dataItems;
            dataItems = gson.fromJson(streamReader, (Type) Person.class);
            for (Person p : dataItems) {
                staff.addPers(p);
            }
        } catch (FileNotFoundException e) {
            Dialogs.dialogs(e.getMessage(), this);
        }

        FileOutputStream fileOutputStream = null;
        if (arguments.getString("Organization") != null) {
            Listener listener = new Listener(surname, name, midname, bday[0] + ":" + (bday[1] + 1) + ":" + bday[2], type, ((TextView) super.findViewById(R.id.OutRazn)).getText().toString());
            staff.addPers(listener);

        } else {
            Students students = new Students(surname, name, midname, bday[0] + ":" + (bday[1] + 1) + ":" + bday[2], type, Integer.parseInt(((TextView) super.findViewById(R.id.OutRazn)).getText().toString()));
            staff.addPers(students);

        }
        String jsonListener = gson.toJson(staff);
        try {
            fileOutputStream = new FileOutputStream(new File(super.getFilesDir(), "Staff.txt"));
            fileOutputStream.write(jsonListener.getBytes());
        } catch (Exception e) {
            Dialogs.dialogs(e.getMessage(), this);
        }
    }
}