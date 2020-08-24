package principal;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

import clases.*;

public class Main {
	static Console consola=System.console();
	static Scanner leerN = new Scanner(System.in);
	static Scanner leerC = new Scanner(System.in);
	static CompañiaFerroviaria oCompañia=new CompañiaFerroviaria(1234);//Se instancia la compañia
	static Administrador oAdmin;//Variable administrador
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		registroAdmin();
		
		login();

	}
	
	/**
	 * Menu de bienvenida con las opciones del sistema
	 */
	static void bienvenido() {
		int opc=0;
		System.out.println("\n\t\t**Bienvenido <<"+oAdmin.getNombre()+">> al Sistema de Gestión de Trenes**\n");
		System.out.println("1.- Agregar tren");
		System.out.println("2.- Agregar empleado");
		System.out.println("3.- Asignar empleado (Vagon o Maquina)");
		System.out.println("4.- Informe de empleados");
		System.out.println("5.- Registrar administrador");
		System.out.println("6.- Cerrar sesion");
		
		System.out.print("Digite opcion: ");
		
		opc=leerN.nextInt();
		
		switch (opc) {
		case 1: 
			crearTren();
			break;
		case 2:
			crearEmpleado();
			break;
		case 3:
			asignarEmpleado();
			break;
		case 4:
			imforme();
			break;
		case 5:
			registroAdmin();
			bienvenido();
			break;
		case 6:
			login();
			break;
		default:
			System.out.println("Opcion incorrecta");
			bienvenido();
			break;
		}
			
		
	}
	
	/**
	 * Metodo que instancia y guarda empleado de la compañia
	 */
	static void crearEmpleado() {
		Scanner leerCaracter=new Scanner(System.in);
		String nombre, domicilio;
		int cedula, nss, telefono;
		char opc;
		Empleado oEmpleado;// variable tipo Empleado
		
		System.out.print("\nNombre: ");
		nombre=leerC.nextLine();
		System.out.print("Cedula: ");
		cedula=leerN.nextInt();
		System.out.print("Domicilio: ");
		domicilio=leerC.nextLine();
		System.out.print("Numero Seguridad Social: ");
		nss=leerN.nextInt();
		System.out.print("\n¿Es jefe? (s/n): ");//Pregunta si es jefe
		opc=leerCaracter.next().charAt(0);
		
		/**
		 * Si es jefe se instancia a Empleado como Jefe
		 */
		if(opc=='s' || opc=='S') {
			System.out.print("Telefono: ");
			telefono=leerN.nextInt();
			oEmpleado=new Jefe(cedula,nombre,nss,domicilio,telefono);
			
		}
		else {
			/**
			 * Si es operario se instancia a Empleado como Operario
			 */
			System.out.print("¿Es operario? (s/n): ");
			opc=leerCaracter.next().charAt(0);
			if(opc=='s' || opc=='S') {
				/*Operario*/ oEmpleado=new Operario(cedula, nombre, nss, domicilio);
			}
			else {
				/**
				 * Se instancia a Empleado como Empleado
				 */
				oEmpleado= new Empleado(cedula, nombre, nss, domicilio);
			}
		}
		
		/**
		 * Administrador guarda a empleado creado en lista de empleados de
		 * la compañia
		 */
		oAdmin.agregarEmpleado(oEmpleado.getCedula(), oEmpleado);
		System.out.println("\n\t**Empleado guardado**");
		
		bienvenido();//Regresa al menu de bienvenido
	}
	
	/**
	 * Metodo que instancia y guarda tren de la compañia
	 */
	static void crearTren() {
		int opc, cedula, capacidad, potencia;
		Jefe oJefe;//Variable jefe
		System.out.println("Capacidad del vagon de tren (KG): ");
		capacidad=leerN.nextInt();
		System.out.println("Potencia de maquina tractora (W): ");
		potencia=leerN.nextInt();
		Tren oTren=new Tren(oCompañia.getLstTren().size()+1, new Vagon(capacidad), new MaquinaTractora(potencia));
		do {
			System.out.print("Digite cedula de jefe a asignar: ");
			cedula=leerN.nextInt();
			oJefe=oAdmin.buscarJefe(cedula);//Se busca en la lista de empleados a un jefe mediante cedula
			if(oJefe==null) {
				System.out.println("**Jefe no encontrado**");
			}else {
				break;
			}
		}while(oJefe==null);
		System.out.println("Jefe/a "+"a asignar: "+oJefe.getNombre());
		oTren.setoJefe(oJefe);//Se asigna jefe a tren
		System.out.println("\t**Se ha agregado un nuevo tren con codigo #"+oTren.getCodigo_identificacion()+"**");
		oCompañia.agregarTren(oTren);
		do {
			System.out.println("**Menu para agregar vagones al tren**");
			System.out.println("\n1.- Agregar vagon");
			System.out.println("2.- salir");
			System.out.print("Digite opcion: ");
			opc=leerN.nextInt();
			if(opc==1){
				System.out.print("\nCapacidad de vagon: ");
				opc=leerN.nextInt();
				System.out.println("\t**Vagon agregado**");
				oTren.agregarVagon(new Vagon(opc));//Se agrega vagon creado a tren
				
			}
			else {
				opc=0;
			}
		}while(opc!=0);	
		bienvenido();// Vuelve a menu de benvenida
		
	}
	
	
	/**
	 * Metodo que asigna Vagon o maquina tractora a empleado
	 */
	static void asignarEmpleado() {
		int  opc=0, cedula, num;
		Empleado oEmpleado;// Variable tipo Empleado
		
		oAdmin.listarTren();//Se enlista los trenes disponibles de la compañia
		System.out.print("\n\nElige un tren: ");
		opc=leerN.nextInt();
		Tren oTren=oCompañia.getLstTren().get(opc-1);//Se elige tren mediante su codigo
		
		do {
			System.out.print("Cedula de empleado a asignar: ");
			cedula=leerN.nextInt();
			/**
			 * Se busca empleado de la lista de empleados mediante su cedula
			 */
			oEmpleado=oAdmin.buscarEmpleado(cedula);
			if(oEmpleado==null) {
				System.out.println("**Empleado no encontrado**");
			}else {
				break;
			}
		}while(oEmpleado==null);
		System.out.println("**Empleado a asignar: "+oEmpleado.getNombre()+" con cargo de "+cargoEmpleado(oEmpleado)+"**");
		System.out.println("\n1.- Vagon");
		/**
		 * Si empleado es operario le permite asignar maquina tractora
		 */
		if(Operario.isOperario(oEmpleado)) {
			System.out.println("2.- Maquina");
		}
		opc=leerN.nextInt();
		
		if(opc==1) {
			oTren.listarVagon();//se enlistan vagones del tren
			System.out.print("Elegir vagon: ");
			num=leerN.nextInt();
			/**
			 * Se asigna empleado a vagon elegido
			 */
			oTren.getLstVagon().get(num-1).agregarEmpleado(oEmpleado);
			System.out.println("\n**Empleado asignado correctamente**\n");
		}else {
			/**
			 * Se comprueba que la maquina tractora este 
			 * disponible (sin operario asignado)
			 */
			if(oTren.getoMaquina().isDisponible()==true) {
				/**
				 * Asigna operario a maquina tractora
				 */
				oTren.getoMaquina().setoOperario((Operario) oEmpleado);
				System.out.println("\n**Empleado asignado correctamente**\n");
			}else {
				System.out.println("\n**La maquina tractora no esta disponible**\n");
			}
		}
		
		bienvenido();//Se regresa al menu de bienvenida
	}
	
	/**
	 * Metodo que enlista empleados de la empresa
	 */
	static void imforme() {
		oAdmin.listarEmpleado();
		
		bienvenido();
	}
	
	
	/**
	 * Metodo que registra a nuevo administrador
	 */
	static void registroAdmin() {
		System.out.println("\t\t**Sistema de Gestion de Trenes (Registro)**\n\n");
		String nombre, domicilio, usuario, contraseña;
		int cedula, nss, telefono;
		char opc;
		Empleado oEmpleado;//Variable empleado
		
		System.out.print("\nNombre: ");
		nombre=leerC.nextLine();
		System.out.print("Cedula: ");
		cedula=leerN.nextInt();
		System.out.print("Domicilio: ");
		domicilio=leerC.nextLine();
		System.out.print("Numero Seguridad Social: ");
		nss=leerN.nextInt();
		System.out.print("\n\nNombre de usuario: ");
		usuario=leerC.nextLine();
		
		if(consola!=null) {
			contraseña=contraseñaConsola();
		}else {
			contraseña=confirmarContraseña();//Se confirma contraseña
		}
		
		
		//Se instancia Empleado como Administrador
		oEmpleado=new Administrador(cedula, nombre, nss, domicilio, usuario, contraseña,oCompañia);
		//Se guarda administrador a lista de empleados de compañia
		oCompañia.getLstEmpleado().put(oEmpleado.getCedula(), oEmpleado);
		//Se guarda administrador a lista de administradores de compañia
		oCompañia.getLstAdmin().put((usuario+contraseña), (Administrador) oEmpleado);
		
		System.out.println("\n**Registro completado con exito**\n");
		
		
		
	}
	
	/**
	 * Metodo que confirma contraseña de registro de administrador
	 * @return
	 */
	static String confirmarContraseña() {
		String contraseña, contraseña2;
		do {
			System.out.print("Contraseña: ");
			contraseña=leerC.nextLine();
			System.out.print("Confirmar contraseña: ");
			contraseña2=leerC.nextLine();
			
			if(contraseña.equals(contraseña2)) {
				break;
			}else {
				System.out.println("**Contraseña no coincide**");
			}
				
		}while(contraseña!=contraseña2);
		return contraseña;
	}
	
	/**
	 * Metodo que presinta el inicio de sesion de la compañia
	 */
	static void login() {
		String usuario, contraseña;
		int cont=0;
		while(cont<3) {
			System.out.println("\t\t**Inicio de sesion**\n");
			System.out.print("Usuario: ");
			usuario=leerC.nextLine();
			if(consola!=null) {
				contraseña=pedirContraseña();
			}else {
				System.out.print("Contraseña: ");
				contraseña=leerC.nextLine();
			}
			
			//Se busca administrador en lista de compañia
			oAdmin=oCompañia.buscarAdmin(usuario, contraseña);
			if(oAdmin==null) {
				System.out.println("**Contraseña incorrecta, intento "+(cont+1)+" de 3");
				cont++;
			}else {
				break;
			}
			
		}
		if(cont<3) {
			bienvenido();
		}else {
			System.exit(0);
		}
		
	}
	
	/**
	 * Metodo que devuelve el cargo de empleado (Jefe, Operario o Empleado)
	 * @param oEmpleado
	 * @return
	 */
	static String cargoEmpleado(Empleado oEmpleado){
		if(Jefe.isJefe(oEmpleado)) {
			return "Jefe";
		}else {
			if(Operario.isOperario(oEmpleado)) {
				return "Operario";
			}else {
				return "Empleado";
			}
		}
	}
	
	
	static String contraseñaConsola() {
		
		
		String contraseña, contraseña2;
		do {
			char[]pwd=consola.readPassword("Contraseña: ");
			char[]pwd2=consola.readPassword("Confirmar contraseña: ");
			
			contraseña=String.valueOf(pwd);
			contraseña2=String.valueOf(pwd2);
			if(contraseña.equals(contraseña2)) {
				break;
			}else {
				System.out.println("**Contraseña no coincide**");
			}
				
		}while(contraseña!=contraseña2);
		return contraseña;
	}
	
	static String pedirContraseña() {
		char[]pwd=consola.readPassword("Contraseña: ");
		return String.valueOf(pwd);
	}
	
	

}
