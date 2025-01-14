package rocks.alexmihai.medium.numberofislands;

/**
 * - Keep track of visited land in a `visited` matrix
 * - Iterate original matrix
 * - If it's land, go searching for the whole island (DFS or BFS, doesn't matter)
 * - While moving around, mark cells as visited
 */
public class Solution {
    public int numIslands(char[][] grid) {
        var visited = new boolean[grid.length][grid[0].length];

        var res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    searchIsland(grid, visited, i, j);
                }
            }
        }

        return res;
    }

    private void searchIsland(char[][] grid, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == '1') {
            searchIsland(grid, visited, i - 1, j);
        }

        if (i < visited.length - 1 && !visited[i + 1][j] && grid[i + 1][j] == '1') {
            searchIsland(grid, visited, i + 1, j);
        }

        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == '1') {
            searchIsland(grid, visited, i, j - 1);
        }

        if (j < visited[0].length - 1 && !visited[i][j + 1] && grid[i][j + 1] == '1') {
            searchIsland(grid, visited, i, j + 1);
        }
    }
}
