package interviewbit.graph;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int dx[] = {-1, -2, -1, -2, 1, 2, 1, 2};
        int dy[] = { -2, -1, 2, 1, -2, -1, 2, 1};
        boolean isVisited[][] = new boolean[N+1][M+1];
        Queue<Point> queue = new LinkedList<>();
        Point p = new Point(x1, y1);
        queue.offer(p);
        isVisited[x1][y1] = true;
        int moveCount = 0;

        while ( !queue.isEmpty() ){
            int nodesAtCurrentBreadth= queue.size();

            for(int i=0; i< nodesAtCurrentBreadth; i++ ){
                Point currentPos = queue.remove();

                if ( currentPos.x == x2 && currentPos.y == y2){
                    return moveCount;
                }


                for (int j=0; j< dx.length; j++ ){
                    if ( isValid ( currentPos.x + dx[j], currentPos.y+dy[j], N, M)
                     && isVisited[currentPos.x+dx[j]][currentPos.y+dy[j]] == false){
                        queue.add(new Point(currentPos.x + dx[i], currentPos.y + dy[j]));
                        isVisited[currentPos.x + dx[j]][currentPos.y + dy[j]] = true;
                    }
                }
            }
            moveCount++;
        }
        return -1;

    }

    private boolean isValid(int x, int y, int N, int M) {
        if (x<=0 || x>N || y<=0 || y > M ){
            return false;
        }
        return true;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
