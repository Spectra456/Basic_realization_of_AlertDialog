package com.example.spectra.labsix;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final int IDD_LIST_COLOR = 1;
    public final int IDD_LIST_COLOR1 = 2;
    public final int IDD_LIST_COLOR2 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setText("IMPLICIT");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        showDialog(IDD_LIST_COLOR);
                        break;

                }
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText("MULTIPLE");
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button2:
                        showDialog(IDD_LIST_COLOR1);
                        break;

                }
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setText("EXCLUSIVE");
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button3:
                        showDialog(IDD_LIST_COLOR2);
                        break;

                }
            }
        });



    }

    @Override
    protected android.app.Dialog onCreateDialog(int id){

        final String[] colors ={"Red","Green","Blue"};
        final boolean[] checkedColors = {false,false,false};

        final int[] choose = {1};

        switch (id){
            case IDD_LIST_COLOR:

                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("Choose color");
                builder1.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "You choose " +colors[which], Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                    }
                });

                builder1.setCancelable(true);
                return builder1.create();

            case IDD_LIST_COLOR1:

                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("Choose color");
                builder2.setMultiChoiceItems(colors,checkedColors, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,boolean isChecked) {
                        checkedColors[which] = isChecked;
                    }

                });

                builder2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder state = new StringBuilder();
                        for(int i=0; i < colors.length;i++){
                            state.append("          " + colors[i] );
                            if(checkedColors[i])
                                state.append(" selected         \n");
                            else
                                state.append(" not selected         \n");
                        }

                        Toast toast = Toast.makeText(getApplicationContext(), state.toString(), Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                });

                builder2.setCancelable(true);
                return builder2.create();

            case IDD_LIST_COLOR2:

                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle("Choose color");
                builder3.setCancelable(true);

                builder3.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        StringBuilder strNum = new StringBuilder();
                        for (int num : choose)
                        {
                            strNum.append(num);
                        }
                        int finalInt = Integer.parseInt(strNum.toString());

                        Toast toast = Toast.makeText(getApplicationContext(),"You choose " +colors[finalInt], Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);

                        toast.show();
                    }
                });

                builder3.setNeutralButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                });
                builder3.setSingleChoiceItems(colors, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        choose[0] = which;
                    }
                });

                return builder3.create();

            default:
                return null;
        }
        
        
    }
    
    

    }





