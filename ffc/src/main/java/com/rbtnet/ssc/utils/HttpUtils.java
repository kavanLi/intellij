package com.rbtnet.ssc.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 1136009436@qq.com
 */
public class HttpUtils {

    HttpClient client;

    public HttpUtils() {
        client = HttpClients.createDefault();
    }

    public HttpClient getClient() {
        return client;
    }

    public String post(String url, Map <String, String> params) throws IOException {
        HttpPost post = new HttpPost(url);

        List <NameValuePair> datas = new ArrayList <NameValuePair>();

        for (Map.Entry <String, String> p : params.entrySet()) {
            datas.add(new BasicNameValuePair(p.getKey(), p.getValue()));
        }

        if (datas.size() > 0) {
            post.setEntity(new UrlEncodedFormEntity(datas));
        }

        HttpResponse response = getClient().execute(post);

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            throw new RuntimeException("该地址请求失败");
        }
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public String get(String url) throws IOException {
        HttpGet post = new HttpGet(url);
        HttpResponse response = getClient().execute(post);

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            throw new RuntimeException("该地址请求失败");
        }
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public boolean download(String url, FileOutputStream fileOutputStream) {
        boolean ret = false;
        HttpGet get = new HttpGet(url);
        HttpResponse response;
        try {
            response = getClient().execute(get);//获取验证码
            response.getEntity().writeTo(fileOutputStream);

            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
