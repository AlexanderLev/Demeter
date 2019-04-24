package pro.kbgame.demeter.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.kbgame.demeter.R;

public class CommandsActivity extends AppCompatActivity {

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

    @BindView(R.id.btStopAllWatering)
    Button btStopAllWatering;

    @BindView(R.id.btCancel)
    Button btCancel;

    @BindView(R.id.btSave)
    Button btSave;

    @SuppressWarnings("unused")
    @OnClick(R.id.btStopAllWatering)
    public void btStopAllWateringClick() {
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
        setContentView(R.layout.activity_commands);
        ButterKnife.bind(this);

    }

}
