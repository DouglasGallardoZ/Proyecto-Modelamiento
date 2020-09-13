package clases;

import java.util.ArrayList;
import java.util.Collection;

public class Administrador extends Empleado {
	
	private String usuario;
	private String contraseña;
	private CompañiaFerroviaria oCompañia;
	private int edad

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(int cedula, String nombre, int nss, String domicilio, String usuario, String contraseña, CompañiaFerroviaria oCompañia) {
		super(cedula, nombre, nss, domicilio);
		// TODO Auto-generated constructor stub
		this.setContraseña(contraseña);
		this.setUsuario(usuario);
		this.setoCompañia(oCompañia);
	}

	/**
	 * Enlista los trenes disponibles de la compañia
	 */
	public void listarTren() {
		
		for(int i=0;i<this.oCompañia.getLstTren().size();i++) {
			System.out.println(oCompañia.getLstTren().get(i));
		}
	}
	


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"Administrativo";
	}
	

	/**
	 * Enlista los empleados de la empresa sea jefe,operario o administrador
	 */
	public void listarEmpleado() {
		//System.out.println(this.lstEmpleado);
		for (Object value : oCompañia.getLstEmpleado().values()) {  }
		Collection<Empleado> values = oCompañia.getLstEmpleado().values();
		ArrayList<Empleado> listaNueva = new ArrayList<Empleado>(values);
		
		for(int i=0;i<listaNueva.size();i++) {
			System.out.println((i+1)+".-  "+listaNueva.get(i));
		}
	}
	
	/**
	 * Busca un jefe de la lista de empleados
	 * @param cedula
	 * @return
	 */
	public Jefe buscarJefe(int cedula) {
		Empleado oJefe = oCompañia.getLstEmpleado().get(cedula);
		if(Jefe.isJefe(oJefe)) {
			return (Jefe)oJefe;
		}else {
			return null;
		}
	}
	
	/**
	 * Busca un empleado que no es jefe ni operario de la lista de empleados
	 * @param cedula
	 * @return
	 */
	public Empleado buscarEmpleado(int cedula) {
		Empleado oEmpleado = oCompañia.getLstEmpleado().get(cedula);
		if(oEmpleado!=null) {
			return oEmpleado;
		}else {
			return null;
		}
	}
	
	/**
	 * Busca un operario de la lista de empleados
	 * @param cedula
	 * @return
	 */
	public Operario buscarOperario(int cedula) {
		Empleado oOperario = oCompañia.getLstEmpleado().get(cedula);
		if(Operario.isOperario(oOperario)) {
			return (Operario)oOperario;
		}else {
			return null;
		}
	}
	
	/**
	 * Agrega a un administrador registrado a la lista de administradores
	 * de la empresa
	 * @param usuario
	 * @param contraseña
	 * @param oAdmin
	 */
	public void agregarAdmin(String usuario,String contraseña , Administrador oAdmin ) {
		String clave=usuario+contraseña;
		oCompañia.getLstAdmin().put(clave, oAdmin);
	}
	
	
	
	/**
	 * Agrega a un empleado registrado en la lista de empleados
	 * @param cedula
	 * @param oEmpleado
	 */
	public void agregarEmpleado(int cedula, Empleado oEmpleado) {
		//this.lstEmpleado.add(oEmpleado);
		oCompañia.getLstEmpleado().put(cedula, oEmpleado);
	}
	
	
	
	
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public CompañiaFerroviaria getoCompañia() {
		return oCompañia;
	}

	public void setoCompañia(CompañiaFerroviaria oCompañia) {
		this.oCompañia = oCompañia;
	}

}
