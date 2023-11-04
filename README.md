# ShortVideoAPP With Flutter
# 项目介绍
本项目是一款基于抖音API而开发的极简短视频APP
 
# 项目实现
3.1 技术选型与相关开发文档
本项目技术选型：
**Android与Flutter混合开发**
 
Android最低支持兼容版本——5.0
编程语言：**Java，dart**
前端使用框架 **Flutter 2.5.0**

选型理由：混合开发中，最接近原生开发的框架，性能强大，流畅，优秀的路由设计，优秀的动画设计，跨多种平台，减少开发成本；支持插件，可以访问原生系统的调用

项目API平台——抖音开放平台（https://open.douyin.com）
![在这里插入图片描述](https://img-blog.csdnimg.cn/34eb8ab6703e4b8286ddb9eeab50c55f.png)
## 架构设计
### **项目框架——mvvm**
使用mvvm框架优势在于：使项目松散耦合，易于维护。 ，轻松添加新功能或删除现有功能，可测试的代码，为项目提供了良好的结构，并使浏览和理解我们的代码更加容易。
![\[图片\]](https://img-blog.csdnimg.cn/4c1ab335e1ee4508b64218a6cf24df47.png)
### **网络框架**
**Retrofit + RxJava + OkHttp**
Retrofit充分利用注解的灵活性，以接口的形式配置来实现解耦。与后台沟通起来也非常方便，api接口可直接调用
OkHttp支持HTTP/2, HTTP/2通过使用多路复用技术在一个单独的TCP连接上支持并发, 通过在一个连接上一次性发送多个请求来发送或接收数据，支持GZIP, 可以压缩下载体积，响应缓存可以直接避免重复请求，会从很多常用的连接问题中自动恢复；
### **数据库框架**
Room提供了SQLite的抽象层，以便在充分利用SQLite的同时允许流畅的数据库访问，编译期检查，Room会在编译的时候验证每个@Query和@Entity等，它不仅检查语法问题，还会检查是否有该表,这就意味着几乎没有任何运行时错误的风险而且有较少的模板代码与 LiveData集成；
 
# **项目代码介绍**
本项目文件目录如下：
![**\[图片\]**](https://img-blog.csdnimg.cn/eb5c2a2fe5b948d7b30f4d5c1032d4b8.png)
 
WLTYshotVideos2 目录介绍
![\[图片\]](https://img-blog.csdnimg.cn/20516cc8e52d40db80beea80c73242cf.png)
![\[图片\]](https://img-blog.csdnimg.cn/18865eb38ba14c538481958e4da29440.png)
### 接口获取部分
![\[图片\]](https://img-blog.csdnimg.cn/dfd708827cce49118a50764cbf33ea44.png)
# 测试结果
建议从功能测试和性能测试两部分分析，其中功能测试补充测试用例，性能测试补充性能分析报告、可优化点等内容。
功能测试
TikTokMin
TikTokMin进入即播放视频，单击暂停，上下滑动屏幕切换视频
![\[图片\]](https://img-blog.csdnimg.cn/fe754e2ad0ba4098bf7a2865be0fed1a.png)
底部功能页面栏切换页面（如个人页面切换）
![\[图片\]](https://img-blog.csdnimg.cn/6aed16a4e1fd4d7280dcd05316c3b3eb.png)
WLTYshotVideos2
进入APP后首页展示三个排行榜，电影，综艺，抖音剧集排行榜
![\[图片\]](https://img-blog.csdnimg.cn/3ca1251d5f8149a1a038c25a48bf3085.png)
点击进去排行榜中：（Eg：电影排行榜）
向下滑动可以查看更多排行：
![\[图片\]](https://img-blog.csdnimg.cn/b39ab3afa82b4cc1b3850a8826c36587.png)
# 性能测试
ODM项目为了测试平台稳定性，会下载大量第三方app进行冷、热启动的测试，并生成测试报告。
根据测试结果可用于暴露平台性能上的一些缺陷。
实现：python+adb

测试手机：
1. SM-N9600 ——Samsung Galaxy Note9 （One UI2.5）
Android系统版本：10.0     内核版本： 4.9.186-22986754
![\[图片\]](https://img-blog.csdnimg.cn/017e7ae3ff094fed8ee7d4880978e2e7.png)
五、Demo 演示视频 （必填）
项目实机调试：（实机运行抖音APP的电影排行榜）
![\[图片\]](https://img-blog.csdnimg.cn/2288c024aac74edfb1fb991b25402b0b.png)
![\[图片\]](https://img-blog.csdnimg.cn/7da31310269444c483f6f6f2cb3cbc27.png)
# 项目视频演示地址：https://live.csdn.net/v/234203
项目内容截图： 
![在这里插入图片描述](https://img-blog.csdnimg.cn/7cc2a5ea0d414560bcfda206a6828414.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/7339476dc08341479fdeb52f192f2509.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/6be64c27b5124209b3e59b5c9c8c3256.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a8aee72e0ed34d9b86437d18c33d5a87.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a23512b349a14dcd9df6800b30a86491.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a1497a9415f64eb499fd9647d6c4f2e5.png)
# 项目总结与反思
**目前出现的问题**
1. 排行榜数据接口问题：无法获取抖音剧集和综艺排行榜的数据
2. 排行榜模块需要经过room数据库本地缓存，出现的问题：初次打开时，因为需要数据本地缓存，如果对排行榜刷新过快会出现数据无法接收进而APP闪退（或返回到首页）
3. 对TikTokMin的前端样式还未来及做接口对接（对于Flutter暂未找到对接抖音开放平台的方法）
已识别出的优化项
4. 对于Flutter的TikTokMin优化了图标和字体，使用Tiktok官方图标
![\[图片\]](https://img-blog.csdnimg.cn/05a11e3c01394510a262795c25f7f97e.png)
5. 对WLTYshotVideos2加入RXJava 方便切换线程
6. 将数据进行储存，直接调接口的话次数有限。可以切换数据然后进行数据获取（部分接口已被注释，按需调用）
架构演进的可能性
7. 项目主体使用了MVVM架构：Model-View-ViewModel，但是由于 View 和 ViewModel 解耦，导致 Debug 时难以一眼看出 View 的事件传递；代码复杂性增大， Debug 比较困难；后期可以使用MVI，MVI 模式的改动在于将 View 和 ViewModel 之间的多数据流改为基于 ViewState 的单数据流；
 
