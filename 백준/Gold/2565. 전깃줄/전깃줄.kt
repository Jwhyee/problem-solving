import java.util.StringTokenizer
import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val dp = IntArray(n) { -1 }
    val graph = Array(n) { IntArray(2) }

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        graph[i][0] = st.nextToken().toInt()
        graph[i][1] = st.nextToken().toInt()
    }
    
    graph.sortWith { o1, o2 -> o1[0] - o2[0] }

    for (i in dp.indices) {
        dp[i] = 1
        for (j in 0 until i) {
            if (graph[i][1] > graph[j][1]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    var max = 0
    for (i in 0 until n) {
        max = max(max, dp[i])
    }

    println(n - max)
}