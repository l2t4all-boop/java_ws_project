package com.l2t.lcj.collections;

import java.util.HashSet;
import java.util.Set;

public class ProductManager {

    public static void main(String[] args) {
        Product p1 =
                Product.builder()
                        .name("iPhone16")
                        .brand("Apple")
                        .price(85000)
                        .build();
        Product p2 =
                Product.builder()
                        .name("iPhone16")
                        .brand("Apple")
                        .price(95000)
                        .build();

        Product p3 =
                Product.builder()
                        .name("iPhone17")
                        .brand("Apple")
                        .price(145000)
                        .build();
        Product p4 =
                Product.builder()
                        .name("iPhone16 Pro Max")
                        .brand("Apple")
                        .price(145000)
                        .build();

        Set<Product> productSet = new HashSet<>();
        productSet.add(p1);
        productSet.add(p2);
        productSet.add(p3);
        productSet.add(p4);

        System.out.println(productSet.size());
    }
}
