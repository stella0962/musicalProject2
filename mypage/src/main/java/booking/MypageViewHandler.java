package booking;

import booking.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MypageViewHandler {


    @Autowired
    private MypageRepository mypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingStarted_then_CREATE_1 (@Payload BookingStarted bookingStarted) {
        try {

            if (!bookingStarted.validate()) return;

            // view 객체 생성
            Mypage mypage = new Mypage();
            // view 객체에 이벤트의 Value 를 set 함
            mypage.setBookingId(bookingStarted.getId());
            mypage.setMusicalName(bookingStarted.getMusicalName());
            mypage.setCustomerName(bookingStarted.getCustomerName());
            mypage.setTelephoneInfo(Long.valueOf(bookingStarted.getTelephone()));
            mypage.setAddr(bookingStarted.getAddr());
            mypage.setBookingStatus(bookingStarted.getBookingStatus());
            // view 레파지 토리에 save
            mypageRepository.save(mypage);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenBookingCanceled_then_UPDATE_1(@Payload BookingCanceled bookingCanceled) {
        try {
            if (!bookingCanceled.validate()) return;
                // view 객체 조회

                    List<Mypage> mypageList = mypageRepository.findByBookingId(bookingCanceled.getId());
                    for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setBookingStatus("CANCEL_BOOKING'");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPaymentApproved_then_UPDATE_2(@Payload PaymentApproved paymentApproved) {
        try {
            if (!paymentApproved.validate()) return;
                // view 객체 조회

                    List<Mypage> mypageList = mypageRepository.findByBookingId(paymentApproved.getBookingId());
                    for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setPaymentStatus("COMPLETE_PAYMENT");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCanceled_then_UPDATE_3(@Payload PayCanceled payCanceled) {
        try {
            if (!payCanceled.validate()) return;
                // view 객체 조회

                    List<Mypage> mypageList = mypageRepository.findByBookingId(payCanceled.getBookingId());
                    for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setPaymentStatus("CANCEL_PAYMENT");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_4(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회

                    List<Mypage> mypageList = mypageRepository.findByBookingId(deliveryStarted.getBookingId());
                    for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setDeliveryDate(deliveryStarted.getDeliveryDate());
                    mypage.setShipperName(deliveryStarted.getShipperName());
                    mypage.setDeliveryStatus("COMPLETE_DELIVERY");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryCanceled_then_UPDATE_5(@Payload DeliveryCanceled deliveryCanceled) {
        try {
            if (!deliveryCanceled.validate()) return;
                // view 객체 조회

                    List<Mypage> mypageList = mypageRepository.findByBookingId(deliveryCanceled.getBookingId());
                    for(Mypage mypage : mypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    mypage.setDeliveryStatus("CANCEL_DELIVERY");
                // view 레파지 토리에 save
                mypageRepository.save(mypage);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

