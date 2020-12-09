package com.sd.viewlistener;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sd.lib.viewlistener.ext.integers.FViewVisibilityListener;

public class TestVisibilityActivity extends AppCompatActivity
{
    public static final String TAG = TestVisibilityActivity.class.getSimpleName();

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_visibility);
        mButton = findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(final View v)
            {
                v.setVisibility(View.GONE);
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        v.setVisibility(View.VISIBLE);
                    }
                }, 2000);
            }
        });

        mVisibilityListener.setView(mButton);
    }

    private final FViewVisibilityListener<Button> mVisibilityListener = new FViewVisibilityListener<Button>()
    {
        @Override
        protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
        {
            Log.i(TAG, "onVisibilityChanged:" + oldValue + " -> " + newValue);
        }
    };
}
