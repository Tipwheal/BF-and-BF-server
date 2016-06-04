package service;

import java.rmi.RemoteException;

public class Execute implements ExecuteService {

	@Override
	public String execute(String code, String param) throws RemoteException {
		int codePtr = 0;
		int charPtr = 0;
		int paramPtr = 0;
		char[] chars = new char[100];
		boolean end = false;
		while (!end) {
			switch (code.substring(codePtr, codePtr + 1)) {
			case "+":
				chars[charPtr]++;
				break;
			case "-":
				chars[charPtr]--;
				break;
			case "<":
				charPtr--;
				break;
			case ">":
				charPtr++;
				break;
			case ",":
				chars[charPtr] = param.charAt(paramPtr);
				paramPtr++;
				break;
			case ".":
				System.out.print("jkjk");
			case "[":
			case "]":
			}
		}
		return null;
	}

}
