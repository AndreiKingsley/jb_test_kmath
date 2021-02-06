fun printMatrix(a: Matrix) {
    for (i in 0 until a.shape.first) {
        for (j in 0 until a.shape.second) {
            print(a[i, j])
            print(" ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    val m = Matrix(
        arrayOf(
            arrayOf(4.0, 0.0, 0.0),
            arrayOf(8.0, 15.0, 0.0),
            arrayOf(16.0, -2.3, 4.2),
        )
    )
    val a = m * m.transposed
    printMatrix(choleskyDecomposition(a))
}