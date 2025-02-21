/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author OS
 */
public class OrderCalculator {

    public double calculateTotalPrice(double[] itemPrices, String customerType,boolean isVIP, String discountCode ) {
        if (itemPrices == null || itemPrices.length ==0 ) {
            throw new IllegalArgumentException("No Item in the order");
        }
        double totalPrice = 0.0;
        for (double price: itemPrices){
            if(price<=0){
                throw new IllegalArgumentException("Items price must be grater than zero");
            }
            totalPrice+=price;
        }
       double discount =0.0;
       if (isVIP){
           discount = 0.20;
       }else if (customerType.equalsIgnoreCase("Regular")){
           discount = 0.05;
       }
       if (discountCode !=null && discountCode.isEmpty()){
           if(discountCode.equals("Sale10")){
               discount+=0.10;
           }else if (discountCode.equals("WELCOMES")){
               discount+=0.05;
           }
       }
       double finalPrice = totalPrice*(1-discount);
       return finalPrice < 0 ? 0 : finalPrice;
    
}
}
