package com.example.padcc.visitorsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Details extends AppCompatActivity {
TextView id2,fname2,lname2,phone2,email2,tech2,gender2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        id2=(TextView)findViewById(R.id.Did);
        fname2=(TextView)findViewById(R.id.Dtextfname);
        lname2=(TextView)findViewById(R.id.Dtextlname);
        phone2=(TextView)findViewById(R.id.Dtextphone);
        email2=(TextView)findViewById(R.id.Dtextemail);
        tech2=(TextView)findViewById(R.id.Dtexttechnique);
        gender2=(TextView)findViewById(R.id.Dtextgender);

        Intent intent=getIntent();
        String FName=intent.getStringExtra("firstname");
        String LName=intent.getStringExtra("lastname");
        String PHONE=intent.getStringExtra("phonenumber");
        String EMAIL=intent.getStringExtra("emailaddress");
        String TECH=intent.getStringExtra("techni");
        String GENDER=intent.getStringExtra("gend");

        fname2.setText(FName);
        lname2.setText(LName);
        phone2.setText(PHONE);
        email2.setText(EMAIL);
        tech2.setText(TECH);
        gender2.setText(GENDER);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.details_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.itm_update:

            case R.id.item_detete:


        }
        return super.onOptionsItemSelected(item);
    }
}
