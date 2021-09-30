package booking;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Mypage_table")
public class Mypage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long bookingId;
        private String musicalName;
        private String customerName;
        private Long telephoneInfo;
        private String addr;
        private String bookingStatus;
        private String paymentStatus;
        private Long deliveryDate;
        private String shipperName;
        private String deliveryStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getBookingId() {
            return bookingId;
        }

        public void setBookingId(Long bookingId) {
            this.bookingId = bookingId;
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
        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }
        public Long getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(Long deliveryDate) {
            this.deliveryDate = deliveryDate;
        }
        public String getShipperName() {
            return shipperName;
        }

        public void setShipperName(String shipperName) {
            this.shipperName = shipperName;
        }
        public String getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(String deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }

}