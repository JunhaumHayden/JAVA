package edu.ufsc.fln.concurrencys;

public class threads01 {
    static int contator_global = 0;

    public static class Incrementador extends Thread {
        //atributes
        private int nLoops;
        //constructor
        public Incrementador(int nLoops) {
            this.nLoops = nLoops;
        }
        //method
        @Override
        public void run() {
            for (int i = 0; i < nLoops; i++) {
                contator_global++;
            }
        }
    }
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide the number of threads and the number of loops.");
            return;
        }
        int nThreads = Integer.parseInt(args[0]);
        int nLoops = Integer.parseInt(args[1]);

        Thread[] threads = new Thread[nThreads];

        //create threads
        for (int i = 0; i <nThreads; i++) {
            threads[i] = new Incrementador(nLoops);
            threads[i].start();
        }
        //join threads
        for (int i = 0; i <nThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread " + i + " was interrupted.");
            }
        }
        //print result
        System.out.println("Final value of contator_global: " + contator_global);
        System.out.println("Final value of nLoops: " + nLoops);
    }
}
