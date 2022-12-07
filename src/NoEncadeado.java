public class NoEncadeado {
    private int valor;
    private NoEncadeado proximoNo;

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setProximoNo(NoEncadeado proximoNo) {
        this.proximoNo = proximoNo;
    }

    public NoEncadeado getProximoNo() {
        return proximoNo;
    }

    public int getValor() {
        return valor;
    }

}