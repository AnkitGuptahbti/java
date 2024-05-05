import java.util.Stack;

public class CustomStack {
   
    protected int data[];
    private  static final int DEFAULT_SIZE=10;
    int top=-1;

    public  CustomStack() {
        this(DEFAULT_SIZE);
    }
    public  CustomStack(int size){
        this.data=new int[size];
    }
    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        top++;
        data[top]=item;
        return true;
    }
    public int pop() throws Exception{
        if(isEmpty()){
           throw new Exception("Cannot pop form an empty stack");
        }
        return data[top--];

    }
    public int peek() throws Exception{
        if(isEmpty())throw new Exception("Cannot peek form an empty stack");
        return data[top];
    }
   public boolean isFull(){
         return top==data.length-1;
    }
   public boolean isEmpty(){
        return top==-1;
    }

}