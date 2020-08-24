package clases;

import java.util.ArrayList;
import java.util.List;

public class Tren {
	private int codigo_identificacion;
	private Jefe oJefe;
	private MaquinaTractora oMaquina;
	private List<Vagon> lstVagon;
	private boolean disponible=true;
	
	public Tren() {
		// TODO Auto-generated constructor stub
	}
	
	public Tren(int codigo, Vagon oVagon, MaquinaTractora oMaquina) {
		lstVagon=new ArrayList<Vagon>();
		this.codigo_identificacion=codigo;
		this.oMaquina=oMaquina;
		this.lstVagon.add(oVagon);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "|Codigo: "+this.codigo_identificacion+"| #Vagones: "+this.lstVagon.size()+"| Jefe designado: "+this.oJefe.getNombre();
	}
	
	/**
	 * Agrega un vagon en lista de vagones del tren
	 * @param oVagon
	 */
	public void agregarVagon(Vagon oVagon) {
		this.lstVagon.add(oVagon);
	}
	
	/**
	 * Retorna la disponibilidad del tren
	 * @return
	 */
	public boolean isDisponible() {
		return this.disponible;
	}
	
	/**
	 * Enlista los vagones asociados al tren
	 */
	public void listarVagon() {
		System.out.println("|Codigo  |Capacidad|");
		for(int i=0;i<this.lstVagon.size();i++) {
			System.out.println("|"+(i+1)+"  |"+"|"+this.lstVagon.get(i)+"|");
		}
	}
	
	

	// Metodos getters - setters
	
	
	public int getCodigo_identificacion() {
		return codigo_identificacion;
	}
	public MaquinaTractora getoMaquina() {
		return oMaquina;
	}

	public void setoMaquina(MaquinaTractora oMaquina) {
		this.oMaquina = oMaquina;
	}

	public List<Vagon> getLstVagon() {
		return lstVagon;
	}

	public void setLstVagon(List<Vagon> lstVagon) {
		this.lstVagon = lstVagon;
	}

	public void setCodigo_identificacion(int codigo_identificacion) {
		this.codigo_identificacion = codigo_identificacion;
	}
	public Jefe getoJefe() {
		return oJefe;
	}
	public void setoJefe(Jefe oJefe) {
		this.oJefe = oJefe;
		this.disponible=false;
	}
	

}
