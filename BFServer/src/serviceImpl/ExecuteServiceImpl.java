//请不要修改本文件名
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

	/**
	 * 请实现该方法
	 */
	@Override
	public String execute(String code, String param) throws RemoteException {
		this.code = code;
		this.param = param;
		this.comply();
		return result;
	}

	public void comply() {
		if (cPtr >= code.length())
			return;
		switch (code.charAt(cPtr)) {
		case '+':
			this.add();
			break;
		case '-':
			this.sub();
			break;
		case '<':
			this.left();
			break;
		case '>':
			this.right();
			break;
		case '[':
			this.loopIn();
			break;
		case ']':
			this.loopOut();
			break;
		case ',':
			this.input();
			break;
		case '.':
			this.output();
			break;
		}
	}

	public void add() {
		nums[nPtr]++;
		cPtr++;
		this.comply();
	}

	public void sub() {
		nums[nPtr]--;
		cPtr++;
		this.comply();
	}

	public void left() {
		nPtr--;
		cPtr++;
		this.comply();
	}

	public void right() {
		nPtr++;
		cPtr++;
		this.comply();
	}

	public void loopIn() {
		if (nums[nPtr] != 0) {
			cPtr++;
		} else {
			cPtr += code.substring(cPtr).indexOf(']');
		}
		this.comply();
	}

	public void loopOut() {
		if (nums[nPtr] == 0) {
			cPtr++;
		} else {
			cPtr = code.substring(0, cPtr).lastIndexOf('[');
		}
		this.comply();
	}

	public void input() {
		nums[nPtr] = param.charAt(pPtr);
		pPtr++;
		cPtr++;
		this.comply();
	}

	public void output() {
		result += nums[nPtr];
		cPtr++;
		this.comply();
	}

}
