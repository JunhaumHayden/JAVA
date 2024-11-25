package dio.springboot.app;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //Sao componentes dentro do container. Usado quando se tem o codigo fonte (Não é possivel de ser usado quando usamos classes de outras bibliotecas)
public class ConversorJson {
    @Autowired //para nao usar dependencia explicita (new Gson)
    private Gson gson;
    public ViaCepResponse converter(String json ){
        ViaCepResponse response = gson.fromJson(json,ViaCepResponse.class);
        return response;
    }
}
