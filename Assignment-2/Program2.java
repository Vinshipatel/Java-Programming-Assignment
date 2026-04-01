import java.util.*;

class SharedBuffer {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        data = value;
        available = true;

        System.out.println("Produced: " + data);

        notify();
    }

    public synchronized void consume() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Consumed: " + data);

        available = false;

        notify();
    }
}

class Producer extends Thread {
    private SharedBuffer buffer;
    private int count;

    Producer(SharedBuffer buffer, int count) {
        this.buffer = buffer;
        this.count = count;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            buffer.produce(i * 10);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;
    private int count;

    Consumer(SharedBuffer buffer, int count) {
        this.buffer = buffer;
        this.count = count;
    }

    public void run() {
        for (int i = 1; i <= count; i++) {
            buffer.consume();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        SharedBuffer buffer = new SharedBuffer();

        Producer p = new Producer(buffer, n);
        Consumer c = new Consumer(buffer, n);

        p.start();
        c.start();
    }
}