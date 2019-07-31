package com.example.afinal;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    View mview;
    TextView textTitle ,textTime;

    public NoteViewHolder(View itemview)
    {
        super(itemview);

        mview =itemview;
        textTitle=mview.findViewById(R.id.note_title);
        textTime=mview.findViewById(R.id.note_time);

    }
    public  void setnoteTitle(String title)
    {
        textTitle.setText(title);
    }
    public void setnoteTime(String time)
    {
        textTitle.setText(time);
    }

}
