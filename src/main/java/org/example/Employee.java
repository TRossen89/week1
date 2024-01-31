package org.example;

import java.time.LocalDate;

public class Employee {

    private String name;

    private LocalDate dateOfbirth;



    private int age;

    public Employee(String name, LocalDate dateOfbirth) {
        this.name = name;
        this.dateOfbirth = dateOfbirth;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Employee(String name, LocalDate dateOfbirth, int age) {
        this.name = name;
        this.dateOfbirth = dateOfbirth;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dateOfbirth=" + dateOfbirth +
                ", age=" + age +
                '}';
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public String getBirthMonth(){

        return dateOfbirth.getMonth().toString();
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }
}
