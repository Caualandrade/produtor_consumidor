package org.example;

public class FIFO {

    private int cabeca, cauda, qtd_elementos;

    private int fila[];

    public FIFO(int elemento) {
        this.cabeca = 0;
        this.cauda = 0;
        this.qtd_elementos = 0;
        this.fila = new int[elemento];
    }

    public void enqueue(int elemento){
        this.fila[this.cauda] = elemento;
        if(this.cauda == this.fila.length-1){
            this.cauda = 0;
        }else{
            this.cauda += 1;
        }
        this.qtd_elementos++;
    }

    public int dequeue(){
        int valor = this.fila[this.cabeca];
        if(this.cabeca == this.fila.length-1){
            this.cabeca = 0;
        }else{
            this.cabeca += 1;
        }
        this.qtd_elementos--;
        return valor;
    }

    public boolean cheia(){
        if(this.qtd_elementos == this.fila.length){
            return true;
        }else{
            return false;
        }
    }

    public boolean vazia(){
        if(this.qtd_elementos == 0){
            return true;
        }else{
            return false;
        }
    }

    public int getCabeca() {
        return cabeca;
    }

    public void setCabeca(int cabeca) {
        this.cabeca = cabeca;
    }

    public int getCauda() {
        return cauda;
    }

    public void setCauda(int cauda) {
        this.cauda = cauda;
    }

    public int getQtd_elementos() {
        return qtd_elementos;
    }

    public void setQtd_elementos(int qtd_elementos) {
        this.qtd_elementos = qtd_elementos;
    }

    public int[] getFila() {
        return fila;
    }

    public void setFila(int[] fila) {
        this.fila = fila;
    }
}
