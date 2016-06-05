package serviceImpl;

import java.rmi.RemoteException;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(new ExecuteServiceImpl().execute("++++++++++[>+++++++<-]>.", ""));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
