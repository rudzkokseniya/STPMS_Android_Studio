package rudko.fit.bstu.laba3.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import rudko.fit.bstu.laba3.R;

public class Fullinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullinfo);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.getString("Name");
        String midname = arguments.getString("MiddleName");
        String surname = arguments.getString("SurName");
        String type = arguments.getString("Type");
        String bday = arguments.getString("BDay");
        String mail=arguments.getString("Mail");
        String vk = arguments.getString("VK");
        String tel = arguments.getString("Tel");


        ((TextView) super.findViewById(R.id.OutName)).setText(name);
        ((TextView) super.findViewById(R.id.OutSurName)).setText(surname);
        ((TextView) super.findViewById(R.id.OutMidName)).setText(midname);
        ((TextView) super.findViewById(R.id.OutBDay)).setText(bday);
        ((TextView) super.findViewById(R.id.OutMail)).setText(mail);
        ((TextView) super.findViewById(R.id.OutMail)).setMovementMethod(new ScrollingMovementMethod());;
        ((TextView) super.findViewById(R.id.OutVK)).setText(vk);
        ((TextView) super.findViewById(R.id.OutTel)).setText(tel);
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

    public void OnTel(View view) {
        String tel="tel:"+((TextView) super.findViewById(R.id.OutTel)).getText().toString();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(tel)));
    }

    public void OnVK(View view) {
        String VK="http://vk.com/"+((TextView) super.findViewById(R.id.OutVK)).getText().toString();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(VK)));
    }

    public void OnMail(View view) {
        String mail="mailto:"+((TextView) super.findViewById(R.id.OutMail)).getText().toString();
        startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse(mail)));
    }
    public void OnFoto(View view) {
        showPhotoDialog();
    }

    public void showPhotoDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose ").setPositiveButton("Camera",(dialogInterface,i) ->{
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(cameraIntent);
        }).setNegativeButton("Gallery",(dialogInterface,i)->{
            Intent galleryIntent = new Intent(Intent.ACTION_PICK);
            galleryIntent.setType("image/*");
            startActivity(galleryIntent);
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}