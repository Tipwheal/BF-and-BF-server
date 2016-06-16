package service;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2016/6/16.
 */
public interface ExecuteService {
    public String execute(String code, String param) throws RemoteException;
}
