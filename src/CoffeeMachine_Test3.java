import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine_Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> coffeeMachine = new LinkedHashMap<>();
        coffeeMachine.put("water", 400);
        coffeeMachine.put("milk", 540);
        coffeeMachine.put("beans", 120);
        coffeeMachine.put("cups", 9);

        int moneyInMachine = 550;

        showMaterials();

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int choice = Integer.parseInt(scanner.nextLine());
                choice1To3(coffeeMachine, moneyInMachine, choice);
                break;
            case "fill":
                fillMachine(scanner, coffeeMachine, moneyInMachine);
                break;
            case "take":

                System.out.printf("I gave you $%d%n", moneyInMachine);
                System.out.println();

                moneyInMachine = 0;

                machineStatus(coffeeMachine);
                System.out.println(showMachineMoney(moneyInMachine));

                break;
        }

    }

    private static void fillMachine(Scanner scanner, Map<String, Integer> coffeeMachine, int moneyInMachine) {
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
        machineStatus(coffeeMachine);
        System.out.println(showMachineMoney(moneyInMachine));
    }

    private static void choice1To3(Map<String, Integer> coffeeMachine, int moneyInMachine, int choice) {
        switch (choice) {
            case 1:
                coffeeMachine.put("water", coffeeMachine.get("water") - 250);
                coffeeMachine.put("beans", coffeeMachine.get("beans") - 16);
                coffeeMachine.put("cups", coffeeMachine.get("cups") - 1);
                moneyInMachine += 4;
                machineStatus(coffeeMachine);
                System.out.println(showMachineMoney(moneyInMachine));
                break;
            case 2:
                coffeeMachine.put("water", coffeeMachine.get("water") - 350);
                coffeeMachine.put("milk", coffeeMachine.get("milk") - 75);
                coffeeMachine.put("beans", coffeeMachine.get("beans") - 20);
                coffeeMachine.put("cups", coffeeMachine.get("cups") - 1);
                moneyInMachine += 7;
                machineStatus(coffeeMachine);
                System.out.println(showMachineMoney(moneyInMachine));
                break;
            case 3:
                coffeeMachine.put("water", coffeeMachine.get("water") - 200);
                coffeeMachine.put("milk", coffeeMachine.get("milk") - 100);
                coffeeMachine.put("beans", coffeeMachine.get("beans") - 12);
                coffeeMachine.put("cups", coffeeMachine.get("cups") - 1);
                moneyInMachine += 6;
                machineStatus(coffeeMachine);
                System.out.println(showMachineMoney(moneyInMachine));
                break;
        }
    }

    public static String showMachineMoney(int machineMoney) {
        return String.format("$%d of money%n", machineMoney);
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
            }
        });
    }

    public static void showMaterials() {
        System.out.println("""
                The coffee machine has:
                400 ml of water
                540 ml of milk
                120 g of coffee beans
                9 disposable cups
                $550 of money""");
        System.out.println();
    }
}
