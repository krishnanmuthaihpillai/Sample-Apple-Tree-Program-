package com.techdew.appletree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText user_text;
    TextView enter_text, gate_1, gate_2, gate_3;
    Button proceed;
    int current_value;
    int gatekeeper_value;
    int remaining_value;
    boolean gate1_boolean, gate2_boolean, gate3_boolean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        user_text = (EditText) findViewById(R.id.user_edit_text);
        enter_text = (TextView) findViewById(R.id.enter_number_of_apple);
        gate_1 = (TextView) findViewById(R.id.gate1);
        gate_2 = (TextView) findViewById(R.id.gate2);
        gate_3 = (TextView) findViewById(R.id.gate3);
        proceed = (Button) findViewById(R.id.proceed_button);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_value=0;
                gatekeeper_value=0;
                remaining_value=0;
                gate_1.setText("");
                gate_2.setText("");
                gate_3.setText("");
                String usr_str = user_text.getText().toString();
                if (usr_str.length() > 0) {
                    current_value = Integer.parseInt(usr_str);
                    // check for gate 1
                     gate1_boolean = getstatus(current_value);
                    if(gate1_boolean){
                        String gatestr1="\n" +"*****GATE #3*********\n" +"Successfully passed Gate Keeper ### 3 "+"\n Apple Given to the Gate Keeper 3 is :"+gatekeeper_value+"\n And The Remaining Apples in Hand  :"+remaining_value;
                        gate_1.setText(""+gatestr1);
                        // check for gate 2
                         gate2_boolean = getstatus(current_value);

                        if(gate2_boolean){
                            String gatestr2="\n" +
                                    " *****GATE #2*********\n" + " Successfully passed Gate Keeper ### 2 "+"\n Apple Given to the Gate Keeper 3 is :"+gatekeeper_value+"\n And The Remaining Apples in Hand :"+remaining_value;
                            gate_2.setText(""+gatestr2);
                            // check for gate 3
                            gate3_boolean = getstatus(current_value);
                            if(gate3_boolean){
                                String gatestr3="\n" +
                                        " *****GATE #1*********\n" +
                                        " Successfully passed Gate Keeper ### 1 "+"\n Apple Given to the Gate Keeper 3 is :"+gatekeeper_value+"\n And The Remaining Apples in Hand :" + remaining_value;
                                gate_3.setText(""+gatestr3);
                            }else {
                                // Gate 1 fails
                                String Str="Gate 1 Failed"+"\n"+"Please Try with another number ";
                                gate_3.setText(""+Str);
                            }
                        }else {
                            // Gate 2 Faliure
                            String Str="Gate 2 Failed"+"\n"+"Please Try with another number ";
                            gate_2.setText(""+Str);
                        }
                    }else {
                        // failed on Gate 3
                        String Str="Gate 3 Failed"+"\n"+"Please Try with another number ";
                        gate_1.setText(""+Str);
                    }
                }

            }


        });
    }

    private boolean getstatus(int value) {
        boolean return_value=false;
        if (value % 2 == 0) {
             gatekeeper_value = (value / 2) + 1;
             remaining_value = (value / 2) - 1;
            current_value=remaining_value;
            if(current_value!=0){
                return_value=true;
            }
        }
        return return_value;
    }
}
