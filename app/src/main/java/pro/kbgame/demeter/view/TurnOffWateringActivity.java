package pro.kbgame.demeter.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
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
        setAllWateringStatusOff();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btCancel)
    public void btCancelClick() {
        finish();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btSave)
    public void btSaveClick() {
        StatusKeeper.getInstance(this).setCurrentStatus(status);
        finish();
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldOne)
    public void setSwWateringFieldOneChanged(boolean changed) {
        status.getWaterReceiverList().get(0).setWatering(!changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldTwo)
    public void setSwWateringFieldTwoChanged(SwitchCompat swWateringFieldTwo, boolean changed) {
        status.getWaterReceiverList().get(1).setWatering(!changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldThree)
    public void setSwWateringFieldThreeChanged(SwitchCompat swWateringFieldThree, boolean changed) {
        status.getWaterReceiverList().get(2).setWatering(!changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldFour)
    public void setSwWateringFieldFourChanged(SwitchCompat swWateringFieldFour, boolean changed) {
        status.getWaterReceiverList().get(3).setWatering(!changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldFive)
    public void setSwWateringFieldFiveChanged(SwitchCompat swWateringFieldFive, boolean changed) {
        status.getWaterReceiverList().get(4).setWatering(!changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldSix)
    public void setSwWateringFieldSixChanged(SwitchCompat swWateringFieldSix, boolean changed) {
        status.getWaterReceiverList().get(5).setWatering(!changed);
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

    private void setSwitchesByStatus(){
        swWateringFieldOne.setChecked(status.getWaterReceiverList().get(0).isWatering());
        swWateringFieldTwo.setChecked(status.getWaterReceiverList().get(1).isWatering());
        swWateringFieldThree.setChecked(status.getWaterReceiverList().get(2).isWatering());
        swWateringFieldFour.setChecked(status.getWaterReceiverList().get(3).isWatering());
        swWateringFieldFive.setChecked(status.getWaterReceiverList().get(4).isWatering());
        swWateringFieldSix.setChecked(status.getWaterReceiverList().get(5).isWatering());
    }

    private void setAllWateringStatusOff(){
        for(int i = 0; i < status.getWaterReceiverList().size(); i++){
            status.getWaterReceiverList().get(i).setWatering(false);
        }
        for(int i = 0; i < status.getBarrelList().size(); i++){
            status.getBarrelList().get(i).setFilling(false);
        }
    }


}
