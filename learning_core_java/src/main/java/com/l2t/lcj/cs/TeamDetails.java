package com.l2t.lcj.cs;

public class TeamDetails {
    private String teamName;
    private String teamShortCode;

    public TeamDetails(String teamName, String teamShortCode){
        this.teamName = teamName;
        this.teamShortCode = teamShortCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamShortCode() {
        return teamShortCode;
    }

    public void setTeamShortCode(String teamShortCode) {
        this.teamShortCode = teamShortCode;
    }
}
