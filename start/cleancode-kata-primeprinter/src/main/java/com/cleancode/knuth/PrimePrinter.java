package com.cleancode.knuth;

public class PrimePrinter {

    private static final int numberOfNumbers = 1000;
    private static final int linesPerPage = 50;
    private static final int columns = 4;

    public static void main(String[] args) {
        PrimePrinterHelper helper = new PrimePrinterHelper();
        int[] numbers = helper.generatePrimes(numberOfNumbers);

        new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
    }
}
