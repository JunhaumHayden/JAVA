package mainapp;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;

// import domain.Cliente;
import domain.EtipoCombustivel;
import domain.Ecategoria;
import domain.Cor;
import domain.Modelo;
// import domain.Motor;
// import domain.Marca;
// import domain.PessoaFisica;
// import domain.PessoaJuridica;
// import domain.Pontuacao;
// import domain.Veiculos;
import domain.Marca;

public class exemploUsoLista {

     // Criando listas para armazenar os clientes, veículos, motor, modelo, marca e cor
    //  private static List<Cliente> clientes = new ArrayList<>();
    //  private static List<Veiculos> veiculos = new ArrayList<>();
    //  private static List<Motor> motores = new ArrayList<>();
    private static List<Modelo> modelos = new ArrayList<>();
    private static List<Marca> marcas = new ArrayList<>();
    private static List<Cor> cores = new ArrayList<>();
    private static final Scanner leia = new Scanner(System.in);


    public static void exemplodeUso() {
    
        // Adicionando dados pré-definidas
         // Criando cores
        cores.add(new Cor("Vermelho"));
        cores.add(new Cor("Azul"));
        Cor cor1 = new Cor("Preto");
        cores.add(cor1);

        // Criando marcas
        marcas.add(new Marca("Honda"));
        marcas.add(new Marca("Toyota"));
        Marca marca1 = new Marca("Nissan");
        marcas.add(marca1);
    

        // Criando modelos
        Modelo modelo1 = new Modelo("Versa", marca1, Ecategoria.PEQUENO, 100, EtipoCombustivel.GASOLINA);
        Modelo modelo2 = new Modelo("Frontier", marca1, Ecategoria.GRANDE, 150, EtipoCombustivel.DIESEL);
        modelos.add(modelo1);
        modelos.add(modelo2);

    //     // Criando veículos
    //     Veiculo veiculo1 = new Veiculo("Carro 1", modelo1, cor1);
    //     Veiculo veiculo2 = new Veiculo("Carro 2", modelo2, cor2);
    //     veiculos.add(veiculo1);
    //     veiculos.add(veiculo2);

    //     // Criando clientes
    //     Pontuacao pontosCliente1 = new Pontuacao();
    //     Pontuacao pontosCliente2 = new Pontuacao();

    //     Cliente cliente1 = new PessoaFisica("João", "999999999", "joao@teste.com", new Date(), pontosCliente1, "123.456.789-00", new Date());
    //     Cliente cliente2 = new PessoaJuridica("Empresa X", "888888888", "empresa@teste.com", new Date(), pontosCliente2, "12.345.678/0001-00", "123456789");
    //     clientes.add(cliente1);
    //     clientes.add(cliente2);

    //     // Associando veículos aos clientes
    //     cliente1.addVeiculos(veiculo1);
    //     cliente2.addVeiculos(veiculo2);

    //     // Adicionando pontos
    //     pontosCliente1.adicionarPontos(15);
    //     pontosCliente2.adicionarPontos(15);

    //     // Mostrando saldo de pontos
    //     System.out.println("Saldo de pontos do Cliente 1: " + pontosCliente1.saldo());
    //     System.out.println("Saldo de pontos do Cliente 2: " + pontosCliente2.saldo());

    //     // Subtraindo pontos
    //     pontosCliente1.subtrairPontos(5);
    //     pontosCliente2.subtrairPontos(5);

    //     // Mostrando novo saldo de pontos
    //     System.out.println("\nNovo saldo de pontos do Cliente 1: " + pontosCliente1.saldo());
    //     System.out.println("Novo saldo de pontos do Cliente 2: " + pontosCliente2.saldo());
    }
    public static void menuPrincipal() {
        
        int opcao = 0;
        do {
            System.out.println("1 - novo");
            // System.out.println("2 - repor");
            // System.out.println("3 - retirar");
            // System.out.println("4 - quantidade atual de um produto");
            // System.out.println("5 - listar todos");
            // System.out.println("6 - Reajustar preço");
            System.out.println("0 - sair");
            System.out.print("Opcao: ");
            opcao = leia.nextInt();
            switch (opcao) {
                //case 1: novo(); break;
                // case 2: repor(); break;
                // case 3: break;
                // case 4: pesquisarProduto(); break;
                // case 5: listarTodos(); break;
                // case 6: reajustarValor(); break;
                case 0: System.out.println("Finalizando o programa...");break;
                default: System.out.println("Opcao invalida");
            } 
        } while (opcao != 0);
    }
    // Declaração do método para chamar o menu interativo
    
    // Declaraçao do metodo auxiliar
    private static void printing(String string)
    {
        System.out.println("*********************");
        System.out.println(string);
        System.out.println("\n");
    }
    
    public static boolean isValidCategoria(String categoria) {
        for (Ecategoria cat : Ecategoria.values()) {
            if (cat.name().equals(categoria)) {
                return true;
            }
        }
        return false;
    }
    
   
    //CORES
    // Método para consultar uma cor
    public static void consultaCor() 
    {
        for (Cor c : cores) 
        {
            System.out.println(c.getNome());
        }
    }
    // Método para adicionar uma nova cor
    public static void addCor(List<Cor> listaCores) 
    {
        System.out.println("Informe a nova cor: ");
        String c = leia.nextLine();
        listaCores.add(new Cor(c));
        printing("Nova cor adicionada com sucesso!");
    }
    // Método para remover uma nova cor
    public static void removeCor(List<Cor> listaCores)
    {
        System.out.print("Informe a cor a ser removida: ");
        String corInformada = leia.nextLine();
        Cor corRemovida = null;
        for (Cor cor : listaCores) {
            if (cor.getNome().equalsIgnoreCase(corInformada)) {
                corRemovida = cor;
                break;
            }
        }
        if (corRemovida != null) {
            listaCores.remove(corRemovida);
            System.out.println("Cor removida com sucesso!");
        } else {
            System.out.println("Cor não encontrada!");
        }
    }
    //MARCA
    // Método para consultar uma marca
    public static void consultaMarca() 
    {
        for (Marca m : marcas) 
        {
            System.out.println(m.getNome());
        }
    }
    // Método para adicionar uma nova marca
    public static void addMarca(List<Marca> listaMarcas) 
    {
        System.out.println("Informe a nova marca: ");
        String m = leia.nextLine();
        listaMarcas.add(new Marca(m));
        printing("Nova marca adicionada com sucesso!");
    }
    // Método para remover uma nova cor
    public static void removeMarca(List<Marca> listaMarcas)
    {
        System.out.print("Informe a marca a ser removida: ");
        String marcaInformada = leia.nextLine();
        Marca marcaRemovida = null;
        for (Marca marca : listaMarcas) {
            if (marca.getNome().equalsIgnoreCase(marcaInformada)) {
                marcaRemovida = marca;
                break;
            }
        }
        if (marcaRemovida != null) {
            listaMarcas.remove(marcaRemovida);
            System.out.println("Marca removida com sucesso!");
        } else {
            System.out.println("Marca não encontrada!");
        }
    }

    //MODELO
    // Método para consultar um modelo
    public static void consultaModelo() 
    {
        for (Modelo m : modelos) 
        {
            System.out.println(m.getDescricao());
        }
    }
    // Método para adicionar um novo modelo
    public static void addModelo(List<Modelo> listaModelos, List<Marca> listaMarcas) 
    {
        System.out.println("Informe o novo modelo: ");
        String dadoEntrada = "";
        boolean flagCategoria = false;
        while (!flagCategoria) //Laço de repetiçao para escolher um novo modelo
        {
            dadoEntrada = leia.nextLine();
            // Verifica se a entrada indica para sair do programa
            if (dadoEntrada.equalsIgnoreCase("s"))
                {
                    return;
                }
            // Verifica se o modelo já existe na lista 
            for (Modelo modelo : listaModelos) 
            {
                if (modelo.getDescricao().equalsIgnoreCase(dadoEntrada)) 
                {
                    System.out.println("Modelo já existe na lista! Digite novamente ou digite S para sair: ");
                    break;
                }
                else
                {
                    flagCategoria = true;
                }
            }
        }
        Modelo novoModelo = new Modelo(dadoEntrada);
        // Preenchendo os atributos do modelo
        System.out.print("categoria.......: ");
        flagCategoria = false;
        while (!flagCategoria) //Laço de repeticao para escolher uma categoria
        {
            System.out.print("(PEQUENO, MEDIO, GRANDE, MOTO, PADRAO): ");
            String categoriaModelo = leia.nextLine().toUpperCase();
            if (categoriaModelo.equalsIgnoreCase("s"))
            {
                return;
            }
            if (isValidCategoria(categoriaModelo)) 
            {
                novoModelo.setCategoria(Ecategoria.valueOf(categoriaModelo));
                flagCategoria = true;
            } else 
            {
                System.out.println("Categoria inválida. Digite novamente ou digite S para sair.");
            }
        }    
        
        System.out.print("\nMarca...: ");
        flagCategoria = false;
        while (!flagCategoria) //Laço de repetiçao para escolher um novo marca
        {
            dadoEntrada = leia.nextLine();
            // Verifica se a entrada indica para sair do programa
            if (dadoEntrada.equalsIgnoreCase("s"))
                {
                    return;
                }
            // Verifica se o marcao já existe na lista 
            for (Marca marca : listaMarcas) 
            {
                // associa ao Modelo caso exista
                if (marca.getNome().equalsIgnoreCase(dadoEntrada)) 
                {
                    novoModelo.setMarca(marca);
                    flagCategoria = true;
                }
                // Caso nao exista, pergunta se deseja adicionar um novo modelo
                else
                {
                    System.out.println("Marca " + dadoEntrada + " nao existe na lista!\nDigite SIM caso deseja criar esta Marca ou digite S para sair: ");
                    String confirmaEntrada = leia.nextLine();
                        if (confirmaEntrada.equalsIgnoreCase("sim"))
                        {
                            Marca novaMarca = new Marca(dadoEntrada);
                            marcas.add(novaMarca);
                            novoModelo.setMarca(novaMarca);
                            flagCategoria = true;
                        }
                        if (confirmaEntrada.equalsIgnoreCase("s"))
                        {
                            return;
                        }
                        else
                        {
                            System.out.println("Entrada invalida, Informe novamente a Marca ou digite S para sair: ");
                            break;
                        }
                }
            }
        }
        System.out.print("Potencia.....: ");
        novoModelo.getMotor().setPotencia(leia.nextInt());
        System.out.print("Tipo de Combustivel.....: ");
        novoModelo.getMotor().setTipoCombustivel(null);
        listaModelos.add(novoModelo);
        printing("Novo modelo adicionado com sucesso!");
        
        
    }
    public static void main(String[] args) {
        exemplodeUso();
        consultaModelo();
        printing("Add Modelo");
        addModelo(modelos, marcas);
        consultaModelo();
        // printing("Remover Marca");
        // removeMarca(marcas);
        // consultaMarca();
        //menuPrincipal();
    }

   }


