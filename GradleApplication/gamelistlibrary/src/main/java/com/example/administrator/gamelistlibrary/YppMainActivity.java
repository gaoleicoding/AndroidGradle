package com.example.administrator.gamelistlibrary;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YppMainActivity extends Activity {

    Activity curAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.yppactivity_main);
        final EditText editText=(EditText) findViewById(R.id.editText);
        Button button=(Button) findViewById(R.id.button);
        final ImageView imageView=(ImageView)findViewById(R.id.imageView);
        curAct=this;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence text=editText.getText().toString()+getApplicationContext().getPackageName();
                Toast.makeText(curAct,text,Toast.LENGTH_LONG).show();
                imageView.setImageResource(R.drawable.ewm);
            }
        });
    }
}
