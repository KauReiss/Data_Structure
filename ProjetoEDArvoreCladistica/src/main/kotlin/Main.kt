import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("🌿 Bem-vindo à Árvore Cladística!")
    print("Digite a espécie raiz: ")
    val especieRaiz = scanner.nextLine()

    val tree = ArvoreCladistica(NoArvore(especieRaiz))

    while (true) {
        println("\n📜 MENU:")
        println("1️⃣ Inserir Espécie")
        println("2️⃣ Visualizar Árvore")
        println("3️⃣ Buscar Espécie")
        println("4️⃣ Remover Espécie")
        println("5️⃣ Sair")
        print("👉 Escolha uma opção: ")

        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine() // Limpar buffer
                print("🔹 Espécie ancestral: ")
                val pai = scanner.nextLine()
                print("🔹 Nova espécie: ")
                val novaEspecie = scanner.nextLine()
                tree.inserirEspecie(pai, novaEspecie)
            }
            2 -> {
                println("\n🌳 Árvore Cladística:")
                tree.imprimirArvore(tree.raiz)
            }
            3 -> {
                scanner.nextLine() // Limpar buffer
                print("🔍 Buscar espécie: ")
                val search = scanner.nextLine()
                val found = tree.buscarEspecie(tree.raiz, search)
                if (found != null) {
                    println("✅ Espécie '$search' encontrada!")
                } else {
                    println("❌ Espécie '$search' não encontrada.")
                }
            }
            4 -> {
                scanner.nextLine() // Limpar buffer
                print("❌ Remover espécie: ")
                val remover = scanner.nextLine()
                tree.removerEspecies(remover)
                println("✅ Espécie '$remover' e seus descendentes foram removidos.")
            }
            5 -> {
                println("🚪 Saindo...")
                break
            }
            else -> println("⚠️ Opção inválida! Tente novamente.")
        }
    }
    scanner.close()
}