import java.io.IOException;

public class Menu {
    private FileWorker fileWorker = new FileWorker();
    private boolean closeLoop = true;
    private int n1;
    private String menu = "1.add Client\n" +
            "2.upd Client\n" +
            "3.delete Client\n" +
            "4.print all Clients\n" +
            "5.save to file Client\n" +
            "6.load from file\n" +
            "0.exit";
    ScannerWrapper scannerWrapper = new ScannerWrapper();

    public void start() throws IOException, ClassNotFoundException {
        CustomerAccountContainer customerAccountContainer = new CustomerAccountContainer();
        while (closeLoop != false) {
            System.out.println(menu);
            n1 = scannerWrapper.readInt();
            switch (n1) {
                case 0: {
                    closeLoop = false;
                    break;
                }
                case 1: {
                    CustomerAccount customerAccount = new CustomerAccount();
                    addInformationAboutClient(customerAccount);
                    customerAccountContainer.add(customerAccount);
                    break;
                }
                case 2: {
                    CustomerAccount customerAccount = new CustomerAccount();
                    addInformationAboutClient(customerAccount);
                    System.out.println("Enter the customer number:");
                    customerAccountContainer.update(scannerWrapper.readInt() - 1, customerAccount);
                    break;
                }
                case 3: {
                    System.out.println("Enter the customer number:");
                    customerAccountContainer.delete(scannerWrapper.readInt() - 1);
                    break;
                }
                case 4: {
                    customerAccountContainer.aboutClient();
                    break;
                }
                case 5: {
                    fileWorker.write(customerAccountContainer);
                    break;
                }
                case 6: {
                    CustomerAccountContainer temp = fileWorker.read();
                    for (CustomerAccount customerAccount : temp.getCaContainer()) {
                        customerAccountContainer.add(customerAccount);
                    }
                    break;
                }
                default:
                    closeLoop = false;
            }
        }
    }

    private void addInformationAboutClient(CustomerAccount customerAccount) {
        System.out.println("Name:");
        customerAccount.setName(scannerWrapper.readLine());
        System.out.println("Surname: ");
        customerAccount.setSurname(scannerWrapper.readLine());
        System.out.println("Address: ");
        customerAccount.setAddress(scannerWrapper.readLine());
        System.out.println("1.Information about rates\n" + "2.Select rate");
        n1 = scannerWrapper.readInt();
        switch (n1) {
            case 1: {
                System.out.println("1.4G elementary\n" + "2.4G mini\n" + "3.4G maxi\n" + "4.4G mega");
                customerAccount.selectRate();
                break;
            }
            case 2: {
                System.out.println("1.4G elementary\n" + "2.4G mini\n" + "3.4G maxi\n" + "4.4G mega");
                customerAccount.selectRate();
                break;
            }
            default:
                break;
        }
    }
}
