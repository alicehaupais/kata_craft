package com.megacorp.ecs;

import java.util.Scanner;

public class CLI {

    private static Scanner scanner;
    private static final String[] COMMANDS = {"quit - quit the program", "order - create a new command", "help - " +
            "displays the help"};

    private static Command order;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        showDivider("Welcome to Efficent Command System 2.0");
        loop();
    }

    public static void loop() {
        System.out.print("Enter command : ");

        String command = scanner.next();

        switch (command) {
            case "quit":
                showDivider("System stopped");
                break;
            case "order":
                createOrder();
                break;
            default:
                showHelp();
                loop();
        }
    }

    private static void createOrder() {
        Command order = new Command();

        showDivider("Order Menu");

        System.out.println("New order created.");
        System.out.println("Add new elements to your order");
        addStuff(order);
        orderLoop();
    }

    private static void addStuff(Command order) {
        System.out.print("\nWhat do you want to add to order: ");
        String command = scanner.next();
        int quantity = 0;

        switch (command) {
            case "perpend":
                System.out.println("\nHow many perpends palets do you need ?");
                System.out.print("Enter quantity : ");
                quantity = Integer.parseInt(scanner.next());
                order.addPerpend(quantity);
                break;
            case "wire":
                System.out.println("\nHow many copper wire meters do you need ?");
                System.out.print("Enter quantity : ");
                quantity = Integer.parseInt(scanner.next());
                order.addCopperWire(quantity);
                break;
            default:
                System.out.println("\nNothing added");
        }
        CLI.order = order;
    }

    private static void orderLoop() {
        System.out.print("\nEnter order command : ");
        String command = scanner.next();

        switch (command) {
            case "show":
                showOrder();
                break;
            case "add":
                addStuff(order);
                break;
            case "save":
                order.save();
            case "stop":
                System.out.println("\nQuit Order Menu\n");
                loop();
                return;
            default:
                showHelp();
        }
        orderLoop();
    }

    private static void showOrder() {
        order.show();
    }

    public static void showHelp() {
        System.out.println("\nUnknown command\nThe available commands are the following : \n");
        for (int i = 0; i < COMMANDS.length; i++) {
            System.out.println(COMMANDS[i]);
        }
        System.out.println("");
    }

    public static void showDivider(String title) {
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("          " + title);
        System.out.println("--------------------------------------------------------------------------------\n");
    }
}
