package Domain.janelas;

import Domain.iAbertura;
import Domain.iTravamento;

public abstract class Janela implements iAbertura, iTravamento{
    protected String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "\n   nome= " + nome + "\n***************\n";
    }
}
