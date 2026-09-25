package visao;

import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.HospedeController;
import modelo.Hospede;
import net.miginfocom.swing.MigLayout;

public class JanelaAlterarHospede extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtNome;
	private JTextField txtNascimento;
	private JTextField txtNacionalidade;
	private JTextField txtPassaporte;
	private JTextField txtCheckIn;
	private JTextField txtCheckOut;
	private JTextField txtNumeroQuarto;
	private JTextField txtTotalPago;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtNumeroPessoas;
	private JTextField txtSolicitacoesEspeciais;

	private JComboBox<Integer> comboBoxAvaliacao;

	private Hospede hospedeSelecionado;

	private final HospedeController controller;

	private final Runnable aoSalvar;

	private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public JanelaAlterarHospede(HospedeController controller, Runnable aoSalvar) {

		this.controller = controller;
		this.aoSalvar = aoSalvar;

		configurarJanela();
		criarComponentes();
	}

	private void configurarJanela() {

		setTitle("Alteração");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 400, 500);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);

		contentPane.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][][][][][][][][]"));
	}

	private void criarComponentes() {

		contentPane.add(new JLabel("Nome do Hóspede:"), "cell 0 0");

		txtNome = new JTextField();

		contentPane.add(txtNome, "cell 1 0 3 1,growx");

		txtNome.setColumns(10);

		contentPane.add(new JLabel("Data de Nascimento:"), "cell 0 1");

		txtNascimento = new JTextField();

		contentPane.add(txtNascimento, "cell 1 1 3 1,growx");

		txtNascimento.setColumns(10);

		contentPane.add(new JLabel("Nacionalidade:"), "cell 0 2");

		txtNacionalidade = new JTextField();

		contentPane.add(txtNacionalidade, "cell 1 2 3 1,growx");

		txtNacionalidade.setColumns(10);

		contentPane.add(new JLabel("Número do Passaporte:"), "cell 0 3");

		txtPassaporte = new JTextField();

		contentPane.add(txtPassaporte, "cell 1 3 3 1,growx");

		txtPassaporte.setColumns(10);

		contentPane.add(new JLabel("Data de Check-In:"), "cell 0 4");

		txtCheckIn = new JTextField();

		contentPane.add(txtCheckIn, "cell 1 4 3 1,growx");

		txtCheckIn.setColumns(10);

		contentPane.add(new JLabel("Data de Check-Out:"), "cell 0 5");

		txtCheckOut = new JTextField();

		contentPane.add(txtCheckOut, "cell 1 5 3 1,growx");

		txtCheckOut.setColumns(10);

		contentPane.add(new JLabel("Número do Quarto:"), "cell 0 6");

		txtNumeroQuarto = new JTextField();

		contentPane.add(txtNumeroQuarto, "cell 1 6 3 1,growx");

		txtNumeroQuarto.setColumns(10);

		contentPane.add(new JLabel("Total Pago:"), "cell 0 7");

		txtTotalPago = new JTextField();

		contentPane.add(txtTotalPago, "cell 1 7 3 1,growx");

		txtTotalPago.setColumns(10);

		contentPane.add(new JLabel("E-mail do Hóspede:"), "cell 0 8");

		txtEmail = new JTextField();

		contentPane.add(txtEmail, "cell 1 8 3 1,growx");

		txtEmail.setColumns(10);

		contentPane.add(new JLabel("Número de Telefone:"), "cell 0 9");

		txtTelefone = new JTextField();

		contentPane.add(txtTelefone, "cell 1 9 3 1,growx");

		txtTelefone.setColumns(10);

		contentPane.add(new JLabel("Endereço:"), "cell 0 10");

		txtEndereco = new JTextField();

		contentPane.add(txtEndereco, "cell 1 10 3 1,growx");

		txtEndereco.setColumns(10);

		contentPane.add(new JLabel("Número de Pessoas na Reserva:"), "cell 0 11");

		txtNumeroPessoas = new JTextField();

		contentPane.add(txtNumeroPessoas, "cell 1 11 3 1,growx");

		txtNumeroPessoas.setColumns(10);

		contentPane.add(new JLabel("Solicitações Especiais:"), "cell 0 12");

		txtSolicitacoesEspeciais = new JTextField();

		contentPane.add(txtSolicitacoesEspeciais, "cell 1 12 3 1,growx");

		txtSolicitacoesEspeciais.setColumns(10);

		contentPane.add(new JLabel("Avaliação do Hóspede:"), "cell 0 13");

		comboBoxAvaliacao = new JComboBox<>();

		adicionarAvaliacoes();

		contentPane.add(comboBoxAvaliacao, "cell 1 13 3 1,growx");

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(e -> salvar());

		contentPane.add(btnSalvar, "cell 1 14");

		JButton btnCancelar = new JButton("Cancelar");

		btnCancelar.addActionListener(e -> dispose());

		contentPane.add(btnCancelar, "cell 2 14");
	}

	private void adicionarAvaliacoes() {

		for (int avaliacao = 0; avaliacao <= 5; avaliacao++) {
			comboBoxAvaliacao.addItem(avaliacao);
		}
	}

	private void salvar() {

		controller.atualizar(JanelaAlterarHospede.this, hospedeSelecionado, txtNome.getText(), txtNascimento.getText(),
				txtNacionalidade.getText(), txtPassaporte.getText(), txtCheckIn.getText(), txtCheckOut.getText(),
				txtNumeroQuarto.getText(), txtTotalPago.getText(), txtEmail.getText(), txtTelefone.getText(),
				txtEndereco.getText(), txtNumeroPessoas.getText(), txtSolicitacoesEspeciais.getText(),
				(Integer) comboBoxAvaliacao.getSelectedItem());

		controller.salvar();

		aoSalvar.run();

	}

	public void mostrarDados(Hospede hospede) {

		this.hospedeSelecionado = hospede;

		txtNome.setText(hospede.getNome());

		txtNascimento.setText(hospede.getNascimento().format(dateFormatter));

		txtNacionalidade.setText(hospede.getNacionalidade());

		txtPassaporte.setText(hospede.getPassaporte());

		txtCheckIn.setText(hospede.getCheckIn().format(dateFormatter));

		txtCheckOut.setText(hospede.getCheckOut().format(dateFormatter));

		txtNumeroQuarto.setText(String.valueOf(hospede.getNumeroQuarto()));

		txtTotalPago.setText(String.valueOf(hospede.getTotalPago()));

		txtEmail.setText(hospede.getEmail());

		txtTelefone.setText(hospede.getTelefone());

		txtEndereco.setText(hospede.getEndereco());

		txtNumeroPessoas.setText(String.valueOf(hospede.getNumeroPessoas()));

		txtSolicitacoesEspeciais.setText(hospede.getSolicitacoesEspeciais());

		comboBoxAvaliacao.setSelectedItem(hospede.getAvaliacao());
	}
}