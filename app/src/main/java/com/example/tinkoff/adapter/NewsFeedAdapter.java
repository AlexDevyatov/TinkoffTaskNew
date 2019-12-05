package com.example.tinkoff.adapter;

import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinkoff.R;
import com.example.tinkoff.model.News;
import com.example.tinkoff.view.NewsContentActivity;

import java.util.Collections;
import java.util.List;

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder> {

    private List<News> newsList;

    public NewsFeedAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsFeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new NewsFeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedViewHolder holder, int position) {
        holder.bind(newsList.get(position));
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void updateNewsList(List<News> newsList) {
        this.newsList = newsList;
        Collections.sort(newsList);
        Collections.reverse(newsList);
        notifyDataSetChanged();
    }

    public static class NewsFeedViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNews;
        private News news;

        public NewsFeedViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNews = itemView.findViewById(R.id.tvNewsName);
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), NewsContentActivity.class);
                intent.putExtra("newsId", news.getId());
                itemView.getContext().startActivity(intent);
            });
        }

        public void bind(News news) {
            this.news = news;
            tvNews.setText(Html.fromHtml(news.getText()));
        }
    }
}
