package company.google.trees_and_graphs;

import java.util.HashSet;
import java.util.Set;

public class P489RobotRoomCleaner {
    int[][] dirs = {{1,0},{0,-1},{-1,0}, {0,1} } ; // down, left, up, right - clockwise moves
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtrack( robot, visited, 0, 0, 0);
    }

    private void backtrack(Robot robot, Set<String> visited, int x, int y, int arrow) {
        robot.clean();
        for ( int i=0; i<4; i++){
            int newX = x+ dirs[i][0];
            int newY = y+ dirs[i][1];
            String path = newX+"#"+newY;
            if ( !visited.contains(path) && robot.move()){
                visited.add(path);
                backtrack(robot, visited, newX, newY, arrow);
            }
            robot.turnRight();
            arrow = (arrow+1)%4;
        }
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();

        // Clean the current cell.
        void clean();
    }
}
