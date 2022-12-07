public class Main {
    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();

        System.out.println(lista.listaVazia());
        lista.inserirInicio(15);
        lista.inserirInicio(5);
        lista.inserirInicio(4);
        lista.inserirInicio(3);
        lista.inserirInicio(2);
        lista.inserirInicio(18);
        lista.inserirInicio(17);
        lista.inserirInicio(16);
        lista.inserirInicio(14);
        lista.inserirInicio(13);
        lista.InserirNaPosicao(3,4);
        lista.obterModificar(3,10000);
        System.out.println(lista.retornarElementos());
        lista.removerNaPosicao(10);
        System.out.println(lista.Quantidade());
        System.out.println(lista.retornarElementos());


    }
}
