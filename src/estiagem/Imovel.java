package estiagem;

public class Imovel {
	
	Integer moradores;
	Double consumo;
	double media;
	
	public void setMoradores(Integer moradores) {
		this.moradores = moradores;
	}
	
	public void setConsumo(Double consumo) {
		this.consumo = consumo;
	}
	
	public Integer getMoradores() {
		return this.moradores;
	}
	
	public Double getConsumo() {
		return this.consumo;
	}
	
	public void calcularMedia() {
		
		this.media = Math.floor( this.consumo / this.moradores );
	}
	
	public double getMedia() {
		return this.media;
	}
}
