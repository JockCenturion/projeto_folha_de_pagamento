package folha;

import java.util.HashMap;
import java.util.Map.Entry;

public class BancoDeDados {
	private HashMap<String, Funcionario>banco;
	
	public BancoDeDados() {
		banco = new HashMap<>();
	}
	
	public void adicionaFuncionario(Funcionario f) { //NullPointerException
		banco.put(f.getNomeFunc().toUpperCase(), f);
	}
	
	public Funcionario buscaFuncionario(String nome) {
		return banco.get(nome.toUpperCase());
	}
	
	public void listaFuncionarios() {
		for (Entry<String, Funcionario> set : banco.entrySet()) {
			System.out.println(set.getValue());
		}
	}
	
	public int numeroDeFuncionarios() {
		return banco.size();
	}
	
	
	

}
