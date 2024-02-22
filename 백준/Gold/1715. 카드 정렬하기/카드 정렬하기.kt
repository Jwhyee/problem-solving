package greedy

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
   val n = readLine().toInt()
   val cards = PriorityQueue<Int>()

   // 큐에 모든 카드를 넣음
   repeat(n) {
      cards += readLine().toInt()
   }

   // 총 합
   var total = 0

   // 카드 묶음이 비어있을 때까지 반복
   while (cards.isNotEmpty()) {
      // 현재 카드 묶음
      val cur = cards.poll()

      // 큐가 비어있지 않을 경우 다음 카드를 꺼내서 현재 묶음과 더함
      if (cards.isNotEmpty()) {
         val sum = cur + cards.poll()
         total += sum
         cards += sum
      }
   }

   println(total)

}