package com.cleancode.knuth;

public class PrimeGenerator {

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
