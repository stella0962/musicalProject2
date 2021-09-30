package booking;

public class BookingStarted extends AbstractEvent {

    private Long id;
    private String musicalName;
    private String customerName;
    private Integer telephoneInfo;
    private String addr;
    private String bookingStatus;

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
    public Integer getTelephone() {
        return telephoneInfo;
    }

    public void setTelephone(Integer telephoneInfo) {
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