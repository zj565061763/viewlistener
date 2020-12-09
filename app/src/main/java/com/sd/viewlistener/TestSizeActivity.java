package com.sd.viewlistener;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sd.lib.viewlistener.ext.integers.FViewHeightListener;
import com.sd.lib.viewlistener.ext.integers.FViewWidthListener;

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

    private final FViewWidthListener<Button> mWidthListener = new FViewWidthListener<Button>()
    {
        @Override
        protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
        {
            Log.i(TAG, "onWidthChanged:" + oldValue + " -> " + newValue);
        }
    };

    private final FViewHeightListener<Button> mHeightListener = new FViewHeightListener<Button>()
    {
        @Override
        protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
        {
            Log.i(TAG, "onHeightChanged:" + oldValue + " -> " + newValue);
        }
    };
}
