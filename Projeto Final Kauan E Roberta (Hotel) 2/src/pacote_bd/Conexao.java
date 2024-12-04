package pacote_bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private String maquina ="localhost";
	private String banco = "bd_hotel";
	private String usuario = "root";
	private String senha = "root";
	private int porta = 3306;
	private Connection conectar;
	
	public Conexao() {
		
		try {
			String url = "jdbc:mysql://"+maquina+":"+porta+"/"+banco;
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conectar = DriverManager.getConnection(url,usuario,senha);
			System.out.println("Banco de dados conectado!");
			
		}catch(Exception erro) {
			System.out.println("Falha ao conectar no BD: "+erro.getMessage());			
		}
		
	}//fim do construtor
	
	public Connection getConexao() {
		return this.conectar;
	}
	
	public void finalizarConexao() {
		try {
			conectar.close();
		}catch(Exception erro) {
			System.out.println("Falha ao encerrar conexao! "+erro.getMessage());
		}
	}//fim do m�todo finalizarConexao	
	
}
