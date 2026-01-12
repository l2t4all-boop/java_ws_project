package com.l2t.ljson;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CountryStateWrapper {

    @JsonProperty("india_states")
    private List<StateDetails> states;

    public List<StateDetails> getStates() {
        return states;
    }

    public void setStates(List<StateDetails> states) {
        this.states = states;
    }
}
