package com.itenas.uas.rpl.application;

import java.util.Scanner;

import com.itenas.uas.rpl.function.ControllerAplication;

public class mainApplication {
	public static void main(String[] args) {
		ControllerAplication conApli = new ControllerAplication();
		char des = 'N';
		Scanner scan = new Scanner(System.in);
		
		while ((des == 'N') || (des == 'n')) {
			conApli.mainMenu();
			System.out.print("Apakah anda ingin keluar aplikasi?? : ");
			des = scan.next().charAt(0);
		}
		
		System.out.println("Keluar Aplikasi!!!!!");
	}
}
