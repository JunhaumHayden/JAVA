package edu.ufsc.fln.concurrencys;

import java.io.*;
import java.util.*;

public class VectorSum {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Uso: java VectorSum n_threads a_file b_file");
            return;
        }

        int nThreads = Integer.parseInt(args[0]);
        double[] a = loadVector(args[1]);
        double[] b = loadVector(args[2]);

        if (a.length != b.length) {
            System.out.println("Vetores de tamanhos diferentes!");
            return;
        }

        int size = a.length;
        double[] c = new double[size];

        if (nThreads > size) {
            nThreads = size;
        }

        Thread[] threads = new Thread[nThreads];
        int chunkSize = size / nThreads;
        int remainder = size % nThreads;

        int start = 0;
        for (int i = 0; i < nThreads; i++) {
            int end = start + chunkSize + (i < remainder ? 1 : 0);
            Thread t = new Thread(new Worker(a, b, c, start, end));
            threads[i] = t;
            t.start();
            start = end;
        }

        for (Thread t : threads) {
            t.join();
        }

        avaliar(a, b, c);
    }

    static class Worker implements Runnable {
        private final double[] a, b, c;
        private final int start, end;

        public Worker(double[] a, double[] b, double[] c, int start, int end) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                c[i] = a[i] + b[i];
            }
        }
    }

    // Lê vetor de arquivo ou gera aleatoriamente
    static double[] loadVector(String filename) throws IOException {
        if (filename.startsWith("gen:")) {
            int size = Integer.parseInt(filename.split(":")[1]);
            double[] vec = new double[size];
            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                vec[i] = rand.nextInt(20); // valor arbitrário
            }
            return vec;
        } else {
            List<Double> list = new ArrayList<>();
            try (Scanner scanner = new Scanner(new File(filename))) {
                while (scanner.hasNextDouble()) {
                    list.add(scanner.nextDouble());
                }
            }
            double[] result = new double[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }

    static void avaliar(double[] a, double[] b, double[] c) {
        boolean ok = true;
        for (int i = 0; i < a.length; i++) {
            if (Math.abs(c[i] - (a[i] + b[i])) > 1e-6) {
                System.out.printf("Erro no índice %d: %.2f + %.2f != %.2f\n", i, a[i], b[i], c[i]);
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println("Resultado correto!");
        }
    }
}

