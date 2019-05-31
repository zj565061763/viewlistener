package com.sd.lib.viewlistener.ext.integers;

import android.view.View;

/**
 * 监听 {@link View#getVisibility()}
 *
 * @param <V>
 */
public abstract class FViewVisibilityListener<V extends View> extends FViewIntegerPropertyListener<V>
{
    @Override
    protected Integer getPropertyValue(V view)
    {
        return view.getVisibility();
    }
}
