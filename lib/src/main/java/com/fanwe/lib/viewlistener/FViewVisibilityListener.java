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
 * view的显示隐藏监听
 */
public abstract class FViewVisibilityListener<T extends View> extends BaseViewListener<T>
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
