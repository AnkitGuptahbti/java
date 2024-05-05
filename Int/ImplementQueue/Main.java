package Int.ImplementQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        CircularQueue q=new CircularQueue(5);
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.display();
        System.out.println(q.front());
        q.remove();
        q.insert(99);
        q.display();
    }
}
