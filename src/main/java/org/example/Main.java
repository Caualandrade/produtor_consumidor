package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Iniciando...");
        FIFO fila = new FIFO(5);
        ConsumerProducer programa = new ConsumerProducer(fila);

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

        // A função join faz a main esperar as duas threads encerrarem para ela encerrar
        produtor.join();
        consumidor.join();

    }
}