package com.sd.viewlistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sd.lib.viewlistener.FViewPropertyListener;

public class TestSizeActivity extends AppCompatActivity
{
    public static final String TAG = TestSizeActivity.class.getSimpleName();

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_size);
        mButton = findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                final ViewGroup.LayoutParams params = v.getLayoutParams();
                params.width = v.getWidth() + 10;
                params.height = v.getHeight() + 10;
                v.setLayoutParams(params);
            }
        });

        mWidthListener.setView(mButton);
        mHeightListener.setView(mButton);
    }

    private final FViewPropertyListener<Button, Integer> mWidthListener = new FViewPropertyListener<Button, Integer>()
    {
        @Override
        protected Integer getPropertyValue(Button view)
        {
            return view.getWidth();
        }

        @Override
        protected void onPropertyValueChanged(Integer value, Button view)
        {
            Log.i(TAG, "onWidthChanged:" + value);
        }
    };

    private final FViewPropertyListener<Button, Integer> mHeightListener = new FViewPropertyListener<Button, Integer>()
    {
        @Override
        protected Integer getPropertyValue(Button view)
        {
            return view.getHeight();
        }

        @Override
        protected void onPropertyValueChanged(Integer value, Button view)
        {
            Log.i(TAG, "onHeightChanged:" + value);
        }
    };
}
