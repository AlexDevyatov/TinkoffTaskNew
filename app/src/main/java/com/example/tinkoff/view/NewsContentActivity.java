package com.example.tinkoff.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.tinkoff.App;
import com.example.tinkoff.R;
import com.example.tinkoff.di.AppComponent;
import com.example.tinkoff.model.NewsContent;
import com.example.tinkoff.viewmodel.NewsContentViewModel;
import com.example.tinkoff.viewmodel.factory.NewsContentViewModelFactory;

public class NewsContentActivity extends AppCompatActivity {

    private TextView tvNewsContent;
    private NewsContentViewModel newsContentViewModel;
    private int newsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        newsId = getIntent().getIntExtra("newsId", 0);
        tvNewsContent = findViewById(R.id.tvNewsContent);
        createViewModel();
    }

    private void createViewModel() {
        AppComponent appComponent = ((App)getApplication()).getAppComponent();
        newsContentViewModel = ViewModelProviders.of(this, new NewsContentViewModelFactory(appComponent, newsId)).get(NewsContentViewModel.class);
        newsContentViewModel.request();
        newsContentViewModel.getData().observe(this, this::showNewsContent);
    }

    private void showNewsContent(NewsContent newsContent) {
        tvNewsContent.setMovementMethod(new ScrollingMovementMethod());
        tvNewsContent.setText(Html.fromHtml(newsContent.getPayload().getContent()));
    }
}
