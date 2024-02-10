package com.example.summerprelab1;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(context == null || intent == null || intent.getAction() == null){
           return;
        }
        if (intent.getAction() != (Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            return;
        }

        SmsMessage[] smsMessage = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage message : smsMessage) {
            Toast.makeText(context, "Message from "+message.getDisplayOriginatingAddress() +": body" +message.getMessageBody(), Toast.LENGTH_SHORT)
                    .show();

        }
    }



}
