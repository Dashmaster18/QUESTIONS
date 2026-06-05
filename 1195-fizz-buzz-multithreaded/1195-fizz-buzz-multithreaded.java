import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int curr = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (curr <= n) {
            while (curr <= n && !(curr % 3 == 0 && curr % 5 != 0))
                wait();

            if (curr > n) break;

            printFizz.run();
            curr++;
            notifyAll();
        }
        notifyAll();
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (curr <= n) {
            while (curr <= n && !(curr % 5 == 0 && curr % 3 != 0))
                wait();

            if (curr > n) break;

            printBuzz.run();
            curr++;
            notifyAll();
        }
        notifyAll();
    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (curr <= n) {
            while (curr <= n && !(curr % 15 == 0))
                wait();

            if (curr > n) break;

            printFizzBuzz.run();
            curr++;
            notifyAll();
        }
        notifyAll();
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (curr <= n) {
            while (curr <= n && (curr % 3 == 0 || curr % 5 == 0))
                wait();

            if (curr > n) break;

            printNumber.accept(curr);
            curr++;
            notifyAll();
        }
        notifyAll();
    }
}