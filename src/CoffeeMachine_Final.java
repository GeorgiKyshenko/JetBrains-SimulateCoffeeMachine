import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine_Final {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> coffeeMachine = new LinkedHashMap<>();
        coffeeMachine.put("water", 400);
        coffeeMachine.put("milk", 540);
        coffeeMachine.put("beans", 120);
        coffeeMachine.put("cups", 9);
        coffeeMachine.put("money", 550);
        
//        int moneyInMachine = 550;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();

            switch (action) {
                case "remaining":
                    System.out.println();
                    machineStatus(coffeeMachine);
                    continue;
                case "exit":
                    return;
                case "take":
                    System.out.println();
                    takeMachineMoney(coffeeMachine);
                    break;
                case "buy":
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");

                    String choice = scanner.nextLine();
                    choices(coffeeMachine, choice);
                    break;
                case "fill":
                    System.out.println();
                    fillMachine(scanner, coffeeMachine);
                    break;
            }
        }
    }

    private static void choices(Map<String, Integer> coffeeMachine, String choice) {
        switch (choice) {
            case "1":
                if (coffeeMachine.get("water") >= 250 && coffeeMachine.get("beans") >= 16) {
                    System.out.println("I have enough resources, making you a coffee!\n");

                    coffeeMachine.put("water", coffeeMachine.get("water") - 250);
                    coffeeMachine.put("beans", coffeeMachine.get("beans") - 16);
                    coffeeMachine.put("cups", coffeeMachine.get("cups") - 1);
                    coffeeMachine.put("money", coffeeMachine.get("money") + 4);
                } else {
                    if (coffeeMachine.get("water") < 250) {
                        System.out.println("Sorry, not enough water!\n");
                    } else if (coffeeMachine.get("beans") < 16) {
                        System.out.println("Sorry, not enough coffee beans!\n");
                    }
                }
                break;
            case "2":
                if (coffeeMachine.get("water") >= 350 && coffeeMachine.get("beans") >= 20
                        && coffeeMachine.get("milk") >= 75) {
                    System.out.println("I have enough resources, making you a coffee!\n");

                    coffeeMachine.put("water", coffeeMachine.get("water") - 350);
                    coffeeMachine.put("milk", coffeeMachine.get("milk") - 75);
                    coffeeMachine.put("beans", coffeeMachine.get("beans") - 20);
                    coffeeMachine.put("cups", coffeeMachine.get("cups") - 1);
                    coffeeMachine.put("money", coffeeMachine.get("money") + 7);
                } else {
                    if (coffeeMachine.get("water") < 350) {
                        System.out.println("Sorry, not enough water!\n");
                    } else if (coffeeMachine.get("milk") < 75) {
                        System.out.println("Sorry, not enough milk!\n");
                    } else if (coffeeMachine.get("beans") < 20) {
                        System.out.println("Sorry, not enough coffee beans!\n");
                    }
                }
                break;
            case "3":
                if (coffeeMachine.get("water") >= 200 && coffeeMachine.get("beans") >= 12
                        && coffeeMachine.get("milk") >= 100) {
                    System.out.println("I have enough resources, making you a coffee!\n");

                    coffeeMachine.put("water", coffeeMachine.get("water") - 200);
                    coffeeMachine.put("milk", coffeeMachine.get("milk") - 100);
                    coffeeMachine.put("beans", coffeeMachine.get("beans") - 12);
                    coffeeMachine.put("cups", coffeeMachine.get("cups") - 1);
                    coffeeMachine.put("money", coffeeMachine.get("money") + 6);
                } else {
                    if (coffeeMachine.get("water") < 200) {
                        System.out.println("Sorry, not enough water!\n");
                    } else if (coffeeMachine.get("milk") < 100) {
                        System.out.println("Sorry, not enough milk!\n");
                    } else if (coffeeMachine.get("beans") < 12) {
                        System.out.println("Sorry, not enough coffee beans!\n");
                    }
                }
                break;
            case "back":
                System.out.println();
                break;
        }
    }

    private static void takeMachineMoney(Map<String, Integer> coffeeMachine) {
        coffeeMachine.entrySet().forEach(el -> {
            if (el.getKey().equals("money")) {
                System.out.printf("I gave you $%d%n", el.getValue());
                coffeeMachine.put("money", 0);
            }
        });
        System.out.println();
    }

    private static void machineStatus(Map<String, Integer> coffeeMachine) {
        coffeeMachine.entrySet().forEach(el -> {
            if (el.getKey().equals("water")) {
                System.out.printf("%d ml of water%n", el.getValue());
            } else if (el.getKey().equals("milk")) {
                System.out.printf("%d ml of milk%n", el.getValue());
            } else if (el.getKey().equals("beans")) {
                System.out.printf("%d g of coffee beans%n", el.getValue());
            } else if (el.getKey().equals("cups")) {
                System.out.printf("%d disposable cups%n", el.getValue());
            } else if (el.getKey().equals("money")) {
                System.out.printf("$%d of money%n", el.getValue());
            }
        });
        System.out.println();
    }

    private static void fillMachine(Scanner scanner, Map<String, Integer> coffeeMachine) {
        System.out.println("Write how many ml of water you want to add:");

        int waterAdded = Integer.parseInt(scanner.nextLine());
        coffeeMachine.put("water", coffeeMachine.get("water") + waterAdded);

        System.out.println("Write how many ml of milk you want to add:");

        int milkAdded = Integer.parseInt(scanner.nextLine());
        coffeeMachine.put("milk", coffeeMachine.get("milk") + milkAdded);

        System.out.println("Write how many grams of coffee beans you want to add:");

        int beansAdded = Integer.parseInt(scanner.nextLine());
        coffeeMachine.put("beans", coffeeMachine.get("beans") + beansAdded);

        System.out.println("Write how many disposable cups of coffee you want to add:");

        int cupsAdded = Integer.parseInt(scanner.nextLine());
        coffeeMachine.put("cups", coffeeMachine.get("cups") + cupsAdded);
    }
}
