# ShortVideoAPP With Flutter
# Project introduction
This project is a very short video APP developed based on the Tiktok API
 
# Project implementation
3.1 Technology selection and related development documents
Technical selection of this project:
**Android and Flutter Mixed development **

Android minimum support compatible version 5.0
Programming languages: **Java, dart**
The front-end uses the framework **Flutter 2.5.0**

Selection reasons: In hybrid development, the framework closest to native development, strong performance, smooth, excellent routing design, excellent animation design, across a variety of platforms, reduce development costs; Supports plugins that can access native system calls
Project API Platform -- Tiktok Open Platform (https://open.douyin.com)
![在这里插入图片描述](https://img-blog.csdnimg.cn/34eb8ab6703e4b8286ddb9eeab50c55f.png)
## Architecture design
### ** Project framework -- mvvm**
The advantage of using the mvvm framework is that the project is loosely coupled and easy to maintain. It's easy to add new features or remove existing ones, testable code, gives good structure to the project, and makes browsing and understanding our code much easier.
![\[图片\]](https://img-blog.csdnimg.cn/4c1ab335e1ee4508b64218a6cf24df47.png)
### ** Network Framework **
**Retrofit + RxJava + OkHttp**
Retrofit takes full advantage of the flexibility of annotations, configured as interfaces for decoupling. It is also very convenient to communicate with the background, and the api interface can be called directly
OkHttp supports HTTP/2, HTTP/2 supports concurrency on a single TCP connection by using multiplexing technology, sending or receiving data by sending multiple requests at once on a connection, supports GZIP, can compress the download volume, response caching can directly avoid repeated requests, and supports the following: Will automatically recover from many common connection problems;
### ** Database Framework **
Room provides SQLite's abstraction layer to allow smooth database access while taking full advantage of SQLite. Compile-time checks, Room verifies every @Query, @Entity, etc. at compile time. It not only checks for syntax problems, but also checks for syntax problems. The presence of a table is also checked, which means there is hardly any risk of runtime errors and less template code is integrated with LiveData;

# ** Project code introduction **
The file directory of this project is as follows:
![**\[图片\]**](https://img-blog.csdnimg.cn/eb5c2a2fe5b948d7b30f4d5c1032d4b8.png)
 
WLTYshotVideos2 
![\[图片\]](https://img-blog.csdnimg.cn/20516cc8e52d40db80beea80c73242cf.png)
![\[图片\]](https://img-blog.csdnimg.cn/18865eb38ba14c538481958e4da29440.png)
### Interface acquisition part
![\[图片\]](https://img-blog.csdnimg.cn/dfd708827cce49118a50764cbf33ea44.png)
# Test Results
It is recommended to analyze from functional test and performance test, in which functional test supplements test cases, performance test supplements performance analysis report, and optimization points.
Functional testing
TikTokMin
When TikTokMin enters, play the video, click Pause, and swipe up and down to switch videos
![\[图片\]](https://img-blog.csdnimg.cn/fe754e2ad0ba4098bf7a2865be0fed1a.png)
Bottom function page bar switch page (such as personal page switch)
![\[图片\]](https://img-blog.csdnimg.cn/6aed16a4e1fd4d7280dcd05316c3b3eb.png)
WLTYshotVideos2
After entering the APP, the home page displays three rankings, including the ranking of movies, variety shows and Tiktok series
![\[图片\]](https://img-blog.csdnimg.cn/3ca1251d5f8149a1a038c25a48bf3085.png)
Click into the leaderboard: (Eg: Movie Leaderboard)
Swipe down to see more rankings:
![\[图片\]](https://img-blog.csdnimg.cn/b39ab3afa82b4cc1b3850a8826c36587.png)
# Performance test
In order to test the stability of the platform, the ODM project will download a large number of third-party apps for cold and hot startup tests and generate test reports.
The test results can be used to expose some flaws in platform performance.
Implementation: python+adb

Test phone:
1. SM-N9600 -- Samsung Galaxy Note9 (One UI2.5)
Android OS version: 10.0 Kernel version: 4.9.186-22986754
![\[图片\]](https://img-blog.csdnimg.cn/017e7ae3ff094fed8ee7d4880978e2e7.png)
5. Demo Demo Video
Project real machine debugging: (real machine running Tiktok APP movie ranking)
![\[图片\]](https://img-blog.csdnimg.cn/2288c024aac74edfb1fb991b25402b0b.png)
![\[图片\]](https://img-blog.csdnimg.cn/7da31310269444c483f6f6f2cb3cbc27.png)
# project video demo address: https://live.csdn.net/v/234203
Screenshot of project content:
![在这里插入图片描述](https://img-blog.csdnimg.cn/7cc2a5ea0d414560bcfda206a6828414.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/7339476dc08341479fdeb52f192f2509.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/6be64c27b5124209b3e59b5c9c8c3256.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a8aee72e0ed34d9b86437d18c33d5a87.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a23512b349a14dcd9df6800b30a86491.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/a1497a9415f64eb499fd9647d6c4f2e5.png)

