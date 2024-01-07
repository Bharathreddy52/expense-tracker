package expense_Tracker;

import java.io.Serializable;

class Expense implements Serializable{
	private static final long serialVersionUID = 1L;
    String date;
    String category;
    double amount;

    Expense(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Category: " + category + ", Amount: " + amount;
    }
}



