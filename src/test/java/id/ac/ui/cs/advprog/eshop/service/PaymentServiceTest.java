package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private Order order;
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                products,
                1708560000L,
                "Safira Sudrajat");

        paymentData = new HashMap<>();
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
    }

    @Test
    void testAddPayment() {
        Payment payment = new Payment("paymentId", order, "VOUCHER", paymentData);
        when(paymentRepository.save(payment)).thenReturn(payment);

        Payment savedPayment = paymentService.addPayment(order, "VOUCHER", paymentData);
        assertEquals(payment, savedPayment);
    }

    @Test
    void testSetStatusSuccess() {
        Payment payment = new Payment("paymentId", order, "VOUCHER", paymentData);
        paymentService.setStatus(payment, "SUCCESS");

        assertEquals("SUCCESS", payment.getStatus());
        assertEquals(OrderStatus.SUCCESS.toString(), order.getStatus());
    }

    @Test
    void testSetStatusRejected() {
        Payment payment = new Payment("paymentId", order, "VOUCHER", paymentData);
        paymentService.setStatus(payment, "REJECTED");

        assertEquals("REJECTED", payment.getStatus());
        assertEquals(OrderStatus.FAILED.toString(), order.getStatus());
    }

    @Test
    void testGetPayment() {
        Payment payment = new Payment("paymentId", order, "VOUCHER", paymentData);
        when(paymentRepository.findById("paymentId")).thenReturn(payment);

        Payment retrievedPayment = paymentService.getPayment("paymentId");
        assertEquals(payment, retrievedPayment);
    }

    @Test
    void testGetAllPayments() {
        List<Payment> paymentList = Arrays.asList(
                new Payment("paymentId1", order, "VOUCHER", paymentData),
                new Payment("paymentId2", order, "CASH", new HashMap<>()),
                new Payment("paymentId3", order, "BANK_TRANSFER", new HashMap<>()));

        when(paymentRepository.getAllPayments()).thenReturn(paymentList);

        List<Payment> retrievedPayments = paymentService.getAllPayments();
        assertEquals(paymentList, retrievedPayments);
    }
}
