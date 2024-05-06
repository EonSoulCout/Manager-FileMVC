package Controlador;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import LibreriaV2.Archivos;
import Modelo.ManagerFile;
import Vista.Menu;


public class Logic {

	ManagerFile f;
	Menu m;

	public Logic(Menu me) {
		m=me;
		f = new ManagerFile();
		//fi.OpenFile();
		loadMenu();
	}
	public void loadMenu() {
		Scanner read = new Scanner(System.in);
		int op = 0;
		while(op != 3) {
			op = m.menu(read);
			switch(op) {
			case 1:
				f.openFile();
				break;
			case 2:
				int num;
				do {
					System.out.print(m.subMenu(1));
					System.out.print(m.subMenu(2));
					System.out.print(m.subMenu(3));
					System.out.print(m.subMenu(6));
					System.out.print(m.subMenu(5));
					num=read.nextInt();

					if(num==1) {
						f.listFile();
					}else if(num==2){
						f.listFile();
						System.out.print(m.subMenu(4));
						int tipo=read.nextInt();
						f.editFile(tipo);
					}else if(num==3) {
						f.getInfo();
						break;
					}
				}while(num!=4);
				break;
			case 3:
				System.out.print(m.subMenu(8));	
				break;
			default:
				System.out.print(m.subMenu(0));			
			}	

		}
	}

}
