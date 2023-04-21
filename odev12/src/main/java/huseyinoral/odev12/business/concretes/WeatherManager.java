package huseyinoral.odev12.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import huseyinoral.odev12.business.abstracts.WeatherService;
import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.Result;
import huseyinoral.odev12.core.utitilies.results.SuccesDataResult;
import huseyinoral.odev12.dataAccess.abstracts.StudentBookDao;
import huseyinoral.odev12.dto.concretes.WeatherDto;
import huseyinoral.odev12.entities.concretes.StudentBook;

@Service
public class WeatherManager implements WeatherService {
	
	private final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public String getWeatherCity(String name) {
		
		String uri = "https://geocoding-api.open-meteo.com/v1/search?name={name}&language=tr&count=1";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class,name);
	    
	    //WeatherDto weatherDto=modelMapper.map(result, WeatherDto.class);
	    //System.out.println(weatherDto);
	    return result;
	}

	@Override
	public String getWeatherCityAll(String name) {
		String uri = "https://geocoding-api.open-meteo.com/v1/search?name={name}&language=tr&count=20";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class,name);
	    
	    
	    return result;
	}



}
