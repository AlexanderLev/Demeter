package pro.kbgame.demeter.view;


import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvStatus)
    TextView tvStatus;

    @BindView(R.id.tvDateOfStatus)
    TextView tvDateOfStatus;

    @BindView(R.id.tvTemperature)
    TextView tvTemperature;

    @BindView(R.id.tvHumidity)
    TextView tvHumidity;

    @BindView(R.id.tvSoil)
    TextView tvSoil;

    @BindView(R.id.ivShowerBarrel)
    ImageView ivShowerBarrel;

    @BindView(R.id.ivWateringBarrel)
    ImageView ivWateringBarrel;

    @BindView(R.id.tvShowerBarrelStatus)
    TextView tvShowerBarrelStatus;

    @BindView(R.id.tvWateringBarrelStatus)
    TextView tvWateringBarrelStatus;

    @BindView(R.id.tvWateringFieldOne)
    TextView tvWateringFieldOne;

    @BindView(R.id.tvWateringFieldTwo)
    TextView tvWateringFieldTwo;

    @BindView(R.id.tvWateringFieldThree)
    TextView tvWateringFieldThree;

    @BindView(R.id.tvWateringFieldFour)
    TextView tvWateringFieldFour;

    @BindView(R.id.tvWateringFieldFive)
    TextView tvWateringFieldFive;

    @BindView(R.id.tvWateringFieldSix)
    TextView tvWateringFieldSix;

    @BindView(R.id.ivWateringFieldOne)
    ImageView ivWateringFieldOne;

    @BindView(R.id.ivWateringFieldTwo)
    TextView ivWateringFieldTwo;

    @BindView(R.id.ivWateringFieldThree)
    TextView ivWateringFieldThree;

    @BindView(R.id.ivWateringFieldFour)
    TextView ivWateringFieldFour;

    @BindView(R.id.ivWateringFieldFive)
    TextView ivWateringFieldFive;

    @BindView(R.id.ivWateringFieldSix)
    TextView ivWateringFieldSix;

    @BindView(R.id.btGetStatus)
    Button btGetStatus;

    @BindView(R.id.btWatering)
    Button btWatering;

    @SuppressWarnings("unused")
    @OnClick(R.id.btGetStatus)
    public void btGetStatusClick() {
        finish();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btWatering)
    public void btWateringClick() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

}