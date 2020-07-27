package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int defWater = 400; // default amount of water
    static int defMilk = 540;
    static int defCoffee = 120;
    static int defDisCups = 9;
    static int defMoney = 550;
    static boolean isExit = false;
//    static String action;

    public enum State {
        BUY("buy"),
        FILL("fill"),
        TAKE("take"),
        REMAINING("remaining"),
        EXIT("exit");

        String action;

        State(String action) {
            this.action = action;
        }

        public static State checkState(String input) {
            for (State value : values()) {
                if (input.equals(value.action)) {
                    return value;
                }
            }
            return EXIT;
        }
    }

    public static void updateState(int water, int milk, int coffee, int disCups, int money) {
        defWater -= water;
        defMilk -= milk;
        defCoffee -= coffee;
        defDisCups -= disCups;
        defMoney += money;
    }

    public static void remaining() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(defWater + " of water");
        System.out.println(defMilk + " of milk");
        System.out.println(defCoffee + " of coffee beans");
        System.out.println(defDisCups + " of disposable cups");
        System.out.println(defMoney + " of money");
        System.out.println();
    }

    public static void buy(){
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String buyChoice = scanner.nextLine();
        System.out.println();
        switch (buyChoice) {
            case "1": // espresso - water 250, coffee 16, $4
                if (defWater >= 250 && defCoffee >= 16 && defDisCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    updateState(250,0,16,1,4);
                } else if (defWater < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (defCoffee < 16) {
                    System.out.println("Sorry, not enough coffee!");
                    break;
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                }
                break;
            case "2": // latte - water 350, milk 75, coffee 20, $7
                if (defWater >= 350 && defMilk >= 75 && defCoffee >= 20 && defDisCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    updateState(350,75,20,1,7);
                } else if (defWater < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (defMilk < 75) {
                        System.out.println("Sorry, not enough milk!");
                        break;
                } else if (defCoffee < 20) {
                    System.out.println("Sorry, not enough coffee!");
                    break;
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                }
                break;
            case "3": // cappuccino - water 200, milk 100, coffee 12, $6
                if (defWater >= 200 && defMilk >= 100 && defCoffee >= 12 && defDisCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    updateState(200,100,12,1,6);
                } else if (defWater < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else if (defMilk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else if (defCoffee < 12) {
                    System.out.println("Sorry, not enough coffee!");
                    break;
                } else {
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
                }
                break;
            case "back":
                break;
        }
    }

    public static void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int addCoffee = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addDisCups = scanner.nextInt();
        System.out.println();
        updateState(-addWater, -addMilk, -addCoffee, -addDisCups,0);
    }

    public static void take(){
        System.out.println("I gave you $" + defMoney);
        System.out.println();
        updateState(0,0,0,0, -defMoney);
    }

    public static void exit() {
        isExit = true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!isExit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            State state = State.checkState(scanner.nextLine());
            switch (state) {
                case BUY:
                    buy();
                    break;
                case FILL:
                    fill();
                    break;
                case TAKE:
                    take();
                    break;
                case REMAINING:
                    updateState(0,0,0,0,0);
                    remaining();
                    break;
                case EXIT:
                    exit();
                    break;
            }
        }
    }
}

