import java.util.concurrent.*;

// Runnable implementation
class PrimeTask implements Runnable {
    int start, end;

    PrimeTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // Method to check prime
    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " processing range " + start + " to " + end);
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class Program1 {
    public static void main(String[] args) {
        int max = 100;   // limit
        int threads = 4; // number of threads
        int range = max / threads;

        // ===== Using Executor Framework =====
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        int start = 1;

        for (int i = 0; i < threads; i++) {
            int end = start + range - 1;

            // last thread handles remaining numbers
            if (i == threads - 1) {
                end = max;
            }

            PrimeTask task = new PrimeTask(start, end);

            // Submit Runnable task
            executor.execute(task);

            start = end + 1;
        }

        executor.shutdown();
    }
}