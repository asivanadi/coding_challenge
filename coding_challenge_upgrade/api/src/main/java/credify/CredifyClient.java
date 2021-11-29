package credify;

import com.google.gson.JsonObject;

import com.upgrade.config.CredifyConfiguration;
import helper.RequestManager;
import io.qameta.allure.Step;
import retrofit2.Response;


public class CredifyClient {
    private static final String API_VERSION = "v2";
    private static final RequestManager REQUEST_MANAGER = new RequestManager();
    private static final CredifyConfiguration CREDIFY_CONFIGURATION = CredifyConfiguration.INSTANCE;
    private final CredifyWebServer credifyWebServer;

    /**
     * ctor for Credify Client
     */
    public CredifyClient() {
        this.credifyWebServer = REQUEST_MANAGER.createHttpClient(CredifyWebServer.class,
                CREDIFY_CONFIGURATION.getUrl());
    }

    /**
     * Create object.
     * @param sourceId      sourceId
     * @param corrId        corrId
     * @param byObject      byObject
     * @param payload       payload
     * @return id of object in json format
     */
    @Step("Execute post byObject")
    public Response<JsonObject> postByObject(String sourceId, String corrId, String byObject, JsonObject payload) {
        try {
            return this.credifyWebServer.postByObject(sourceId, corrId, API_VERSION, byObject, payload).execute();
        } catch(Exception ex) {
            throw new RuntimeException("Unable to post object", ex);
        }
    }
}
