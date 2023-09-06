import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountEntryInterface extends Remote {
    int getAmount() throws RemoteException;
    String getDate() throws RemoteException;
    String getOtherAccount() throws RemoteException;
    void changeAmount(int newAmount) throws RemoteException;
}