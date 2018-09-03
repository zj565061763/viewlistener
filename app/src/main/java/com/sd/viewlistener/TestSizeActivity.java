package com.sd.viewlistener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sd.lib.viewlistener.FViewSizeListener;

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

        mListener.setView(mButton);
    }

    private final FViewSizeListener<Button> mListener = new FViewSizeListener<Button>()
    {
        @Override
        protected void onWidthChanged(int newWidth, int oldWidth, View view)
        {
            Log.i(TAG, "onWidthChanged:" + newWidth + "," + oldWidth);
        }

        @Override
        protected void onHeightChanged(int newHeight, int oldHeight, View view)
        {
            Log.i(TAG, "onHeightChanged:" + newHeight + "," + oldHeight);
        }
    };
}
