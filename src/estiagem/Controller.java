package estiagem;

import java.util.ArrayList;

public class Controller {	
	
	Boolean agrupar = true;
	ArrayList <Cidade> cidades = new ArrayList<>();
	
	void adicionarInformacao(Integer moradores, Double consumo) {
			    
	    Imovel imovel = new Imovel();
	    imovel.setMoradores( moradores );
	    imovel.setConsumo( consumo );
	    imovel.calcularMedia();
	    
	    this.cidades.get( this.cidades.size() -1 ).adicionarImovel(imovel);
	    
	}
	
	boolean validar(int moradores, Double consumo) {
		
		return ( ( moradores > 0 && moradores < 11) && (consumo > 0 && consumo < 201));
	}
	
	void iniciarCidade( int qtdImoveis) {
		
		int id = cidades.size() + 1; 
		cidades.add( new Cidade(qtdImoveis, id) );	

	}
	
	public void imprimir() {
		
 		int i = 1;		
 		
 		
 		for (Cidade cidade : cidades) {
 			
 			if(this.agrupar) {
 				
 				cidade.OrdenarImpressao();
 				cidade.Imprimir();
 				
 	 		}else {
 	 			
 	 			cidade.OrdenarImpressao2();
 				cidade.Imprimir2();
 	 		}
			
			
			if(i < cidades.size()) {
				System.out.print("\n\n");
			}
			i++;
		}
 		 
		
	}
}
