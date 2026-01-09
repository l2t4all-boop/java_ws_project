package com.l2t.lcj.cs;

import java.util.Arrays;

public class TeamDetailsService {

    public static void main(String[] args) {
        System.out.println(getAllTeamsNames());
    }

    // Example: KKR, RCB,......
    public static String getAllTeamsNames() {
        TeamDetails[] teamDetails = getTeamDetails();
        String[] names = new String[teamDetails.length];
        int i = 0;
        for (TeamDetails t: teamDetails) {
            names[i++] = t.getTeamShortCode();
        }
        return Arrays.toString(names);
    }
    private static TeamDetails[] getTeamDetails() {
        return new TeamDetails[]{
                new TeamDetails("Kolkata Knight Riders", "KKR"),
                new TeamDetails("Royal Challengers Bangalore", "RCB"),
                new TeamDetails("Chennai Super Kings", "CSK"),
                new TeamDetails("Kings XI Punjab", "KXIP"),
                new TeamDetails("Rajasthan Royals", "RR"),
                new TeamDetails("Delhi Daredevils", "DD"),
                new TeamDetails("Mumbai Indians", "MI"),
                new TeamDetails("Deccan Chargers", "DC"),
                new TeamDetails("Kochi Tuskers Kerala", "KTK"),
                new TeamDetails("Pune Warriors", "PW"),
                new TeamDetails("Sunrisers Hyderabad", "SRH"),
                new TeamDetails("Rising Pune Supergiants", "RPS"),
                new TeamDetails("Gujarat Lions", "GL")
        };
    }
}
