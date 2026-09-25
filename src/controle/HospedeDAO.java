
package controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

import modelo.Hospede;

public class HospedeDAO {

	private File obterPastaPrograma() {
		try {
			File local = new File(HospedeDAO.class.getProtectionDomain().getCodeSource().getLocation().toURI());

			if (local.isFile()) {
				return local.getParentFile();
			}

			return local;

		} catch (URISyntaxException erro) {
			erro.printStackTrace();

			return new File(System.getProperty("user.dir"));
		}
	}

	public void escreverArquivo(ArrayList<Hospede> lista, String nomeArquivo) {

		File pastaPrograma = obterPastaPrograma();
		File arq = new File(pastaPrograma, nomeArquivo);

		try {

			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));

			objOutput.writeObject(lista);
			objOutput.flush();
			objOutput.close();

			System.out.println("Arquivo salvo com sucesso!");
			System.out.println("Local: " + arq.getAbsolutePath());
			System.out.println("Hospedes salvos: " + lista.size());

		} catch (IOException erro) {

			System.out.println("Erro ao salvar o arquivo:");
			erro.printStackTrace();
			System.out.println("Local: " + arq.getAbsolutePath());
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Hospede> lerArquivo(String nomeArquivo) {

		ArrayList<Hospede> lista = new ArrayList<Hospede>();

		File pastaPrograma = obterPastaPrograma();
		File arq = new File(pastaPrograma, nomeArquivo);

		try {

			if (arq.exists() && arq.length() > 0) {

				ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));

				lista = (ArrayList<Hospede>) objInput.readObject();

				objInput.close();

				System.out.println("Arquivo carregado com sucesso!");
				System.out.println("Local: " + arq.getAbsolutePath());
				System.out.println("Hospedes carregados: " + lista.size());

			} else {

				System.out.println("Arquivo não existe ou está vazio.");
				System.out.println("Será utilizada uma lista vazia.");
				System.out.println("Local: " + arq.getAbsolutePath());
			}

		} catch (IOException erro) {

			System.out.println("Erro ao ler o arquivo:");
			erro.printStackTrace();

		} catch (ClassNotFoundException erro) {

			System.out.println("Classe Hospede não encontrada:");
			erro.printStackTrace();
		}

		return lista;
	}
}
