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

import com.fanwe.lib.updater.Updater;
import com.fanwe.lib.updater.ViewUpdater;
import com.fanwe.lib.updater.impl.OnPreDrawUpdater;

/**
 * view的显示隐藏监听
 */
public abstract class FViewVisibilityListener
{
    private ViewUpdater mViewUpdater;
    /**
     * 当前view的visibility状态
     */
    private int mVisibility = View.VISIBLE;

    /**
     * 获得设置的view
     *
     * @return
     */
    public final View getView()
    {
        return getViewUpdater().getView();
    }

    /**
     * 设置要监听的view
     *
     * @param view
     */
    public final void setView(View view)
    {
        getViewUpdater().setView(view);
        getViewUpdater().start();
    }

    private ViewUpdater getViewUpdater()
    {
        if (mViewUpdater == null)
        {
            mViewUpdater = new OnPreDrawUpdater();
            mViewUpdater.setUpdatable(new Updater.Updatable()
            {
                @Override
                public void update()
                {
                    notifyIfNeed();
                }
            });
            mViewUpdater.setOnStateChangeCallback(new Updater.OnStateChangeCallback()
            {
                @Override
                public void onStateChanged(boolean started, Updater updater)
                {
                    if (started)
                        updater.notifyUpdatable();
                }
            });
        }
        return mViewUpdater;
    }

    private void notifyIfNeed()
    {
        final View view = getView();
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
     * View的可见状态发生变化
     *
     * @param visibility
     * @param view
     */
    public abstract void onVisibilityChanged(int visibility, View view);
}
