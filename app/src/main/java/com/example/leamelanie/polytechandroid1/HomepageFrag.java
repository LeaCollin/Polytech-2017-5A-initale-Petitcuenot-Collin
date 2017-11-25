package com.example.leamelanie.polytechandroid1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mel on 11/10/2017.
 */

public class HomepageFrag extends Fragment {

    Button oneVSone;
    Button beers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_homepage, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final HomepageFrag thisFragment = this;

        oneVSone = getActivity().findViewById(R.id.OnevsIA);
        oneVSone.setOnClickListener (new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager frman = getFragmentManager();
                FragmentTransaction ftran = frman.beginTransaction();
                QuestionFormFrag ffrag = new QuestionFormFrag();
                ftran.replace(R.id.fragment, ffrag);
                ftran.commit();
            }
        });

        beers = getActivity().findViewById(R.id.beers);
        beers.setOnClickListener (new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager frman = getFragmentManager();
                FragmentTransaction ftran = frman.beginTransaction();
                BeerFrag ffrag = new BeerFrag();
                ftran.replace(R.id.fragment, ffrag);
                ftran.commit();
            }
        });

    }
}
