package ie.citadel.pupils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class PupilServerApplication {
	
  @Bean
  public Sampler defaultSampler() {
    return new AlwaysSampler();
  }	

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate(){
      return new RestTemplate();
  }

  public static void main(String[] args) {
        SpringApplication.run(PupilServerApplication.class, args);
  }
}
