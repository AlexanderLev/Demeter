package pro.kbgame.demeter.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import pro.kbgame.demeter.R;
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

    @BindView(R.id.ivFillingShowerBarrel)
    ImageView ivFillingShowerBarrel;

    @BindView(R.id.ivFillingWateringBarrel)
    ImageView ivFillingWateringBarrel;

    @BindView(R.id.swFillingShowerBarrel)
    SwitchCompat swFillingShowerBarrel;

    @BindView(R.id.swFillingWateringBarrel)
    SwitchCompat swFillingWateringBarrel;

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
                status.getWaterReceiverList().get(0).setTimeInMin(time);
            }
        });

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldTwo)
    public void ibWateringFieldTwoClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                status.getWaterReceiverList().get(1).setTimeInMin(time);
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldThree)
    public void ibWateringFieldThreeClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                status.getWaterReceiverList().get(3).setTimeInMin(time);
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldFour)
    public void ibWateringFieldFourClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                status.getWaterReceiverList().get(4).setTimeInMin(time);
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldFive)
    public void ibWateringFieldFiveClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                status.getWaterReceiverList().get(5).setTimeInMin(time);
            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldSix)
    public void ibWateringFieldSixClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {
                status.getWaterReceiverList().get(6).setTimeInMin(time);
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
        collectData();
        finish();
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

    private void setSwitchesByStatus() {
        swWateringFieldOne.setChecked(status.getWaterReceiverList().get(0).isWatering());
        swWateringFieldTwo.setChecked(status.getWaterReceiverList().get(1).isWatering());
        swWateringFieldThree.setChecked(status.getWaterReceiverList().get(2).isWatering());
        swWateringFieldFour.setChecked(status.getWaterReceiverList().get(3).isWatering());
        swWateringFieldFive.setChecked(status.getWaterReceiverList().get(4).isWatering());
        swWateringFieldSix.setChecked(status.getWaterReceiverList().get(5).isWatering());

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
        status.getWaterReceiverList().get(1).setWatering(swWateringFieldTwo.isChecked());
        status.getWaterReceiverList().get(2).setWatering(swWateringFieldThree.isChecked());
        status.getWaterReceiverList().get(3).setWatering(swWateringFieldFour.isChecked());
        status.getWaterReceiverList().get(4).setWatering(swWateringFieldFive.isChecked());
        status.getWaterReceiverList().get(5).setWatering(swWateringFieldSix.isChecked());
        status.getBarrelList().get(0).setFilling(swFillingShowerBarrel.isChecked());
        status.getBarrelList().get(1).setFilling(swFillingWateringBarrel.isChecked());
    }

}
