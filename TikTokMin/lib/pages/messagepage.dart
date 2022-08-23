import 'package:flutter/material.dart';

class MessagePage extends StatelessWidget {
  const MessagePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    print('消息');
    double screenWidth = MediaQuery.of(context).size.width;
    return Scaffold(
      backgroundColor: Colors.transparent,
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        actions: [
          Container(
            alignment: Alignment.center,
            padding: EdgeInsets.only(right: 10),
            child: Icon(
              Icons.camera_alt,
              color: Colors.grey[800],
            ),
          )
        ],
        title: const Text(
          '所有动态',
          style: TextStyle(color:Colors.black, fontSize: 15),
        ),
        centerTitle: true,
      ),
      body: CustomScrollView(
        physics: ClampingScrollPhysics(),
        slivers: <Widget>[
          SliverToBoxAdapter(
            child: Container(
              alignment: Alignment.center,
              width: screenWidth,
              padding: EdgeInsets.symmetric(horizontal: 10),
              child: Container(
                width: screenWidth - 20,
                height: 35,
                padding: EdgeInsets.only(left: 10),
                decoration: BoxDecoration(
                    color: Colors.grey[400]!.withOpacity(0.2),
                    borderRadius: BorderRadius.circular(3)),
                child: TextField(
                  keyboardType: TextInputType.text,
                  decoration: InputDecoration(
                    hintText: '搜索',
                    hintStyle: TextStyle(color: Colors.grey, fontSize: 13),
                  ),
                ),
              ),
            ),
          ),
          SliverToBoxAdapter(
            child: Container(
              padding: EdgeInsets.symmetric(horizontal: 5, vertical: 10),
              margin: EdgeInsets.only(top: 10),
              decoration: const BoxDecoration(
                  border: Border.symmetric(
                      horizontal:
                      BorderSide(width: 0.5, color: Colors.grey))),
              child: SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                primary: true,
                child: Row(
                  children: [
                    Container(
                      alignment: Alignment.center,
                      width: 60,
                      height: 75,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: const [
                          SizedBox(
                            height: 50,
                            width: 50,
                            child: CircleAvatar(
                              backgroundImage: NetworkImage(
                                'https://i2.hdslb.com/bfs/face/43b21998da8e7e210340333f46d4e2ae7ec046eb.jpg@240w_240h_1c_1s.jpg',
                              ),
                            ),
                          ),
                          Text(
                            'ASOUL_Offcical',
                            style: TextStyle(color: Colors.grey, fontSize: 11),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          )
                        ],
                      ),
                    ),
                    Container(
                      alignment: Alignment.center,
                      width: 60,
                      height: 75,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: const [
                          SizedBox(
                            height: 50,
                            width: 50,
                            child: CircleAvatar(
                              backgroundImage: NetworkImage(
                                'https://i0.hdslb.com/bfs/face/8895c87082beba1355ea4bc7f91f2786ef49e354.jpg@240w_240h_1c_1s.jpg',
                              ),
                            ),
                          ),
                          Text(
                            '乃琳Queen',
                            style: TextStyle(color: Colors.grey, fontSize: 11),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          )
                        ],
                      ),
                    ),
                    Container(
                      alignment: Alignment.center,
                      width: 60,
                      height: 75,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: const [
                          SizedBox(
                            height: 50,
                            width: 50,
                            child: CircleAvatar(
                              backgroundImage: NetworkImage(
                                'https://i2.hdslb.com/bfs/face/a7fea00016a8d3ffb015b6ed8647cc3ed89cbc63.jpg@240w_240h_1c_1s.jpg',
                              ),
                            ),
                          ),
                          Text(
                            '珈乐Carol',
                            style: TextStyle(color: Colors.grey, fontSize: 11),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          )
                        ],
                      ),
                    ),
                    Container(
                      alignment: Alignment.center,
                      width: 60,
                      height: 75,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: const [
                          SizedBox(
                            height: 50,
                            width: 50,
                            child: CircleAvatar(
                              backgroundImage: NetworkImage(
                                'https://i1.hdslb.com/bfs/face/668af440f8a8065743d3fa79cfa8f017905d0065.jpg@240w_240h_1c_1s.jpg',
                              ),
                            ),
                          ),
                          Text(
                            '贝拉Kira',
                            style: TextStyle(color: Colors.grey, fontSize: 11),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          )
                        ],
                      ),
                    ),
                    Container(
                      alignment: Alignment.center,
                      width: 60,
                      height: 75,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: const [
                          SizedBox(
                            height: 50,
                            width: 50,
                            child: CircleAvatar(
                              backgroundImage: NetworkImage(
                                'https://i2.hdslb.com/bfs/face/d399d6f5cf7943a996ae96999ba3e6ae2a2988de.jpg@240w_240h_1c_1s.jpg',
                              ),
                            ),
                          ),
                          Text(
                            '嘉然今天吃什么',
                            style: TextStyle(color: Colors.grey, fontSize: 11),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          )
                        ],
                      ),
                    ),
                    Container(
                      alignment: Alignment.center,
                      width: 60,
                      height: 75,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: const [
                          SizedBox(
                            height: 50,
                            width: 50,
                            child: CircleAvatar(
                              backgroundImage: NetworkImage(
                                'https://i0.hdslb.com/bfs/face/566078c52b408571d8ae5e3bcdf57b2283024c27.jpg@240w_240h_1c_1s.jpg',
                              ),
                            ),
                          ),
                          Text(
                            '向晚大魔王',
                            style: TextStyle(color: Colors.grey, fontSize: 11),
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                          )
                        ],
                      ),
                    ),
                  ],
                ),
              ),
            ),
          ),
          SliverToBoxAdapter(
            child: messageList(),
          )
        ],
      ),
    );
  }
}

class messageList extends StatefulWidget {
  const messageList({Key? key}) : super(key: key);

  @override
  _messageListState createState() => _messageListState();
}

class _messageListState extends State<messageList> {
  @override
  Widget build(BuildContext context) {
    List m = ['1', '2', '3', '4'];
    return ListView.builder(
      physics: const NeverScrollableScrollPhysics(),
      shrinkWrap: true,
      itemCount: m.length,
      // itemExtent: 60,
      itemBuilder: (BuildContext context, int index) {
        return Column(
          children: [
            const ListTile(
                leading: CircleAvatar(
                  backgroundImage: NetworkImage(
                      'https://i2.hdslb.com/bfs/face/43b21998da8e7e210340333f46d4e2ae7ec046eb.jpg@240w_240h_1c_1s.jpg'),
                ),
                title: Text(
                  'ASOUL_Offcical',
                  style: TextStyle(color: Colors.white, fontSize: 12),
                ),
                subtitle: Text('8分钟内在线',
                    style: TextStyle(color: Colors.grey, fontSize: 11)),
                trailing: Icon(
                  Icons.arrow_forward_ios,
                  color: Colors.grey,
                  size: 13,
                )),
            Divider(
              height: 1,
              color: Colors.grey[850]!.withOpacity(0.5),
            )
          ],
        );
      },
    );
  }
}
