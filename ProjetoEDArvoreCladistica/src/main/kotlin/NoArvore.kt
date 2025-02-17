class NoArvore<T>(val dado: T, val ancestral: T) {

    val descendente = mutableListOf<NoArvore<T>>()  // Lista de descendentes do nó(espécie)

    fun addDescendente(filho: NoArvore<T>) {
        descendente.add(filho)
    }
    fun removeDescendente(filho: NoArvore<T>) {
        descendente.remove(filho)
    }
    fun imprimirDescendentes(){
        if (descendente.isEmpty()) {
            return
        }
        for (filho in descendente) {
            print(" '${filho.dado}'")
        }
        println(".")
    }

    fun temDescendentes() :Boolean {
        if (descendente.isEmpty()) {
            return false
        } else {
            return true
        }
    }
}

