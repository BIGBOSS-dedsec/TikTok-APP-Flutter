import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:tiktok_app/pages/home_page.dart';
import 'package:tiktok_app/pages/messagepage.dart';
import 'package:tiktok_app/theme/colors.dart';
import 'package:tiktok_app/widgets/tik_tok_icons.dart';
import 'package:tiktok_app/widgets/upload_icon.dart';
import 'package:tiktok_app/pages/Me_page.dart';

class RootPage extends StatefulWidget {
  const RootPage({Key? key}) : super(key: key);

  @override
  State<RootPage> createState() => _RootPageState();
}

List bottonItems = [
  {'icon': TikTokIcons.home, 'label': '首页', 'isIcon': true},
  {'icon': TikTokIcons.search, 'label': '发现', 'isIcon': true},
  {'icon': '', 'label': '', 'isIcon': false},
  {'icon': TikTokIcons.heart, 'label': '收件箱', 'isIcon': true},
  {'icon': TikTokIcons.profile, 'label': '个人主页', 'isIcon': true},
];
int pageIndex = 0;

class _RootPageState extends State<RootPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      bottomNavigationBar: getFooter(),
      body: getBody(),
    );
  }

  getBody() {
    return IndexedStack(
      index: pageIndex,
      children: const[
         HomePage(),
        Center(
          child: Text(
            '发现',
            style: TextStyle(
              fontWeight: FontWeight.bold,
              color: black,
              fontSize: 20,
            ),
          ),
        ),
         Center(
          child: Text(
            '添加',
            style: TextStyle(
              fontWeight: FontWeight.bold,
              color: black,
              fontSize: 20,
            ),
          ),
        ),
        MessagePage(),
        MePage(),
      ],
    );
  }

  getFooter() {
    var size = MediaQuery.of(context).size;
    return Container(
      height: 80,
      width: double.infinity,
      decoration: const BoxDecoration(color: appBgColor),
      child: Padding(
        padding: const EdgeInsets.only(left: 20, right: 20, top: 10),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          crossAxisAlignment: CrossAxisAlignment.start,
          children: List.generate(
            bottonItems.length,
            (index) => bottonItems[index]['isIcon']
                ? InkWell(
                    onTap: () {
                      log('$index');
                      selectedIndex(index);
                    },
                    child: Column(
                      children: [
                        Icon(bottonItems[index]['icon'], color: white),
                        const SizedBox(height: 5),
                        Text(
                          bottonItems[index]['label'],
                          style: const TextStyle(fontSize: 10, color: white),
                        ),
                      ],
                    ),
                  )
                : InkWell(
                    onTap: () {
                      print(index);
                      selectedIndex(index);
                    },
                    child: const UploadIcon(),
                  ),
          ),
        ),
      ),
    );
  }

  selectedIndex(index) {
    setState(() {
      pageIndex = index;
    });
  }
}
