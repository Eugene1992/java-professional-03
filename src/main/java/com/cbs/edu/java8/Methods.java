package com.cbs.edu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Methods {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Ivan Ivanov",   25, Gender.MALE,    15000,  2.7));
        employees.add(new Employee("Anna Karenina", 23, Gender.FEMALE,  25000,  1.6));
        employees.add(new Employee("Tom Crus",      18, Gender.MALE,    55000,  1.2));
        employees.add(new Employee("Sara Barkley",  35, Gender.FEMALE,  7000,   5.5));
        employees.add(new Employee("Bob Marley",    34, Gender.MALE,    33000,  1.3));

        System.out.println("\nfilter | отфильтровать только женщин\n");
        List<Employee> collected = employees
                .stream()
                .filter(employee -> employee.gender == Gender.FEMALE)
                .filter(employee -> employee.name.matches(""))
                .collect(Collectors.toList());

        System.out.println("\nskip | пропустить 2 первых сотрудников и вывести остальных\n");
        employees
                .stream()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("\nskip | пропустить 2 первых сотрудников и вывести остальных\n");
//        employees.add(new Employee("Bob Marley",    34, Gender.MALE,    33000,  1.3));
        employees
                .stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\nmap | вывести зарплаты сотрудников\n");
        employees
                .stream()
                .map(e -> e.salary)
                .filter(s -> s > 10000)
                .forEach(System.out::println);

        System.out.println("\npeek | вывести зарплаты сотрудников с учетом бонуса\n");
        employees
                .stream()
                .peek(employee -> employee.salary = (long)(employee.salary * employee.bonus))
                .forEach(e -> System.out.println(e.salary));

        System.out.println("\nlimit | вывести первых трех сотрудников\n");
        employees
                .stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\nsorted / sorted | отсортировать по возрасту\n");
        employees
                .stream()
                .sorted((o1, o2) -> o1.age - o2.age)
                .forEach(System.out::println);

        System.out.println("\nmapToLong | вывести зарплаты сотрудников\n");
        employees
                .stream()
                .mapToLong(e -> e.salary)
                .forEach(System.out::println);

        System.out.println("\nflatMap | разбить имя построчно\n");
        employees
                .stream()
                .flatMap(employee -> stream(employee.name.split(" ")))
                .forEach(System.out::println);

        System.out.println(employees
                .stream()
                .map(e -> e.name)
                .reduce(new BinaryOperator<String>() {
                    @Override
                    public String apply(String employee, String employee2) {
                        return employee + ", " + employee2;
                    }
                })
        .get());

        System.out.println(employees
                .stream()
                .map(e -> e.salary)
                .max((s1, s2) -> (int) (s1 - s2))
                .orElse(-1L));

        System.out.println(employees
                .stream()
                .map(e -> e.salary)
                .max((s1, s2) -> (int) (s1 - s2))
                .orElse(-1L));

        System.out.println(employees
                .stream()
                .filter(e -> e.gender == Gender.FEMALE)
                .count());

        System.out.println(employees
                .stream()
                .filter(e -> e.gender == Gender.FEMALE)
                .findFirst()
                .orElse(null));

        System.out.println(employees
                .stream()
                .anyMatch(e -> e.salary > 50000));

        System.out.println(employees
                .stream()
                .allMatch(e -> e.salary > 50000));

        System.out.println(employees
                .stream()
                .noneMatch(e -> e.salary > 10000));

        System.out.println(getRichMales(employees, 30000));
        System.out.println(Arrays.toString(getRichMalesToArray(employees, 30000)));
    }

    public static List<Employee> getRichMales(List<Employee> employees, long filter) {
        return employees
                .stream()
                .filter(e -> e.gender == Gender.MALE)
                .filter(e -> e.salary > filter)
                .collect(Collectors.toList());
    }

    public static Employee[] getRichMalesToArray(List<Employee> employees, long filter) {
        return employees
                .stream()
                .filter(e -> e.gender == Gender.MALE)
                .filter(e -> e.salary > filter)
                .toArray(Employee[]::new);
    }

    static class Employee {

        String name;
        int age;
        Gender gender;
        long salary;
        double bonus;

        public Employee(String name, int age, Gender gender, long salary, double bonus) {
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.salary = salary;
            this.bonus = bonus;
        }

        public Employee(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            if (age != employee.age) return false;
            if (salary != employee.salary) return false;
            if (Double.compare(employee.bonus, bonus) != 0) return false;
            if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
            return gender == employee.gender;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            result = 31 * result + (gender != null ? gender.hashCode() : 0);
            result = 31 * result + (int) (salary ^ (salary >>> 32));
            temp = Double.doubleToLongBits(bonus);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    ", salary=" + salary +
                    ", bonus=" + bonus +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
