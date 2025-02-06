package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.InputStream;
import java.util.Set;

public class JsonValidator {
    public static void main(String[] args) throws Exception {
        // Create ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Load the JSON schema
        InputStream schemaStream = JsonValidator.class
            .getResourceAsStream("/schema.json");
        JsonNode schemaNode = objectMapper.readTree(schemaStream);

        // Create schema factory and load schema
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaNode);

        // JSON to validate
        String json = "{\n" +
            "    \"name\": \"testmyname\",\n" +
            "    \"age\": 30,\n" +
            "    \"email\": \"john@example.com\"\n" +
            "}";
        JsonNode jsonNode = objectMapper.readTree(json);

        // Validate
        Set<ValidationMessage> validationResult = schema.validate(jsonNode);

        // Check validation results
        if (validationResult.isEmpty()) {
            System.out.println("Validation successful!");
        } else {
            System.out.println("Validation errors:");
            validationResult.forEach(vm -> System.out.println(vm.getMessage()));
        }
    }
}