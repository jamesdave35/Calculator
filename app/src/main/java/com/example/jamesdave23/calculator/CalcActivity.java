package com.example.jamesdave23.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CalcActivity extends Activity {

    public enum Operation{
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    TextView resultsText;
    String runningNumber = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentOperation;
    int result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        resultsText = (TextView) findViewById(R.id.resultText);
        resultsText.setText("");
    }

    public void resultsPressed(View view) {

        processOperation(Operation.EQUAL);
    }

    public void dividePressed(View view ){
        processOperation(Operation.DIVIDE);
    }

    public void multiplyPressed(View view){

        processOperation(Operation.MULTIPLY);
    }

    public void subtractPressed(View view){
        processOperation(Operation.SUBTRACT);
    }

    public void addPressed(View view){
        processOperation(Operation.ADD);
    }
    public void onePressed(View view){

        numberPressed(1);

    }
    public void twoPressed(View view){

        numberPressed(2);
    }
    public void threePressed(View view){

        numberPressed(3);
    }
    public void fourPressed(View view){
        numberPressed(4);

    }
    public void fivePressed(View view){
        numberPressed(5);

    }
    public void sixPressed(View view){
        numberPressed(6);

    }
    public void sevenPressed(View view){
        numberPressed(7);

    }
    public void eightPressed(View view){
        numberPressed(8);

    }
    public void ninePressed(View view){
        numberPressed(9);

    }
    public void zeroPressed(View view){
        numberPressed(0);

    }
    public void clearPressed(View view){

        rightValue = "";
        leftValue = "";
        result = 0;
        runningNumber = "";
        currentOperation = null;
        resultsText.setText("");
    }

    void processOperation(Operation operation){

        if (currentOperation != null){

            if(runningNumber != ""){

                rightValue = runningNumber;
                runningNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                }

                leftValue = String.valueOf(result);
                resultsText.setText(leftValue);
            }


        } else {

            leftValue = runningNumber;
            runningNumber = "";

        }
        currentOperation = operation;
    }

    void numberPressed(int number){

        runningNumber += String.valueOf(number);
        resultsText.setText(runningNumber);

    }


}
