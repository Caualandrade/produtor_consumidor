package org.example;

import java.util.Random;

public class ConsumerProducer {

    private final FIFO fila;
    private final Random rand = new Random();

    public ConsumerProducer(FIFO fila) {
        this.fila = fila;
    }

    public void produce() {
        int elemento = 0;
        while (true) {
            synchronized (this) {
                while (fila.cheia()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                fila.enqueue(elemento);
                System.out.println("Elemento " + elemento + " produzido");
                fila.printFila();
                elemento++;
                notify();
            }

            // Espera aleatória entre 0 e 1000 ms
            try {
                Thread.sleep(rand.nextInt(1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {
        int elemento;
        while (true) {
            synchronized (this) {
                while (fila.vazia()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                elemento = fila.dequeue();
                System.out.println("Elemento " + elemento + " consumido");
                fila.printFila();
                notify();
            }

            // Espera aleatória entre 0 e 1000 ms
            try {
                Thread.sleep(rand.nextInt(1000));
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
