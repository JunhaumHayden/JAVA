package one.digitalinnovation.gof.strategy;

public class Robo {
	//Atributo do tipo da Inteface, permitindo o polimorfismo.
	private Comportamento comportamento;

	public void setComportamento(Comportamento comportamento) {
		this.comportamento = comportamento;
	}
	
	public void mover() {
		comportamento.mover();
	}
}
