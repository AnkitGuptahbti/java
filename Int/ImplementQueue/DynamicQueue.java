package Int.ImplementQueue;

public class DynamicQueue extends CircularQueue {
    public DynamicQueue() {
        super();// constructor in the parent class that dont take argument
    }

    public DynamicQueue(int size) {
        super(size);// constructor in the parent class that take argument
    }
    @Override
    public boolean insert(int item){


        if (this.isFull()) {
            // double array sixze
            int temp[] = new int[data.length * 2];

            // copy all previos items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front+i)%data.length];
            }
            front=0;
            end=data.length;
            data = temp;
        }


        return super.insert(item);

    }

}
