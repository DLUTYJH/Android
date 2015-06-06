package com.example.counter;
/**
 * android the first achievement:Counter
 * Stay hunger,Stay foolish.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{
	Button button_c;
	Button button_del;
	Button button_multi;
	Button button_divi;
	Button button_sub;
	Button button_add;
	Button button_point;
	Button button_equel;
	Button button_0;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_4;
	Button button_5;
	Button button_6;
	Button button_7;
	Button button_8;
	Button button_9;
    EditText etv;
    boolean flag=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button_c=(Button) findViewById(R.id.button_c);
		button_del=(Button) findViewById(R.id.button_del);
		button_multi=(Button) findViewById(R.id.button_multi);
		button_divi=(Button) findViewById(R.id.button_divi);
		button_sub=(Button) findViewById(R.id.button_sub);
		button_add=(Button) findViewById(R.id.button_add);
		button_point=(Button) findViewById(R.id.button_point);
		button_equel=(Button) findViewById(R.id.button_equel);
		button_1=(Button) findViewById(R.id.button_1);
		button_2=(Button) findViewById(R.id.button_2);
		button_3=(Button) findViewById(R.id.button_3);
		button_4=(Button) findViewById(R.id.button_4);
		button_5=(Button) findViewById(R.id.button_5);
		button_6=(Button) findViewById(R.id.button_6);
		button_7=(Button) findViewById(R.id.button_7);
		button_8=(Button) findViewById(R.id.button_8);
		button_9=(Button) findViewById(R.id.button_9);
		button_0=(Button) findViewById(R.id.button_0);
		etv = (EditText) findViewById(R.id.editText1);
		
		
		button_c.setOnClickListener(this);
		button_del.setOnClickListener(this);
		
		button_multi.setOnClickListener(this);
		button_divi.setOnClickListener(this);
		button_sub.setOnClickListener(this);
		button_add.setOnClickListener(this);
		
		button_equel.setOnClickListener(this);
		
		button_point.setOnClickListener(this);
		button_1.setOnClickListener(this);
		button_2.setOnClickListener(this);
		button_3.setOnClickListener(this);		
		button_4.setOnClickListener(this);
		button_5.setOnClickListener(this);
		button_6.setOnClickListener(this);
		button_7.setOnClickListener(this);
		button_8.setOnClickListener(this);
		button_9.setOnClickListener(this);
		button_0.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str = etv.getText().toString();
		switch(v.getId()){
			case R.id.button_0:
			case R.id.button_1:
			case R.id.button_2:
			case R.id.button_3:
			case R.id.button_4:
			case R.id.button_5:
			case R.id.button_6:
			case R.id.button_7:
			case R.id.button_8:
			case R.id.button_9:
			case R.id.button_point:
				if(flag){
					flag=false;
					str="";
					etv.setText("");
				}
				etv.setText(str+((Button)v).getText());
				break;
			case R.id.button_add:
			case R.id.button_sub:
			case R.id.button_multi:
			case R.id.button_divi:
				if(flag)flag=false;
				etv.setText(str+" "+((Button)v).getText()+" ");
				break;
			case R.id.button_c:
				etv.setText("");
				break;
			case R.id.button_del:
				etv.setText(str.substring(0, str.length()-1));
				break;
			case R.id.button_equel:
				calResult();
				break;
		}
	}
	private void calResult(){
		String str = etv.getText().toString();
		double result=0;
		double d1;
		double d2;
		flag=true;
		//if(str.equals("")){return;}
	    //if(!str.contains(" ")){return;}
		String s1 = str.substring(0, str.indexOf(" "));
		String op = str.substring(str.indexOf(" ")+1, str.indexOf(" ")+2);
		String s2 = str.substring(str.indexOf(" ")+3);
		if(!s1.equals(" ")&&!s2.equals(" ")){
			d1 = Double.parseDouble(s1);
			d2 = Double.parseDouble(s2);
			if(op.equals("+")){
				result = d1+d2;
			}
			else if(op.equals("-")){
				result = d1-d2;
			}
			else if(op.equals("*")){
				result = d1*d2;
			}
			else {
				if(d2==0){
					result =0;
				}
				else result = d1/d2;
			}
			if(!s1.contains(".")&&!s2.contains(".")){
				int r = (int)result;
				etv.setText(r+"");
			}else {
				etv.setText(result+"");
			}
		}
		else if(!s1.equals(" ")&&s2.equals(" ")){
			etv.setText(s1);
		}
		else if(s1.equals(" ")&&!s2.equals(" ")){
			etv.setText(s2);
		}
		else{
			etv.setText("0");
		}
	}
}
