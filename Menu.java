package Vista;

import java.util.Scanner;

import Controlador.Logic;

public class Menu {


	public Menu() {
		Logic log=new Logic(this);
	}

	public int menu(Scanner read) {		
		System.out.print("\n\tBienvenidos");
		System.out.print("\n1.- Selecionar archivos");
		System.out.print("\n2.- Buscar recursos");
		System.out.print("\n3.- Salir");
		System.out.print("\n Opcion: ");
		return read.nextInt();		
	}
	
	public String subMenu(int op) {
		return switch(op) {
		case 1->"\n1.- Listar Archivos almacenados";
		case 2->"\n2.- Modificar Archivos ";
		case 3->"\n3.- Buscar Patrones ";
		case 4->"\nQue archivo desea editar: ";
		case 5->"\nOpcion: ";
		case 6->"\n4.- Salir ";
		case 7->"\nQue archivo desea buscar: ";
		case 8->"\nSaliendo del programa";
		default->"\nOpción invalida";
		};
	}

}
