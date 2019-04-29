package pro.kbgame.demeter.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;
import pro.kbgame.demeter.model.Settings;
import pro.kbgame.demeter.repository.PreferencesKeeper;
import pro.kbgame.demeter.repository.StatusKeeper;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.etWateringFieldOne)
    EditText etWateringFieldOne;

    @BindView(R.id.etWateringFieldTwo)
    EditText etWateringFieldTwo;

    @BindView(R.id.etWateringFieldThree)
    EditText etWateringFieldThree;

    @BindView(R.id.etWateringFieldFour)
    EditText etWateringFieldFour;

    @BindView(R.id.etWateringFieldFive)
    EditText etWateringFieldFive;

    @BindView(R.id.etWateringFieldSix)
    EditText etWateringFieldSix;

    @BindView(R.id.etReceivingPhoneNumber)
    EditText etReceivingPhoneNumber;

    @BindView(R.id.cbRemindAboutWatering)
    CheckBox cbRemindAboutWatering;

    @BindView(R.id.btCancel)
    Button btCancel;

    @BindView(R.id.btSave)
    Button btSave;

    @SuppressWarnings("unused")
    @OnClick(R.id.btCancel)
    public void btCancelClick() {
        finish();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btSave)
    public void btSaveClick() {
        PreferencesKeeper.getInstance().saveSettingsToPrefs(this, collectDataToSave());
        Toast.makeText(this, R.string.all_saved, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        initUi();
    }

    private void initUi(){
        displayData(loadSettingsData());
    }

    private Settings collectDataToSave(){
        Settings settings = new Settings();
        settings.setFieldNameOne(etWateringFieldOne.getText().toString());
        settings.setFieldNameTwo(etWateringFieldTwo.getText().toString());
        settings.setFieldNameThree(etWateringFieldThree.getText().toString());
        settings.setFieldNameFour(etWateringFieldFour.getText().toString());
        settings.setFieldNameFive(etWateringFieldFive.getText().toString());
        settings.setFieldNameSix(etWateringFieldSix.getText().toString());
        settings.setReceivingPhoneNumber(String.valueOf(etReceivingPhoneNumber.getText()));
        settings.setRemindAboutWatering(cbRemindAboutWatering.isChecked());
        return settings;
    };

    private Settings loadSettingsData(){
        return PreferencesKeeper.getInstance().loadSettingsFromPrefs(this);

    }

    private void displayData(Settings settings){
        etWateringFieldOne.setText(settings.getFieldNameOne());
        etWateringFieldTwo.setText(settings.getFieldNameTwo());
        etWateringFieldThree.setText(settings.getFieldNameThree());
        etWateringFieldFour.setText(settings.getFieldNameFour());
        etWateringFieldFive.setText(settings.getFieldNameFive());
        etWateringFieldSix.setText(settings.getFieldNameSix());
        etReceivingPhoneNumber.setText(settings.getReceivingPhoneNumber());
        cbRemindAboutWatering.setChecked(settings.isRemindAboutWatering());
    }

}