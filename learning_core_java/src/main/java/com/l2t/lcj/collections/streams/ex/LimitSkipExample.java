package com.l2t.lcj.collections.streams.ex;

import java.util.List;

record Product(int id, String name, double price){}
public class LimitSkipExample {

    public static void main(String[] args) {

        List<Product> products
                = List.of(
                    new Product(1001,"iPhone17 Pro",160000),
                    new Product(1002,"iPhone17",120000),
                    new Product(1003,"iPhone16",100000),
                    new Product(1004,"iPhone16 Pro",140000),
                    new Product(1005,"iPhone16 Pro Max 512",120000),
                    new Product(1006,"iPhone16 Pro Max 256",110000),
                    new Product(1007,"iPhone16 Pro Max 1TB",220000),
                    new Product(1008,"iPhone18",180000),
                    new Product(1009,"iPhone18 Pro",280000),
                    new Product(1010,"iPhone18 Pro Max",290000)
                );
        // Sort by price and skip first 5 products give me only 2 product after skip
    }
}
