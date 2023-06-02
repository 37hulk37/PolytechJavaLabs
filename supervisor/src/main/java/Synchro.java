public class Synchro {
    private State state = State.UNKNOWN;
    private boolean valueSet;
    private boolean stopped = false;

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isStopped() {
        return stopped;
    }

    public synchronized void stop() {
        stopped = true;
        System.out.println("Interrupting AbstractProgram");
    }

    public synchronized State get() {
        while (!stopped && !valueSet)
            try {
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        System.out.println("Got: " + state);
        valueSet = false;
        notify();
        return state;
    }

    public synchronized void put(State state) {
        while (stopped && valueSet)
            try {
                wait();
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        this.state = state;
        valueSet = true;
        notify();
    }
}