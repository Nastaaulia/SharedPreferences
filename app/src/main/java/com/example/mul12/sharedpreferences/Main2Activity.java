package com.example.mul12.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails2();
        // nama
        String nama = user.get(SessionManager.KEY_NAMA);
        // email
        String nim = user.get(SessionManager.KEY_NIM);
        TextView Nama = (TextView) findViewById(R.id.textView2);
        TextView Nim = (TextView) findViewById(R.id.textView3);
        Nama.setText(nama);
        Nim.setText(nim);
    }
}
