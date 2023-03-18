package io.renren.util;

import cn.hutool.http.HttpUtil;
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送工具类
 */
public class SmsUtils {

    public static final String HOST = "http://dfsmsv2.market.alicloudapi.com";

    public static final String PATH = "/data/send_sms_v2";

    public static final String METHOD = "POST";

    public static final String APP_CODE = "944eda7942984eb68f9e6bf49aa09c6c";





    public static void send(String context,String phone){
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + APP_CODE);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:"+context);
        bodys.put("phone_number", phone);
        bodys.put("template_id", "TPL_0000");


        try {

            HttpResponse response = HttpUtils.doPost(HOST, PATH, METHOD, headers, querys, bodys);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
