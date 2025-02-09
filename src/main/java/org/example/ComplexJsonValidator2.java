package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.InputStream;
import java.util.Set;

public class ComplexJsonValidator2 {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonSchema schema = loadSchema(objectMapper, "/complex-schema.json");
        JsonNode jsonNode = loadJson(objectMapper, "/complex-json.json");

        Set<ValidationMessage> validationResult = schema.validate(jsonNode);

        if (validationResult.isEmpty()) {
            System.out.println("Validation successful!");
        } else {
            System.out.println("Validation errors:");
            validationResult.forEach(vm -> System.out.println(vm.getMessage()));
        }
    }

    private static JsonSchema loadSchema(ObjectMapper objectMapper, String schemaPath) throws Exception {
        InputStream schemaStream = ComplexJsonValidator1.class.getResourceAsStream(schemaPath);
        if (schemaStream == null) {
            throw new IllegalArgumentException("Schema file not found");
        }
        JsonNode schemaNode = objectMapper.readTree(schemaStream);
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        return factory.getSchema(schemaNode);
    }

    private static JsonNode loadJson(ObjectMapper objectMapper, String jsonPath) throws Exception {
        InputStream jsonStream = ComplexJsonValidator1.class.getResourceAsStream(jsonPath);
        if (jsonStream == null) {
            throw new IllegalArgumentException("JSON file not found");
        }
        return objectMapper.readTree(jsonStream);
    }
}
