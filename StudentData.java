package com.devlancetask.devlancetask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentData extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    StudentDpter myAdapter;
    ArrayList<StudentModel> studentModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);

        recyclerView = findViewById(R.id.recyclerStudent);
        databaseReference = FirebaseDatabase.getInstance().getReference("Students");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        studentModelArrayList = new ArrayList<>();
        myAdapter = new StudentDpter(this,studentModelArrayList);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    StudentModel studentModel = snapshot1.getValue(StudentModel.class);
                    studentModelArrayList.add(studentModel);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}