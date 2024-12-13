data class NoDuplo( var conteudoProduto: Produto) {
    var anterior: NoDuplo? = null;
    var proximo: NoDuplo? = null;

}