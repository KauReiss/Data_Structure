class ArvoreCladistica<T> (var raiz: NoArvore<T>) {

    fun buscarEspecie(no: NoArvore<T>?, especie: T,):NoArvore<T>? {
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
            println(" Espécie '$novaEspecie' adicionada sob '$ancestral'.")
        } else {
            println(" Espécie ancestral ' $ancestral' não foi encontrada!")
        }
    }

    fun removerEspecies(especie: T): Boolean {
        if (raiz?.dado == especie) {
            // Criar uma cópia da lista para evitar modificação durante a iteração
            val filhosParaRemover = raiz.descendente.toList()
            for (filho in filhosParaRemover) {
                raiz.removeDescendente(filho)  // Remove sem erro
            }

            println("🌿 Raiz da árvore removida. Todas as espécies foram apagadas.")
            return true
        }

        removerNo(raiz, especie) // Se não for a raiz, busca e remove
        return false
    }

    fun removerNo(no: NoArvore<T>?, especie: T) {
        no?.descendente?.removeIf {it.dado == especie}
        no?.descendente?.forEach {removerNo(it, especie)}
    }

    fun imprimirArvore(no: NoArvore<T>, depth: Int = 0) {
        if (no == null) return
        println("${" ".repeat(depth * 2)}🔹 ${no.dado}")
        for (descendente in no.descendente) {
            imprimirArvore(descendente, depth + 1)
        }
    }
}

