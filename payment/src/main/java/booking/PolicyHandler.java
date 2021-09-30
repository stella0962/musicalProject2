package booking;

import booking.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @Autowired PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverBookingCanceled_CancelPay(@Payload BookingCanceled bookingCanceled){

        if(!bookingCanceled.validate()) return;

        java.util.Optional<Payment> paymentOptional = paymentRepository.findById(bookingCanceled.getId());

        Payment payment = paymentOptional.get();
        payment.setPaymentStatus("CANCEL_PAYMENT");
        paymentRepository.save(payment);


        System.out.println("\n\n##### listener CancelPay : " + bookingCanceled.toJson() + "\n\n");

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}