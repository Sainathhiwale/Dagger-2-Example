package com.examen.simpledagger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examen.simpledagger.network.model.Android;
import com.examen.simpledagger.utils.AppConstants;

import java.util.List;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.MyViewHolder> {
    private Context context;
    private List<Android>list;

    public SampleAdapter(Context context, List<Android> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.android_list,viewGroup,false);
        return  new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Android android = list.get(position);
       if (android.getID()!=null){
           holder.tvId.setText(android.getID());
       }else {
           holder.tvId.setText(AppConstants.Empty);
       }if (android.getTitle()!=null){
           holder.tvTitle.setText(android.getTitle());
        }else {
           holder.tvTitle.setText(AppConstants.Empty);
        }if (android.getDueDate()!=null){
           holder.tvDate.setText(android.getDueDate());
        }else {
           holder.tvDate.setText(AppConstants.Empty);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
      TextView tvId,tvTitle,tvDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = (TextView)itemView.findViewById(R.id.tvId);
            tvTitle= (TextView)itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView)itemView.findViewById(R.id.tvDate);
        }
    }
}
