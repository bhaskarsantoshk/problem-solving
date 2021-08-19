package technologies.java_collections.array_list.excercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String args[]) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));

        List<String> employeesAgedOver50 = getEmployeesAgedOverGivenNumber(list, 50);
        System.out.println(employeesAgedOver50);

        System.out.println("Solution using streams");
        list.stream().filter(emp -> emp.age > 50).map(emp -> emp.name).forEach(System.out::println);

        List<String> employeesFromUSA = getEmployeesFromCountry(list, "USA");
        System.out.println(employeesFromUSA);
        list.stream().filter(emp -> emp.country.equals("USA")).map(emp -> emp.name).forEach(System.out::println);


        // Sort employees by country
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.country.compareTo(o2.country);
            }
        });

        for (Employee e: list){
            System.out.println(e.name+" "+ e.country);
        }

    }

    private static List<String> getEmployeesFromCountry(List<Employee> list, String country) {
        List<String> res = new ArrayList<>();
        for (Employee e: list){
            if ( e.country.equals(country)){
                res.add(e.name);
            }
        }
        return res;
    }

    private static List<String> getEmployeesAgedOverGivenNumber(List<Employee> list, int age) {
        List<String> res = new ArrayList<>();
        for (Employee e: list){
            if ( e.age >= 50){
                res.add(e.name);
            }
        }
        return res;
    }
}
