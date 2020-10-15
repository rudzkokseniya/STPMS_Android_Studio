package rudko.fit.bstu.laba3;

import android.app.Activity;

import androidx.appcompat.app.AlertDialog;

public  class Dialogs {

    public static void dialogs(String s, Activity activity) {
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setMessage(s);
        builder.setPositiveButton("Ok", null);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
