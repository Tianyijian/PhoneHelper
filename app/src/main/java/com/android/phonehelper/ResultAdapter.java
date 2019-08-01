package com.android.phonehelper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder> {

    private List<ResultItem> items;
    private Context context;
    ResultAdapter(List<ResultItem> items, Context context){
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_result_layout, parent, false);
        final ResultViewHolder holder = new ResultViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        ResultItem item = items.get(position);
        final int video = item.getVideo();
        final String content = item.getContent();
        holder.resultView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ResultDetailsActivity.class);
                intent.putExtra("content", content);
                intent.putExtra("video", video);
                context.startActivity(intent);
            }
        });
        holder.image.setImageResource(item.getImage());
        holder.content.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ResultViewHolder extends RecyclerView.ViewHolder{
        private TextView content;
        private ImageView image;
        View resultView;
        ResultViewHolder(@NonNull View itemView) {
            super(itemView);
            resultView = itemView;
            content = resultView.findViewById(R.id.search_result_text);
            image = resultView.findViewById(R.id.search_result_image);
            image.setAdjustViewBounds(false);
        }
    }
}
