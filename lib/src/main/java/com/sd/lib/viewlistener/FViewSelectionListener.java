package com.sd.lib.viewlistener;

import android.view.View;

/**
 * view的选中状态变化监听
 *
 * @param <T>
 */
public abstract class FViewSelectionListener<T extends View> extends BaseViewListener<T>
{
    private boolean mSelected = false;

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
    public abstract void onSelectionChanged(boolean selected, T view);
}
