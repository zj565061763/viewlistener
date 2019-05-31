package com.sd.viewlistener;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sd.lib.viewlistener.FViewPropertyListener;

public class TestSelectionActivity extends AppCompatActivity
{
    public static final String TAG = TestSelectionActivity.class.getSimpleName();

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_selection);
        mButton = findViewById(R.id.btn);
        mButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                v.setSelected(!v.isSelected());
            }
        });

        mListener.setView(mButton);
    }

    private final FViewPropertyListener<Button, Boolean> mListener = new FViewPropertyListener<Button, Boolean>()
    {
        @Override
        protected Boolean getPropertyValue(Button view)
        {
            return view.isSelected();
        }

        @Override
        protected void onPropertyValueChanged(Button view, Boolean oldValue, Boolean newValue)
        {
            Log.i(TAG, "onSelectionChanged:" + oldValue + " -> " + newValue);

            if (newValue)
                view.setTextColor(Color.RED);
            else
                view.setTextColor(Color.BLACK);
        }
    };
}
