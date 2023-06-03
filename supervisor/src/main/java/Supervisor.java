public class Supervisor implements Runnable {
    private final AbstractProgram abstractProgram;
    private Thread thread;

    public Supervisor() {
        this.abstractProgram = new AbstractProgram();
        this.thread = new Thread(abstractProgram, "AbstractProgram");
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                State state = abstractProgram.getState();
                System.out.println(state);

                switch (state) {
                    case FATAL_ERROR -> {
                        thread.interrupt();
                    }

                    case STOPPING -> {
                        thread.interrupt();
                        thread = new Thread(abstractProgram, "AbstractProgram");
                        thread.start();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            thread.interrupt();
        }
    }
}