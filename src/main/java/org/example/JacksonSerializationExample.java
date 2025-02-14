package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializationExample {
    private String id;
    private String name;
    private int age;
    private String email;
    private Address address;
    private String[] phones;
    private boolean isActive;

    // Getters and setters

    public static class Address {
        private String street;
        private String city;
        private String zipcode;

        // Getters and setters
        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of the JacksonSerializationExample class
        JacksonSerializationExample person = new JacksonSerializationExample();
        person.setId("507f1f77bcf86cd799439011");
        person.setName("John Doe");
        person.setAge(30);
        person.setEmail("john.doe@example.com");
        Address address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Anytown");
        address.setZipcode("12345");
        person.setAddress(address);
        person.setPhones(new String[]{"1234567890", "0987654321"});
        person.setIsActive(false);

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Serialize the person object to JSON
        String jsonString = objectMapper.writeValueAsString(person);

        // Print the JSON string
        System.out.println(jsonString);
    }

    // Getters and setters for JacksonSerializationExample class
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}