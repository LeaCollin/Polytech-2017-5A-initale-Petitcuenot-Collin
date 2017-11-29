package com.example.leamelanie.polytechandroid1;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.leamelanie.polytechandroid1.service.MyIntentService;

/**
 * Created by Mel on 11/10/2017.
 */

public class QuestionFormFrag extends Fragment {

    private MyReceiver receiver;
    int score = 5;
    int vies = 7;
    public Button butAnswer1 = null;
    public Button butAnswer2 = null;
    public Button butAnswer3 = null;
    public Button butAnswer4 = null;

    public class MyReceiver extends BroadcastReceiver {

        public static final String ACTION_RESP = "actionResp";


        @Override
        public void onReceive(Context context, Intent intent) {
            String myQuestion = intent.getStringExtra(MyIntentService.QUESTION);
            if (!(myQuestion == null)) {
                TextView textViewQuestion = getActivity().findViewById(R.id.question);
                textViewQuestion.setText(myQuestion);
            }

            String answers1 = intent.getStringExtra(MyIntentService.ANSWERS);
            if (!(answers1 == null)) {
                TextView textViewmyAnswer1= getActivity().findViewById(R.id.button1);
                textViewmyAnswer1.setText(myQuestion);
            }

            String answers2 = intent.getStringExtra(MyIntentService.ANSWERS);
            if (!(answers2 == null)) {
                TextView textViewmyAnswer2 = getActivity().findViewById(R.id.button2);
                textViewmyAnswer2.setText(myQuestion);
            }

            String answers3 = intent.getStringExtra(MyIntentService.ANSWERS);
            if (!(answers3 == null)) {
                TextView textViewmyAnswer3 = getActivity().findViewById(R.id.button3);
                textViewmyAnswer3.setText(myQuestion);
            }

            String answers4 = intent.getStringExtra(MyIntentService.ANSWERS);
            if (!(answers4 == null)) {
                TextView textViewmyAnswer4 = getActivity().findViewById(R.id.button4);
                textViewmyAnswer4.setText(myQuestion);
            }

            Boolean myAnswer = intent.getBooleanExtra(MyIntentService.ANSWER, false);
            TextView textViewScore = getActivity().findViewById(R.id.scorePlayer);
            TextView textViewVies = getActivity().findViewById(R.id.nbVies);
            if (myAnswer){
                score ++;
                textViewScore.setText(""+score);

                AlertDialog ad = new AlertDialog.Builder(getActivity()).create();
                ad.setCancelable(false);
                ad.setMessage(getActivity().getString(R.string.winner));
                ad.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                ad.show();
            }
            else{
                score--;
                vies--;
                textViewScore.setText(""+score);
                textViewVies.setText(""+vies);

                if (vies == 0) {
                    AlertDialog ad = new AlertDialog.Builder(getActivity()).create();
                    ad.setCancelable(false);
                    ad.setMessage(getActivity().getString(R.string.loser));
                    ad.setButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    ad.show();
                }

            }


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.frag_question_form, container, false);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView textViewMonScore = getActivity().findViewById(R.id.scorePlayer);
        TextView textViewMesVies = getActivity().findViewById(R.id.nbVies);
        textViewMonScore.setText(String.valueOf(score));
        textViewMesVies.setText(String.valueOf(vies));
        butAnswer1 = getActivity().findViewById(R.id.button1);
        butAnswer2 = getActivity().findViewById(R.id.button2);
        butAnswer3 = getActivity().findViewById(R.id.button3);
        butAnswer4 = getActivity().findViewById(R.id.button4);

        receiver = new MyReceiver();

        Intent myIntent = new Intent(getActivity(), MyIntentService.class);
        myIntent.putExtra(MyIntentService.TASK, "questionA");
        getActivity().startService(myIntent);

        myIntent.putExtra(MyIntentService.TASK, "answer1");
        getActivity().startService(myIntent);
        myIntent.putExtra(MyIntentService.TASK, "answer2");
        getActivity().startService(myIntent);
        myIntent.putExtra(MyIntentService.TASK, "answer3");
        getActivity().startService(myIntent);
        myIntent.putExtra(MyIntentService.TASK, "answer4");
        getActivity().startService(myIntent);

        Button.OnClickListener answerListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MyIntentService.class);

                switch (v.getId()){
                    case R.id.button1:
                        getActivity().findViewById(R.id.button1).setClickable(false);
                        myIntent.putExtra(MyIntentService.TASK, butAnswer1.getText());
                        getActivity().startService(myIntent);
                        break;
                    case R.id.button2:
                        getActivity().findViewById(R.id.button2).setClickable(false);
                        myIntent.putExtra(MyIntentService.TASK, butAnswer2.getText());
                        getActivity().startService(myIntent);
                        break;
                    case R.id.button3:
                        getActivity().findViewById(R.id.button3).setClickable(false);
                        myIntent.putExtra(MyIntentService.TASK, butAnswer3.getText());
                        getActivity().startService(myIntent);
                        break;
                    case R.id.button4:
                        getActivity().findViewById(R.id.button4).setClickable(false);
                        myIntent.putExtra(MyIntentService.TASK, butAnswer4.getText());
                        getActivity().startService(myIntent);
                        break;

                }
            }

        };

        butAnswer1.setOnClickListener(answerListener);
        butAnswer2.setOnClickListener(answerListener);
        butAnswer3.setOnClickListener(answerListener);
        butAnswer4.setOnClickListener(answerListener);
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
