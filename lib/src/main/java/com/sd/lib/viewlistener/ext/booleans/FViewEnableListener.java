package com.sd.lib.viewlistener.ext.booleans;

import android.view.View;

/**
 * 监听 {@link View#isEnabled()}
 *
 * @param <V>
 */
public abstract class FViewEnableListener<V extends View> extends FViewBooleanPropertyListener<V>
{
    @Override
    protected Boolean getPropertyValue(V view)
    {
        return view.isEnabled();
    }
}
