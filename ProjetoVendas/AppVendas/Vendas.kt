import java.time.LocalDate

class Vendas(
    val id: Int,
    val cliente: Cliente,
    val metodoPagamento: String,
    val dataVenda: LocalDate,
    val itens: List<Produto>,
    val vendedor: Funcionario,
) {
    fun registrarVenda(venda: Vendas) {
    
    // Adiciona a venda ao histórico do cliente
    cliente.historico.add(venda)
    }

    fun cancelarVenda(id: Int) {
        // Lógica para cancelar uma venda específica
    }

    fun relatorioVendas() {
        // Lógica para gerar um relatório das vendas
    }
}