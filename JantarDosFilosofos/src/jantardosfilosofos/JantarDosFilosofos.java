/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jantardosfilosofos;

/**
 *
 * @author 202312010019
 */
public class JantarDosFilosofos {

    static final int NUM_FILOSOFOS = 5;

    public static void main(String[] args) {
        Hashis hashis = new Hashis(NUM_FILOSOFOS);
        Filosofo[] filosofos = new Filosofo[NUM_FILOSOFOS];

        // Inicializa os filósofos e suas threads com IDs de 1 a 5
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            filosofos[i] = new Filosofo(i + 1, hashis); // IDs começam de 1
            new Thread(filosofos[i]).start();
        }
    }
}
