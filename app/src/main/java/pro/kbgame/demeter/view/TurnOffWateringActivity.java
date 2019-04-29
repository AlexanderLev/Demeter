package pro.kbgame.demeter.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.repository.StatusKeeper;

public class TurnOffWateringActivity extends AppCompatActivity {

    private Status status;

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

    @BindView(R.id.swWateringFieldOne)
    SwitchCompat swWateringFieldOne;

    @BindView(R.id.swWateringFieldTwo)
    SwitchCompat swWateringFieldTwo;

    @BindView(R.id.swWateringFieldThree)
    SwitchCompat swWateringFieldThree;

    @BindView(R.id.swWateringFieldFour)
    SwitchCompat swWateringFieldFour;

    @BindView(R.id.swWateringFieldFive)
    SwitchCompat swWateringFieldFive;

    @BindView(R.id.swWateringFieldSix)
    SwitchCompat swWateringFieldSix;

    @BindView(R.id.swFillingShowerBarrel)
    SwitchCompat swFillingShowerBarrel;

    @BindView(R.id.swFillingWateringBarrel)
    SwitchCompat swFillingWateringBarrel;

    @SuppressWarnings("unused")
    @OnClick(R.id.btTurnOffWateringAll)
    public void btTurnOffWateringAllClick() {
        checkAllSwitches(false);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btCancel)
    public void btCancelClick() {
        finish();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btSave)
    public void btSaveClick() {
        collectData();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_off_watering);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        status = StatusKeeper.getInstance(this).getCurrentStatus();
        setNames();
        setSwitchesByStatus();

    }


    private void checkAllSwitches(boolean state) {
        swWateringFieldOne.setChecked(state);
        swWateringFieldTwo.setChecked(state);
        swWateringFieldThree.setChecked(state);
        swWateringFieldFour.setChecked(state);
        swWateringFieldFive.setChecked(state);
        swWateringFieldSix.setChecked(state);
        swFillingShowerBarrel.setChecked(state);
        swFillingWateringBarrel.setChecked(state);
    }

    private void setNames() {
        tvWateringFieldOne.setText(String.valueOf(status.getWaterReceiverList().get(0).getName()));
        tvWateringFieldTwo.setText(String.valueOf(status.getWaterReceiverList().get(1).getName()));
        tvWateringFieldThree.setText(String.valueOf(status.getWaterReceiverList().get(2).getName()));
        tvWateringFieldFour.setText(String.valueOf(status.getWaterReceiverList().get(3).getName()));
        tvWateringFieldFive.setText(String.valueOf(status.getWaterReceiverList().get(4).getName()));
        tvWateringFieldSix.setText(String.valueOf(status.getWaterReceiverList().get(5).getName()));
    }

    private void setSwitchesByStatus() {
        swWateringFieldOne.setClickable(status.getWaterReceiverList().get(0).isWatering());
        swWateringFieldOne.setChecked(status.getWaterReceiverList().get(0).isWatering());
        swWateringFieldTwo.setClickable(status.getWaterReceiverList().get(1).isWatering());
        swWateringFieldTwo.setChecked(status.getWaterReceiverList().get(1).isWatering());
        swWateringFieldThree.setChecked(status.getWaterReceiverList().get(2).isWatering());
        swWateringFieldThree.setClickable(status.getWaterReceiverList().get(2).isWatering());
        swWateringFieldFour.setChecked(status.getWaterReceiverList().get(3).isWatering());
        swWateringFieldFour.setClickable(status.getWaterReceiverList().get(3).isWatering());
        swWateringFieldFive.setChecked(status.getWaterReceiverList().get(4).isWatering());
        swWateringFieldFive.setClickable(status.getWaterReceiverList().get(4).isWatering());
        swWateringFieldSix.setChecked(status.getWaterReceiverList().get(5).isWatering());
        swWateringFieldSix.setClickable(status.getWaterReceiverList().get(5).isWatering());
        swFillingShowerBarrel.setClickable(status.getBarrelList().get(0).isFilling());
        swFillingShowerBarrel.setChecked(status.getBarrelList().get(0).isFilling());
        swFillingWateringBarrel.setClickable(status.getBarrelList().get(1).isFilling());
        swFillingWateringBarrel.setChecked(status.getBarrelList().get(1).isFilling());
    }

    private void collectData() {
        status.getWaterReceiverList().get(0).setWatering(swWateringFieldOne.isChecked());
        status.getWaterReceiverList().get(1).setWatering(swWateringFieldTwo.isChecked());
        status.getWaterReceiverList().get(2).setWatering(swWateringFieldThree.isChecked());
        status.getWaterReceiverList().get(3).setWatering(swWateringFieldFour.isChecked());
        status.getWaterReceiverList().get(4).setWatering(swWateringFieldFive.isChecked());
        status.getWaterReceiverList().get(5).setWatering(swWateringFieldSix.isChecked());
        status.getBarrelList().get(0).setFilling(swFillingShowerBarrel.isChecked());
        status.getBarrelList().get(1).setFilling(swFillingWateringBarrel.isChecked());
    }
}
