package shevtsod.com.lab5;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EMAIL = "shevtsod.com.lab5.USERNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize errorMessage as not being visible
        TextView errorMessage = (TextView)findViewById(R.id.inputErrorMessage);
        errorMessage.setVisibility(View.GONE);

    }

    /**
     * Sends the user from the mainActivity to the LoggedInActivity
     * @param view the view object that was clicked
     */
    public void actionSubmit(View view) {
        //Check to see if any fiels are empty, and show an error message if so
        EditText emailET = (EditText)findViewById(R.id.email);
        String email = emailET.getText().toString();

        EditText passET = (EditText)findViewById(R.id.password);
        String password = passET.getText().toString();

        TextView errorMessage = (TextView)findViewById(R.id.inputErrorMessage);

        if(email.isEmpty() || password.isEmpty()) {
            errorMessage.setVisibility(View.VISIBLE);
            //Do not send user to next activity if any fields are empty
            return;
        } else {
            errorMessage.setVisibility(View.GONE);
        }


        //Send user to the next activity (LoggedInActivity)
        Intent intent = new Intent(this, LoggedInActivity.class);
        intent.putExtra(EMAIL, email);
        startActivity(intent);
    }
}
