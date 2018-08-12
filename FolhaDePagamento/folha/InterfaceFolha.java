package folha;
import java.util.Date;

public interface InterfaceFolha {
	public abstract Date getDtInicial() throws Exception;
	public abstract Date getDtFinal() throws Exception;
	public abstract void incluiDebito(String hist, double val) throws Exception;
	public abstract void incluiCredito(String hist, double val) throws Exception;
}
