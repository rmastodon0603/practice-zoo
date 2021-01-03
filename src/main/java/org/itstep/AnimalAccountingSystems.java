package org.itstep;

import org.itstep.animal.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalAccountingSystems {
    static ArrayList<Animal> animalList = new ArrayList<Animal>();
    static Scanner scanner = new Scanner(System.in);

    private static void addAnimal() {
        System.out.println("1 - Python\n" +
                "2 - Boa\n" +
                "3 - Viper\n" +
                "4 - Lion\n" +
                "5 - Panther\n" +
                "6 - Wolf\n" +
                "7 - Dingo Dog");
        int num;

        num = scanner.nextInt();
        String name;

        int age;
        int weight;
        int aviaryNumber;
        int timeSpentInTheZoo;

        System.out.println("Enter name");
        name = scanner.next();
        System.out.println("Enter age");
        age = scanner.nextInt();
        System.out.println("Enter weight");
        weight = scanner.nextInt();
        System.out.println("Enter aviary number");
        aviaryNumber = scanner.nextInt();
        System.out.println("Enter time spent in the zoo");
        timeSpentInTheZoo = scanner.nextInt();

        switch (num) {
            case 1: {
                int length;
                String color;
                System.out.println("Enter length");
                length = scanner.nextInt();
                System.out.println("Enter color");
                color = scanner.next();
                animalList.add(new Python("python", name, age, weight, aviaryNumber, timeSpentInTheZoo, length, color));
            }
            break;
            case 2: {
                int length;
                String color;
                System.out.println("Enter length");
                length = scanner.nextInt();
                System.out.println("Enter color");
                color = scanner.next();
                animalList.add(new Python("boa", name, age, weight, aviaryNumber, timeSpentInTheZoo, length, color));
            }
            break;
            case 3: {
                int length;
                String color;
                System.out.println("Enter length");
                length = scanner.nextInt();
                System.out.println("Enter color");
                color = scanner.next();
                animalList.add(new Python("viper", name, age, weight, aviaryNumber, timeSpentInTheZoo, length, color));
            }
            break;
            case 4: {
                boolean mane;
                System.out.println("Got a mane?");
                mane = scanner.nextBoolean();
                animalList.add(new Lion("lion", name, age, weight, aviaryNumber, timeSpentInTheZoo, mane));
            }
            break;
            case 5: {
                String color;
                System.out.println("Enter color");
                color = scanner.next();
                animalList.add(new Panther("panther", name, age, weight, aviaryNumber, timeSpentInTheZoo, color));
            }
            break;
            case 6: {
                animalList.add(new Wolf("wolf", name, age, weight, aviaryNumber, timeSpentInTheZoo));
            }
            break;
            case 7: {
                animalList.add(new DingoDog("dingoDog", name, age, weight, aviaryNumber, timeSpentInTheZoo));
            }
            break;
            default: {
                System.out.println("Error");
            }
        }
    }

    private static void showAnimals() {
        for (Animal animal : animalList) {
            System.out.println(animal.getName() + "(" + animal.getType() + ")");
        }
    }

    private static void deleteAnimal() {
        System.out.println("Enter nickname");
        String name;
        name = scanner.next();
        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).getName().equals(name)) {
                animalList.remove(i);
                return;
            }
        }
        System.out.println("Same animal not found");
    }

    private static void addingFoodExpenses() {
        System.out.println("Enter nickname");
        String name;
        name = scanner.next();
        for (Animal animal : animalList) {
            if (animal.getName().equals(name)) {
                System.out.println("Enter food expenses");
                int expenses;
                expenses = scanner.nextInt();
                animal.setFoodExpensesForTheCurrentDay(expenses);
                animal.setFoodExpensesForAllTime(animal.getFoodExpensesForAllTime() + expenses);
                return;
            }
        }
        System.out.println("Same animal not found");
    }

    private static int calculationFoodExpensesCurrentDay() {
        int expenses = 0;
        for (Animal animal : animalList) {
            expenses += animal.getFoodExpensesForTheCurrentDay();
        }
        return expenses;
    }

    private static int calculationFoodExpensesAllTime() {
        int expenses = 0;
        for (Animal animal : animalList) {
            expenses += animal.getFoodExpensesForAllTime();
        }
        return expenses;
    }

    public static void menu() {
        int menu;
        do {
            System.out.println("1 - Add new animal\n" +
                    "2 - Show all animals\n" +
                    "3 - Remove animal by nickname\n" +
                    "4 - Add food expenses\n" +
                    "5 - Calculate food expenses of current day\n" +
                    "6 - Calculate food expenses of entire period");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    showAnimals();
                    break;
                case 3:
                    deleteAnimal();
                    break;
                case 4:
                    addingFoodExpenses();
                    break;
                case 5:
                    System.out.println(calculationFoodExpensesCurrentDay());
                    break;
                case 6:
                    System.out.println(calculationFoodExpensesAllTime());
                    break;
            }
        } while (menu != 0);
    }
}
