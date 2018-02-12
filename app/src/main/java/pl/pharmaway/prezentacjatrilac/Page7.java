package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page7 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View item1 = view.findViewById(R.id.page7_1);
        View item2 = view.findViewById(R.id.page7_2);
        View item3 = view.findViewById(R.id.page7_3);
        View item4 = view.findViewById(R.id.page7_4);
        View item5 = view.findViewById(R.id.page7_5);
        View item6 = view.findViewById(R.id.page7_6);
        View item8 = view.findViewById(R.id.page7_8);
        View item9 = view.findViewById(R.id.page7_9);
        View item10 = view.findViewById(R.id.page7_10);
        View item11 = view.findViewById(R.id.page7_11);

        if (savedInstanceState == null) {
            setInvisible(
                    item1,
                    item2,
                    item3,
                    item4,
                    item5,
                    item6,
                    item8,
                    item9,
                    item10,
                    item11
            );

            animateIn(500, inAnimator,

                    item1,
                    item2,
                    item3,
                    item4,
                    item5,
                    item6,
                    item8,
                    item9,
                    item10,
                    item11
            );
        } else {
            setVisible(

                    item1,
                    item2,
                    item3,
                    item4,
                    item5,
                    item6,
                    item8,
                    item9,
                    item10,
                    item11
            );
        }
    }

    @Override
    public boolean isGoToSummary() {
        return false;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page7;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page8();
    }
}
