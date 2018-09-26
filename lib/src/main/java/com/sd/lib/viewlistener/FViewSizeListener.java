package com.sd.lib.viewlistener;

import android.view.View;

/**
 * 监听view宽高变化
 */
public abstract class FViewSizeListener<T extends View> extends FViewListener<T>
{
    private int mWidth;
    private int mHeight;

    @Override
    public final void update()
    {
        super.update();

        final T view = getView();
        if (view == null)
            return;

        onWidthChanged(mWidth, onGetWidth(view), view);
        onHeightChanged(mHeight, onGetHeight(view), view);
    }

    @Override
    protected final void onUpdate(T view)
    {
        if (view == null)
            return;

        final int oldWidth = mWidth;
        final int oldHeight = mHeight;

        final int newWidth = onGetWidth(view);
        final int newHeight = onGetHeight(view);

        if (oldWidth != newWidth)
        {
            mWidth = newWidth;
            onWidthChanged(oldWidth, newWidth, view);
        }

        if (oldHeight != newHeight)
        {
            mHeight = newHeight;
            onHeightChanged(oldHeight, newHeight, view);
        }
    }

    protected int onGetWidth(View view)
    {
        return view.getWidth();
    }

    protected int onGetHeight(View view)
    {
        return view.getHeight();
    }

    protected abstract void onWidthChanged(int oldWidth, int newWidth, View view);

    protected abstract void onHeightChanged(int oldHeight, int newHeight, View view);
}
