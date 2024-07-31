Descrição
Você está desenvolvendo um programa para calcular os salários de funcionários em uma empresa. Neste desafio, você implementará uma solução que permite ao usuário inserir o número de horas trabalhadas e a taxa de pagamento por hora de diferentes funcionários e calcular o salário total com base nas horas trabalhadas e na taxa de pagamento. O cálculo deve ser feito diretamente, multiplicando as horas trabalhadas pela taxa por hora. Para esta solução, aplicaremos o padrão de design Factory Method. Este padrão ajuda a promover flexibilidade e desacoplamento, facilitando a expansão e manutenção do código.

Padrão de Design - Factory Method

Objetivo: Criar objetos de forma flexível e desacoplada, permitindo que a criação dos objetos seja delegada a uma fábrica.

Como Aplicar: Em vez de criar diretamente um objeto da classe Employee, você usará uma classe fábrica EmployeeFactory para criar instâncias de Employee. A classe fábrica oferece um método estático para criar o objeto, seguindo o padrão Factory Method.

Saiba mais sobre o: Factory Method

Entrada
O programa deve receber as seguintes entradas:

Número de horas trabalhadas: Um inteiro representando o total de horas trabalhadas por um funcionário.

Taxa de pagamento por hora: Um valor decimal representando a taxa de pagamento por hora do funcionário.

Saída
O programa exibirá a seguinte mensagem:

Salario total: X, onde X é o salário total calculado para o funcionário.

Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
22
12	Salario total: 264.0
40
15	Salario total: 600.0
10
10	Salario total: 100.0
