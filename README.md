# About
监听Android view的某个状态的变化，比如可见状态变化，选中状态变化，大小变化等

# FViewVisibilityListener
```java
private final FViewVisibilityListener<Button> mListener = new FViewVisibilityListener<Button>()
{
    @Override
    public void onVisibilityChanged(int visibility, Button view)
    {
        Log.i(TAG, "onVisibilityChanged:" + visibility);
    }
};

// 设置要监听的view
mListener.setView(view);
```
