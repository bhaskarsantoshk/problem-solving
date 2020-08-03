package books.EPI.Searching;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GPACalculatorUtil {
    private static final Comparator<Student> compareGPA = (a,b) -> {
        if ( a.gradePointAverage != b.gradePointAverage ){
            return Double.compare(a.gradePointAverage, b.gradePointAverage);
        }
        return a.name.compareTo(b.name);
    };

    public static boolean searchStudent(List<Student> students, Student target, Comparator<Student> compareGPA){
        return Collections.binarySearch(students, target, compareGPA) >= 0;
    }
}
