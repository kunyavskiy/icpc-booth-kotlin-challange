// https://open.kattis.com/problems/fairshare

fun main() {
    val n = readln().toInt()
    val d = List(n) {
        readln().split(" ").map { it.toLong() }
    }
    val totalCash = d.sumOf { (cash, _) -> cash }
    val totalSpent = d.sumOf { (_, spent) -> spent }
    val res = d.indexOfFirst { (cash, spent) ->
        totalSpent - (totalCash - cash) <= spent
    }
    println(if (res == -1) "imposible" else res + 1)
}
