package com.devlancetask.devlancetask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentDpter extends RecyclerView.Adapter<StudentDpter.MyViewHolder> {

    Context context;
    ArrayList<StudentModel> studentModelArrayList;

    public StudentDpter(Context context, ArrayList<StudentModel> studentModelArrayList) {
        this.context = context;
        this.studentModelArrayList = studentModelArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_user,null);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        StudentModel studentModel = studentModelArrayList.get(position);
        holder.textId.setText(studentModel.getId());
        holder.textName.setText(studentModel.getName());

    }

    @Override
    public int getItemCount() {
        return studentModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textId, textName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textId = itemView.findViewById(R.id.textViewID);
            textName = itemView.findViewById(R.id.textViewName);
        }
    }
}
