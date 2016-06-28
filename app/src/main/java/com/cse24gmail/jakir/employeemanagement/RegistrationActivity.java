package com.cse24gmail.jakir.employeemanagement;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    EditText etName;
    EditText etDesignation;
    EditText etEmail;
    EditText etAddress;
    EditText etPhone;

    Button btnCancel;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName= (EditText) findViewById(R.id.etName);
        etAddress= (EditText) findViewById(R.id.etAddress);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPhone= (EditText) findViewById(R.id.etPhone);
        etDesignation= (EditText) findViewById(R.id.etDesignation);

        btnCancel= (Button) findViewById(R.id.btnCancel);
        btnSave= (Button) findViewById(R.id.btnSave);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etName.getText().toString();
                String phone=etPhone.getText().toString();
                String designation=etDesignation.getText().toString();
                String email=etEmail.getText().toString();
                String address=etAddress.getText().toString();


                if(name.isEmpty() || phone.isEmpty() || designation.isEmpty() || email.isEmpty() || address.isEmpty()){
                    AlertDialog.Builder alert=new AlertDialog.Builder(RegistrationActivity.this);
                    alert.setTitle("Warning");
                    alert.setMessage("Please submit all information carefully");
                    alert.setPositiveButton("GOT IT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alert.show();
                }
                else {
                    DBHelper helper=new DBHelper(RegistrationActivity.this);
                    long insert=helper.addEmployee(name,designation,email,phone,address);

                    if(insert>=0){
                        Log.d("RegistrationActivity","Insert successfull");
                    }
                    finish();
                }
            }
        });
    }
}
