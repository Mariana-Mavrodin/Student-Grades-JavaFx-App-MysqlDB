package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author Mavrodin Mariana
 * Grupa: 435
 * Serie: C
 * Specializare: TST
 */
public class SampleController implements Initializable {

	@FXML
	private TableView<Student> tabelaStudenti;
	@FXML
	private Tab sectiuneStudenti;
	@FXML
	private Button butonIncarcareStudenti;
	@FXML
	private Button butonStergereStudent;
	@FXML
	private Button butonAdaugareStudent;
	@FXML
	private Button butonIncarcareActualizareStudent;
	@FXML
	private Button butonActualizareStudent;
	@FXML
	private TableColumn<Student, Integer> coloanaIdStudent;
	@FXML
	private TableColumn<Student, String> coloanaNumeStudent;
	@FXML
	private TableColumn<Student, String> coloanaPrenumeStudent;
	@FXML
	private TableColumn<Student, Integer> coloanaGrupaStudent;
	@FXML
	private TableColumn<Student, String> coloanaSerieStudent;
	@FXML
	private TableColumn<Student, Integer> coloanaAnStudent;
	@FXML
	private TableColumn<Student, String> coloanaSpecializareStudent;

	@FXML
	private TextField chenarNumeStudent;
	@FXML
	private TextField chenarPrenumeStudent;
	@FXML
	private TextField chenarGrupaStudent;
	@FXML
	private TextField chenarSerieStudent;
	@FXML
	private TextField chenarAnStudent;
	@FXML
	private TextField chenarSpecializareStudent;

	@FXML
	private TableView<Evaluare> tabelaEvaluari;
	@FXML
	private Tab sectiuneEvaluari;
	@FXML
	private Button butonStergereEvaluare;
	@FXML
	private Button butonIncarcareEvaluari;
	@FXML
	private Button butonAdaugareEvaluare;
	@FXML
	private Button butonIncarcareActualizareEvaluare;
	@FXML
	private Button butonActualizareEvaluare;
	@FXML
	private TableColumn<Evaluare, Integer> coloanaIdEvaluare;
	@FXML
	private TableColumn<Evaluare, String> coloanaNumeEvaluare;
	@FXML
	private TableColumn<Evaluare, String> coloanaPrenumeEvaluare;
	@FXML
	private TableColumn<Evaluare, Integer> coloanaPartialEvaluare;
	@FXML
	private TableColumn<Evaluare, Integer> coloanaExamenEvaluare;
	@FXML
	private TableColumn<Evaluare, Integer> coloanaColocviuEvaluare;
	@FXML
	private TableColumn<Evaluare, String> coloanaMaterieEvaluare;

	@FXML
	private TextField chenarNumeEvaluare;
	@FXML
	private TextField chenarPrenumeEvaluare;
	@FXML
	private TextField chenarPartialEvaluare;
	@FXML
	private TextField chenarExamenEvaluare;
	@FXML
	private TextField chenarColocviuEvaluare;
	@FXML
	private TextField chenarMaterieEvaluare;

	@FXML
	private TableView<Subiect> tabelaSubiecte;
	@FXML
	private Tab sectiuneSubiecte;
	@FXML
	private Button butonStergereSubiect;
	@FXML
	private Button butonIncarcareSubiecte;
	@FXML
	private Button butonAdaugareSubiect;
	@FXML
	private Button butonIncarcareActualizareSubiect;
	@FXML
	private Button butonActualizareSubiect;
	@FXML
	private TableColumn<Subiect, Integer> coloanaIdMaterieSubiect;
	@FXML
	private TableColumn<Subiect, String> coloanaDenumireMaterieSubiect;
	@FXML
	private TableColumn<Subiect, Integer> coloanaPartialSubiect;
	@FXML
	private TableColumn<Subiect, Integer> coloanaExamenSubiect;
	@FXML
	private TableColumn<Subiect, Integer> coloanaColocviuSubiect;

	@FXML
	private TextField chenarDenumireMaterieSubiect;
	@FXML
	private TextField chenarPartialSubiect;
	@FXML
	private TextField chenarExamenSubiect;
	@FXML
	private TextField chenarColocviuSubiect;

	@FXML
	private TableView<Materie> tabelaMaterii;
	@FXML
	private Tab sectiuneMaterii;
	@FXML
	private Button butonStergereMaterie;
	@FXML
	private Button butonIncarcareMaterii;
	@FXML
	private Button butonAdaugareMaterie;
	@FXML
	private Button butonIncarcareActualizareMaterie;
	@FXML
	private Button butonActualizareMaterie;
	@FXML
	private TableColumn<Materie, Integer> coloanaIdMaterie;
	@FXML
	private TableColumn<Materie, String> coloanaDenumireMaterie;
	@FXML
	private TableColumn<Materie, String> coloanaProfesorMaterie;
	@FXML
	private TableColumn<Materie, Integer> coloanaPuncteCreditMaterie;

	@FXML
	private TextField chenarDenumireMaterie;
	@FXML
	private TextField chenarProfesorMaterie;
	@FXML
	private TextField chenarPuncteCreditMaterie;

	private ObservableList<Student> dateStudenti;
	private ObservableList<Materie> dateMaterii;
	private ObservableList<Subiect> dateSubiecte;
	private ObservableList<Evaluare> dateEvaluari;

	private DBOperations jb;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		jb = new DBOperations();
	}

	@FXML
	private void incarcaStudenti(ActionEvent event) throws SQLException, Exception {

		jb.connect();
		dateStudenti = FXCollections.observableArrayList();
		ResultSet rs = jb.incarcareStudentiOperatieBD();

		while (rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt(Student.coloanaId));
			student.setNume(rs.getString(Student.coloanaNume));
			student.setPrenume(rs.getString(Student.coloanaPrenume));
			student.setGrupa(rs.getInt(Student.coloanaGrupa));
			student.setSerie(rs.getString(Student.coloanaSerie));
			student.setAn(rs.getInt(Student.coloanaAn));
			student.setSpecializare(rs.getString(Student.coloanaSpecializare));
			dateStudenti.add(student);
		}

		coloanaIdStudent.setCellValueFactory(cellData -> cellData.getValue().idProprietate().asObject());
		coloanaNumeStudent.setCellValueFactory(cellData -> cellData.getValue().numeProprietate());
		coloanaPrenumeStudent.setCellValueFactory(cellData -> cellData.getValue().prenumeProprietate());
		coloanaGrupaStudent.setCellValueFactory(cellData -> cellData.getValue().grupaProprietate().asObject());
		coloanaSerieStudent.setCellValueFactory(cellData -> cellData.getValue().serieProprietate());
		coloanaAnStudent.setCellValueFactory(cellData -> cellData.getValue().anProprietate().asObject());
		coloanaSpecializareStudent.setCellValueFactory(cellData -> cellData.getValue().specializareProprietate());

		tabelaStudenti.setItems(dateStudenti);
		jb.disconnect();
	}
	
	@FXML
	private void incarcaEvaluari(ActionEvent event) throws Exception {
		
		jb.connect();
		dateEvaluari = FXCollections.observableArrayList();
		ResultSet rs = jb.incarcareEvaluariOperatieBD();
		
		while (rs.next()) {
			Evaluare evaluare = new Evaluare();
			evaluare.setIdStudent(rs.getInt(Evaluare.coloanaId));
			evaluare.setNume(rs.getString(Evaluare.coloanaNumeStudent));
			evaluare.setPrenume(rs.getString(Evaluare.coloanaPrenumeStudent));
			evaluare.setPartial(rs.getInt(Evaluare.coloanaPunctajObtinutPartial));
			evaluare.setExamen(rs.getInt(Evaluare.coloanaPunctajObtinutExamen));
			evaluare.setColocviu(rs.getInt(Evaluare.coloanaPunctajObtinutColocviu));
			evaluare.setMaterie(rs.getString(Evaluare.coloanaDenumireMaterie));
			dateEvaluari.add(evaluare);
		}
		
		coloanaIdEvaluare.setCellValueFactory(cellData -> cellData.getValue().idStudentProprietate().asObject());
		coloanaNumeEvaluare.setCellValueFactory(cellData -> cellData.getValue().numeProprietate());
		coloanaPrenumeEvaluare.setCellValueFactory(cellData -> cellData.getValue().prenumeProprietate());
		coloanaPartialEvaluare.setCellValueFactory(cellData -> cellData.getValue().partialProprietate().asObject());
		coloanaExamenEvaluare.setCellValueFactory(cellData -> cellData.getValue().examenProprietate().asObject());
		coloanaColocviuEvaluare.setCellValueFactory(cellData -> cellData.getValue().colocviuProprietate().asObject());
		coloanaMaterieEvaluare.setCellValueFactory(cellData -> cellData.getValue().materieProprietate());

		tabelaEvaluari.setItems(dateEvaluari); // adaug lista cu evaluari in tabela
		jb.disconnect();
	}

	@FXML
	private void incarcaSubiecte(ActionEvent event) throws Exception {
		
		jb.connect();
		dateSubiecte = FXCollections.observableArrayList();
		ResultSet rs = jb.incarcareSubiecteOperatieBD();
		
		while (rs.next()) {
			Subiect subiect = new Subiect();
			subiect.setIdMaterie(rs.getInt(Subiect.coloanaIdMaterie));
			subiect.setDenumireMaterie(rs.getString(Subiect.coloanaDenumireMaterie));
			subiect.setPartial(rs.getInt(Subiect.coloanaPunctajPartial));
			subiect.setExamen(rs.getInt(Subiect.coloanaPunctajExamen));
			subiect.setColocviu(rs.getInt(Subiect.coloanaPunctajColocviu));
			dateSubiecte.add(subiect);
		}
		
		coloanaIdMaterieSubiect.setCellValueFactory(cellData -> cellData.getValue().idMaterieProprietate().asObject());   
		coloanaDenumireMaterieSubiect.setCellValueFactory(cellData -> cellData.getValue().denumireMaterieProprietate());
		coloanaPartialSubiect.setCellValueFactory(cellData -> cellData.getValue().partialProprietate().asObject());
		coloanaExamenSubiect.setCellValueFactory(cellData -> cellData.getValue().examenProprietate().asObject());
		coloanaColocviuSubiect.setCellValueFactory(cellData -> cellData.getValue().colocviuProprietate().asObject());

		tabelaSubiecte.setItems(dateSubiecte); // adaug lista cu subiecte in tabela
		jb.disconnect();
	}
	
	@FXML
	private void incarcaMaterii(ActionEvent event) throws SQLException, Exception {
		
		jb.connect();
		dateMaterii = FXCollections.observableArrayList();
		ResultSet rs = jb.incarcareMateriiOperatieBD();
		
		while (rs.next()) {
			Materie materie = new Materie();
			materie.setId(rs.getInt(Materie.coloanaId));
			materie.setDenumire(rs.getString(Materie.coloanaDenumire));
			materie.setProfesor(rs.getString(Materie.coloanaProfesor));
			materie.setPuncteCredit(rs.getInt(Materie.coloanaPuncteCredit));
			dateMaterii.add(materie);
		}
		
		coloanaIdMaterie.setCellValueFactory(cellData -> cellData.getValue().idProprietate().asObject());
		coloanaDenumireMaterie.setCellValueFactory(cellData -> cellData.getValue().denumireProprietate());
		coloanaProfesorMaterie.setCellValueFactory(cellData -> cellData.getValue().profesorProprietate());
		coloanaPuncteCreditMaterie.setCellValueFactory(cellData -> cellData.getValue().puncteCreditProprietate().asObject());
		
		tabelaMaterii.setItems(dateMaterii);
		jb.disconnect();
	}

	@FXML
	private void adaugaStudent(ActionEvent event) throws Exception {
		Integer grupa;
		Integer an;
		
		String nume = chenarNumeStudent.getText();
		String prenume = chenarPrenumeStudent.getText();
		String serie = chenarSerieStudent.getText();
		String specializare = chenarSpecializareStudent.getText();
		
		String optionalSpecializare = specializare == null ? "" : specializare; 
		
		if(nume != null && !nume.isEmpty() && prenume != null && !prenume.isEmpty() 
				&& serie != null && !serie.isEmpty()) {
			try {
				grupa = Integer.parseInt(chenarGrupaStudent.getText());
				an = Integer.parseInt(chenarAnStudent.getText());
				jb.connect();
				jb.adaugareStudentOperatieBD(nume, prenume, grupa, serie, an, optionalSpecializare);
				jb.disconnect();
				butonIncarcareStudenti.fire();
			}catch(NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}
	}
	
	@FXML
	private void adaugaEvaluare(ActionEvent event) throws Exception {
		Integer partial;
		Integer examen;
		Integer colocviu;
		
		String nume = chenarNumeEvaluare.getText();
		String prenume = chenarPrenumeEvaluare.getText();
		String materie = chenarMaterieEvaluare.getText();
		
		if(nume != null && !nume.isEmpty() && prenume != null && !prenume.isEmpty() && materie != null && !materie.isEmpty()) {
			try {
				partial = Integer.parseInt(chenarPartialEvaluare.getText());
				examen = Integer.parseInt(chenarExamenEvaluare.getText());
				colocviu = Integer.parseInt(chenarColocviuEvaluare.getText());
				jb.connect();
				jb.adaugareEvaluareOperatieBD(nume, prenume, partial, examen, colocviu, materie);
				jb.disconnect();
				butonIncarcareEvaluari.fire();
			}catch(NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}

	}

	@FXML
	private void adaugaSubiect(ActionEvent event) throws Exception {
		Integer punctajPartial;
		Integer punctajExamen;
		Integer punctajColocviu;
		
		String numeMaterie = chenarDenumireMaterieSubiect.getText();
		
		if(numeMaterie != null && !numeMaterie.isEmpty()) {
			try {
				punctajPartial = Integer.parseInt(chenarPartialSubiect.getText());
				punctajExamen = Integer.parseInt(chenarExamenSubiect.getText());
				punctajColocviu = Integer.parseInt(chenarColocviuSubiect.getText());
				jb.connect();
				jb.adaugareSubiectOperatieBD(numeMaterie, punctajPartial, punctajExamen, punctajColocviu); // nume la fel
				jb.disconnect();
				butonIncarcareSubiecte.fire();
			}catch(NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}

	}

	@FXML
	private void adaugaMaterie(ActionEvent event) throws Exception {
		Integer puncteCredit;
		
		String denumire = chenarDenumireMaterie.getText();
		String profesor = chenarProfesorMaterie.getText();
		
		if(denumire != null && !denumire.isEmpty() && profesor != null && !profesor.isEmpty()) {
			try {
				puncteCredit = Integer.parseInt(chenarPuncteCreditMaterie.getText());
				jb.connect();
				jb.adaugareMaterieOperatieBD(denumire, profesor, puncteCredit);
				jb.disconnect();
				butonIncarcareMaterii.fire();
			}catch(NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}

	}

	@FXML
	private void incarcaDatePentruActualizareStudent(ActionEvent event) throws Exception {
		
		Student studentSelectat = tabelaStudenti.getSelectionModel().getSelectedItem();

		if (studentSelectat != null) {
			chenarNumeStudent.setText(studentSelectat.getNume());
			chenarPrenumeStudent.setText(studentSelectat.Prenume());
			chenarGrupaStudent.setText(studentSelectat.getGrupa().toString());
			chenarSerieStudent.setText(studentSelectat.getSerie());
			chenarAnStudent.setText(studentSelectat.getAn().toString());
			chenarSpecializareStudent.setText(studentSelectat.getSpecializare());
		}
	}
	
	@FXML
	private void incarcaDatePentruActualizareEvaluare(ActionEvent event) throws Exception {
		
		Evaluare evaluareSelectata = tabelaEvaluari.getSelectionModel().getSelectedItem();

		if (evaluareSelectata != null) {
			chenarNumeEvaluare.setText(evaluareSelectata.getNume());
			chenarPrenumeEvaluare.setText(evaluareSelectata.getPrenume());
			chenarPartialEvaluare.setText(evaluareSelectata.getPartial().toString());
			chenarExamenEvaluare.setText(evaluareSelectata.getExamen().toString());
			chenarColocviuEvaluare.setText(evaluareSelectata.getColocviu().toString());
			chenarMaterieEvaluare.setText(evaluareSelectata.getMaterie());
		}
	}




	@FXML
	private void incarcaDatePentruActualizareSubiect(ActionEvent event) throws Exception {
		
		Subiect subiectSelectat = tabelaSubiecte.getSelectionModel().getSelectedItem();

		if (subiectSelectat != null) {
			chenarDenumireMaterieSubiect.setText(subiectSelectat.getDenumireMaterie());
			chenarPartialSubiect.setText(subiectSelectat.getPartial().toString());
			chenarExamenSubiect.setText(subiectSelectat.getExamen().toString());
			chenarColocviuSubiect.setText(subiectSelectat.getColocviu().toString());

		}
	}
	
	@FXML
	private void incarcaDatePentruActualizareMaterie(ActionEvent event) throws Exception {
		
		Materie materieSelectata = tabelaMaterii.getSelectionModel().getSelectedItem();

		if (materieSelectata != null) {
			chenarDenumireMaterie.setText(materieSelectata.getDenumire());
			chenarProfesorMaterie.setText(materieSelectata.getProfesor());
			chenarPuncteCreditMaterie.setText(materieSelectata.getPuncteCredit().toString());
		}
	}
	
	@FXML
	private void actualizeazaStudent(ActionEvent event) throws Exception {
		
		Student studentSelectat = tabelaStudenti.getSelectionModel().getSelectedItem();
		String optionalSpecializare; 
		Integer grupa, an;
		
		if (studentSelectat != null) {
			try {
				grupa = Integer.parseInt(chenarGrupaStudent.getText());
				an = Integer.parseInt(chenarAnStudent.getText());
				optionalSpecializare = chenarSpecializareStudent.getText() == null ? "" : chenarSpecializareStudent.getText(); //pentru ca este optional in bd poate fi null
				
				jb.connect();
				jb.actualizareStudentOperatieBD(studentSelectat.getId(), chenarNumeStudent.getText(),
						chenarPrenumeStudent.getText(), grupa, chenarSerieStudent.getText(), an, optionalSpecializare);
				jb.disconnect();
				butonIncarcareStudenti.fire();

				chenarNumeStudent.setText("");
				chenarPrenumeStudent.setText("");
				chenarGrupaStudent.setText("");
				chenarSerieStudent.setText("");
				chenarAnStudent.setText("");
				chenarSpecializareStudent.setText("");

			} catch (NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}
	}

	@FXML
	private void actualizeazaEvaluare(ActionEvent event) throws Exception {
		
		Evaluare evaluareSelectata = tabelaEvaluari.getSelectionModel().getSelectedItem();
		Integer partial, examen, colocviu;
		
		if (evaluareSelectata != null) {
			try {
				partial = Integer.parseInt(chenarPartialEvaluare.getText());
				examen = Integer.parseInt(chenarExamenEvaluare.getText());
				colocviu = Integer.parseInt(chenarColocviuEvaluare.getText());
				
				jb.connect();
				jb.actualizareEvaluareOperatieBD(evaluareSelectata.getIdStudent(), chenarNumeEvaluare.getText(), chenarPrenumeEvaluare.getText(), partial, examen,
						colocviu, chenarMaterieEvaluare.getText());
				jb.disconnect();
				butonIncarcareEvaluari.fire();

				chenarNumeEvaluare.setText("");
				chenarPrenumeEvaluare.setText("");
				chenarPartialEvaluare.setText("");
				chenarExamenEvaluare.setText("");
				chenarColocviuEvaluare.setText("");
				chenarMaterieEvaluare.setText("");

			} catch (NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}
	}
	
	@FXML
	private void actualizeazaSubiect(ActionEvent event) throws Exception {
		
		Subiect subiectSelectat = tabelaSubiecte.getSelectionModel().getSelectedItem();
		Integer partial, examen, colocviu;
		
		if (subiectSelectat != null) {
			try {
				partial = Integer.parseInt(chenarPartialSubiect.getText());
				examen = Integer.parseInt(chenarExamenSubiect.getText());
				colocviu = Integer.parseInt(chenarColocviuSubiect.getText());
				jb.connect();
				jb.actualizareSubiectOperatieBD(chenarDenumireMaterieSubiect.getText(), partial, examen, colocviu);
				jb.disconnect();
				butonIncarcareSubiecte.fire();

				chenarDenumireMaterieSubiect.setText("");
				chenarPartialSubiect.setText("");
				chenarExamenSubiect.setText("");
				chenarColocviuSubiect.setText("");

			} catch (NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}
	}
	
	@FXML
	private void actualizeazaMaterie(ActionEvent event) throws Exception {
		
		Materie materieSelectata = tabelaMaterii.getSelectionModel().getSelectedItem();
		Integer PuncteCredit;
		
		if (materieSelectata != null) {
			try {
				PuncteCredit = Integer.parseInt(chenarPuncteCreditMaterie.getText());
				jb.connect();
				jb.actualizareMaterieOperatieBD(materieSelectata.getId(), chenarDenumireMaterie.getText(),
						chenarProfesorMaterie.getText(), PuncteCredit);
				jb.disconnect();
				butonIncarcareMaterii.fire();

				chenarDenumireMaterie.setText("");
				chenarProfesorMaterie.setText("");
				chenarPuncteCreditMaterie.setText("");

			} catch (NumberFormatException e) {
				throw new Exception("Nu s-a putut parsa un string la integer.");
			}
		}
	}

	@FXML
	private void stergeStudent(ActionEvent event) throws Exception {
		
		Student studentSelectat = tabelaStudenti.getSelectionModel().getSelectedItem();
		
		if (studentSelectat != null) { // in caz de apas inca o data pe butonul stergere student, sa nu mi dea eroare
			jb.connect();
			jb.stergereStudentOperatieBD(studentSelectat.getId()); // din studentul selecatat, iau doar id ul cu geter ul
			jb.disconnect();
			butonIncarcareStudenti.fire(); // apasare automata a butonului de incarcare studenti
		}
	}

	@FXML
	private void stergeEvaluare(ActionEvent event) throws Exception {
		
		Evaluare evaluareSelectata = tabelaEvaluari.getSelectionModel().getSelectedItem();
	
		if (evaluareSelectata != null) {
			jb.connect();
			jb.stergereEvaluareOperatieBD(evaluareSelectata.getIdStudent(), evaluareSelectata.getMaterie()); 
			jb.disconnect();
			butonIncarcareEvaluari.fire(); 
		}
	}

	@FXML
	private void stergeSubiect(ActionEvent event) throws Exception {
		
		Subiect subiectSelectat = tabelaSubiecte.getSelectionModel().getSelectedItem();
	
		if (subiectSelectat != null) { // in caz de apas inca o data pe butonul stergere student, sa nu mi dea eroare
			jb.connect();
			jb.stergereSubiectOperatieBD(subiectSelectat.getIdMaterie()); // din subiectul selecatat, iau doar id ul materiei
			jb.disconnect();
			butonIncarcareSubiecte.fire(); // apasare automata a butonului de incarcare studenti
		}
	}

	@FXML
	private void stergeMaterie(ActionEvent event) throws Exception {
		
		Materie materieSelectata = tabelaMaterii.getSelectionModel().getSelectedItem();
		
		if (materieSelectata != null) { 
			jb.connect();
			jb.stergereMaterieOperatieBD(materieSelectata.getId()); 
			jb.disconnect();
			butonIncarcareMaterii.fire(); 
		}
	}

}
