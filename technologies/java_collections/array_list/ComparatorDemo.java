package technologies.java_collections.array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Jane", 29));
        list.add(new Employee("Alex", 54));
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.age-o2.age;
            }
        });

        for(Employee emp : list) {
            System.out.println("Employee Name: " + emp.name + ", Employee Age: " + emp.age);
        }

        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Jane", 29));
        workers.add(new Worker("Alex", 54));
        Collections.sort(workers, new AgeCompartor());

        for(Worker worker : workers) {
            System.out.println("worker Name: " + worker.name + ", worker Age: " + worker.age);
        }
    }
}

class AgeCompartor implements Comparator<Worker>{
    @Override
    public int compare(Worker o1, Worker o2) {
        return o1.age-o2.age;
    }
}

class Worker{
    String name;
    int age;

    public Worker(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}
