// ignore_for_file: file_names
import 'package:flutter/material.dart';
import 'package:tiktok_app/pages/profiletab_1.dart';
import 'package:tiktok_app/pages/profiletab_2.dart';
import 'package:tiktok_app/pages/profiletab_3.dart';

class MePage extends StatefulWidget {
  const MePage({Key? key}) : super(key: key);
  @override
  State<MePage> createState() => _MePageState();
}

class _MePageState extends State<MePage>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;
  @override
  void dispose() {
    super.dispose();
    _tabController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
      appBar: AppBar(
        title: const Text('Asoul_Offcical',style: TextStyle(color: Colors.black)),
        backgroundColor: Colors.transparent,
        elevation: 0,
        leading: const Icon(Icons.person_add,color: Colors.black),
        actions: const [
          Padding(padding: EdgeInsets.only(right: 20.0),
          child: Icon(
            Icons.menu,
            color: Colors.black,
            ),
          ),
        ],
      ),
      backgroundColor: Colors.white,
      body: Column(
        children: [
          Container(
            height: 120,
            width: 120,
            decoration: BoxDecoration(
                shape: BoxShape.circle,
                image: DecorationImage(
                    image: NetworkImage('https://i2.hdslb.com/bfs/face/43b21998da8e7e210340333f46d4e2ae7ec046eb.jpg@240w_240h_1c_1s.jpg'), fit: BoxFit.cover),
            ),
          ),

          const Padding(
              padding: EdgeInsets.all(15.0),
            child: Text('@Asoul_Offcical',
              style: TextStyle(color: Colors.black, fontSize: 20),
            ),
          ),



          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Expanded(
                child: Container(
                  alignment: Alignment.centerRight,
                  child: Column(
                    children: const [
                      Text(
                        '5',
                        style: TextStyle(
                            color: Colors.black,
                            fontWeight: FontWeight.bold,
                            fontSize: 20 ),
                      ),
                      SizedBox(
                        height: 5,
                      ),
                      Text(
                        '关注中',
                        style: TextStyle(
                            color: Colors.grey ),
                      ),
                    ],
                  ),
                ),
              ),
              Expanded(child: Container(
                child: Column(
                  children: const [
                    Text(
                      '68.9k',
                      style: TextStyle(
                          color: Colors.black,
                          fontWeight: FontWeight.bold,
                          fontSize: 20 ),
                    ),
                    SizedBox(
                      height: 5,
                    ),
                    Text(
                      '粉丝',
                      style: TextStyle(
                          color: Colors.grey ),
                    ),
                  ],
                ),
              ),
              ),
              Expanded(child: Container(
                alignment: Alignment.centerLeft,
                child: Column(
                  children: const [
                    Text(
                      '4.8k',
                      style: TextStyle(
                          color: Colors.black,
                          fontWeight: FontWeight.bold,
                          fontSize: 20 ),
                    ),
                    SizedBox(
                      height: 5,
                    ),
                    Text(
                      '喜欢',
                      style: TextStyle(
                          color: Colors.grey ),
                    ),
                  ],
                ),
              )),
            ],
          ),
          const SizedBox(height: 10,),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                padding: const EdgeInsets.symmetric(vertical: 15,horizontal: 40),
                child:
                const Text('编辑个人信息',style: TextStyle(color: Colors.black,fontSize: 18),),
                decoration: BoxDecoration(
                  border: Border.all(color: Colors.grey.shade300),
                  borderRadius: BorderRadius.circular(5)),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(horizontal: 4.0),
                child: Container(
                  padding: const EdgeInsets.all(15),
                  child:Icon(
                    Icons.camera_alt,
                    color: Colors.grey[800],
                  ),
                  decoration: BoxDecoration(
                      border: Border.all(color: Colors.grey.shade300),
                      borderRadius: BorderRadius.circular(5)),
                ),
              ),
              Container(
                padding: const EdgeInsets.all(15),
                child: Icon(
                  Icons.bookmark_border,
                  color: Colors.grey[800],
                ),
                decoration: BoxDecoration(
                    border: Border.all(color: Colors.grey.shade300),
                    borderRadius: BorderRadius.circular(5)),
              ),

          ],),
          const SizedBox(height: 15,),

          Text(
            '我的视频',
            style: TextStyle(color: Colors.grey[700]),
          ),

          const TabBar(
              tabs: [
                Tab(
                  icon: Icon(Icons.grid_3x3,color: Colors.black,),
                ),
                Tab(
                  icon: Icon(Icons.favorite,color: Colors.black,),
                ),
                Tab(
                  icon: Icon(Icons.lock_outline_rounded,color: Colors.black,),
                ),
              ],
            ),

          const Expanded(
              child: TabBarView(
                children: [
                  FirstTab(),
                  SecondTab(),
                  ThirdTab(),
                ],
              )
          ),
        ],
      ),
      ),
    );
  }
}