package huseyinoral.odev12.core.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ErrorConfig {
	 @Bean
	  public ErrorProperties errorProperties(){
	    return new ErrorProperties();
	  }
}
