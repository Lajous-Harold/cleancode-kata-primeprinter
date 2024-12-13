package com.cleancode.knuth;

public class PrimePrinter {

    private static final int numberOfNumbers = 1000;
    private static final int linesPerPage = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimeGenerator generator = new PrimeGenerator();
        int[] numbers = generator.generatePrimes(numberOfNumbers);

        new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
    }
}
