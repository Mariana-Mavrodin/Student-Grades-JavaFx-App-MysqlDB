package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

/**
 * @author Mavrodin Mariana
 * Grupa: 435
 * Serie: C
 * Specializare: TST
 */
public class DBOperations {
	String error;
	Connection con;

	public DBOperations() {
	}

	public void connect() throws ClassNotFoundException, SQLException, Exception 
	{
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect?useSSL=false",
				 "root", "paste.bronzate18");
		 } catch (ClassNotFoundException cnfe) {
			 error = "ClassNotFoundException: Nu s-a gasit driverul bazei de date.";
			 throw new ClassNotFoundException(error);
		 } catch (SQLException cnfe) {
			 error = "SQLException: Nu se poate conecta la baza de date.";
			 throw new SQLException(error);
		 } catch (Exception e) {
			 error = "Exception: A aparut o exceptie neprevazuta in timp ce se stabilea legatura la baza de date.";
			 throw new Exception(error);
		 }
    }
	
	public void disconnect() throws SQLException {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException sqle) {
			error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
			throw new SQLException(error);
		}
	}
	
	public ResultSet incarcareStudentiOperatieBD() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select s.idstudent as '" + Student.coloanaId 
					+ "', s.nume as '" + Student.coloanaNume 
					+ "', s.prenume as '" + Student.coloanaPrenume 
					+ "', s.grupa as '" + Student.coloanaGrupa 
					+ "', s.serie as '" + Student.coloanaSerie 
					+ "', s.an as '" + Student.coloanaAn 
					+ "', s.specializare as '" + Student.coloanaSpecializare 
					+ "' from studenti s;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	
		return rs;
	}
	
	public ResultSet incarcareEvaluariOperatieBD() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("SELECT s.idstudent as '" + Evaluare.coloanaId 
					+ "', s.nume as '" + Evaluare.coloanaNumeStudent
					+ "', s.prenume as '" + Evaluare.coloanaPrenumeStudent 
					+ "', e_partial.punctajobtinut as '" + Evaluare.coloanaPunctajObtinutPartial
					+ "', e_examen.punctajobtinut as '" + Evaluare.coloanaPunctajObtinutExamen 
					+ "', e_colocviu.punctajobtinut as '" + Evaluare.coloanaPunctajObtinutColocviu 
					+ "', m.denumire as '" + Evaluare.coloanaDenumireMaterie
					+ "' from evaluari e_partial "
					+ "join studenti s ON e_partial.idstudent = s.idstudent "
					+ "join subiecte sb_partial ON e_partial.idsubiect = sb_partial.idsubiect "
					+ "join materii m ON sb_partial.idmaterie = m.idmaterie "
					+ "join evaluari e_examen ON e_examen.idstudent = e_partial.idstudent "
					+ "join subiecte sb_examen ON e_examen.idsubiect = sb_examen.idsubiect "
					+ "join evaluari e_colocviu ON e_colocviu.idstudent = e_partial.idstudent "
					+ "join subiecte sb_colocviu ON e_colocviu.idsubiect = sb_colocviu.idsubiect "
					+ "where sb_partial.tip = 'partial' AND sb_partial.idmaterie = sb_examen.idmaterie AND sb_examen.tip = 'examen' "
					+ "AND sb_partial.idmaterie = sb_colocviu.idmaterie AND sb_colocviu.tip = 'colocviu';");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
		return rs;
	}

	public ResultSet incarcareSubiecteOperatieBD() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("SELECT m.idmaterie as '" + Subiect.coloanaIdMaterie 
					+ "', m.denumire as '" + Subiect.coloanaDenumireMaterie
					+ "', s1.punctaj as '" + Subiect.coloanaPunctajPartial
					+ "', s2.punctaj as '" + Subiect.coloanaPunctajExamen
					+ "', s3.punctaj as '" + Subiect.coloanaPunctajColocviu
					+ "' FROM `proiect`.`materii` as m " 
					+ "JOIN `proiect`.`subiecte` as s1 on m.idmaterie = s1.idmaterie "
					+ "JOIN `proiect`.`subiecte` as s2 on m.idmaterie = s2.idmaterie "
					+ "JOIN `proiect`.`subiecte` as s3 on m.idmaterie = s3.idmaterie "
					+ "WHERE s1.tip = 'partial' AND s2.tip = 'examen' AND s3.tip='colocviu';");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error); 
		}
		return rs; 
	}
	
	public ResultSet incarcareMateriiOperatieBD() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String queryString = ("select m.idmaterie as '" + Materie.coloanaId 
					+ "', m.denumire as '" + Materie.coloanaDenumire
					+ "', m.profesor as '" + Materie.coloanaProfesor 
					+ "', m.punctecredit as '" + Materie.coloanaPuncteCredit 
					+ "' from materii m;");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	
		return rs;
	}
	
	public void adaugareStudentOperatieBD(String nume, String prenume, Integer grupa, String serie, Integer an, String specializare) 
			throws SQLException, Exception {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO studenti (nume, prenume, grupa, serie, an, specializare) "
					+ "VALUES ('" + nume + "', '" + prenume + "', " + grupa + " , '" + serie + "', " + an + " , '" + specializare + "');");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}
	
	public void adaugareEvaluareOperatieBD(String nume, String prenume, Integer pctObtPartial, Integer pctObtExamen, Integer pctObtColocviu, String materie) 
			throws SQLException, Exception {
		Integer idSubiectPartial = null;
		Integer idSubiectExamen = null;
		Integer idSubiectColocviu = null;
		Integer idMaterie = null;
		Integer idStudent = null; 
		try {
			//pas 1- obtin idMaterie
			ResultSet rs = null;
			Statement stmtForIdMaterie;
			stmtForIdMaterie = con.createStatement();
			rs = stmtForIdMaterie.executeQuery("SELECT idmaterie FROM materii WHERE denumire = '" + materie + "';");
			rs.next();
			idMaterie = rs.getInt("idmaterie");
			
			//pas 2 - obtin idSubiectPartial pentru tip='Partial' cu idMaterie din statement
			
			ResultSet rs1 = null;
			Statement stmtForIdSubiectPartial;
			stmtForIdSubiectPartial = con.createStatement();
			rs1 = stmtForIdSubiectPartial.executeQuery("SELECT idsubiect FROM subiecte WHERE tip = 'partial' and idmaterie = " + idMaterie + " ;");
			rs1.next();
			idSubiectPartial = rs1.getInt("idsubiect");
			
			//pas 3-  obtin idSubiectExamen pentru tip='Examen' cu idMaterie din statement
			
			ResultSet rs2 = null;
			Statement stmtForIdSubiectExamen;
			stmtForIdSubiectExamen = con.createStatement();
			rs2 = stmtForIdSubiectExamen.executeQuery("SELECT idsubiect FROM subiecte WHERE tip = 'examen' and idmaterie = " + idMaterie + " ;");
			rs2.next();
			idSubiectExamen = rs2.getInt("idsubiect");
			
			//pas 4-  obtin idSubiectColocviu pentru tip='Colocviu' cu idMaterie din statement
			
			ResultSet rs3 = null;
			Statement stmtForIdSubiectColocviu;
			stmtForIdSubiectColocviu = con.createStatement();
			rs3 = stmtForIdSubiectColocviu.executeQuery("SELECT idsubiect FROM subiecte WHERE tip = 'colocviu' and idmaterie = " + idMaterie + " ;");
			rs3.next();
			idSubiectColocviu = rs3.getInt("idsubiect");
			
			//pas 5- obtin idstudent
			
			ResultSet rs4 = null;
			Statement stmtForIdStudent;
			stmtForIdStudent = con.createStatement();
			rs4 = stmtForIdStudent.executeQuery("SELECT idstudent FROM studenti WHERE nume = '" + nume + "' and prenume = '" + prenume + "';");
			rs4.next();
			idStudent = rs4.getInt("idstudent");
			
           //Pentru Punctajul obtinut la partial
			Statement stmtInsert;
			stmtInsert = con.createStatement();
			stmtInsert.executeUpdate("insert into evaluari (idstudent, idsubiect, punctajobtinut)"
					+ "values ( " + idStudent + " , " + idSubiectPartial + " , " + pctObtPartial + " );");

			// Pentru Punctajul obtinut la examen
			Statement stmtInsert1;
			stmtInsert1 = con.createStatement();
			stmtInsert1.executeUpdate("insert into evaluari (idstudent, idsubiect, punctajobtinut)"
					+ "values ( " + idStudent + " , "  + idSubiectExamen + " , " + pctObtExamen + " );");

			// Pentru Punctajul obtinut la colocviu
			Statement stmtInsert2;
			stmtInsert2 = con.createStatement();
			stmtInsert2.executeUpdate("insert into evaluari (idstudent, idsubiect, punctajobtinut)"
					+ "values ( " + idStudent + " , " + idSubiectColocviu + " , " + pctObtColocviu + " );");
			
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	} 

	public void adaugareSubiectOperatieBD(String numeMaterie, Integer punctajPartial, Integer punctajExamen, Integer punctajColocviu) 
			throws SQLException, Exception {
		Integer idMaterie = null;
		try {
			// create a prepared SQL statement
			ResultSet rs = null;
			Statement stmtForIdMaterie;
			stmtForIdMaterie = con.createStatement();
			rs = stmtForIdMaterie.executeQuery("SELECT idmaterie FROM materii WHERE denumire = '" + numeMaterie + "';");
			rs.next();
			idMaterie = rs.getInt("idmaterie");
			
			Statement stmtInsert1;
			stmtInsert1 = con.createStatement();
			stmtInsert1.executeUpdate("insert into subiecte (tip, idmaterie, punctaj) values ('Partial'," + idMaterie + ", " + punctajPartial + ");");
			
			Statement stmtInsert2;
			stmtInsert2 = con.createStatement();
			stmtInsert2.executeUpdate("insert into subiecte (tip, idmaterie, punctaj) values ('Examen'," + idMaterie+", " + punctajExamen + ");");
			
			Statement stmtInsert3;
			stmtInsert3 = con.createStatement();
			stmtInsert3.executeUpdate("insert into subiecte (tip, idmaterie, punctaj) values ('Colocviu'," + idMaterie + ", " + punctajColocviu + ");");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}

	public void adaugareMaterieOperatieBD(String denumire, String profesor, Integer puncteCredit) throws SQLException, Exception {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("insert into materii(denumire, profesor, punctecredit) values ('" + denumire + "', '" + profesor + "', " + puncteCredit + " ); ");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}
	
	public void actualizareStudentOperatieBD(Integer id, String nume, String prenume, Integer grupa, String serie, Integer an, String specializare ) 
			throws SQLException, Exception {
		try {
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("update studenti set nume = '" + nume + "', prenume = '" + prenume + "' , grupa= " 
			+ grupa + ", serie= '" + serie + "', an= " + an + ", specializare= '" + specializare + "' "
			+ "where idstudent = " + id + ";");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}

	public void actualizareEvaluareOperatieBD(Integer idStudent, String nume, String prenume, Integer punctajPartial,  Integer punctajExamen ,  Integer punctajColocviu , String materie) 
			throws SQLException, Exception {
		Integer idMaterie = null;
		Integer idSubiectPartial =null;
		Integer idSubiectExamen = null;
		Integer idSubiectColocviu = null;
		Integer idEvaluarePartial=null;
		Integer idEvaluareExamen=null;
		Integer idEvaluareColocviu=null;
		try {
		//am idStudent din argument
	
		//am obtinut idMaterie pentru a putea obtine dupa idSubiect pentru un anumit tip(Partial, Examen, Colocviu)
		ResultSet rs1 = null;
		Statement stmtForIdMaterie;
		stmtForIdMaterie = con.createStatement();
		rs1 = stmtForIdMaterie.executeQuery("SELECT idmaterie FROM materii WHERE denumire = '" + materie + "';");
		rs1.next();
		idMaterie = rs1.getInt("idmaterie");
		
		////  id-urile Subiectelor obtinute pentru fiecare tip 
		ResultSet rs2 = null;
		Statement stmtForIdSubiectPartial;
		stmtForIdSubiectPartial = con.createStatement();
		rs2 = stmtForIdSubiectPartial.executeQuery("SELECT idsubiect FROM subiecte WHERE idmaterie = " + idMaterie + " and tip='partial';");
		rs2.next();
		idSubiectPartial = rs2.getInt("idsubiect");
		
		ResultSet rs3 = null;
		Statement stmtForIdSubiectExamen;
		stmtForIdSubiectExamen = con.createStatement();
		rs3 = stmtForIdSubiectExamen.executeQuery("SELECT idsubiect FROM subiecte WHERE idmaterie = " + idMaterie + " and tip='examen';");
		rs3.next();
		idSubiectExamen = rs3.getInt("idsubiect");
		
		ResultSet rs4 = null;
		Statement stmtForIdSubiectColocviu;
		stmtForIdSubiectColocviu = con.createStatement();
		rs4 = stmtForIdSubiectColocviu.executeQuery("SELECT idsubiect FROM subiecte WHERE idmaterie = " + idMaterie + " and tip='colocviu';");
		rs4.next();
		idSubiectColocviu = rs4.getInt("idsubiect");
	    //////
		
		////// id-urile Evaluarilor obtinut pentru ficare idStudent cu un idSubiect de un anumit tip
		ResultSet rs5 = null;
		Statement stmtForIdEvaluarePartial;
		stmtForIdEvaluarePartial = con.createStatement();
		rs5 = stmtForIdEvaluarePartial.executeQuery("SELECT idevaluare FROM evaluari WHERE idstudent = " + idStudent + " and idsubiect = " + idSubiectPartial + ";");
		rs5.next();
		idEvaluarePartial = rs5.getInt("idevaluare");
		
		ResultSet rs6 = null;
		Statement stmtForIdEvaluareExamen;
		stmtForIdEvaluareExamen = con.createStatement();
		rs6 = stmtForIdEvaluareExamen.executeQuery("SELECT idevaluare FROM evaluari WHERE idstudent = " + idStudent + " and idsubiect = " + idSubiectExamen + ";");
		rs6.next();
		idEvaluareExamen = rs6.getInt("idevaluare");
		
		ResultSet rs7 = null;
		Statement stmtForIdEvaluareColocviu;
		stmtForIdEvaluareColocviu = con.createStatement();
		rs7 = stmtForIdEvaluareColocviu.executeQuery("SELECT idevaluare FROM evaluari WHERE idstudent = " + idStudent + " and idsubiect = " + idSubiectColocviu + ";");
		rs7.next();
		idEvaluareColocviu = rs7.getInt("idevaluare");
		
		Statement stmt;
		stmt = con.createStatement();
		stmt.executeUpdate("update evaluari set punctajobtinut= " + punctajPartial 
				+ " where idevaluare= " + idEvaluarePartial + ";");
		
		Statement stmt1;
		stmt1 = con.createStatement();
		stmt1.executeUpdate("update evaluari set punctajobtinut= " + punctajExamen + 
				" where idevaluare= " + idEvaluareExamen + ";");
		
		Statement stmt2;
		stmt2 = con.createStatement();
		stmt2.executeUpdate("update evaluari set punctajobtinut= " + punctajColocviu + 
				" where idevaluare= " + idEvaluareColocviu + ";");
			
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}

	public void actualizareSubiectOperatieBD(String materie, Integer punctajPartial,  Integer punctajExamen ,  Integer punctajColocviu ) 
			throws SQLException, Exception {
		Integer idMaterie = null;
		Integer idSubiectPartial = null;
		Integer idSubiectExamen = null;
		Integer idSubiectColocviu = null;
		try {
			
			ResultSet rs = null;
			Statement stmtForIdMaterie;
			stmtForIdMaterie = con.createStatement();
			rs = stmtForIdMaterie.executeQuery("SELECT idmaterie FROM materii WHERE denumire = '" + materie + "';");
			rs.next();
			idMaterie = rs.getInt("idmaterie");
			
			ResultSet rs1 = null;
			Statement stmtForIdSubiectPartial;
			stmtForIdSubiectPartial = con.createStatement();
			rs1 = stmtForIdSubiectPartial.executeQuery("SELECT idsubiect FROM subiecte WHERE idmaterie = " + idMaterie + " and tip='partial';");
			rs1.next();
			idSubiectPartial = rs1.getInt("idsubiect");
			
			ResultSet rs2 = null;
			Statement stmtForIdSubiectExamen;
			stmtForIdSubiectExamen = con.createStatement();
			rs2 = stmtForIdSubiectExamen.executeQuery("SELECT idsubiect FROM subiecte WHERE idmaterie = " + idMaterie + " and tip='examen';");
			rs2.next();
			idSubiectExamen = rs2.getInt("idsubiect");
			
			ResultSet rs3 = null;
			Statement stmtForIdSubiectColocviu;
			stmtForIdSubiectColocviu = con.createStatement();
			rs3 = stmtForIdSubiectColocviu.executeQuery("SELECT idsubiect FROM subiecte WHERE idmaterie = " + idMaterie + " and tip='colocviu';");
			rs3.next();
			idSubiectColocviu = rs3.getInt("idsubiect");
			
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("update subiecte set punctaj= " + punctajPartial 
					+ " where idsubiect = " + idSubiectPartial + ";");
			
			Statement stmt1;
			stmt1 = con.createStatement();
			stmt1.executeUpdate("update subiecte set punctaj= " + punctajExamen
					+ " where idsubiect = " + idSubiectExamen + ";");
			
			Statement stmt2;
			stmt2 = con.createStatement();
			stmt2.executeUpdate("update subiecte set punctaj= " + punctajColocviu 
					+ " where idsubiect = " + idSubiectColocviu+";");
			
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}

	public void actualizareMaterieOperatieBD(Integer idMaterie, String denumire, String profesor, Integer puncteCredit ) 
			throws SQLException, Exception {
		try {
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("update materii set denumire= '" + denumire + "' , profesor='" + profesor + "', punctecredit= " + puncteCredit 
					+ " where idmaterie=" + idMaterie + ";");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}

	public void stergereStudentOperatieBD(Integer id) throws SQLException, Exception {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("delete from studenti where idstudent = " + id + ";");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	} 
	
	public void stergereEvaluareOperatieBD(Integer id, String materie) throws SQLException, Exception {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("DELETE from evaluari WHERE idstudent = " + id + " AND idsubiect IN ( SELECT idsubiect from subiecte WHERE idmaterie IN "
					+ " (SELECT idmaterie from materii WHERE denumire = '" + materie + "'))");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	} 
	
	public void stergereSubiectOperatieBD(Integer id) throws SQLException, Exception {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("delete from subiecte where idmaterie = " + id + ";");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	} 
	
	public void stergereMaterieOperatieBD(Integer id) throws SQLException, Exception {
		try {
			// create a prepared SQL statement
			Statement stmt;
			stmt = con.createStatement();
			stmt.executeUpdate("delete from materii where idmaterie = " + id + ";");
		} catch (SQLException sqle) {
			error = "SQLException: Interogarea nu a fost posibila.";
			throw new SQLException(error);
		} catch (Exception e) {
			error = "A aparut o exceptie in timp ce se extrageau datele.";
			throw new Exception(error);
		}
	}
}