package Domain.portas;

public class PortaGiratoria extends Porta
{
    protected String estado;
    protected String condicao;
    
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getCondicao() {
        return condicao;
    }
    
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }
    
    public void travar()
    {
        this.setCondicao("TRAVADO");
        System.out.println("Esta " + this.getClass() + "foi" + getCondicao());
    }
    public void destravar()
    {
        this.setCondicao("DESTRAVADO");
        System.out.println("Esta " + this.getClass() + "foi" + getCondicao());
    }
    
    public void abrir()
    {
        this.setEstado("ABERTO");
        System.out.println("Esta " + this.getClass() + "foi" + getEstado());
    
    }
    public void fechar()
    {
        this.setEstado("FECHADO");
        System.out.println("Esta " + this.getClass() + "foi" + getEstado());
    }
    
}
