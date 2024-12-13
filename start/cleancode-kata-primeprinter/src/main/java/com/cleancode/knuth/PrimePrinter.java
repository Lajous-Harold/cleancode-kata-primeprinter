package com.cleancode.knuth;

public class PrimePrinter {

    private static final int NUMBER_OF_NUMBERS = 1000;
    private static final int LINES_PER_PAGE = 50;
    private static final int COLUMNS = 4;

    public static void main(String[] args) {
        PrimeGenerator generator = new PrimeGenerator();
        int[] numbers = generator.generatePrimes(NUMBER_OF_NUMBERS);

        NumberPrinter printer = new NumberPrinter(LINES_PER_PAGE, COLUMNS);
        printer.print(numbers, NUMBER_OF_NUMBERS);
    }
}
