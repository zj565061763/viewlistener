package com.fanwe.lib.viewlistener;

import android.graphics.Rect;
import android.view.View;

/**
 * 监听view宽高变化
 */
public abstract class FViewDisplaySizeListener<T extends View> extends FViewSizeListener<T>
{
    private final Rect mRect = new Rect();

    @Override
    protected final int onGetHeight(View view)
    {
        view.getWindowVisibleDisplayFrame(mRect);
        return mRect.height();
    }

    @Override
    protected final int onGetWidth(View view)
    {
        view.getWindowVisibleDisplayFrame(mRect);
        return mRect.width();
    }
}
