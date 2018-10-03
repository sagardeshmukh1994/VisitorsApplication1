package com.example.padcc.visitorsapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class registrationActivity extends AppCompatActivity {
    EditText Firstname,Lastname,Phone,Email,Technique;
    RadioButton male,female;
    RadioGroup rg;
    Button submit,cancle;
    DatabaseHandler db;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        final TextView textViewResult=(TextView)findViewById(R.id.text2);
        Firstname=(EditText) findViewById(R.id.firsname);
        Lastname=(EditText) findViewById(R.id.lastname);
        Phone=(EditText) findViewById(R.id.phone);
        Email=(EditText) findViewById(R.id.email);
        Technique=(EditText) findViewById(R.id.technique);
        male=(RadioButton) findViewById(R.id.Male);
        female=(RadioButton) findViewById(R.id.Female);

        submit=(Button) findViewById(R.id.submit1);
        cancle=(Button) findViewById(R.id.cancle1);

        db=new DatabaseHandler(registrationActivity.this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Visitor visitor = new Visitor();
                String fname,lname,phone,mail,technique;
                String gender="";


                if (male.isChecked()) {

                        gender="Male";
                }else {
                    gender="feMale";
                }


                fname =Firstname.getText().toString();
                lname =Lastname.getText().toString();
                phone =Phone.getText().toString();
                technique=Technique.getText().toString();
                mail =Email.getText().toString();
              //  gender =rb.getText().toString();


                visitor.setVfirstnName(fname);
                visitor.setVLastName(lname);
                visitor.setVPhone(phone);
                visitor.setVEmail(mail);
                visitor.setVTechnique(technique);
                visitor.setVgender(gender);
                Long result=db.insertVisitor(visitor);
                Log.i("result :",String.valueOf(result));
                Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();
            }
        });

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.item_view:

                Intent intent=new Intent(registrationActivity.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Visitors List",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
