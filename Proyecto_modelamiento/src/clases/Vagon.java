package clases;

import java.util.ArrayList;
import java.util.List;

public class Vagon {
	
	private int capacidad_max;
	private List<Empleado> lstEmpleado;
	
	public Vagon() {
		// TODO Auto-generated constructor stub
	}
	public Vagon(int capacidad_max) {
		lstEmpleado = new ArrayList<Empleado>();
		this.capacidad_max=capacidad_max;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Capacidad: "+this.capacidad_max;
	}
	
	/**
	 * Agrega a lista empleados asignados al vagon
	 * @param oEmpleado
	 */
	public void agregarEmpleado(Empleado oEmpleado) {
		this.lstEmpleado.add(oEmpleado);
		oEmpleado.getLstVagon().add(this);
	}
	
	public int getCapacidad_max() {
		return capacidad_max;
	}
	public void setCapacidad_max(int capacidad_max) {
		this.capacidad_max = capacidad_max;
	}
	public List<Empleado> getLstEmpleado() {
		return lstEmpleado;
	}
	public void setLstEmpleado(List<Empleado> lstEmpleado) {
		this.lstEmpleado = lstEmpleado;
	}

}
