package ch3;

import java.util.*;

public class Customer{
    private List<Account> accounts = new ArrayList<>();

    public void add(Account account){
        accounts.add(account);
    }

    public Iterator<Account> getAccounts(){
        return accounts.iterator();
    }
}