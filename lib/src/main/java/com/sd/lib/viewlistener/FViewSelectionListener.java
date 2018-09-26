package com.sd.lib.viewlistener;

import android.view.View;

/**
 * view的选中状态变化监听
 *
 * @param <T>
 */
public abstract class FViewSelectionListener<T extends View> extends FViewListener<T>
{
    private boolean mSelected;

    @Override
    protected void onViewChanged(View oldView, View newView)
    {
        super.onViewChanged(oldView, newView);
        if (newView != null)
            mSelected = newView.isSelected();
    }

    @Override
    public void update()
    {
        super.update();

        final T view = getView();
        if (view == null)
            return;

        onSelectionChanged(view.isSelected(), view);
    }

    @Override
    protected final void onUpdate(T view)
    {
        if (view == null)
            return;

        final boolean selected = view.isSelected();
        if (mSelected != selected)
        {
            mSelected = selected;
            onSelectionChanged(selected, view);
        }
    }

    /**
     * 选中状态变化
     *
     * @param selected
     * @param view
     */
    protected abstract void onSelectionChanged(boolean selected, T view);
}
