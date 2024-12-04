package pacote_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

import pacote_bd.Conexao;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDeCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;
	private JTextField caixaNome;
	private JTextField caixaEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastro frame = new TelaDeCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaDeCadastro() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 545);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		SpringLayout sl_painelPrincipal = new SpringLayout();
		painelPrincipal.setLayout(sl_painelPrincipal);
		
		JPanel painel_1 = new JPanel();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, painel_1, -5, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, painel_1, 340, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, painel_1, 60, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, painel_1, 5, SpringLayout.EAST, painelPrincipal);
		painel_1.setBackground(Color.DARK_GRAY);
		painelPrincipal.add(painel_1);
		SpringLayout sl_painel_1 = new SpringLayout();
		painel_1.setLayout(sl_painel_1);
		
		JLabel labelTitulo = new JLabel("Cad.Cliente");
		sl_painel_1.putConstraint(SpringLayout.NORTH, labelTitulo, 15, SpringLayout.NORTH, painel_1);
		sl_painel_1.putConstraint(SpringLayout.WEST, labelTitulo, 100, SpringLayout.WEST, painel_1);
		sl_painel_1.putConstraint(SpringLayout.SOUTH, labelTitulo, -15, SpringLayout.SOUTH, painel_1);
		sl_painel_1.putConstraint(SpringLayout.EAST, labelTitulo, -100, SpringLayout.EAST, painel_1);
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		painel_1.add(labelTitulo);
		
		JLabel labelImagem = new JLabel("");
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelImagem, 5, SpringLayout.SOUTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelImagem, 0, SpringLayout.WEST, painel_1);
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelImagem, -5, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelImagem, -5, SpringLayout.WEST, painelPrincipal);
		labelImagem.setIcon(new ImageIcon(TelaDeCadastro.class.getResource("/pacote_imagens/WhatsApp Image 2023-12-05 at 14.43.55.jpeg")));
		painelPrincipal.add(labelImagem);
		
		JLabel labelNome = new JLabel("Nome Completo:");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelNome, 24, SpringLayout.SOUTH, painel_1);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelNome, 17, SpringLayout.EAST, labelImagem);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelNome, 51, SpringLayout.SOUTH, painel_1);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, labelTitulo);
		sl_painel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, painel_1);
		painel_1.add(lblNewLabel);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelNome, 193, SpringLayout.EAST, labelImagem);
		labelNome.setForeground(new Color(0, 0, 0));
		labelNome.setFont(new Font("Tahoma", Font.BOLD, 20));
		painelPrincipal.add(labelNome);
		
		caixaNome = new JTextField();
		caixaNome.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaNome, 6, SpringLayout.SOUTH, labelNome);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaNome, 0, SpringLayout.WEST, labelNome);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaNome, 45, SpringLayout.EAST, labelNome);
		painelPrincipal.add(caixaNome);
		caixaNome.setColumns(10);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelCPF, 6, SpringLayout.SOUTH, caixaNome);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelCPF, 0, SpringLayout.WEST, labelNome);
		painelPrincipal.add(labelCPF);
		
		MaskFormatter formatoCPF = new MaskFormatter("###.###.###-##");
		formatoCPF.setPlaceholder("000.000.000-00");
		JFormattedTextField caixaCPF = new JFormattedTextField(formatoCPF);
		caixaCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaCPF, 6, SpringLayout.SOUTH, labelCPF);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaCPF, 17, SpringLayout.EAST, labelImagem);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, caixaCPF, 26, SpringLayout.SOUTH, labelCPF);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaCPF, 238, SpringLayout.EAST, labelImagem);
		painelPrincipal.add(caixaCPF);
		
		JLabel labelData = new JLabel("Data de Nascimento:");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelData, 6, SpringLayout.SOUTH, caixaCPF);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelData, 0, SpringLayout.WEST, labelCPF);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelData, -10, SpringLayout.EAST, caixaCPF);
		labelData.setFont(new Font("Tahoma", Font.BOLD, 20));
		painelPrincipal.add(labelData);
		
		JDateChooser caixaData = new JDateChooser();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaData, 6, SpringLayout.SOUTH, labelData);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaData, 0, SpringLayout.WEST, labelNome);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaData, 0, SpringLayout.EAST, labelData);
		painelPrincipal.add(caixaData);
		
		JLabel labelCelular = new JLabel("Celular:");
		labelCelular.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelCelular, 6, SpringLayout.SOUTH, caixaData);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelCelular, 0, SpringLayout.WEST, labelNome);
		painelPrincipal.add(labelCelular);
		
		MaskFormatter formatoCelular = new MaskFormatter("+##(##)#####-####");
		formatoCelular.setPlaceholder("+00(00)00000-0000");
		JFormattedTextField caixaCelular = new JFormattedTextField(formatoCelular);
		caixaCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaCelular, 6, SpringLayout.SOUTH, labelCelular);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaCelular, 17, SpringLayout.EAST, labelImagem);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, caixaCelular, 26, SpringLayout.SOUTH, labelCelular);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaCelular, 0, SpringLayout.EAST, caixaNome);
		painelPrincipal.add(caixaCelular);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelEmail, 6, SpringLayout.SOUTH, caixaCelular);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelEmail, 0, SpringLayout.WEST, labelNome);
		painelPrincipal.add(labelEmail);
		
		caixaEmail = new JTextField();
		caixaEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaEmail, 3, SpringLayout.SOUTH, labelEmail);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaEmail, 0, SpringLayout.WEST, caixaNome);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaEmail, 0, SpringLayout.EAST, caixaNome);
		painelPrincipal.add(caixaEmail);
		caixaEmail.setColumns(10);
		
		JLabel labelReservas = new JLabel("Reservas:");
		labelReservas.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelReservas, 0, SpringLayout.NORTH, labelNome);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelReservas, 91, SpringLayout.EAST, labelNome);
		painelPrincipal.add(labelReservas);
		
		JComboBox comboReserva = new JComboBox();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, comboReserva, 5, SpringLayout.SOUTH, labelReservas);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, comboReserva, 0, SpringLayout.WEST, labelReservas);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, comboReserva, 30, SpringLayout.EAST, labelReservas);
		painelPrincipal.add(comboReserva);
		comboReserva.addItem("Selecione");
		comboReserva.addItem("Solteiro");
		comboReserva.addItem("Casal");
		comboReserva.addItem("Apartamento");
		comboReserva.addItem("Suíte Presidencial");
		
		JLabel labelCheckin = new JLabel("Check-in");
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, comboReserva, -20, SpringLayout.SOUTH, labelCheckin);
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelCheckin, 5, SpringLayout.SOUTH, comboReserva);
		labelCheckin.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelCheckin, 0, SpringLayout.WEST, labelReservas);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelCheckin, 0, SpringLayout.SOUTH, labelCPF);
		painelPrincipal.add(labelCheckin);
		
		JDateChooser caixaDataEntrada = new JDateChooser();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaDataEntrada, 0, SpringLayout.NORTH, caixaCPF);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaDataEntrada, 0, SpringLayout.WEST, labelReservas);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaDataEntrada, 0, SpringLayout.EAST, comboReserva);
		painelPrincipal.add(caixaDataEntrada);
		
		JLabel labelDataSaida = new JLabel("Check-out");
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, caixaDataEntrada, -25, SpringLayout.SOUTH, labelDataSaida);
		labelDataSaida.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelDataSaida, 0, SpringLayout.WEST, labelReservas);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelDataSaida, 0, SpringLayout.SOUTH, labelData);
		painelPrincipal.add(labelDataSaida);
		
		JDateChooser caixaDataSaida = new JDateChooser();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaDataSaida, 0, SpringLayout.NORTH, caixaData);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaDataSaida, 0, SpringLayout.WEST, labelReservas);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, caixaDataSaida, 30, SpringLayout.SOUTH, labelDataSaida);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaDataSaida, 0, SpringLayout.EAST, caixaDataEntrada);
		painelPrincipal.add(caixaDataSaida);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCadastrar.setBackground(new Color(0, 100, 0));
		btnCadastrar.setBorderPainted(false);
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, btnCadastrar, -120, SpringLayout.SOUTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, btnCadastrar, -70, SpringLayout.SOUTH, painelPrincipal);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = caixaNome.getText();
				String cpf = caixaCPF.getText();
				String celular = caixaCelular.getText();
				String email = caixaEmail.getText();
				String reservas = comboReserva.getSelectedItem().toString();
				String data;
				String data_entrada;
				String data_saida;
				
				SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
				data = formatoData.format(caixaData.getDate());
				
				SimpleDateFormat formatoDta_entrada = new SimpleDateFormat("yyyy-MM-dd");
				data_entrada = formatoDta_entrada.format(caixaDataEntrada.getDate());
				
				SimpleDateFormat formatoDta_saida = new SimpleDateFormat("yyyy-MM-dd");
				data_saida = formatoDta_saida.format(caixaDataSaida.getDate());
				
		
				String sql = "insert into tb_clientes "
						+ "(nome_cliente, cpf_cliente, "
						+ "data_nascimento, celular_cliente, "
						+ "email_cliente, data_entrada, "
						+ "data_saida, tipo_quarto) "
						+ "values"
						+ "(?, ?, ?, ?, ?, ?, ?, ?)";
				
				
				Conexao novaConexao = new Conexao();
				Connection conectar = novaConexao.getConexao();
				PreparedStatement preparar = null;
				ResultSet resultados = null;
				
				try {
					preparar = conectar.prepareStatement(sql);
					preparar.setString(1, nome);
					preparar.setString(2, cpf);
					preparar.setString(3, data);
					preparar.setString(4, celular);
					preparar.setString(5, email);
					preparar.setString(6, data_entrada);
					preparar.setString(7, data_saida);
					preparar.setString(8, reservas);
					preparar.execute();
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					
					dispose();
					TelaDeGerenciamento t1 = new TelaDeGerenciamento();
					t1.setVisible(true);
					t1.setLocationRelativeTo(null);
					
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar! "+erro.getMessage());
				}
				
				
			}
		});
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, btnCadastrar, 0, SpringLayout.WEST, labelNome);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, btnCadastrar, 0, SpringLayout.EAST, caixaEmail);
		painelPrincipal.add(btnCadastrar);
	}
}
