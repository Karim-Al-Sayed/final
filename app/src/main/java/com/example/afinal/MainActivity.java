package com.example.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mnoteList;
    private GridLayoutManager gridLayoutManager;
    private DatabaseReference refdb;
    private FirebaseRecyclerAdapter<Note, NoteViewHolder> noteadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.main_new_note_btn:
                Intent intent=new Intent(MainActivity.this,new_note.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}

