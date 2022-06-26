import java.util.Scanner;

public class CoffeeMachine_Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printText();

        System.out.println("Write how many cups of coffee you will need:");

        int cups = Integer.parseInt(scanner.nextLine());
        System.out.println(calculateIngredients(cups));




    }

    public static void printText() {
        System.out.println("""
                Starting to make a coffee
                Grinding coffee beans
                Boiling water
                Mixing boiled water with crushed coffee beans
                Pouring coffee into the cup
                Pouring some milk into the cup
                Coffee is ready!""");
    }

    public static String calculateIngredients(int cups) {

        int water = 200 * cups;
        int milk = 50 * cups;
        int coffeeBeans = 15 * cups;

        return String.format("For %d cups of coffee you will need:%n%d ml of water%n%d ml of milk%n%d g of coffee beans",
                cups, water, milk, coffeeBeans);
    }  //връща String, който трябва да се отпечата !!!
}
