package com.hzyc.wzy.test01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText usernameEdit;
    private EditText passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);

        usernameEdit = (EditText)findViewById(R.id.usernameEdit);
        passwordEdit = (EditText)findViewById(R.id.passwordEdit);
        login = (Button)findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (usernameEdit.getText().toString().equals("admin") && passwordEdit.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "账号或密码错误", Toast.LENGTH_LONG).show();
                }
            }
        });
    }




}
