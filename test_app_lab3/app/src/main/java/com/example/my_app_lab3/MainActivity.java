package com.example.my_app_lab3;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        but1 = findViewById(R.id.button);
        but2 = findViewById(R.id.button2);
        but3 = findViewById(R.id.button3);
        but4 = findViewById(R.id.button4);

    }
    public void firstToast(View view) {
        Toast testToast = Toast.makeText(getApplicationContext(),"Button 1 pressed",Toast.LENGTH_SHORT);
        testToast.show();
    }

    public void topToast(View view) {
        Toast topToast = Toast.makeText(getApplicationContext(),"Button 2 pressed", Toast.LENGTH_LONG);
        topToast.setGravity(Gravity.TOP,0,0);
        topToast.show();

    }
    public void yesOrNo(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Your buttons red now?")
                .setNegativeButton("No >:(", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast dialogToast = Toast.makeText(getApplicationContext(),"Window closed", Toast.LENGTH_SHORT);
                        dialogToast.show();
                    }
                })
                .setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast dialogToast = Toast.makeText(getApplicationContext(),"red. Yay", Toast.LENGTH_SHORT);
                        dialogToast.show();
                        but1.setTextColor(Color.RED);
                        but2.setTextColor(Color.RED);
                        but3.setTextColor(Color.RED);
                        but4.setTextColor(Color.RED);
                    }
                })
                .setIcon(R.drawable.test_icon);
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void crossroads(View view) {

        String[] Pers = {"\n" +
                "choice 1", "\n" +
                "choice 2", "\n" +
                "choice 3"};
        boolean[] pers = {false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("One, Two or Three?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(pers[2] && !pers[0] && !pers[1]){
                            Toast crossroadToast = Toast.makeText(getApplicationContext(),"Well done",Toast.LENGTH_LONG);
                            crossroadToast.setGravity(Gravity.CENTER,0,0);
                            crossroadToast.show();
                            dialogInterface.cancel();
                        }
                        else{
                            but1.setVisibility(View.INVISIBLE);
                            but2.setVisibility(View.INVISIBLE);
                            but3.setVisibility(View.INVISIBLE);
                            but4.setVisibility(View.INVISIBLE);
                            Toast crossroadToast = Toast.makeText(getApplicationContext(),"Unlucky",Toast.LENGTH_LONG);
                            crossroadToast.setGravity(Gravity.CENTER,0,0);
                            crossroadToast.show();
                            dialogInterface.cancel();
                        }
                    }
                })
                .setMultiChoiceItems(Pers, pers, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean e) {
                        pers[i] = e;
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }
}