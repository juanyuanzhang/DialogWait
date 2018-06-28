package com.example.administrator.dialogwait;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnwait = findViewById(R.id.butWait);
        btnwait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog =ProgressDialog.show(MainActivity.this,"吃飯中","請等待3秒.........",true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(3000);
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        finally{
                            dialog.dismiss();
                        }

                    }
                }).start();
            }
        });
    }
}
