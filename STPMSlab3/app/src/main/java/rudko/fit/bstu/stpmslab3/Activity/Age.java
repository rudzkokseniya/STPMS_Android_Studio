package rudko.fit.bstu.stpmslab3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import rudko.fit.bstu.stpmslab3.R;

public class Age extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
        DatePicker datePicker = super.findViewById(R.id.datepicker);
        Bundle arguments = getIntent().getExtras();
        int[] bday = arguments.getIntArray("BDay");
        if (bday != null)
            datePicker.init(bday[2], bday[1], bday[0], null);
        else
            datePicker.init(2001, 9, 21, null);

    }

    public void Back(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");


        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        startActivity(intent);
    }

    public void Next(View view) {
        DatePicker datePicker = super.findViewById(R.id.datepicker);
        int[] birthday = new int[]{datePicker.getDayOfMonth(), datePicker.getMonth(), datePicker.getYear()};

        Intent intent = new Intent(this, LisStu.class);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");

        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("BDay", birthday);
        startActivity(intent);
    }
}