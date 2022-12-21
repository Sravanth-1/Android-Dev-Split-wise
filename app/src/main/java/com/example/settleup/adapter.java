package com.example.settleup;

import android.content.Context;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.MyviewHolder> {
    ArrayList<model> mList;
    Context context;

    public adapter(Context context, ArrayList<model>mList){
        this.mList = mList;
        this.context = context;
    }
    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
       model mod = mList.get(position);
       holder.name.setText(mod.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public  static  class  MyviewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public MyviewHolder(@NonNull View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.name_text);
        }
    }

}
