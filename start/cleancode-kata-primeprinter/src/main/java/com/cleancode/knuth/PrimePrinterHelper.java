package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int ordmax = 30;
    private int numbers[];
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n = 0;
    private int multiples[] = new int[ordmax + 1];

    public int[] generatePrimes(int numberOfNumbers) {

        numbers = new int[numberOfNumbers + 1];
        candidate = 1;
        primeIndex = 1;
        numbers[1] = 2;
        ord = 2;
        square = 9;

        while (primeIndex < numberOfNumbers) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = numbers[ord] * numbers[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += numbers[n] + numbers[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            numbers[primeIndex] = candidate;
        }

        return numbers;
    }
}

class NumberPrinter {
    private final int linesPerPage;
    private final int columns;

    public NumberPrinter(int linesPerPage, int columns) {
        this.linesPerPage = linesPerPage;
        this.columns = columns;
    }

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        int pagenumber = 1;
        int pageoffset = 1;
        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (int column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfNumbers)
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }
}
