package client.credify;

import com.google.gson.JsonObject;
import credify.CredifyClient;
import helper.SchemaValidator;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.util.UUID;

class CredifyClientTest {
    private final CredifyClient credifyClient = new CredifyClient();
    private static final SchemaValidator SCHEMA_VALIDATOR = new SchemaValidator();

    @Feature("Credify Client")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testpostbyLeadSecret() {
        final JsonObject payload = new JsonObject();
        final String sourceId = "coding-challenge";
        final String correlationId = UUID.randomUUID().toString();
        payload.addProperty("loanAppUuid", "b8096ec7-2150-405f-84f5-ae99864b3e96");
        payload.addProperty("skipSideEffects", true);
        Response<JsonObject> response =
                credifyClient.postByObject(sourceId, correlationId, "byLeadSecret", payload);
        assert response.body() != null;
        Assertions.assertTrue(response.isSuccessful());
        Assertions.assertEquals(response.code(), 200);
        SCHEMA_VALIDATOR.validateJsonSchema("/json/credify/byLeadSecretPostResponseSchema.json",
                response.body());
        Assertions.assertEquals("PERSONAL_LOAN",
                response.body().get("loanAppResumptionInfo").getAsJsonObject().get("productType").getAsString());
    }

    @Feature("Credify Client")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testpostbyLeadSecretInvalidId() {
        final JsonObject payload = new JsonObject();
        final String sourceId = "coding-challenge";
        final String correlationId = UUID.randomUUID().toString();
        payload.addProperty("loanAppUuid", "b8096ec7-2150-405f-84f5-ae99864b3e9");
        payload.addProperty("skipSideEffects", true);
        Response<JsonObject> response =
                credifyClient.postByObject(sourceId, correlationId, "byLeadSecret", payload);
        Assertions.assertFalse(response.isSuccessful());
        Assertions.assertNotEquals(response.code(), 200);
    }
}
