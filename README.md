# WLTY10001_ShortVideo
2022第四届字节跳动青训营—Android基础班—结营项目—WLTY10001短视频APP

青训营前端结业项目答辩汇报文档—10001万里挑一
一、项目介绍
本项目是一款基于抖音API而开发的极简短视频APP
 
项目服务地址：https://github.com/BIGBOSS-dedsec/WLTY10001_ShortVideo
 
 
二、项目分工
暂时无法在飞书文档外展示此内容
 
三、项目实现
3.1 技术选型与相关开发文档
本项目技术选型：
Android与Flutter混合开发
 
Android最低支持兼容版本——5.0
编程语言：Java，dart
前端使用框架 Flutter 2.5.0
选型理由：混合开发中，最接近原生开发的框架，性能强大，流畅，优秀的路由设计，优秀的动画设计，跨多种平台，减少开发成本；支持插件，可以访问原生系统的调用

项目API平台——抖音开放平台（https://open.douyin.com）
[图片]
 
3.2 架构设计
项目框架——mvvm
使用mvvm框架优势在于：使项目松散耦合，易于维护。 ，轻松添加新功能或删除现有功能，可测试的代码，为项目提供了良好的结构，并使浏览和理解我们的代码更加容易。
[图片]
网络框架
Retrofit + RxJava + OkHttp
Retrofit充分利用注解的灵活性，以接口的形式配置来实现解耦。与后台沟通起来也非常方便，api接口可直接调用
OkHttp支持HTTP/2, HTTP/2通过使用多路复用技术在一个单独的TCP连接上支持并发, 通过在一个连接上一次性发送多个请求来发送或接收数据，支持GZIP, 可以压缩下载体积，响应缓存可以直接避免重复请求，会从很多常用的连接问题中自动恢复；
数据库框架
Room提供了SQLite的抽象层，以便在充分利用SQLite的同时允许流畅的数据库访问，编译期检查，Room会在编译的时候验证每个@Query和@Entity等，它不仅检查语法问题，还会检查是否有该表,这就意味着几乎没有任何运行时错误的风险而且有较少的模板代码与 LiveData集成；
 
3.3 项目代码介绍
本项目文件目录如下：
[图片]
其中：TikTokMin是使用Flutter开发的前端样式：WLTYShotVideo2是使用Java编写的数据对接；APP_RES 是APK安装包；
TikTokMIn项目是用Flutter（Dart）写的前端样式，其中项目依赖为：
name: tiktok_app
description: 抖音极简版青训营.
version: 1.0.0+1

environment:
  sdk: ">=2.14.0 <3.0.0"
dependencies:
 cupertino_icons: ^1.0.2； 
video_player: ^2.2.17
  oktoast: ^3.0.0
  # 网络请求
  dio: ^3.0.10
  # 刷新控件
  pull_to_refresh: 1.6.4-nullsafety.1
  # 状态管理、路由管理、依赖注入
  get: ^4.1.4
  # 本地存储
  shared_preferences: ^2.0.5
  # 网络状态库
  connectivity: ^0.4.9+5
  # 点赞
  like_button: ^2.0.2
  # 图片加载
  cached_network_image: ^2.4.1
  # 走马灯
  marquee: ^2.1.0
  # video_player封装的控制器
  chewie: ^1.0.0
  # 相机插件，还在开发中
  camera: ^0.8.1
  # 事件总线
  event_bus: ^2.0.0
  # 二维码
  #  qrscan: ^0.2.22
  # loading
  flutter_easyloading: ^3.0.0
  # 图片选择
  image_picker: ^0.6.7+22
  # 获取视频缩略图
  video_thumbnail: ^0.5.2

WLTYshotVideos2是基于Java开发的后端数据对接部分，其中项目依赖为：
// OkHttp
 'com.squareup.okhttp3:okhttp:4.9.3'
'com.squareup.okhttp3:logging-interceptor:4.9.0'

// ROOM
"androidx.room:room-runtime:2.3.0"
 "androidx.room:room-compiler:2.3.0"

// 图片加载
 'com.github.bumptech.glide:glide:4.13.0'
 'com.github.bumptech.glide:compiler:4.13.0'


// RXJava 方便切换线程
"io.reactivex.rxjava2:rxjava:2.2.20"
"io.reactivex.rxjava2:rxandroid:2.1.1"
 
WLTYshotVideos2 目录介绍
[图片]
[图片]
接口获取部分
[图片]

四、测试结果
建议从功能测试和性能测试两部分分析，其中功能测试补充测试用例，性能测试补充性能分析报告、可优化点等内容。
功能测试
TikTokMin
TikTokMin进入即播放视频，单击暂停，上下滑动屏幕切换视频
[图片]
底部功能页面栏切换页面（如个人页面切换）
[图片]
WLTYshotVideos2
进入APP后首页展示三个排行榜，电影，综艺，抖音剧集排行榜
[图片]
点击进去排行榜中：（Eg：电影排行榜）
向下滑动可以查看更多排行：
[图片]
性能测试
ODM项目为了测试平台稳定性，会下载大量第三方app进行冷、热启动的测试，并生成测试报告。
根据测试结果可用于暴露平台性能上的一些缺陷。
实现：pythn+adb

测试手机：
1. SM-N9600 ——Samsung Galaxy Note9 （One UI2.5）
Android系统版本：10.0     内核版本： 4.9.186-22986754
[图片]
五、Demo 演示视频 （必填）
项目实机调试：（实机运行抖音APP的电影排行榜）
[图片]

[图片]
项目视频演示地址：https://live.csdn.net/v/234203
项目内容截图： 
[图片]
[图片]
[图片]
[图片]
[图片]
[图片]
六、项目总结与反思
目前出现的问题
1. 排行榜数据接口问题：无法获取抖音剧集和综艺排行榜的数据
2. 排行榜模块需要经过room数据库本地缓存，出现的问题：初次打开时，因为需要数据本地缓存，如果对排行榜刷新过快会出现数据无法接收进而APP闪退（或返回到首页）
3. 对TikTokMin的前端样式还未来及做接口对接（对于Flutter暂未找到对接抖音开放平台的方法）
已识别出的优化项
4. 对于Flutter的TikTokMin优化了图标和字体，使用Tiktok官方图标
[图片]
5. 对WLTYshotVideos2加入RXJava 方便切换线程
6. 将数据进行储存，直接调接口的话次数有限。可以切换数据然后进行数据获取（部分接口已被注释，按需调用）
架构演进的可能性
7. 项目主体使用了MVVM架构：Model-View-ViewModel，但是由于 View 和 ViewModel 解耦，导致 Debug 时难以一眼看出 View 的事件传递；代码复杂性增大， Debug 比较困难；后期可以使用MVI，MVI 模式的改动在于将 View 和 ViewModel 之间的多数据流改为基于 ViewState 的单数据流；
项目过程中的反思与总结
反思
本次项目开发中，在Flutter部分时间用的较多，由于对Flutter（Dart）的技术掌握不够，以及抖音开放平台暂无Flutter对接案例，对Flutter数据对接尝试多次失败，从而转而进行Java开发，Flutter仅开发出前端的样式，Java部分仅写出排行榜模块....
总体对技术掌握不够熟练，对APP项目的优化有所欠缺，对开发项目的节奏掌握不好；本次项目的粉丝和个人界面数据对接因为时间原因没有完成，很多的开发初期想的一些细节没有加入（如开屏闪屏，Lottie动画：点赞红心，抖音Logo等，二级界面切换动画打磨欠缺），还有对团队开发过程中的配合等问题；
总结
本次项目的开发中，我们在一起成长了很多，增加了团队默契；青训营本次提供的课程对本项目的学习和开发提供了很大的帮助；本项目虽然还有很多遗留的问题与不足，但是我们会一直对本项目进行不断的完善与开发，努力做到我们心中的APP；
通过本次团队项目的开发，我们各自有所成长中也认识到了自身技术的不足，今后会针对我们的不足，有目标的进行学习和强化。
