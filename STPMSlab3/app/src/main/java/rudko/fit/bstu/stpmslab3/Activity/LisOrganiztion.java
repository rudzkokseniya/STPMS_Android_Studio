package rudko.fit.bstu.stpmslab3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;

import rudko.fit.bstu.stpmslab3.R;


public class LisOrganiztion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis_organiztion);
        String[] organ = {"EPAM", "ITechArt", "Wargaming"};
        Spinner spinner = findViewById(R.id.ChooseOrganization);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, organ);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void Back(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        int[] bday = arguments.getIntArray("BDay");


        Intent intent = new Intent(this, LisStu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("Type", type);
        intent.putExtra("BDay", bday);
        startActivity(intent);
    }

    public void Next(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        int[] bday = arguments.getIntArray("BDay");
        Spinner spinner = super.findViewById(R.id.ChooseOrganization);
        String organization = spinner.getSelectedItem().toString();

        Intent intent = new Intent(this, Final.class);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("Type", type);
        intent.putExtra("BDay", bday);
        intent.putExtra("Organization", organization);
        startActivity(intent);
    }
}