package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando...");
        FIFO fila = new FIFO(5);
        ConsumerProducer programa = new ConsumerProducer(fila);

        Thread produtor = new Thread(() -> programa.produce());
        Thread consumidor = new Thread(() -> programa.consume());

        produtor.start();
        consumidor.start();

        produtor.join();
        consumidor.join();

    }
}