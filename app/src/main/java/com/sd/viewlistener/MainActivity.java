package com.sd.viewlistener;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
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
            case R.id.btn_select:
                startActivity(new Intent(this, TestSelectActivity.class));
                break;
        }
    }
}
