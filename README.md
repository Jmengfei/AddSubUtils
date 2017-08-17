# Android商城购物车加减控件AddSubUtils

# 相关博客

[商城购物车加减控件的简单封装](http://blog.csdn.net/sinat_36668731/article/details/77163019)

[商城购物车加减控件的简单封装（续），解决ListView中数据错乱的问题](http://blog.csdn.net/sinat_36668731/article/details/77337091)


# 实例效果

![这里写图片描述](http://img.blog.csdn.net/20170817135117202?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMzY2Njg3MzE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

# 联系方式：

![这里写图片描述](http://img.blog.csdn.net/20170809175419051?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMzY2Njg3MzE=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

- 如果您有什么问题或者建议，欢迎加入qq群，这里还可以学习Kotlin。

# Attributes属性（addsubutils布局文件中调用）

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

# 使用步骤

### 1.依赖AddSubUtils
```
dependencies {
 compile 'com.mengfei:AddSubUtils:1.5.0' // 最新版本
}
```
或者下载源码包，链接：https://github.com/Jmengfei/AddSubUtils ，引用本地lib,并且在build.gradle中添加：
```
dependencies {
 compile project(':addsubutils')
}
```

### 2. 在xml代码中引用

```
    <com.mengfei.AddSubUtils
        android:id="@+id/add_sub"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
```
你也可以自定义样式：

```
 <com.mengfei.AddSubUtils
        android:id="@+id/add_sub_2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        jmf:editable="true"
        jmf:ImageWidth="60dp"
        jmf:contentTextColor="@color/colorText"
        jmf:contentWidth="120dp"
        jmf:contentTextSize="16sp"
        jmf:contentBackground="@color/material_teal_200"
        jmf:leftBackground="@drawable/left_selector"
        jmf:rightBackground="@drawable/right_selector"
        jmf:leftResources="@drawable/minus"
        jmf:rightResources="@drawable/plus"/>
```

### 3.在Activity或者Fragment中配置AddSubUtils

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

### 4. 如果你是在ListView或者RecyclerView中使用：

```
        holder.list_item_utils
                    .setStep(1)
                    .setBuyMax(30)
                    .setPosition(position)    // 传入当前位置，一定要传，不然数据会错乱
                    .setCurrentNumber(dataBean.getValue())
                    .setInventory(50)
                    .setOnWarnListener(new AddSubUtils.OnWarnListener() {
                        @Override
                        public void onWarningForInventory(int inventory) {
                            Toast.makeText(ListViewActivity.this, "不能超过当前库存:" + inventory, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onWarningForBuyMax(int max) {
                            Toast.makeText(ListViewActivity.this, "超过最大购买数:" + max, Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onWarningForBuyMin(int min) {
                            Toast.makeText(ListViewActivity.this, "低于最小购买数:" + min, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setOnChangeValueListener(new AddSubUtils.OnChangeValueListener() {
                        @Override
                        public void onChangeValue(int value,int position) {
                            setValue(position,value);    // 使用传回来的position设置数据
                        }
                    });
```
注意：这里setPosition()是一定要有的

采用的是链式调用，这里你只需要传入你关心的值即可。

# 关于我

一个想搞事情的Android攻城狮

csdn主页：http://blog.csdn.net/sinat_36668731?viewmode=list

掘金主页：https://juejin.im/user/582991ff570c3500587d2da9

简书主页：http://www.jianshu.com/u/0e9fd9fee3a6
