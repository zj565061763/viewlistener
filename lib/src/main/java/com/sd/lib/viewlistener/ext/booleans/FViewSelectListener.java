package com.sd.lib.viewlistener.ext.booleans;

import android.view.View;

/**
 * 监听 {@link View#isSelected()}
 *
 * @param <V>
 */
public abstract class FViewSelectListener<V extends View> extends FViewBooleanPropertyListener<V>
{
    @Override
    protected Boolean getPropertyValue(V view)
    {
        return view.isSelected();
    }
}
