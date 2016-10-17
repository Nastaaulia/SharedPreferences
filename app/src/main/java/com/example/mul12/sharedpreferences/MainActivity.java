package com.example.mul12.sharedpreferences;

import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    // Session Manager Class
    SessionManager session;
    // Button Logout
    Button btnLogout, btnNext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Session class instance
        session = new SessionManager(getApplicationContext());
        TextView lblName = (TextView) findViewById(R.id.lblNama);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
        final EditText edNama = (EditText) findViewById(R.id.edNama);
        final EditText edNim = (EditText) findViewById(R.id.edNim);
        // Button logout
           btnLogout = (Button) findViewById(R.id.btnLogout);
            btnNext = (Button) findViewById(R.id.btnNext);
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();
        // Cek User apakah sudah login
        session.checkLogin();
        // Mendapatkan data user dari session
        HashMap<String, String> user = session.getUserDetails();
        // nama
        String name = user.get(SessionManager.KEY_NAME);
        // email
        String email = user.get(SessionManager.KEY_EMAIL);
        // menampilkan user data
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));
        /**          * Logout button click event          * */
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // menghapus session data
                // dan mengarahakan ke LoginActivity
                session.logoutUser();
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edNama.getText().toString();
                String nim = edNim.getText().toString();
                Intent a = new Intent(getApplicationContext(), Main2Activity.class);
                session.createLoginSession2(nama, nim);
                startActivity(a);
            }
        });
    }
}