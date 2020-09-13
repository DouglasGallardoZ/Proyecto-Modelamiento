package clases;

public class Jefe extends Empleado {
	
	private int telefono;
	private int edad;
	
	public Jefe() {
		// TODO Auto-generated constructor stub
	}

	public Jefe(int cedula, String nombre, int nss, String domicilio, int telefono) {
		super(cedula, nombre, nss, domicilio);
		// TODO Auto-generated constructor stub
		this.telefono=telefono;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+" Jefe|";
	}
	
	/**
	 * Retorna verdadero si el empleado a consultar es jefe caso contrario 
	 * retorna falso 
	 * @param oEmpleado
	 * @return
	 */
	public static boolean isJefe(Empleado oEmpleado) {
		try {
			Jefe oJ=(Jefe)oEmpleado;
			return true;
		} catch (ClassCastException e) {
			// TODO: handle exception
			return false;
		}
	}
	
	
	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
