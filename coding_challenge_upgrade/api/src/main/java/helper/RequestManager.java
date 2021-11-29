package helper;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RequestManager {

    /**
     * creates http client.
     * @param <T> class type
     * @param service web service
     * @param baseUrl url
     * @return class type
     */
    public <T> T createHttpClient(final Class<T> service, final String baseUrl) {
        final Retrofit retrofit;

        final OkHttpClient client = new OkHttpClient.Builder().readTimeout(2, TimeUnit.MINUTES)
                .callTimeout(2, TimeUnit.MINUTES).retryOnConnectionFailure(true)
                .addInterceptor(new AllureOkHttp3())
                .build();
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(service);
    }
}
