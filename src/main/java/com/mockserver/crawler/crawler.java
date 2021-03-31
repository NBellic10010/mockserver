package com.mockserver.crawler;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.mockserver.utils.RandomString;

import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;

public class crawler {
    private static final int TIME_OUT = 5000;
    public static final String YIKE = "yike";
    private static final String appKey = "go_galaxy";
    private static final String appSecret = "4UAtIOuo!zultEz0";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    @Autowired
    private CloseableHttpClient httpClient;

    public static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (byte aByte : bytes) {
            buf.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[aByte & 0x0f]);
        }
        return buf.toString();
    }
    public static void setHeader(HttpRequestBase httpGet) throws Exception {
        Random random = new Random();
        Date now = new Date();
        long curTime = now.getTime();
        String nonce = RandomString.randomString(RandomString.ALL_CHAR, 12);
        String value = appSecret + nonce + curTime;

        MessageDigest messageDigest = MessageDigest.getInstance("sha1");
        messageDigest.update(value.getBytes());
        String checkSum = getFormattedText(messageDigest.digest());

        httpGet.addHeader("AppKey", appKey);
        httpGet.addHeader("Nonce", nonce);
        httpGet.addHeader("CurTime", String.valueOf(curTime));
        httpGet.addHeader("CheckSum", checkSum);
    }
    private String sendRequest(HttpGet httpGet) throws Exception {
        RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(TIME_OUT).setSocketTimeout(TIME_OUT).setConnectTimeout(TIME_OUT).build();
        String result = "";
        setHeader(httpGet);
        httpGet.setConfig(config);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        HttpGet httpGet = new HttpGet("https://api.yikeweiqi.com/open/golive/66144");
        crawler c = new crawler();
        c.sendRequest(httpGet);
    }
}
