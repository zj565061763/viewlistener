package com.sd.viewlistener;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sd.lib.viewlistener.ext.booleans.FViewSelectListener;

public class TestSelectActivity extends AppCompatActivity
{
    public static final String TAG = TestSelectActivity.class.getSimpleName();

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_select);
        mButton = findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                v.setSelected(!v.isSelected());
            }
        });

        mSelectListener.setView(mButton);
    }

    private final FViewSelectListener<Button> mSelectListener = new FViewSelectListener<Button>()
    {
        @Override
        protected void onPropertyValueChanged(Button view, Boolean oldValue, Boolean newValue)
        {
            Log.i(TAG, "onSelectChanged:" + oldValue + " -> " + newValue);

            if (newValue)
                view.setTextColor(Color.RED);
            else
                view.setTextColor(Color.BLACK);
        }
    };
}
