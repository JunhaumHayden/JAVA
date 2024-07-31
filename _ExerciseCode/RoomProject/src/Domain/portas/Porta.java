package Domain.portas;

import Domain.iAbertura;
import Domain.iTravamento;

public abstract class Porta implements iAbertura, iTravamento
{
    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n Nome= " + nome + "\n_______________\n";
    }

}
