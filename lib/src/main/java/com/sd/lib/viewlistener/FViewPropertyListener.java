package com.sd.lib.viewlistener;

import android.view.View;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * View属性值变化监听
 *
 * @param <V> 监听的View类型
 * @param <P> 属性值类型
 */
public abstract class FViewPropertyListener<V extends View, P> extends FViewListener<V>
{
    private P mPropertyValue;
    private final Class<P> mPropertyClass;

    public FViewPropertyListener()
    {
        final ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        final Type[] types = parameterizedType.getActualTypeArguments();
        if (types != null && types.length > 1)
        {
            mPropertyClass = (Class<P>) types[1];
        } else
        {
            throw new RuntimeException("generic type not found");
        }
    }

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
            onPropertyValueChanged(getPropertyValue(view), view);
    }

    @Override
    protected final void onUpdate(V view)
    {
        if (view == null)
            return;

        final P propertyValue = getPropertyValue(view);
        if (!isEquals(mPropertyValue, propertyValue))
        {
            mPropertyValue = propertyValue;
            onPropertyValueChanged(propertyValue, view);
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
        if (mPropertyClass == Integer.class)
        {
            return ((Integer) newValue).compareTo((Integer) oldValue) == 0;
        } else if (mPropertyClass == Boolean.class)
        {
            return ((Boolean) newValue).compareTo((Boolean) oldValue) == 0;
        } else if (mPropertyClass == Long.class)
        {
            return ((Long) newValue).compareTo((Long) oldValue) == 0;
        } else if (mPropertyClass == Float.class)
        {
            return ((Float) newValue).compareTo((Float) oldValue) == 0;
        } else if (mPropertyClass == Double.class)
        {
            return ((Double) newValue).compareTo((Double) oldValue) == 0;
        } else if (mPropertyClass == Short.class)
        {
            return ((Short) newValue).compareTo((Short) oldValue) == 0;
        } else if (mPropertyClass == Character.class)
        {
            return ((Character) newValue).compareTo((Character) oldValue) == 0;
        } else if (mPropertyClass == Byte.class)
        {
            return ((Byte) newValue).compareTo((Byte) oldValue) == 0;
        }

        return oldValue == newValue;
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
     * @param value
     * @param view
     */
    protected abstract void onPropertyValueChanged(P value, V view);
}
