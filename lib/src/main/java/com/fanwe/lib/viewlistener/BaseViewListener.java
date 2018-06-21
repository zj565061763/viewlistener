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

abstract class BaseViewListener<T extends View>
{
    private ViewUpdater mViewUpdater;

    /**
     * 返回设置的view
     *
     * @return
     */
    public final T getView()
    {
        return (T) getViewUpdater().getView();
    }

    /**
     * 设置要监听的view
     *
     * @param view
     */
    public final void setView(T view)
    {
        getViewUpdater().setView(view);
        getViewUpdater().start();
    }

    private ViewUpdater getViewUpdater()
    {
        if (mViewUpdater == null)
        {
            mViewUpdater = new OnPreDrawUpdater()
            {
                @Override
                protected void onViewChanged(View newView, View oldView)
                {
                    super.onViewChanged(newView, oldView);
                    BaseViewListener.this.onViewChanged(newView, oldView);
                }
            };
            mViewUpdater.setUpdatable(new Updater.Updatable()
            {
                @Override
                public void update()
                {
                    onUpdate(getView());
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

    protected void onViewChanged(View newView, View oldView)
    {
    }

    protected abstract void onUpdate(T view);
}
