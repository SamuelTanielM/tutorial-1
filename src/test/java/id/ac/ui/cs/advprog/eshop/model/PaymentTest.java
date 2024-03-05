package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaymentTest {

    private List<Product> products;

    List<Order> orders;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("a2c62328-4837-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        this.products.add(product1);
        this.products.add(product2);

        this.orders = new ArrayList<>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat");
        Order order2 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Makara");
        this.orders.add (order1);
        this.orders.add (order2);

        this.paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP12345678");

    }

    //id: String
    //method: String to save a sub-feature name.
    //status: String
    //paymentData: Map<String, String> to save payment sub-feature data.

    @Test
    void testPaymentByVoucherCodeFailed() {
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                PaymentStatus.SUCCESS.getValue(),
                this.paymentData);

        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }
    //If the payment status is set to “SUCCESS”, then the status of the Order object that is related to the Payment object will also be “SUCCESS”.

    @Test
    void testPaymentByVoucherCodeFailed() {
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                PaymentStatus.REJECTED.getValue(),
                this.paymentData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testCreateOrderInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            Payment payment = new Payment(
                    "13652556-012a-4c07-b546-54eb1396d79b",
                    this.orders.get(1),
                    "DAA BASDAT KUIS ;-;",
                    this.paymentData);
        });
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                this.paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("MEOW"));
    }
}
