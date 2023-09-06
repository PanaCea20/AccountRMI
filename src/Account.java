import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;
import java.util.HashSet;

public class Account extends UnicastRemoteObject implements AccountInterface {
    private String name;
    private Set<AccountEntryInterface> entries;

    public Account() throws RemoteException{}

    public Account(String name) throws RemoteException {
        this.name = name;
        this.entries = new HashSet<>();
    }


    public AccountEntryInterface searchEntryByAmount(int amount) throws RemoteException {
        for (AccountEntryInterface entry : entries) {
            if (entry.getAmount() == amount) {
                return entry;
            }
        }
        return null;
    }


    public void addEntry(int amount, String date, String otherAccount) throws RemoteException {
        AccountEntryInterface entry = new AccountEntry(amount, date, otherAccount);
        entries.add(entry);
    }


    public Set<AccountEntryInterface> getAllEntries() throws RemoteException {
        return entries;
    }


    public String getAccountName() throws RemoteException {
        return name;
    }


    public int calculateTotalAmount() throws RemoteException {
        int totalAmount = 0;
        for (AccountEntryInterface entry : entries) {
            totalAmount += entry.getAmount();
        }
        return totalAmount;
    }

    public static void main (String[] args) throws Exception{
        try{
            AccountInterface account1 = new Account("Nizar");
            AccountInterface account2 = new Account("Josh");

            Naming.rebind("Nizar", account1);
            Naming.rebind("Josh", account2);

            System.out.println("Server started and objects bound in the registry.");

        } catch (Exception e) {
            System.out.println("DataServer: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
