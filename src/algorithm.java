import java.util.stream.IntStream;

public class algorithm {
    // dimension of input
    static int N = 9;

    // sample input
    public static int grid[][];

    public algorithm(int[][] gridToSolve){
        this.grid = gridToSolve;
    }


    static class Cell {

        int row, col;

        public Cell(int row, int col) {
            super();
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Cell [row=" + row + ", col=" + col + "]";
        }
    };

    /**
     * Utility function to check whether @param value is valid for @param cell
     */

    public static boolean isValid(Cell cell, int value) {

        if (grid[cell.row][cell.col] != 0) {
            throw new RuntimeException(
                    "Cannot call for cell which already has a value");
        }

        // if v present row, return false
        for (int c = 0; c < 9; c++) {
            if (grid[cell.row][c] == value)
                return false;
        }

        // if v present in col, return false
        for (int r = 0; r < 9; r++) {
            if (grid[r][cell.col] == value)
                return false;
        }

        int x1 = 3 * (cell.row / 3);
        int y1 = 3 * (cell.col / 3);
        int x2 = x1 + 2;
        int y2 = y1 + 2;

        for (int x = x1; x <= x2; x++)
            for (int y = y1; y <= y2; y++)
                if (grid[x][y] == value)
                    return false;

        // if value not present in row, col and bounding box, return true
        return true;
    }

    static Cell getNextCell(Cell cur) {

        int row = cur.row;
        int col = cur.col;

        // next cell => col++
        col++;

        // if col > 8, then col = 0, row++
        // reached end of row, got to next row
        if (col > 8) {
            // goto next line
            col = 0;
            row++;
        }

        // reached end of matrix, return null
        if (row > 8)
            return null; // reached end

        Cell next = new Cell(row, col);
        return next;
    }

    // must return true, if the soduku is solved, return false otherwise
    public static boolean solve(Cell cur) {

        // if the cell is null reached the end
        if (cur == null)
            return true;

        if (grid[cur.row][cur.col] != 0) {
            return solve(getNextCell(cur));
        }

        // if grid[cur] doesn't have a value
        // try each possible value
        for (int i = 1; i <= 9; i++) {
            // check if valid, if valid, then update
            boolean valid = isValid(cur, i);

            if (!valid) // i not valid for this cell, try other values
                continue;

            // assign here
            grid[cur.row][cur.col] = i;

            // continue with next cell
            boolean solved = solve(getNextCell(cur));
            // if solved, return, else try other values
            if (solved)
                return true;
            else
                grid[cur.row][cur.col] = 0; // reset
        }
        return false;
    }

    public static void main(String[] args) {
        // for testing
        int [][] grid2 = { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, //
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 }, //
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 }, //
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, //
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 }, //
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 }, //
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, //
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 }, //
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
        algorithm algorithm = new algorithm(grid2);
        boolean solved = solve(new Cell(0, 0));
        if (!solved) {
            System.out.println("SUDOKU cannot be solved.");
            return;
        }
        System.out.println("SOLUTION\n");
        printGrid(grid);
    }

    // utility to print the grid
    static void printGrid(int grid[][]) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++)
                System.out.print(grid[row][col]);
            System.out.println();
        }
    }
}
