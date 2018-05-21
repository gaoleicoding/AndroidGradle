package com.gradle;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gradle.basemodule.BaseActivity;
import com.gradle.mylibrary.LibraryActivity;
import com.gradle.mylibrary2.Library2Activity;

import java.lang.reflect.Field;


public class MainActivity extends BaseActivity {

    Button button1;
    TextView textView,splash_text;
    ImageView imageView;
    RelativeLayout splash_layout;
    Handler handler=new Handler(){
        public void handleMessage(Message msg){
            splash_layout.setVisibility(View.GONE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.title);
        splash_text = (TextView) findViewById(R.id.splash_text);
        imageView = (ImageView) findViewById(R.id.img);
        splash_layout = (RelativeLayout) findViewById(R.id.splash_layout);
        initConfig();
        handler.sendEmptyMessageDelayed(0,3000);
//        splash_layout.setBackgroundResource(R.mipmap.splash_bg);
//        splash_text.setText(R.string.splash_text);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Intent intent = new Intent();
                                           //这里的packetname 一定记住填写 掉用方的packetname 因为 aar最终会被合并到调用方的manifest文件
//                                           intent.setComponent(new ComponentName("com.gradle",//packagename
//                                                   "com.gradle.mylibrary.LibraryActivity"));//classname//
                                           intent.setClass(MainActivity.this,LibraryActivity.class);
                                           startActivity(intent);                                       }
                                   }
        );
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

                                                          public void onClick(View v) {
                                                              Intent intent = new Intent();
                                                              //这里的packetname 一定记住填写 掉用方的packetname 因为 aar最终会被合并到调用方的manifest文件
//                                                              intent.setComponent(new ComponentName("com.gradle",//packagename
//                                                                      "com.gradle.mylibrary2.Library2Activity"));//classname//
                                                              intent.setClass(MainActivity.this,Library2Activity.class);
                                                              startActivity(intent);
                                                          }
                                                      }
        );
    }
    private void initConfig() {
        ApplicationInfo info = null;
        try {
            info = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager
                    .GET_META_DATA);
            int tintColor = info.metaData.getInt("tint_color");
            String app_name = info.metaData.getString("app_name");
            String welcomePath = info.metaData.getString("welcome_bg");

            Class c = R.mipmap.class;
            Field[] fields = c.getFields();
            for (Field field : fields) {
                if (field.getName().equals(welcomePath.substring(welcomePath.lastIndexOf("/") + 1,
                        welcomePath.lastIndexOf(".")))) {
                    int welcomeBgRes = (int) field.get(c.newInstance());
                    imageView.setImageResource(welcomeBgRes);
                    break;
                }
            }

            textView.setTextColor(tintColor);
            textView.setText(app_name);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public void goToActivity(View v) {
        //方法一 可行
//        try{
//            Intent intent = new Intent();
//            //这里的packetname 一定记住填写 掉用方的packetname 因为 aar最终会被合并到调用方的manifest文件
//            intent.setComponent(new ComponentName("cn.gradle",//packagename
//                    "com.example.administrator.gamelistlibrary.YppMainActivity"));//classname//
//            startActivity(intent);
//        } catch (Exception e) {
//            Toast.makeText(getApplicationContext(),e.getMessage() ,Toast.LENGTH_LONG).show();
//
//        }
//        return;
        //方法二 可行
        //此种方式 需要androidmanifest.xml添加相应的activity
//        startActivity(new Intent(this, YppMainActivity.class));
//        return;

    }
}
