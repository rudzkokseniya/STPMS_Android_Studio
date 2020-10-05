package rudko.fit.bstu.stpmslab3.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import rudko.fit.bstu.stpmslab3.Dialogs;
import rudko.fit.bstu.stpmslab3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            String name = arguments.getString("Name");
            String midname = arguments.getString("MiddleName");
            String surname = arguments.getString("SurName");
            EditText editText = (EditText) super.findViewById(R.id.InputName);
            EditText editText1 = (EditText) super.findViewById(R.id.InputMiddleName);
            EditText editText2 = (EditText) super.findViewById(R.id.InputSurName);
            editText.setText(name);
            editText1.setText(surname);
            editText2.setText(midname);

        }
        Dialogs.dialogs("Создались", this);
    }


    @Override
    protected void onResume() {

        Dialogs.dialogs("Вернулись", this);
        super.onResume();
    }

    @Override
    protected void onStop() {

        Dialogs.dialogs("Остановились", this);
        super.onStop();
    }

    public void FIONext(View view) {
        Intent intent = new Intent(this, Age.class);
        EditText editText = (EditText) super.findViewById(R.id.InputName);
        EditText editText1 = (EditText) super.findViewById(R.id.InputMiddleName);
        EditText editText2 = (EditText) super.findViewById(R.id.InputSurName);

        intent.putExtra("Name", editText.getText().toString());
        intent.putExtra("MiddleName", editText1.getText().toString());
        intent.putExtra("SurName", editText2.getText().toString());
        startActivity(intent);
    }

}