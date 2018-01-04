package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewPropertyAnimator;

import pl.pharmaway.prezentacjatrilac.animation.AnimationOperator;
import pl.pharmaway.prezentacjatrilac.mvp.Cancelable;

public class Page4 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View title1 = view.findViewById(R.id.page4_table2);

        if (savedInstanceState == null) {
            setInvisible(
                    title1
            );

            animateIn(500, inAnimator,
                    title1
            );
        } else {
            setVisible(
                    title1
            );
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page4;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page5();
    }
}
