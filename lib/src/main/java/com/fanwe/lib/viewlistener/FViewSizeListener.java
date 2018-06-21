/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.viewlistener;

import android.view.View;

/**
 * 监听view宽高变化
 */
public abstract class FViewSizeListener<T extends View> extends BaseViewListener<T>
{
    private int mWidth;
    private int mHeight;

    @Override
    protected void onViewChanged(View newView, View oldView)
    {
        super.onViewChanged(newView, oldView);

        mWidth = 0;
        mHeight = 0;
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

        if (newWidth != oldWidth)
        {
            mWidth = newWidth;
            onWidthChanged(newWidth, oldWidth, view);
        }

        if (newHeight != oldHeight)
        {
            mHeight = newHeight;
            onHeightChanged(newHeight, oldHeight, view);
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

    protected abstract void onWidthChanged(int newWidth, int oldWidth, View view);

    protected abstract void onHeightChanged(int newHeight, int oldHeight, View view);
}
