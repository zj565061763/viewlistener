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
