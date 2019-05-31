package com.sd.lib.viewlistener.ext.integers;

import android.view.View;

/**
 * 监听 {@link View#getWidth()}
 *
 * @param <V>
 */
public abstract class FViewWidthListener<V extends View> extends FViewIntegerPropertyListener<V>
{
    @Override
    protected Integer getPropertyValue(V view)
    {
        return view.getWidth();
    }
}
