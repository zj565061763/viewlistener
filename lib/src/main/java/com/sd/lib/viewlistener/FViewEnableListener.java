package com.sd.lib.viewlistener;

import android.view.View;

public abstract class FViewEnableListener<T extends View> extends FViewListener<T>
{
    private boolean mEnabled;

    @Override
    protected void onViewChanged(View oldView, View newView)
    {
        super.onViewChanged(oldView, newView);
        if (newView != null)
            mEnabled = newView.isEnabled();
    }

    @Override
    public final void update()
    {
        super.update();

        final T view = getView();
        if (view != null)
            onEnableChanged(view.isEnabled(), view);
    }

    @Override
    protected final void onUpdate(T view)
    {
        if (view == null)
            return;

        final boolean enabled = view.isEnabled();
        if (mEnabled != enabled)
        {
            mEnabled = enabled;
            onEnableChanged(enabled, view);
        }
    }

    protected abstract void onEnableChanged(boolean enabled, T view);
}
