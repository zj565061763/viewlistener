package com.sd.lib.viewlistener;

import android.view.View;

/**
 * View属性值变化监听
 *
 * @param <V> 监听的View类型
 * @param <P> 属性值类型
 */
public abstract class FViewPropertyListener<V extends View, P> extends FViewListener<V>
{
    private P mPropertyValue;

    @Override
    protected void onViewChanged(V oldView, V newView)
    {
        super.onViewChanged(oldView, newView);
        if (newView != null)
            mPropertyValue = getPropertyValue(newView);
    }

    @Override
    public final void update()
    {
        super.update();

        final V view = getView();
        if (view != null)
            onPropertyValueChanged(mPropertyValue, getPropertyValue(view), view);
    }

    @Override
    protected final void onUpdate(V view)
    {
        if (view == null)
            return;

        final P oldValue = mPropertyValue;
        final P newValue = getPropertyValue(view);

        if (!isEquals(oldValue, newValue))
        {
            mPropertyValue = newValue;
            onPropertyValueChanged(oldValue, newValue, view);
        }
    }

    /**
     * 属性值是否相等
     *
     * @param oldValue
     * @param newValue
     * @return
     */
    protected boolean isEquals(P oldValue, P newValue)
    {
        return (oldValue == newValue) || (oldValue != null && oldValue.equals(newValue));
    }

    /**
     * 返回View的属性值
     *
     * @param view
     * @return
     */
    protected abstract P getPropertyValue(V view);

    /**
     * 属性值变化
     *
     * @param oldValue
     * @param newValue
     * @param view
     */
    protected abstract void onPropertyValueChanged(P oldValue, P newValue, V view);
}
