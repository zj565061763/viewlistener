package com.sd.lib.viewlistener;

import android.view.View;

import com.sd.lib.viewupdater.ViewUpdater;
import com.sd.lib.viewupdater.impl.OnPreDrawUpdater;

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

        if (view != null)
            getViewUpdater().start();
        else
            getViewUpdater().stop();
    }

    private ViewUpdater getViewUpdater()
    {
        if (mViewUpdater == null)
        {
            mViewUpdater = new OnPreDrawUpdater();
            mViewUpdater.setOnViewChangeCallback(new ViewUpdater.OnViewChangeCallback()
            {
                @Override
                public void onViewChanged(View oldView, View newView, ViewUpdater updater)
                {
                    BaseViewListener.this.onViewChanged(oldView, newView);
                }
            });
            mViewUpdater.setUpdatable(new ViewUpdater.Updatable()
            {
                @Override
                public void update()
                {
                    onUpdate(getView());
                }
            });
        }
        return mViewUpdater;
    }

    protected void onViewChanged(View oldView, View newView)
    {
    }

    protected abstract void onUpdate(T view);
}
