package com.shohagapp.eventnote.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shohagapp.eventnote.R;
import com.shohagapp.eventnote.model.Event;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.viewHolder> {

    private ArrayList<Event> myevent;

    public EventAdapter(ArrayList<Event> myevent) {
        this.myevent = myevent;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Event current = myevent.get(position);

        holder.eventtv.setText(current.getName());
        holder.detailstv.setText(current.getDetails());
    }

    @Override
    public int getItemCount() {
        if (myevent.isEmpty()){
            return 0;
        }else{
            return myevent.size();
        }
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView eventtv, detailstv;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            eventtv =itemView.findViewById(R.id.eventtvET);
            detailstv = itemView.findViewById(R.id.detailstvET);
        }
    }
}
