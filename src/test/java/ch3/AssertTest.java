package ch3;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.rules.*;

public class AssertTest{
    private Account account;

    @Before
    public void createAccount(){
        account = new Account("口座名");
    }

    //残高が0以上か
    @Test
    public void hasPositiveBalance(){
        account.deposit(50);
        assertTrue(account.hasPositiveBalance());
    }

    //入金すると残高が増加
    @Test
    public void depositIncreaseBalance(){
        int initialBalance = account.getBalance();
        account.deposit(100);
        assertTrue(account.getBalance() > initialBalance);
        assertThat(account.getBalance(),equalTo(100));
    }

    //Hamcrestお試し
    @Test
    @Ignore
    public void compareArraysFailing(){
        assertThat(new String[]{"a","b","c"},equalTo(new String[]{"a","b"}));
        assertThat(new String[]{"a"},equalTo(new String[]{"a","ab"}));
    }
    @Test
    public void compareArraysPassing(){
        assertThat(new String[]{"a","b"}, equalTo(new String[]{"a","b"}));
    }

    //例外の検証法
    @Test(expected=InsufficientFundsException.class)
    public void throwsWhenWithdrawingTooMuch(){
        account.withdraw(10000);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Test
    public void exceptionRule(){
        thrown.expect(InsufficientFundsException.class);
        thrown.expectMessage("残高不足です。");

        account.withdraw(10000);
    }
}
