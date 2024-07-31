package Domain.janelas;

public class JanelaBasculante extends Janela
{
    protected String estado;
    protected String condicao;


    public String getEstado() {
        return estado;
    }

    public String getCondicao() {
        return condicao;
    }

    public void travar()
    {
        if (this.estado == "ABERTA")
        {
            System.out.println(this.getClass().getSimpleName() + " não pode ser travada pq está " + getEstado());
        }else
        {
            this.condicao = "TRAVADA";
            System.out.println(this.getClass().getSimpleName() + " foi " + getCondicao());
        }
    }
    public void destravar()
    {
        this.condicao = "DESTRAVADA";
        System.out.println(this.getClass().getSimpleName() + " foi " + getCondicao());
    }

    public void abrir()
    {
        if (this.condicao == "TRAVADA")
        {
            System.out.println(this.getClass().getSimpleName() + " não pode ser aberta pq está " + this.condicao);
        }else 
        {
            this.estado = "ABERTA";
            System.out.println(this.getClass().getSimpleName() + " foi " + getEstado());
        }

    }
    public void fechar()
    {
        this.estado = "FECHADA";
        System.out.println(this.getClass().getSimpleName() + " foi " + getEstado());
    }

}