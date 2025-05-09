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
                        System.out.println("[Produtor] Fila cheia. Aguardando...");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("[Produtor] Produzindo elemento " + elemento);
                fila.enqueue(elemento);
                System.out.println("[Produtor] Elemento " + elemento + " inserido na fila.");
                fila.printFila();

                elemento++;
                System.out.println("[Produtor] Notificando consumidor...");
                notify();
            }

            try {
                int sleepTime = rand.nextInt(1000);
                System.out.println("[Produtor] Dormindo por " + sleepTime + "ms");
                Thread.sleep(sleepTime);
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
                        System.out.println("[Consumidor] Fila vazia. Aguardando...");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                elemento = fila.dequeue();
                System.out.println("[Consumidor] Elemento " + elemento + " consumido.");
                fila.printFila();

                System.out.println("[Consumidor] Notificando produtor...");
                notify();
            }

            try {
                int sleepTime = rand.nextInt(1000);
                System.out.println("[Consumidor] Dormindo por " + sleepTime + "ms");
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
