package com.mk.michaelk.mytasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends Activity {


    EditText title,free;
    Spinner category;
    Button save;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        save=(Button)findViewById(R.id.btn);
        category=(Spinner)findViewById(R.id.Category);
        title=(EditText)findViewById(R.id.Title);
        free=(EditText)findViewById(R.id.FreeText);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String acategory=category.getSelectedItem().toString().trim();
                String aTitle=title.getText().toString().trim();
                String aFree=free.getText().toString().trim();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference myRef = database.getReference("All");
                String aCategory=myRef.push().getKey();
                task Task=new task(acategory,aTitle,aFree);
                myRef.child(aCategory).setValue(Task);
                open();

            }
        });

        FirebaseDatabase.getInstance().getReference().child("Task").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
             //   db.child("Task").setValue(aCa)

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
    public void open(){
        Intent intent =new Intent(this,Tasks.class);
        startActivity(intent);
    }
}
