
public class TesteConexao {

	public static void main(String[] args) {

		// Conexao conn = null;
		try (Conexao con = new Conexao()) {
			con.leDados();
		} catch (IllegalStateException ex) {
			System.out.println("Deu erro na conexão.");
		}

		// } catch (IllegalStateException ex) {
		// System.out.println("Deu erro na conexão.");
		// }finally {
		// System.out.println("Finally.");
		// if (con!= null) {
		// con.close();
		// }
		// }

		/*
		 * Conexao conn = null; try { conn = new Conexao(); conn.leDados(); } catch
		 * (IllegalStateException ex) { System.out.println("Deu erro na conexão.");
		 * }finally { conn.fecha(); }
		 */
	}
}
