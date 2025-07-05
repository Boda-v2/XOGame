package com.abdulrahman.xogame;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView Player1ScoreText ;
    TextView Player2ScoreText ;
    TextView playerOne ;
    TextView playerTwo ;
    ConstraintLayout root ;
    Button bt1 ;
    Button bt2 ;
    Button bt3 ;
    Button bt4 ;
    Button bt5 ;
    Button bt6 ;
    Button bt7 ;
    Button bt8 ;
    Button bt9 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerOne = findViewById(R.id.player_one);
        playerTwo = findViewById(R.id.player_two);

        Player1ScoreText = findViewById(R.id.player_one_score);
        Player2ScoreText = findViewById(R.id.player_tow_score);
        root = findViewById(R.id.root);
        bt1 = findViewById(R.id.bt_1);
        bt2 = findViewById(R.id.bt_2);
        bt3 = findViewById(R.id.bt_3);
        bt4 = findViewById(R.id.bt_4);
        bt5 = findViewById(R.id.bt_5);
        bt6 = findViewById(R.id.bt_6);
        bt7 = findViewById(R.id.bt_7);
        bt8 = findViewById(R.id.bt_8);
        bt9 = findViewById(R.id.bt_9);


        initalizeBoardState();

        String name1 = getIntent().getStringExtra(Constant.PLAYER_ONE);
        String name2 = getIntent().getStringExtra(Constant.PLAYER_TWO);
        playerOne.setText(name1);
        playerTwo.setText(name2);

        
    }
    int counter = 0 ;
    int player1Score = 0 ;
    int player2Score = 0 ;
    ArrayList<String> boardState;

    void initalizeBoardState() {
        boardState = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            boardState.add("");
        }
        bt1.setText("");
        bt2.setText("");
        bt3.setText("");
        bt4.setText("");
        bt5.setText("");
        bt6.setText("");
        bt7.setText("");
        bt8.setText("");
        bt9.setText("");
    }
    public void onPlayerClick(View view) {
        Button clickedButton = (Button) view;
        String playerSymbol = "" ;
        if (counter % 2 == 0) {
            clickedButton.setText("X");
            clickedButton.setTextColor(Color.RED);
            playerSymbol = "X" ;
            counter++ ;
        } else {
            clickedButton.setText("O");
            clickedButton.setTextColor(Color.YELLOW);
            playerSymbol = "O" ;
            counter++ ;
        }
        writePlayerSymbolInState(clickedButton.getId(), playerSymbol);
        if (checkWinner("X")) {
            player1Score++ ;
            Player1ScoreText.setText(""+player1Score);
            initalizeBoardState();
            counter = 0 ;
        }
        else if (checkWinner("O")) {
            player2Score++ ;
            Player2ScoreText.setText(""+player2Score);
            initalizeBoardState();
            counter = 0 ;
        }
        else if (counter == 9) {
            initalizeBoardState();
            counter = 0 ;
        }

    }
    void writePlayerSymbolInState(int id, String playerSymbol) {
        if (id == R.id.bt_1) {
            boardState.set(0, playerSymbol);
        } else if (id == R.id.bt_2) {
            boardState.set(1, playerSymbol);
        }
        else if (id == R.id.bt_3) {
            boardState.set(2, playerSymbol);
        }
        else if (id == R.id.bt_4) {
            boardState.set(3, playerSymbol);
        }
        else if (id == R.id.bt_5) {
            boardState.set(4, playerSymbol);
            }
        else if (id == R.id.bt_6) {
            boardState.set(5, playerSymbol);
        }
        else if (id == R.id.bt_7) {
            boardState.set(6, playerSymbol);
        }
        else if (id == R.id.bt_8) {
            boardState.set(7, playerSymbol);
            }
        else if (id == R.id.bt_9) {
            boardState.set(8, playerSymbol);
        }
    }
    boolean checkWinner(String playerCode){
        for (int i = 0; i < 3; i++) {
            if     (boardState.get(i).equals(playerCode)&&
                    boardState.get(i+3).equals(playerCode)&&
                    boardState.get(i+6).equals(playerCode)){
                return true ;
            }
        }

        if (boardState.get(0).equals(playerCode)&&
                boardState.get(4).equals(playerCode)&&
                boardState.get(8).equals(playerCode)) {
            return true;

        }
        if (boardState.get(2).equals(playerCode)&&
                boardState.get(4).equals(playerCode)&&
                boardState.get(6).equals(playerCode)) {
            return true;

        }


        return false;
    }

}