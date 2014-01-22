package com.example.helloworld;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView tv;
	private EditText et;
	private String texto;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.i("Create", "onCreate");
        
        tv = (TextView)findViewById(R.id.textView1);
        et = (EditText)findViewById(R.id.editText1);
        
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        
        this.texto = prefs.getString("texto", "");
        if(!this.texto.equals("")){
        	this.tv.setText(this.texto);
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void botaoClicado(View v){
    	
    	this.texto = et.getText().toString();
    	tv.setText(this.texto);
    	
    	Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
    	
    	Log.i("Botão", "Botão funfou!");
    	/*if(tv.getText().equals("Clique!")){
    		tv.setText("Olá Mundo!");
    	}else{
    		tv.setText("Clique!");
    	}*/
    	
    }

    
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	
    	SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    	
    	Editor editor = prefs.edit();
    	editor.putString("texto", this.texto);
    	editor.commit();
    }
}
