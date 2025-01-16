interface InterfaceProduto{
    
    fun inserirProduto(product: Produto);
    fun aualizarProduto(nome: String, product: Produto);
    fun apagarProduto(nome: String);

    fun estaCheia(): Boolean;
    fun estaVazia(): Boolean;
    fun imprimir(): String;
}