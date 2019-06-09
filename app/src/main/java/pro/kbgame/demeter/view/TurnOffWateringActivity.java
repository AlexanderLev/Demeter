package pro.kbgame.demeter.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;
import pro.kbgame.demeter.common.CommandsTranslator;
import pro.kbgame.demeter.model.Status;
import pro.kbgame.demeter.repository.PreferencesKeeper;
import pro.kbgame.demeter.repository.StatusKeeper;

public class TurnOffWateringActivity extends AppCompatActivity {

    private Status status;
    private int REQUEST_CODE_PERMISSION_SEND_SMS = 1;

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

    @BindView(R.id.ivFillingShowerBarrel)
    ImageView ivFillingShowerBarrel;

    @BindView(R.id.ivFillingWateringBarrel)
    ImageView ivFillingWateringBarrel;

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

    @BindViews({R.id.swWateringFieldOne, R.id.swWateringFieldTwo, R.id.swWateringFieldThree, R.id.swWateringFieldFour, R.id.swWateringFieldFive, R.id.swWateringFieldSix, R.id.swFillingShowerBarrel, R.id.swFillingWateringBarrel})
    List<SwitchCompat> switchCompatList;

    @SuppressWarnings("unused")
    @OnClick(R.id.btTurnOffWateringAll)
    public void btTurnOffWateringAllClick() {
        //checkAllSwitches(true);
        for (SwitchCompat switchCompat : switchCompatList) {
            switchCompat.setChecked(true);
        }
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btCancel)
    public void btCancelClick() {
        finish();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btSave)
    public void btSaveClick() {
        checkForPermissions();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_off_watering);
        ButterKnife.bind(this);
        checkForSettingsData();
        initUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkForSettingsData();
        initUI();
    }

    private void initUI() {
        status = StatusKeeper.getInstance(this).getCurrentStatus();
        setNames();
        setBarrelImageByStatus();
        setDropsByStatus();
    }

    private void setNames() {
        tvWateringFieldOne.setText(String.valueOf(status.getWaterReceiverList().get(0).getName()));
        tvWateringFieldTwo.setText(String.valueOf(status.getWaterReceiverList().get(1).getName()));
        tvWateringFieldThree.setText(String.valueOf(status.getWaterReceiverList().get(2).getName()));
        tvWateringFieldFour.setText(String.valueOf(status.getWaterReceiverList().get(3).getName()));
        tvWateringFieldFive.setText(String.valueOf(status.getWaterReceiverList().get(4).getName()));
        tvWateringFieldSix.setText(String.valueOf(status.getWaterReceiverList().get(5).getName()));
    }

    private void setBarrelImageByStatus() {
        if (status.getBarrelList().get(0).isFull()) {
            ivFillingShowerBarrel.setImageResource(R.drawable.ic_shower_barrel_full);
        } else if (!status.getBarrelList().get(0).isFull()) {
            ivFillingShowerBarrel.setImageResource(R.drawable.ic_shower_barrel_empty);
        }
        if (status.getBarrelList().get(0).isFilling()) {
            ivFillingShowerBarrel.setImageResource(R.drawable.ic_shower_barrel_filling);
        }

        if (status.getBarrelList().get(1).isFull()) {
            ivFillingWateringBarrel.setImageResource(R.drawable.ic_watering_barrel_full);
        } else if (!status.getBarrelList().get(1).isFull()) {
            ivFillingWateringBarrel.setImageResource(R.drawable.ic_watering_barrel_empty);
        }
        if (status.getBarrelList().get(1).isFilling()) {
            ivFillingWateringBarrel.setImageResource(R.drawable.ic_watering_barrel_filling);
        }

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


    private SparseBooleanArray collectData() {
        status.getWaterReceiverList().get(0).setWatering(swWateringFieldOne.isChecked());
        status.getWaterReceiverList().get(1).setWatering(swWateringFieldTwo.isChecked());
        status.getWaterReceiverList().get(2).setWatering(swWateringFieldThree.isChecked());
        status.getWaterReceiverList().get(3).setWatering(swWateringFieldFour.isChecked());
        status.getWaterReceiverList().get(4).setWatering(swWateringFieldFive.isChecked());
        status.getWaterReceiverList().get(5).setWatering(swWateringFieldSix.isChecked());
        status.getBarrelList().get(0).setFilling(swFillingShowerBarrel.isChecked());
        status.getBarrelList().get(1).setFilling(swFillingWateringBarrel.isChecked());

        SparseBooleanArray switchesPositions = new SparseBooleanArray();
        for (int i = 0; i < switchCompatList.size(); i++) {
            switchesPositions.put(i, switchCompatList.get(i).isChecked());
        }
        return switchesPositions;
    }

    private void checkForPermissions() {
        int permissionStatus = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            executeUserCommands();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},
                    REQUEST_CODE_PERMISSION_SEND_SMS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_PERMISSION_SEND_SMS && grantResults.length == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                executeUserCommands();
            } else {
                Toast.makeText(this, R.string.all_not_enough_permissions, Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void executeUserCommands() {
        SparseBooleanArray switchesPositions = collectData();
        CommandsTranslator.getInstance(this).turnWatering(switchesPositions);
        finish();
    }

    private void checkForSettingsData() {
        if (!PreferencesKeeper.getInstance().isDataPresent()) {
            Toast.makeText(this, R.string.all_please_fill_settings_data, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
    }

}
