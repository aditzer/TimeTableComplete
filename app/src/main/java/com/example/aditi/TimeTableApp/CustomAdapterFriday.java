package com.example.aditi.TimeTableApp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterFriday extends RecyclerView.Adapter<CustomAdapterFriday.MyViewHolderFriday> {

    private Context context;
    private Activity activity;
    private ArrayList Lec_id, sub, books;

    CustomAdapterFriday(Activity activity, Context context, ArrayList Lec_id, ArrayList sub, ArrayList books){
        this.activity = activity;
        this.context = context;
        this.Lec_id = Lec_id;
        this.sub = sub;
        this.books = books;
    }

    @NonNull
    @Override
    public CustomAdapterFriday.MyViewHolderFriday onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolderFriday(view);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolderFriday holder, final int position) {
        holder.Lec_id_txt.setText(String.valueOf(Lec_id.get(position)));
        holder.sub_txt.setText(String.valueOf(sub.get(position)));
        holder.books_txt.setText(String.valueOf(books.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivityFriday.class);
                intent.putExtra("id", String.valueOf(Lec_id.get(position)));
                intent.putExtra("title", String.valueOf(sub.get(position)));
                intent.putExtra("author", String.valueOf(books.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Lec_id.size();
    }

    class MyViewHolderFriday extends RecyclerView.ViewHolder {

        TextView Lec_id_txt, sub_txt, books_txt;
        LinearLayout mainLayout;

        MyViewHolderFriday(@NonNull View itemView) {
            super(itemView);
            Lec_id_txt = itemView.findViewById(R.id.sun_lec_no);
            sub_txt = itemView.findViewById(R.id.sun_sub_name);
            books_txt = itemView.findViewById(R.id.sun_book_name);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}


