package main;

import domain.Modelo;
import domain.Veiculos;
import domain.Cor;
import domain.Marca;

public class Main {
    public static void main(String[] args) {
        // Instanciando objetos usando construtores sobrecarregados
        //Instanciando os Modelos
        System.out.println("\nIniciando Programa...\n");
        System.out.println("\n----------------\n");
        System.out.println("\nInstanciando os Modelos...\n");


        //Usando Construtor padrão
        Modelo modelo1 = new Modelo();
        modelo1.setDescricao("Modelo A");
        //Usando Construtor Sobrecarregado
        Modelo modelo2 = new Modelo("Modelo B");


        System.out.println("\nInstanciando os Marca...\n");
        //Usando Construtor padrão
        Marca marca1 = new Marca();
        marca1.setNome("Marca X");
        //Usando Construtor Sobrecarregado
        Marca marca2 = new Marca("Marca Y");

        // Exibindo objetos criados
        System.out.println("\nObjetos criados:\n");
        System.out.println(modelo1);
        System.out.println(modelo2);
        System.out.println(marca1);
        System.out.println(marca2);
        System.out.println("\n----------------\n");

        // Realizando associação entre as classes (agregação)
        modelo1.setMarca(marca1);
        modelo2.setMarca(marca2);
        System.out.println("\n----------------\n");

        // Exibindo associação entre as classes
        System.out.println("\nAssociação entre classes:\nPelo Metodo ToString\n\n");
        System.out.println(modelo1);
        System.out.println(modelo2);

        System.out.println("\n\nAssociação entre classes:");
        System.out.println("Modelo 1 pertence à Marca: " + modelo1.getMarca());
        System.out.println("Modelo 2 pertence à Marca: " + modelo2.getMarca());
        System.out.println("\n----------------\n");

        // Criando uma instância de Cor
        Cor cor1 = new Cor("Preto");
        Cor cor2 = new Cor("Branca");
        
        // Criando uma instância de Veiculos
        System.out.println("\nInstanciando os Marca...\n");
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
        System.out.println("Cor: " + veiculo1.getCor().getNome());
        
        // Exibindo os detalhes do veículo 2
        System.out.println("\n----------------\n");
        System.out.println("\nDetalhes do Veículo 2:");
        System.out.println("ID: " + veiculo2.getId());
        System.out.println("Placa: " + veiculo2.getPlaca());
        System.out.println("Observações: " + veiculo2.getObservacoes());
        System.out.println("Marca: " + veiculo2.getModelo().getMarca().getNome());
        System.out.println("Modelo: " + veiculo1.getModelo().getDescricao());
        System.out.println("Cor: " + veiculo2.getCor().getNome());

    }
}
