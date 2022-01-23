package com.example.exercises;

import java.util.Collection;
import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;

public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		var highPopulatedCityOfEachContinent = 
				countryDao.findAllCountries()
				          .stream()
				          .map( country -> country.getCities().stream().map(city -> new ContinentCityPair(country.getContinent(),city)).toList())
				          .flatMap(Collection::stream)
				          .collect(Collectors.groupingBy(ContinentCityPair::continent,Collectors.maxBy( (p1,p2) -> p1.city().getPopulation()-p2.city().getPopulation())));
		highPopulatedCityOfEachContinent.forEach((continent,city)->System.out.printf("%s: %s\n",continent,city.get()));
	}

}