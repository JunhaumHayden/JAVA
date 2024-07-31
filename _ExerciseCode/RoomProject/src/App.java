import Domain.Quarto;
import Domain.portas.PortaCorrer;
import Domain.janelas.*;
import Domain.portas.*;


public class App {
    public static void main(String[] args) throws Exception {
        
        Janela janela01 = new JanelaBasculante();
        janela01.setNome("Principal");
        Porta porta01 = new PortaCorrer();
        porta01.setNome(" de Entrada");
        
        Quarto quarto01 = new Quarto();
        quarto01.setJanela(janela01);
        quarto01.setPorta(porta01);

        System.out.println(quarto01);
        quarto01.getJanela().abrir();
        quarto01.getJanela().travar();
        quarto01.getJanela().fechar();
        quarto01.getJanela().travar();
        quarto01.getJanela().abrir();
    }
}
