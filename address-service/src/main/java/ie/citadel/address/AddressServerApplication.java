package ie.citadel.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class AddressServerApplication {
	
    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }
	
    public static void main(String[] args) {
        SpringApplication.run(AddressServerApplication.class, args);
    }
}
