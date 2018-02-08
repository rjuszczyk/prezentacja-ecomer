package pl.pharmaway.prezentacjatrilac;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.MediaController;

import com.sprylab.android.widget.TextureVideoView;

import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
import static android.view.View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

public class ContainerActivity extends AppCompatActivity {

    private TextureVideoView mVideoView;
    public boolean goToSummary;

    public static void start(Context context, Class<? extends Fragment> page) {
        start(context, page, false);
    }

    public static void start(Context context, Class<? extends Fragment> page, boolean goToSummary) {
        Intent intent = new Intent(context, ContainerActivity.class);
        intent.putExtra("page", page);
        intent.putExtra("goToSummary", goToSummary);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goToSummary = getIntent().getBooleanExtra("goToSummary", false);
        getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        SYSTEM_UI_FLAG_FULLSCREEN |
                        SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setContentView(R.layout.container);

        mVideoView = findViewById(R.id.video_view);

        if(savedInstanceState == null) {
            Class<? extends Fragment> fragmentClass;
            if(getIntent().hasExtra("page")) {
                fragmentClass = (Class<? extends Fragment>) getIntent().getSerializableExtra("page");
            } else {
                fragmentClass = Page3.class;
            }
            try {
                Fragment fragment = fragmentClass.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        initVideoView();
    }

    private void initVideoView() {
        mVideoView.setVideoPath(getVideoPath());
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(final MediaPlayer mp) {
                mVideoView.start();
            }
        });

        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    public String getVideoPath() {
        return "android.resource://" + getPackageName() + "/" + R.raw.movie;
    }
}
