package dio.springboot;

import org.springframework.stereotype.Component;

@Component //Annotation para o indicar ao spring que essa classe deverá ser um componente do containner criado pelo spring
public class Calculadora {
    public int somar(int numero1, int numero2){
        return numero1 + numero2;
    }
    public int soma(int x, int y){
        return x+y;
    }

    public float somaFloat(float f1, float f2){
        return f1+f2;
    }

    public long somaLong(long f1, long f2){
        return f1+f2;
    }
}
