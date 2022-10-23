package com.example.bookhotel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>{
    ArrayList<datamodel> dataholder;

    public myadapter(ArrayList<datamodel> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
holder.image.setImageResource(dataholder.get(position).getImage());
      holder.book.setText(dataholder.get(position).getBook());
      holder.type.setText(dataholder.get(position).getType());
    }

    @Override
    public int getItemCount() {
       return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView book,type;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imag);
            book=itemView.findViewById(R.id.boo);
            type=itemView.findViewById(R.id.type);

        }
    }
}
