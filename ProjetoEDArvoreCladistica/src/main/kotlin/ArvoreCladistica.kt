class ArvoreCladistica<T> (var raiz: NoArvore<T>) {

    fun buscarEspecie(no: NoArvore<T>?, especie: T):NoArvore<T>? {
        if (no == null){
            return null
        }
        if (no.dado == especie) {
            return no
        }

        for (filho in no.descendente) {
            val encontrado = buscarEspecie(filho, especie)
            if (encontrado != null) {
                return encontrado
            }
        }
        return null
    }

    fun inserirEspecie(ancestral: T, novaEspecie: T) {
        val noPai = buscarEspecie(raiz, ancestral)
        if (noPai != null) {
            noPai.addDescendente(NoArvore(novaEspecie, ancestral))
            println("✅ A Espécie '$novaEspecie' adicionada sob '$ancestral'.")
        } else {
            println("❌ A Espécie ancestral ' $ancestral' não foi encontrada!")
        }
    }

    fun removerEspecies(especie: T): Boolean {
        if (raiz?.dado == especie) {
            val filhosParaRemover = raiz.descendente.toList() // Cria uma cópia da lista para evitar modificação durante a iteração
            for (filho in filhosParaRemover) {
                raiz.removeDescendente(filho)
            }
            println("🌿 Raiz da árvore removida. Todas as espécies foram apagadas.")
            return true
        }

        removerNo(raiz, especie) // Se não for a raiz, busca e remove
        return false
    }

    fun removerNo(no: NoArvore<T>?, especie: T) {
        if (buscarEspecie(no, especie) == null) {
            println("❌ A Espécie '$especie' não encontrada.")
        } else {
            no?.descendente?.removeIf {it.dado == especie}
            no?.descendente?.forEach {removerNo(it, especie)}
            println("✅ A Espécie '$especie' e seus descendentes foram removidos.")
        }

    }

    fun imprimirArvore(no: NoArvore<T>, depth: Int = 0) {
        if (no == null) return
        println("${" ".repeat(depth * 2)}🔹 ${no.dado}")
        for (descendente in no.descendente) {
            imprimirArvore(descendente, depth + 1)
        }
    }

    fun imprimirFilogenetica(no: NoArvore<T>?, especie: T) {
        if (no == null){
            return
        }
        if (no.dado == especie) {
            println("🌳 Relação Filgenética '$especie':")
            imprimirArvore(no)
            return
        }

        for (filho in no.descendente) {
            val procura = buscarEspecie(filho, especie)
            if (procura != null) {
                println("🌳 Relação Filgenética '${procura.dado}':")
                imprimirArvore(procura)
                return
            }
        }
        println("❌ Espécie '$especie' não escontrada!")
    }
}

