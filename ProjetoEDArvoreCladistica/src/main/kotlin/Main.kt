import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("🌿 Bem-vindo à Árvore Cladística!")
    print("🐾 Digite a espécie raiz: ")
    val especieRaiz = scanner.nextLine()

    var tree = ArvoreCladistica(NoArvore(especieRaiz, ""))

    while (true) {
        println("\n📜 MENU:")
        println("1️⃣ Inserir Espécie")
        println("2️⃣ Visualizar Árvore Completa")
        println("3️⃣ Buscar Espécie")
        println("4️⃣ Destalhes de Espécie")
        println("5️⃣ Remoção de Espécie")
        println("6️⃣ Visualizar relação filogenética")
        println("7️⃣ Sair")

        print("👉 Escolha uma opção: ")
        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine() // Limpar buffer
                print("🔹 Espécie ancestral: ")
                val pai = scanner.nextLine()
                if (tree.buscarEspecie(tree.raiz, pai) == null) {
                    println("❌ O Ancestral '$pai' não foi encontrado.")
                } else {
                    print("🔹 Nova espécie: ")
                    val novaEspecie = scanner.nextLine()
                    tree.inserirEspecie(pai, novaEspecie)
                }
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
                    println("✅ A Espécie '$search' foi encontrada!")
                } else {
                    println("❌ A Espécie '$search' não foi encontrada.")
                }
            }
            4 -> {
                scanner.nextLine() // Limpar buffer
                print("🐾 Detalhes da espécie: ")
                val search = scanner.nextLine()
                val found = tree.buscarEspecie(tree.raiz, search)
                if (found != null) {
                    if (found.ancestral != "") {
                        if (found.temDescendentes()){
                            val ancestral = found.ancestral
                            print("✅ A Espécie '$search' tem como ancestral '$ancestral' e descendentes.")
                            found.imprimirDescendentes()
                        } else {
                            val ancestral = found.ancestral
                            println("✅ A Espécie '$search' tem como ancestral '$ancestral' e não tem descendentes.")
                        }
                    } else {
                        println("✅ A Espécie '$search' é a raiz da árvore.")
                    }
                } else {
                    println("❌ A Espécie '$search' não foi encontrada.")
                }
            }
            5 -> {
                scanner.nextLine() // Limpar buffer
                print("❌ Remover espécie: ")
                val remover = scanner.nextLine()
                if (tree.removerEspecies(remover)) {
                    print("🐾 Qual espécie será a nova raiz: ")
                    val novaRaiz = scanner.nextLine()
                    tree = ArvoreCladistica(NoArvore(novaRaiz, ""))
                }
            }

            6 -> {
                scanner.nextLine() // Limpar buffer
                print("🐾 Filogenética de qual espécie: ")
                val especie = scanner.nextLine()
                tree.imprimirFilogenetica(tree.raiz, especie)
            }

            7 -> {
                println("🚪 Saindo...")
                break
            }
            else -> println("⚠️ Opção inválida! Tente novamente.")
        }
    }
    scanner.close()
}