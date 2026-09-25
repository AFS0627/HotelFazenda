package controle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Hospede;
import visao.JanelaAlterarHospede;

public class HospedeController {
	private final HospedeDAO dao;
	private final ArrayList<Hospede> listaHospedes;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final String nomeArquivo = "dados.dat";

	public HospedeController() {
		dao = new HospedeDAO();
		listaHospedes = dao.lerArquivo(nomeArquivo);
	}

	public boolean adicionar(String nome, String nascimento, String nacionalidade, String passaporte, String checkIn,
			String checkOut, String numeroQuarto, String totalPago, String email, String telefone, String endereco,
			String numeroPessoas, String solicitacoesEspeciais, int avaliacao) {
		if (!validarCampos(nome, nascimento, nacionalidade, passaporte, checkIn, checkOut, numeroQuarto, totalPago,
				email, telefone, endereco, numeroPessoas, avaliacao)) {

			return false;

		}
		Hospede hospede = criarHospede(nome, nascimento, nacionalidade, passaporte, checkIn, checkOut, numeroQuarto,
				totalPago, email, telefone, endereco, numeroPessoas, solicitacoesEspeciais, avaliacao);
		listaHospedes.add(hospede);
		JOptionPane.showMessageDialog(null, "Hóspede adicionado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		return true;
	}

	public void excluir(int posicao) {
		if (posicao >= 0 && posicao < listaHospedes.size()) {
			listaHospedes.remove(posicao);
			JOptionPane.showMessageDialog(null, "Hóspede excluído com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public Hospede buscar(int posicao) {
		if (posicao >= 0 && posicao < listaHospedes.size()) {
			return listaHospedes.get(posicao);
		}
		return null;
	}

	public ArrayList<Hospede> listar() {
		return listaHospedes;
	}

	public void alterar(int posicao, Hospede hospede) {
		if (posicao >= 0 && posicao < listaHospedes.size()) {
			listaHospedes.set(posicao, hospede);
		}
	}

	public void salvar() {
		dao.escreverArquivo(listaHospedes, nomeArquivo);
	}

	private Hospede criarHospede(String nome, String nascimento, String nacionalidade, String passaporte,
			String checkIn, String checkOut, String numeroQuarto, String totalPago, String email, String telefone,
			String endereco, String numeroPessoas, String solicitacoesEspeciais, int avaliacao) {
		Hospede hospede = new Hospede();
		hospede.setNome(nome.trim());
		hospede.setNascimento(LocalDate.parse(nascimento.trim(), formatter));
		hospede.setNacionalidade(nacionalidade.trim());
		hospede.setPassaporte(passaporte.trim());
		hospede.setCheckIn(LocalDate.parse(checkIn.trim(), formatter));
		hospede.setCheckOut(LocalDate.parse(checkOut.trim(), formatter));
		hospede.setNumeroQuarto(Integer.parseInt(numeroQuarto.trim()));
		hospede.setTotalPago(Double.parseDouble(totalPago.trim().replace(",", ".")));
		hospede.setEmail(email.trim());
		hospede.setTelefone(telefone.trim());
		hospede.setEndereco(endereco.trim());
		hospede.setNumeroPessoas(Integer.parseInt(numeroPessoas.trim()));
		hospede.setSolicitacoesEspeciais(solicitacoesEspeciais.trim());
		hospede.setAvaliacao(avaliacao);
		return hospede;
	}

	public List<Object[]> obterDadosTabela() {
		List<Object[]> dados = new ArrayList<>();
		for (Hospede hospede : listaHospedes) {
			dados.add(new Object[] { hospede.getNome(), hospede.getNascimento().format(formatter),
					hospede.getNacionalidade(), hospede.getPassaporte(), hospede.getCheckIn().format(formatter),
					hospede.getCheckOut().format(formatter), hospede.getNumeroQuarto(), hospede.getTotalPago() + " R$",
					hospede.getEmail(), hospede.getTelefone(), hospede.getEndereco(), hospede.getNumeroPessoas(),
					hospede.getSolicitacoesEspeciais(), hospede.getAvaliacao() });
		}
		return dados;
	}

	public void atualizar(JanelaAlterarHospede janela, Hospede hospede, String nome, String nascimento,
			String nacionalidade, String passaporte, String checkIn, String checkOut, String numeroQuarto,
			String totalPago, String email, String telefone, String endereco, String numeroPessoas,
			String solicitacoesEspeciais, int avaliacao) {
		if (!validarCampos(nome, nascimento, nacionalidade, passaporte, checkIn, checkOut, numeroQuarto, totalPago,
				email, telefone, endereco, numeroPessoas, avaliacao)) {

			return;
		}
		hospede.setNome(nome.trim());
		hospede.setNascimento(LocalDate.parse(nascimento.trim(), formatter));
		hospede.setNacionalidade(nacionalidade.trim());
		hospede.setPassaporte(passaporte.trim());
		hospede.setCheckIn(LocalDate.parse(checkIn.trim(), formatter));
		hospede.setCheckOut(LocalDate.parse(checkOut.trim(), formatter));
		hospede.setNumeroQuarto(Integer.parseInt(numeroQuarto.trim()));
		hospede.setTotalPago(Double.parseDouble(totalPago.trim().replace(",", ".")));
		hospede.setEmail(email.trim());
		hospede.setTelefone(telefone.trim());
		hospede.setEndereco(endereco.trim());
		hospede.setNumeroPessoas(Integer.parseInt(numeroPessoas.trim()));
		hospede.setSolicitacoesEspeciais(solicitacoesEspeciais.trim());
		hospede.setAvaliacao(avaliacao);
		salvar();
		JOptionPane.showMessageDialog(null, "Hóspede alterado com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	private boolean validarCampos(String nome, String nascimento, String nacionalidade, String passaporte,
			String checkIn, String checkOut, String numeroQuarto, String totalPago, String email, String telefone,
			String endereco, String numeroPessoas, int avaliacao) {
		if (nome == null || nome.trim().isEmpty()) {
			mostrarErro("Informe o nome do hóspede.");
			return false;
		}
		if (nascimento == null || nascimento.trim().isEmpty()) {
			mostrarErro("Informe a data de nascimento.");
			return false;
		}
		LocalDate dataNascimento;
		try {
			dataNascimento = LocalDate.parse(nascimento.trim(), formatter);
		} catch (DateTimeParseException erro) {
			mostrarErro("Data de nascimento inválida.\n" + "Use o formato dd/MM/yyyy.");
			return false;
		}
		if (dataNascimento.isAfter(LocalDate.now())) {
			mostrarErro("A data de nascimento não pode ser futura.");
			return false;
		}
		if (nacionalidade == null || nacionalidade.trim().isEmpty()) {
			mostrarErro("Informe a nacionalidade.");
			return false;
		}
		if (passaporte == null || passaporte.trim().isEmpty()) {
			mostrarErro("Informe o passaporte.");
			return false;
		}
		if (checkIn == null || checkIn.trim().isEmpty()) {
			mostrarErro("Informe a data de check-in.");
			return false;
		}
		LocalDate dataCheckIn;
		try {
			dataCheckIn = LocalDate.parse(checkIn.trim(), formatter);
		} catch (DateTimeParseException erro) {
			mostrarErro("Data de check-in inválida.\n" + "Use o formato dd/MM/yyyy.");
			return false;
		}
		if (checkOut == null || checkOut.trim().isEmpty()) {
			mostrarErro("Informe a data de check-out.");
			return false;
		}
		LocalDate dataCheckOut;
		try {
			dataCheckOut = LocalDate.parse(checkOut.trim(), formatter);
		} catch (DateTimeParseException erro) {
			mostrarErro("Data de check-out inválida.\n" + "Use o formato dd/MM/yyyy.");
			return false;
		}
		if (dataCheckOut.isBefore(dataCheckIn)) {
			mostrarErro("A data de check-out não pode ser anterior " + "à data de check-in.");
			return false;
		}
		if (numeroQuarto == null || numeroQuarto.trim().isEmpty()) {
			mostrarErro("Informe o número do quarto.");
			return false;
		}
		try {
			int quarto = Integer.parseInt(numeroQuarto.trim());
			if (quarto <= 0) {
				mostrarErro("O número do quarto deve ser maior que zero.");
				return false;
			}
		} catch (NumberFormatException erro) {
			mostrarErro("Número do quarto inválido.\n" + "Informe apenas números inteiros.");
			return false;
		}
		if (totalPago == null || totalPago.trim().isEmpty()) {
			mostrarErro("Informe o valor total pago.");
			return false;
		}
		try {
			double valor = Double.parseDouble(totalPago.trim().replace(",", "."));
			if (valor < 0) {
				mostrarErro("O total pago não pode ser negativo.");
				return false;
			}
		} catch (NumberFormatException erro) {
			mostrarErro("Valor total pago inválido.\n" + "Informe um número válido.");
			return false;
		}
		if (email == null || email.trim().isEmpty()) {
			mostrarErro("Informe o e-mail.");
			return false;
		}
		if (!emailValido(email.trim())) {
			mostrarErro("E-mail inválido.\n" + "Exemplo: nome@email.com");
			return false;
		}
		if (telefone == null || telefone.trim().isEmpty()) {
			mostrarErro("Informe o telefone.");
			return false;
		}
		if (endereco == null || endereco.trim().isEmpty()) {
			mostrarErro("Informe o endereço.");
			return false;
		}
		if (numeroPessoas == null || numeroPessoas.trim().isEmpty()) {
			mostrarErro("Informe o número de pessoas.");
			return false;
		}
		try {
			int pessoas = Integer.parseInt(numeroPessoas.trim());
			if (pessoas <= 0) {
				mostrarErro("O número de pessoas deve ser maior que zero.");
				return false;
			}
		} catch (NumberFormatException erro) {
			mostrarErro("Número de pessoas inválido.\n" + "Informe apenas números inteiros.");
			return false;
		}
		if (avaliacao < 1 || avaliacao > 5) {
			mostrarErro("A avaliação deve estar entre 1 e 5.");
			return false;
		}
		return true;
	}

	private boolean emailValido(String email) {
		return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	}

	private void mostrarErro(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "Erro de validação", JOptionPane.ERROR_MESSAGE);
	}

	public void abrirAlteracao(int posicao, Runnable aoSalvar) {
		Hospede hospede = buscar(posicao);
		if (hospede == null) {
			mostrarErro("Selecione um hóspede para alterar.");
			return;
		}
		JanelaAlterarHospede janela = new JanelaAlterarHospede(this, aoSalvar);
		janela.mostrarDados(hospede);
		janela.setVisible(true);
	}
}