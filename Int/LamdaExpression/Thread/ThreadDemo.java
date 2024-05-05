package Int.LamdaExpression.Thread;

public class ThreadDemo {
    public static void main(String[] args) {
    
        // First Thread: Thread - JOHN
        
        // Creating a Runnable object using lambda expression
        Runnable thread1 = () -> {
            // This is the body of the thread
            // Stuff
            for (int i = 1; i <= 10; i++) {
                System.out.println("Value of i is " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        // Creating a Thread object and passing the Runnable to its constructor
        Thread t1 = new Thread(thread1);
        t1.setName("John");
        // Starting the thread
        t1.start();





        Runnable thread2 = () -> {
            // This is the body of the thread
            // Stuff
            for (int i = 1; i <= 10; i++) {
                System.out.println(i*2);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
         // Creating a Thread object and passing the Runnable to its constructor
         Thread t2 = new Thread(thread2);
         t2.setName("John");
         // Starting the thread
         t2.start();
    }
}
