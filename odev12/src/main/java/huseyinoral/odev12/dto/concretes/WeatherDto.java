package huseyinoral.odev12.dto.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherDto {
	
	@JsonProperty("name")
	private int name;
	
	//kaç tane sonuç döndüreceği için
	
}
