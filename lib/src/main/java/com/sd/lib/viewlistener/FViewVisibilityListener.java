package com.sd.lib.viewlistener;

import android.view.View;

/**
 * view的显示隐藏监听
 */
public abstract class FViewVisibilityListener<T extends View> extends FViewListener<T>
{
    private int mVisibility = View.VISIBLE;

    @Override
    protected final void onUpdate(T view)
    {
        if (view == null)
            return;

        final int visibility = view.getVisibility();
        if (mVisibility != visibility)
        {
            mVisibility = visibility;
            onVisibilityChanged(visibility, view);
        }
    }

    /**
     * 可见状态变化
     *
     * @param visibility
     * @param view
     */
    public abstract void onVisibilityChanged(int visibility, T view);
}
