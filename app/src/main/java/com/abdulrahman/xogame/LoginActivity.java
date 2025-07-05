package com.abdulrahman.xogame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText playerOneET ;
    EditText playerTwoET ;
    Button startBT ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        playerOneET = findViewById(R.id.playerOneET);
        playerTwoET = findViewById(R.id.playerTwoET);
        startBT = findViewById(R.id.startBT);
        String Name1 = playerOneET.getText().toString();
        String Name2 = playerTwoET.getText().toString();

        startBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();

            }
        });

    }
    public void click(){
        String Name1 = playerOneET.getText().toString();
        String Name2 = playerTwoET.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(Constant.PLAYER_ONE,Name1);
        intent.putExtra(Constant.PLAYER_TWO,Name2);
        startActivity(intent);
    }
}