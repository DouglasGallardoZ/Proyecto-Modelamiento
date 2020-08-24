package clases;

import java.util.List;

public class MaquinaTractora {
	
	private int potencia_max;
	private Operario oOperario;
	private boolean disponible=true;
	
	public MaquinaTractora() {
		// TODO Auto-generated constructor stub
	}
	public MaquinaTractora(int potencia_max) {
		this.potencia_max=potencia_max;
	}
	
	/**
	 * Retorna la disponibilidad de la maquina tractora
	 * @return
	 */
	public boolean isDisponible() {
		return this.disponible;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Maquina: "+this.potencia_max;
	}
	
	public int getPotencia_max() {
		return potencia_max;
	}
	public void setPotencia_max(int potencia_max) {
		this.potencia_max = potencia_max;
	}
	public Operario getoOperario() {
		return oOperario;
	}
	
	/**
	 * Asigna operario en la maquina tratora
	 * @param oOperario
	 */
	public void setoOperario(Operario oOperario) {
		this.oOperario = oOperario;
		oOperario.agregarMaquina(this);
		this.disponible=false;
	}

}
