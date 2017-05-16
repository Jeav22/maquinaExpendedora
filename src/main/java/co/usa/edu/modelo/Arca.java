package co.usa.edu.modelo;

public class Arca {
	private int idArca;
	private int denominacion;
	private int piezas;
	private int cantidadMaximaPiezas;
		
	public Arca(int idArca, int denominacion, int piezas, int cantidadMaximaPiezas) {
		this.idArca = idArca;
		this.denominacion = denominacion;
		this.piezas = piezas;
		this.cantidadMaximaPiezas = cantidadMaximaPiezas;
	}
	
	public int getIdArca() {
		return idArca;
	}
	public void setIdArca(int idArca) {
		this.idArca = idArca;
	}
	public int getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(int denominacion) {
		this.denominacion = denominacion;
	}
	public int getPiezas() {
		return piezas;
	}
	public void setPiezas(int piezas) {
		this.piezas = piezas;
	}
	public int getCantidadMaximaPiezas() {
		return cantidadMaximaPiezas;
	}
	public void setCantidadMaximaPiezas(int cantidadMaximaPiezas) {
		this.cantidadMaximaPiezas = cantidadMaximaPiezas;
	}
}
	