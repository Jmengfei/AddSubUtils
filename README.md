# AddSubUtils
对购物车加减按钮的简单封装，几行代码就搞定，采用链式调用，而且样式支持自定义

# 实例效果

![这里写图片描述](http://img.blog.csdn.net/20170814122512400?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMzY2Njg3MzE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

# Gradle

```
dependencies {
 compile 'com.mengfei:AddSubUtils:1.0.0'
}
```

# 如何使用

### 1. 在xml代码中引用

```
    <com.mengfei.AddSubUtils
        android:id="@+id/add_sub"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="10dp" />
```
### 2.在Activity或者Fragment中配置Banner

```
 AddSubUtils addSubUtils = (AddSubUtils) findViewById(R.id.add_sub);
        addSubUtils.setBuyMax(30)       // 最大购买数，默认为int的最大值
                .setInventory(50)       // 库存，默认为int的最大值
                .setCurrentNumber(5)    // 设置当前数，默认为1
                .setStep(5)             // 步长，默认为1
                .setBuyMin(2)           // 购买的最小值，默认为1
                .setOnWarnListener(new AddSubUtils.OnWarnListener() {
                    @Override
                    public void onWarningForInventory(int inventory) {
                        Toast.makeText(MainActivity.this, "当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMax(int max) {
                        Toast.makeText(MainActivity.this, "超过最大购买数:" + max, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onWarningForBuyMin(int min) {
                        Toast.makeText(MainActivity.this, "低于最小购买数:" + min, Toast.LENGTH_SHORT).show();
                    }
                });
```

# Attributes属性（banner布局文件中调用）

| Attributes 	|forma	|describe|
| ----------- |-------|------- |
|editable	|boolean|是否可以手动输入|
|location	|string	|输入框的位置(在左边还是右边)，默认中间|
|ImageWidth	|dimension|左右2边+-按钮的宽度|
|contentWidth	|dimension|中间EditText的宽度|
|contentTextSize|dimension|中间EditText的字体大小|
|contentTextColor|color	|中间字体的颜色|
|all_background|color/reference|整个控件的background|
|leftBackground|color/reference|左面控件的背景|
|rightBackground|color/reference|右面控件的背景|
|contentBackground|color/reference|中间控件的背景|
|leftResources|color/reference|左面控件的资源|
|rightResources|color/reference|右面控件的资源|


