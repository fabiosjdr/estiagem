package estiagem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class desafio {
	
	public static void main(String[] args) {
		
		   try {	
				
				File myObj = new File(System.getProperty("user.dir")+"/src/entrada.txt");
			    Scanner myReader = new Scanner(myObj);
				
			    Controller controller = new Controller();
			    
			    while (myReader.hasNextLine()) {
			    	
			    	String info = myReader.nextLine();

			    	//identifica a linha que inicia cada instrucao
			    	if(info.matches("^\\d{1,3}(?!.)")) {		    		
					    
			    		Integer qtdImoveis = Integer.parseInt(info);
			    		if(qtdImoveis > 0 && qtdImoveis < 107) {
			    			controller.iniciarCidade(qtdImoveis);
			    		}else {
			    			break;
			    		}
			    							   
					    
			    	}else {		    		
			    		
			    		var instrucao = info.split(" ");
			    		var moradores = Integer.parseInt(instrucao[0]);
			    		var consumo   = Double.parseDouble(instrucao[1]);
			    		
			    		if(controller.validar(moradores, consumo)) {
			    			controller.adicionarInformacao( moradores, consumo );
			    		}
			    		
			    		
			    	}
			    }
			    
			    controller.imprimir();
			    myReader.close();
			    
			} catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
		    }
		}
}
