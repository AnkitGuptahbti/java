public class ThreadExample implements Runnable {
    private String message;

    public ThreadExample(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExample("Thread 1")); // Create a new thread with the ThreadExample instance
                                                               // and a message "Thread 1"
        Thread t2 = new Thread(new ThreadExample("Thread 2")); // Create a new thread with the ThreadExample instance
                                                               // and a message "Thread 2"
        Thread t3 = new Thread(new ThreadExample("Thread 3")); // Create a new thread with the ThreadExample instance
                                                               // and a message "Thread 3"
        t1.start(); // Start the first thread
        // t2.start(); // Start the second thread
        // t3.start(); // Start the third thread
    }
}