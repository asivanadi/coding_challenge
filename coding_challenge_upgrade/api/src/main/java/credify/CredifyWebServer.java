package credify;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.*;


public interface CredifyWebServer {

    /**
     * Create object.
     *
     * @param cfSourceId source id
     * @param cfCorrId correlation id
     * @param apiVersion api version
     * @param byObject   byObject
     * @param payload    payload
     * @return id of object in json format
     */
    @POST("/api/brfunnelorch/{apiVersion}/resume/{byObject}")
    @Headers({
            "Content-Type: application/json",
            "Accept: */*"
    })
    Call<JsonObject> postByObject(@Header("x-cf-source-id") String cfSourceId,
                                  @Header("x-cf-corr-id") String cfCorrId,
                                  @Path("apiVersion") String apiVersion,
                                  @Path("byObject") String byObject, @Body JsonObject payload);

}