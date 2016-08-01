# XListView（感谢您的Star or Fork）
XListView的修改版,增加仿IOS的等待圈
QQ交流群：

## 演示gif
![Alt text](/fresh.gif)
![Alt text](/load.gif)
####原作者XListView https://github.com/Maxwin-z/XListView-Android
####RecyclerView的版本:https://github.com/limxing/LFRecyclerView-Android
##个人更新地方:
    增加了时间的判断显示
    修改了刷新的同时不能够加载,加载的时候不能够刷新
    增加了仿IOS的自定义LoadView的旋转等待图片(如果您也喜欢,欢迎Fork or Star)
##Usage
    与原XListView一致

2016-05-18更新:
添加执行更新的方法
 startRefresh()
 
 2016-06-7 添加一个隐藏时间的方法
 hideTimeView();

2016-06-8 添加一个可以设置标题和结尾的功能
setFootText(String text)    setHeaderText(String header)

2016-07-21 更新一个方法(stopRefresh),更换来三个状态图标
//添加一个当ListView为空时可以添加图片或提示语
