package br.com.panicobass.testelistactivity;

public class Carro {
	private String modelo;
	private String marca;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCarroImagem(int position) {
		switch (position) {
		case 0:
			return (R.drawable.carro1);
		case 1:
			return (R.drawable.carro2);
		case 2:
			return (R.drawable.carro3);
		case 3:
			return (R.drawable.carro4);
		case 4:
			return (R.drawable.carro5);
		default:
			return (R.drawable.carro6);
		}
	}

}
