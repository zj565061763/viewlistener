package com.sd.lib.viewlistener;

import android.view.View;

/**
 * view的显示隐藏监听
 */
public abstract class FViewVisibilityListener<T extends View> extends FViewListener<T>
{
    private int mVisibility;

    @Override
    protected void onViewChanged(View oldView, View newView)
    {
        super.onViewChanged(oldView, newView);
        if (newView != null)
            mVisibility = newView.getVisibility();
    }

    @Override
    public final void update()
    {
        super.update();

        final T view = getView();
        if (view != null)
            onVisibilityChanged(view.getVisibility(), view);
    }

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
    protected abstract void onVisibilityChanged(int visibility, T view);
}
