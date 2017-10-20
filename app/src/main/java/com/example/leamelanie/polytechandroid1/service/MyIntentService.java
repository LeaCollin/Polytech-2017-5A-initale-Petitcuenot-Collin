package com.example.leamelanie.polytechandroid1.service;

import android.app.IntentService;
import android.content.Intent;

import com.example.leamelanie.polytechandroid1.QuestionFormFrag;


/**
 * Created by Mel on 18/10/2017.
 */

public class MyIntentService extends IntentService {

    public static final String TASK = "task";
    public static final String QUESTION = "question";
    public static final String ANSWER = "answer";

    public String nextQuestion = "De quel animal est-ce le cri ?";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String myTask = intent.getStringExtra(TASK);

        if (myTask.equals("questionA")) {
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(QUESTION, nextQuestion);
            sendBroadcast(broadcastIntent);
        }

        else if(myTask.equals("Le Chien")){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(ANSWER, true);
            sendBroadcast(broadcastIntent);
        }
        else {
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(ANSWER, false);
            sendBroadcast(broadcastIntent);
        }

    }
}
