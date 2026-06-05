class Solution {

    List<Integer> list = new ArrayList<>();
    Random rand = new Random();

    public Solution(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}