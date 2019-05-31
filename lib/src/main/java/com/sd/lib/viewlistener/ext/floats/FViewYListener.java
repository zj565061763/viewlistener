package com.sd.lib.viewlistener.ext.floats;

import android.view.View;

/**
 * 监听 {@link View#getY()}
 *
 * @param <V>
 */
public abstract class FViewYListener<V extends View> extends FViewFloatPropertyListener<V>
{
    @Override
    protected Float getPropertyValue(V view)
    {
        return view.getY();
    }
}
