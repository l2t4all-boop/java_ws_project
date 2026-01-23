package com.l2t.lcj.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryDetailsUsingMap {


    public static void main(String[] args) {

            CountryService countryService = new CountryService();
            List<Country> countries = countryService.getCountries();
            Map<String, List<Country>> regionCountries = getRegionNameWithCountries(countries);
            System.out.println(regionCountries);

            regionCountries.forEach((k,v)->{
                System.out.println("Region :"+k+" has "+v.size()+" countries");
                v.forEach((ele)->{
                    System.out.println(ele.getOfficialName());
                });
                System.out.println("-".repeat(100));
            });
    }

    private static Map<String, List<Country>> getRegionNameWithCountries(List<Country> countries) {
        Map<String,List<Country>> map = new HashMap<>();
        for(Country country:countries){
            List<Country> countryList = map.getOrDefault(country.getRegion(),new ArrayList<>());
            countryList.add(country);
            map.put(country.getRegion(),countryList);
        }
        return map;
    }
}
