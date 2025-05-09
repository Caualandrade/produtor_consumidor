package org.example;

public class FIFO {
    private int cabeca, cauda, qtd_elementos;
    private int[] fila;

    public FIFO(int tamanho) {
        this.cabeca = 0;
        this.cauda = 0;
        this.qtd_elementos = 0;
        this.fila = new int[tamanho];
    }

    public void enqueue(int elemento) {
        fila[cauda] = elemento;
        cauda = (cauda + 1) % fila.length;
        qtd_elementos++;
    }

    public int dequeue() {
        int valor = fila[cabeca];
        cabeca = (cabeca + 1) % fila.length;
        qtd_elementos--;
        return valor;
    }

    public boolean cheia() {
        return qtd_elementos == fila.length;
    }

    public boolean vazia() {
        return qtd_elementos == 0;
    }

    public void printFila() {
        System.out.print("FILA: [");

        for (int i = 0; i < fila.length; i++) {
            // Calcula o índice real baseado na posição circular
            int index = (cabeca + i) % fila.length;

            if (i < qtd_elementos) {
                System.out.print(fila[index]);
            } else {
                System.out.print("__");
            }

            if (i < fila.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }


}
