package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


// ###################################################################################################################
        // EXERCISE 1
// ###################################################################################################################


        // Add
        ArithmeticOperation add = (a, b) -> a + b;
        int addResult = add.perform(8, 9);
        System.out.println("Add - result: " + addResult);


        // Subtract
        ArithmeticOperation subtract = (a, b) -> a - b;
        int subtractResult = subtract.perform(16, 5);
        System.out.println("Subtract - result: " + subtractResult);


        // Multiply
        ArithmeticOperation multiply = (a, b) -> a * b;
        int multiplyResult = multiply.perform(20, 2);
        System.out.println("Multiply - result: " + multiplyResult);

        // Divide
        ArithmeticOperation divide = (a, b) -> a / b;
        int divideResult = divide.perform(20, 4);
        System.out.println("Divide - result: " + divideResult);

        // Modulus
        ArithmeticOperation modulus = (a, b) -> a % b;
        int modulusResult = modulus.perform(18, 4);
        System.out.println("Modulus - result: " + modulusResult);


        // Power
        ArithmeticOperation power = (a, b) -> {
            Double result = Math.pow(Double.valueOf(a), Double.valueOf(b));
            return result.intValue();
        };
        int powerResult = power.perform(5, 3);
        System.out.println("Power - result: " + powerResult);


        System.out.println("--------------------------------------------------");

        int addResult2 = operate(8, 9, add);
        System.out.println("Add with operate method - result: " + addResult2);

        int subtractResult2 = operate(16, 5, subtract);
        System.out.println("Subtract with operate method - result:  " + subtractResult2);

        int multiplyResult2 = operate(20, 2, multiply);
        System.out.println("Multiply with operate method - result: " + multiplyResult2);

        int divideResult2 = operate(20, 4, divide);
        System.out.println("Divide with operate method - result: " + divideResult2);

        int modulusResult2 = operate(18, 4, modulus);
        System.out.println("Modulus with operate method - result: " + modulusResult2);

        int powerResult2 = operate(5, 3, power);
        System.out.println("Power with operate method - result: " + powerResult2);


        System.out.println("-----------------------------------------------");


        // ARRAYS
        int[] array1 = {8, 4, 2, 6, 5, 18};
        int[] array2 = {4, 27, 8, 6, 2, 50};

        int[] arrayOfCalculatedNumbers = operate(array1, array2, add);

        for (int i : arrayOfCalculatedNumbers) {
            System.out.println("Add (array) - result: " + i);
        }

        System.out.println("-----------------------------------------------");

        int[] arrayOfCalculatedNumbers2 = operate(array1, array2, subtract);

        for (int i : arrayOfCalculatedNumbers2) {
            System.out.println("Subtract (array) - result: " + i);
        }

        System.out.println("-----------------------------------------------");


        int[] arrayOfCalculatedNumbers3 = operate(array1, array2, multiply);

        for (int i : arrayOfCalculatedNumbers3) {
            System.out.println("Multiply (array) - result: " + i);
        }

        System.out.println("-----------------------------------------------");


        int[] arrayOfCalculatedNumbers4 = operate(array1, array2, divide);

        for (int i : arrayOfCalculatedNumbers4) {
            System.out.println("Divide (array) - result: " + i);
        }

        System.out.println("-----------------------------------------------");


        int[] arrayOfCalculatedNumbers5 = operate(array1, array2, modulus);

        for (int i : arrayOfCalculatedNumbers5) {
            System.out.println("Modulus (array) - result: " + i);
        }


        System.out.println("-----------------------------------------------");

        int[] arrayOfCalculatedNumbers6 = operate(array1, array2, power);

        for (int i : arrayOfCalculatedNumbers6) {
            System.out.println("Power (array) - result: " + i);
        }


// ###################################################################################################################
        // EXERCISE 2
// ###################################################################################################################


        // 1. ----------
        System.out.println("------------------------------------------------");
        System.out.println("Mapped array: \n");

        int[] arrayOfNumberToMapOrFilter = {3, 4, 6, 1, 45, 9};

        // Transforming numbers in array by multiplying every number by 2
        int[] mappedNumbers = map(arrayOfNumberToMapOrFilter, i -> i * 2);
        for (int i : mappedNumbers) {
            System.out.println(i);
        }


        // 2. -----------
        System.out.println("------------------------------------------------");
        System.out.println("Filtered array: \n");

        // Filtered array with numbers dividable by 3
        int[] filteredArray = filter(arrayOfNumberToMapOrFilter, (i -> (i % 3 == 0) ? true : false));

        for (int i : filteredArray) {
            System.out.println(i);
        }


// ###################################################################################################################
        // EXERCISE 3
// ###################################################################################################################

        // 1. ----------

        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(4);
        listOfIntegers.add(18);
        listOfIntegers.add(21);
        listOfIntegers.add(49);
        listOfIntegers.add(25);
        listOfIntegers.add(112);
        listOfIntegers.add(50);
        listOfIntegers.add(56);
        listOfIntegers.add(224);

        Predicate<Integer> isDividableBy7 = i -> i % 7 == 0;

        System.out.println("-----------------------------------------------------------");
        System.out.println("Dividable by 7:\n ");

        List<Integer> listWithNumbersDividableBy7 = new ArrayList<>();

        int counter = 0;
        for (int i : listOfIntegers) {

            if (isDividableBy7.test(i)) {

                listWithNumbersDividableBy7.add(i);
                System.out.println(listWithNumbersDividableBy7.get(counter));
                counter++;
            }
        }


        // 2. ----------------

        System.out.println("-------------------------------------------");
        System.out.println("Supplier - create list of Employeeobjects:\n");
        List<String> listOfNames = Arrays.asList("Karl", "Monika", "Caroline", "Esben", "Pedro", "Selma", "Oskar",
                "Mette");

        Supplier<Employee> supplier = () -> {
            Random random = new Random();
            int randomIndex = random.nextInt(listOfNames.size());
            String name = listOfNames.get(randomIndex);
            int age = random.nextInt(0, 130);
            return new Employee(name, age);
        };

        List<Employee> listOfEmployees = createListOfEmployees(6, supplier);
        listOfEmployees.forEach(System.out::println);


        // 3. ----------

        System.out.println("-------------------------------------------");
        System.out.println("Consumer - printEmployee:\n");
        Consumer<Employee> employeeToPrint = emp -> System.out.println(emp);
        listOfEmployees.forEach(employeeToPrint);


        // 4. ----------

        System.out.println("--------------------------------------------");
        System.out.println("Function - convert Employee objects to employee names: \n");
        Function<Employee, String> employeeStringFunction = emp -> emp.getName();
        List<String> listOfEmployeeNames = new ArrayList<>();

        for (Employee e : listOfEmployees) {
            String employeeName = employeeStringFunction.apply(e);
            listOfEmployeeNames.add(employeeName);
        }
        listOfEmployeeNames.forEach(System.out::println);


        // 5. ----------

        System.out.println("-------------------------------------------------------");
        System.out.println("Predicate - employees older than 18: \n");

        Predicate<Employee> olderThan18 = i -> i.getAge() > 18 == true;

        for (Employee e : listOfEmployees) {
            if (olderThan18.test(e)) {
                System.out.println(e.getName() + "\nAge: " + e.getAge() + "\n");
            }
        }


// ###################################################################################################################
        // EXERCISE 4
// ###################################################################################################################

        System.out.println("---------------------------------------------");

        List<String> listOfNames2 = Arrays.asList("Karl", "Monika", "Caroline", "Esben", "Pedro", "Selma", "Oskar",
                "Mette");

        // 1. --------

        Supplier<Employee> supplier2 = () -> {
            Random random = new Random();
            int randomIndex = random.nextInt(listOfNames2.size());
            String name = listOfNames2.get(randomIndex);
            int year = random.nextInt(1930, 2006);
            int month = random.nextInt(1, 13);
            int day = 0;

            if (month < 8) {
                if (month % 2 == 0) {
                    if (month == 2) {
                        day = random.nextInt(1, 30);

                    } else {
                        day = random.nextInt(1, 31);
                    }
                } else {
                    day = random.nextInt(1, 32);
                }

            } else {
                if (month % 2 == 0) {
                    day = random.nextInt(1, 32);
                } else {
                    day = random.nextInt(1, 31);

                }
            }

            LocalDate dateOfBirth = LocalDate.of(year, month, day);
            return new Employee(name, dateOfBirth);
        };

        List<Employee> listOfEmployees2 = createListOfEmployees(20, supplier2);
        listOfEmployees2.forEach(System.out::println);

        Function<LocalDate, Integer> calculatingAge = birthDate -> {
            LocalDate dateOfToday = LocalDate.now();
            Period age = Period.between(birthDate, dateOfToday);
            return age.getYears();
        };

        System.out.println("Age of each employee: ");

        List<Employee> listOfEmployeesWithAge = calculateAge(listOfEmployees2, calculatingAge);

        for (Employee emp : listOfEmployeesWithAge) {
            System.out.println("Name: " + emp.getName() + "\n" + "Date of birth: " + emp.getDateOfbirth() + "\n"
                    + "Age: " + emp.getAge() + "\n");
        }


        // 2. --------

        System.out.println("--------------------------------------------");
        int summedAge = 0;
        for (Employee emp : listOfEmployeesWithAge) {
            summedAge += emp.getAge();
        }

        int averageAge = summedAge / listOfEmployeesWithAge.size();
        System.out.println("Average age: " + averageAge);


        // 3. --------

        System.out.println("----------------------------------------------");

        System.out.println("Employees born in December: ");
        Predicate<Employee> bornInDecember = emp -> emp.getDateOfbirth().getMonthValue() == 12;

        List<Employee> listOfEmployeesBornInDecember =
                listOfEmployeesWithAge.stream().filter(bornInDecember).collect(Collectors.toList());

        listOfEmployeesBornInDecember.forEach(employee -> System.out.println("Name: " + employee.getName() + "\n" +
                "Date of birth: " + employee.getDateOfbirth() + "\n" +
                "Birth month: " + employee.getDateOfbirth().getMonth() + "\n"));

        ArrayList<Employee> listTester = new ArrayList<>();
        listTester.add(new Employee("Anders", 20));


        // 4. --------


    }

    private static List<Employee> calculateAge(List<Employee> listOfEmployees2, Function<LocalDate, Integer> calculatingAge) {

        List<Employee> listOfEmployeesWithAge = new ArrayList<>();
        for (Employee emp : listOfEmployees2) {
            int age = calculatingAge.apply(emp.getDateOfbirth());
            Employee employeeWithAge = new Employee(emp.getName(), emp.getDateOfbirth(), age);
            listOfEmployeesWithAge.add(employeeWithAge);
        }

        return listOfEmployeesWithAge;
    }


    static int operate(int a, int b, ArithmeticOperation op) {

        int result = op.perform(a, b);
        return result;
    }


    static int[] operate(int[] a, int[] b, ArithmeticOperation op) {

        List<Integer> listOfCalculatedNumbers = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int result = op.perform(a[i], b[i]);
            listOfCalculatedNumbers.add(result);
        }

        int[] arrayOfCalculatedNumbers = new int[listOfCalculatedNumbers.size()];

        int counter = 0;
        for (int i : listOfCalculatedNumbers) {
            arrayOfCalculatedNumbers[counter] = i;
            counter++;
        }

        return arrayOfCalculatedNumbers;
    }


    static int[] map(int[] a, MyTransformingType op) {

        List<Integer> listOfNumbers = new ArrayList<>();

        for (int i : a) {
            listOfNumbers.add(op.transform(i));
        }

        int[] arrayOftransformedNumbers = new int[listOfNumbers.size()];

        int counter = 0;
        for (int i : listOfNumbers) {
            arrayOftransformedNumbers[counter] = i;
            counter++;
        }

        return arrayOftransformedNumbers;
    }

    static int[] filter(int[] a, MyValidatingType op) {

        List<Integer> listOfNumbers = new ArrayList<>();

        for (int i : a) {
            if (op.validate(i)) {
                listOfNumbers.add(i);
            }
        }

        int[] arrayOfFilteredNumbers = new int[listOfNumbers.size()];

        int counter = 0;
        for (int i : listOfNumbers) {
            arrayOfFilteredNumbers[counter] = i;
            counter++;
        }
        return arrayOfFilteredNumbers;
    }


    private static List<Employee> createListOfEmployees(int numberOfEmployees, Supplier<Employee> supplier) {

        List<Employee> listOfEmployees = new ArrayList<>();
        for (int i = 0; i < numberOfEmployees; i++) {
            listOfEmployees.add(supplier.get());
        }
        return listOfEmployees;
    }

}


