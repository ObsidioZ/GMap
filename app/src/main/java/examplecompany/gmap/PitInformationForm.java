package examplecompany.gmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import examplecompany.gmap.R;


public class PitInformationForm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pit_information_form);

    }
    public void SavePitInformation(View button) {

        EditText PitID = (EditText) findViewById(R.id.EnterPitID);
        PitID.setText("Field Updated");

        Spinner TypeOfPit = (Spinner) findViewById(R.id.PitTypeChoices);
        PitID.setText(TypeOfPit.getSelectedItem().toString());
        this.finish();


    }

    public void CancelPitInformation(View button) {

        this.finish();
    }
}
