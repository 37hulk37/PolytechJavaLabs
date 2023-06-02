import java.util.Random;

public class AbstractProgram implements Runnable {
    private State state = State.UNKNOWN;
    private final static Random random = new Random();
    private final Synchro synchro;

    public AbstractProgram(Synchro queue) {
        this.synchro = queue;
    }

    @Override
    public void run() {
        try {
            while ( !synchro.isStopped() ) {
                changeState();
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private void changeState() {
        State[] states = State.values();
        int next = random.nextInt(1, 4);
        state = states[next];

        synchro.put(state);
    }
}
