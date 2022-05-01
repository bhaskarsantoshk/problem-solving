package OnlineAssessments;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    public static int treasureIsland(char[][] island) {
        if ( island == null || island.length == 0) return 0;
        int steps = 0;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        queue.add(new Point(0,0));
        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int i=0; i<size; i++) {
                Point point = queue.poll();
                int x = point.x;
                int y = point.y;
                if (island[x][y] == 'X') return steps;
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < island.length
                            && newY >= 0 && newY < island[0].length
                            && !visited[newX][newY]) {
                        queue.add(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
