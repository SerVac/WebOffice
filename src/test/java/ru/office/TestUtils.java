package ru.office;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.assertj.core.util.Lists;

import java.io.IOException;
import java.util.List;

public class TestUtils {

    public static HttpClient client;

    static {
        Header contentTypeHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        Header acceptHeader = new BasicHeader(HttpHeaders.ACCEPT, "application/json");
        List<Header> headers = Lists.newArrayList(contentTypeHeader, acceptHeader);
        client = HttpClients.custom()
                .setDefaultHeaders(headers)
                .build();
    }

    public static HttpResponse httpGet(String pathUrl) throws IOException {
        HttpUriRequest request = RequestBuilder.get(pathUrl).build();
        return client.execute(request);
    }

    public static HttpResponse httpDelete(String pathUrl) throws IOException {
        HttpUriRequest request = RequestBuilder.delete(pathUrl).build();
        return client.execute(request);
    }

    public static HttpResponse httpPut(String pathUrl, String jsonPayload) throws IOException {
        StringEntity entity = new StringEntity(jsonPayload);
        RequestBuilder builder = RequestBuilder.put(pathUrl);
        HttpUriRequest request = builder.setEntity(entity).build();
        return client.execute(request);
    }

    public static HttpResponse httpPost(String pathUrl, String jsonPayload) throws IOException {
        StringEntity entity = new StringEntity(jsonPayload);
        RequestBuilder builder = RequestBuilder.post(pathUrl);
        HttpUriRequest request = builder.setEntity(entity).build();
        return client.execute(request);
    }

    public static HttpResponse httpPost(String pathUrl, List<Header> headers, String jsonPayload) throws IOException {
        StringEntity entity = new StringEntity(jsonPayload);
        RequestBuilder builder = RequestBuilder.post(pathUrl);
        headers.stream().forEach(h -> builder.addHeader(h));
        HttpUriRequest request = builder.setEntity(entity).build();
        return client.execute(request);
    }

}
