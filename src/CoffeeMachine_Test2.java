import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine_Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> coffeeMachine = new LinkedHashMap<>();

        System.out.println("Write how many ml of water the coffee machine has:");
        coffeeMachine.put("Water", Integer.parseInt(scanner.nextLine()));
//        getWater(coffeeMachine, "Water");

        System.out.println("Write how many ml of milk the coffee machine has: ");
        coffeeMachine.put("Milk", Integer.parseInt(scanner.nextLine()));
//        getMilk(coffeeMachine, "Milk");

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        coffeeMachine.put("Beans", Integer.parseInt(scanner.nextLine()));
//        getCoffeeBeans(coffeeMachine, "Beans");

        System.out.println("Write how many cups of coffee you will need:");
        int cups = Integer.parseInt(scanner.nextLine());

        int waterPerCup = 200;
        int milkPerCup = 50;
        int beansPerCup = 15;

        int countCups = 0;

        while (coffeeMachine.get("Water") >= waterPerCup && coffeeMachine.get("Milk") >= milkPerCup && coffeeMachine.get("Beans") >= beansPerCup) {
            coffeeMachine.put("Water", coffeeMachine.get("Water") - waterPerCup);
            coffeeMachine.put("Milk", coffeeMachine.get("Milk") - milkPerCup);
            coffeeMachine.put("Beans", coffeeMachine.get("Beans") - beansPerCup);
            countCups++;
        }

        if (countCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        }

        if (countCups > cups) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)%n", countCups - cups);
        } else if (countCups < cups) {
            System.out.printf("No, I can make only %d cup(s) of coffee%n", countCups);
        }


    }


//    private static void getCoffeeBeans(Map<String, Integer> coffeeMachine, String beans) {
//        coffeeMachine.entrySet().stream().forEach(el -> {
//            if (el.getKey().equals(beans)) {
//                System.out.println(el.getValue());
//            }
//        });
//    }
//
//    private static void getMilk(Map<String, Integer> coffeeMachine, String milk) {
//        coffeeMachine.entrySet().stream().forEach(el -> {
//            if (el.getKey().equals(milk)) {
//                System.out.println(el.getValue());
//            }
//        });
//    }
//
//    private static void getWater(Map<String, Integer> coffeeMachine, String water) {
//        coffeeMachine.entrySet().stream().forEach(el -> {
//            if (el.getKey().equals(water)) {
//                System.out.println(el.getValue());
//            }
//        });
//    }
}
