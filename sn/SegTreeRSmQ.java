package sn;
//segment tree is noting but a data structure which store the resultant of a given range in given index in an array.
//now it i want to search [3-8] need to look at tree because none of the tree store that ,so how i will do that look at query now.
//Time complexity  : Build( O(n)) ,  query( log(n))  ,  update( log(n))
public class SegTreeRSmQ {

    public static void main(String[] args) {
        int n=5;int arr[]={1,2,3,4,5};
        SGTreeRSumQ o=new SGTreeRSumQ(5);
        o.build(0,0,n-1,arr);
        System.out.println(o.query(0,0,n-1,3,4));
        o.update(0,0,n-1,0,10);
        System.out.println(o.query(0,0,n-1,0,2));
    }
}


class SGTreeRSumQ {
    int[] seg;

    public SGTreeRSumQ(int n) {
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
        seg[ind] = (seg[2 * ind + 1]+seg[2 * ind + 2]);
    }

    public int query(int ind, int low, int high, int l, int r) {
        // no overlap
        // l r low high or low high l r
        if (r < low || high < l)
            return 0;

        // complete overlap
        // [l low high r]
        if (low >= l && high <= r)
            return seg[ind];
        //overlap
        int mid = (low + high) >> 1;
        int left = query(2 * ind + 1, low, mid, l, r);
        int right = query(2 * ind + 2, mid + 1, high, l, r);
        return (left+ right);
    }

    public void update(int ind, int low, int high, int i, int val) {
        if (low == high) {
            seg[ind] = val;
            return;
        }

        int mid = (low + high) >> 1;
        if (i <= mid)
            update(2 * ind + 1, low, mid, i, val);
        else
            update(2 * ind + 2, mid + 1, high, i, val);
        seg[ind] = (seg[2 * ind + 1]+seg[2 * ind + 2]);
    }
}
