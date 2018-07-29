# widget
[中文文档](README_CN.md)<br>
The development of this control library is intended to enhance the performance and experience of Android native controls.

![](pic.jpg 'pic')

# 效果
The overstretched effect of the top picture added is the overstretching effect of the picture imitated by IOS Appstore.

![image](https://github.com/chengweidev/widget/blob/master/f.gif ) 

* Extend RecycleView, retaining its original features<br>
* According to the rolling item of RecycleView, it dynamically adjusts the top position of each item and scale value of head, and does not trigger requestLayout.<br>
* Head has handled all kinds of extreme situations that have been deployed to ensure that head will not reveal only half of them.<br>
* The fast throw motion of RecycleView is processed to ensure that the position of head can be normal when fling to head.<br>



# 集成
You need to integrate the V4 and V7 libraries, and the effect libraries here
   
    implementation 'com.chw.android:widget:3.0.3'
    implementation 'com.android.support:support-v4:27.1.1'
    implementation 'com.android.support:recyclerview-v7:27.1.1'
    
 #    使用
 
It is very simple to use, change the RecycleView to WeRecycleView, and set the sliding mode.
      
     mRecycleView.setScrollMode(WeRecycleView.SCROLL_SCALE_HEAD);
     mRecycleView.setMaxScale(4f);
     mRecycleView.setSafeHeight(480);
     mRecycleView.setCloseOffset(50 * mDensity);
     
