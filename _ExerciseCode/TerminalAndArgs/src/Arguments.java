package java._ExerciseCode.TerminalAndArgs.src;
public class Arguments {
    public static void main(String[] args) {
        String nome = args[0];
        String sobrenome = args[1];
        int idade = Integer.valueOf(args[2]);
        double altura = Double.valueOf(args[3]);

        System.out.println("O nome é: " + nome + " " + sobrenome );
        System.out.println("Idade de: " + idade);
        System.out.println("Altura de: " + altura + "cm ");

    }

}
