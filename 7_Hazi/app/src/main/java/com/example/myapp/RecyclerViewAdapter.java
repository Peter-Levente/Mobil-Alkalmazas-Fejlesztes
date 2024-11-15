package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final Context context;
    private final String[] nameArray;
    private final String[] infoArray;
    private final Integer[] imageArray;

    public RecyclerViewAdapter(Context context, String[] nameArray, String[] infoArray, Integer[] imageArray) {
        this.context = context;
        this.nameArray = nameArray;
        this.infoArray = infoArray;
        this.imageArray = imageArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(nameArray[position]);
        holder.info.setText(infoArray[position]);
        holder.image.setImageResource(imageArray[position]);

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, nameArray[position], Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return nameArray.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, info;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            info = itemView.findViewById(R.id.info);
            image = itemView.findViewById(R.id.image);
        }
    }
}
