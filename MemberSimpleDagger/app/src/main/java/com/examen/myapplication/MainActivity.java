package com.examen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    private EditText memberId;
    private Button submitButton;
    @Inject
    MemberDataManager memberDataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getApp().getMemberAppComponent().inject(this);
        memberId = (EditText)findViewById(R.id.etMemberId);
        submitButton = (Button)findViewById(R.id.btnSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (memberId.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Field can not be empty", Toast.LENGTH_SHORT).show();
                }else {
                    String input = memberId.getText().toString().trim();
                    String result = memberDataManager.checkMemberStatus(input);

                    //String result = new MemberDataManager().checkMemberStatus(input);
                    Toast.makeText(MainActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
