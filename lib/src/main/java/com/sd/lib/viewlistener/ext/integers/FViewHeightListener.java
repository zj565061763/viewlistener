package com.sd.lib.viewlistener.ext.integers;

import android.view.View;

/**
 * 监听 {@link View#getHeight()}
 *
 * @param <V>
 */
public abstract class FViewHeightListener<V extends View> extends FViewIntegerPropertyListener<V>
{
    @Override
    protected Integer getPropertyValue(V view)
    {
        return view.getHeight();
    }
}
