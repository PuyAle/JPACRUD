package ui;

import java.util.List;
import java.util.Scanner;
import entities.Product;

public class UI {

    final static Scanner sc = new Scanner(System.in);
//
    private static int choice;

    public static int menu() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("==================================");
                System.out.println("1. Register product");
                System.out.println("2. Print all products");
                System.out.println("3. Print product by name");
                System.out.println("4. Print product by pricerange");
                System.out.println("5. Update product name");
                System.out.println("6. Update product price");
                System.out.println("7. Delete product");
                System.out.println("0. Exit");
                System.out.println("==================================");

                System.out.println("Enter a number from the menu");
                choice = sc.nextInt();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("wrong choice try again");
            }

        }

        return choice;
    }

    public String enterName() {
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("Enter the name of the product");
                String name = sc.nextLine();
                return name;
            } catch (Exception e) {
                System.out.println("wrong choice try again");

            }
        }
        return null;
    }

    public double enterPrice() {
        boolean loop = true;
        double price = 0;
        while (loop) {

            try {
                System.out.println("Enter the price");
                price = sc.nextDouble();
                sc.nextLine();
                loop = false;

            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Wrong choice");
            }
        }
        return price;
    }

    public void printList(List<Product> a) {
        if (a.isEmpty()) {
            System.out.println("Is empty!");
        } else {
            a.forEach(System.out::println);
        }
    }

    public int enterId() {
        boolean loop = true;
        int id = 0;
        while (loop) {
            try {
                System.out.println("Enter the id of the product: ");
                id = sc.nextInt();
                sc.nextLine();
                loop = false;
            } catch (Exception e) {
                System.out.println("Wrong choice!");
            }
        }
        return id;
    }

}
