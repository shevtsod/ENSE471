package shevtsod.com.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        //Get the intent that started this activity
        Intent intent = getIntent();
        String email = intent.getStringExtra(MainActivity.EMAIL);

        //Output the email to this activity
        TextView textView = (TextView)findViewById(R.id.showEmail);
        textView.setText("Welcome, " + email + "!");
    }
}
