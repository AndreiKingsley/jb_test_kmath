import kotlin.math.sqrt

fun choleskyDecomposition(a: Matrix): Matrix {

    // assume all requirements are met

    val n = a.shape.first
    val bufferMatrix = Matrix(Pair(n, n))
    for (i in 0 until n) {
        for (j in 0 until i) {
            var l = a[i, j]
            for (k in 0 until j) {
                l -= bufferMatrix[i, k] * bufferMatrix[j, k]
            }
            bufferMatrix[i, j] = l / bufferMatrix[j, j]
        }
        var l = a[i, i]
        for (j in 0 until i) {
            l -= bufferMatrix[i, j] * bufferMatrix[i, j]
        }
        bufferMatrix[i, i] = sqrt(l)
    }
    return bufferMatrix
}