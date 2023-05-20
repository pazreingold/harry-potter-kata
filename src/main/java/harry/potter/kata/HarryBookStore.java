package harry.potter.kata;

import java.util.*;

public class HarryBookStore {
    public double buy(Map<Integer, Integer> books) {
        return divideBooksToSeries(books)
                .stream()
                .mapToDouble(bookSeries -> calculatePurchase(bookSeries, calculateDiscount(bookSeries)))
                .reduce(0, Double::sum);
    }

    private List<Map<Integer, Integer>> divideBooksToSeries(Map<Integer, Integer> books) {
        List<Map<Integer, Integer>> series = new ArrayList<>();

        int max = books.values().stream().max(Integer::compare).get();

        for (int i = 1; i <= max; i++) {
            Map booksSeries = new HashMap();
            for (int j = 1; j <= books.size(); j++) {
                if (books.get(j) >= i) {
                    booksSeries.put(j, 1);
                }
            }

            series.add(booksSeries);
        }
        return series;
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