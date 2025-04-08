package com.dsa.stack.StockSpanner.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class OnlineStockSpanner {
    List<Integer> prices;

    public OnlineStockSpanner() {
        prices = new ArrayList<>();
    }

    public int next(int price) {
        prices.add(price);
        int span = 1;
        for (int i = prices.size() - 2; i >= 0; i -= 1) {
            if (prices.get(i) <= price)
                span += 1;
            else
                break;
        }
        return span;
    }

}
