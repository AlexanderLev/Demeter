package pro.kbgame.demeter.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import pro.kbgame.demeter.R;
import pro.kbgame.demeter.common.CommandsTranslator;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.repository.StatusKeeper;

public class TurnOnWateringActivity extends AppCompatActivity {
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

    @BindView(R.id.ibWateringFieldOne)
    ImageButton ibWateringFieldOne;

    @BindView(R.id.ibWateringFieldTwo)
    ImageButton ibWateringFieldTwo;

    @BindView(R.id.ibWateringFieldThree)
    ImageButton ibWateringFieldThree;

    @BindView(R.id.ibWateringFieldFour)
    ImageButton ibWateringFieldFour;

    @BindView(R.id.ibWateringFieldFive)
    ImageButton ibWateringFieldFive;

    @BindView(R.id.ibWateringFieldSix)
    ImageButton ibWateringFieldSix;

    @BindView(R.id.tvWateringFieldOneTime)
    TextView tvWateringFieldOneTime;

    @BindView(R.id.tvWateringFieldTwoTime)
    TextView tvWateringFieldTwoTime;

    @BindView(R.id.tvWateringFieldThreeTime)
    TextView tvWateringFieldThreeTime;

    @BindView(R.id.tvWateringFieldFourTime)
    TextView tvWateringFieldFourTime;

    @BindView(R.id.tvWateringFieldFiveTime)
    TextView tvWateringFieldFiveTime;

    @BindView(R.id.tvWateringFieldSixTime)
    TextView tvWateringFieldSixTime;

    @BindView(R.id.ivFillingShowerBarrel)
    ImageView ivFillingShowerBarrel;

    @BindView(R.id.ivFillingWateringBarrel)
    ImageView ivFillingWateringBarrel;

    @BindView(R.id.swFillingShowerBarrel)
    SwitchCompat swFillingShowerBarrel;

    @BindView(R.id.swFillingWateringBarrel)
    SwitchCompat swFillingWateringBarrel;

    @BindViews({R.id.tvWateringFieldOneTime, R.id.tvWateringFieldTwoTime, R.id.tvWateringFieldThreeTime, R.id.tvWateringFieldFourTime, R.id.tvWateringFieldFiveTime, R.id.tvWateringFieldSixTime})
    List <TextView> timersTvList;

    @BindViews({R.id.swWateringFieldOne, R.id.swWateringFieldTwo, R.id.swWateringFieldThree, R.id.swWateringFieldFour, R.id.swWateringFieldFive, R.id.swWateringFieldSix})
    List<SwitchCompat> receiversSwList;


    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldOne)
    public void setSwWateringFieldOneChanged(boolean changed) {
        ibWateringFieldOne.setEnabled(changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldTwo)
    public void setSwWateringFieldTwoChanged(SwitchCompat swWateringFieldTwo, boolean changed) {
        ibWateringFieldTwo.setEnabled(changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldThree)
    public void setSwWateringFieldThreeChanged(SwitchCompat swWateringFieldThree, boolean changed) {
        ibWateringFieldThree.setEnabled(changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldFour)
    public void setSwWateringFieldFourChanged(SwitchCompat swWateringFieldFour, boolean changed) {
        ibWateringFieldFour.setEnabled(changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldFive)
    public void setSwWateringFieldFiveChanged(SwitchCompat swWateringFieldFive, boolean changed) {
        ibWateringFieldFive.setEnabled(changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swWateringFieldSix)
    public void setSwWateringFieldSixChanged(SwitchCompat swWateringFieldSix, boolean changed) {
        ibWateringFieldSix.setEnabled(changed);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swFillingShowerBarrel)
    public void setSwFillingShowerBarrelChanged(SwitchCompat swFillingShowerBarrel, boolean changed) {
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged(R.id.swFillingWateringBarrel)
    public void setSwFillingWateringBarrelChanged(SwitchCompat swFillingWateringBarrel, boolean changed) {
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldOne)
    public void ibWateringFieldOneClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                tvWateringFieldOneTime.setText(String.valueOf(time));
            }
        });

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldTwo)
    public void ibWateringFieldTwoClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                tvWateringFieldTwoTime.setText(String.valueOf(time));
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldThree)
    public void ibWateringFieldThreeClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                tvWateringFieldThreeTime.setText(String.valueOf(time));
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldFour)
    public void ibWateringFieldFourClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                tvWateringFieldFourTime.setText(String.valueOf(time));
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldFive)
    public void ibWateringFieldFiveClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                tvWateringFieldFiveTime.setText(String.valueOf(time));
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldSix)
    public void ibWateringFieldSixClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                tvWateringFieldSixTime.setText(String.valueOf(time));
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btCancel)
    public void btCancelClick() {
        finish();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btSave)
    public void btSaveClick() {
        if(isZeroTimeValuePresent()){
            Toast.makeText(this, R.string.all_set_watering_time, Toast.LENGTH_SHORT).show();
        }
        else {
            collectData();
            CommandsTranslator.getInstance(this).turnWatering();
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_on_watering);
        ButterKnife.bind(this);
        initUi();
    }

    private void setTimer(SetWateringTime setWateringTime) {
        final NumberPicker view = new NumberPicker(this);
        view.setMinValue(0);
        view.setMaxValue(99);
        view.setWrapSelectorWheel(false);
        new AlertDialog.Builder(this).setView(view).setTitle(R.string.all_setup_time_in_min).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setWateringTime.timeInMin(view.getValue());
            }
        }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }

    interface SetWateringTime {
        void timeInMin(int time);
    }

    private void initUi() {
        status = StatusKeeper.getInstance(this).getCurrentStatus();
        setNames();
        allTimersEnabled(false);
        allTimersSetZeroTime();
        setSwitchesByStatus();
        setBarrelImageByStatus();
    }

    private void setNames() {
        tvWateringFieldOne.setText(String.valueOf(status.getWaterReceiverList().get(0).getName()));
        tvWateringFieldTwo.setText(String.valueOf(status.getWaterReceiverList().get(1).getName()));
        tvWateringFieldThree.setText(String.valueOf(status.getWaterReceiverList().get(2).getName()));
        tvWateringFieldFour.setText(String.valueOf(status.getWaterReceiverList().get(3).getName()));
        tvWateringFieldFive.setText(String.valueOf(status.getWaterReceiverList().get(4).getName()));
        tvWateringFieldSix.setText(String.valueOf(status.getWaterReceiverList().get(5).getName()));
    }

    private void allTimersEnabled(boolean state) {
        ibWateringFieldOne.setEnabled(state);
        ibWateringFieldTwo.setEnabled(state);
        ibWateringFieldThree.setEnabled(state);
        ibWateringFieldFour.setEnabled(state);
        ibWateringFieldFive.setEnabled(state);
        ibWateringFieldSix.setEnabled(state);
    }

    private void allTimersSetZeroTime(){
        tvWateringFieldOneTime.setText("0");
        tvWateringFieldTwoTime.setText("0");
        tvWateringFieldThreeTime.setText("0");
        tvWateringFieldFourTime.setText("0");
        tvWateringFieldFiveTime.setText("0");
        tvWateringFieldSixTime.setText("0");
    }

    private void setSwitchesByStatus() {
        swWateringFieldOne.setChecked(status.getWaterReceiverList().get(0).isWatering());
        swWateringFieldTwo.setChecked(status.getWaterReceiverList().get(1).isWatering());
        swWateringFieldThree.setChecked(status.getWaterReceiverList().get(2).isWatering());
        swWateringFieldFour.setChecked(status.getWaterReceiverList().get(3).isWatering());
        swWateringFieldFive.setChecked(status.getWaterReceiverList().get(4).isWatering());
        swWateringFieldSix.setChecked(status.getWaterReceiverList().get(5).isWatering());
        swFillingShowerBarrel.setChecked(status.getBarrelList().get(0).isFilling());
        swFillingWateringBarrel.setChecked(status.getBarrelList().get(1).isFilling());

    }

    private void setBarrelImageByStatus() {
        if (status.getBarrelList().get(0).isFull()) {
            ivFillingShowerBarrel.setImageResource(R.drawable.ic_shower_barrel_full);
        } else if (!status.getBarrelList().get(0).isFull()) {
            ivFillingShowerBarrel.setImageResource(R.drawable.ic_shower_barrel_empty);
        }
        if (status.getBarrelList().get(0).isFilling()) {
            ivFillingShowerBarrel.setImageResource(R.drawable.ic_shower_barrel__not_full);
        }

        if (status.getBarrelList().get(1).isFull()) {
            ivFillingWateringBarrel.setImageResource(R.drawable.ic_watering_barrel_full);
        } else if (!status.getBarrelList().get(1).isFull()) {
            ivFillingWateringBarrel.setImageResource(R.drawable.ic_watering_barrel_empty);
        }
        if (status.getBarrelList().get(1).isFilling()) {
            ivFillingWateringBarrel.setImageResource(R.drawable.ic_watering_barrel_not_full);
        }

    }


    private void collectData() {
        status.getWaterReceiverList().get(0).setWatering(swWateringFieldOne.isChecked());
        status.getWaterReceiverList().get(0).setTimeInMin(Integer.parseInt(tvWateringFieldOneTime.getText().toString()));
        status.getWaterReceiverList().get(1).setWatering(swWateringFieldTwo.isChecked());
        status.getWaterReceiverList().get(1).setTimeInMin(Integer.parseInt(tvWateringFieldTwoTime.getText().toString()));
        status.getWaterReceiverList().get(2).setWatering(swWateringFieldThree.isChecked());
        status.getWaterReceiverList().get(2).setTimeInMin(Integer.parseInt(tvWateringFieldThreeTime.getText().toString()));
        status.getWaterReceiverList().get(3).setWatering(swWateringFieldFour.isChecked());
        status.getWaterReceiverList().get(3).setTimeInMin(Integer.parseInt(tvWateringFieldFourTime.getText().toString()));
        status.getWaterReceiverList().get(4).setWatering(swWateringFieldFive.isChecked());
        status.getWaterReceiverList().get(4).setTimeInMin(Integer.parseInt(tvWateringFieldFiveTime.getText().toString()));
        status.getWaterReceiverList().get(5).setWatering(swWateringFieldSix.isChecked());
        status.getWaterReceiverList().get(5).setTimeInMin(Integer.parseInt(tvWateringFieldSixTime.getText().toString()));
        status.getBarrelList().get(0).setFilling(swFillingShowerBarrel.isChecked());
        status.getBarrelList().get(1).setFilling(swFillingWateringBarrel.isChecked());
    }

    private boolean isZeroTimeValuePresent(){
        for (int i = 0; i < timersTvList.size(); i++){
            int receiverTime = status.getWaterReceiverList().get(i).getTimeInMin();
            int tvTimer = Integer.parseInt(timersTvList.get(i).getText().toString());
            boolean checked = receiversSwList.get(i).isChecked();
            if(checked && receiverTime == 0 && tvTimer == 0){
                return true;
            }
        }
        return false;
    }

}
