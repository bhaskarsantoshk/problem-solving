package OnlineAssessments;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        if ( instructions == null || instructions.length() == 0) return false;
        int x = 0;
        int y = 0;
        String direction = "North";
        for ( char c: instructions.toCharArray()){
            if ( c == 'G'){
                if ( direction.equals("North") ) {
                    y += 1;
                } else if ( direction.equals("South")){
                    y -= 1;
                } else if ( direction.equals("East")) {
                    x += 1;
                } else {
                    x -= 1;
                }
            } else if ( c == 'L') {
                if ( direction.equals("North") ) {
                    direction = "West";
                } else if ( direction.equals("South")){
                    direction = "East";
                } else if ( direction.equals("East")) {
                    direction = "North";
                } else {
                    direction = "South";
                }
            } else if ( c == 'R'){
                if ( direction.equals("North") ) {
                    direction = "East";
                } else if ( direction.equals("South")){
                    direction = "West";
                } else if ( direction.equals("East")) {
                    direction = "South";
                } else {
                    direction = "North";
                }
            }
        }
        if ( x == 0 && y == 0) return true;
        if ( direction.equals("North")) return false;
        return true;
    }
}
