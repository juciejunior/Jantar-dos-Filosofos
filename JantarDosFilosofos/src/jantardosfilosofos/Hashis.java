/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jantardosfilosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author 202312010019
 */
public class Hashis {
    private final int NUM_FILOSOFOS;
    private final Semaphore[] semaforos;

    public Hashis(int numFilosofo) {
        NUM_FILOSOFOS = numFilosofo;
        semaforos = new Semaphore[NUM_FILOSOFOS];

        // Inicializa os semáforos, cada um com 1 permissão (binário)
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            semaforos[i] = new Semaphore(1);
        }
    }

    public void pegarHashis(int id) throws InterruptedException {
        // Ajusta os índices para serem 0-baseados
        int esquerda = (id - 1 + NUM_FILOSOFOS) % NUM_FILOSOFOS; // Hashis à esquerda
        int direita = id % NUM_FILOSOFOS; // Hashis à direita

        // Adquire semáforo para o hashi da esquerda
        semaforos[esquerda].acquire();
        // Adquire semáforo para o hashi da direita
        semaforos[direita].acquire();
    }

    public void devolverHashis(int id) {
        // Ajusta os índices para serem 0-baseados
        int esquerda = (id - 1 + NUM_FILOSOFOS) % NUM_FILOSOFOS; // Hashis à esquerda
        int direita = id % NUM_FILOSOFOS; // Hashis à direita

        // Libera semáforo para o hashi da esquerda
        semaforos[esquerda].release();
        // Libera semáforo para o hashi da direita
        semaforos[direita].release();
    }
}
