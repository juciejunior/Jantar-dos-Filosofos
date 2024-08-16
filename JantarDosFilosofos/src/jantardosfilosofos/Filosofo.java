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
public class Filosofo implements Runnable {
    
    private final int id;
    private final Hashis hashis;

    public Filosofo(int id, Hashis hashis) {
        this.id = id;
        this.hashis = hashis;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                hashis.pegarHashis(id);
                comer();
                hashis.devolverHashis(id);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 2000));
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo.");
        Thread.sleep((long) (Math.random() * 2000));
    }
}
