package com.cleancode.knuth;

class NumberPrinter {
    private final int LINES_PER_PAGE;
    private final int COLUMNS;

    public NumberPrinter(int linesPerPage, int columns) {
        this.LINES_PER_PAGE = linesPerPage;
        this.COLUMNS = columns;
    }

    public void print(int[] numbers, int numberOfNumbers) {
        int pagenumber = 1;
        int pageoffset = 1;
        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (int rowoffset = pageoffset; rowoffset <= pageoffset + LINES_PER_PAGE - 1; rowoffset++) {
                for (int column = 0; column <= COLUMNS - 1; column++)
                    if (rowoffset + column * LINES_PER_PAGE <= numberOfNumbers)
                        System.out.printf("%10d", numbers[rowoffset + column * LINES_PER_PAGE]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += LINES_PER_PAGE * COLUMNS;
        }
    }
}
