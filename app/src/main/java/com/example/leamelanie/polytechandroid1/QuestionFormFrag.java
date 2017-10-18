package com.example.leamelanie.polytechandroid1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leamelanie.polytechandroid1.service.MyIntentService;

/**
 * Created by Mel on 11/10/2017.
 */

public class QuestionFormFrag extends Fragment {

    public class MyReceiver extends BroadcastReceiver {

        public static final String ACTION_RESP = "actionResp";

        @Override
        public void onReceive(Context context, Intent intent) {
            String myQuestion = intent.getStringExtra(MyIntentService.QUESTION);
            TextView textView = getActivity().findViewById(R.id.question);
            textView.setText(myQuestion);
        }
    }

    private MyReceiver receiver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_question_form, container, false);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        receiver = new MyReceiver();

        Intent myIntent = new Intent(getActivity(), MyIntentService.class);
        myIntent.putExtra(MyIntentService.TASK, "questionA");
        getActivity().startService(myIntent);
    }

    @Override
    public void onResume() {
        super.onResume();
        // on déclare notre Broadcast Receiver
        IntentFilter filter = new IntentFilter(MyReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        getActivity().registerReceiver(receiver, filter);
    }
}
