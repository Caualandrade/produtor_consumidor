package org.example;

import java.util.Random;

public class ConsumerProducer {

    FIFO fila;

    public ConsumerProducer(FIFO fila) {
        this.fila = fila;
    }

    public void produce() {
        Random rand = new Random();
        int elemento = 0;
        while (true) {
            synchronized (this) {
                while (this.fila.cheia()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                this.fila.enqueue(elemento);
                System.out.println("Elemento " + elemento + " produzido");
                elemento++;
                notify();
            }

            try {
                Thread.sleep(rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public void consume() {
        Random rand = new Random();

        int elemento;
        while (true) {
            synchronized (this) {
                while (this.fila.vazia()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                elemento = this.fila.dequeue();
                System.out.println("Elemento " + elemento + " consumido");
                notify();

                try {
                    Thread.sleep(rand.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
