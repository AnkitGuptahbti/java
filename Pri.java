import java.util.ArrayList;

public class Pri {

    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }

    void pre(Node root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(-1);
            return;
        }
        list.add(root.data);
        pre(root.left, list);
        pre(root.right, list);
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        // code here

        if (A.size() == 0)
            return null;
        int a = A.remove(0);
        if (a == -1)
            return null;
        Node root = new Node(a);
        Node l = deSerialize(A);
        Node r = deSerialize(A);
        root.left = l;
        root.right = r;
        return root;
    }
}
