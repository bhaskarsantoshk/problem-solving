package technologies.java_collections.array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComprableDemo {

        public static void main(String[] args) {
            List<Employee> list = new ArrayList<>();
            list.add(new Employee("Jane", 29));
            list.add(new Employee("Alex", 54));

            // Collections.sort(list); - Throws compile time error, no suitable method found
            // If Employee doesn't implement Comparable interface and override compareTo method
            Collections.sort(list);

            for(Employee emp : list) {
                System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
            }
        }
}

class Employee implements Comparable<Employee> {
    String name;
    int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Employee e) {
        return (this.age - e.age);
    }
}
