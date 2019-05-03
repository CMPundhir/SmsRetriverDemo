package com.cmpundhir.cm.smsretriverdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMessageReceiveListener{
    TextView msgTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTxt = findViewById(R.id.msg);
        MySmsRetriever.bindListener(this);
        //akeTcTdOB8c
//        AppSignatureHelper appSignatureHelper = new AppSignatureHelper(this);
//        ArrayList<String> code = appSignatureHelper.getAppSignatures();
//        for (String s : code){
//            Log.d("hash",s);
//        }
        initSMsRetriever();
    }

    private void initSMsRetriever(){
        SmsRetrieverClient client = SmsRetriever.getClient(this /* context */);
        Task<Void> task = client.startSmsRetriever();
        task.addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });

        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    @Override
    public void messageReceived(String msg) {
        msgTxt.setText(msg);
    }
}
