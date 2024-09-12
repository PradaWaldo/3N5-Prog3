package org.pradavelasque

fun main() {
var list1 = listOf(0.1, 12.34, -0.1234, 3.1416)
var liste1Inverse = triInverseAlaMain(list1)
    println(liste1Inverse)
}

fun triInverseAlaMain(list: List<Double>): MutableList<Double> {
    var listeNombre = list.toMutableList()

    for (i in 0 until listeNombre.size -1 ){
        for (j in i + 1 until  listeNombre.size) {
            if (listeNombre[i] < listeNombre[j]){
                var temp = listeNombre[i]
                listeNombre[i] = listeNombre[j]
                listeNombre[j] = temp
            }
        }
    }
    return listeNombre
}