# widget
（[English document](README_EN.md)）<br>
开发这个控件库是为了致力于提升android原生控件的一些性能及体验

![](pic.jpg 'pic')

# 效果
这次添加的顶部图片过度拉伸效果是仿ios的appstore中的图片过度拉伸效果。

![image](https://github.com/chengweidev/widget/blob/master/f.gif ) 

* 继承RecycleView，保留RecycleView原本的特性<br>
* 根据RecycleView的滚动item时动态调整各item的top位置及head的scale值，不触发requestLayout。<br>
* 处理了head收起展开的各种极端情况，确保head不会只露出半个<br>
* 处理了RecycleView的快速抛动情况，确保fling到head时head的位置能正常<br>



# 集成
需要集成v4和v7两个库，以及这里的效果库
   
    implementation 'com.chw.android:widget:3.0.3'
    implementation 'com.android.support:support-v4:27.1.1'
    implementation 'com.android.support:recyclerview-v7:27.1.1'
    
 #    使用
 
 使用起来十分简单，将RecycleView换成WeRecycleView即可，设置滑动模式
      
     mRecycleView.setScrollMode(WeRecycleView.SCROLL_SCALE_HEAD);
     mRecycleView.setMaxScale(4f);
     mRecycleView.setSafeHeight(480);
     mRecycleView.setCloseOffset(50 * mDensity);
     
