import java.io.Serializable;

public class CustomerAccountContainer implements Serializable {
    private int count = 0;
    private CustomerAccount[] caContainer = new CustomerAccount[10];
    private String write = "";

    public CustomerAccount[] getCaContainer() {
        return caContainer;
    }

    public int getCount() {
        return count;
    }

    public String getWrite() {
        return write;
    }

    public void add(CustomerAccount customerAccount) {

        if (count < this.caContainer.length) {
            this.caContainer[count++] = customerAccount;
            write = write + customerAccount + "\n";
        } else {
            CustomerAccount[] customerAccount1 = new CustomerAccount[count];
            for (int i = 0; i < customerAccount1.length; i++) {
                customerAccount1[i] = caContainer[i];
            }
            caContainer = new CustomerAccount[(int) (caContainer.length * 1.5)];
            for (int i = 0; i < customerAccount1.length; i++) {
                caContainer[i] = customerAccount1[i];
            }
            this.caContainer[count] = customerAccount;
            write = write + customerAccount + "\n";
        }
    }

    public void delete(int index) {
        int j = 0;
        CustomerAccount[] buffer = new CustomerAccount[caContainer.length];
        for (int i = 0; i < caContainer.length; i++) {
            if (i != index) {
                buffer[j] = caContainer[i];
                j++;
            }
        }
        caContainer = buffer;
        count--;
    }

    public void update(int i, CustomerAccount newCustomerAccount) {
        if (i > count) {
            throw new IllegalArgumentException();
        }
        caContainer[i] = newCustomerAccount;
    }

    public void aboutClient() {
        for (int i = 0; i < count; i++) {
            if (caContainer[i] != null){
                System.out.println(caContainer[i]);
            }
        }
    }
}
