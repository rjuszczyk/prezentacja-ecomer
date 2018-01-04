package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page3 extends FooterFragment {
    float _65;
    float _150;
    Handler handler;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        handler = new Handler();
        _65 = getResources().getDisplayMetrics().density * 65;
        _150 = getResources().getDisplayMetrics().density * 150;

        View page3_tab1 = view.findViewById(R.id.page3_tab1);
        View page3_tab2 = view.findViewById(R.id.page3_tab2);
        View page3_tab3 = view.findViewById(R.id.page3_tab3);
        View page3_tab4 = view.findViewById(R.id.page3_tab4);

        View babel11 = view.findViewById(R.id.babel11);
        View babel12 = view.findViewById(R.id.babel12);
        View babel13 = view.findViewById(R.id.babel13);

        View babel21 = view.findViewById(R.id.babel21);
        View babel22 = view.findViewById(R.id.babel22);
        View babel23 = view.findViewById(R.id.babel23);

        View babel31 = view.findViewById(R.id.babel31);
        View babel32 = view.findViewById(R.id.babel32);
        View babel33 = view.findViewById(R.id.babel33);

        animateBabel(babel11, babel12, babel13);
        animateBabel(babel21, babel22, babel23);
        animateBabel(babel31, babel32, babel33);

        if (savedInstanceState == null) {
            setInvisible(
                    page3_tab1,
                    page3_tab2,
                    page3_tab3,
                    page3_tab4
            );
            animateIn(500, inAnimator,
                    page3_tab1,
                    page3_tab2,
                    page3_tab3,
                    page3_tab4
            );
        } else {
            setVisible(
                    page3_tab1,
                    page3_tab2,
                    page3_tab3,
                    page3_tab4
            );
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    private void animateBabel(View babel11, final View babel12, final View babel13) {
        babel11.setAlpha(0);
        babel12.setAlpha(0);
        babel13.setAlpha(0);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animateBabel(babel12, 0);
            }
        },1000);
        animateBabel(babel11, -_65);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animateBabel(babel13, _65);
            }
        },2000);

    }

    private void animateBabel(final View babel13, final float x) {
        babel13.setAlpha(0);
        babel13.setScaleX(0.3f);
        babel13.setScaleY(0.3f);
        babel13.setTranslationX(0);
        babel13.setTranslationY(0);

        babel13.animate().alpha(1).start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                babel13.animate().alpha(0).start();
            }
        },2000);

        babel13.animate()
                .translationX(x)
                .translationY(-_150)
                .scaleX(1)
                .scaleY(1)
                .setDuration(3000)
                .start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animateBabel(babel13, x);
            }
        }, 3000);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page3;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page4();
    }
}
