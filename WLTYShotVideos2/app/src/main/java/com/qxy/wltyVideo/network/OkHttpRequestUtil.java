package com.qxy.wltyVideo.network;

import android.app.Activity;
import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * OkHttp工具类
 */
public class OkHttpRequestUtil {
    private static final String TAG = "OkHttpRequestUtil";
    private static OkHttpClient client;

    private static final OkHttpRequestUtil okHttpRequestUtil = new OkHttpRequestUtil();

    public static OkHttpRequestUtil getInstance() {
        return okHttpRequestUtil;
    }

    private OkHttpRequestUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> {
            Log.d("HttpLoggingInterceptor", message);
        });
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addNetworkInterceptor(httpLoggingInterceptor)
                .build();
    }

    public interface ICallBack {
        void onResponse(String result);
    }

    /*-------------------------------------------------------------------------------------------------------
    提供给外部调用的方法*/

    /**
     * post方式提交表单（已自动添加personToken）
     *
     * @param activity  Activity
     * @param url       根路径后面的子路径
     * @param map       要发送的数据Map
     * @param iCallBack 请求成功的回调
     */
    public void formPost(Activity activity, String url, Map<String, String> map, final ICallBack iCallBack) {

//        FormBody.Builder builder = new FormBody.Builder();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            builder.add(entry.getKey(), entry.getValue());
//        }
//
//        RequestBody requestBodyPost = builder.build();
//
//
//        okhttp3.Request requestPost = new okhttp3.Request.Builder()
//                .url(Interface.SERVER_ADDRESS + url)
//                .addHeader("Content-Type", "multipart/form-data")
//                .post(requestBodyPost).build();
//        client.newCall(requestPost).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                String message = e != null ? e.getMessage() : "";
//                Log.e(TAG, "onFailure: " + message);
//            }
//
//            @Override
//            public void onResponse(Call call, okhttp3.Response response) throws IOException {
//                String body = response.body().string();
//                Log.e(TAG, "onResponse: body = " + body);
//                requestSuccess(activity, body, iCallBack);
//            }
//        });

        String body = "{\"data\":{\"access_token\":\"clt.e37c397b1c32e38cff37159451a3f57fZWK1Dwck2zcSiCZlCk6Fqe5W5gtx\",\"captcha\":\"\",\"desc_url\":\"\",\"description\":\"\",\"error_code\":0,\"expires_in\":7200,\"log_id\":\"202208112303060102091681600E1B5857\"},\"message\":\"success\"}";
        requestSuccess(activity, body, iCallBack);
    }

    /**
     * get请求
     *
     * @param activity  Activity
     * @param url       根路径后面的子路径
     * @param map       要发送的数据Map
     * @param iCallBack 请求成功的回调
     */
    public void get(Activity activity, String url, Map<String, String> map, final ICallBack iCallBack) {
//        HttpUrl.Builder builder = HttpUrl.parse(Interface.SERVER_ADDRESS + url).newBuilder();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            builder.addQueryParameter(entry.getKey(), entry.getValue());
//        }
//        HttpUrl httpUrl = builder.build();
//
//        okhttp3.Request requestGetParams =
//                new okhttp3.Request.Builder()
//                        .url(httpUrl.toString())
//                        .addHeader("Content-Type", "application/json")
//                        .addHeader("access-token", accesstoken)
//                        .build();
//        client.newCall(requestGetParams).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//                String message = e != null ? e.getMessage() : "";
//                Log.e("TAG", "onFailure: " + message);
//            }
//
//            @Override
//            public void onResponse(Call call, okhttp3.Response response) throws IOException {
//
//                String body = response.body().string();
//                Log.e("TAG", "onResponse: body = " + body);
//                requestSuccess(activity, body, iCallBack);
//            }
//        });
        String body = "{\"data\":{\"active_time\":\"2022-08-09\",\"description\":\"\",\"error_code\":0,\"list\":[{\"actors\":[\"沈腾\",\"马丽\",\"常远\",\"李诚儒\",\"黄才伦\",\"辣目洋子\",\"郝瀚\",\"黄子韬\",\"王成思\",\"高海宝\",\"杨铮\",\"史彭元\",\"张熙然\",\"黄若萌\",\"杨皓宇\"],\"directors\":[\"张吃鱼\"],\"discussion_hot\":3168193,\"hot\":12930828,\"id\":\"6903365126108381703\",\"influence_hot\":940444,\"maoyan_id\":\"1359034\",\"name\":\"独行月球\",\"name_en\":\"Moon Man\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/93204d13cf5a4fb080e74ea6d057eca1?from=552310259\",\"release_date\":\"2022-07-29\",\"search_hot\":1244890,\"topic_hot\":1130843,\"type\":1},{\"actors\":[\"古天乐\",\"刘青云\",\"刘嘉玲\",\"姜皓文\",\"谢君豪\",\"吴倩\",\"万国鹏\",\"张家辉\",\"刘浩良\",\"麦天枢\",\"朱鉴然\",\"程小夏\"],\"areas\":[\"香港\"],\"directors\":[\"吴炫辉\"],\"discussion_hot\":2830724,\"hot\":11594206,\"id\":\"6446787399010746893\",\"influence_hot\":842538,\"maoyan_id\":\"249033\",\"name\":\"明日战记\",\"name_en\":\"Warriors of Future\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/5d9299715de44f1db6645f3466d73173?from=552310259\",\"release_date\":\"2022-08-05\",\"search_hot\":1183265,\"tags\":[\"动作\",\"科幻\"],\"topic_hot\":1007894,\"type\":1},{\"actors\":[\"李汶翰\",\"徐若晗\",\"王博文\",\"高秋梓\",\"柯蓝\",\"苇青\"],\"directors\":[\"落落\"],\"discussion_hot\":2965643,\"hot\":11531889,\"id\":\"7073662696507474446\",\"influence_hot\":874466,\"maoyan_id\":\"1331205\",\"name\":\"遇见你\",\"name_en\":\"Almost Love\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/c2204b96045341ab9c2eaa6c33edeef6?from=552310259\",\"release_date\":\"2022-08-04\",\"search_hot\":1167591,\"topic_hot\":1010902,\"type\":1},{\"actors\":[\"马思纯\",\"王俊凯\",\"范伟\",\"曾美慧孜\",\"李晓川\",\"赵润南\",\"龚蓓苾\",\"黄璐\",\"莫西子诗\",\"曾慕梅\",\"万茜\",\"刘琳\"],\"areas\":[\"中国大陆\"],\"directors\":[\"李玉\"],\"discussion_hot\":2683785,\"hot\":10771133,\"id\":\"6894133081402245639\",\"influence_hot\":854595,\"maoyan_id\":\"1369917\",\"name\":\"断·桥\",\"name_en\":\"The Fallen Bridge\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/ad80a23419ea4e12bc8520378cd8e88a?from=552310259\",\"release_date\":\"2022-08-13\",\"search_hot\":1108810,\"tags\":[\"剧情\"],\"topic_hot\":876648,\"type\":1},{\"actors\":[\"周依然\",\"吴念轩\",\"汤加文\",\"翁楚汉\",\"吴彦姝\",\"张歆艺\",\"袁弘\",\"谢治勋\",\"耿军\",\"詹妮\"],\"directors\":[\"吴家凯\",\"张智鸿\"],\"discussion_hot\":2248480,\"hot\":7821191,\"id\":\"7074839902659183111\",\"influence_hot\":784477,\"maoyan_id\":\"1331600\",\"name\":\"一直一直都很喜欢你\",\"name_en\":\"Love Can't Be Said\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/d1c81cff25824f84a921fd9300c5ca97?from=552310259\",\"release_date\":\"2022-07-22\",\"search_hot\":932981,\"topic_hot\":696874,\"type\":1},{\"actors\":[\"杨凝\",\"李兰陵\",\"刘知否\",\"瞳音\",\"常文涛\",\"佟心竹\",\"山新\",\"李翰林\",\"图特哈蒙\",\"阎么么\",\"王琳熙\"],\"directors\":[\"王云飞\"],\"discussion_hot\":1708731,\"hot\":7569852,\"id\":\"7118672168472281631\",\"influence_hot\":790822,\"maoyan_id\":\"\",\"name\":\"疯了！桂宝之三星夺宝\",\"name_en\":\"CRAZY.KWAI.BOO Sanxingdui Spirited Away\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/078a28d12cae4e3daa3ab6092fe17c56?from=552310259\",\"release_date\":\"2022-07-29\",\"search_hot\":836221,\"topic_hot\":505619,\"type\":1},{\"actors\":[\"黄渤\",\"荣梓杉\",\"姚晨\",\"范伟\",\"贾冰\",\"许君聪\",\"于洋\",\"梅婷\",\"黄觉\",\"李泽宇\",\"范湉湉\"],\"directors\":[\"陈思诚\"],\"discussion_hot\":2512424,\"hot\":7504955,\"id\":\"6898272571448689159\",\"influence_hot\":853292,\"maoyan_id\":\"1357145\",\"name\":\"外太空的莫扎特\",\"name_en\":\"Mozart from Space\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/2333bc223d5a4cc591093f4e893bbf6f?from=552310259\",\"release_date\":\"2022-07-15\",\"search_hot\":955936,\"topic_hot\":803389,\"type\":1},{\"actors\":[\"刘红韵\",\"邓玉婷\",\"严彦子\",\"祖晴\",\"高全胜\",\"苗浩生\",\"李团\",\"申克\",\"胡严彦\",\"李薇薇\"],\"areas\":[\"中国大陆\"],\"directors\":[\"黄伟明\"],\"discussion_hot\":2207345,\"hot\":7197481,\"id\":\"6803949067538792968\",\"influence_hot\":949062,\"maoyan_id\":\"1297952\",\"name\":\"开心超人之英雄的心\",\"name_en\":\"The Stones\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/2c9639d6d5a74b8baa9c888096ffbd43?from=552310259\",\"release_date\":\"2022-07-22\",\"search_hot\":877435,\"tags\":[\"动画\"],\"topic_hot\":596442,\"type\":1},{\"actors\":[\"李孝谦\",\"漆昱辰\",\"林俊毅\",\"修雨秀\",\"许童心\",\"丁冠森\",\"李光洁\",\"周深\",\"沈月\",\"张奕聪\",\"高至霆\",\"孙浩\",\"姜卓君\",\"张熙然\",\"夏子轩\"],\"directors\":[\"王梓骏\"],\"discussion_hot\":1918073,\"hot\":7178392,\"id\":\"7077392575660818980\",\"influence_hot\":0,\"maoyan_id\":\"1310222\",\"name\":\"我们的样子像极了爱情\",\"name_en\":\"Close to Love\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/ec798d50b0bd4053a8436b26d31f0aaa?from=552310259\",\"release_date\":\"2022-08-04\",\"search_hot\":0,\"topic_hot\":676519,\"type\":1},{\"actors\":[\"刘青云\",\"蔡卓妍\",\"林峯\",\"谭凯\",\"陈家乐\",\"汤怡\",\"何珮瑜\",\"李若彤\",\"吴浩康\",\"洪天明\",\"车婉婉\",\"斌子\",\"李菁\",\"马志威\",\"杨天宇\",\"胡子彤\",\"朱鉴然\",\"马睿瀚\"],\"areas\":[\"香港\"],\"directors\":[\"韦家辉\"],\"discussion_hot\":2551101,\"hot\":7025790,\"id\":\"6531972731066384900\",\"influence_hot\":912906,\"maoyan_id\":\"1203439\",\"name\":\"神探大战\",\"name_en\":\"Cold Detective\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/73a0215e0c2d41efb338aa248e6d2978?from=552310259\",\"release_date\":\"2022-07-08\",\"search_hot\":1009582,\"tags\":[\"动作\",\"悬疑\",\"犯罪\"],\"topic_hot\":863519,\"type\":1},{\"actors\":[\"陆双\",\"谢蔚\",\"吉莹\",\"吴海涛\",\"白文显\",\"陈志荣\"],\"directors\":[\"陆锦辉\",\"钟彧\"],\"discussion_hot\":1622530,\"hot\":6992122,\"id\":\"7069703033898140168\",\"influence_hot\":485115,\"maoyan_id\":\"1358119\",\"name\":\"猪猪侠大电影·海洋日记\",\"name_en\":\"GG BOND：Ocean Mission\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/dcef320b1d774b07908a90b7b26a4fdd?from=552310259\",\"release_date\":\"\",\"search_hot\":735654,\"topic_hot\":413764,\"type\":1},{\"actors\":[\"王千源\",\"郭晓东\",\"王迅\",\"许龄月\",\"马渝捷\",\"倪大红\",\"关晓彤\",\"张兆辉\",\"张光北\",\"童蕾\",\"郭晓峰\",\"杨洛仟\"],\"areas\":[\"中国大陆\"],\"directors\":[\"郭晓峰\"],\"discussion_hot\":2555589,\"hot\":6952130,\"id\":\"6858859543187849741\",\"influence_hot\":0,\"maoyan_id\":\"1302480\",\"name\":\"猎屠\",\"name_en\":\"Butcher Hunter\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/a5de28bf4370a36f5e8261f007faee35?from=552310259\",\"release_date\":\"2022-06-03\",\"search_hot\":0,\"topic_hot\":808557,\"type\":1},{\"actors\":[\"张译\"],\"areas\":[\"中国大陆\"],\"directors\":[\"黄健明\"],\"discussion_hot\":2295597,\"hot\":6690659,\"id\":\"6531973976749507076\",\"influence_hot\":0,\"maoyan_id\":\"346331\",\"name\":\"再见怪兽\",\"name_en\":\"\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/8dc89481d0a2332fd56f4c28a5d05c56?from=552310259\",\"release_date\":\"\",\"search_hot\":0,\"tags\":[\"动画\"],\"topic_hot\":695531,\"type\":1},{\"discussion_hot\":1898018,\"hot\":6225832,\"id\":\"7069703142962627080\",\"influence_hot\":0,\"maoyan_id\":\"1439146\",\"name\":\"迷你世界之觉醒\",\"name_en\":\"KAKA\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/d0b5a94a41aa4f8088a63577d1ffbb8e?from=552310259\",\"release_date\":\"\",\"search_hot\":0,\"topic_hot\":221625,\"type\":1},{\"actors\":[\"锦鲤\",\"李岱昆\",\"张磊\",\"阎萌萌\",\"杨凝\",\"晨宁溪\",\"张遥函\",\"齐斯伽\",\"高枫\",\"赵明洲\",\"敖磊\",\"郭政建\"],\"areas\":[\"中国大陆\"],\"directors\":[\"胡一泊\"],\"discussion_hot\":2054020,\"hot\":6136127,\"id\":\"6531988673146126851\",\"influence_hot\":848808,\"maoyan_id\":\"1212472\",\"name\":\"冲出地球\",\"name_en\":\"Rainbow Sea Fly High\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/dcfe0db1f97b47ecb801e1858dd93798?from=552310259\",\"release_date\":\"2022-07-16\",\"search_hot\":909434,\"tags\":[\"科幻\",\"动画\",\"冒险\"],\"topic_hot\":613624,\"type\":1},{\"actors\":[\"倪妮\",\"张鲁一\",\"辛柏青\",\"池松壮亮\",\"中野良子\",\"新音\",\"王佳佳\",\"耐安\",\"毛乐\"],\"directors\":[\"张律\"],\"discussion_hot\":1954008,\"hot\":5587715,\"id\":\"7118672661575959076\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"漫长的告白\",\"name_en\":\"Yanagawa\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/15f516da827b4233a5a9b25be3fa09b9?from=552310259\",\"release_date\":\"2022-08-04\",\"search_hot\":0,\"topic_hot\":422519,\"type\":1},{\"actors\":[\"武仁林\",\"海清\",\"杨光锐\",\"武赟志\",\"李生甫\",\"张敏\",\"赵登平\",\"王彩兰\",\"曾建贵\",\"马占红\",\"王翠兰\",\"续彩霞\"],\"directors\":[\"李睿珺\"],\"discussion_hot\":2076644,\"hot\":5520611,\"id\":\"7065249891530113543\",\"influence_hot\":715029,\"maoyan_id\":\"1336601\",\"name\":\"隐入尘烟\",\"name_en\":\"Return to Dust\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/89b1dda86dfd43ecac9e2e1c22f1a9dd?from=552310259\",\"release_date\":\"2022-07-08\",\"search_hot\":862756,\"tags\":[\"剧情\",\"爱情\"],\"topic_hot\":524863,\"type\":1},{\"actors\":[\"普加·巴哈卢卡\",\"Parth Suri\",\"石天龙\",\"母其弥雅\",\"何椰子\",\"Abhimanyu Sharma\",\"拉兹巴·亚达夫\",\"Ravi Kale\",\"Prateek Parma\"],\"directors\":[\"拉姆·戈帕尔·维马\",\"刘静\"],\"discussion_hot\":1645555,\"hot\":5228258,\"id\":\"7034344828066333215\",\"influence_hot\":660467,\"maoyan_id\":\"1437427\",\"name\":\"龙女孩\",\"name_en\":\"Enter the Girl Dragon\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/22886838135e473183c4a37a33a8105f?from=552310259\",\"release_date\":\"2022-07-15\",\"search_hot\":682842,\"topic_hot\":329156,\"type\":1},{\"actors\":[\"朱一龙\",\"杨恩又\",\"王戈\",\"刘陆\",\"罗京民\",\"吴倩\",\"郑卫莉\",\"陈创\",\"李春嫒\",\"钟宇升\",\"刘亚津\",\"刘浩\",\"韩延\"],\"directors\":[\"刘江江\"],\"discussion_hot\":2543352,\"hot\":5179364,\"id\":\"6966889198838252045\",\"influence_hot\":975107,\"maoyan_id\":\"1397016\",\"name\":\"人生大事\",\"name_en\":\"Lighting Up the Stars\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/e58231caf9eb4e88ab5e5575e493b667?from=552310259\",\"release_date\":\"2022-06-24\",\"search_hot\":1045089,\"topic_hot\":904803,\"type\":1},{\"discussion_hot\":1434490,\"hot\":5138624,\"id\":\"7108554671324660237\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"迷失之城 The Lost City\",\"name_en\":\"The Lost City\",\"poster\":\"\",\"release_date\":\"\",\"search_hot\":0,\"topic_hot\":326266,\"type\":1},{\"actors\":[\"泰莉莎·加拉赫\",\"西蒙·格林诺\",\"迈克尔·墨菲\",\"保罗·潘廷\",\"韦恩·格雷森\",\"罗布·拉克斯特拉夫\",\"Helen Walsh\",\"基思·威克姆\",\"安德烈斯·威廉姆斯\",\"乔·怀亚特\",\"珍妮·约科波里\"],\"directors\":[\"布莱尔·西蒙斯\"],\"discussion_hot\":1539621,\"hot\":4905627,\"id\":\"7094203739543863816\",\"influence_hot\":643758,\"maoyan_id\":\"\",\"name\":\"海底小纵队：洞穴大冒险\",\"name_en\":\"Octonauts and the Caves of Sac Actun\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/04476718610b4bfa9db229ee86064a7d?from=552310259\",\"release_date\":\"2020-07-09\",\"search_hot\":755284,\"topic_hot\":406290,\"type\":1},{\"actors\":[\"马赛\",\"任达华\",\"吴镇宇\",\"洪天明\",\"余香凝\",\"吴澋滔\",\"元华\",\"林恺铃\",\"伍咏诗\",\"胡子彤\",\"徐浩昌\",\"龚慈恩\",\"张达明\",\"张锦程\",\"林雪\",\"刘国昌\"],\"areas\":[\"香港\",\"中国大陆\",\"中国香港\"],\"directors\":[\"杜琪峰\",\"徐克\",\"许鞍华\",\"林岭东\",\"谭家明\",\"洪金宝\",\"袁和平\"],\"discussion_hot\":1393873,\"hot\":4867742,\"id\":\"6446319343134310926\",\"influence_hot\":0,\"maoyan_id\":\"248182\",\"name\":\"七人乐队\",\"name_en\":\"Eight And A Half\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/b1437fe277312c5e18bdf69fe74f2f17?from=552310259\",\"release_date\":\"2022-07-29\",\"search_hot\":0,\"tags\":[\"剧情\",\"历史\"],\"topic_hot\":216269,\"type\":1},{\"actors\":[\"许烈英\",\"王思蓉\",\"刘子涵\"],\"directors\":[\"陶涛\",\"张琪\",\"秦博\",\"范士广\"],\"discussion_hot\":2467132,\"hot\":4595309,\"id\":\"7039325286676038174\",\"influence_hot\":742763,\"maoyan_id\":\"1429716\",\"name\":\"人间世\",\"name_en\":\"Once Upon a Life\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/7930e8b762a44382bc96621a06398952?from=552310259\",\"release_date\":\"\",\"search_hot\":0,\"topic_hot\":173128,\"type\":1},{\"actors\":[\"张译\",\"吴京\",\"李九霄\",\"魏晨\",\"Vladimir Ershov\",\"邱天\",\"周思羽\",\"邓超\",\"欧豪\",\"张承\",\"刘显达\",\"杨轶\",\"齐超\",\"朱梓瑜\",\"刘雨辰\",\"万沛鑫\",\"石昊正\"],\"directors\":[\"管虎\",\"郭帆\",\"路阳\"],\"discussion_hot\":2402064,\"hot\":4237831,\"id\":\"6882965933837517326\",\"influence_hot\":781881,\"maoyan_id\":\"1339160\",\"name\":\"金刚川\",\"name_en\":\"The Sacrifice\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/4c973ee2521487e9e9895cdb87b8824c?from=552310259\",\"release_date\":\"2020-10-23\",\"search_hot\":890053,\"tags\":[\"剧情\",\"战争\"],\"topic_hot\":698297,\"type\":1},{\"actors\":[\"吴京\",\"易烊千玺\",\"段奕宏\",\"张涵予\",\"朱亚文\",\"李晨\",\"韩东君\",\"耿乐\",\"杜淳\",\"胡军\"],\"directors\":[\"陈凯歌\",\"徐克\",\"林超贤\"],\"discussion_hot\":1367357,\"hot\":4043542,\"id\":\"7024141505304625700\",\"influence_hot\":1025840,\"maoyan_id\":\"1446115\",\"name\":\"长津湖之水门桥\",\"name_en\":\"The Battle at Lake Changjin II\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/800a70903eeb44fa9548237ae201d3fb?from=552310259\",\"release_date\":\"2022-02-01\",\"search_hot\":901543,\"tags\":[\"剧情\",\"历史\",\"战争\"],\"topic_hot\":711802,\"type\":1},{\"actors\":[\"易烊千玺\",\"田雨\",\"陈哈琳\",\"齐溪\",\"公磊\",\"许君聪\",\"王宁\",\"黄尧\",\"巩金国\",\"田壮壮\",\"王传君\",\"徐峥\",\"章宇\",\"张志坚\",\"咏梅\",\"杨新鸣\",\"朱俊麟\",\"贾弘逍\",\"陈翊曈\",\"陈哈琳\",\"岳小军\",\"朱俊麟\",\"王丽涵\",\"贾弘逍\",\"韩笑\",\"孙征宇\",\"黄艺馨\",\"修梦迪\",\"苏子航\",\"郑伊倩\",\"丁文博\",\"王一博\",\"白宇\",\"王圣迪\"],\"areas\":[\"中国大陆\"],\"directors\":[\"文牧野\"],\"discussion_hot\":1252864,\"hot\":3861376,\"id\":\"6947574949951308318\",\"influence_hot\":931576,\"maoyan_id\":\"1383307\",\"name\":\"奇迹·笨小孩\",\"name_en\":\"Nice View\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/a25a554fba8742938b14f430c1428929?from=552310259\",\"release_date\":\"2022-02-01\",\"search_hot\":870536,\"tags\":[\"剧情\"],\"topic_hot\":636359,\"type\":1},{\"actors\":[\"陈永胜\",\"章宇\",\"曹操\",\"柯国庆\",\"刘奕铁\",\"黄炎\",\"赵琥成\",\"王梓屹\",\"陈铭杨\",\"王乃训\",\"李汶聪\",\"程泓鑫\",\"张译\",\"林博洋\",\"钱焜\",\"AJ Donnelly\",\"柯南·何裴\",\"凯文·李\",\"勃小龙\"],\"directors\":[\"张艺谋\",\"张末\"],\"discussion_hot\":1130827,\"hot\":3775003,\"id\":\"6951008600240325157\",\"influence_hot\":870179,\"maoyan_id\":\"1367251\",\"name\":\"狙击手\",\"name_en\":\"Snipers\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/04a7512d8f104c01ace497b2c8ba3289?from=552310259\",\"release_date\":\"2022-02-01\",\"search_hot\":1007392,\"tags\":[\"剧情\",\"战争\",\"历史\"],\"topic_hot\":499414,\"type\":1},{\"actors\":[\"吴京\",\"易烊千玺\",\"段奕宏\",\"张涵予\",\"朱亚文\",\"李晨\",\"韩东君\",\"胡军\",\"黄轩\",\"欧豪\",\"史彭元\",\"李岷城\",\"唐国强\",\"杨一威\",\"周小斌\",\"林永健\",\"王宁\",\"刘劲\",\"卢奇\",\"王伍福\",\"耿乐\",\"曹阳\",\"李军\",\"王同辉\",\"艾米\",\"石昊正\",\"许明虎\",\"卢奇\",\"曹阳\",\"李军\",\"郑恺\",\"张国立\"],\"areas\":[\"中国大陆\"],\"directors\":[\"陈凯歌\",\"徐克\",\"林超贤\",\"冯小刚\"],\"discussion_hot\":1607529,\"hot\":3401441,\"id\":\"6455308856976212493\",\"influence_hot\":1025840,\"maoyan_id\":\"257706\",\"name\":\"长津湖\",\"name_en\":\"The Battle at Lake Changjin\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/44e3a92362504154980c603a776c2e6e?from=552310259\",\"release_date\":\"2021-09-30\",\"search_hot\":1030765,\"tags\":[\"剧情\",\"历史\",\"战争\"],\"topic_hot\":849997,\"type\":1},{\"actors\":[\"赵今麦\",\"林一\",\"沈月\",\"汪佳辉\",\"范诗然\",\"张宸逍\"],\"directors\":[\"林孝谦\"],\"discussion_hot\":2162219,\"hot\":3266190,\"id\":\"7069696726600253988\",\"influence_hot\":932486,\"maoyan_id\":\"1336701\",\"name\":\"一周的朋友\",\"name_en\":\"One Week Friends\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/0fce6195ee5d45729dda4da915ea1812?from=552310259\",\"release_date\":\"2022-06-18\",\"search_hot\":929628,\"topic_hot\":637667,\"type\":1},{\"actors\":[\"周冬雨\",\"尹昉\",\"宋小宝\",\"潘斌龙\",\"王景春\",\"赵今麦\",\"黄超\",\"杨斯\",\"黄晓明\",\"宋佳\",\"张航诚\",\"郑罗茜\",\"曾梦雪\",\"付妤舒\",\"李乃文\",\"吴彦姝\",\"赵亮\"],\"directors\":[\"周楠\",\"张弛\",\"田羽生\",\"董越\",\"饶晓志\"],\"discussion_hot\":2031199,\"hot\":3249728,\"id\":\"6970254173996745223\",\"influence_hot\":813680,\"maoyan_id\":\"1410425\",\"name\":\"你是我的春天\",\"name_en\":\"Ode to the Spring\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/08096dc720ac49a4bfb5703d0a9b9bd6?from=552310259\",\"release_date\":\"2022-07-01\",\"search_hot\":809110,\"topic_hot\":575135,\"type\":1}]},\"extra\":{\"logid\":\"202208092329440102081660471708BCDA\",\"now\":1660058984909}}";
//        String body = "{\"data\":{\"active_time\":\"2022-08-11\",\"description\":\"\",\"error_code\":0,\"list\":[{\"actors\":[\"虞书欣\",\"王鹤棣\",\"徐海乔\",\"郭晓婷\",\"张凌赫\",\"李一桐\",\"林柏叡\"],\"directors\":[\"伊峥\",\"钱敬午\"],\"discussion_hot\":0,\"hot\":26673634,\"id\":\"7008348389511430686\",\"influence_hot\":4520649,\"maoyan_id\":\"\",\"name\":\"苍兰诀\",\"name_en\":\"\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/944c7c4c9f1740ecaebc916a47bff9ca?from=552310259\",\"release_date\":\"2022-08-07\",\"search_hot\":22149234,\"topic_hot\":3750,\"type\":2},{\"actors\":[\"杨紫\",\"成毅\",\"张睿\",\"孟子义\",\"朱泳腾\",\"徐恺咛\",\"李欣泽\",\"韩承羽\",\"傅方俊\",\"李彧\",\"朱丽岚\",\"沈晓海\",\"林源\",\"叶晞月\",\"谷雪儿\",\"何中华\",\"侯梦瑶\",\"孙泽源\",\"杨肸子\",\"张芷溪\",\"夏志远\",\"刘萌萌\",\"张天阳\",\"赵文浩\",\"李梦潇\",\"钟祺\",\"王皓轩\",\"刘宇桥\",\"王建新\",\"岳跃利\",\"梁婧娴\",\"谢宁\",\"王靖\",\"张弓\",\"王岗\",\"马敬涵\",\"姜薏柔\",\"王九胜\",\"李昂\",\"张岩\",\"邬靖靖\",\"张墨锡\",\"薛亦伦\",\"王奕珵\",\"程硕男\",\"卢禹豪\",\"郭浩宇\",\"李昶\",\"王景颢\",\"张好杰\",\"黄晶晶\",\"谢治勋\",\"孔祥池\",\"钟小淇\",\"张雨霏\",\"郭伟\",\"颜景瑶\",\"赵芮菡\",\"钟鸣\",\"贺子\",\"周忆丹\",\"荆媚\",\"李栋\",\"苑航铭\",\"周诗淇\",\"刘琪锜\",\"文熙\",\"赵文龙\",\"李东阳\",\"田苗苗\",\"任娜\"],\"directors\":[\"郭虎\",\"任海涛\"],\"discussion_hot\":205687,\"hot\":16175893,\"id\":\"6974601166835909156\",\"influence_hot\":1045677,\"maoyan_id\":\"\",\"name\":\"沉香如屑\",\"name_en\":\"Immortal Samsara\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/18ba805226ff4219b43e9e35314705c6?from=552310259\",\"release_date\":\"2022-07-20\",\"search_hot\":14923143,\"topic_hot\":1384,\"type\":2},{\"actors\":[\"张嘉益\",\"闫妮\",\"赵今麦\",\"郭俊辰\",\"姜冠南\",\"韩沛颖\",\"张樟\",\"刘航宇\",\"张弈聪\",\"胡家华\",\"王文绮\",\"吴璟沐\",\"李传缨\",\"张雯\",\"刘孜\",\"黄曼\",\"田小洁\",\"张晓谦\",\"杨旭\",\"许薇\",\"朱辉\",\"陈羽汐\",\"闫勤\",\"刘贾玺\",\"陈菲儿\",\"郭振迦\",\"王诗晴\",\"李君婕\",\"王丁一\",\"王小伟\",\"李树\",\"胡希凡\",\"杜金泽\",\"王蓉\"],\"areas\":[\"中国大陆\"],\"directors\":[\"李少飞\"],\"discussion_hot\":143041,\"hot\":12723771,\"id\":\"6894891734744957453\",\"influence_hot\":487774,\"maoyan_id\":\"\",\"name\":\"少年派第二部\",\"name_en\":\"\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/6ba68b24873149299233eb9795926383?from=552310259\",\"release_date\":\"2022-07-21\",\"search_hot\":12092239,\"topic_hot\":715,\"type\":2},{\"actors\":[\"雷佳音\",\"张子枫\",\"张新成\",\"王骁\",\"王宥钧\",\"胡连馨\",\"是安\",\"林子烨\",\"傅铂涵\",\"刘琳\",\"王圣迪\",\"耿乐\",\"倪妮\",\"童瑶\",\"万茜\",\"刘佳\",\"秦堰\",\"李传缨\",\"赵达\",\"翟小兴\",\"田雷\",\"来喜\",\"句号\",\"张海宇\",\"彭浩森\"],\"areas\":[\"中国大陆\"],\"directors\":[\"沈严\",\"曹凯\"],\"discussion_hot\":7789,\"hot\":3294586,\"id\":\"6825971568028418573\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"天才基本法\",\"name_en\":\"The Heart of Genius\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/7cd5e3b249fb4acb990e75d54dc51449?from=552310259\",\"release_date\":\"2022-07-22\",\"search_hot\":3286360,\"tags\":[\"剧情\",\"爱情\"],\"topic_hot\":436,\"type\":2},{\"actors\":[\"黄磊\",\"刘奕君\",\"海清\",\"梅婷\",\"李林谦\",\"江鹏\",\"李进荣\",\"韩童生\",\"苏小明\",\"吴彼\",\"田曦薇\",\"刘家袆\"],\"directors\":[\"刘闯\"],\"discussion_hot\":6518,\"hot\":985931,\"id\":\"7085561187370271236\",\"influence_hot\":273370,\"maoyan_id\":\"\",\"name\":\"张卫国的夏天\",\"name_en\":\"\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/0695cfe41bd64242bde5781a5cd3b3dd?from=552310259\",\"release_date\":\"2022-07-18\",\"search_hot\":705796,\"topic_hot\":246,\"type\":2},{\"actors\":[\"赵丽颖\",\"刘威\",\"唐曾\",\"罗晋\",\"曹征\",\"张可盈\",\"张喜前\",\"迟蓬\",\"林思意\",\"刘衍辰\",\"王志飞\",\"冯雷\",\"宋佳伦\",\"陈炜\",\"钱洁\",\"马昕墨\",\"宋元甫\",\"辛鹏\",\"陈炜\",\"冯雷\",\"褚栓忠\",\"姜寒\",\"高晓菲\",\"金顺子\",\"孙渤洋\",\"金铁峰\",\"马羚\",\"吴晓东\",\"刘滢\",\"于子洋\",\"段冉\",\"吴刚\",\"惠英红\"],\"areas\":[\"中国大陆\"],\"directors\":[\"郑晓龙\",\"刘雪松\",\"姚远\"],\"discussion_hot\":5371,\"hot\":487945,\"id\":\"6798438560421642759\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"幸福到万家\",\"name_en\":\"The Story of Xing Fu\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/98403de3ec45414c8eed55521867ec65?from=552310259\",\"release_date\":\"2022-06-29\",\"search_hot\":482538,\"tags\":[\"剧情\"],\"topic_hot\":36,\"type\":2},{\"actors\":[\"江疏影\",\"杨采钰\",\"张佳宁\",\"张慧雯\",\"李浩菲\",\"窦骁\",\"王安宇\",\"经超\",\"张昊唯\",\"曲哲明\",\"罗海琼\",\"于莎莎\",\"王汀\",\"苗洛依\",\"赵思玫\"],\"areas\":[\"中国大陆\"],\"directors\":[\"孔笙\",\"简川訸\"],\"discussion_hot\":0,\"hot\":438331,\"id\":\"6438968925160997378\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"欢乐颂第三部\",\"name_en\":\"Ode to Joy\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/2762fc8dae9f4d238c8ce928343cb91e?from=552310259\",\"release_date\":\"2022-08-11\",\"search_hot\":413840,\"tags\":[\"剧情\",\"爱情\"],\"topic_hot\":24491,\"type\":2},{\"actors\":[\"许凯\",\"钟楚曦\",\"王阳\",\"阮巨\",\"张晨光\",\"洪剑涛\",\"孟阿赛\",\"黑泽\",\"盖雨嘉\",\"马启越\",\"何奉天\",\"程涛\",\"张帆\",\"包贝尔\",\"张馨予\",\"高曙光\",\"何赛飞\",\"陈紫函\",\"吕小品\",\"左金珠\",\"左二龙\",\"韩姝妹\",\"强宇\",\"吴雨峰\",\"威力斯\",\"谭飞\",\"高晟\",\"柏辰\",\"高长远\",\"孙雪宁\"],\"areas\":[\"中国大陆\"],\"directors\":[\"林楠\"],\"discussion_hot\":5140,\"hot\":355150,\"id\":\"6532006716551201294\",\"influence_hot\":1922,\"maoyan_id\":\"\",\"name\":\"迷航昆仑墟\",\"name_en\":\"Lost in the Kunlun Mountains\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/8c0e9508ba7547f4814c429b8f160b8e?from=552310259\",\"release_date\":\"2022-07-27\",\"search_hot\":347998,\"topic_hot\":89,\"type\":2},{\"actors\":[\"辣目洋子\",\"李宏毅\",\"陈欣予\",\"郭丞\",\"陆宇鹏\",\"杨万里\",\"漆培鑫\",\"李博洋\",\"白澍\",\"姚芊羽\",\"王东\",\"李智楠\",\"林一霆\",\"王婉娟\",\"陈梦希\",\"王鹏\",\"韩恩依\",\"邓琦梦\",\"刘佳瑜\",\"门东毅\",\"夏一瑶\",\"韩明\",\"曹成方子\",\"郝燕飞\",\"凌子幂\",\"文明\",\"靳美玲\",\"靳庆玲\",\"张雷\",\"肖天龙\",\"于觐源\",\"张佳宁\",\"施丽杰\"],\"directors\":[\"徐惠康\"],\"discussion_hot\":342,\"hot\":82006,\"id\":\"7111609520375366181\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"我叫刘金凤\",\"name_en\":\"The Legendary Life of Quee Lau\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/2440d40c1d5842398888ad097ebf9807?from=552310259\",\"release_date\":\"2022-06-24\",\"search_hot\":81662,\"topic_hot\":2,\"type\":2},{\"actors\":[\"黄梦莹\",\"任东霖\",\"刘泳希\",\"魏鹏\",\"张宇彤\",\"郑龙\",\"董李无忧\",\"刘六\",\"刘思艺\",\"王唯恩\",\"訾富尔\",\"夏望\",\"台雅雯\",\"陈良\",\"和树标\",\"沈冲\",\"侯析焱\",\"牛犇\",\"王丽云\",\"王侃\",\"周铁\",\"李嘉铭\",\"李相国\",\"常官亭\",\"李雨蔓\",\"常元佳\",\"郝梓萱\",\"李雄\",\"朱翔\"],\"directors\":[\"李相国\"],\"discussion_hot\":315,\"hot\":46984,\"id\":\"7113802255727329822\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"齐丑无艳之破镜重圆\",\"name_en\":\"The Ugly Queen Ⅱ\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/430eff66369f45a0b86a108b99e8fe90?from=552310259\",\"release_date\":\"2022-06-27\",\"search_hot\":46667,\"topic_hot\":1,\"type\":2}]},\"extra\":{\"logid\":\"202208112303320102080371994B1CBE74\",\"now\":1660230212388}}";
//        String body="{\"data\":{\"active_time\":\"2022-08-11\",\"description\":\"\",\"error_code\":0,\"list\":[{\"directors\":[\"吴梦知\"],\"discussion_hot\":9076,\"hot\":1505415,\"id\":\"7099679727127888421\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"乘风破浪第三季\",\"name_en\":\"\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/55a2c5cbfca84c8f8b67dc4d1f8a75e6?from=552310259\",\"release_date\":\"2022-05-20\",\"search_hot\":1496264,\"topic_hot\":75,\"type\":3},{\"directors\":[\"晏吉\"],\"discussion_hot\":4792,\"hot\":1150662,\"id\":\"7117607606499476005\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"密室大逃脱第四季\",\"name_en\":\"Great Escape 4\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/133bdc997e5640dd87d4c865d02a0be2?from=552310259\",\"release_date\":\"2022-07-08\",\"search_hot\":1145846,\"topic_hot\":22,\"type\":3},{\"directors\":[\"左近\"],\"discussion_hot\":65281,\"hot\":772410,\"id\":\"7112821168931308040\",\"influence_hot\":116054,\"maoyan_id\":\"\",\"name\":\"中国说唱巅峰对决\",\"name_en\":\"The Rap of China\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/3c12a6a880a3440c8f6ce92656e05b6c?from=552310259\",\"release_date\":\"2022-06-25\",\"search_hot\":591007,\"topic_hot\":67,\"type\":3},{\"directors\":[\"戴维\",\"张红岩\"],\"discussion_hot\":415,\"hot\":747993,\"id\":\"7106329173978776078\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"怦然心动20岁第二季\",\"name_en\":\"Twinkle Love vol.2\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/c0e91dd681fa4ebfa6060ae2a1b203dc?from=552310259\",\"release_date\":\"2022-06-08\",\"search_hot\":747532,\"topic_hot\":45,\"type\":3},{\"areas\":[\"内地\"],\"directors\":[\"涂涵\",\"曹棋\",\"付家鹏\",\"常玉琴\",\"彭婧\"],\"discussion_hot\":14743,\"hot\":599529,\"id\":\"6778263242243310094\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"快乐大本营 2020\",\"name_en\":\"Happy Camp 2020\",\"poster\":\"https://p9-dy.byteimg.com/obj/compass/d34baaa5323f49699a0f82c8b45031f9?from=552310259\",\"release_date\":\"2020-01-04\",\"search_hot\":546540,\"topic_hot\":38244,\"type\":3},{\"directors\":[\"徐向东\"],\"discussion_hot\":0,\"hot\":465012,\"id\":\"7114948344710955556\",\"influence_hot\":0,\"maoyan_id\":\"\",\"name\":\"蒙面舞王第三季\",\"name_en\":\"\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/65d0d1064ebd40afba3b37120347a249?from=552310259\",\"release_date\":\"2022-07-03\",\"search_hot\":464984,\"topic_hot\":27,\"type\":3},{\"areas\":[\"中国\"],\"directors\":[\"池源\"],\"discussion_hot\":0,\"hot\":451891,\"id\":\"6778263670825681421\",\"influence_hot\":4208,\"maoyan_id\":\"\",\"name\":\"非诚勿扰 2020\",\"name_en\":\"You are the One 2020\",\"poster\":\"https://p3-dy.byteimg.com/obj/compass/f1b8b1ada898620f8e6e4b9f4862e46f?from=552310259\",\"release_date\":\"2020-01-04\",\"search_hot\":405946,\"topic_hot\":41736,\"type\":3},{\"areas\":[\"内地\"],\"directors\":[\"毛豆豆\",\"谭曼\",\"武赟\",\"冯灵慧\",\"刘曦诺\",\"蔡金玲\",\"李子琪\",\"金理\",\"齐雯\",\"龙思淇\"],\"discussion_hot\":3612,\"hot\":209931,\"id\":\"6778633357346472455\",\"influence_hot\":58348,\"maoyan_id\":\"\",\"name\":\"天天向上 2020\",\"name_en\":\"Day Day Up 2020\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/60cb67311a16eaa2ee85ac213b3082ba?from=552310259\",\"release_date\":\"2020-01-05\",\"search_hot\":147789,\"topic_hot\":181,\"type\":3},{\"directors\":[\"刘力辉\"],\"discussion_hot\":0,\"hot\":99554,\"id\":\"7124957750689432077\",\"influence_hot\":12748,\"maoyan_id\":\"\",\"name\":\"中餐厅第六季\",\"name_en\":\"Chinese Restaurant Season 6\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/62eaf9c03c6342e1aaadeac23555c296?from=552310259\",\"release_date\":\"2022-08-12\",\"search_hot\":86805,\"topic_hot\":0,\"type\":3},{\"directors\":[\"陈歆宇\"],\"discussion_hot\":21375,\"hot\":51264,\"id\":\"7116780996275470855\",\"influence_hot\":1400,\"maoyan_id\":\"\",\"name\":\"牧野家族\",\"name_en\":\"Let It Be\",\"poster\":\"https://p1-dy.byteimg.com/obj/compass/9a3ca7f9627745d8ac54aed768eaac34?from=552310259\",\"release_date\":\"2022-07-16\",\"search_hot\":28484,\"topic_hot\":3,\"type\":3}]},\"extra\":{\"logid\":\"202208112352290102081741711D1E8F19\",\"now\":1660233149608}}\n";
                requestSuccess(activity, body, iCallBack);
    }


    private String accesstoken = "clt.943da17996fb5cebfbc70c044c3fc25a57T54DcjT6HNKGqnUdxzy1KcxFnZ";

    public void setAccessToken(String accesstoken) {
        this.accesstoken = accesstoken;
    }


    /**
     * 请求成功后，将获取的数据传递给回调方法
     * 回调方法中的内容直接运行在主线程中
     *
     * @param activity  Activity
     * @param result    JsonResult 拿到的数据
     * @param iCallBack 回调接口
     */
    private static void requestSuccess(Activity activity, final String result, final ICallBack iCallBack) {
        activity.runOnUiThread(() -> {
            if (iCallBack != null) {
                iCallBack.onResponse(result);
            }
        });
    }


}
