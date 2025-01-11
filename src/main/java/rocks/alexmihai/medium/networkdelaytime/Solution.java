package rocks.alexmihai.medium.networkdelaytime;

import java.util.*;

/**
 * It's Dijkstra's algorithm, while keeping track of the max value (maximum time to get to any node).
 */
public class Solution {
    private record Node(int target, int weight) { }
    private record Path(int target, int distanceFromStart) { }

    public int networkDelayTime(int[][] times, int n, int k) {
        var adjList = new HashMap<Integer, List<Node>>();

        for (int[] time : times) {
            adjList.putIfAbsent(time[0], new ArrayList<>());
            adjList.get(time[0]).add(new Node(time[1], time[2]));
        }

        var visited = new HashSet<Integer>(n);

        var visitQueue = new PriorityQueue<>(Comparator.comparing(Path::distanceFromStart));
        visitQueue.add(new Path(k, 0));

        var res = 0;
        while (!visitQueue.isEmpty()) {
            var current = visitQueue.poll();
            if (visited.contains(current.target)) continue;

            visited.add(current.target);
            res = Math.max(res, current.distanceFromStart);

            if (adjList.get(current.target) == null) continue;

            for (var neighbor : adjList.get(current.target)) {
                if (visited.contains(neighbor.target)) continue;

                visitQueue.add(new Path(neighbor.target, current.distanceFromStart + neighbor.weight));
            }
        }

        if (visited.size() < n) return -1;
        return res;
    }
}
