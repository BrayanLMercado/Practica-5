/*
Nombre: Lopez Mercado Brayan
Matrícula: 1280838
Materia: Programación Orientada a Objetos 
Práctica 5: Encapsulamiento, Cohesión y Acoplamiento
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
			System.out.println("¿Deseas Seguir Usando El Programa? (S/N)");
			OpcT=Entry.nextLine(); // Por un motivo que desconozco, sólo funciona con la doble captura
			OpcT=Entry.nextLine(); // No tengo palabras que puedan describir mi confusión o_O
			OpcT=OpcT.toUpperCase();
			if(!OpcT.equals("S")){
				System.out.println("Gracias, Tenga Un Buen Día");
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
