package com.l2t.ljson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class StateInformationUsingDomainObjects {

    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CountryStateWrapper countryStateWrapper = objectMapper.readValue(StateInformationService
                    .class.getResourceAsStream("/state_data.json")
            ,CountryStateWrapper.class
            );
            List<StateDetails> stateDetailsList = countryStateWrapper.getStates();
            for(StateDetails stateDetails: stateDetailsList){
                System.out.println(stateDetails);
                System.out.println("-".repeat(150));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
