/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pbo_pertemuan10_inheritance;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author A-2
 */
public class Game {

    int secretNumber;
    private int guessLimit;

    public Game(int guessLimit) {
        this.guessLimit = guessLimit;
    }

    public void generateNumber() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1; // Contoh: 1-100
    }

    public int getGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tebakan Anda (1-100): ");
        return scanner.nextInt();
    }

    public String checkGuess(int guess) {
        if (guess == secretNumber) {
            return "Benar!";
        } else if (guess > secretNumber) {
            return "Terlalu tinggi, coba lagi!";
        } else {

            return "Terlalu rendah, coba lagi!";
        }
    }

    public void play() {
        generateNumber();
        int remainingGuesses = guessLimit;
        while (remainingGuesses > 0) {
            int guess = getGuess();
            String feedback = checkGuess(guess);
            System.out.println(feedback);
            if (feedback.equals("Benar!")) {
                break;
            }
            remainingGuesses--;
            System.out.println("Sisa tebakan: " + remainingGuesses);
        }
        if (remainingGuesses == 0) {
            System.out.println("Maaf, Anda kehabisan tebakan. Angka rahasia adalah: " + secretNumber);
        }
    }
}
