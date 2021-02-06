import kotlin.math.abs

/*
    Simple matrix implementation
 */
class Matrix(private val array: Array<Array<Double>>) {

    val shape: Pair<Int, Int> = Pair(array.size, array[0].size)

    val rowNumber = shape.first
    val columnNumber = shape.second

    val transposed: Matrix
        get() {
            val bufferMatrix = Matrix(Pair(shape.second, shape.first))
            for (i in 0 until rowNumber) {
                for (j in 0 until columnNumber) {
                    bufferMatrix[j, i] = this[i, j]
                }
            }
            return bufferMatrix
        }

    constructor(shape: Pair<Int, Int>) : this(
        Array(shape.first) { Array(shape.second) { 0.0 } }
    )

    operator fun set(i: Int, j: Int, value: Double) {
        array[i][j] = value
    }

    operator fun get(i: Int, j: Int): Double {
        return array[i][j]
    }

    operator fun times(other: Matrix): Matrix {
        val l = this.shape.first
        val m = this.shape.second
        val n = other.shape.second
        var res = Matrix(Pair(l, n))
        for (i in 0 until l) {
            for (j in 0 until n) {
                var sum = 0.0
                for (k in 0 until m) {
                    sum += this[i, k] * other[k, j]
                }
                res[i, j] = sum
            }
        }
        return res
    }

    fun epsilonEqual(other: Matrix, epsilon: Double = 1e-5): Boolean {
        if (this.shape != other.shape) {
            return false
        }
        for (i in 0 until rowNumber) {
            for (j in 0 until columnNumber) {
                if (abs(other[i, j] - this[i, j]) > epsilon) {
                    return false
                }
            }
        }
        return true
    }
}