package com.example.padcc.visitorsapplication;

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

    List<Visitor> visitorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        listView = (ListView) findViewById(R.id.listview1);
        rg=(RadioGroup) findViewById(R.id.radioGroup);

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

                int j=rg.getCheckedRadioButtonId();
                RadioButton rb=(RadioButton)findViewById(j);

                fname =Firstname.getText().toString();
                lname =Lastname.getText().toString();
                phone =Phone.getText().toString();
                technique=Technique.getText().toString();
                mail =Email.getText().toString();
                gender =rb.getText().toString();

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

                ArrayList<Visitor> visitorsList=db.getAllVisitors();

                 textViewResult.setText("Name "+visitorsList.get(0).VfirstnName + " \nEmail " + visitorsList.get(0).VEmail + "\nGender " +visitorsList.get(0).Vgender);

                Toast.makeText(getApplicationContext(),  "Firstname"+visitorsList.get(0).VfirstnName +" \n Lastname "
                                +visitorsList.get(0).VLastName +" \nGender "+visitorsList.get(0).Vgender +" \n ",
                        Toast.LENGTH_SHORT).show();

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


                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return visitorList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.visitorslist, null);

            TextView textViewfname1 = (TextView) view.findViewById(R.id.textfname);
            TextView textViewlname1 = (TextView) view.findViewById(R.id.textlname);
            TextView textViewephone1 = (TextView) view.findViewById(R.id.textphone);
            TextView textViewemail1 = (TextView) view.findViewById(R.id.textemail);
            TextView textViewtechnique1 = (TextView) view.findViewById(R.id.texttechnique);
            TextView textViewgender1 = (TextView) view.findViewById(R.id.textgender);

            textViewfname1.setText(visitorList.get(position).getVfirstnName());
            textViewlname1.setText(visitorList.get(position).getVLastName());
            textViewephone1.setText(visitorList.get(position).getVPhone());
            textViewemail1.setText(visitorList.get(position).getVEmail());
            textViewtechnique1.setText(visitorList.get(position).getVTechnique());
            textViewgender1.setText(visitorList.get(position).getVgender());

            return view;
        }
    }
//
}
