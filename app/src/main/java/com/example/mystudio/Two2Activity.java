package com.example.mystudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Two2Activity extends AppCompatActivity {
   public static final String EXTRA_REPLY = "Two2Activity.extra.REPLY";
   public static final String EXTRA_MESSAGE = "Two2Activity.extra.MESSAGE";
   private EditText mReply;

   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_two2);

       mReply = findViewById(R.id.editText_second);

       Intent intent = getIntent();
       String message = intent.getStringExtra(Two2Activity.EXTRA_MESSAGE);

       TextView textView = findViewById(R.id.text_message);
       textView.setText(message);
   }

   public void returnReply(View view){
      String reply = mReply.getText().toString();
      Intent replyIntent = new Intent();
      setResult(RESULT_OK, replyIntent);
      finish();
   }
}
