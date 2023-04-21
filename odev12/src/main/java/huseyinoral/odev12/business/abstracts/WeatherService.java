package huseyinoral.odev12.business.abstracts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import huseyinoral.odev12.core.utitilies.results.DataResult;
import huseyinoral.odev12.core.utitilies.results.SuccesDataResult;
import huseyinoral.odev12.dto.concretes.StudentDto;
import huseyinoral.odev12.dto.concretes.WeatherDto;

@Repository
public interface WeatherService {
	
	//DataResult<List<WeatherCitiesListDto>> getAllCities();
	String getWeatherCity(String name);
	String getWeatherCityAll(String name);
}
