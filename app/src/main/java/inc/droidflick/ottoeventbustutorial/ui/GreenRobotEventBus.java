package inc.droidflick.ottoeventbustutorial.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import inc.droidflick.ottoeventbustutorial.R;
import inc.droidflick.ottoeventbustutorial.model.Events;
import inc.droidflick.ottoeventbustutorial.ui.core.BaseActivity;

public class GreenRobotEventBus extends BaseActivity implements View.OnClickListener {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    TextView messageLabel;
    Button addTrigger, nextActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void init() {
        messageLabel = findViewById(R.id.messageLabel);

        addTrigger = findViewById(R.id.addTrigger);

        nextActivity = findViewById(R.id.nextActivity);
    }

    @Override
    public void initUiListeners() {
        addTrigger.setOnClickListener(this);
        nextActivity.setOnClickListener(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Events event) {
        if (event != null && event.getMessage() != null) {
            Toast.makeText(GreenRobotEventBus.this, event.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        /**
         * greenrobot:eventbus
         * **/

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addTrigger:
                Events events = new Events();
                events.setMessage("Event Triggered");
                EventBus.getDefault().post(events);
                break;
            case R.id.nextActivity:
                BaseActivity.startNewActivity(this, SquareUpOttoEventBus.class);
                break;
        }
    }
}
