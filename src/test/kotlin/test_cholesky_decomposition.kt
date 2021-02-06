import kotlin.test.assertTrue
import kotlin.test.Test

class TestCholeskyDecompositions {
    @Test
    fun testSimple() {
        val a = Matrix(
            arrayOf(
                arrayOf(1.0, 0.0, 0.0),
                arrayOf(0.0, 1.0, 0.0),
                arrayOf(0.0, 0.0, 1.0),
            )
        )
        assertTrue { a.epsilonEqual(choleskyDecomposition(a * a.transposed)) }
    }

    @Test
    fun testInteger() {
        val a = Matrix(
            arrayOf(
                arrayOf(12.0, 0.0, 0.0, 0.0),
                arrayOf(343.0, 188.0, 0.0, 0.0),
                arrayOf(242.0, 13.0, 121.0, 0.0),
                arrayOf(21.0, 2.0, 1.0, 243.0),
            )
        )

        assertTrue { a.epsilonEqual(choleskyDecomposition(a * a.transposed)) }
    }

    @Test
    fun testPositive() {
        val a = Matrix(
            arrayOf(
                arrayOf(132.34, 0.0, 0.0, 0.0),
                arrayOf(3.111, 8.12, 0.0, 0.0),
                arrayOf(100.0, 13.231, 121.0, 0.0),
                arrayOf(1.11, 22.5, 11.23, 9.67),
            )
        )

        assertTrue { a.epsilonEqual(choleskyDecomposition(a * a.transposed)) }
    }

    @Test
    fun testNonPositive() {
        val a = Matrix(
            arrayOf(
                arrayOf(32.34, 0.0, 0.0, 0.0),
                arrayOf(-31.81, 934.1, 0.0, 0.0),
                arrayOf(0.0, -123.31, 1.0, 0.0),
                arrayOf(321.311, -412.25, 9.63, 10.5),
            )
        )

        assertTrue { a.epsilonEqual(choleskyDecomposition(a * a.transposed)) }
    }

}
