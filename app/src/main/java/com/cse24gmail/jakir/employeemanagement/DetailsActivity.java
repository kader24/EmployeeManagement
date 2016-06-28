package com.cse24gmail.jakir.employeemanagement;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    TextView name;
    TextView designation;
    TextView phone;
    TextView email;
    TextView address;

    ArrayList<Employee> arrayList;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        dbHelper=new DBHelper(DetailsActivity.this);
        arrayList=new ArrayList<>();

        int id=getIntent().getExtras().getInt("id");

        name = (TextView) findViewById(R.id.tvNameDetails);
        email = (TextView) findViewById(R.id.tvEmail);
        phone = (TextView) findViewById(R.id.tvPhone);
        designation = (TextView) findViewById(R.id.tvDesignation);
        address = (TextView) findViewById(R.id.tvAddress);


        arrayList=dbHelper.getEmployeeInfoById(id);

        for(int i=0;i<arrayList.size();i++){

        }
        for(Employee e:arrayList){
            String Ename=e.getName();
            String Edesignation=e.getDesignation();
            String Eaddress=e.getAddress();
            String Ephone=e.getPhone();
            String Eemail=e.getEmail();

            name.setText(Ename);
            designation.setText(Edesignation);
            email.setText(Eemail);
            phone.setText(Ephone);
            address.setText(Eaddress);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
