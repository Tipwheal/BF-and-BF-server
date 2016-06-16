package serviceImpl;

import java.rmi.RemoteException;

import service.ExecuteService;

public class ExecuteServiceImpl implements ExecuteService {
    private char[] nums = new char[400];
    private int nPtr = 0;
    private int cPtr = 0;
    private int pPtr = 0;
    private String code;
    private String param;
    private String result = "";

    public String execute(String code, String param) throws RemoteException {
        this.code = code;
        this.param = param;
        this.comply();
        return result;
    }

    public void comply() {
        while (cPtr < code.length()) {
            switch (code.charAt(cPtr)) {
                case '+':
                    nums[nPtr]++;
                    cPtr++;
                    break;
                case '-':
                    nums[nPtr]--;
                    cPtr++;
                    break;
                case '<':
                    nPtr--;
                    cPtr++;
                    break;
                case '>':
                    nPtr++;
                    cPtr++;
                    break;
                case '[':
                    cPtr += nums[nPtr] != 0 ? 1 : code.substring(cPtr).indexOf(']');
                    break;
                case ']':
                    cPtr += nums[nPtr] == 0 ? 1 : code.substring(0, cPtr).lastIndexOf('[');
                    break;
                case ',':
                    nums[nPtr] = param.charAt(pPtr);
                    pPtr++;
                    cPtr++;
                    break;
                case '.':
                    result += nums[nPtr];
                    cPtr++;
                    break;
            }
        }
    }
}
