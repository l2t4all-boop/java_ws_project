package com.l2t.ljson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StateInformationService {

    public static void main(String[] args) {

        // Load json data

        // Using json tree load State Details

        // Show All the state details

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(StateInformationService
                    .class.getResourceAsStream("/state_data.json"));

            JsonNode statesNodeArr = jsonNode.get("india_states");
            StateDetails[] arr = new StateDetails[statesNodeArr.size()];
            int i = 0;
            for(JsonNode stateNode: statesNodeArr){
                String state = stateNode.get("state").asText();
                String capital = stateNode.get("capital").asText();
                double population = stateNode.get("population").doubleValue();
                double minTemp = stateNode.get("minTemperature").doubleValue();
                double maxTemp = stateNode.get("maxTemperature").doubleValue();
                StateDetails obj = new StateDetails();
                obj.setState(state);
                obj.setCapital(capital);
                obj.setMaxTemperature(maxTemp);
                obj.setMinTemperature(minTemp);
                obj.setPopulation(population);
                arr[i++] = obj;
            }

            for(StateDetails obj : arr){
                System.out.println(obj);
                System.out.println("-".repeat(100));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
