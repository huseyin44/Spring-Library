package huseyinoral.odev12.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import huseyinoral.odev12.business.abstracts.WeatherService;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.dto.concretes.WeatherDto;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
	
	private WeatherService weatherService;
	
	@Autowired
	public WeatherController(WeatherService weatherService) {
		super();
		this.weatherService = weatherService;
	}
	
	@GetMapping("/getOneCity")
	public String getWeatherCity(@RequestParam String name){
		return this.weatherService.getWeatherCity(name);
	}
	
	@GetMapping("/getAllCities")
	public String getWeatherCityAll(@RequestParam String name){
		return this.weatherService.getWeatherCityAll(name);
	}

}
