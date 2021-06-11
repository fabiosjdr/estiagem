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
	
	ArrayList <Imovel> imovel = new ArrayList<>();
	ArrayList <Integer> Ordem = new ArrayList<>();
	Map<Integer,Double> medias = new HashMap<>();
	
	Cidade(int qtd, int id) {
		
		this.totalMoradoresCidade = 0;
		this.mediaConsumoCidade = 0;
		this.setQuantidadeImoveis(qtd);		
		this.setIdImovel(id);
		
	}
	
	public void setIdImovel(int id) {
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
	}
	
	public ArrayList<Imovel> getImoveis() {
		
		return this.imovel;
	}

	protected void OrdenarImpressao() {
		
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
	
	public void Imprimir() {
		
		
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
