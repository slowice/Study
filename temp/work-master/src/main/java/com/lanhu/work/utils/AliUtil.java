package com.lanhu.work.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;



public class AliUtil {
	
  public static String request(String host, Map<String, Object> params, String secret) throws Exception {
        String params_string = "";
        List sortedKeys = new ArrayList(params.keySet());
        Collections.sort(sortedKeys);
        for (Object key : sortedKeys) {
            params_string += URLEncoder.encode(String.valueOf(key), "UTF-8") + "=" + URLEncoder.encode(String.valueOf(params.get(key)), "UTF-8") + "&";
        }
        String request = host + "/?" + params_string + "Signature=" + sign("GET", params, secret + "&");
        return request;
    }
    //构造签名
    private static String sign(String method, Map<String, Object> params, String secret) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException  {
        String query_string = "";
        List sortedKeys = new ArrayList(params.keySet());
        Collections.sort(sortedKeys);
        for (Object key : sortedKeys) {
            query_string += '&' + popEncode(String.valueOf(key)) + '=' + popEncode(String.valueOf(params.get(key)));
        }
        String sign_to_string = method + "&%2F&" + popEncode(query_string.substring(1, query_string.length()));
        Mac e = Mac.getInstance("HmacSHA1");
        e.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA1"));
        byte[] signData = e.doFinal(sign_to_string.getBytes("UTF-8"));
        return Encodes.encodeBase64(signData);
    }
    //pop网管urlEncode
    private static String popEncode(String value) throws UnsupportedEncodingException {
        return value != null ? URLEncoder.encode(value, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~") : null;
    }
    
    
    public static String formatTimestamp() {
    	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd'T'hh:mm:ss'Z'");
        sdf.setTimeZone(new SimpleTimeZone(0, "GMT"));
        String timestamp = sdf.format(new Date());
        return timestamp;
    }

}
