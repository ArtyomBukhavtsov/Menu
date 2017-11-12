import java.io.Serializable;

public class CustomerAccount extends Client implements Serializable {
    private String rate;
    private int internet;
    private String phoneNumber;
    private double balance;
    private String typeOfRate;
    private double priceOfRate;
    private int minutes;
    ScannerWrapper scannerWrapper = new ScannerWrapper();

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public double getPriceOfRate() {
        return priceOfRate;
    }

    public void setPriceOfRate(double priceOfRate) {
        this.priceOfRate = priceOfRate;
    }

    public String getTypeOfRate() {
        return typeOfRate;
    }

    public void setTypeOfRate(String typeOfRate) {
        this.typeOfRate = typeOfRate;
    }

    public String getRate() {
        return rate;
    }

    public double getBalance() {
        return balance;
    }

    PhoneNumber pn = new PhoneNumber();

    public void selectRate() {
        int i = scannerWrapper.readInt();
        method(i);
    }

    public void aboutRates() {
        int n;
        int i = scannerWrapper.readInt();
        switch (i) {
            case 1: {
                String s = "rate:4G elementary\n" +
                        "priceOfRate:2.95 rub\n" +
                        "minutes:250\n" +
                        "internet:500 Mb\n";
                System.out.println(s);
                System.out.println("1.accept\n" + "2.back");
                n = scannerWrapper.readInt();
                switch (n) {
                    case 1: {
                        method(i);
                    }
                    case 2: {
                        System.out.println("1.4G elementary\n" + "2.4G mini\n" + "3.4G maxi\n" + "4.4G mega");
                        aboutRates();
                        break;
                    }
                }
                break;
            }
            case 2: {
                String s = "rate: 4G mini\n" +
                        "priceOfRate:5.95 rub\n" +
                        "minutes:500\n" +
                        "internet:1500 Mb\n";
                System.out.println(s);
                System.out.println("1.accept\n" + "2.back");
                n = scannerWrapper.readInt();
                switch (n) {
                    case 1: {
                        method(i);
                    }
                    case 2: {
                        System.out.println("1.4G elementary\n" + "2.4G mini\n" + "3.4G maxi\n" + "4.4G mega");
                        aboutRates();
                        break;
                    }
                }
                break;
            }
            case 3: {
                String s = "rate: 4G maxi\n" +
                        "priceOfRate:8.95 rub\n" +
                        "minutes:1000\n" +
                        "internet:3000 Mb\n";
                System.out.println(s);
                System.out.println("1.accept\n" + "2.back");
                n = scannerWrapper.readInt();
                switch (n) {
                    case 1: {
                        method(i);
                    }
                    case 2: {
                        System.out.println("1.4G elementary\n" + "2.4G mini\n" + "3.4G maxi\n" + "4.4G mega");
                        aboutRates();
                        break;
                    }
                }
                break;
            }
            case 4: {
                String s = "rate: 4G mega\n" +
                        "priceOfRate:13.45 rub\n" +
                        "minutes:2000\n" +
                        "internet:6000 Mb\n";
                System.out.println(s);
                System.out.println("1.accept\n" + "2.back");
                n = scannerWrapper.readInt();
                switch (n) {
                    case 1: {
                        method(i);
                    }
                    case 2: {
                        System.out.println("1.4G elementary\n" + "2.4G mini\n" + "3.4G maxi\n" + "4.4G mega");
                        aboutRates();
                        break;
                    }
                }
                break;
            }
        }
    }

    private void method(int i) {
        switch (i) {
            case 1: {
                rate = "4G elementary";
                phoneNumber = pn.makeNumber(phoneNumber);
                priceOfRate = 2.95;
                minutes = 250;
                internet = 500;
                balance = balance - priceOfRate;
                break;
            }
            case 2: {
                rate = "4G mini";
                phoneNumber = pn.makeNumber(phoneNumber);
                priceOfRate = 5.95;
                minutes = 500;
                internet = 1500;
                balance = balance - priceOfRate;
                break;
            }
            case 3: {
                rate = "4G maxi";
                phoneNumber = pn.makeNumber(phoneNumber);
                priceOfRate = 8.95;
                minutes = 1000;
                internet = 3000;
                balance = balance - priceOfRate;
                break;
            }
            case 4: {
                rate = "4G mega";
                phoneNumber = pn.makeNumber(phoneNumber);
                priceOfRate = 13.45;
                minutes = 2000;
                internet = 60000;
                balance = balance - priceOfRate;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Account: \n" +
                "Name:" + getName() + ", Surname:" + getSurname() + "\n" +
                "Rate:" + rate + ", InternetMemory:" + internet + " Mb" + "\n" +
                "PhoneNumber:" + phoneNumber + ", Balance:" + balance + " rub\n";

    }
}
