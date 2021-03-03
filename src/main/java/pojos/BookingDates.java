package pojos;

public class BookingDates {
   /* {
        "firstname": "Selim",
            "lastname": "Ak",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
        "checkin": "2020-09-09",
                "checkout": "2020-09-21"
    }
    }

    */
    private String checkin;
    private String checkout;

    public BookingDates() {
    }

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
