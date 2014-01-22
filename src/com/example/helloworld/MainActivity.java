package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView tv;
	EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.i("Create", "onCreate");
        
        tv = (TextView)findViewById(R.id.textView1);
        et = (EditText)findViewById(R.id.editText1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onStart(){
    	Log.i("Start", "onStart");
    }
    
    @Override
    public void onResume(){
    	Log.i("Resume", "onResume");
    }
    
    public void botaoClicado(View v){
    	Toast.makeText(this, "Hello world!", Toast.LENGTH_SHORT).show();
    	
    	Log.i("Botão", "Botão funfou!");
    	
    	tv.setText(et.getText());
    	
    	/*if(tv.getText().equals("Clique!")){
    		tv.setText("Olá Mundo!");
    	}else{
    		tv.setText("Clique!");
    	}*/
    	
    }
    
}
