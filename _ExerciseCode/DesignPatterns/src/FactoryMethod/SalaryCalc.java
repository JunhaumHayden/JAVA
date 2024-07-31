package FactoryMethod;

import java.util.Scanner;

// Classe Employee para representar os detalhes do funcionário:
class Employee {
    private int hoursWorked;
    private double hourlyRate;

    public Employee(int hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Classe Factory para criar objetos Employee:
class EmployeeFactory {
    // Método estático para criar e retornar um objeto Employee:
    public static Employee createEmployee(int hoursWorked, double hourlyRate) {

        return new Employee(hoursWorked, hourlyRate);
    }
}


public class SalaryCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de horas trabalhadas:");
        int hoursWorked = scanner.nextInt();

        System.out.println("Digite a taxa de pagamento por hora:");
        double hourlyRate = scanner.nextDouble();
        
        // Utilize o Factory Method para criar um objeto Employee:
        Employee employee = EmployeeFactory.createEmployee(hoursWorked, hourlyRate);
        
        // Calcular o salário:
        double salary = employee.calculateSalary();

        System.out.printf("Salario total: %.1f%n", salary);
    }
}

