package com.example.mvc_netflix_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvc_netflix_1.controller.StudentController;
import com.example.mvc_netflix_1.controller.UserController;
import com.example.mvc_netflix_1.model.StudentWS;
import com.example.mvc_netflix_1.model.UserWS;
import com.example.mvc_netflix_1.model.pojo.Student;
import com.example.mvc_netflix_1.model.pojo.User;

public class MainActivity extends AppCompatActivity {
    private UserController controller;
    private MainActivity view;
    private UserWS model;
    Button btnUpdate;
    private EditText email;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CARGAR VIEW
        view = this;
        //CARGAR MODEL
        //MODEL + VIEW
        controller = new UserController(model, view);
        //CASO DE USO -> OBTENER ESTUDIANTE
        controller.newUser();
        email = (EditText) findViewById(R.id.edtEmail);
        pass = (EditText) findViewById(R.id.edtPassword);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEmail = String.valueOf(email.getText());
                String newPass = String.valueOf(pass.getText());
                controller.getUser().setEmail(newEmail);
                controller.getUser().setPassword(newPass);
                //Muestro en pantalla
                printUser(controller.getUser());
            }
        });

    }
    public void  printStudentDetails(Student student){
        Log.d("MainActivity - NAME", student.getName());
        Log.d("MainActivity - NAME", student.getSurname());

    }

    public void printUser(User user){

        email.setText(user.getEmail());

        email.setText(user.getPassword());
    }
}