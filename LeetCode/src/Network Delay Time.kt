

private fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
    val map = createNodeMap(times, N, K)
    val distance = dijkstra(map, N, K)
    return distance.max().let { if(it == Int.MAX_VALUE) -1 else it ?: -1 }
}

private fun createNodeMap(times: Array<IntArray>, n: Int, k: Int): Array<IntArray> {
    val map = Array(n + 1) {
        IntArray(n + 1) { Int.MAX_VALUE }
    }

    map[k][k] = 0

    times.forEach {
        val start = it[0]
        val target = it[1]
        val value = it[2]
        map[start][target] = value
    }

    return map
}

private fun dijkstra(map: Array<IntArray>, n: Int, k: Int): IntArray {
    //distance를 k -> 노드로 직접 연결된 가중치로 초기화
    val distance = IntArray(n + 1) { i -> map[k][i] }
    val isVisited = BooleanArray(n + 1) { false }

    //자기자신 가중치 0, 방문함으로 변경
    distance[k] = 0
    isVisited[k] = true

    for (x in 0 until n - 1) {
        var min = Int.MAX_VALUE
        var minNode = -1;

        for (i in 1..n) {
            if (!isVisited[i] && distance[i] != Int.MAX_VALUE && distance[i] < min) {
                min = distance[i];
                minNode = i
            }
        }

        if (minNode == -1) {
            break;
        }
        isVisited[minNode] = true

        for (i in 1..n) {
            if (!isVisited[i] && map[minNode][i] != Int.MAX_VALUE) {
                distance[minNode].plus(map[minNode][i]).let {
                    if (it < distance[i]) {
                        distance[i] = it
                    }
                }
            }
        }
    }

    distance[0] = -1
    return distance
}