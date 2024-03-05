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

    }

    //id: String
    //method: String to save a sub-feature name.
    //status: String
    //paymentData: Map<String, String> to save payment sub-feature data.

    @Test
    void testPaymentByVoucherCodeSuccess() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "VOUCHER",
                "",
                paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }
    //If the payment status is set to “SUCCESS”, then the status of the Order object that is related to the Payment object will also be “SUCCESS”.

    @Test
    void testPaymentByVoucherCodeFailed() {
        Map<String, String> paymentFpaymentDataailed = new HashMap<>();
        paymentData.put("voucherCode", "INVALIDCODE");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "VOUCHER",
                "",
                paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
    @Test
    void testCashOnDeliverySuccess() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("address", "123 Street, City");
        paymentData.put("deliveryFee", "10");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "COD",
                "",
                paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCashOnDeliveryRejectedEmptyAddress() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("deliveryFee", "10");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "COD",
                "",
                paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testCashOnDeliveryRejectedEmptyDeliveryFee() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("address", "123 Street, City");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "COD",
                "",
                paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testPaymentByBankTransferSuccess() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Bank XYZ");
        paymentData.put("referenceCode", "123456");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "COD",
                "",
                paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testPaymentByBankTransferRejectedEmptyBankName() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("referenceCode", "123456");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "COD",
                "",
                paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testPaymentByBankTransferRejectedEmptyReferenceCode() {
        Map<String, String> paymentData = new HashMap<>();
        paymentData.put("bankName", "Bank XYZ");

        Payment payment = new Payment(
                "13652556-012a-4c07-b546-54eb1396d79b",
                this.orders.get(1),
                "COD",
                "",
                paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
}
