/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package javaapplication1;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderCalculatorTest {

    public OrderCalculatorTest() {
    }

    @Test
    public void testCalculateTotalPrice() {
    }
/* TC001:System appear error "No Item in the order" */
    @Test
    public void TestItemPriceNull() {
        OrderCalculator salaryCalculator = new OrderCalculator();
        salaryCalculator.calculateTotalPrice(new double[]{}, "none", false, "none");

    }
   /* TC002:System appear error "Items price must be grater than zero" */
     @Test
    public void TestPriceSmallerThan0() {
        OrderCalculator salaryCalculator = new OrderCalculator();
        double[] itemPrices = new double[]{-100, -200};
        salaryCalculator.calculateTotalPrice(itemPrices,"none", false, "none");
    }
    /* TC003:System calculateTotalPrice with discount =0.20 */
     @Test
    public void testIsVipCustomer(){
          OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{10,20}, "none", true, "none");
    }
    /* TC004:System calculateTotalPrice with discount =0.05 */
     @Test
    public void testIsRegularCutomer(){
         OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{20,30}, "Regular", false, "none");
    }
    /* TC005:System calculateTotalPrice with discount +=0.10 */
     @Test
     public void testDiscountCode10percent(){
         OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{30,40}, "none", false, "SALE10");
    }
     /* TC006:System calculateTotalPrice with discount +=0.05*/
      @Test
       public void testDiscountCode5percent(){
         OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{30,40}, "none", false, "WELCOME5");
    }
       /* TC007:System calculateTotalPrice with discount =0.30 */
        @Test
        public void testIsVipCustomerAndHaveDiscountCode10percent(){
          OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{10,20}, "none", true, "SALE10");
    }
        /* TC007:System calculateTotalPrice with discount =0.25 */
         @Test
         public void testIsVipCustomerAndHaveDiscountCode5percent(){
          OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{10,20}, "none", true, "WELCOME5");
    }
         /* TC008:System calculateTotalPrice with discount =0.15 */
          @Test
          public void testIsRegularCustomerAndHaveDiscountCode10percent(){
          OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{10,20}, "Regular", false, "SALE10");
    }
          /* TC009:System calculateTotalPrice with discount =0.10 */
           @Test
           public void testIsRegularCustomerAndHaveDiscountCode5percent(){
          OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{10,20}, "Regular", false, "WELCOME5");
    }
           /* TC0010:System calculateTotalPrice with discount =0.25*/
            @Test
           public void testRegularAndVipAtTheSameTime(){
         OrderCalculator salaryCalculator = new OrderCalculator();
             salaryCalculator.calculateTotalPrice(new double[]{30,40}, "Regular", true, "none");
    }
         

}
