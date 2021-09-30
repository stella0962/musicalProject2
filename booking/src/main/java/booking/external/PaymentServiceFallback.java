package booking.external;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallback implements PaymentService {
    @Override
    public boolean approvePay(Payment payment) {

        System.out.println("\\n=========FALL BACK STARTING=========\\n"); //fallback 메소드 작동 테스트

        return false;
    }
}