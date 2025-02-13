class NoArvore<T>(val dado: T) {
    val descendente = mutableListOf<NoArvore<T>>()

    fun addDescendente(filho: NoArvore<T>) {
        descendente.add(filho)
    }
    fun removeDescendente(filho: NoArvore<T>) {
        descendente.remove(filho)
    }
}
