package pro.kbgame.demeter.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.repository.StatusKeeper;

public class MainActivity extends AppCompatActivity {

    private Status status;

    @BindView(R.id.tvStatus)
    TextView tvStatus;

    @BindView(R.id.ibSettings)
    ImageButton ibSettings;

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
    ImageView ivWateringFieldTwo;

    @BindView(R.id.ivWateringFieldThree)
    ImageView ivWateringFieldThree;

    @BindView(R.id.ivWateringFieldFour)
    ImageView ivWateringFieldFour;

    @BindView(R.id.ivWateringFieldFive)
    ImageView ivWateringFieldFive;

    @BindView(R.id.ivWateringFieldSix)
    ImageView ivWateringFieldSix;

    @BindView(R.id.btGetStatus)
    Button btGetStatus;

    @BindView(R.id.btTurnOnWatering)
    Button btTurnOnWatering;

    @BindView(R.id.btTurnOffWatering)
    Button btTurnOffWatering;

    StatusCallBack statusCallBack;

    @SuppressWarnings("unused")
    @OnClick(R.id.ibSettings)
    public void ibSettingsClick() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btGetStatus)
    public void btGetStatusClick() {
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btTurnOnWatering)
    public void btTurnOnWateringClick() {
        Intent intent = new Intent(this, TurnOnWateringActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btTurnOffWatering)
    public void btTurnOffWateringClick() {
        Intent intent = new Intent(this, TurnOffWateringActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUi();
    }

    @Override
    public void onResume() {
        super.onResume();
        initUi();
    }


    private void initUi() {
        StatusKeeper statusKeeper = StatusKeeper.getInstance(this);
        registerCallBack(statusKeeper);
        status = statusCallBack.statusCallBack();
        tvTemperature.setText(String.valueOf(status.getTemp()));
        tvHumidity.setText(String.valueOf(status.getHumidity()));
        tvSoil.setText(String.valueOf(status.getSoil()));
        setNames();
        setDropsByStatus();
    }

    public void registerCallBack(StatusCallBack statusCallBack) {
        this.statusCallBack = statusCallBack;
    }

    private void setNames() {
        tvWateringFieldOne.setText(String.valueOf(status.getWaterReceiverList().get(0).getName()));
        tvWateringFieldTwo.setText(String.valueOf(status.getWaterReceiverList().get(1).getName()));
        tvWateringFieldThree.setText(String.valueOf(status.getWaterReceiverList().get(2).getName()));
        tvWateringFieldFour.setText(String.valueOf(status.getWaterReceiverList().get(3).getName()));
        tvWateringFieldFive.setText(String.valueOf(status.getWaterReceiverList().get(4).getName()));
        tvWateringFieldSix.setText(String.valueOf(status.getWaterReceiverList().get(5).getName()));
    }

    private void setDropsByStatus() {
        if (status.getWaterReceiverList().get(0).isWatering()) {
            ivWateringFieldOne.setVisibility(View.VISIBLE);
        } else {
            ivWateringFieldOne.setVisibility(View.INVISIBLE);
        }
        if (status.getWaterReceiverList().get(1).isWatering()) {
            ivWateringFieldTwo.setVisibility(View.VISIBLE);
        } else {
            ivWateringFieldTwo.setVisibility(View.INVISIBLE);
        }
        if (status.getWaterReceiverList().get(2).isWatering()) {
            ivWateringFieldThree.setVisibility(View.VISIBLE);
        } else {
            ivWateringFieldThree.setVisibility(View.INVISIBLE);
        }
        if (status.getWaterReceiverList().get(3).isWatering()) {
            ivWateringFieldFour.setVisibility(View.VISIBLE);
        } else {
            ivWateringFieldFour.setVisibility(View.INVISIBLE);
        }
        if (status.getWaterReceiverList().get(4).isWatering()) {
            ivWateringFieldFive.setVisibility(View.VISIBLE);
        } else {
            ivWateringFieldFive.setVisibility(View.INVISIBLE);
        }
        if (status.getWaterReceiverList().get(5).isWatering()) {
            ivWateringFieldSix.setVisibility(View.VISIBLE);
        } else {
            ivWateringFieldSix.setVisibility(View.INVISIBLE);
        }
    }

    public interface StatusCallBack {
        Status statusCallBack();
    }

}