// https://open.kattis.com/problems/lastchristmas

fun onlyMaxCount(
    top: List<String>,
    candidates: List<String>,
): List<String> {
    val counts = top.groupingBy { it }.eachCount()
    val maxValue = candidates.maxOf { counts[it] ?: 0 }
    return candidates.filter {
       (counts[it] ?: 0) == maxValue
    }
}

fun main() {
    val data = List(readln().toInt()) {
        readln().split(" ")
    }
    val bestByTotal = onlyMaxCount(
        data.flatten(),
        data.flatten(),
    )
    val best = (0 until 10)
        .fold(bestByTotal) { prevBest, pos ->
            onlyMaxCount(data.map { it[pos] }, prevBest)
        }.singleOrNull()
    println(best ?: "tie")
}
