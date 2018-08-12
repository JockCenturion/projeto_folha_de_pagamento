package testSI;
import convenio. *;
import excecoes. *;
import folha.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {
	public static void main(String[] args) {
		
        Calendar cal = new GregorianCalendar();        
        Date hoje = cal.getTime();         
        cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)-1);
        Date haUmMes = cal.getTime();   
        InterfaceConvenio convenio = new MedGrupo();
        	
        Funcionario f1 = null, f2;
        
        BancoDeDados bd = new BancoDeDados();
        /*
        try {
            f1 = new FuncionarioMensalista("Joao", haUmMes, 500);
            f1.registraConvenio(convenio, "1");
            f1.registraEvento(new EventoReajuste(hoje, 500));
            f1.registraEvento(new EventoHoraExtra(hoje, 3));
            f1.registraEvento(new EventoFalta(hoje));
            f1.registraEvento(new EventoAtraso(hoje, 1));
            f1.geraDemonstrativo();
            
            f2 = new FuncionarioComissionado("Brother", haUmMes, 600);
            f2.registraConvenio(convenio, "2");
            f2.registraEvento(new EventoReajuste(hoje, 300));
            f2.registraEvento(new EventoComissao(hoje, 80));
            //f2.registraEvento(new EventoFalta(hoje)); //Evento inválido para comissionado
            //f2.geraDemonstrativo();
            
         
            
        } catch (FolhaException e) {
        	System.out.println("Error: " + e);
        }
        */
        
     
        try {
			EventoRescisao er = new EventoRescisao(hoje, 1, true);
		} catch (FolhaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
       
        
       
        /*
        f1 = new FuncionarioMensalista("Joao", haUmMes, 500);
        f2 = new FuncionarioComissionado("Brother", haUmMes, 600);
      
        bd.adicionaFuncionario(f1);
        bd.adicionaFuncionario(f2);
        bd.listaFuncionarios();
        */
        
        
        

        
      
	}
}
