package com.l2t.ljson;

public class StateDetails {
    private String state;
    private String capital;
    private double population;
    private double minTemperature;
    private double maxTemperature;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "StateDetails{" +
                "state='" + state + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}
