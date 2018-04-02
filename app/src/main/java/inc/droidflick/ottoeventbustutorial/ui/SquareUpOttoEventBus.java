package inc.droidflick.ottoeventbustutorial.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import inc.droidflick.ottoeventbustutorial.R;
import inc.droidflick.ottoeventbustutorial.event.EventBusOtto;
import inc.droidflick.ottoeventbustutorial.model.Events;
import inc.droidflick.ottoeventbustutorial.ui.BaseActivity;


public class SquareUpOttoEventBus extends BaseActivity implements View.OnClickListener {


    @Override
    int getLayoutId() {
        return R.layout.activity_second;
    }


    TextView message;
    Button addTrigger, nextActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    void init() {
        message = findViewById(R.id.hello);
        addTrigger = findViewById(R.id.addTrigger);

        nextActivity = findViewById(R.id.nextActivity);
    }

    @Override
    void initUiListeners() {
        addTrigger.setOnClickListener(this);
        nextActivity.setOnClickListener(this);
    }

    @Subscribe
    public void getMessage(Events event) {

        if (event != null && event.getMessage() != null) {
            message.setText(event.getMessage());
        } else {
            message.setText("");
        }

        Toast.makeText(SquareUpOttoEventBus.this, "Event Occurred", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBusOtto.registerBus(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusOtto.unRegisterBus(this);
    }


    @Override
    public void onBackPressed() {
        BaseActivity.startNewActivity(this, GreenRobotEventBus.class);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addTrigger:
                Events events = new Events();
                events.setMessage("Event Triggered");
                EventBusOtto.triggerEventWithValue(events);
                break;
            case R.id.nextActivity:
                BaseActivity.startNewActivity(this, GreenRobotEventBus.class);
                break;
        }


    }
}
