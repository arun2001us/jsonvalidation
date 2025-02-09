package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.InputStream;
import java.util.Set;

public class ComplexJsonValidator1 {
    public static void main(String[] args) throws Exception {
        // Create ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Load the JSON schema
        InputStream schemaStream = ComplexJsonValidator.class.getResourceAsStream("/complex-schema.json");
        if (schemaStream == null) {
            throw new IllegalArgumentException("Schema file not found");
        }
        JsonNode schemaNode = objectMapper.readTree(schemaStream);

        // Create schema factory and load schema
        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        JsonSchema schema = factory.getSchema(schemaNode);

        // Load the JSON to validate from a file
        InputStream jsonStream = ComplexJsonValidator.class.getResourceAsStream("/complex-json.json");
        if (jsonStream == null) {
            throw new IllegalArgumentException("JSON file not found");
        }
        JsonNode jsonNode = objectMapper.readTree(jsonStream);

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