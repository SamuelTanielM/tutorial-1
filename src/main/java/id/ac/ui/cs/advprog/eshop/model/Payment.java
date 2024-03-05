package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class Payment {

    // Getters and Setters
    @Setter
    @Getter
    private String id;
    @Getter
    @Setter
    private String method;

    private Order order;
    @Setter
    @Getter
    private String status;
    @Setter
    @Getter
    private Map<String, String> paymentData;

    public Payment(String id, Order order, String method, Map<String, String> paymentData) {
        this.id = id;
        this.order = order;
        this.method = method;
        this.paymentData = paymentData;

        // Set payment status based on payment method
        switch (method) {
            case "VOUCHER" -> setPaymentByVoucherCodeStatus();
            case "COD" -> setCashOnDeliveryStatus();
            case "BANK_TRANSFER" -> setPaymentByBankTransferStatus();
        }

        // Update order status based on payment status
        if (this.status.equals("SUCCESS")) {
            order.setStatus(String.valueOf(OrderStatus.SUCCESS));
        } else if (this.status.equals("REJECTED")) {
            order.setStatus(String.valueOf(OrderStatus.FAILED));
        }

    }


    private void setPaymentByVoucherCodeStatus() {
        if (paymentData == null) {
            throw new IllegalArgumentException("Payment data is null");
        }

        if (paymentData.containsKey("voucherCode")) {
            String voucherCode = paymentData.get("voucherCode");
            if (isValidVoucherCode(voucherCode)) {
                this.status = "SUCCESS";
            } else {
                this.status = "REJECTED";
            }
        }
    }


    private boolean isValidVoucherCode(String voucherCode) {
        return voucherCode.length() == 16 && voucherCode.startsWith("ESHOP");
    }

    private void setCashOnDeliveryStatus() {
        if (paymentData == null) {
            throw new IllegalArgumentException("Payment data is null");
        }
        if (paymentData.containsKey("address") && paymentData.containsKey("deliveryFee")) {
            String address = paymentData.get("address");
            String deliveryFee = paymentData.get("deliveryFee");
            if (!address.isEmpty() && !deliveryFee.isEmpty()) {
                this.status = "SUCCESS";
            } else {
                this.status = "REJECTED";
            }
        } else {
            this.status = "REJECTED";
        }
    }

    private void setPaymentByBankTransferStatus() {
        if (paymentData == null) {
            throw new IllegalArgumentException("Payment data is null");
        }

        if (paymentData.containsKey("bankName") && paymentData.containsKey("referenceCode")) {
            String bankName = paymentData.get("bankName");
            String referenceCode = paymentData.get("referenceCode");
            if (!bankName.isEmpty() && !referenceCode.isEmpty()) {
                this.status = "SUCCESS";
            } else {
                this.status = "REJECTED";
            }
        } else {
            this.status = "REJECTED";
        }
    }

}
