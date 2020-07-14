package com.example.azuga.Azugademo.helper;

public class ItemHelper {

    public float applyTax(String itemCategory, float price, int quantity){
        switch(itemCategory){
            case "Medicine":
            case "Food":
                return calculateTax(5,price, quantity);
            case "Imported":
                return calculateTax(18,price, quantity);
            case "Clothes":
                if(price > 1000){
                    return calculateTax(12,price, quantity);
                }
                return calculateTax(5,price, quantity);
            case "Music":
                return calculateTax(3,price, quantity);
            default:
                return 0;
        }
    }

    private float calculateTax(int tax, float price, int quantity){
        float totalPrice = price * quantity;
        float resultTax = totalPrice * tax / 100;
        float newPrice = totalPrice + resultTax;
        return newPrice;
    }


}
