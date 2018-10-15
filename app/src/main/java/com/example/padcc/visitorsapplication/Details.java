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
        Visitor visitor=(Visitor)intent.getSerializableExtra("visitor");


//        String FName=intent.getStringExtra("firstname");
//        String LName=intent.getStringExtra("lastname");
//        String PHONE=intent.getStringExtra("phonenumber");
//        String EMAIL=intent.getStringExtra("emailaddress");
//        String TECH=intent.getStringExtra("techni");
//        String GENDER=intent.getStringExtra("gend");

        id2.setText(String.valueOf(visitor.getVisitorId()));
        fname2.setText(visitor.getVfirstnName());
        lname2.setText(visitor.getVLastName());
        phone2.setText(visitor.getVPhone());
        email2.setText(visitor.getVEmail());
        tech2.setText(visitor.getVTechnique());
        gender2.setText(visitor.getVgender());

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
