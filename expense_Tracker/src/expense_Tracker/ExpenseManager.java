package expense_Tracker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ExpenseManager {
    private List<Expense> expenses;

    ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    void addExpense(Expense expense) {
        expenses.add(expense);
    }

    List<Expense> getAllExpenses() {
        return expenses;
    }

    Map<String, Double> getCategoryWiseSummation() {
        Map<String, Double> categorySumMap = new HashMap<>();
        for (Expense expense : expenses) {
            categorySumMap.merge(expense.category, expense.amount, Double::sum);
        }
        return categorySumMap;
    }

    void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(expenses);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            expenses = (List<Expense>) ois.readObject();
            System.out.println("Data loaded successfully!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

