package com.Impl;

import java.util.Scanner;

import org.hibernate.Session;


import com.model.Account;
import com.service.MethodService;
import com.user.Check;

public class MethodServiceImpl  implements MethodService{

	Session session = Check.getSessionFactory().openSession();
	
	@Override
	public void createAccount() {
		Account acc = new Account();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Account number:");
		acc.setAccno(sc.nextInt());
		System.out.println("Enter the Account Holder Name:");
		acc.setName(sc.next());		
		System.out.println("Enter the Account Holder Address:");
		acc.setAddr(sc.next());
		System.out.println("Enter the Account Mobile number:");
		acc.setMobno(sc.nextLong());
		System.out.println("Enter the Account Adhaar number:");
		acc.setAdharno(sc.nextLong());
		System.out.println("Enter the Account Holder Age:");
		acc.setAge(sc.nextInt());
		System.out.println("Enter the Account Holder MinBal:");
		acc.setMinbal(sc.nextInt());
		System.out.println("Enter the Account Holder Gender:");
		acc.setGender(sc.next());
		System.out.println("Enter the Password:");
		acc.setPass(sc.nextInt());
		session.save(acc);
		session.beginTransaction().commit();
		System.out.println("==================================================");
		System.out.println("  Data Submit Successfully !! ");
		System.out.println("==================================================");
		
	}

	@Override
	public void transationDetails() {
		Scanner sc1 = new Scanner(System.in);
		while(true) {
		System.out.println("Enter the Account Number :");
		int accno = sc1.nextInt();
		Account ac1 = session.get(Account.class, accno);
		System.out.println("Enter the Password: ");
		int pass = sc1.nextInt();
		try {
		if(accno==ac1.getAccno() && pass== ac1.getPass())
		{
		
				System.out.println("==================================================");
				System.out.println("                 Account details                  ");
				System.out.println("==================================================");
				System.out.println();
				System.out.println("Account Number              :"+ac1.getAccno());
				System.out.println("Account Name                :"+ac1.getName());
				System.out.println("Account Address             :"+ac1.getAddr());
				System.out.println("Account Mobile Number       :"+ac1.getMobno());
				System.out.println("Account Adhaar Number       :"+ac1.getAdharno());
				System.out.println("Account Holder Age          :"+ac1.getAge());				
				System.out.println("Account Holder MinBal       :"+ac1.getMinbal());
				System.out.println("Account Holder Gender       :"+ac1.getGender());
				System.out.println();
				System.out.println("==================================================");
				}
		break;
			}
		catch (NullPointerException e) {
			System.out.println("Enter the Correct Account Number And Password ??");
		}
		}
	}

	public void depositMoney() {
		Scanner sc3 = new Scanner(System.in);
		while(true) {
		System.out.println("Enter the Account Number :");
		int acno = sc3.nextInt();
		Account ac1 = session.get(Account.class, acno);
		System.out.println("Enter the Password: ");
		int pass = sc3.nextInt();
		try {
		if(acno==ac1.getAccno() && pass== ac1.getPass())
		{
			System.out.println("==================================================");
			System.out.println("                 Deposit details                  ");
			System.out.println("==================================================");
			int m_amt = ac1.getMinbal();
			System.out.println(m_amt);
			System.out.println("Enter the Amount Do You want Deposit");
			int amt = sc3.nextInt();
			int t_amt= m_amt+amt;
			ac1.setMinbal(t_amt);
			session.save(ac1);
			session.update(ac1);
			session.beginTransaction().commit();
			System.out.println("Balance Updates Successfully !!");
			System.out.println();
			System.out.println("==================================================");
			break;
		}
		}
		catch (NullPointerException e) {
			System.out.println("Enter the Correct Account Number And Password ??");
		}
		
		}

	}

	@Override
	public void transferMoney() {
		Scanner sc4 = new Scanner(System.in);
		while(true) {
		System.out.println("Enter the Account Number :");
		int acno = sc4.nextInt();
		Account ac2 = session.get(Account.class, acno);
		System.out.println("Enter the Password: ");
		int pass = sc4.nextInt();
		try {
		if(acno==ac2.getAccno( ) && pass == sc4.nextInt())
		{
			
			System.out.println("==================================================");
			System.out.println("                 Withdrawl details                  ");
			System.out.println("==================================================");
			int m_amt = ac2.getMinbal();
			System.out.println(m_amt);
			System.out.println("Enter the Amount Do You want Withdrawl");
			int amt = sc4.nextInt();
			int t_amt= m_amt-amt;
			ac2.setMinbal(t_amt);
			session.save(ac2);
			session.update(ac2);
			session.beginTransaction().commit();
			System.out.println("Balance Withdraw Successfully !!");
			System.out.println();
			System.out.println("==================================================");
			break;
			}
		}
		catch (NullPointerException e) {
			System.out.println("Enter the Correct Account Number And Password !!");
		}
		
		}
	}


	@Override
	public void ShowBalance() {
		Scanner sc5 = new Scanner(System.in);
		while(true) {
		System.out.println("Enter the Account Number :");
		int acno = sc5.nextInt();
		Account ac2 = session.get(Account.class, acno);
			System.out.println("Enter the Password: ");
			int pass = sc5.nextInt();
			try {
			if(acno == ac2.getAccno() &&  pass== ac2.getPass())
			{
				System.out.println("==================================================");
				System.out.println("                 Balance details                  ");
				System.out.println("==================================================");
				int m_amt = ac2.getMinbal();
				System.out.println("Remaining Balance :"+m_amt);
				System.out.println();
				System.out.println("==================================================");
				break;
			}
			}
			catch(NullPointerException e){
				System.out.println("Enter Correct Account Number And Password :");
			}
			
			}				
	}

}
