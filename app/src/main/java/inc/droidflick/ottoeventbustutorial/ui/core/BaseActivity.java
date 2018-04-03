package inc.droidflick.ottoeventbustutorial.ui.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Atif Arif on 4/2/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

    }


    @Override
    protected void onStart() {
        getLayoutId();
        init();
        initUiListeners();
        super.onStart();
    }

    public abstract int getLayoutId();

    public abstract void init();

    public abstract void initUiListeners();


    public static void startNewActivity(Activity activity, Class clazz) {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
        activity.finish();


    }


}
