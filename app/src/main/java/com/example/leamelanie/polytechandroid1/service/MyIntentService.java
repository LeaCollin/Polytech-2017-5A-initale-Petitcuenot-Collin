package com.example.leamelanie.polytechandroid1.service;

import android.app.IntentService;
import android.content.Intent;

import com.example.leamelanie.polytechandroid1.QuestionFormFrag;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by Mel on 18/10/2017.
 */

public class MyIntentService extends IntentService {

    public static final String TASK = "task";
    public static final String QUESTION = "question";
    public static final String ANSWER = "answer";
    public static final String ANSWERS = "answers";


    public String nextQuestion = "Comment s'appelle la mascotte de Polyech Lyon ?";
    public String[] answers = {"Léo", "Lilou", "Lénonard","Lionel"};

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

        else if(myTask.equals("asnwer1")){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(ANSWERS, answers[0]);
            sendBroadcast(broadcastIntent);
        }
        else if(myTask.equals("asnwer2")){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(ANSWERS, answers[1]);
            sendBroadcast(broadcastIntent);
        }
        else if(myTask.equals("asnwer3")){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(ANSWERS, answers[2]);
            sendBroadcast(broadcastIntent);
        }
        else if(myTask.equals("asnwer4")){
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(ANSWERS, answers[3]);
            sendBroadcast(broadcastIntent);
        }

        else if(myTask.equals("Léo")){
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
