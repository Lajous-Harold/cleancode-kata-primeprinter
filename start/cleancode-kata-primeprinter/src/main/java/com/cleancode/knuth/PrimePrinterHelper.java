package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private int numbers[];
    private int pagenumber;
    private int pageoffset;
    private int rowoffset;
    private int column;
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n = 0;
    private int multiples[] = new int[ordmax + 1];

    public int[] generateNumbers(int numberOfNumbers) {

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

    public void printNumbers(int[] numbers, int numberOfNumbers) {
        pagenumber = 1;
        pageoffset = 1;
        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (column = 0; column <= columns - 1; column++)
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
