package rudko.fit.bstu.laba3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import rudko.fit.bstu.laba3.R;

public class MailTelVK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_tel_v_k);
        Bundle arguments = getIntent().getExtras();
        String mail = arguments.getString("Mail");
        EditText mailEdit = super.findViewById(R.id.InputMail);
        mailEdit.setText(mail);
        String VK = arguments.getString("VK");
        EditText VKEdit = super.findViewById(R.id.InputVK);
        VKEdit.setText(VK);
        String Tel = arguments.getString("Tel");
        EditText TelEdit = super.findViewById(R.id.InputTel);
        TelEdit.setText(Tel);
    }

    public void Next(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        int[] bday = arguments.getIntArray("BDay");

        Intent intent = new Intent(this, LisStu.class);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("BDay", bday);
        intent.putExtra("Mail", ((EditText)super.findViewById(R.id.InputMail)).getText().toString());
        intent.putExtra("Tel", ((EditText)super.findViewById(R.id.InputTel)).getText().toString());
        intent.putExtra("VK", ((EditText)super.findViewById(R.id.InputVK)).getText().toString());
        startActivity(intent);

    }
    public void Back(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        int[] bday = arguments.getIntArray("BDay");


        Intent intent = new Intent(this, Age.class);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("BDay", bday);
        startActivity(intent);
    }

}