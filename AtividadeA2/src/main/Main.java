package main;

import domain.Modelo;
import domain.Veiculos;
import domain.Cor;
import domain.Marca;
import domain.Ecategoria;
import domain.Motor;
import domain.EtipoCombustivel;

public class Main {
    public static void main(String[] args) {
        // Instanciando objetos usando construtores sobrecarregados
        //Instanciando os Modelos
        System.out.println("\nIniciando Programa...\n");
        System.out.println("\n----------------\n");
       

        System.out.println("\nInstanciando os Marca...\n");
        //Usando Construtor padrão
        Marca marca1 = new Marca();
        marca1.setNome("Marca X");
        //Usando Construtor Sobrecarregado
        Marca marca2 = new Marca("Marca Y");

        // Criando uma instância de Motor
        Motor motor01 = new Motor(150, EtipoCombustivel.GASOLINA);
        Motor motor02 = new Motor(150, EtipoCombustivel.FLEX);

        System.out.println("\nInstanciando os Modelos...\n");

        //Usando Construtor padrão
        Modelo modelo1 = new Modelo();
        modelo1.setDescricao("Modelo A");
        modelo1.getMotor().setPotencia(100);
        modelo1.getMotor().setTipoCombustivel(EtipoCombustivel.FLEX);
        modelo1.setCategoria(Ecategoria.MEDIO);

        //Usando Construtor Sobrecarregado
        Modelo modelo2 = new Modelo("Modelo B");


        
        // Exibindo objetos criados
        System.out.println("\nObjetos criados:\n");
        System.out.println(modelo1);
        System.out.println(modelo2);
        System.out.println(marca1);
        System.out.println(marca2);
        System.out.println(motor01);
        System.out.println(motor02);
        System.out.println("\n----------------\n");

        // Realizando associação entre as classes (agregação)
        modelo1.setMarca(marca1);
        modelo2.setMarca(marca2);
        System.out.println("\n----------------\n");

        // Exibindo associação entre as classes
        System.out.println("\nAssociação entre classes:\nPelo Metodo ToString\n\n");
        System.out.println(modelo1);
        System.out.println(modelo2);
        System.out.println("\n----------------\n");

        System.out.println("\n\nAssociação entre classes:");
        System.out.println("Modelo 1 pertence à Marca: " + modelo1.getMarca());
        //System.out.println("Modelo 1 com o Tipo de Combustivel: " + modelo1.getMotor().getTipoCombustivel());
        System.out.println("Modelo 2 pertence à Marca: " + modelo2.getMarca());
        
        //System.out.println("Modelo 2 com o Tipo de Combustivel: " + modelo2.getMotor().getTipoCombustivel()); 
        System.out.println("\n----------------\n");

        // Criando uma instância de Cor
        Cor cor1 = new Cor("Preto");
        Cor cor2 = new Cor("Branca");
        
        // Criando uma instância de Veiculos
        System.out.println("\nInstanciando os Veiculos...\n");

        Veiculos veiculo1 = new Veiculos("ABC1234", "Veículo em boas condições");
        veiculo1.setCor(cor1); // Definindo a cor do veículo
        veiculo1.setModelo(modelo1); // Definindo o modelo do veículo 2
        
        Veiculos veiculo2 = new Veiculos("DEF5678", "Veículo novo");
        veiculo2.setCor(cor2); // Definindo a cor do veículo 2
        veiculo2.setModelo(modelo2); // Definindo o modelo do veículo 2
        
        // Exibindo os detalhes do veículo 1
        System.out.println("\n----------------\n");
        System.out.println("Detalhes do Veículo 1:");
        System.out.println("ID: " + veiculo1.getId());
        System.out.println("Placa: " + veiculo1.getPlaca());
        System.out.println("Observações: " + veiculo1.getObservacoes());
        System.out.println("Marca: " + veiculo1.getModelo().getMarca().getNome());
        System.out.println("Modelo: " + veiculo1.getModelo().getDescricao());
        System.out.println("Categoria: " + veiculo1.getModelo().getCategoria());
        System.out.println("Motor: " + veiculo1.getModelo().getMotor().getPotencia());
        System.out.println("Tipo de Combustível: " + veiculo1.getModelo().getMotor().getTipoCombustivel());
        System.out.println("Cor: " + veiculo1.getCor().getNome());
        
        // Exibindo os detalhes do veículo 2
        System.out.println("\n----------------\n");
        System.out.println("\nDetalhes do Veículo 2:");
        System.out.println("ID: " + veiculo2.getId());
        System.out.println("Placa: " + veiculo2.getPlaca());
        System.out.println("Observações: " + veiculo2.getObservacoes());
        System.out.println("Marca: " + veiculo2.getModelo().getMarca().getNome());
        System.out.println("Modelo: " + veiculo2.getModelo().getDescricao());
        System.out.println("Categoria: " + veiculo2.getModelo().getCategoria());
        System.out.println("Motor: " + veiculo2.getModelo().getMotor().getPotencia());
        System.out.println("Tipo de Combustível: " + veiculo2.getModelo().getMotor().getTipoCombustivel());
        System.out.println("Cor: " + veiculo2.getCor().getNome());

    }
}
