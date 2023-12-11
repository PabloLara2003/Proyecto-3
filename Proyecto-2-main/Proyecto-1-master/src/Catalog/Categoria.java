package Catalog;

public class Categoria {
	private String idCategoria;
	private int tarifaPorDia;
	private int valorExtra;
	
	public Categoria(String idCategoria, int tarifaPorDia, int valorExtra) {
		super();
		this.idCategoria = idCategoria;
		this.tarifaPorDia = tarifaPorDia;
		this.valorExtra = valorExtra;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getTarifaPorDia() {
		return tarifaPorDia;
	}

	public void setTarifaPorDia(int tarifaPorDia) {
		this.tarifaPorDia = tarifaPorDia;
	}

	public int getValorExtra() {
		return valorExtra;
	}

	public void setValorExtra(int valorExtra) {
		this.valorExtra = valorExtra;
	}
	
	public String generarTexto() {
		String texto = getIdCategoria() + "," + getTarifaPorDia() + "," + getValorExtra();
		return texto;
	}
}