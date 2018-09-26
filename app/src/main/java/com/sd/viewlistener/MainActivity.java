package com.sd.viewlistener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_size:
                startActivity(new Intent(this, TestSizeActivity.class));
                break;
            case R.id.btn_visibility:
                startActivity(new Intent(this, TestVisibilityActivity.class));
                break;
            case R.id.btn_selection:
                startActivity(new Intent(this, TestSelectionActivity.class));
                break;
        }
    }
}
