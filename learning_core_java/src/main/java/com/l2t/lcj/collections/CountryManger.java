package com.l2t.lcj.collections;

import java.util.List;

public class CountryManger {

    public static void main(String[] args) {

            CountryService countryService = new CountryService();

            List<String> countryOfficialNameList = countryService.getOfficialCountryNames();

            countryOfficialNameList
                    .forEach(System.out::println);

    }
}
