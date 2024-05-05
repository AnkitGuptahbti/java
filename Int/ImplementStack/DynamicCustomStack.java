public class DynamicCustomStack extends CustomStack {
    public DynamicCustomStack() {
        super();// constructor in the parent class that dont take argument
    }

    public DynamicCustomStack(int size) {
        super(size);// constructor in the parent class that take argument
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            // double array sixze
            int temp[] = new int[data.length * 2];

            // copy all previos items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        // insert item
        return super.push(item);
    }

}
