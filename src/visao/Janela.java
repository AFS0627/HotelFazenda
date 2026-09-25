package visao;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.HospedeController;
import modelo.Hospede;
import net.miginfocom.swing.MigLayout;

public class Janela extends JFrame {

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
	private JCheckBox chckbxLimpaCampo;

	private JTable table;

	private HospedeController controller;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Janela() {

		controller = new HospedeController();

		configurarJanela();
		criarComponentes();
		atualizarTabela();
	}

	private void configurarJanela() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 841);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane
				.setLayout(new MigLayout("", "[grow][][grow][][][][]", "[][][][16.00][15.00][][][][][][][][][][][]"));
	}

	private void criarComponentes() {

		JLabel lblNome = new JLabel("Nome do Hóspede:");

		contentPane.add(lblNome, "cell 0 0");

		JLabel lblNascimento = new JLabel("Data de Nascimento:");

		contentPane.add(lblNascimento, "cell 2 0");

		txtNome = new JTextField();
		txtNome.setColumns(10);

		contentPane.add(txtNome, "cell 0 1,growx");

		txtNascimento = new JTextField();
		txtNascimento.setColumns(10);

		contentPane.add(txtNascimento, "cell 2 1,growx");

		JLabel lblNacionalidade = new JLabel("Nacionalidade:");

		contentPane.add(lblNacionalidade, "cell 0 2");

		txtNacionalidade = new JTextField();
		txtNacionalidade.setColumns(10);

		contentPane.add(txtNacionalidade, "cell 0 3,growx");

		JLabel lblNumeroPassaporte = new JLabel("Número do Passaporte:");

		contentPane.add(lblNumeroPassaporte, "cell 2 2");

		txtPassaporte = new JTextField();
		txtPassaporte.setColumns(10);

		contentPane.add(txtPassaporte, "cell 2 3,growx");

		JLabel lblDataCheckIn = new JLabel("Data de Check-In:");

		contentPane.add(lblDataCheckIn, "cell 0 4");

		txtCheckIn = new JTextField();
		txtCheckIn.setColumns(10);

		contentPane.add(txtCheckIn, "cell 0 5,growx");

		JLabel lblDataCheckOut = new JLabel("Data de Check-Out:");

		contentPane.add(lblDataCheckOut, "cell 2 4");

		txtCheckOut = new JTextField();
		txtCheckOut.setColumns(10);

		contentPane.add(txtCheckOut, "cell 2 5,growx");

		JLabel lblNumeroQuarto = new JLabel("Número do Quarto:");

		contentPane.add(lblNumeroQuarto, "cell 0 6");

		txtNumeroQuarto = new JTextField();
		txtNumeroQuarto.setColumns(10);

		contentPane.add(txtNumeroQuarto, "cell 0 7,growx");

		JLabel lblTotalPago = new JLabel("Total Pago:");

		contentPane.add(lblTotalPago, "cell 2 6");

		txtTotalPago = new JTextField();
		txtTotalPago.setColumns(10);

		contentPane.add(txtTotalPago, "cell 2 7,growx");

		JLabel lblEmail = new JLabel("E-mail do Hóspede:");

		contentPane.add(lblEmail, "cell 0 8");

		txtEmail = new JTextField();
		txtEmail.setColumns(10);

		contentPane.add(txtEmail, "cell 0 9,growx");

		JLabel lblTelefone = new JLabel("Número de Telefone:");

		contentPane.add(lblTelefone, "cell 2 8");

		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);

		contentPane.add(txtTelefone, "cell 2 9,growx");

		JLabel lblEndereco = new JLabel("Endereço:");

		contentPane.add(lblEndereco, "cell 0 10");

		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);

		contentPane.add(txtEndereco, "cell 0 11,growx");

		JLabel lblPessoas = new JLabel("Número de Pessoas na Reserva:");

		contentPane.add(lblPessoas, "cell 2 10");

		txtNumeroPessoas = new JTextField();
		txtNumeroPessoas.setColumns(10);

		contentPane.add(txtNumeroPessoas, "cell 2 11,growx");

		JLabel lblSolicitacoes = new JLabel("Solicitações Especiais:");

		contentPane.add(lblSolicitacoes, "cell 0 12");

		txtSolicitacoesEspeciais = new JTextField();

		txtSolicitacoesEspeciais.setColumns(10);

		contentPane.add(txtSolicitacoesEspeciais, "cell 0 13,growx");

		JLabel lblAvaliacao = new JLabel("Avaliação do Hóspede:");

		contentPane.add(lblAvaliacao, "cell 2 12");

		comboBoxAvaliacao = new JComboBox<Integer>();

		for (int i = 0; i <= 5; i++) {
			comboBoxAvaliacao.addItem(i);
		}

		contentPane.add(comboBoxAvaliacao, "cell 2 13,growx");

		chckbxLimpaCampo = new JCheckBox("Limpar campos");

		chckbxLimpaCampo.setSelected(true);

		contentPane.add(chckbxLimpaCampo, "cell 0 14");

		JButton btnAdicionar = new JButton("Adicionar");

		contentPane.add(btnAdicionar, "flowx,cell 0 14");

		JButton btnExcluir = new JButton("Excluir");

		contentPane.add(btnExcluir, "flowx,cell 2 14");

		JButton btnAlterar = new JButton("Alterar");

		contentPane.add(btnAlterar, "cell 4 14");

		JButton btnFechar = new JButton("Fechar");

		contentPane.add(btnFechar, "cell 6 14");

		JScrollPane scrollPane = new JScrollPane();

		contentPane.add(scrollPane, "cell 0 15 7 1,grow");

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Data Nascimento", "Nacionalidade", "Número do Passaporte", "Data de Check-In",
						"Data de Check-Out", "Número do Quarto", "Total Pago", "E-mail", "Número de Telefone",
						"Endereço", "Número de Pessoas", "Solicitações Especiais", "Avaliação" }));

		scrollPane.setViewportView(table);

		configurarEventos(btnAdicionar, btnExcluir, btnAlterar, btnFechar);
	}

	private void configurarEventos(JButton btnAdicionar, JButton btnExcluir, JButton btnAlterar, JButton btnFechar) {

		btnAdicionar.addActionListener(e -> adicionar());

		btnExcluir.addActionListener(e -> excluir());

		btnAlterar.addActionListener(e -> alterar());

		btnFechar.addActionListener(e -> fechar());

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				fechar();
			}
		});
	}

	private void adicionar() {

		boolean adicionado = controller.adicionar(txtNome.getText(), txtNascimento.getText(),
				txtNacionalidade.getText(), txtPassaporte.getText(), txtCheckIn.getText(), txtCheckOut.getText(),
				txtNumeroQuarto.getText(), txtTotalPago.getText(), txtEmail.getText(), txtTelefone.getText(),
				txtEndereco.getText(), txtNumeroPessoas.getText(), txtSolicitacoesEspeciais.getText(),
				(Integer) comboBoxAvaliacao.getSelectedItem());

		if (adicionado) {
			atualizarTabela();
			limparCampos();
		}
	}

	private void excluir() {

		controller.excluir(table.getSelectedRow());

		atualizarTabela();
	}

	private void alterar() {

		controller.abrirAlteracao(table.getSelectedRow(), this::atualizarTabela);
	}

	private void fechar() {

		controller.salvar();
		dispose();

	}

	private void limparCampos() {

		if (!chckbxLimpaCampo.isSelected()) {
			return;
		}

		txtNome.setText("");
		txtNascimento.setText("");
		txtNacionalidade.setText("");
		txtPassaporte.setText("");
		txtCheckIn.setText("");
		txtCheckOut.setText("");
		txtNumeroQuarto.setText("");
		txtTotalPago.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtEndereco.setText("");
		txtNumeroPessoas.setText("");
		txtSolicitacoesEspeciais.setText("");

		comboBoxAvaliacao.setSelectedItem(0);
	}

	private void atualizarTabela() {

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.setRowCount(0);

		for (Object[] linha : controller.obterDadosTabela()) {
			model.addRow(linha);
		}
	}
}
