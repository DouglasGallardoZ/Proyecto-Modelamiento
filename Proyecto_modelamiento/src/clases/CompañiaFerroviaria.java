package clases;

import java.util.List;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class CompañiaFerroviaria {
	
	
	private int codigo_compañia;
	private List<Tren> lstTren;
	//private List<Empleado>lstEmpleado;	
	private HashMap<Integer,Empleado> lstEmpleado;
	private HashMap<String, Administrador> lstAdmin;
	
	
	/**
	 * //Constructor que instancia la compañia con un jefe, un tren 
	 * y un operario.
	 * @param codigo
	 */
	public CompañiaFerroviaria(int codigo) {
		lstTren = new ArrayList<Tren>();
		//lstEmpleado=new ArrayList<Empleado>();
		lstEmpleado=new HashMap<Integer,Empleado>();
		setLstAdmin(new HashMap<String,Administrador>());
		
		
		this.codigo_compañia = codigo;
		Empleado oJefe=new Jefe(111222333, "Arlette", 54321, "Guayaquil", 604532);
		Tren oTren=new Tren(1,new Vagon(100), new MaquinaTractora(500));
		oTren.setoJefe((Jefe)oJefe);
		//this.lstEmpleado.add(oJefe);
		this.lstEmpleado.put(oJefe.getCedula(), oJefe);
		oTren.getLstVagon().get(0).agregarEmpleado(oJefe);
		Empleado oOperario=new Operario(123456789, "Alex", 98765, "Guayaquil");
		this.lstEmpleado.put(oOperario.getCedula(), oOperario);
		oTren.getoMaquina().setoOperario((Operario)oOperario);
		agregarTren(oTren);
		
		
		
		
	}
	//Metodos
	
	/**
	 * Agrega tren en la lista de trenes de compañia
	 * @param oTren
	 */
	public void agregarTren(Tren oTren) {
		this.lstTren.add(oTren);
	}
	
	/**
	 * Busca un administrador en la lista de administradores de la compañia
	 * @param usuario
	 * @param contraseña
	 * @return
	 */
	public Administrador buscarAdmin(String usuario, String contraseña) {
		String clave=usuario+contraseña;
		Administrador oAdmin=this.lstAdmin.get(clave);
		if(oAdmin!=null) {
			return oAdmin;
		}else {
			return null;
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Compañía Ferroviaria\n"+this.codigo_compañia;
	}
	
	//Getters y setters
	public int getCodigo_compañia() {
		return codigo_compañia;
	}

	

	public void setCodigo_compañia(int codigo_compañia) {
		this.codigo_compañia = codigo_compañia;
	}

	public List<Tren> getLstTren() {
		return lstTren;
	}

	public void setLstTren(List<Tren> lstTren) {
		this.lstTren = lstTren;
	}

	public HashMap<Integer, Empleado> getLstEmpleado() {
		return lstEmpleado;
	}

	public void setLstEmpleado(HashMap<Integer, Empleado> lstEmpleado) {
		this.lstEmpleado = lstEmpleado;
	}


	public HashMap<String, Administrador> getLstAdmin() {
		return lstAdmin;
	}


	public void setLstAdmin(HashMap<String, Administrador> lstAdmin) {
		this.lstAdmin = lstAdmin;
	}

	
	/*public List<Empleado> getLstEmpleado() {
		return lstEmpleado;
	}

	public void setLstEmpleado(List<Empleado> lstEmpleado) {
		this.lstEmpleado = lstEmpleado;
	}*/
	
	
	
	
	

}
