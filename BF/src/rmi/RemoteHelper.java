package rmi;

import java.rmi.Remote;

import service.IOService;
import service.UserService;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public IOService getIOService(){
		return (IOService)remote;
	}
	
	public UserService getUserService(){
		return (UserService)remote;
	}
	
	public static void main(String[] args) {
		new RemoteHelper().start();
	}
	
	public void start() {
		String[] strs = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		for(int j = 0;j<1000000000;j++) {
			StringBuilder builder = new StringBuilder();
		for(int i =0;i<40;i++) {
			builder.append(strs[new java.util.Random().nextInt(16)]);
		}
		System.out.println("magnet:?xt=urn:btih:"+builder.toString());
	}}
}
