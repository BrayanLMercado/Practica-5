/*
Nombre: Lopez Mercado Brayan
Matrícula: 1280838
Materia: Programación Orientada a Objetos 
Práctica 5: Encapsulamiento, Cohesión y Acoplamiento
*/

import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Cuenta {
	private double Saldo;
	private String Pin;
	private String Titular;
	Scanner Entrada= new Scanner(System.in);
	
	public Cuenta(int opc){
		switch(opc){
			case 1:
				NewUserSave();
				break;
			case 2:
				operaciones(UserSearch(),UserSaldo());
				break;
			
			case 3:
				System.out.println("Gracias, Tenga Buen día");
				break;
		}
		
	}
	
	// Getters
	private String getTitular(){
		System.out.println("Nombre del Titular: ");
		Titular=Entrada.nextLine();
		return Titular;
	}
	
	private String getPin(){
		do{
			System.out.println("Pin del usuario (6 Dígitos): ");
			Pin=Entrada.nextLine();	
		}while(Pin.length()<6 || Pin.length()>6);
		return Pin;
	}
	
	private double getSaldo(){
		System.out.println("Saldo: ");
		Saldo=Entrada.nextDouble();
		return Saldo;
	}

	// Métodos
	private void NewUserSave(){
            try {
                File file = new File("Historial_De_Movimientos_Bancarios.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Nombre del Titular: " + getTitular() + '\n');
                bw.write("Pin Del Usuario: " + getPin() + '\n');
                bw.write(""+getSaldo() + '\n');
                bw.newLine();
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }
	
	private boolean UserSearch(){
		final String Pin=getPin();
		boolean flag =false;
		try {
			Scanner scan = new Scanner(new File("Historial_De_Movimientos_Bancarios.txt"));
	        while(scan.hasNext()){
	            String line = scan.nextLine().toString();
	            if(line.contains(Pin)){
	                flag=true;
	            } 
	        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return flag;
		}
	
	private void operaciones(boolean flag,Double Saldo){
		double saldoEnt,SaldoR;
		if (flag==true){
			switch(menuOP()){
				case 1:
					System.out.println("Seleccione La Cantidad a Retirar");
					saldoEnt=Entrada.nextDouble();
					SaldoR=Saldo-saldoEnt;
					if (SaldoR<0){
							System.out.println("Fondos Insuficientes");
							System.out.println("Saldo Faltante: " + -1*SaldoR );
							System.out.println("Saldo Disponible Para Retiro: " + Saldo );
							break;
					}
					else{
						System.out.println("Retiro Realizado Con Éxito");
						ReWritter(Titular,Pin, SaldoR);
						System.out.println("Saldo Actual: " + SaldoR);
					}
					break;
				case 2:
					System.out.println("Seleccione La Cantidad a Depositar");
					saldoEnt=Entrada.nextDouble();
					SaldoR=Saldo+saldoEnt;
					System.out.println("Deposito Realizado Con Éxito");
					ReWritter(Titular,Pin, SaldoR);
					System.out.println("Saldo Actual: " + SaldoR);
					break;	
				case 3:
					System.out.println("Saldo Total: " + Saldo);
					break;
			}
		}
		else System.out.println("No Existe Un Usuario Con El Pin Ingresado");
	}
	
	public int menuOP(){
		int opc;
		do{
			System.out.println("");
			System.out.println("Menu de Operaciones Bancarias");
			System.out.println("1- Retiro");
			System.out.println("2- Deposito");
			System.out.println("3- Consulta De Saldo");
			opc=Entrada.nextInt();
		}while(opc<1 || opc>3);
		return opc;
	}

	private double UserSaldo(){
		String Pin=PinConfirm();
		try {
			Scanner scan = new Scanner(new File("Historial_De_Movimientos_Bancarios.txt"));
	        while(scan.hasNext()){
	            String line = scan.nextLine().toString();
	            if(line.contains(Pin)){
	                Saldo=Double.parseDouble(scan.nextLine());
	            } 
	        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return Saldo;
		}

	private void ReWritter(String Titular,String Pin,Double Saldo){
		try {
            File file = new File("Historial_De_Movimientos_Bancarios.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Nombre del Titular: " + Titular + '\n');
            bw.write("Pin Del Usuario: " + Pin + '\n');
            bw.write(""+ Saldo + '\n');
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private String PinConfirm(){
		do{
			System.out.println("Confirmación de Pin: ");
			Pin=Entrada.nextLine();	
		}while(Pin.length()<6 || Pin.length()>6);
		return Pin;
	}
}
