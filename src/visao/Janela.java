package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.HospedeDAO;
import modelo.Hospede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;

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
    private JTable table;
    private ArrayList<Hospede> listaHospedes;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Janela frame = new Janela();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Janela() {

        HospedeDAO pdao = new HospedeDAO();
        listaHospedes = pdao.lerArquivo("dados.dat");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1019, 841);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[grow][][grow][][][][]", "[][][][16.00][15.00][][][][][][][][][][][]"));

        JLabel lblNome = new JLabel("Nome do Hóspede:");
        contentPane.add(lblNome, "cell 0 0");

        JLabel lblNascimento = new JLabel("Data de Nascimento:");
        contentPane.add(lblNascimento, "cell 2 0");

        txtNome = new JTextField();
        contentPane.add(txtNome, "cell 0 1,growx");
        txtNome.setColumns(10);

        txtNascimento = new JTextField();
        contentPane.add(txtNascimento, "cell 2 1,growx");
        txtNascimento.setColumns(10);

        JLabel lblNacionalidade = new JLabel("Nacionalidade:");
        contentPane.add(lblNacionalidade, "cell 0 2");
        txtNacionalidade = new JTextField();
        contentPane.add(txtNacionalidade, "cell 0 3,growx");
        txtNacionalidade.setColumns(10);

        JLabel lblNumeroPassaporte = new JLabel("Número do Passaporte:");
        contentPane.add(lblNumeroPassaporte, "cell 2 2");
        txtPassaporte = new JTextField();
        contentPane.add(txtPassaporte, "cell 2 3,growx");
        txtPassaporte.setColumns(10);

        JLabel lblDataCheckIn = new JLabel("Data de Check-In:");
        contentPane.add(lblDataCheckIn, "cell 0 4");
        txtCheckIn = new JTextField();
        contentPane.add(txtCheckIn, "cell 0 5,growx");
        txtCheckIn.setColumns(10);

        JLabel lblDataCheckOut = new JLabel("Data de Check-Out:");
        contentPane.add(lblDataCheckOut, "cell 2 4");
        txtCheckOut = new JTextField();
        contentPane.add(txtCheckOut, "cell 2 5,growx");
        txtCheckOut.setColumns(10);

        JLabel lblNumeroQuarto = new JLabel("Número do Quarto:");
        contentPane.add(lblNumeroQuarto, "cell 0 6");
        txtNumeroQuarto = new JTextField();
        contentPane.add(txtNumeroQuarto, "cell 0 7,growx");
        txtNumeroQuarto.setColumns(10);

        JLabel lblTotalPago = new JLabel("Total Pago:");
        contentPane.add(lblTotalPago, "cell 2 6");
        txtTotalPago = new JTextField();
        contentPane.add(txtTotalPago, "cell 2 7,growx");
        txtTotalPago.setColumns(10);

        JLabel lblEmailHospede = new JLabel("E-mail do Hóspede:");
        contentPane.add(lblEmailHospede, "cell 0 8");
        txtEmail = new JTextField();
        contentPane.add(txtEmail, "cell 0 9,growx");
        txtEmail.setColumns(10);

        JLabel lblTelefone = new JLabel("Número de Telefone:");
        contentPane.add(lblTelefone, "cell 2 8");
        txtTelefone = new JTextField();
        contentPane.add(txtTelefone, "cell 2 9,growx");
        txtTelefone.setColumns(10);

        JLabel lblEndereco = new JLabel("Endereço:");
        contentPane.add(lblEndereco, "cell 0 10");
        txtEndereco = new JTextField();
        contentPane.add(txtEndereco, "cell 0 11,growx");
        txtEndereco.setColumns(10);

        JLabel lblPessoasReserva = new JLabel("Número de Pessoas na Reserva:");
        contentPane.add(lblPessoasReserva, "cell 2 10");
        txtNumeroPessoas = new JTextField();
        contentPane.add(txtNumeroPessoas, "cell 2 11,growx");
        txtNumeroPessoas.setColumns(10);

        JLabel lblSolicitacoesEspeciais = new JLabel("Solicitações Especiais:");
        contentPane.add(lblSolicitacoesEspeciais, "cell 0 12");
        txtSolicitacoesEspeciais = new JTextField();
        contentPane.add(txtSolicitacoesEspeciais, "cell 0 13,growx");
        txtSolicitacoesEspeciais.setColumns(10);

        JLabel lblAvaliacao = new JLabel("Avaliação do Hóspede:");
        contentPane.add(lblAvaliacao, "cell 2 12");
        JComboBox<Integer> comboBoxAvaliacao = new JComboBox<Integer>();
        comboBoxAvaliacao.addItem(0);
		comboBoxAvaliacao.addItem(1);
		comboBoxAvaliacao.addItem(2);
		comboBoxAvaliacao.addItem(3);
		comboBoxAvaliacao.addItem(4);
		comboBoxAvaliacao.addItem(5);
        contentPane.add(comboBoxAvaliacao , "cell 2 13,growx");
        
        JCheckBox chckbxlimpaCampo = new JCheckBox("Limpar campos");
        chckbxlimpaCampo.setSelected(true);
        contentPane.add(chckbxlimpaCampo, "cell 0 14");

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Hospede novoHospede = new Hospede();
                novoHospede.setNome(txtNome.getText());
                novoHospede.setNascimento(LocalDate.parse(txtNascimento.getText(), formatter));
                novoHospede.setNacionalidade(txtNacionalidade.getText());
                novoHospede.setPassaporte(txtPassaporte.getText());
                novoHospede.setCheckIn(LocalDate.parse(txtCheckIn.getText(), formatter));
                novoHospede.setCheckOut(LocalDate.parse(txtCheckOut.getText(), formatter));
                novoHospede.setNumeroQuarto(Integer.parseInt(txtNumeroQuarto.getText()));
                novoHospede.setTotalPago(Double.parseDouble(txtTotalPago.getText()));
                novoHospede.setEmail(txtEmail.getText());
                novoHospede.setTelefone(txtTelefone.getText());
                novoHospede.setEndereco(txtEndereco.getText());
                novoHospede.setNumeroPessoas(Integer.parseInt(txtNumeroPessoas.getText()));
                novoHospede.setSolicitacoesEspeciais(txtSolicitacoesEspeciais.getText());
                Integer avaliacaoSelecionada = (Integer) comboBoxAvaliacao.getSelectedItem();
                novoHospede.setAvaliacao(avaliacaoSelecionada);

                listaHospedes.add(novoHospede);

                atualizarTabela();
                if (chckbxlimpaCampo.isSelected()) {
                    limparCampos();
                }
            }
        });
        Janela estaJanela = this;

        contentPane.add(btnAdicionar, "flowx,cell 0 14");

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicaoSelecionada = table.getSelectedRow();
				listaHospedes.remove(posicaoSelecionada);
				atualizarTabela();
                }
            }
        );
        contentPane.add(btnExcluir, "flowx,cell 2 14");

        JButton btnAlterar = new JButton("Alterar");
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int posicaoSelecionada = table.getSelectedRow();
                    Hospede pessoaSelecionada = listaHospedes.get(posicaoSelecionada);
                    JanelaAlterarHospede novaJanela = new JanelaAlterarHospede(estaJanela);
                    novaJanela.mostrarDados(pessoaSelecionada);
                    novaJanela.setVisible(true);
                    
                
                
            }
        });
        contentPane.add(btnAlterar, "cell 4 14");

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HospedeDAO pdao = new HospedeDAO();
                pdao.escreverArquivo(listaHospedes, "dados.dat");
                dispose();
            }
        });
        contentPane.add(btnFechar, "cell 6 14");

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, "cell 0 15 7 1,grow");

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Nome", "Data Nascimento", "Nacionalidade", "Número do Passaporte", "Data de Check-In", "Data de Check-Out", "Número do Quarto", "Total Pago", "E-mail", "Número de Telefone", "Endereço", "Número de Pessoas", "Solicitações Especiais", "Avaliação"
            }
        ));
        scrollPane.setViewportView(table);
        

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                HospedeDAO pdao = new HospedeDAO();
                pdao.escreverArquivo(listaHospedes, "dados.dat");
            }
        });

        atualizarTabela();
    }
    protected void limparCampos() {
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
    }

    protected void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Hospede h : listaHospedes) {
            model.addRow(new Object[]{
                    h.getNome(),
                    h.getNascimento().format(formatter),
                    h.getNacionalidade(),
                    h.getPassaporte(),
                    h.getCheckIn().format(formatter),
                    h.getCheckOut().format(formatter),
                    h.getNumeroQuarto(),
                    h.getTotalPago()+ "R$",
                    h.getEmail(),
                    h.getTelefone(),
                    h.getEndereco(),
                    h.getNumeroPessoas(),
                    h.getSolicitacoesEspeciais(),
                    h.getAvaliacao()
            });
        }
    }

}
