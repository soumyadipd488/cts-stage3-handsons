package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


@SpringBootApplication
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	private static CountryService countryService;

	public static void main(String[] args) throws CountryNotFoundException {
		
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		Country country = context.getBean(Country.class);
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry(country);
		testUpdateCountry();
		testDeleteCountry();
//		LOGGER.info("Inside main");
	}
	
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");
	}
	
	private static void getAllCountriesTest() throws CountryNotFoundException {

		LOGGER.info("Start");
		
		Country country = countryService.findCountryByCode("IN");

		LOGGER.debug("Country:{}", country);

		LOGGER.info("End");
	}
	
	public static void testAddCountry(Country country)
	{
		LOGGER.info("Start");
		
		country.setCode("ZW");
		country.setName("Zimbabwe");
		
		countryService.addCountry(country);
		
		LOGGER.info("End");
		
	}
	
	public static void testUpdateCountry()
	{
		LOGGER.info("Start");
		
		countryService.updateCountry("ZW", "Zimba");
		
		LOGGER.info("End");
	}
	
	public static void testDeleteCountry()
	{
		LOGGER.info("Start");
		
		countryService.deleteCountry("ZW");
		
		LOGGER.info("End");
	}

}
