package booking;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;

import booking.external.Payment;
import booking.external.PaymentService;

@Entity
@Table(name="Booking_table")
public class Booking {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String musicalName;
    private String customerName;
    private Long telephoneInfo;
    private String addr;
    private String bookingStatus;

    @PostPersist
    public void onPostPersist(){

        BookingStarted bookingStarted = new BookingStarted();

        booking.external.Payment payment = new booking.external.Payment();
        payment.setBookingId(this.getId());
        payment.setAddr(this.getAddr());
        payment.setPaymentStatus("PAYMENT_COMPLETED");


        BookingApplication.applicationContext.getBean(booking.external.PaymentService.class).approvePay(payment);

        this.bookingStatus = "COMPLETE_BOOKING";
        bookingStarted.setId(this.getId());
        bookingStarted.setCustomerName(this.getCustomerName());
        bookingStarted.setTelephone(this.getTelephoneInfo());
        bookingStarted.setAddr(this.getAddr());
        bookingStarted.setBookingStatus("COMPLETE_BOOKING");
        System.out.println("\n\n##### listener bookingStarted : " + bookingStarted.toJson() + "\n\n");

        BeanUtils.copyProperties(this, bookingStarted);
        bookingStarted.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){

        this.setBookingStatus("CANCEL_BOOKING");
        BookingCanceled bookingCanceled = new BookingCanceled();

        bookingCanceled.setId(this.getId());
        bookingCanceled.setCustomerName(this.getCustomerName());
        bookingCanceled.setBookingStatus("CANCEL_BOOKING");

        BeanUtils.copyProperties(this, bookingCanceled);
        bookingCanceled.publishAfterCommit();
    }


    @PrePersist
    public void onPrePersist(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMusicalName() {
        return musicalName;
    }

    public void setMusicalName(String musicalName) {
        this.musicalName = musicalName;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Long getTelephoneInfo() {
        return telephoneInfo;
    }

    public void setTelephoneInfo(Long telephoneInfo) {
        this.telephoneInfo = telephoneInfo;
    }
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }




}