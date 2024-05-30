package domain;

public enum Ecategoria 
{
    PEQUENO("Pequeno"),
    MEDIO("Medio"),
    GRANDE("Grande"),
    MOTO("Moto"),
    PADRAO("Padrão");

    private String descricao;

    private Ecategoria (String descricao) {
     this.descricao = descricao;
    }

    public String getDescricao()
    {
        return descricao;
    }

}
