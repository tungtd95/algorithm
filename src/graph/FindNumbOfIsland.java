package graph;

public class FindNumbOfIsland {
    // Function to find the number of islands.
    int currentIslandCount = 0;
    int[][] tracker;

    public int numIslands(char[][] grid) {
        // Code here
        int x = grid.length;
        int y = grid[0].length;
        tracker = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tracker[i][j] = 0;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1' && tracker[i][j] == 0) {
                    // discover brand-new island
                    currentIslandCount++;
                }
                visit(i, j, grid);
            }
        }
        return currentIslandCount;
    }

    private void visit(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') return;
        if (tracker[i][j] > 0) return; // discovered
        tracker[i][j] = 1;
        visit(i - 1, j - 1, grid);
        visit(i, j - 1, grid);
        visit(i - 1, j, grid);
        visit(i + 1, j + 1, grid);
        visit(i + 1, j, grid);
        visit(i, j + 1, grid);
        visit(i - 1, j + 1, grid);
        visit(i + 1, j - 1, grid);
    }
}
