package expense_Tracker;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager();

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. List All Expenses");
            System.out.println("3. Category-wise Summation");
            System.out.println("4. Save to File");
            System.out.println("5. Load from File");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter date (yyyy-mm-dd): ");
                    String date = scanner.next();
                    System.out.print("Enter category: ");
                    String category = scanner.next();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    Expense newExpense = new Expense(date, category, amount);
                    expenseManager.addExpense(newExpense);
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    List<Expense> allExpenses = expenseManager.getAllExpenses();
                    for (Expense expense : allExpenses) {
                        System.out.println(expense);
                    }
                    break;

                case 3:
                    Map<String, Double> categorySumMap = expenseManager.getCategoryWiseSummation();
                    for (Map.Entry<String, Double> entry : categorySumMap.entrySet()) {
                        System.out.println("Category: " + entry.getKey() + ", Total Expense: " + entry.getValue());
                    }
                    break;

                case 4:
                    expenseManager.saveToFile("expenses.dat");
                    break;

                case 5:
                    expenseManager.loadFromFile("expenses.dat");
                    break;

                case 6:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
