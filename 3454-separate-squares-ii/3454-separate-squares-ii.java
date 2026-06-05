import java.util.*;

class Solution {

    class Node {
        int l, r, cnt;
        long len;
    }

    class SegmentTree {
        Node[] tr;
        int[] xs;

        SegmentTree(int[] xs) {
            this.xs = xs;
            int n = xs.length - 1;
            tr = new Node[n * 4];
            for (int i = 0; i < tr.length; i++)
                tr[i] = new Node();
            build(1, 0, n - 1);
        }

        void build(int u, int l, int r) {
            tr[u].l = l;
            tr[u].r = r;
            if (l != r) {
                int mid = (l + r) >> 1;
                build(u << 1, l, mid);
                build(u << 1 | 1, mid + 1, r);
            }
        }

        void pushUp(int u) {
            if (tr[u].cnt > 0) {
                tr[u].len = (long) xs[tr[u].r + 1] - xs[tr[u].l];
            } else if (tr[u].l == tr[u].r) {
                tr[u].len = 0;
            } else {
                tr[u].len = tr[u << 1].len + tr[u << 1 | 1].len;
            }
        }

        void modify(int u, int l, int r, int v) {
            if (l > r) return;

            if (tr[u].l >= l && tr[u].r <= r) {
                tr[u].cnt += v;
            } else {
                int mid = (tr[u].l + tr[u].r) >> 1;
                if (l <= mid)
                    modify(u << 1, l, r, v);
                if (r > mid)
                    modify(u << 1 | 1, l, r, v);
            }
            pushUp(u);
        }

        long query() {
            return tr[1].len;
        }
    }

    public double separateSquares(int[][] squares) {

        List<int[]> events = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();

        for (int[] s : squares) {
            int x1 = s[0], y1 = s[1], l = s[2];
            int x2 = x1 + l, y2 = y1 + l;

            events.add(new int[]{y1, x1, x2, 1});
            events.add(new int[]{y2, x1, x2, -1});

            set.add(x1);
            set.add(x2);
        }

        events.sort((a, b) -> a[0] - b[0]);

        int[] xs = new int[set.size()];
        int idx = 0;
        for (int x : set)
            xs[idx++] = x;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < xs.length; i++)
            map.put(xs[i], i);

        SegmentTree st = new SegmentTree(xs);

        double totalArea = 0;
        int prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0];
            totalArea += (double) (y - prevY) * st.query();

            st.modify(
                1,
                map.get(e[1]),
                map.get(e[2]) - 1,
                e[3]
            );

            prevY = y;
        }

        double target = totalArea / 2.0;

        st = new SegmentTree(xs);
        double area = 0;
        prevY = events.get(0)[0];

        for (int[] e : events) {
            int y = e[0];
            long width = st.query();
            double add = (double) (y - prevY) * width;

            if (area + add >= target) {
                return prevY + (target - area) / width;
            }

            area += add;

            st.modify(
                1,
                map.get(e[1]),
                map.get(e[2]) - 1,
                e[3]
            );

            prevY = y;
        }

        return 0.0;
    }
}