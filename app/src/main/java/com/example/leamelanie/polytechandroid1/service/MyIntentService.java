package com.example.leamelanie.polytechandroid1.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.leamelanie.polytechandroid1.QuestionFormFrag;

import java.util.ArrayList;

/**
 * Created by Mel on 18/10/2017.
 */

public class MyIntentService extends IntentService {

    public static final String TASK = "task";
    public static final String QUESTION = "question";

    public String nextQuestion = "De quel animal est-ce le cri ?";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String myTask = intent.getStringExtra(TASK);

            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction(QuestionFormFrag.MyReceiver.ACTION_RESP);
            broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
            broadcastIntent.putExtra(QUESTION, nextQuestion);
            sendBroadcast(broadcastIntent);

    }
}
