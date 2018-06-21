package com.fanwe.viewlistener;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fanwe.lib.viewlistener.FViewSelectionListener;

public class TestSelectionActivity extends AppCompatActivity
{
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

        mSelectionListener.setView(mButton);
    }

    private final FViewSelectionListener<Button> mSelectionListener = new FViewSelectionListener<Button>()
    {
        @Override
        public void onSelectionChanged(boolean selected, Button view)
        {
            if (selected)
                view.setTextColor(Color.RED);
            else
                view.setTextColor(Color.BLACK);
        }
    };
}
