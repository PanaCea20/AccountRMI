import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountEntry extends UnicastRemoteObject implements AccountEntryInterface {
    private int amount;
    private String date;
    private String OtherAccount;

    public AccountEntry(int amount, String date, String otherAccount) throws RemoteException {
        this.amount = amount;
        this.date = date;
        this.OtherAccount = otherAccount;
    }


    public int getAmount() throws RemoteException {
        return amount;
    }


    public String getDate() throws RemoteException {
        return date;
    }


    public String getOtherAccount() throws RemoteException {
        return OtherAccount;
    }


    public void changeAmount(int newAmount) throws RemoteException {
        amount = newAmount;
    }
}
