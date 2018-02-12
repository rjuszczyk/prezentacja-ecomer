package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page6 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View mask1 = view.findViewById(R.id.mask1);
        View mask2 = view.findViewById(R.id.mask2);
        View mask3 = view.findViewById(R.id.mask3);

        View page6_item1 = view.findViewById(R.id.page6_item1);
        View page6_item2 = view.findViewById(R.id.page6_item2);
        View page6_item3 = view.findViewById(R.id.page6_item3);

        View page6_table2 = view.findViewById(R.id.page6_table2);

        if (savedInstanceState == null) {
            setInvisible(
                    page6_item1,
                    page6_item2,
                    page6_item3,
                    page6_table2
                    );

            setVisible(
                    mask1,
                    mask2,
                    mask3
            );

            animateIn(500, inAnimator,
                    page6_item1,
                    page6_item2,
                    page6_item3,
                    page6_table2
            );

            animateIn(500, outAnimator,
                    mask1,
                    mask2,
                    mask3
            );
        } else {
            setVisible(
                    page6_item1,
                    page6_item2,
                    page6_item3,
                    page6_table2
            );

            setInvisible(
                    mask1,
                    mask2,
                    mask3
            );
        }
    }



    @Override
    protected int getLayoutResourceId() {
        return R.layout.page6;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page7();
    }
}
