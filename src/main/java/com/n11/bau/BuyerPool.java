package com.n11.bau;

public class BuyerPool {

    public static Buyer getBauBuyer() {
        return new Buyer("test@baun.com", "123qwe", "test test");
    }

    public static Buyer getBauBuyer2() {
        return new Buyer("test2@baun.com", "123qwe", "test test");
    }
}
