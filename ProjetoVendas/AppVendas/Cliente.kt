class Cliente(
    nome: String
    cpf: String
    telefone: Int
    endereco: String
    var historico: MutableList<Vendas>
) : Pessoa(nome, cpf, telefone, endereco) {

    fun relatorioCliente(): Any? {
        // Lógica para gerar relatório do cliente
        return null
    }

    fun historicoCompra(): List<Vendas> {
        
        // Retorna a lista historico
        return historico
    }

    fun fidelizarCliente() {
        
        // historico.size mostra o tamanho da lista que está armazenado o historico de compras do cliente 

        // Se o cliente tiver 5 ou mais comprar já feitas, ele tem direito a 5% de desconto nas compras.
        if (historico.size >= 5) { 
            println("O cliente tem desconto de 5% nas compras!")
        } else {
            var falta: Int = 5 - historico.size
            println("O cliente ainda não tem desconto por fidelidade! \n Faltam " + falta + " compras para ele ter desconto nas próximas compras.")
        }
    }    
}