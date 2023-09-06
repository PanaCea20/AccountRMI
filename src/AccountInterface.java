import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

public interface AccountInterface extends Remote {
    AccountEntryInterface searchEntryByAmount(int amount) throws RemoteException;
    void addEntry(int amount, String date, String otherAccount) throws RemoteException;
    Set<AccountEntryInterface> getAllEntries() throws RemoteException;
    String getAccountName() throws RemoteException;
    int calculateTotalAmount() throws RemoteException;
}