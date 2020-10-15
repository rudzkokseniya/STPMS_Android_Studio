package rudko.fit.bstu.laba3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import rudko.fit.bstu.laba3.Dialogs;
import rudko.fit.bstu.laba3.R;

public class StuMark extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_mark);
        Bundle bundle=getIntent().getExtras();
        if(bundle.getInt("Mark")!=0)
            ((EditText) super.findViewById(R.id.EditMark)).setText(bundle.getInt("Mark")+"");

    }

    public void Back(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        int[] bday = arguments.getIntArray("BDay");
        String mail = arguments.getString("Mail");
        String vk = arguments.getString("VK");
        String tel = arguments.getString("Tel");


        Intent intent = new Intent(this, LisStu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("BDay", bday);
        intent.putExtra("VK", vk);
        intent.putExtra("Tel", tel);
        intent.putExtra("Type", type);
        intent.putExtra("Mail", mail);
        startActivity(intent);
    }

    public void Next(View view) {
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        int[] bday = arguments.getIntArray("BDay");
        Integer mark;
        String mail = arguments.getString("Mail");
        String vk = arguments.getString("VK");
        String tel = arguments.getString("Tel");


        try {
            mark = Integer.parseInt(String.valueOf(((EditText) super.findViewById(R.id.EditMark)).getText()));
            if (mark < 0 || mark > 10) {
                Dialogs.dialogs("Введите число от 0 до 10", this);
                return;
            }
        } catch (Exception i) {
            Dialogs.dialogs("Введите целое число", this);
            return;
        }

        Intent intent = new Intent(this, Final.class);
        intent.putExtra("Name", name);
        intent.putExtra("MiddleName", midname);
        intent.putExtra("SurName", surname);
        intent.putExtra("Mail", mail);
        intent.putExtra("VK", vk);
        intent.putExtra("Tel", tel);
        intent.putExtra("Type", type);
        intent.putExtra("Mark", mark);
        intent.putExtra("BDay", bday);
        startActivity(intent);

    }
}