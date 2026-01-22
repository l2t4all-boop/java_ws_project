package com.l2t.lcj.collections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

public class CountryService {


    private static List<Country> countries = new ArrayList<>();

    static {
        countries = loadDataFromJson();
        System.out.println("Total countries count is :" + countries.size());
    }

    public List<String> getOfficialCountryNames() {
        List<String> countryOfficialNameList = new ArrayList<>();
        for (Country country : countries) {
            countryOfficialNameList.add(country.getOfficialName());
        }
        return countryOfficialNameList;
    }

    public List<Country> getTop5PopulatedCountries(){
        return null;
    }

    public int maxPopulation(){
        return 0;
    }
    public String maxPopulatedCountry(){
        return "";
    }
    // Unique regions
    public List<String> getRegions(){
        return null;
    }

    public List<String> getCountries(String region){
        return null;
    }

    public Country getMaxAreaCountry(){
        return null;
    }


    private static List<Country> loadDataFromJson() {
        try {
            // Read data from country_data.json file get all countries information
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = CountryService.class
                    .getClassLoader()
                    .getResourceAsStream("country_data.json");

            if (inputStream == null) {
                System.err.println("country_data.json file not found in resources");
                return new ArrayList<>();
            }

            // Parse JSON to JsonNode
            JsonNode rootNode = objectMapper.readTree(inputStream);
            ArrayNode countriesArray = (ArrayNode) rootNode;

            // Convert JsonNode to Country objects using Builder pattern
            List<Country> countries = new ArrayList<>();
            for (JsonNode countryNode : countriesArray) {
                // Extract nested name information
                JsonNode nameNode = countryNode.get("name");
                String commonName = nameNode != null && nameNode.has("common") ?
                        nameNode.get("common").asText() : "";
                String officialName = nameNode != null && nameNode.has("official") ?
                        nameNode.get("official").asText() : "";

                // Extract capital array
                List<String> capital = new ArrayList<>();
                JsonNode capitalNode = countryNode.get("capital");
                if (capitalNode != null && capitalNode.isArray()) {
                    for (JsonNode cap : capitalNode) {
                        capital.add(cap.asText());
                    }
                }

                // Extract other fields
                String region = countryNode.has("region") ?
                        countryNode.get("region").asText() : "";
                int area = countryNode.has("area") ?
                        countryNode.get("area").asInt() : 0;
                int population = countryNode.has("population") ?
                        countryNode.get("population").asInt() : 0;

                // Create Country object using Builder pattern
                Country country = Country.builder()
                        .commonName(commonName)
                        .officialName(officialName)
                        .capital(capital)
                        .region(region)
                        .area(area)
                        .population(population)
                        .build();
                countries.add(country);
            }

            return countries;

        } catch (Exception e) {
            System.err.println("Error loading country data: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
