package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentRepositoryTest {

    private PaymentRepository paymentRepository;
    private List<Order> orders;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);
        orders = new ArrayList<>();
        Order order1 = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products,
                1708560000L,
                "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("7f915bb-4b15-42f4-aebc-c3af385fb078",
                products,
                1708570600L,
                "Safira Sudrajat");
        orders.add(order2);
        Order order3 = new Order("e334ef40-9eff-4da8-9487-8ee697ecbf1e",
                products,
                1708570000L,
                "Bambang Sudrajat");
        orders.add(order3);
    }

    @Test
    void testSaveCreate() {
        Order order = orders.get(1);
        Payment payment = new Payment(
                order.getId(),
                order,
                "VOUCHER",
                null);

        Payment result = paymentRepository.save(payment);
        Payment findResult = paymentRepository.findById(orders.get(1).getId());

        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals(payment.getMethod(), findResult.getMethod());
        assertEquals(payment.getStatus(), findResult.getStatus());
        assertEquals(payment.getPaymentData(), findResult.getPaymentData());
    }

    @Test
    void testSaveUpdate() {
        Order order = orders.get(1);
        Payment payment = new Payment(
                order.getId(),
                order,
                "VOUCHER",
                null);

        paymentRepository.save(payment);

        Payment newPayment = new Payment(
                order.getId(),
                order,
                "VOUCHER",
                null);
        newPayment.setStatus("SUCCESS");

        Payment result = paymentRepository.save(newPayment);
        Payment findResult = paymentRepository.findById(orders.get(1).getId());

        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getId(), findResult.getId());
        assertEquals("SUCCESS", findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdFound() {
        Order order = orders.get(1);
        Payment payment = new Payment(
                order.getId(),
                order,
                "VOUCHER",
                null);
        paymentRepository.save(payment);

        Payment findResult = paymentRepository.findById(orders.get(1).getId());

        assertEquals(orders.get(1).getId(), findResult.getId());
        assertEquals("VOUCHER", findResult.getMethod());
        assertEquals("REJECTED", findResult.getStatus());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        for (Order order : orders) {
            Payment payment = new Payment(
                    order.getId(),
                    order,
                    "VOUCHER",
                    null);
            paymentRepository.save(payment);
        }

        Payment findResult = paymentRepository.findById("zczc");
        assertNull(findResult);
    }

    @Test
    void testFindAllByAuthorIfAuthorCorrect() {
        for (Order order : orders) {
            Payment payment = new Payment(
                    order.getId(),
                    order,
                    "VOUCHER",
                    null);
            paymentRepository.save(payment);
        }

        List<Payment> paymentList = paymentRepository.getAllPayments();
        assertEquals(3, paymentList.size());
    }

    @Test
    void testFindAllByAuthorIfAllLowercase() {
        Payment payment = new Payment(
                orders.get(1).getId(),
                orders.get(1),
                "VOUCHER",
                null);
        paymentRepository.save(payment);

        List<Payment> paymentList = paymentRepository.getAllPayments();
        assertTrue(paymentList.isEmpty());
    }
}
