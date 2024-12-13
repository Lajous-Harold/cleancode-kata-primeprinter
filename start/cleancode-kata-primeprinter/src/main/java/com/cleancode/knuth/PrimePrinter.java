package com.cleancode.knuth;

public class PrimePrinter {

    private static final int numberOfNumbers = 1000;

    public static void main(String[] args) {
        PrimePrinterHelper helper = new PrimePrinterHelper();
        int[] primes = helper.generatePrimes(numberOfNumbers);

        NumberPrinter printer = new NumberPrinter(50, 4);
        printer.printNumbers(primes, numberOfNumbers);
    }
}
