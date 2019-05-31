# About
监听Android view的某个状态的变化，比如可见状态变化，选中状态变化，大小变化等

# Gradle
[![](https://jitpack.io/v/zj565061763/viewlistener.svg)](https://jitpack.io/#zj565061763/viewlistener)

# 监听可见状态变化
```java
private final FViewPropertyListener<Button, Integer> mListener = new FViewPropertyListener<Button, Integer>()
{
    @Override
    protected Integer getPropertyValue(Button view)
    {
        return view.getVisibility();
    }

    @Override
    protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
    {
        Log.i(TAG, "onVisibilityChanged:" + oldValue + " -> " + newValue);
    }
};

// 设置要监听的view
mListener.setView(view);
```

# 监听宽度变化
```java
private final FViewPropertyListener<Button, Integer> mListener = new FViewPropertyListener<Button, Integer>()
{
    @Override
    protected Integer getPropertyValue(Button view)
    {
        return view.getWidth();
    }

    @Override
    protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
    {
        Log.i(TAG, "onWidthChanged:" + oldValue + " -> " + newValue);
    }
};

// 设置要监听的view
mListener.setView(view);
```
# 监听选中状态变化
```java
private final FViewPropertyListener<Button, Boolean> mListener = new FViewPropertyListener<Button, Boolean>()
{
    @Override
    protected Boolean getPropertyValue(Button view)
    {
        return view.isSelected();
    }

    @Override
    protected void onPropertyValueChanged(Button view, Integer oldValue, Integer newValue)
    {
        Log.i(TAG, "onSelectionChanged:" + oldValue + " -> " + newValue);
    }
};

// 设置要监听的view
mListener.setView(view);
```
