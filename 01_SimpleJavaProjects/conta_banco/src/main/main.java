package main;                                 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import domain.*;

public class main {
    private static List<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void Main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1 - Abrir conta");
            System.out.println("2 - Consultar saldo");
            System.out.println("3 - Realizar uma operação");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    openAccount();
                    break;
                case 2:
                    checkBalance();
                    break;
                case 3:
                    manageOperations();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        System.out.println("Programa encerrado.");
    }

    private static void openAccount() {
        System.out.println("Digite o número da conta:");
        int number = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o número da agência:");
        String agency = scanner.nextLine();
        System.out.println("Digite o nome do cliente:");
        String clientName = scanner.nextLine();
        System.out.println("Digite o saldo inicial:");
        double balance = scanner.nextDouble();
        accounts.add(new BankAccount(number, agency, clientName, balance));
        System.out.println("Conta aberta com sucesso!");
    }

    private static void checkBalance() {
        System.out.println("Digite o número da conta:");
        int number = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o número da agência:");
        String agency = scanner.nextLine();
        BankAccount account = findAccount(number, agency);
        if (account != null) {
            System.out.println("Saldo atual: " + account.getBalance());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void manageOperations() {
        boolean running = true;
        while (running) {
            System.out.println("Operações:");
            System.out.println("1 - Depósito");
            System.out.println("2 - Saque");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma operação: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (option) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void deposit() {
        System.out.println("Digite o número da conta:");
        int number = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o número da agência:");
        String agency = scanner.nextLine();
        BankAccount account = findAccount(number, agency);
        if (account != null) {
            System.out.println("Digite o valor do depósito:");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static void withdraw() {
        System.out.println("Digite o número da conta:");
        int number = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite o número da agência:");
        String agency = scanner.nextLine();
        BankAccount account = findAccount(number, agency);
        if (account != null) {
            System.out.println("Digite o valor do saque:");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private static BankAccount findAccount(int number, String agency) {
        for (BankAccount account : accounts) {
            if (account.getNumber() == number && account.getAgency().equals(agency)) {
                return account;
            }
        }
        return null;
    }
}

