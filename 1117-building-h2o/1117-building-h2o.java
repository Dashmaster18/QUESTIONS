class H2O {

    private int hydrogenCount = 0;

    public H2O() {

    }

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        while (hydrogenCount == 2) {
            wait();
        }

        releaseHydrogen.run();
        hydrogenCount++;

        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {

        while (hydrogenCount < 2) {
            wait();
        }

        releaseOxygen.run();
        hydrogenCount = 0;

        notifyAll();
    }
}