# About
监听Android view的某个状态的变化，比如可见状态变化，选中状态变化，大小变化等

# Gradle
[![](https://jitpack.io/v/zj565061763/viewlistener.svg)](https://jitpack.io/#zj565061763/viewlistener)

# FViewVisibilityListener
```java
private final FViewVisibilityListener<Button> mListener = new FViewVisibilityListener<Button>()
{
    @Override
    protected void onVisibilityChanged(int visibility, Button view)
    {
        Log.i(TAG, "onVisibilityChanged:" + visibility);
    }
};

// 设置要监听的view
mListener.setView(view);
```

# FViewSizeListener
```java
private final FViewSizeListener<Button> mListener = new FViewSizeListener<Button>()
{
    @Override
    protected void onWidthChanged(int oldWidth, int newWidth, Button view)
    {
        Log.i(TAG, "onWidthChanged:" + oldWidth + "," + newWidth);
    }

    @Override
    protected void onHeightChanged(int oldHeight, int newHeight, Button view)
    {
        Log.i(TAG, "onHeightChanged:" + oldHeight + "," + newHeight);
    }
};

// 设置要监听的view
mListener.setView(view);
```
<br>
更多监听类的详细介绍请参考源码以及demo......
