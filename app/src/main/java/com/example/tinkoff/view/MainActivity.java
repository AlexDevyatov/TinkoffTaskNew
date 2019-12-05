package com.example.tinkoff.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.tinkoff.App;
import com.example.tinkoff.R;
import com.example.tinkoff.adapter.NewsFeedAdapter;
import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.model.News;
import com.example.tinkoff.model.NewsFeed;
import com.example.tinkoff.viewmodel.NewsListViewModel;
import com.example.tinkoff.viewmodel.factory.NewsListViewModelFactory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsFeedAdapter adapter;
    private NewsListViewModel newsListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(this);
        List<News> newsList = new ArrayList<>();
        adapter = new NewsFeedAdapter(newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        createViewModel();
    }

    private void createViewModel() {
        AppComponent appComponent = ((App)getApplication()).getAppComponent();
        newsListViewModel = ViewModelProviders.of(this, new NewsListViewModelFactory(appComponent)).get(NewsListViewModel.class);
        progressBar.setVisibility(View.VISIBLE);
        newsListViewModel.request();
        newsListViewModel.getData().observe(this, this::updateNews);
    }

    private void updateNews(NewsFeed newsFeed) {
        progressBar.setVisibility(View.GONE);
        adapter.updateNewsList(newsFeed.getNewsList());
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        newsListViewModel.request();
    }
}
