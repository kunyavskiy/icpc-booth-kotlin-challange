// https://open.kattis.com/problems/arcadecrane

fun main() {
    val n = readln().toInt()
    var a = readln().split(" ").map { it.toInt() - 1 }
    val ans = mutableListOf<Pair<Int, Int>>()
    fun move(f: Int, t: Int) {
        ans.add(Pair(f + 1, t + 1))
        val mid = if (f < t) {
            a.subList(f + 3, t + 3) + a.subList(f, t + 3)
        } else {
            a.subList(f, f + 3) + a.subList(t, f)
        }
        a = a.subList(0, minOf(f, t)) + mid +
                a.subList(maxOf(f, t) + 3, a.size)
    }
    fun swapPreLast() {
        move(n - 3, n - 5); move(n - 3, n - 4)
        move(n - 3, n - 5)
    }
    fun swapLast() {
        move(n - 3, n - 4); swapPreLast(); move(n - 4, n - 3)
    }
    for (i in 0 until n - 3) {
        repeat(2) {
            a.indexOf(i).takeIf { it != i }?.let { cur ->
                move(minOf(cur, n - 3), i)
            }
        }
    }
    if (a[n - 3] > a[n - 2]) swapPreLast()
    if (a[n - 2] > a[n - 1]) swapLast()
    if (a[n - 3] > a[n - 2]) swapPreLast()
    println(ans.size)
    for ((f, s) in ans) { println("$f $s") }
}
