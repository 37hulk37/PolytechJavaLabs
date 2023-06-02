public class Supervisor implements Runnable {
    private final Synchro synchro;
    private final AbstractProgram abstractProgram;
    private Thread abstractThread;

    public Supervisor(Synchro synchro) {
        this.synchro = synchro;
        this.abstractProgram = new AbstractProgram(synchro);

        this.abstractThread = new Thread(abstractProgram, "AbstractProgram");
        abstractThread.start();
        System.out.println("Starting AbstractProgram");
    }

    private void stopThread() {
        synchro.stop();
        abstractThread.interrupt();
    }

    private void startThread() {
        synchro.setStopped(false);
        abstractThread = new Thread(abstractProgram, "AbstractProgram");
        abstractThread.start();
    }

    @Override
    public void run() {
        try {
            while ( !synchro.isStopped() ) {
                State state = synchro.get();

                switch (state) {
                    case FATAL_ERROR ->
                            stopThread();

                    case STOPPING -> {
                        stopThread();
                        startThread();
                    }
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
