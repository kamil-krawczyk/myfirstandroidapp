package ca.kamilkrawczyk.buttonclicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // These are our variables.
    private Button ourButton;
    private TextView ourMessage;
    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Displays screen GUI.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ourButton = (Button) findViewById(R.id.button);
        ourMessage = (TextView) findViewById(R.id.textView);

        // This function describes what the button does.
        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTimesClicked = numTimesClicked + 1;
                String theResult = "You pressed my button " + numTimesClicked + " time";
                // Let's give the results a bit of variety; this makes the clicking a little more entertaining.
                if (numTimesClicked != 1) {
                    theResult += "s";
                }
                if (numTimesClicked >= 20) {
                    theResult += "!";
                }
                if (numTimesClicked >= 50) {
                    theResult += "!!11";
                }
                if (numTimesClicked >= 100) {
                    theResult = "STOP CLICKING ME PLEASE!!!";
                }
                ourMessage.setText(theResult);
                }
            };

        // This applies our function to our button.
        ourButton.setOnClickListener(ourOnClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // These are our two messages to show; one for the total, one that plays after the value was reset back to zero.
            Toast toastMessage = Toast.makeText(this, "Holy cow, you've pressed the button " + numTimesClicked + " times, you're a goddamn monster!", Toast.LENGTH_LONG);
            Toast toastMessage2 = Toast.makeText(this, "Aww no! We reset it to zero.", Toast.LENGTH_SHORT);
            // Plays first message.
            toastMessage.show();
            // Resets value to zero.
            numTimesClicked = 0;
            // Then plays second message.
            toastMessage2.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
