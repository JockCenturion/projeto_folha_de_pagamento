package controle;

import convenio. *;
import excecoes. *;
import folha.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Controle {
	static int resp = 0;
	static Scanner input = new Scanner(System.in);
	static BancoDeDados bd = new BancoDeDados();
	
	public static void main(String[] args) {
		do {
			menu();
			resp = input.nextInt();
			
			switch(resp) {
				case 1: op01(); break; 
				case 2: op02(); break;
				case 3: op03(); break;
				case 4: op04(); break;
				case 5: System.out.println("\tSaindo..."); break;
				default: System.out.println("Opcao Inválida.");
			}
		} while (resp != 5);
	}
	
	public static void menu() {
		System.out.println("\n\t\t\tMenu\n\n" 	    		 		  +
						   "\t1) Cadastro de Funcionario\n" 		  +
						   "\t2) Gerar Demonstrativo\n" 		      +
						   "\t3) Registrar Convenio MedGrupo\n" 	  +
						   "\t4) Registrar Evento\n"	 		 	  + 
						   "\t5) Sair"                                );
	}
	
	public static void op01() {
		
		/*Tirar Depois*/
	    Calendar cal = new GregorianCalendar();        
	    Date hoje = cal.getTime();         
	    cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)-1);
	    Date haUmMes = cal.getTime(); 
	    
	 
		System.out.println("\n\t\t\tCadastro do Funcionario\n\n" + 
						   "\tTipo[1 para Mensalista ou 2 para Comissionado]: ");
		
		if (input.nextInt() == 1) {
			input.nextLine();
			System.out.println("\tNome e Salario, Respectivamente: \n");
			bd.adicionaFuncionario(new FuncionarioMensalista(input.nextLine(), haUmMes, input.nextDouble()));
		} else {
			input.nextLine();
			System.out.println("\tNome e Salario, Respectivamente: \n");
			bd.adicionaFuncionario(new FuncionarioComissionado(input.nextLine(), haUmMes, input.nextDouble()));
		}
	} 
	
	public static void op02() {   
		if (bd.numeroDeFuncionarios() > 0) {
			try {
				System.out.println("\tNome: ");
				input.nextLine();
				Funcionario f = bd.buscaFuncionario(input.nextLine());
				f.geraDemonstrativo();
			} catch (FolhaException e){
				System.out.println(e);
			}
		} else {
			System.out.println("Nenhum Funcionario Cadastrado.");
		}
	}
	
	public static void op03() {
		if (bd.numeroDeFuncionarios() > 0) {
			input.nextLine();
			System.out.println("\n\t\t\tRegistrar Convênio\n\n" + 
							   "Nome do Funcionario: ");
			Funcionario f = bd.buscaFuncionario(input.nextLine());
			f.registraConvenio(new MedGrupo(), "1");
			System.out.println("Convenio Registrado Para " + f);
		} else {
			System.out.println("Nenhum Funcionario Cadastrado.");
		}
	
	}
	
	public static void op04() {
		
		/*Tirar Depois*/
	    Calendar cal = new GregorianCalendar();        
	    Date hoje = cal.getTime();         
	    cal.set(Calendar.MONTH,cal.get(Calendar.MONTH)-1);
	    Date haUmMes = cal.getTime(); 
	    Funcionario f = null;
		
		if (bd.numeroDeFuncionarios() > 0) {
			System.out.println("\n\t\t\tRegistrar Eventos\n\n"  +
					   "\t1) Reajuste\n" 			 			+
					   "\t2) Hora Extra\n" 						+
					   "\t3) Falta\n" 			 			    +
					   "\t4) Atraso\n" 			 			    +
					   "\t5) Recisao\n" 			 			+
					   "\t6) Comissao\n" 			 			);
			
			try {
				switch (input.nextInt()) {
					case 1: 
						System.out.println("\tNome: ");
						input.nextLine();
						f = bd.buscaFuncionario(input.nextLine());
						System.out.println("\tValor: ");
						f.registraEvento(new EventoReajuste(hoje, input.nextDouble()));
						break;
					case 2:
						System.out.println("\tNome: ");
						input.nextLine();
						f = bd.buscaFuncionario(input.nextLine());
						System.out.println("\tQtde. De Horas: ");
						f.registraEvento(new EventoHoraExtra(hoje, input.nextDouble()));
						break;
					case 3:
						System.out.println("\tNome: ");
						input.nextLine();
						f = bd.buscaFuncionario(input.nextLine());
						f.registraEvento(new EventoFalta(hoje));
						break;
					case 4:
						System.out.println("\tNome: ");
						input.nextLine();
						f = bd.buscaFuncionario(input.nextLine());
						System.out.println("\tQtde. de Horas: ");
						f.registraEvento(new EventoAtraso(hoje, input.nextDouble()));
						break;
					case 5:
						System.out.println("\tNome: ");
						input.nextLine();
						f = bd.buscaFuncionario(input.nextLine());
						System.out.println("\tMotivo: 1)Se Demitiu 2)Foi Demitido 3)Aposentado: ");
						int motivo = input.nextInt();
						System.out.println("\tAviso: 1)Cumpriu Aviso 2)Aviso Idenizado");
						boolean aviso = (input.nextInt() == 1 ? true : false);
						f.registraEvento(new EventoRescisao(hoje, motivo, aviso));
						break;
						
					case 6:
						System.out.println("\tNome: ");
						input.nextLine();
						f = bd.buscaFuncionario(input.nextLine());
						System.out.println("\tValor da Comissao: ");
						f.registraEvento(new EventoComissao(hoje, input.nextDouble()));
						break;
					default: System.out.println("Opcao Inválida.");
				}
			} catch (FolhaException e) {
				System.out.println(e);
			}
		} else {
			System.out.println("Nenhum Funcionario Cadastrado.");
		}
	}
}
