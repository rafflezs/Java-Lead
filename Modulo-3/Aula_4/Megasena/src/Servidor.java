
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

/**
 *
 * @author LEAD
 */
public class Servidor {

	private String resultado;
	private String data;

	public void iniciarServico() {

		HashMap <String, String> mapa = (HashMap<String, String>) Map.ofEntries(
				entry("08/10", "06-55-13-47-22-19"),
				entry("15/10", "10-34-22-01-43-17"),
				entry("22/10", "02-31-42-21-12-49"),
				entry("29/10", "54-15-14-32-24-11"),
				entry("05/11", "01-35-19-32-25-44"));

		try {

			ServerSocket servidor = new ServerSocket(8898);
			while (true) {

				System.out.println("Aguardando conexão...");
				Socket cliente = servidor.accept();
				DataInputStream dataInputStream = new DataInputStream(cliente.getInputStream());
				String data = dataInputStream.readUTF();
				resultado = mapa.get(data);
				DataOutputStream dataOutputStream = new DataOutputStream(cliente.getOutputStream());

				System.out.println("Enviando dados para " + cliente.getInetAddress());
				dataOutputStream.writeUTF(resultado);
			}

		} catch (IOException exception) {
			System.err.println(exception.getMessage());
		}

	}

	public static void main(String[] args) {
		Servidor servidorDeResultados = new Servidor();
		servidorDeResultados.iniciarServico();
	}

}
