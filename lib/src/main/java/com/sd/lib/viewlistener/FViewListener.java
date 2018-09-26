package com.sd.lib.viewlistener;

import android.view.View;
import android.view.ViewTreeObserver;

import java.lang.ref.WeakReference;

public abstract class FViewListener<T extends View>
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
            if (old != null)
            {
                old.removeOnAttachStateChangeListener(mOnAttachStateChangeListener);
                registerViewTreeObserver(old, false);
            }

            mView = view == null ? null : new WeakReference<>(view);
            onViewChanged(old, view);

            if (view != null)
            {
                view.addOnAttachStateChangeListener(mOnAttachStateChangeListener);
                registerViewTreeObserver(view, true);
            }
        }
    }

    /**
     * 手动触发一次通知
     */
    public void update()
    {
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

    protected abstract void onUpdate(T view);
}
