package pl.pharmaway.prezentacjatrilac;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page2 extends FooterActivity {

    FirstChoice firstChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firstChoice = new FirstChoice(getSharedPreferences("appPrefs", Context.MODE_PRIVATE));

        View sklad = findViewById(R.id.sklad);
        View skutecznosc = findViewById(R.id.skutecznosc);
        View unikatowosc = findViewById(R.id.unikatowosc);
        View pacjent = findViewById(R.id.pacjent);

        sklad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setFirstChoice("skład");
                startActivity(Page3.class);

            }
        });

        skutecznosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setFirstChoice("skuteczność");
                startActivity(Page4.class);
            }
        });

        unikatowosc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setFirstChoice("unikatowość");
                startActivity(Page6.class);
            }
        });

        pacjent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstChoice.setFirstChoice("pacjent");
                startActivity(Page7.class);
            }
        });
    }

    @Override
    protected void onNextClicked() {
        firstChoice.setFirstChoice("skład");
        super.onNextClicked();
    }

    private void startActivity(Class<? extends Fragment> activityClass) {
        ContainerActivity.start(this, activityClass);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page2;
    }

    @Override
    protected Class<?> getNextActivity() {
        return ContainerActivity.class;
    }
}
