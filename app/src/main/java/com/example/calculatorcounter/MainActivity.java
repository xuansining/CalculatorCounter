package com.example.calculatorcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ////////数字/////////////////

    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    //////运算符///////
    private Button Sub_btn;
    private Button Add_btn;
    private Button Mul_btn;
    private Button Div_btn;
    private Button Equ_btn;
    private Button Point_btn;
    private Button Percent_btn;
    private Button Clear_btn;
    private EditText tvResult;
    private Button Delete_btn;
    private boolean isCount = false;

    private String existedText = "";

    private boolean startWithOperator = false;

    private boolean startWithSubtract = false;

    private boolean noStartWithOperator = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initView() {
        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.btn7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);

        Add_btn = (Button) findViewById(R.id.btnAdd);
        Sub_btn = (Button) findViewById(R.id.btnSubtract);
        Mul_btn = (Button) findViewById(R.id.btnMultiply);
        Div_btn = (Button) findViewById(R.id.btnDiv);
        Equ_btn = (Button) findViewById(R.id.btnEqual);
        Point_btn = (Button) findViewById(R.id.btnPoint);
        Percent_btn = (Button) findViewById(R.id.percent_btn);
        Clear_btn = (Button) findViewById(R.id.btnClear);
        Delete_btn = (Button) findViewById(R.id.btnDelete);

        tvResult = (EditText) findViewById(R.id.tvrResult);

        existedText = tvResult.getText().toString();
    }

    private void initEvent() {
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);

        Add_btn.setOnClickListener(this);
        Sub_btn.setOnClickListener(this);
        Mul_btn.setOnClickListener(this);
        Div_btn.setOnClickListener(this);
        Equ_btn.setOnClickListener(this);
        Point_btn.setOnClickListener(this);
        Percent_btn.setOnClickListener(this);
        Clear_btn.setOnClickListener(this);
        Delete_btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num0:
                existedText = isOverRange(existedText, "0");
                break;
            case R.id.num1:
                existedText = isOverRange(existedText, "1");
                break;
            case R.id.num2:
                existedText = isOverRange(existedText, "2");
                break;
            case R.id.num3:
                existedText = isOverRange(existedText, "3");
                break;
            case R.id.num4:
                existedText = isOverRange(existedText, "4");
                break;
            case R.id.num5:
                existedText = isOverRange(existedText, "5");
                break;
            case R.id.num6:
                existedText = isOverRange(existedText, "6");
                break;
            case R.id.btn7:
                existedText = isOverRange(existedText, "7");
                break;
            case R.id.num8:
                existedText = isOverRange(existedText, "8");
                break;
            case R.id.num9:
                existedText = isOverRange(existedText, "9");
                break;
            case R.id.btnAdd:
                if (!existedText.contains("e")) {
                    if (judgeExpress()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "+";
                        }
                    } else {
                        if (isCount) {
                            isCount = false;
                        }
                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "+");
                        } else if (existedText.substring(existedText.length() - 1).equals("*")) {
                            existedText = existedText.replace("*", "+");
                        } else if (existedText.substring(existedText.length() - 1).equals("/")) {
                            existedText = existedText.replace("/", "+");
                        } else if (existedText.substring(existedText.length() - 1).equals("+")) {
                            existedText = existedText.replace("+", "+");
                        }

                    }

                } else {
                    existedText = "0";
                }
                break;
            case R.id.btnSubtract:
                if (!existedText.contains("e")) {
                    if (judgeExpress()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "-";
                        }
                    } else {
                        if (isCount) {
                            isCount = false;
                        }
                        if ((existedText.substring(existedText.length() - 1)).equals("+")) {
                            existedText = existedText.replace("+", "-");
                        } else if (existedText.substring(existedText.length() - 1).equals("*")) {
                            existedText = existedText.replace("*", "-");
                        } else if (existedText.substring(existedText.length() - 1).equals("/")) {
                            existedText = existedText.replace("/", "-");
                        } else if (existedText.substring(existedText.length() - 1).equals("+")) {
                            existedText = existedText.replace("-", "-");
                        }

                    }

                } else {
                    existedText = "0";
                }
                break;
            case R.id.btnDiv:
                if (!existedText.contains("e")) {
                    if (judgeExpress()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "/";
                        }
                    } else {
                        if (isCount) {
                        }
                        isCount = false;
                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "/");
                        } else if (existedText.substring(existedText.length() - 1).equals("*")) {
                            existedText = existedText.replace("*", "/");
                        } else if (existedText.substring(existedText.length() - 1).equals("+")) {
                            existedText = existedText.replace("+", "/");
                        } else if (existedText.substring(existedText.length() - 1).equals("/")) {
                            existedText = existedText.replace("/", "/");
                        }

                    }

                } else {
                    existedText = "0";
                }
                break;
            case R.id.btnMultiply:
                if (!existedText.contains("e")) {
                    if (judgeExpress()) {
                        existedText = getResult();
                        if (existedText.equals("error")) {

                        } else {
                            existedText += "*";
                        }
                    } else {
                        if (isCount) {
                            isCount = false;
                        }
                        if ((existedText.substring(existedText.length() - 1)).equals("-")) {
                            existedText = existedText.replace("-", "*");
                        } else if (existedText.substring(existedText.length() - 1).equals("*")) {
                            existedText = existedText.replace("*", "*");
                        } else if (existedText.substring(existedText.length() - 1).equals("/")) {
                            existedText = existedText.replace("/", "*");
                        } else if (existedText.substring(existedText.length() - 1).equals("+")) {
                            existedText = existedText.replace("+", "*");
                        }

                    }

                } else {
                    existedText = "0";
                }
                break;
            case R.id.btnPoint:
                if (!isCount) {

                    if (existedText.contains("+") || existedText.contains("-") || existedText.contains("*") || existedText.contains("/")) {
                        String param1 = null;
                        String param2 = null;
                        if (existedText.contains("+")) {
                            param1 = existedText.substring(0, existedText.indexOf("+"));
                            param2 = existedText.substring(existedText.indexOf("+") + 1);
                        } else if (existedText.contains("-")) {
                            param1 = existedText.substring(0, existedText.indexOf("-"));
                            param2 = existedText.substring(existedText.indexOf("-") + 1);
                        } else if (existedText.contains("*")) {
                            param1 = existedText.substring(0, existedText.indexOf("*"));
                            param2 = existedText.substring(existedText.indexOf("*") + 1);
                        } else if (existedText.contains("/")) {
                            param1 = existedText.substring(0, existedText.indexOf("/"));
                            param2 = existedText.substring(existedText.indexOf("/") + 1);
                        }
                        Log.d("Anonymous param1", param1);
                        Log.d("Anonymous param2", param2);
                        Boolean isContainedDot = param2.contains(".");
                        if (param2.length() >= 9) {

                        } else if (!isContainedDot) {
                            if (param2.equals("")) {
                                existedText += "0.";
                            } else {
                                existedText += ".";
                            }
                        } else {
                            return;
                        }
                    }
                    isCount = false;
                } else {
                    existedText += "0.";
                    isCount = false;
                }
                break;
            case R.id.btnDelete:
                if (existedText.equals("error")) {

                    existedText = "0";
                } else if (existedText.length() >= 0) {
                    if (existedText.length() == 1) {
                        existedText = "0";
                    } else {
                        existedText = existedText.substring(0, existedText.length() - 1);
                    }
                }
                break;
            case R.id.btnClear:
                existedText = "0";
                break;
        }

        tvResult.setText(existedText);

    }

    private String getResult() {
        String tempResult = null;
        String param1 = null;
        String param2 = null;
        double arg1 = 0;
        double arg2 = 0;
        double result = 0;
        getCondition();

        if (startWithOperator || noStartWithOperator || startWithSubtract) {
            if (existedText.contains("+")) {
                param1 = existedText.substring(0, existedText.indexOf("+"));
                param1 = existedText.substring(existedText.indexOf("+") + 1);
                if (param2.equals("")) {
                    tempResult = existedText;
                } else {
                    arg1 = Double.parseDouble(param1);
                    arg2 = Double.parseDouble(param2);
                    result = arg1 + arg2;
                    tempResult = String.format("%f", result);
                    tempResult = subZeroAndDot(tempResult);
                }

            } else if (existedText.contains("*")) {
                tempResult = existedText;
            } else {
                arg1 = Double.parseDouble(param1);
                arg2 = Double.parseDouble(param2);
                result = arg1 * arg2;
                tempResult = String.format("%f", result);
                tempResult = subZeroAndDot(tempResult);
            }
        } else if (existedText.contains("/")) {

            param1 = existedText.substring(0, existedText.indexOf("/"));
            param2 = existedText.substring(existedText.indexOf("/") + 1);
            if (param2.equals("0")) {
                tempResult = "error";
            } else if (param2.equals("")) {
                tempResult = existedText;
            } else {
                arg1 = Double.parseDouble(param1);
                arg2 = Double.parseDouble(param2);
                result = arg1 / arg2;
                tempResult = String.format("%f", result);
                tempResult = subZeroAndDot(tempResult);

            }
        } else if (existedText.contains("-")) {
            param1 = existedText.substring(0, existedText.lastIndexOf("-"));
            param2 = existedText.substring(existedText.lastIndexOf("-" + 1));
            if (param2.equals("")) {
                tempResult = existedText;
            } else {
                result = arg1 - arg2;
                tempResult = String.format("%f", result);
                tempResult = subZeroAndDot(tempResult);

            }
        }
        if (tempResult.length() >= 10) {

            tempResult = String.format("%e", Double.parseDouble(tempResult));
        } else if (tempResult.contains(".")) {
            if (tempResult.substring(0, tempResult.indexOf(".")).length() >= 10) {
                tempResult = String.format("%e", Double.parseDouble(tempResult));
            }
        }else {
           tempResult=existedText;
        }
        return tempResult;
    }






    private String isOverRange(String existedText ,String s) {
        if (!isCount){
            if (existedText.contains("e")){
                existedText="0";
            }
            if (existedText.contains("0")){
                existedText="";
            }
            if (existedText.contains("+")|| existedText.contains("-")|| existedText.contains("*")||
                    existedText.contains("/")){
                String param2=null;
                if (existedText.contains("+")){
                    param2=existedText.substring(existedText.indexOf("+")+1);
                }else if (existedText.contains("-")){
                    param2=existedText.substring(existedText.indexOf("-")+1);

                }else if (existedText.contains("*")){
                    param2=existedText.substring(existedText.indexOf("*")+1);
                }else if (existedText.contains("/")){
                    param2=existedText.substring(existedText.indexOf("/")+1);
                }
                if (existedText.substring(existedText.length()-1).equals("+")||existedText.substring(existedText.length()-1).equals("-")||
                existedText.substring(existedText.length()-1).equals("*")|| existedText.substring(existedText.length()-1).equals("/")) {

                   existedText+=s;
                }else {
                    if (param2.contains(".")){
                        if (param2.length()>=10){

                        }else{
                            existedText+=s;
                        }
                    }else {
                        if (param2.length()>=9){

                        }else {
                            existedText+=s;
                        }
                    }

                }
            }else {
                 if (existedText.contains(".")){
                     if (existedText.length()>=10){

                     }else{
                         existedText+=s;
                     }
                 }else {
                     if (existedText.length()>=9){

                     }else {
                         existedText+=s;
                     }
                 }
                 }
                 isCount=false;

            }else {
            existedText=s;
            isCount=false;
        }
         return existedText;
    }
    public static String subZeroAndDot(String s){
      if (s.indexOf(".")>0){
          s=s.replaceAll("0+?$","");
          s=s.replaceAll("[.]$","");
      }

return s;


    }
    private  boolean judgeExpress(){

        getCondition();
        String tempParam2=null;
        if (startWithSubtract||noStartWithOperator||startWithOperator){

            if (existedText.contains("+")) {

                tempParam2 = existedText.substring(existedText.indexOf("+") + 1);
                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }
            }else if (existedText.contains("*")){
                tempParam2 = existedText.substring(existedText.indexOf("*") + 1);
                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }
            }else if (existedText.contains("/")){
                tempParam2 = existedText.substring(existedText.indexOf("/") + 1);
                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }

            }else if (existedText.contains("-")){
                tempParam2 = existedText.substring(existedText.indexOf("-") + 1);
                if (tempParam2.equals("")) {
                    return false;
                } else {
                    return true;
                }
            }

            }
         return false;




        }
    private  void getCondition(){

        startWithOperator=existedText.startsWith("-")&&(existedText.contains("+")||existedText.contains("*")||existedText.contains("/"));
        startWithSubtract=existedText.startsWith("-")&&(existedText.lastIndexOf("-")!=0);
        noStartWithOperator=!existedText.startsWith("-")&&(existedText.contains("+")||
        existedText.contains("-")||existedText.contains("*")||existedText.contains("/"));
    }
}
