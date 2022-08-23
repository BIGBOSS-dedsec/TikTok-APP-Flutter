import 'package:flutter/material.dart';
import 'package:tiktok_app/constants/data_json.dart';
import 'package:tiktok_app/theme/colors.dart';
import 'package:tiktok_app/widgets/tik_tok_icons.dart';
import 'package:video_player/video_player.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage>
    with SingleTickerProviderStateMixin {
  late TabController _tabController;

  @override
  void initState() {
    super.initState();
    _tabController = TabController(length: items.length, vsync: this);
  }

  @override
  void dispose() {
    super.dispose();
    _tabController.dispose();
  }

  getBody() {
    var size = MediaQuery.of(context).size;
    return RotatedBox(
      quarterTurns: 1,
      child: TabBarView(
        controller: _tabController,
        children: List.generate(
          items.length,
          (index) => RotatedBox(
            quarterTurns: -1,
            child: VideoPlayeItems(
              size: size,
              name: items[index]['name'],
              videoUrl: items[index]['videoUrl'],
              caption: items[index]['caption'],
              songName: items[index]['songName'],
              albumImg: items[index]['albumImg'],
              comments: items[index]['comments'],
              likes: items[index]['likes'],
              shares: items[index]['shares'],
              profileImg: items[index]['profileImg'],
            ),
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return getBody();
  }
}

class VideoPlayeItems extends StatefulWidget {
  const VideoPlayeItems({
    Key? key,
    required this.size,
    required this.name,
    required this.caption,
    required this.songName,
    required this.albumImg,
    required this.comments,
    required this.likes,
    required this.shares,
    required this.profileImg,
    required this.videoUrl,
  }) : super(key: key);

  final Size size;
  final String name;
  final String caption;
  final String videoUrl;
  final String songName;
  final String albumImg;
  final String comments;
  final String likes;
  final String shares;
  final String profileImg;

  @override
  State<VideoPlayeItems> createState() => _VideoPlayeItemsState();
}

class _VideoPlayeItemsState extends State<VideoPlayeItems>
    with SingleTickerProviderStateMixin {
  late VideoPlayerController _videoPlayerController;
  bool isShowingPlaying = false;

  @override
  void initState() {
    super.initState();
    _videoPlayerController = VideoPlayerController.asset(widget.videoUrl)
      ..initialize().then((value) {
        _videoPlayerController.play();
        setState(() {
          isShowingPlaying = false;
        });
      });
  }

  @override
  void dispose() {
    super.dispose();
    _videoPlayerController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        setState(() {
          _videoPlayerController.value.isPlaying
              ? _videoPlayerController.pause()
              : _videoPlayerController.play();
        });
      },
      child: SizedBox(
        width: widget.size.width,
        height: widget.size.height,
        child: Stack(
          children: [
            SizedBox(
                width: widget.size.width,
                height: widget.size.height,
                child: Stack(
                  children: [
                    VideoPlayer(_videoPlayerController),
                    _videoPlayerController.value.isPlaying
                        ? const SizedBox()
                        : Center(
                            child: Icon(
                            Icons.play_arrow,
                            size: 88,
                            color: white.withOpacity(.5),
                          ))
                  ],
                )),
            SizedBox(
              width: widget.size.width,
              height: widget.size.height,
              child: SafeArea(
                child: Padding(
                  padding: const EdgeInsets.only(
                    left: 15,
                    right: 15,
                    top: 25,
                    bottom: 10,
                  ),
                  child: Column(
                    children: [
                      const HeaderHomePage(),
                      Flexible(
                        child: Row(
                          children: [
                            LeftPanel(
                              size: widget.size,
                              name: widget.name,
                              caprion: widget.caption,
                              songName: widget.songName,
                            ),
                            RightPanel(
                                size: widget.size,
                                albumImg: widget.albumImg,
                                comments: widget.comments,
                                likes: widget.likes,
                                shares: widget.shares,
                                profileImg: widget.profileImg),
                          ],
                        ),
                      )
                    ],
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class RightPanel extends StatelessWidget {
  const RightPanel({
    Key? key,
    required this.size,
    required this.profileImg,
    required this.likes,
    required this.comments,
    required this.shares,
    required this.albumImg,
  }) : super(key: key);

  final Size size;
  final String profileImg;
  final String likes;
  final String comments;
  final String shares;
  final String albumImg;

  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: SizedBox(
        height: size.height,
        child: Column(
          children: [
            Container(
              height: size.height * 0.3,
            ),
            Expanded(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  getProfile(
                    profileImg: profileImg,
                  ),
                  getIcon(
                    icon: TikTokIcons.heart,
                    count: likes,
                    size: 35,
                  ),
                  getIcon(
                    icon: TikTokIcons.chat_bubble,
                    count: comments,
                    size: 35,
                  ),
                  getIcon(
                    icon: TikTokIcons.reply,
                    count: shares,
                    size: 25,
                  ),
                  getAlbum(
                    albumImg: albumImg,
                  )
                ],
              ),
            )
          ],
        ),
      ),
    );
  }

  getAlbum({albumImg}) {
    return Container(
      width: 55,
      height: 55,
      child: Stack(
        children: [
          Container(
            width: 55,
            height: 55,
            decoration: BoxDecoration(shape: BoxShape.circle, color: black),
          ),
          Center(
            child: Container(
              width: 30,
              height: 30,
              decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  image: DecorationImage(
                      image: NetworkImage(albumImg), fit: BoxFit.cover)),
            ),
          ),
        ],
      ),
    );
  }

  getIcon({icon, double? size, count}) {
    return Column(
      children: [
        Icon(
          icon,
          color: white,
          size: size,
        ),
        const SizedBox(height: 5),
        Text(
          count,
          style: const TextStyle(fontWeight: FontWeight.w500, color: white),
        )
      ],
    );
  }

  getProfile({profileImg}) {
    return SizedBox(
      width: 55,
      height: 55,
      child: Stack(
        clipBehavior: Clip.none,
        children: [
          Container(
            width: 50,
            height: 50,
            decoration: BoxDecoration(
                shape: BoxShape.circle,
                border: Border.all(color: white),
                image: DecorationImage(
                    image: NetworkImage(profileImg), fit: BoxFit.cover)),
          ),
          Positioned(
              left: 18,
              bottom: -5,
              child: Container(
                width: 20,
                height: 20,
                // alignment: Alignment.center,
                decoration: const BoxDecoration(
                  color: primary,
                  shape: BoxShape.circle,
                ),
                child: Center(
                    child: Icon(
                  Icons.add,
                  color: white,
                  size: 15,
                )),
              ))
        ],
      ),
    );
  }
}

class LeftPanel extends StatelessWidget {
  const LeftPanel({
    Key? key,
    required this.size,
    required this.name,
    required this.caprion,
    required this.songName,
  }) : super(key: key);

  final Size size;
  final String name;
  final String caprion;
  final String songName;

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      //  height: 100,
      height: size.height,
      width: size.width * 0.78,
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          Text(
            name,
            style: const TextStyle(color: white),
          ),
          const SizedBox(height: 10),
          Text(
            caprion,
            style: const TextStyle(color: white),
          ),
          const SizedBox(height: 10),
          Row(
            children: [
              const Icon(
                Icons.music_note,
                color: white,
                size: 15,
              ),
              Text(
                songName,
                style: const TextStyle(
                  color: white,
                  fontSize: 12,
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}

class HeaderHomePage extends StatelessWidget {
  const HeaderHomePage({
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          '已关注',
          style: TextStyle(
            fontSize: 16,
            color: white.withOpacity(.5),
          ),
        ),
        const SizedBox(width: 5),
        Text(
          '|',
          style: TextStyle(
            fontSize: 16,
            color: white.withOpacity(.3),
          ),
        ),
        const SizedBox(width: 5),
        const Text(
          '推荐',
          style: TextStyle(
              fontSize: 17, color: white, fontWeight: FontWeight.bold),
        ),
      ],
    );
  }
}
