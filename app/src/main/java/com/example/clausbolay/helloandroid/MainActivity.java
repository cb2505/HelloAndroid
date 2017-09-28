package com.example.clausbolay.helloandroid;

import android.app.Activity;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Creates a activity for the ouput of
 * the typed name and age.
 */
public class MainActivity extends Activity {

    private TextView message;
    private Button furtherFinished;
    private EditText insertName;
    private EditText insertAge;
    private boolean fristKlick;
    private TextView age;


    /**
     * Creates the GUI.
     * Includes one TextView, one Button
     * and two EditText fields.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = (TextView) findViewById(R.id.messageString);
        furtherFinished = (Button) findViewById(R.id.further_finished);
        insertName = (EditText) findViewById(R.id.insert_text);
        insertAge = (EditText) findViewById(R.id.inputDate);
        age = (EditText) findViewById(R.id.inputDate);
        fristKlick = true;
        message.setText(R.string.welcome);
        furtherFinished.setText(R.string.further);
        furtherFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fristKlick) {
                    message.setText(getString(R.string.hello) +
                            insertName.getText());
                    insertName.setVisibility(View.INVISIBLE);
                    insertAge.setVisibility(View.INVISIBLE);
                    furtherFinished.setText(R.string.finished);

                    message.setText("Hey " + insertName.getText().toString() +
                            " , your are " + getAge(Integer.parseInt(age.getText().toString())) + " old!");
                    fristKlick = false;
                } else {
                    finish();
                }
            }
        });

        insertName.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                furtherFinished.setEnabled(s.length() > 0);
            }
        });
        furtherFinished.setEnabled(false);
    }

    /**
     * Checks the button, if it is clicked or not.
     *
     * @param item
     * @return boolean
     */
    @Override // aus generierter Klasse übernommen
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Calculates the age.
     *
     * @param birthYear
     * @return age
     */
    private int getAge(int birthYear) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int result = year - birthYear;
        return result;
    }

}

