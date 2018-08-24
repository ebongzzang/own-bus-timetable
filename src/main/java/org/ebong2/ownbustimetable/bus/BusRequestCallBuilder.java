package org.ebong2.ownbustimetable.bus;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.apache.logging.log4j.util.Strings;

@Slf4j
class BusRequestCallBuilder {

    private HttpUrl.Builder httpUrlBuilder;
    private OkHttpClient client;

    public BusRequestCallBuilder(OkHttpClient client, String url)  {
        this.client = client;
        this.httpUrlBuilder = HttpUrl.parse(url).newBuilder();
    }

    public BusRequestCallBuilder addQueryParameter(String name, String value) {

        if(name ==null || value ==null) {
           log.warn("builder receive query parameter that null. replace empty string.");
           name = Strings.EMPTY;
           value = Strings.EMPTY;
        }

        this.httpUrlBuilder = httpUrlBuilder.addQueryParameter(name, value);
        return this;
    }

    public Call build() {
        Request request = new Request.Builder().get().url(httpUrlBuilder.build()).build();
        return client.newCall(request);
    }


}
