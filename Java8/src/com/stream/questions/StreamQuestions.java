package com.stream.questions;

import java.util.*;
import java.util.stream.Collectors;

public class StreamQuestions {
    public static void main(String[] args) {
        List<Employees> employeesList = new ArrayList<>();
        employeesList.add(new Employees(111,45,"Mitu","Male","IT",2023,2345.67));
        employeesList.add(new Employees(112,46,"Jitu","Male","IT",2023,4567.00));
        employeesList.add(new Employees(113,47,"Sabi","Female","HR",2021,4500.00));

        ////Count the male and female Employee:
        Map<String, Long> noOfMaleFemal = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.counting()));

        ///print the departments
        employeesList.stream().map(Employees::getDept).distinct().forEach(System.out::println);

        //Average age of male and Female Employees:
        Map<String, Double> avgAge = employeesList.stream()
                .collect(Collectors.groupingBy(Employees::getGender, Collectors.averagingInt(Employees::getAge)));

        ///get Details for the heighest Salary Employee:
        Optional<Employees> heighestEmployee = employeesList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employees::getSalary)));

        ///Find the name of the employee who joined after 2015
        employeesList.stream().filter(e->e.getYearOfJoining()>2015).map(Employees::getName)
                .forEach(System.out::println);

        //Count the number of employeeEach Depratment:
        getCountDept(employeesList);

        //Average Salary of Each Department
        getAvgDept(employeesList);

        //get the youngest maleEmployee of Department IT
        getYongestEmployee(employeesList);

    }

        public static void getCountDept(List<Employees> employeesList){
            Map<String, Long> employeeCount = employeesList.stream().collect(Collectors.groupingBy(Employees::getDept, Collectors.counting()));
            Set<Map.Entry<String, Long>> entries = employeeCount.entrySet();
            for (Map.Entry<String,Long> m:entries){
                System.out.println(m.getKey() +"----"+m.getValue());
            }
        }

    public static void getAvgDept(List<Employees> employeesList){
        Map<String, Double> collect = employeesList.stream().collect(Collectors.groupingBy(Employees::getDept,
                Collectors.averagingDouble(Employees::getSalary)));

        Set<Map.Entry<String, Double>> entries = collect.entrySet();

        for (Map.Entry<String,Double> m:entries){
            System.out.println(m.getKey() +"----"+m.getValue());
        }
    }


    public static void getYongestEmployee(List<Employees> employeesList){
        employeesList.stream().filter(e->e.getGender().equals("Male") && e.getDept().equals("IT"))
                .min(Comparator.comparingInt(Employees::getAge)).get();
    }



}
