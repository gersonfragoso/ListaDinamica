public class ListaEncadeada {
    private int tamanhoLista = 10;
    private NoEncadeado primeiroNo = null;
    private NoEncadeado ultimoNo = null;
    private int quantidade = 0;

    public int Quantidade(){ //VERIFICAR O TAMANHO DA LISTA
        return quantidade;
    }
    public boolean listaVazia(){ // SE A LISTA ESTA VDAZIA
        if(quantidade == 0){
            return true;
        }
        return false;
    }
    public boolean listaCheia(){ //SE A LISTA ESTA CHEIA
        if(quantidade == tamanhoLista){
            return true;
        }
        return false;
    }

// PRIMEIRO VAMOS CRIAR OS METODOS INSERIR NO INICIO O NO FINAL
// ASSIM SIMPLIFICA PARA O METODO INSERIR NA POSIÇÃO
// POIS DEPENDENDO DA LISTA É SO INSERIR OU NO FINAL OU NO INICIO
    public void inserirInicio(int valor){ //INSERIR O VALOR NO INICIO
        NoEncadeado no = new NoEncadeado();

        if(listaCheia() == true){//FAZ A CHECAGEM SE A LISTA ESTA CHEIA
            System.out.println("lista cheia");
        }else{//CASO NAO ESTEJA ELE CONTINUA A OPERAÇÃO
            no.setValor(valor);
            no.setProximoNo(primeiroNo);
            primeiroNo = no;
            ultimoNo = primeiroNo;
            quantidade ++;
        }

    }
    public void inserirFinal(int valor){//INSERIR NO FINAL
        if(quantidade == 0){//NESSE CASO SE A LISTA FOR VAZIA ELE É SO INSERIR NO COMEÇO
            inserirInicio(valor);
        }else{
            if(listaCheia() == true){ //FAZ A CHECAGEM SE A LISTA ESTA CHEIA
                System.out.println("lista cheia");
            }else{//CASO NAO ELE VARRE A LISTA ATE O ULTIMO NO E INSERI O VALOR
                NoEncadeado no = new NoEncadeado();
                no.setValor(valor);
                no.setProximoNo(null);
                ultimoNo.setProximoNo(no);
                quantidade ++;

            }
        }
    }
    public void InserirNaPosicao(int posicao, int valor){ //INSERIR EM UMA POSIÇÃO ESPECIFICA
        if(listaCheia()==true) {//FAZ A CHECAGEM SE A LISTA ESTA CHEIA
            System.out.println("lista cheia");
        }
        else if(quantidade == 0 ){ //INSERIR NO INICIO
            inserirInicio(valor);
        } else if (posicao == quantidade) {//INSERIR NO FINAL
            inserirFinal(valor);
        }

        else{//FUNÇÃO PARA INSERIR EM UM DETERMINADA FUNÇÃO
            if(posicaoExiste(posicao)) {
                if(buscarPosicao(posicao)==null) {//AQUI FAZ A CHECAGEM PARA VER SE A POSIÇÃO NAO ESTA OCUPADA JA QUE TEMOS O METODOS PARA ALTERAR
                    NoEncadeado noPosicao = buscarPosicao(posicao);
                    noPosicao.setValor(valor);
                    quantidade++;
                }else{
                    System.out.println("use o metodo modificar/remover");
                }
            }else{
                System.out.println("posição nao existe");
            }
        }
    }
    public NoEncadeado buscarPosicao(int posicao) { //BUSCAR A POSIÇÃO DO ELEMENTO
        if (!posicaoExiste(posicao)) {
            throw new RuntimeException("posição nao existe");//AQUI COLOQUEI UM THROW PUT CASO A POSIÇÃO NAO EXISTA NA LISTA
        }
        NoEncadeado atual = primeiroNo; // CRIANDO O NO ATUAL PARA VARRER A LISTA
        for (int i = 0; i < posicao; i++) {//VARRENDO A LISTA
            atual = atual.getProximoNo();
        }
        System.out.println(atual.getValor());//RETORNANDO O VALOR PARA O MAIN COMO STRING
        return atual;//RETORNANDO O VALOR PARA O MAIN
    }
    private boolean posicaoExiste(int posicao){ //CHEGAGEM SE A POSIÇÃO EXISTE
        if(posicao >= 0 && posicao < quantidade){
            return true;
        }

        return false;
    }
    public void removerNaPosicao(int posicao){ //REMOVER ELEMENTO PELA A POSIÇÃO
        if(quantidade == 0){ //CHAMO O METODO REMOVERINICIO QUE FOI FEITO MAIS ABAIXO
            removerInicio();
        }else if(posicao == quantidade){//CHAMO O METODO REMOVERFINAL QUE FOI FEITO MAIS ABAIXO
            removerFinal();
        }else{ // ESSE É O METODO QUE VAI REMOVER DE ACORDO COM A POSIÇÃO
            NoEncadeado noPosicaoAnterior = buscarPosicao(posicao -1);//O -1 É POR CAUSA QUE O INDICE COMEÇA EM 0
            NoEncadeado noPosicaoAtual= noPosicaoAnterior.getProximoNo();
            if(noPosicaoAtual.getProximoNo()!= null){
                noPosicaoAnterior.setProximoNo(noPosicaoAtual.getProximoNo());
                quantidade --;

            }else{
                noPosicaoAnterior.setProximoNo(null);
            }
        }

    }
    public void removerInicio(){ //REMOVER NO INICIO
        if(quantidade == 0){
            return ;
        }
        primeiroNo = primeiroNo.getProximoNo();
        quantidade --;

    }
    public void removerFinal(){//REMOVER NO FINAL
        if(quantidade == 0){//SE A LISTA ESTIVER VAZIA
            listaVazia();
        }else if(quantidade == 1){//SE ESTIVER APENAS 1 VALOR
            removerInicio();
            return ;

        }else {
            NoEncadeado noPosicaoAnterior = buscarPosicao(quantidade - 2);// METODO DA REMOÇÃO NO FINAL
            noPosicaoAnterior.setProximoNo(null);
            quantidade--;

        }

    }
    public void obterModificar(int posicao, int valor){ // METODO PARA BUSCAR A POSIÇÃO E MODIFICAR O ELEMENTO
        if (!posicaoExiste(posicao)) {
            throw new RuntimeException("posição nao existe"); // CASO A POSIÇÃO NAO EXISTA
        }
        NoEncadeado atual = primeiroNo;
        for (int i = 0; i < posicao; i++) { //PERCORRER A LISTA ATE ACHAR A POSIÇÃO
            atual = atual.getProximoNo();
        }
        atual.setValor(valor);  //SUBSTITUINDO O VALOR
        System.out.println("valor atualizado");

    }
    String retornarElementos() { //RETORNA OS VALORES NA LISTA
        StringBuilder elementos = new StringBuilder("[");

        NoEncadeado atual = primeiroNo;

        while (atual.getProximoNo() != null) { //WHILE PARA PERCORRER A LISTA E PEGAR OS VALORES
            elementos.append(atual.getValor());
            elementos.append(" ");
            atual = atual.getProximoNo();
        }

        elementos.append(atual.getValor());

        elementos.append("]");

        return elementos.toString();
    }


}
