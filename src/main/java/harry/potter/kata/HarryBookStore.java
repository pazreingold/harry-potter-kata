package harry.potter.kata;

import java.util.Map;

public class HarryBookStore {
    public double buy(Map<Integer, Integer> books) {
        return calculatePurchase(books, calculateDiscount(books));
    }

    private double calculateDiscount(Map<Integer, Integer> books) {
        double discount = 0;

        if (books.size() == 2) {
            discount = 0.05;
        } else if (books.size() == 3) {
            discount = 0.1;
        } else if (books.size() == 4) {
            discount = 0.2;
        } else if (books.size() == 5) {
            discount = 0.25;
        }
        return discount;
    }

    private double calculatePurchase(Map<Integer, Integer> books, double discount) {
        int price = 8;
        double sum = 0;

        for (int copies : books.values()) {
            sum += copies * price * (1 - discount);
        }
        return sum;
    }
}