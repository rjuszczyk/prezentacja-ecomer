package pl.pharmaway.prezentacjatrilac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import pl.pharmaway.prezentacjatrilac.mvp.LoadingPresenter;
import pl.pharmaway.prezentacjatrilac.mvp.LoadingView;
import pl.pharmaway.prezentacjatrilac.mvp.fake.FormDataRepositoryImpl;
import pl.pharmaway.prezentacjatrilac.mvp.fake.LoadingModelImpl;
import pl.pharmaway.prezentacjatrilac.mvp.fake.SendFormImpl;

public class LoadingActivity extends FooterActivity implements LoadingView{

    LoadingPresenter loadingPresenter;
    private TextView progressMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressMsg = findViewById(R.id.progressMsg);

        loadingPresenter = new LoadingPresenter(
                new LoadingModelImpl(),
                this,
                new SendFormImpl(),
                new FormDataRepositoryImpl()
        );
        loadingPresenter.start();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page0;
    }

    @Override
    protected Class<?> getNextActivity() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loadingPresenter.stop();
    }

    @Override
    public void showLoading(String message) {
        progressMsg.setText(message);
    }

    @Override
    public void goToNext() {
        Intent intent = new Intent(this, Page1.class);
        startActivity(intent);
    }
}
