class Funcionario(
    usuario: String,
    senha: String,
    nome: String = "",
    cpf: String = "",
    telefone: Int = 0,
    endereco: String = ""
) : Pessoa(nome, cpf, telefone, endereco) {
    val usuario = usuario
    val senha = senha

    fun verificarLogin(user: String, password: String): Boolean {
        var verificacao: Boolean= false;
        
        // Verifica se o usuario e senha inseridos no parâmetro estão corretos com o login do Funcionario
        if (user == usuario && password == senha) {
            verificacao = true
        }
        return verificacao;
    }
}