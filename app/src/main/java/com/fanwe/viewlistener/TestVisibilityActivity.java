package com.fanwe.viewlistener;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fanwe.lib.viewlistener.FViewVisibilityListener;

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

        mListener.setView(mButton);
    }

    private final FViewVisibilityListener<Button> mListener = new FViewVisibilityListener<Button>()
    {
        @Override
        public void onVisibilityChanged(int visibility, Button view)
        {
            Log.i(TAG, "onVisibilityChanged:" + visibility);
        }
    };
}
