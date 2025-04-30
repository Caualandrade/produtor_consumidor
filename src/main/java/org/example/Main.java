package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando");
        FIFO fila = new FIFO(3);
        ConsumerProducer programa = new ConsumerProducer(fila);


        Thread produtor = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        programa.produce();
                    }
                }
        );

        Thread consumidor = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        programa.consume();
                    }
                }
        );

        produtor.start();
        consumidor.start();
        produtor.join();
        consumidor.join();

    }
}