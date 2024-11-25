package dio.springboot.app;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Annotation para garantir a injecao de dependencia. Informa que esta classe é uma configuracao no conteiner do Spring
public class Beans {
    @Bean
    public Gson gson(){
        return new Gson();
    }
}
