// ignore_for_file: file_names

import 'package:cached_network_image/cached_network_image.dart';
import 'package:dio/dio.dart';
import 'package:extended_tabs/extended_tabs.dart';
import 'package:m_loading/m_loading.dart';
import 'package:flutter/material.dart';

class NotePage extends StatelessWidget {
  const NotePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return NotePage1();
  }
}

class NotePage1 extends StatefulWidget {
  NotePage1({Key? key}) : super(key: key);

  @override
  _NotePageState createState() => _NotePageState();
}

//singticker 和autokeepalive会重复
class _NotePageState extends State<NotePage1> {
  ScrollController controller = ScrollController();

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          leading: Icon(
            Icons.adjust,
            color: Colors.black,
            size: 18,
          ),
          actions: [
            Icon(
              Icons.search,
              color: Colors.black,
              size: 18,
            ),
            SizedBox(
              width: 20,
            )
          ],
          primary: true,
          backgroundColor: Colors.white,
          toolbarHeight: 35,
          centerTitle: true,
          bottomOpacity: 0,
          elevation: 0.5,
        ),
        body: ExtendedTabBarView(
          children: [Text('data'), DiscoverPage(), Text('data')],
        ));
  }
}

//expandtab 有 bug singtick 要用provider 提供的 singtick

class DiscoverPage extends StatefulWidget {
  DiscoverPage({Key? key}) : super(key: key);

  @override
  _DiscoverPageState createState() => _DiscoverPageState();
}

class _DiscoverPageState extends State<DiscoverPage>
    with AutomaticKeepAliveClientMixin {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    double screenwidth = MediaQuery.of(context).size.width;
    return Column(
      // mainAxisSize: MainAxisSize.max,
      children: [
        Theme(
          data: ThemeData(
            splashColor: Colors.transparent, // 点击时的水波纹颜色设置为透明
            highlightColor: Colors.transparent, // 点击时的背景高亮颜色设置为透明
          ),
          child: Container(
              padding: EdgeInsets.symmetric(
                horizontal: 0,
              ),
              margin: EdgeInsets.symmetric(vertical: 10),
              )),
        Expanded(
            child: Container(

              // decoration: BoxDecoration(color: Colors.black),
                padding: EdgeInsets.only(
                  left: screenwidth * 0.01,
                  right: screenwidth * 0.01,
                ),
                child: ExtendedTabBarView(children: [
                  MainItem(
                    category: 'recommend',
                  ),
                  MainItem(
                    category: 'music',
                  ),
                  MainItem(
                    category: 'live',
                  ),
                  MainItem(
                    category: 'residence',
                  ),
                  MainItem(
                    category: 'journey',
                  ),
                  MainItem(
                    category: 'science',
                  ),
                  MainItem(
                    category: 'Vlog',
                  ),
                  MainItem(
                    category: 'funny',
                  ),
                  MainItem(
                    category: 'food',
                  ),
                  MainItem(
                    category: 'feeling',
                  )
                ])))
      ],
    );
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}

class cityPage extends StatefulWidget {
  cityPage({Key? key}) : super(key: key);

  @override
  _cityPageState createState() => _cityPageState();
}

class _cityPageState extends State<cityPage>
    with AutomaticKeepAliveClientMixin {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text('成都'),
      ),
    );
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}

class subPage extends StatefulWidget {
  subPage({Key? key}) : super(key: key);

  @override
  _subPageState createState() => _subPageState();
}

class _subPageState extends State<subPage> with AutomaticKeepAliveClientMixin {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Center(
        child: Text('关注'),
      ),
    );
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}

class title extends StatelessWidget {
  const title({Key? key, required this.controller}) : super(key: key);
  final TabController controller;
  @override
  Widget build(BuildContext context) {
    double screenwidth = MediaQuery.of(context).size.width;
    return Container(
        width: 0.5 * screenwidth,
        child: Theme(
          data: ThemeData(
            splashColor: Colors.transparent, // 点击时的水波纹颜色设置为透明
            highlightColor: Colors.transparent, // 点击时的背景高亮颜色设置为透明
          ),
          child: ExtendedTabBar(
            indicatorSize: TabBarIndicatorSize.label,
            indicatorColor: Colors.redAccent,
            controller: controller,
            labelColor: Colors.black,
            tabs: [Text('关注'), Text('发现'), Text('成都')],
            labelStyle: TextStyle(
                color: Colors.black, fontSize: 13, fontWeight: FontWeight.w600),
            unselectedLabelStyle: TextStyle(fontSize: 13),
            unselectedLabelColor: Colors.black45,
          ),
        ));
  }
}

class MainItem extends StatefulWidget {
  MainItem({Key? key, required this.category}) : super(key: key);
  final String category;
  @override
  _MainItemState createState() => _MainItemState();
}

class _MainItemState extends State<MainItem>
    with AutomaticKeepAliveClientMixin {
  List xiaoData = [];
  int key = 1;
  ScrollController controller = ScrollController();
  List newdata = [];

  @override
  void initState() {
    super.initState();
    getData();

    controller.addListener(() {
      if (controller.position.pixels == controller.position.maxScrollExtent) {
        print('加载更多$key');
        getData();
      }
    });
  }

  getData() async {
    Response re =
    await Dio().get('http://101.200.141.108:8080/douyin/test?key=$key');
    print('k是$key');
    key++;
    setState(() {
      // print(re.data);
      xiaoData.addAll(re.data);
      newdata = re.data;
    });
  }

  Widget _loading() {
    if (xiaoData.isNotEmpty) {
      if (newdata.isEmpty) {
        return Container(
          width: 150,
          height: 30,
          alignment: Alignment.center,
          child: Text(
            '没有更多数据了',
            style: TextStyle(fontSize: 12, color: Colors.grey),
          ),
        );
      }
      return Container(
          width: 150,
          height: 30,
          alignment: Alignment.center,
          child: Container(
            width: 50,
            child: BallPulseLoading(
              ballStyle: BallStyle(
                size: 8,
                color: Colors.cyan,
                ballType: BallType.solid,
              ),
            ),
          ));
    } else {
      return Container();
    }
  }

  @override
  // TODO: implement wantKeepAlive
  bool get wantKeepAlive => true;
}


String setData(count) {
  String data;

  if (count >= 10000) {
    print(count);
    double result = count / 10000;
    data = result.toStringAsFixed(1) + 'w';
  } else {
    data = count.toString();
  }

  return data;
}
