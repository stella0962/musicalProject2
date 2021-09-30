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
    @Autowired DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentApproved_StartDelivery(@Payload PaymentApproved paymentApproved){

        if(!paymentApproved.validate()) return;

        System.out.println("\n\n##### listener StartDelivery : " + paymentApproved.toJson() + "\n\n");



        // Sample Logic //
        // Delivery delivery = new Delivery();
        // deliveryRepository.save(delivery);

    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayCanceled_CancelDelivery(@Payload PayCanceled payCanceled){

        if(!payCanceled.validate()) return;

        System.out.println("\n\n##### listener CancelDelivery : " + payCanceled.toJson() + "\n\n");



        // Sample Logic //
        // Delivery delivery = new Delivery();
        // deliveryRepository.save(delivery);

    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}


}