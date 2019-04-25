package pro.kbgame.demeter.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;

public class TurnOnWateringActivity extends AppCompatActivity {

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
    @OnClick(R.id.ibWateringFieldOne)
    public void ibWateringFieldOneClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {

            }
        });

    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldTwo)
    public void ibWateringFieldTwoClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {

            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldThree)
    public void ibWateringFieldThreeClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {

            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldFour)
    public void ibWateringFieldFourClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {

            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldFive)
    public void ibWateringFieldFiveClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {

            }
        });
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.ibWateringFieldSix)
    public void ibWateringFieldSixClick() {
        setTimer(new SetWateringTime() {
            @Override
            public void timeInMin(int time) {

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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_on_watering);
        ButterKnife.bind(this);
        initUi();
    }

    private void setTimer(SetWateringTime setWateringTime){
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

    interface SetWateringTime{
        void timeInMin(int time);
    }

    private void initUi(){
        allTimersEnabled(false);
        setSwitchesListeners();

    }

    private void allTimersEnabled(boolean state){
        ibWateringFieldOne.setEnabled(state);
        ibWateringFieldTwo.setEnabled(state);
        ibWateringFieldThree.setEnabled(state);
        ibWateringFieldFour.setEnabled(state);
        ibWateringFieldFive.setEnabled(state);
        ibWateringFieldSix.setEnabled(state);
    }

    private void setSwitchesListeners(){
        swWateringFieldOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ibWateringFieldOne.setEnabled(isChecked);
            }
        });
        swWateringFieldTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ibWateringFieldTwo.setEnabled(isChecked);
            }
        });
        swWateringFieldThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ibWateringFieldThree.setEnabled(isChecked);
            }
        });
        swWateringFieldFour.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ibWateringFieldFour.setEnabled(isChecked);
            }
        });
        swWateringFieldFive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ibWateringFieldFive.setEnabled(isChecked);
            }
        });
        swWateringFieldSix.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ibWateringFieldSix.setEnabled(isChecked);
            }
        });

        swFillingShowerBarrel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        swFillingWateringBarrel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

    }


}
