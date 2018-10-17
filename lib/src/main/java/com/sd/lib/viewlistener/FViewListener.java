package com.sd.lib.viewlistener;

import android.view.View;
import android.view.ViewTreeObserver;

import java.lang.ref.WeakReference;

abstract class FViewListener<T extends View>
{
    private WeakReference<T> mView;

    /**
     * 返回设置的view
     *
     * @return
     */
    public final T getView()
    {
        return mView == null ? null : mView.get();
    }

    /**
     * 设置要监听的view
     *
     * @param view
     */
    public final void setView(T view)
    {
        final T old = getView();
        if (old != view)
        {
            start(false);

            mView = view == null ? null : new WeakReference<>(view);
            onViewChanged(old, view);

            start(true);
        }
    }

    /**
     * 是否开始监听
     *
     * @param start true-开始，false-停止
     */
    public final void start(boolean start)
    {
        final View view = getView();
        if (view != null)
        {
            registerAttachStateChangeListener(view, start);
            registerViewTreeObserver(view, start);
        }
    }

    private void registerAttachStateChangeListener(View view, boolean register)
    {
        view.removeOnAttachStateChangeListener(mOnAttachStateChangeListener);
        if (register)
            view.addOnAttachStateChangeListener(mOnAttachStateChangeListener);
    }

    private void registerViewTreeObserver(View view, boolean register)
    {
        final ViewTreeObserver observer = view.getViewTreeObserver();
        if (observer.isAlive())
        {
            observer.removeOnPreDrawListener(mOnPreDrawListener);
            if (register)
                observer.addOnPreDrawListener(mOnPreDrawListener);
        }
    }

    private final View.OnAttachStateChangeListener mOnAttachStateChangeListener = new View.OnAttachStateChangeListener()
    {
        @Override
        public void onViewAttachedToWindow(View v)
        {
            registerViewTreeObserver(v, true);
        }

        @Override
        public void onViewDetachedFromWindow(View v)
        {
            registerViewTreeObserver(v, false);
        }
    };

    private final ViewTreeObserver.OnPreDrawListener mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener()
    {
        @Override
        public boolean onPreDraw()
        {
            onUpdate(getView());
            return true;
        }
    };

    protected void onViewChanged(View oldView, View newView)
    {
    }

    /**
     * 手动触发一次通知
     */
    public void update()
    {
    }

    protected abstract void onUpdate(T view);
}
