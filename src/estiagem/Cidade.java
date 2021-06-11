package estiagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

public class Cidade {
	
	int qtd;
	int id;
	double mediaConsumoCidade;
	int totalMoradoresCidade;
	
	ArrayList <Imovel>  imovel 		 	= new ArrayList<>();
	ArrayList <Double>  OrdemAgrupada 	= new ArrayList<>();
	ArrayList <Integer> Ordem 			= new ArrayList<>();
	Map<Integer,Double> medias 		 	= new HashMap<>();
	Map<Double,Integer> mediasAgrupadas = new HashMap<>();
	
	Cidade(int qtd, int id) {
		
		this.totalMoradoresCidade = 0;
		this.mediaConsumoCidade = 0;
		this.setQuantidadeImoveis(qtd);		
		this.setIdCidade(id);
		
	}
	
	public void setIdCidade(int id) {
		this.id = id;
	}
	
	public void setQuantidadeImoveis(int qtd) {
		this.qtd = qtd;
	}
	
	public int getQuantidadeImoveis() {
		return this.qtd;
	}
	
	public void adicionarImovel(Imovel imovel) {
		
		this.totalMoradoresCidade += imovel.getMoradores();
		this.mediaConsumoCidade += imovel.getConsumo();
		
		this.imovel.add(imovel);
		this.medias.put(this.imovel.size() -1  , imovel.media);

		if(this.mediasAgrupadas.containsKey(imovel.media)) {
			int moradoresPorMedia = this.mediasAgrupadas.get(imovel.media).intValue();
			this.mediasAgrupadas.put(imovel.media, (moradoresPorMedia + imovel.moradores));
		}else {
			this.mediasAgrupadas.put(imovel.media,imovel.moradores);
		}
		
	}
	
	public ArrayList<Imovel> getImoveis() {
		
		return this.imovel;
	}

	protected void OrdenarImpressao2() {
		
		SortedSet<Double> MediaOrdenada = new TreeSet<>(medias.values());
		//System.out.println(MediaOrdenada);
		
		for (Double media : MediaOrdenada) {
			
			for(Entry<Integer, Double> entry: medias.entrySet()) {
				
				if(entry.getValue().equals(media)  ) {
					this.Ordem.add( entry.getKey() );
				}
				
			}
			
		}
		
	}
	
	protected void OrdenarImpressao() {		
		
		SortedSet<Double> MediaOrdenada = new TreeSet<>(mediasAgrupadas.keySet());		
				
		for (Double media : MediaOrdenada) {			
			this.OrdemAgrupada.add(media);
		}
	}
	
	public void Imprimir(){
		
		System.out.println("Cidade# "+ this.id);		
		int i = 1; 
		
		for (Double ordem : OrdemAgrupada) {			
			String espaco = (i == OrdemAgrupada.size()) ? "\n" : " ";
			var media =  ordem;
			var morad = mediasAgrupadas.get(ordem).intValue();
			System.out.print( Integer.toString(morad)  +"-"+ String.format(Locale.US,"%.0f",media) + espaco );
			i++;
		}		
		
		System.out.print("Consumo medio: " + String.format(Locale.US,"%.2f",( Math.floor( (this.mediaConsumoCidade / this.totalMoradoresCidade) * 100) / 100)) + " m3.");
		//System.out.printf("Consumo medio: %.2f m3.", (this.mediaConsumoCidade / this.totalMoradoresCidade));
		
		
	}

	public void Imprimir2() {
		
		
		System.out.println("Cidade# "+ this.id);		
		int i = 1; 
		for (Integer ordem : Ordem) {
			
			String espaco = (i == Ordem.size()) ? "\n" : " ";
			var media = imovel.get(ordem).getMedia();			 
			System.out.print( imovel.get(ordem).getMoradores()+"-"+ String.format(Locale.US,"%.0f",media) + espaco );
			i++;
		}		
		
		System.out.print("Consumo medio: " + String.format(Locale.US,"%.2f",( Math.floor( (this.mediaConsumoCidade / this.totalMoradoresCidade) * 100) / 100)) + " m3.");
		//System.out.printf("Consumo medio: %.2f m3.", (this.mediaConsumoCidade / this.totalMoradoresCidade));
		
		
	}
	
	
	
}
