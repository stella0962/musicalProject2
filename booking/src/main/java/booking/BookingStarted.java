package booking;

public class BookingStarted extends AbstractEvent {

    private Long id;
    private String musicalName;
    private String customerName;
    private Long telephone;
    private String addr;
    private String bookingStatus;


    public BookingStarted(){
        super();
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
    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
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