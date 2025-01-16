data class Produto (
    val nome: String,
    val categoria: String,
    val preco: Double,
    val tamanho: String,
    val cor: String,
    var qtdEstoque: Int
) : InterfaceProduto {

    private var ponteiroPrimeiro: NoDuplo? = null;
    private var ponteiroUltimo: NoDuplo? = null;
    private var quantidade = 0;
    private var tamanhoLista = 10;



    // Lista de Produtos
    override fun inserirProduto(product: Produto) {
        
        if (!estaCheia()) {
            var aux = ponteiroPrimeiro;
            
            // Passa pela lista para verificar se já existe um Produto igual ao que está tentando ser inserido
            while (aux != null) {
                if (aux.conteudoProduto.nome == product.nome) {
                    println("Produto com o nome '${product.nome}' já existe na lista.")
                    break;
                }
                aux = aux.proximo;
            }
            val noNovo = NoDuplo(product)  // criando nó do produto a ser inserido

            // Se a lista estiver vazia ele aponta os ponteiros para ele e adiciona 1 a quant
            if (quantidade == 0) {
                ponteiroPrimeiro = noNovo
                ponteiroUltimo = noNovo
                quantidade++

            // se não, ele será inserido no final da lista
            } else {
                ponteiroUltimo?.proximo = noNovo;
                noNovo.anterior = ponteiroUltimo;
                ponteiroUltimo = noNovo;
                quantidade++
            }
        } else {
            println(" Erro! A lista está cheia!")
        }
     }

    override fun aualizarProduto(nome: String, product: Produto) {
        if (!estaVazia()) {
            var aux = ponteiroPrimeiro;
            var produtoAntigo = ponteiroUltimo;
            var contem : Boolean = false;
            
            // Passa pela lista procurando o Produto a ser atualizado pelo nome inserido no parâmetro
            while (aux != null) {
                if (nome == aux.conteudoProduto.nome) {
                    produtoAntigo = aux;
                    contem = true;
                }
                aux = aux.proximo;
            }

            // Se estiver encontrado na lista, ele atualiza o objeto Produto pelo novo que está no parâmetro da função
            if (contem == true) {
                produtoAntigo?.conteudoProduto = product;

            // Se não, é porque ele não foi encontrado
            } else {
                println(" Erro! Produto não encontrado.")
            }
        } else {
            println("Erro! A lista de produtos está vazia.")
        }
     }

    override fun apagarProduto(nome: String) {
        if (!estaVazia()) {
            var aux = ponteiroPrimeiro;
            var produtoApagar = ponteiroUltimo;
            var contem : Boolean = false;
            
            // Passa pela lista procurando o Produto a ser excluído pelo nome inserido no parâmetro
            while (aux != null) {
                if (nome == aux.conteudoProduto.nome) {
                    produtoApagar = aux;
                    contem = true;
                }
                aux = aux.proximo;
            }

            // Se estiver encontrado na lista, ele irá verificar se ele é o único da lista, ou o ultimo, ou se está entre dois nós
            if (contem == true) {
                if (quantidade == 1) {
                    ponteiroUltimo = null;
                    ponteiroPrimeiro = null;
                    quantidade = 0;
                } else if (produtoApagar?.proximo == null) {
                    aux = produtoApagar?.anterior;
                    aux?.proximo = null;
                    produtoApagar?.anterior = null;
                    ponteiroUltimo = aux;
                    quantidade--;
                } else {
                    var auxAnterior = produtoApagar.anterior;
                    var auxProximo = produtoApagar.proximo;
                    produtoApagar.anterior = null;
                    produtoApagar.proximo = null;
                    produtoApagar.conteudoProduto = null;
                    auxAnterior?.proximo = auxProximo;
                    auxProximo?.anterior = auxAnterior;
                    quantidade--;
                }
            } else {
            println("Erro! A lista de produtos está vazia.")
        }
    }
}

    override fun estaCheia(): Boolean { 
        return (quantidade == tamanhoLista);
    }

    override fun estaVazia(): Boolean {
        return (quantidade == 0);
     }

    override fun imprimir(): String {
            var aux = ponteiroPrimeiro;
            var produto = aux?.conteudoProduto;
            var lista: String = " Lista de produtos [ "

            while (aux != null) {
                produto = aux.conteudoProduto;
                lista +=  " \n Nome: ${produto?.nome}, Categoria: ${produto?.categoria}, Preço: R$ ${produto?.preco}, Tamanho: ${produto?.tamanho}, Cor: ${produto?.cor}, Estoque: ${produto?.qtdEstoque}"
                aux.proximo;
            }
            lista += "\n ]"
            return lista;
}
}