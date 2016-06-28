package com.cse24gmail.jakir.employeemanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeListActivity extends AppCompatActivity {
    TextView tvAddEmployee;
    ListView lvEmployeeList;

    MyAdapter adapter;
    ArrayList<Employee> arrayList;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        dbHelper=new DBHelper(EmployeeListActivity.this);
        arrayList=new ArrayList<>();
        setAdapter();
        tvAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration=new Intent(EmployeeListActivity.this,RegistrationActivity.class);
                startActivity(registration);
            }
        });
    }

    private void setAdapter(){
        arrayList=dbHelper.getEmployee();
        adapter=new MyAdapter(EmployeeListActivity.this,arrayList);
        tvAddEmployee= (TextView) findViewById(R.id.tvAddNewEmployee);
        lvEmployeeList= (ListView) findViewById(R.id.lvEmployeeList);

        lvEmployeeList.setAdapter(adapter);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        setAdapter();
    }
}
