package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class new_note extends AppCompatActivity {
    private Button btncreate;
    private EditText ettitle, etcontent;
    private DatabaseReference notref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);


        btncreate = (Button) findViewById(R.id.new_note_button);
        ettitle = (EditText) findViewById(R.id.new_note_title);
        etcontent = (EditText) findViewById(R.id.new_note_content);

        FirebaseDatabase database = FirebaseDatabase.getInstance(); //object from db
        notref = database.getReference("Note");//ref.
        final Calendar calendar = Calendar.getInstance();

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tit = ettitle.getText().toString().trim();
                String cont = etcontent.getText().toString().trim();
                String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format( calendar.getTime());
                if (!TextUtils.isEmpty(tit) && !TextUtils.isEmpty(cont))

                {
                    final Map<String, String> notemap = new HashMap<>();
                    notemap.put("Title", tit);
                    notemap.put("Content", cont);
                    notemap.put("Current Date",currentDate);
                    notref.push().setValue(notemap);
                    Snackbar.make(view, "Note Created", Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(new_note.this, MainActivity.class);
                    startActivity(intent);
                } else
                    Snackbar.make(view, "Empty Note !", Snackbar.LENGTH_LONG).show();
            }
        });
    }}
