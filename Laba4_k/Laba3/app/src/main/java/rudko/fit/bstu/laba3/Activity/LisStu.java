package rudko.fit.bstu.laba3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import rudko.fit.bstu.laba3.R;

public class LisStu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis_stu);
        Bundle arguments = getIntent().getExtras();
        String type = arguments.getString("Type");

        if (type != null) {
            if (type.intern() == "Student") {
                RadioButton radioButton = super.findViewById(R.id.RadioStudent);
                radioButton.setChecked(true);
            } else {
                RadioButton radioButton = super.findViewById(R.id.RadioListener);
                radioButton.setChecked(true);
            }
        }

    }

    public void LisStuNext(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        int[] bday = arguments.getIntArray("BDay");
        String mail = arguments.getString("Mail");
        String vk = arguments.getString("VK");
        String tel = arguments.getString("Tel");


        if (((RadioButton) super.findViewById(R.id.RadioStudent)).isChecked()) {
            Intent intent = new Intent(this, StuMark.class);
            intent.putExtra("Name", name);
            intent.putExtra("MiddleName", midname);
            intent.putExtra("SurName", surname);
            intent.putExtra("Mail", mail);
            intent.putExtra("VK", vk);
            intent.putExtra("Tel", tel);
            intent.putExtra("BDay", bday);
            intent.putExtra("Type", "Student");
            startActivity(intent);
        }
        if (((RadioButton) super.findViewById(R.id.RadioListener)).isChecked()) {
            Intent intent = new Intent(this, LisOrganiztion.class);
            intent.putExtra("Name", name);
            intent.putExtra("MiddleName", midname);
            intent.putExtra("SurName", surname);
            intent.putExtra("BDay", bday);
            intent.putExtra("Mail", mail);
            intent.putExtra("VK", vk);
            intent.putExtra("Tel", tel);
            intent.putExtra("Type", "Listener");
            startActivity(intent);
        }
    }

    public void LisStuBack(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        int[] bday = arguments.getIntArray("BDay");
        String mail = arguments.getString("Mail");
        String vk = arguments.getString("VK");
        String tel = arguments.getString("Tel");


        Intent intent = new Intent(this, MailTelVK.class);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("BDay", bday);
        intent.putExtra("Mail", mail);
        intent.putExtra("VK", vk);
        intent.putExtra("Tel", tel);
        startActivity(intent);
    }
}