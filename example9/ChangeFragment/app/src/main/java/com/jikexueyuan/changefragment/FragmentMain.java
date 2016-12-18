package com.jikexueyuan.changefragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by dej on 2016/10/11.
 */
public class FragmentMain extends Fragment implements View.OnClickListener {

    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, null);

        root.findViewById(R.id.btnShowAnotherFragment).setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction()
                .setCustomAnimations(R.animator.enter, R.animator.exit, R.animator.enter, R.animator.exit)
                .addToBackStack("AnotherFragment")
                .replace(R.id.fragment, new AnotherFragment())
                .commit();
    }
}
