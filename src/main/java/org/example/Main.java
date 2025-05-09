package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando...");
        FIFO fila = new FIFO(5);
        ConsumerProducer programa = new ConsumerProducer(fila);

        /*
        Thread produtor = new Thread(() -> programa.produce());
        Thread consumidor = new Thread(() -> programa.consume());
        */

        Thread produtor = new Thread(new Runnable() {
            @Override
            public void run() {
                programa.produce();
            }
        });

        Thread consumidor = new Thread(new Runnable() {
            @Override
            public void run() {
                programa.consume();
            }
        });


        produtor.start();
        consumidor.start();

        //A main vai esperar que as threads produtor e consumidor terminem antes de continuar ou encerrar.
        produtor.join();
        consumidor.join();

    }
}