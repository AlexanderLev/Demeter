package pro.kbgame.demeter.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;

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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        initUi();
    }

    private void initUi(){}

}
