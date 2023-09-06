import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.util.Set;

public class Client{
    public static void main(String[] args) throws Exception{
        if (args.length != 1)
            throw new IllegalArgumentException("Syntax: Client <localhost>");
        try {
            //Registry registry = LocateRegistry.getRegistry("localhost");
            //AccountInterface account = (AccountInterface) Naming.lookup("rmi://" + args[0] + "/Nizar");
            //AccountInterface account0 = (AccountInterface) Naming.lookup("rmi://" + args[0] + "/Josh");
            AccountInterface account1 = (AccountInterface) Naming.lookup("Nizar");
            AccountInterface account2 = (AccountInterface) Naming.lookup("Josh");

            //Perform operations on the account objects
            AccountEntryInterface entry1 = account1.searchEntryByAmount(600);
            if (entry1 != null){
                System.out.println("Found entry with amount 600: " + entry1.getDate() + " " + entry1.getOtherAccount());
            }

            AccountEntryInterface entry2 = account1.searchEntryByAmount(600);
            if (entry2 != null){
                entry2.changeAmount(750);
                System.out.println("Updated amount= " + entry2.getAmount());
            }

            account1.addEntry(600, "30/05/2023", "Ulrich");
            account1.addEntry(1400, "25/05/2023", "Josh");
            account2.addEntry(2300, "24/04/2023", "Armin");
            account2.addEntry(250, "13/05/2023", "Mathias");

            Set<AccountEntryInterface> entries1 = account1.getAllEntries();
            for(AccountEntryInterface entry : entries1) {
                System.out.println("Entry: Amount= " + entry.getAmount() + ", Date= " + entry.getDate() + ", OtherAccount= " + entry.getOtherAccount());
            }

            String accountName1 = account1.getAccountName();
            System.out.println("Account name: " + accountName1);

            int totalAmount1 = account1.calculateTotalAmount();
            System.out.println("Total amount: " + totalAmount1);
        } catch (Exception e) {
            System.out.println("DataClient: " + e.getMessage());
            e.printStackTrace();
        }
    }

}