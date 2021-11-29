package helper;

import com.google.gson.JsonObject;
import io.qameta.allure.Step;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class SchemaValidator {

    /**
     * Create object.
     * @param validSchemaPath     valid path for the Json Schema
     * @param gsonResponse        gson response
     * @throwsException a ValidationException if this object is invalid
     */
    @Step("Validate Json Schema")
    public void validateJsonSchema(String validSchemaPath, JsonObject gsonResponse) {
            JSONObject validSchemaJsonObject = new JSONObject(new JSONTokener(SchemaValidator.class.getResourceAsStream(validSchemaPath)));
            Schema validSchema = SchemaLoader.load(validSchemaJsonObject);
            validSchema.validate(new JSONObject(gsonResponse.toString()));
    }
}
