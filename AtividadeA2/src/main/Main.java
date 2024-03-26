package main;

import domain.Modelo;
import domain.Marca;

public class Main {
    public static void main(String[] args) {
        // Instanciando objetos usando construtores sobrecarregados
        Modelo modelo1 = new Modelo();
        modelo1.setDescricao("Modelo A");

        Modelo modelo2 = new Modelo("Modelo B");

        Marca marca1 = new Marca();
        marca1.setNome("Marca X");

        Marca marca2 = new Marca("Marca Y");

        // Exibindo objetos criados
        System.out.println("Objetos criados:");
        System.out.println(modelo1);
        System.out.println(modelo2);
        System.out.println(marca1);
        System.out.println(marca2);

        // Realizando associação entre as classes (agregação)
        modelo1.setMarca(marca1);
        modelo2.setMarca(marca2);

        // Exibindo associação entre as classes
        System.out.println("\nAssociação entre classes:\nPelo Metodo ToString\n\n");
        System.out.println(modelo1);
        System.out.println(modelo2);

        System.out.println("\n\nAssociação entre classes:");
        System.out.println("Modelo 1 pertence à Marca: " + modelo1.getMarca());
        System.out.println("Modelo 2 pertence à Marca: " + modelo2.getMarca());
    }
}
