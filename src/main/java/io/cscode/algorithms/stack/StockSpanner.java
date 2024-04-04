package io.cscode.algorithms.stack;

import java.util.Stack;

public class StockSpanner {

    final Stack<int[]> priceSpanPair; // each array will have two values -> price, span

    public StockSpanner() {
        priceSpanPair = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while(!priceSpanPair.isEmpty() && priceSpanPair.peek()[0] <= price) {
            span += priceSpanPair.peek()[1];
            priceSpanPair.pop();
        }
        priceSpanPair.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));

    }
}
