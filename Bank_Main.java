/*
Nombre: Lopez Mercado Brayan
Matr�cula: 1280838
Materia: Programaci�n Orientada a Objetos 
Pr�ctica 5: Encapsulamiento, Cohesi�n y Acoplamiento
*/

import java.util.*;
public class Bank_Main {

	public static void main(String[] args) {
		Scanner Entry = new Scanner(System.in);
		int opc;
		String OpcT;
		do
		{
			do{
				Menu();
				opc=Entry.nextInt();	
			}while(opc<1 || opc>3);
			Cuenta cuenta1= new Cuenta(opc);
			System.out.println("�Deseas Seguir Usando El Programa? (S/N)");
			OpcT=Entry.nextLine(); // Por un motivo que desconozco, s�lo funciona con la doble captura
			OpcT=Entry.nextLine(); // No tengo palabras que puedan describir mi confusi�n o_O
			OpcT=OpcT.toUpperCase();
			if(!OpcT.equals("S")){
				System.out.println("Gracias, Tenga Un Buen D�a");
			}
		}while(OpcT.equals("S"));

	}
	
	public static void Menu(){
		System.out.println("Menu");
		System.out.println("1- Abrir Cuenta");
		System.out.println("2- Acceder A Cuenta Existente");
		System.out.println("3- Salir");
	}

}
