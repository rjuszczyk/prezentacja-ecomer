package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class Page5 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View title1 = view.findViewById(R.id.page5_box1);
        View title2 = view.findViewById(R.id.page5_box2);

        if (savedInstanceState == null) {
            setInvisible(
                    title1,
                    title2
                    );

            animateIn(500, inAnimator,
                    title2,
                    title1
            );
        } else {
            setVisible(
                    title1,
                    title2
            );
        }
    }
    

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page5;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page6();
    }
}
