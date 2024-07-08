class Solution {
    public long countSubarrays(int[] nums, int k) {
        long greaterthank = andofgivenk(nums, k);
        long greaterthankadd1 = andofgivenk(nums, k + 1);
        return greaterthank - greaterthankadd1;
    }

    long andofgivenk(int nums[], int k) {
        int n = nums.length;
        SGTree sg1 = new SGTree(n);
        sg1.build(0, 0, n - 1, nums);
        int j = 0, i = 0;
        long ans = 0;
        while (j < n) {
            long cur = sg1.query(0, 0, n - 1, i, j);
            if (cur >= k) {
                ans += (j - i + 1);
                j++;
            } else if (cur < k) {
                long temp = sg1.query(0, 0, n - 1, i, j);
                while (temp < k && i <= j) {

                    i++;
                    temp = sg1.query(0, 0, n - 1, i, j);
                }
                if (temp >= k)
                    ans += j - i + 1;
                j++;
            }
        }
        return ans;
    }
}

class SGTree {
    int[] seg;

    public SGTree(int n) {
        seg = new int[4 * n + 1];
    }

    public void build(int ind, int low, int high, int[] arr) {
        if (low == high) {
            seg[ind] = arr[low];
            return;
        }

        int mid = (low + high) / 2;
        build(2 * ind + 1, low, mid, arr);
        build(2 * ind + 2, mid + 1, high, arr);
        seg[ind] = (seg[2 * ind + 1] & seg[2 * ind + 2]);
    }

    public int query(int ind, int low, int high, int l, int r) {
        // no overlap
        // l r low high or low high l r
        if (r < low || high < l)
            return -1;      // // this return must be updated

        // complete overlap
        // [l low high r]
        if (low >= l && high <= r)
            return seg[ind];

        int mid = (low + high) >> 1;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return (left & right);
    }

    public void update(int ind, int low, int high, int i, int val) {
        if (low > ind || high < ind)
            return;
        if (low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high) >> 1;
        if (i <= mid)
            update(2 * ind + 1, low, mid, i, val);
        else
            update(2 * ind + 2, mid + 1, high, i, val);
        seg[ind] = (seg[2 * ind + 1] & seg[2 * ind + 2]);
    }
}
//  void update_tree(int node, int start, int end, int i, int val) {
// 	if(start > i || end < i) return;
// 	if(start == i && i == end) {
// 		tree[node] = val;
// 		return;
// 	}
// 	int c1 = 2 * node + 1, c2 = c1 + 1, m = (start+end)/2;

   
// 	update_tree(c1, start, m, i, val);

// 	update_tree(c2, m+1, end, i, val);
 
// 	tree[node] = tree[c1] & tree[c2] ;
// }
