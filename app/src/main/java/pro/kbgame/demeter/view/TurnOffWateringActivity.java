package pro.kbgame.demeter.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import pro.kbgame.demeter.R;

public class TurnOffWateringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_off_watering);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI(){}
}
