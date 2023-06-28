package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        Button one,two,three,four,five,six,seven,eight,nine,zero;
        Button additionn,multiply,minus,dividee,clear,point,equal;
        EditText resultt;
        @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=(Button) findViewById(R.id.one);
        one.setOnClickListener(this);

        two=(Button) findViewById(R.id.two);
        two.setOnClickListener(this);

        three=(Button) findViewById(R.id.three);
        three.setOnClickListener(this);

        four=(Button) findViewById(R.id.four);
        four.setOnClickListener(this);

        five=(Button) findViewById(R.id.five);
        five.setOnClickListener(this);

        six=(Button) findViewById(R.id.six);
        six.setOnClickListener(this);

        seven=(Button) findViewById(R.id.seven);
        seven.setOnClickListener(this);

        eight=(Button) findViewById(R.id.eight);
        eight.setOnClickListener(this);

        nine=(Button) findViewById(R.id.nine);
        nine.setOnClickListener(this);

        zero=(Button) findViewById(R.id.zero);
        zero.setOnClickListener(this);

        dividee=(Button) findViewById(R.id.dividee);
        dividee.setOnClickListener(this);

        multiply=(Button) findViewById(R.id.multiply);
        multiply.setOnClickListener(this);

        minus=(Button) findViewById(R.id.minus);
        minus.setOnClickListener(this);

        additionn=(Button) findViewById(R.id.additionn);
        additionn.setOnClickListener(this);

        point=(Button) findViewById(R.id.point);
        point.setOnClickListener(this);

        equal=(Button) findViewById(R.id.equal);
        equal.setOnClickListener(this);

        clear=(Button) findViewById(R.id.clear);
        clear.setOnClickListener(this);

        resultt=(EditText) findViewById(R.id.resultt);
        resultt.setText("");
        }

    @Override
    public void onClick(View v) {
        if (v.equals(one))
            resultt.append("1");
        if (v.equals(two))
            resultt.append("2");
        if (v.equals(three))
            resultt.append("3");
        if (v.equals(four))
            resultt.append("4");
        if (v.equals(five))
            resultt.append("5");
        if (v.equals(six))
            resultt.append("6");
        if (v.equals(seven))
            resultt.append("7");
        if (v.equals(eight))
            resultt.append("8");
        if (v.equals(nine))
            resultt.append("9");
        if (v.equals(zero))
            resultt.append("0");
        if (v.equals(additionn))
            resultt.append("+");
        if (v.equals(minus))
            resultt.append("-");
        if (v.equals(multiply))
            resultt.append("*");
        if (v.equals(dividee))
            resultt.append("/");
        if (v.equals(point))
            resultt.append(".");
        if (v.equals(clear))
            resultt.setText("");
        if (v.equals(equal))
        {
            try{
                String data=resultt.getText().toString();
                if (data.contains("/")){
                    divide(data);
                }else if (data.contains("*")){
                    multiplication(data);
                }else if (data.contains("+")){
                    addition(data);
                }else if (data.contains("-")){
                    substraction(data);
                }
            }catch (Exception e){
                displayInvalidMessage("invalid operator");
            }
        }
    }
    private void displayInvalidMessage(String invalid_operator){

    }
    private void addition(String data) {
            String[] operands=data.split(Pattern.quote("+"));
            if(operands.length==2){
                double operand1=Double.parseDouble(operands[0]);
                double operand2=Double.parseDouble(operands[1]);
                double result=operand1+operand2;
                resultt.setText(String.valueOf(result));
            }else{
                displayInvalidMessage("Invalid input");
            }
    }
    private void divide(String data) {
        String[] operands=data.split(Pattern.quote("/"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1/operand2;
            resultt.setText(String.valueOf(result));

        }else{
            displayInvalidMessage("Invalid input");
        }
    }
    private void substraction(String data) {
        String[] operands=data.split(Pattern.quote("-"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1-operand2;
            resultt.setText(String.valueOf(result));
        }else{
            displayInvalidMessage("Invalid input");
        }
    }
    private void multiplication(String data) {
        String[] operands=data.split(Pattern.quote("*"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1*operand2;
            resultt.setText(String.valueOf(result));
        }else{
            displayInvalidMessage("Invalid input");
        }
    }
}

