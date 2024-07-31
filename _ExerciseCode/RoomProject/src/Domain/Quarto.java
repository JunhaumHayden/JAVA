package Domain;

import Domain.janelas.Janela;
import Domain.portas.Porta;

public class Quarto 
{
    private Janela janela;
    private Porta porta;

    public Janela getJanela() {
        return janela;
    }
    public void setJanela(Janela janela) {
        this.janela = janela;
    }
    public Porta getPorta() {
        return porta;
    }
    public void setPorta(Porta porta) {
        this.porta = porta;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + "\nJanela: " + getJanela() + "\nPorta: " + getPorta() + "\n";
    }

    
    
}
