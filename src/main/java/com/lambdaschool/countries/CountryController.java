package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/countries")
public class CountryController
{
    static long min = -1;

    // localhost:2019/countries/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountryNames()
    {
        return new ResponseEntity<>(CountriesApplication.countryList.countryList, HttpStatus.OK);
    }

    // localhost:2019/countries/start/a (start at char 'a')
    @GetMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter)
    {
        ArrayList<Country> returnCountries = CountriesApplication.countryList
                .findCountries(c -> c.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        returnCountries.sort((el1, el2) -> (el1.getName().compareToIgnoreCase(el2.getName())));
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    // localhost:2019/countries/names/size/5
    @GetMapping(value = "/names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLength(@PathVariable int number)
    {
        ArrayList<Country> returnCountries = CountriesApplication.countryList
                .findCountries((c -> c.getName().length() >= number));
        returnCountries.sort((el1, el2) -> (el1.getName().compareToIgnoreCase(el2.getName())));
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    // localhost:2019/countries/population/size/4000000
    @GetMapping(value = "/population/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulationSize(@PathVariable long people)
    {
        ArrayList<Country> returnCountries = CountriesApplication.countryList
                .findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(returnCountries, HttpStatus.OK);
    }

    // localhost:2019/countries/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithSmallestPopulation()
    {
        Country country = CountriesApplication.countryList
                .findMinPopulation();
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    // localhost:2019/countries/population/max
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithMaxPopulation()
    {
        Country country = CountriesApplication.countryList
                .findMaxPopulation();
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
}
