class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> ans = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.get(t.get(0)).offer(t.get(1));
        }

        dfs("JFK");
        return ans;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = map.get(src);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }

        ans.addFirst(src);
    }
}