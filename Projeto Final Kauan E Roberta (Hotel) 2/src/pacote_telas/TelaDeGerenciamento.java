package pacote_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import pacote_bd.Conexao;

import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class TelaDeGerenciamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;
	private JTextField caixaNome;
	private JTextField textField;
	private JTable tabela1;

	DefaultTableModel modelo = new DefaultTableModel();
	JFormattedTextField caixaID = new JFormattedTextField();
	private JTextField caixaEmail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeGerenciamento frame = new TelaDeGerenciamento();
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
	public TelaDeGerenciamento() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 549);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		SpringLayout sl_painelPrincipal = new SpringLayout();
		painelPrincipal.setLayout(sl_painelPrincipal);
		
		JDateChooser caixaDataSaida = new JDateChooser();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaDataSaida, 360, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaDataSaida, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaDataSaida, 224, SpringLayout.WEST, painelPrincipal);
		painelPrincipal.add(caixaDataSaida);
		
		JLabel labelDataSaida = new JLabel("Check-out");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelDataSaida, 341, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelDataSaida, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelDataSaida, 355, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelDataSaida, 112, SpringLayout.WEST, painelPrincipal);
		labelDataSaida.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(labelDataSaida);
		
		JDateChooser caixaDataEntrada = new JDateChooser();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaDataEntrada, 316, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaDataEntrada, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaDataEntrada, 224, SpringLayout.WEST, painelPrincipal);
		painelPrincipal.add(caixaDataEntrada);
		
		JLabel labelDataEntrada = new JLabel("Check-in");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelDataEntrada, 296, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelDataEntrada, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelDataEntrada, 310, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelDataEntrada, 166, SpringLayout.WEST, painelPrincipal);
		labelDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(labelDataEntrada);
		
		JPanel painel_1 = new JPanel();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, painel_1, 0, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, painel_1, 0, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, painel_1, 75, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, painel_1, 5, SpringLayout.EAST, painelPrincipal);
		painel_1.setBackground(Color.DARK_GRAY);
		painelPrincipal.add(painel_1);
		SpringLayout sl_painel_1 = new SpringLayout();
		painel_1.setLayout(sl_painel_1);
		
		JLabel labelTitulo = new JLabel("Gerenciamento de Clientes");
		labelTitulo.setForeground(Color.WHITE);
		sl_painel_1.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, painel_1);
		sl_painel_1.putConstraint(SpringLayout.SOUTH, labelTitulo, -20, SpringLayout.SOUTH, painel_1);
		sl_painel_1.putConstraint(SpringLayout.EAST, labelTitulo, -67, SpringLayout.EAST, painel_1);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		sl_painel_1.putConstraint(SpringLayout.WEST, labelTitulo, 67, SpringLayout.WEST, painel_1);
		painel_1.add(labelTitulo);
		
		JLabel labelFechar = new JLabel("X");
		labelFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		sl_painel_1.putConstraint(SpringLayout.NORTH, labelFechar, 0, SpringLayout.NORTH, painel_1);
		sl_painel_1.putConstraint(SpringLayout.SOUTH, labelFechar, -30, SpringLayout.SOUTH, painel_1);
		labelFechar.setHorizontalAlignment(SwingConstants.CENTER);
		labelFechar.setForeground(Color.WHITE);
		labelFechar.setFont(new Font("Tahoma", Font.BOLD, 20));
		sl_painel_1.putConstraint(SpringLayout.WEST, labelFechar, -40, SpringLayout.EAST, painel_1);
		sl_painel_1.putConstraint(SpringLayout.EAST, labelFechar, 0, SpringLayout.EAST, painel_1);
		painel_1.add(labelFechar);
		
		JLabel labelNome = new JLabel("Nome Completo:");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelNome, 86, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelNome, 30, SpringLayout.WEST, painelPrincipal);
		labelNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(labelNome);
		
		caixaNome = new JTextField();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaNome, 106, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaNome, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaNome, 352, SpringLayout.WEST, painelPrincipal);
		caixaNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		painelPrincipal.add(caixaNome);
		caixaNome.setColumns(10);
		
		JLabel labelID = new JLabel("ID:");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelID, 132, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelID, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelID, 146, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelID, 76, SpringLayout.WEST, painelPrincipal);
		labelID.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(labelID);
		
		JLabel labelCPF = new JLabel("CPF:");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelCPF, 171, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelCPF, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelCPF, 185, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelCPF, 76, SpringLayout.WEST, painelPrincipal);
		labelCPF.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(labelCPF);
		
		MaskFormatter formatoCPF = new MaskFormatter("###.###.###-##");
		formatoCPF.setPlaceholder("000.000.000-00");
		JFormattedTextField caixaCPF = new JFormattedTextField(formatoCPF);
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaCPF, 186, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaCPF, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, caixaCPF, 205, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaCPF, 184, SpringLayout.WEST, painelPrincipal);
		caixaCPF.setFont(new Font("Tahoma", Font.BOLD, 11));
		painelPrincipal.add(caixaCPF);
		
		JLabel labelCelular = new JLabel("Nº Celular:");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelCelular, 210, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelCelular, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelCelular, 124, SpringLayout.WEST, painelPrincipal);
		labelCelular.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(labelCelular);
		
		MaskFormatter formatoCelular = new MaskFormatter("+##(##)#####-####");
		formatoCelular.setPlaceholder("+00(00)00000-0000");
		JFormattedTextField caixaCelular = new JFormattedTextField(formatoCelular);
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaCelular, 228, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaCelular, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, caixaCelular, 247, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaCelular, 224, SpringLayout.WEST, painelPrincipal);
		caixaCelular.setFont(new Font("Tahoma", Font.BOLD, 11));
		painelPrincipal.add(caixaCelular);
		
		JLabel labelReserva = new JLabel("Reservas:");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelReserva, 252, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelReserva, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, labelReserva, 266, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, labelReserva, 112, SpringLayout.WEST, painelPrincipal);
		labelReserva.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(labelReserva);
		
		JComboBox comboReserva = new JComboBox();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, comboReserva, 270, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, comboReserva, 30, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, comboReserva, 292, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, comboReserva, 224, SpringLayout.WEST, painelPrincipal);
		painelPrincipal.add(comboReserva);
		comboReserva.addItem("Selecione");
		comboReserva.addItem("Solteiro");
		comboReserva.addItem("Casal");
		comboReserva.addItem("Apartamento");
		comboReserva.addItem("Suíte Presidencial");
		
		textField = new JTextField();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, textField, 148, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, textField, 30, SpringLayout.WEST, painelPrincipal);
		painelPrincipal.add(textField);
		textField.setColumns(10);
		
		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelEmail, 6, SpringLayout.SOUTH, caixaDataSaida);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelEmail, 0, SpringLayout.WEST, caixaDataSaida);
		painelPrincipal.add(labelEmail);
		
		caixaEmail = new JTextField();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaEmail, 6, SpringLayout.SOUTH, labelEmail);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaEmail, 0, SpringLayout.WEST, labelEmail);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaEmail, 0, SpringLayout.EAST, caixaDataSaida);
		painelPrincipal.add(caixaEmail);
		caixaEmail.setColumns(10);
		
		JLabel labelData = new JLabel("Data de Nascimento:");
		labelData.setFont(new Font("Tahoma", Font.BOLD, 15));
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, labelData, 6, SpringLayout.SOUTH, caixaNome);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, labelData, 47, SpringLayout.EAST, textField);
		painelPrincipal.add(labelData);
		
		JDateChooser caixaData = new JDateChooser();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, caixaData, 6, SpringLayout.SOUTH, labelData);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, caixaData, 0, SpringLayout.WEST, labelData);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, caixaData, 0, SpringLayout.EAST, labelData);
		painelPrincipal.add(caixaData);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, scrollPane, 123, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, scrollPane, 377, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, scrollPane, 462, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, painelPrincipal);
		painelPrincipal.add(scrollPane);
		
		Object[] titulos = {"ID", "CPF", "Nome Completo", "Nº Celular", "Tipo de Quarto", "Data de Entrada", "Data de Saída", "Email", "Data de Nascimento"};
		
		modelo.setColumnIdentifiers(titulos);
		
		Object[] linhas = new Object[9];
		

		tabela1 = new JTable();
		scrollPane.setViewportView(tabela1);
		
		tabela1.setModel(modelo);
		
		String sql = "select * from tb_clientes";
		
		Conexao novaConexao = new Conexao();
		Connection conectar = novaConexao.getConexao();
		PreparedStatement preparar = null;
		ResultSet resultados = null;
		
		try {
			preparar = conectar.prepareStatement(sql);
			resultados = preparar.executeQuery();
			
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, 
					"Falha ao consultar: "+erro.getMessage());
		}
		
		try {
			while(resultados.next()) {
				linhas[0] = resultados.getString("id_cliente");
				linhas[1] = resultados.getString("nome_cliente");
				linhas[2] = resultados.getString("cpf_cliente");
				linhas[3] = resultados.getString("celular_cliente");
				linhas[4] = resultados.getString("tipo_quarto");
				linhas[5] = resultados.getString("data_entrada");
				linhas[6] = resultados.getString("data_saida");
				linhas[7] = resultados.getString("email_cliente");
				linhas[8] = resultados.getString("data_nascimento");
				modelo.addRow(linhas);
				
			}
		}catch(Exception erro) {
			JOptionPane.showMessageDialog(null, 
					"Falha ao mostrar resultados: "+erro.getMessage());
		}
		
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, btnAtualizar, 472, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, btnAtualizar, 100, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.SOUTH, btnAtualizar, 88, SpringLayout.NORTH, caixaEmail);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, btnAtualizar, 270, SpringLayout.WEST, painelPrincipal);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = caixaID.getText();
				String cpf = caixaCPF.getText();
				String nome = caixaNome.getText();
				String celular = caixaCelular.getText();
				String tipo_quarto = comboReserva.getSelectedItem().toString();
				String email = caixaEmail.getText();
				String data;
				String data_entrada;
				String data_saida;
				
				SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatoData_entrada = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat formatoData_saida = new SimpleDateFormat("yyyy-MM-dd");
				
				data = formatoData.format(caixaData.getDate());
				data_entrada = formatoData_entrada.format(caixaDataEntrada.getDate());
				data_saida = formatoData_saida.format(caixaDataSaida.getDate());
				
				
				String sql = "update tb_clientes "
						+ "set nome_cliente=?, cpf_cliente=?, "
						+ "email_cliente=?, data_entrada=?, "
						+ "data_saida=?, tipo_quarto=?,  "
						+ "celular_cliente=?, data_nascimento=? "
						+ "where id_cliente=?";
						
				
				dispose();
				TelaDeGerenciamento t1 = null;
				try {
					t1 = new TelaDeGerenciamento();
				}catch(ParseException e1) {
					
					e1.printStackTrace();
				}
						
				t1.setVisible(true);
				
				Conexao novaConexao = new Conexao();
				Connection conectar = novaConexao.getConexao();
				PreparedStatement preparar = null;
				ResultSet resultados = null;
				
				try {
					preparar = conectar.prepareStatement(sql);
					preparar.setString(1, nome);
					preparar.setString(2, cpf);
					preparar.setString(3, email);
					preparar.setString(4, data_entrada);
					preparar.setString(5, data_saida);
					preparar.setString(6, tipo_quarto);
					preparar.setString(7, celular);
					preparar.setString(8, data);
					preparar.setString(9, id);
					preparar.execute();
					dispose();
					TelaDeGerenciamento t2 = new TelaDeGerenciamento();
					t2.setVisible(true);
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
					
					
					
				}catch(Exception erro ) {
					JOptionPane.showMessageDialog(null, 
							"Falha ao autualizar" +erro.getMessage());
				}
						
				
				
				
				
				
			}
		});
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setBackground(new Color(25, 25, 112));
		btnAtualizar.setBorderPainted(false);
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(btnAtualizar);
		
		JButton btnExcluir = new JButton("Excluir");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, btnExcluir, 472, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, btnExcluir, 300, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, btnExcluir, 470, SpringLayout.WEST, painelPrincipal);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = caixaID.getText();
				
				String sql = "delete from tb_clientes " 
				+ "where id_cliente=?";
				
				Conexao novaConexao = new Conexao();
				Connection conectar = novaConexao.getConexao();
				PreparedStatement preparar = null;
				ResultSet resultados = null;
				
				try {
					preparar = conectar.prepareStatement(sql);
					preparar.setString(1, id);
					int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir? ");
					
					if(opcao == 0) {
						preparar.execute();
						dispose();
						TelaDeGerenciamento t1 = new TelaDeGerenciamento();
						t1.setVisible(true);
					}
						
					
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Falha ao excluir: "+erro.getMessage());
				}
				
				
			}
		});
		btnExcluir.setForeground(new Color(255, 255, 255));
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBackground(new Color(255, 0, 0));
		btnExcluir.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		sl_painelPrincipal.putConstraint(SpringLayout.NORTH, btnVoltar, 472, SpringLayout.NORTH, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.WEST, btnVoltar, 500, SpringLayout.WEST, painelPrincipal);
		sl_painelPrincipal.putConstraint(SpringLayout.EAST, btnVoltar, 700, SpringLayout.WEST, painelPrincipal);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				TelaDeCadastro t1 = null;
				try {
					t1 = new TelaDeCadastro();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				t1.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setBorderPainted(false);
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 15));
		painelPrincipal.add(btnVoltar);
		
		
	}
}
