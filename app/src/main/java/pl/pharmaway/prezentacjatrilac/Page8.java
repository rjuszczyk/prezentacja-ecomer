package pl.pharmaway.prezentacjatrilac;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public class Page8 extends FooterFragment {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View item1 = view.findViewById(R.id.page8_box1);
        View item2 = view.findViewById(R.id.page8_box2);
        View item3 = view.findViewById(R.id.page8_box3);

        if (savedInstanceState == null) {
            setInvisible(
                    item1,
                    item2,
                    item3
            );

            animateIn(500, inAnimator,

                    item1,
                    item2,
                    item3
            );
        } else {
            setVisible(

                    item1,
                    item2,
                    item3
            );
        }
    }
    

    @Override
    protected int getLayoutResourceId() {
        return R.layout.page8;
    }

    @Override
    protected Fragment getNextFragment() {
        return new Page9();
    }
}
