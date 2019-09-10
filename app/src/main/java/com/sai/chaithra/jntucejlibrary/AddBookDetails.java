package com.sai.chaithra.jntucejlibrary;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddBookDetails extends AppCompatActivity {

    Button save,book1,book1_clear;
    Button book2,book2_clear;
    Button book3,book3_clear;
    EditText book1_name;
    EditText book2_name;
    EditText book3_name;

    PendingIntent pi,pi2,pi3;
    AlarmManager am,am2,am3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_details);
        final SharedPreferences books = PreferenceManager.getDefaultSharedPreferences(AddBookDetails.this);

        book1=findViewById(R.id.book1_reminder);
        save=findViewById(R.id.save);
        book1_clear=findViewById(R.id.book1_clear);
        book1_name = findViewById(R.id.book1_ed_text);
        book1_name.setText(books.getString("book1",""));


        book2=findViewById(R.id.book2_reminder);
        save=findViewById(R.id.save);
        book2_clear=findViewById(R.id.book2_clear);
        book2_name = findViewById(R.id.book2_ed_text);
        book2_name.setText(books.getString("book2",""));

        book3=findViewById(R.id.book3_reminder);
        save=findViewById(R.id.save);
        book3_clear=findViewById(R.id.book3_clear);
        book3_name = findViewById(R.id.book3_ed_text);
       book3_name.setText(books.getString("book3",""));



        final Intent i = new Intent(AddBookDetails.this, Alarm.class);


        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // int time = Integer.parseInt(etTime.getText().toString());
                Toast.makeText(AddBookDetails.this, "You will be Notified", Toast.LENGTH_SHORT).show();
                int time = 10;

                i.putExtra("name",book1_name.getText().toString());
                pi = PendingIntent.getBroadcast(getApplicationContext(),0,i,0);
                am = (AlarmManager)getSystemService(ALARM_SERVICE);
                SharedPreferences.Editor editor = books.edit();
                editor.putString("book1", book1_name.getText().toString());
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +15);
                String due_date = dateFormat.format(cal.getTime());
                editor.putString("book1_date", due_date);
                editor.commit();

                am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time+1000,pi);

                book1_clear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        am.cancel(pi);
                        Toast.makeText(AddBookDetails.this, "Canceled", Toast.LENGTH_SHORT).show();
                        SharedPreferences books = PreferenceManager.getDefaultSharedPreferences(AddBookDetails.this);
                        SharedPreferences.Editor editor = books.edit();
                        editor.putString("book1", "No Book");
                        editor.putString("book1_date", "");
                        editor.commit();
                        book1_name.setText("");

                    }
                });
            }
        });








        final Intent i2 = new Intent(AddBookDetails.this, Alarm.class);

        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // int time = Integer.parseInt(etTime.getText().toString());
                Toast.makeText(AddBookDetails.this, "You will be Notified", Toast.LENGTH_SHORT).show();
                int time = 10;

                i2.putExtra("name",book2_name.getText().toString());
                pi2 = PendingIntent.getBroadcast(getApplicationContext(),1,i2,0);
                am2 = (AlarmManager)getSystemService(ALARM_SERVICE);
                SharedPreferences.Editor editor = books.edit();
                editor.putString("book2", book2_name.getText().toString());
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +15);
                String due_date = dateFormat.format(cal.getTime());
                editor.putString("book2_date", due_date);
                editor.commit();

                am2.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time+1000,pi2);

                book2_clear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        am2.cancel(pi2);
                        Toast.makeText(AddBookDetails.this, "Canceled", Toast.LENGTH_SHORT).show();
                        SharedPreferences books = PreferenceManager.getDefaultSharedPreferences(AddBookDetails.this);
                        SharedPreferences.Editor editor = books.edit();
                        editor.putString("book2", "No Book");
                        editor.putString("book2_date", "");
                        editor.commit();
                        book2_name.setText("");

                    }
                });
            }
        });





        final Intent i3 = new Intent(AddBookDetails.this, Alarm.class);

        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // int time = Integer.parseInt(etTime.getText().toString());
                Toast.makeText(AddBookDetails.this, "You will be Notified", Toast.LENGTH_SHORT).show();
                int time = 10;

                i3.putExtra("name",book3_name.getText().toString());
                pi3 = PendingIntent.getBroadcast(getApplicationContext(),2,i3,0);
                am3 = (AlarmManager)getSystemService(ALARM_SERVICE);
                SharedPreferences.Editor editor = books.edit();
                editor.putString("book3", book3_name.getText().toString());
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, +15);
                String due_date = dateFormat.format(cal.getTime());
                editor.putString("book3_date", due_date);
                editor.commit();

                am3.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+time+1000,pi3);

                book3_clear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        am3.cancel(pi3);
                        Toast.makeText(AddBookDetails.this, "Canceled", Toast.LENGTH_SHORT).show();
                        SharedPreferences books = PreferenceManager.getDefaultSharedPreferences(AddBookDetails.this);
                        SharedPreferences.Editor editor = books.edit();
                        editor.putString("book3", "No Book");
                        editor.putString("book3_date", "");
                        editor.commit();
                        book3_name.setText("");

                    }
                });
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddBookDetails.this,HomeActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
       startActivity(new Intent(AddBookDetails.this,HomeActivity.class));

    }
}
