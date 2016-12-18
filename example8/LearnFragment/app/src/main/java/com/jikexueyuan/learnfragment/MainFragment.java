package com.jikexueyuan.learnfragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        rootView.findViewById(R.id.btnStartAnotherFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.mainlayout, new AnotherFragment())
                        .commit();
            }
        });

        rootView.findViewById(R.id.btnStartSliderActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SliderActivity.class));
            }
        });

        rootView.findViewById(R.id.btnStartTabbedActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Tabs.class));
            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("Main onDestroyView");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Main onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Main onDestroy");
    }
}
