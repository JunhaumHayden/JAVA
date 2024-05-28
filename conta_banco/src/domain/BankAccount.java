package domain;

public class BankAccount 
{
    private static int lastId = 0; // atributo para implementar autoincremento
    private int id;
     private int number;
     private String agency;
     private String clientName;
     private double balance = 0.0;
     
     //Constuctor padrão
     public BankAccount()
     {
        this.id = ++lastId; //Autoincremento do Id
     }

     //Construtor Sobrecarregado
    public BankAccount(int number, String agency, String clientName, double balance) 
    {
        this(); //Chama o construtor padrão para gerar o id
        this.number = number;
        this.agency = agency;
        this.clientName = clientName;
        this.balance = balance;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        this.balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (this.balance >= amount) 
        {
            this.balance -= amount;
            return true;
        } 
        else 
        {
            return false;
        }
    }

    // Exibir os dados da conta bancária
    @Override
    public String toString()
    {
        return "Olá" + clientName + ", obrigado por criar uma conta em nosso banco, sua agência é " + agency + ", conta " + number + " e seu saldo de R$" + balance + " já está disponível para saque.";
    }

}
