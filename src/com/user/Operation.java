package com.user;

import java.util.Scanner;

import com.Impl.MethodServiceImpl;


public class Operation {

	public static void main(String [] args)
	{
		MethodServiceImpl op = new MethodServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("*=================================== *");
		System.out.println("*  Welcome To Bank ManageMent System *");
		System.out.println("*=================================== *");
		System.out.println("You want to continue press 1");
		System.out.println("For exit press 0");
		int x=sc.nextInt();
			while(true)
			{	
				if(x==1)
				{
					System.out.println("Select Choice");
					System.out.println("1: Select Create Account");
					System.out.println("2: Select TransationDetails");
					System.out.println("3: Select Deposit Money ");
					System.out.println("4: Select Withdrwal Money");
					System.out.println("5: Select View Balance");
					System.out.println("0: exit");
				}
			int a= sc.nextInt();
			switch(a)
			{
			case 1:
				op.createAccount();
				break;
			case 2:
				op.transationDetails();
				break;
			case 3:
				op.depositMoney();
				break;
			case 4:
				op.transferMoney();
				break;
			case 5:
				op.ShowBalance();
				break;
			case 0:
				System.out.println("* Thank You ! Visit Again Our Bank *");
				System.exit(x);
				break;
				
			default :
				System.out.println("Select Valid Type");
				break;
				
		
			}
		}
	}
}
