import java.io.*;

public class FileWorker {
    public CustomerAccountContainer read() {
        try {
            FileInputStream fis = new FileInputStream("aboutClient.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            CustomerAccountContainer customerAccounts = (CustomerAccountContainer) ois.readObject();
            fis.close();
            ois.close();
            return customerAccounts;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error Input! " + e.getMessage());
            System.out.println(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
            System.out.println(3);
        }
        return new CustomerAccountContainer();
    }

    public void write(CustomerAccountContainer customerAccounts) {
        try {
            FileOutputStream fos = new FileOutputStream("aboutClient.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customerAccounts);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Output!");
            System.out.println(2);
        }
    }
}