package su.goday.goday.API;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GoDayRequestAPI {
    public static String RegistrationNewUser(String uri, JSONObject body) {
        String json_result = "";
        HttpClient client = new DefaultHttpClient();
        HttpPut request = new HttpPut(uri);
        HttpResponse response;

        try {
            request.addHeader("content-type", "application/json");
            System.out.println(body.toString());
            StringEntity stringEntity = new StringEntity(body.toString());
            request.setEntity(stringEntity);

            response = client.execute(request);
            json_result = (EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
            json_result = "{\"message\":\"Server Offline\"}";
            return getMessage(json_result);
        }
        return getMessage(json_result);
    }

    public static String SingIn(String uri, JSONObject body) {
        String json_result = "";
        HttpClient client = new DefaultHttpClient();
        HttpPost request = new HttpPost(uri);
        HttpResponse response;

        try {
            request.addHeader("content-type", "application/json");
            System.out.println(body.toString());
            StringEntity stringEntity = new StringEntity(body.toString());
            request.setEntity(stringEntity);

            response = client.execute(request);
            json_result = (EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
            json_result = "{\"message\":\"Server Offline\"}";
            return getMessage(json_result);
        }
        return getMessage(json_result);
    }

    public static String getMessage(String result) {
        String message = result.substring(result.indexOf("message\":\""));
        message = message.substring(10);
        message = message.substring(0, message.indexOf("\""));
        return message;
    }
}