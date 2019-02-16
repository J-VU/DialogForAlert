package example.supervoo.dialogforalert;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // onclick handler for button "Alert"
    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(MainActivity.this);

        // Set alert's Title & Message
        myAlertBuilder.setTitle(R.string.alert_title_alert);
        myAlertBuilder.setMessage(R.string.alert_message_ok_cancel);

        // Adding alert options/buttons : OK
        myAlertBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), getString(R.string.toast_select_ok), Toast.LENGTH_SHORT).show();
                    }
                });
        // Adding alert options/buttons : CANCEL
        myAlertBuilder.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), getString(R.string.toast_select_cancel), Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.show();
    }

    // onClick handler for button "Date"
    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.date_picker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String yearString = Integer.toString(year);
        String monthString = Integer.toString(month + 1);   // Month String starts at 0, +1 fix
        String dayString = Integer.toString(day);
        String dateFull = (monthString + getString(R.string.date_spacer) + dayString + getString(R.string.date_spacer) + yearString);
        Toast.makeText(this, getString(R.string.date_toast_changed), Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.view_date_picked);
        textView.setText(dateFull);
    }
}
