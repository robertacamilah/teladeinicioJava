package pacote_telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pacote_telas.TelaDeCadastro;

import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

public class LoginHotel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;
	private JTextField caixaLogin;
	private JPasswordField caixaSenha;
	JLabel labelMensagem = new JLabel("Usuário e/ou senha incorretos!");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginHotel frame = new LoginHotel();
					frame.setVisible(true);
					//Comando para centralizar a tela
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginHotel() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 493);
		painelPrincipal = new JPanel();
		painelPrincipal.setBackground(Color.LIGHT_GRAY);
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JLabel labelImagem = new JLabel("");
		labelImagem.setBounds(-11, -13, 420, 508);
		labelImagem.setIcon(new ImageIcon(LoginHotel.class.getResource("/pacote_imagens/habbo.jpg")));
		painelPrincipal.add(labelImagem);
		
		JLabel labelLogin = new JLabel("Usuário:");
		labelLogin.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		labelLogin.setBounds(467, 134, 67, 16);
		painelPrincipal.add(labelLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_1.setBounds(467, 200, 61, 16);
		painelPrincipal.add(lblNewLabel_1);
		
		caixaLogin = new JTextField();
		caixaLogin.setHorizontalAlignment(SwingConstants.CENTER);
		caixaLogin.setBounds(467, 162, 168, 26);
		painelPrincipal.add(caixaLogin);
		caixaLogin.setColumns(10);
		
		caixaSenha = new JPasswordField();
		caixaSenha.setHorizontalAlignment(SwingConstants.CENTER);
		caixaSenha.setBounds(467, 228, 168, 26);
		painelPrincipal.add(caixaSenha);
		
		
		labelMensagem.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		labelMensagem.setForeground(Color.RED);
		labelMensagem.setBounds(477, 266, 158, 16);
		painelPrincipal.add(labelMensagem);
		labelMensagem.setVisible(false);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = caixaLogin.getText();
				String senha = new String(caixaSenha.getPassword());
				
				if(usuario.equals("admin") && senha.equals("123456")){
					//Fechar tela de Login
					dispose();
					TelaDeCadastro t1 = null;
					try {
						t1 = new TelaDeCadastro();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					t1.setVisible(true);
					t1.setLocationRelativeTo(null);
				}else {
					labelMensagem.setVisible(true);
					
				}
				
			}
		});
		btnEntrar.setBounds(487, 294, 117, 35);
		painelPrincipal.add(btnEntrar);
		
		JLabel labelFecharTela = new JLabel("X");
		labelFecharTela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Fechar a Tela
				dispose();
			}
		});
		labelFecharTela.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelFecharTela.setBounds(672, 6, 15, 16);
		painelPrincipal.add(labelFecharTela);
	}
}
