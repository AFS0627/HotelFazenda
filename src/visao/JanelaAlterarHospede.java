package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.border.EmptyBorder;
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
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    /**
     * Create the frame.
     */
    public JanelaAlterarHospede(Janela janelaPrincipal) {
        setTitle("Alteração");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][][][][][grow]", "[][][][][][][][][][][][][][][]"));

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
        comboBoxAvaliacao = new JComboBox<Integer>();
        comboBoxAvaliacao.addItem(0);
        comboBoxAvaliacao.addItem(1);
        comboBoxAvaliacao.addItem(2);
        comboBoxAvaliacao.addItem(3);
        comboBoxAvaliacao.addItem(4);
        comboBoxAvaliacao.addItem(5);
        contentPane.add(comboBoxAvaliacao, "cell 1 13 3 1,growx");

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    hospedeSelecionado.setNome(txtNome.getText());
                    hospedeSelecionado.setNascimento(LocalDate.parse(txtNascimento.getText(), dateFormatter));
                    hospedeSelecionado.setNacionalidade(txtNacionalidade.getText());
                    hospedeSelecionado.setPassaporte(txtPassaporte.getText());
                    hospedeSelecionado.setCheckIn(LocalDate.parse(txtCheckIn.getText(), dateFormatter));
                    hospedeSelecionado.setCheckOut(LocalDate.parse(txtCheckOut.getText(), dateFormatter));
                    hospedeSelecionado.setNumeroQuarto(Integer.parseInt(txtNumeroQuarto.getText()));
                    hospedeSelecionado.setTotalPago(Double.parseDouble(txtTotalPago.getText()));
                    hospedeSelecionado.setEmail(txtEmail.getText());
                    hospedeSelecionado.setTelefone(txtTelefone.getText());
                    hospedeSelecionado.setEndereco(txtEndereco.getText());
                    hospedeSelecionado.setNumeroPessoas(Integer.parseInt(txtNumeroPessoas.getText()));
                    hospedeSelecionado.setSolicitacoesEspeciais(txtSolicitacoesEspeciais.getText());
                    Integer selectedItem = (Integer) comboBoxAvaliacao.getSelectedItem();
                    hospedeSelecionado.setAvaliacao(selectedItem);

                    janelaPrincipal.atualizarTabela();
                    dispose();
            }
        });
        
        contentPane.add(btnSalvar, "cell 1 14");

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        contentPane.add(btnCancelar, "cell 2 14");
    }

    public void mostrarDados(Hospede hospedeSelecionado) {
        this.hospedeSelecionado = hospedeSelecionado;
            txtNome.setText(hospedeSelecionado.getNome());
            txtNascimento.setText(hospedeSelecionado.getNascimento().format(dateFormatter));
            txtNacionalidade.setText(hospedeSelecionado.getNacionalidade());
            txtPassaporte.setText(hospedeSelecionado.getPassaporte());
            txtCheckIn.setText(hospedeSelecionado.getCheckIn().format(dateFormatter));
            txtCheckOut.setText(hospedeSelecionado.getCheckOut().format(dateFormatter));
            txtNumeroQuarto.setText(String.valueOf(hospedeSelecionado.getNumeroQuarto()));
            txtTotalPago.setText(String.valueOf(hospedeSelecionado.getTotalPago()));
            txtEmail.setText(hospedeSelecionado.getEmail());
            txtTelefone.setText(hospedeSelecionado.getTelefone());
            txtEndereco.setText(hospedeSelecionado.getEndereco());
            txtNumeroPessoas.setText(String.valueOf(hospedeSelecionado.getNumeroPessoas()));
            txtSolicitacoesEspeciais.setText(hospedeSelecionado.getSolicitacoesEspeciais());
            comboBoxAvaliacao.setSelectedItem(hospedeSelecionado.getAvaliacao());
       
    }
}
