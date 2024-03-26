public class Aluno 
{
        private int matricula;
        private String nome;
        private String cpf;
        private double[] notas;
    
        public Aluno(int matricula, String nome, String cpf, double[] notas) {
            this.matricula = matricula;
            this.nome = nome;
            this.cpf = cpf;
            this.notas = notas;
        }
    
        public double calcularMedia() {
            double soma = 0;
            for (double nota : notas) {
                soma += nota;
            }
            return soma / notas.length;
        }
    
        public void exibirDados() {
            System.out.println("\nDados do Aluno:");
            System.out.println("Matrícula: " + matricula);
            System.out.println("Nome: " + nome);
            System.out.println("CPF: " + cpf);
            System.out.println("Notas: ");
            for (int i = 0; i < notas.length; i++) {
                System.out.println("  Nota " + (i + 1) + ": " + notas[i]);
            }
            System.out.println("Média: " + calcularMedia());
        }
    
    
}
