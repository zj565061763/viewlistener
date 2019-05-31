# About
监听Android view的某个状态的变化，比如可见状态变化，选中状态变化，大小变化等

# Gradle
[![](https://jitpack.io/v/zj565061763/viewlistener.svg)](https://jitpack.io/#zj565061763/viewlistener)

# 监听可见状态变化
```java
private final FViewVisibilityListener<Button> mVisibilityListener = new FViewVisibilityListener<Button>()
{
    @Override
    protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
    {
        Log.i(TAG, "onVisibilityChanged:" + oldValue + " -> " + newValue);
    }
};

// 设置要监听的view
mVisibilityListener.setView(view);
```

# 监听宽度变化
```java
private final FViewWidthListener<Button> mWidthListener = new FViewWidthListener<Button>()
{
    @Override
    protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
    {
        Log.i(TAG, "onWidthChanged:" + oldValue + " -> " + newValue);
    }
};

// 设置要监听的view
mWidthListener.setView(view);
```
# 监听选中状态变化
```java
private final FViewSelectListener<Button> mSelectListener = new FViewSelectListener<Button>()
{
    @Override
    protected void onPropertyValueChanged(Button view, Boolean oldValue, Boolean newValue)
    {
        Log.i(TAG, "onSelectChanged:" + oldValue + " -> " + newValue);

        if (newValue)
            view.setTextColor(Color.RED);
        else
            view.setTextColor(Color.BLACK);
    }
};

// 设置要监听的view
mSelectListener.setView(view);
```

# 自定义监听
```java
private final FViewPropertyListener<Button, Float> mXListener = new FViewPropertyListener<Button, Float>()
{
    @Override
    protected Float getPropertyValue(Button view)
    {
        // 返回监听的值
        return view.getX();
    }

    @Override
    protected void onPropertyValueChanged(Button view, Float oldValue, Float newValue)
    {
        Log.i(TAG, "onXChanged:" + oldValue + " -> " + newValue);
    }
};

// 设置要监听的view
mXListener.setView(view);
```
