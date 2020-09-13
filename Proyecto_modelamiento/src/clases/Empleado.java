package clases;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private int cedula;
	private String nombre;
	private int nss;
	private String domicilio;
	private List<Vagon> lstVagon;
	private List<MaquinaTractora> lstMaquina;
	public Empleado() {
		// TODO Auto-generated constructor stub
		
	}
	public Empleado(int cedula, String nombre, int nss, String domicilio) {
		lstVagon=new ArrayList<Vagon>();
		lstMaquina=new ArrayList<MaquinaTractora>();
		this.nombre=nombre;
		this.nss=nss;
		this.domicilio=domicilio;
		this.cedula=cedula;
		
		
	}
	
	//Metodos
	
	/**
	 * Agrega vagones en lista. 
	 * @param oVagon
	 */
	public void agregarVagon(Vagon oVagon) {
		this.lstVagon.add(oVagon);
	}
	
	/**
	 * Agrega maquina tractora en lista.
	 * @param oMaquina
	 */
	public void agregarMaquina(MaquinaTractora oMaquina) {
		this.lstMaquina.add(oMaquina);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String vagon, maquina;
		if(this.lstVagon.size()==0) {
			vagon="No tiene vagones asignados";
		}else {
			vagon=String.valueOf(this.lstVagon);
		}
		
		if(this.lstMaquina.size()==0) {
			maquina="No tiene maquinas asignadas";
		}else {
			maquina=String.valueOf(this.lstMaquina);
		}
		
		System.out.println(maquina+" "+vagon);
		return this.nombre+"| "+this.nss+"| "+this.domicilio+"|Vagones: {"+vagon+"}|"+"|Maquinas: {"+maquina+"}|";
	}
	
	
	
	public String getNombre() {
		return nombre+"hola";
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNss() {
		return nss;
	}
	public void setNss(int nss) {
		this.nss = nss;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public List<Vagon> getLstVagon() {
		return lstVagon;
	}
	public void setLstVagon(List<Vagon> lstVagon) {
		this.lstVagon = lstVagon;
	}
	public List<MaquinaTractora> getLstMaquina() {
		return lstMaquina;
	}
	public void setLstMaquina(List<MaquinaTractora> lstMaquina) {
		this.lstMaquina = lstMaquina;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

}
