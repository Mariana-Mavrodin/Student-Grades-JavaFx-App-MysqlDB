package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Mavrodin Mariana
 * Grupa: 435
 * Serie: C
 * Specializare: TST
 */
public class Evaluare {
	public static final String coloanaId = "id";
	public static final String coloanaNumeStudent = "Nume";
	public static final String coloanaPrenumeStudent = "Prenume";
	public static final String coloanaPunctajObtinutPartial = "Partial";
	public static final String coloanaPunctajObtinutExamen = "Examen";
	public static final String coloanaPunctajObtinutColocviu = "Colocviu";
	public static final String coloanaDenumireMaterie = "Materie";
	
	private final IntegerProperty idStudent;
	private final StringProperty nume;
	private final StringProperty prenume;
	private final IntegerProperty partial;
	private final IntegerProperty examen;
	private final IntegerProperty colocviu;
	private final StringProperty materie;

	public Evaluare() {
		this.idStudent = new SimpleIntegerProperty();
		this.nume = new SimpleStringProperty();
		this.prenume = new SimpleStringProperty();
		this.partial = new SimpleIntegerProperty();
		this.examen = new SimpleIntegerProperty();
		this.colocviu = new SimpleIntegerProperty();
		this.materie = new SimpleStringProperty();
	}
	
	public Integer getIdStudent() {
		return idStudent.get();
	}

	public String getNume() {
		return nume.get();
	}

	public String getPrenume() {
		return prenume.get();
	}

	public Integer getPartial() {
		return partial.get();
	}

	public Integer getExamen() {
		return examen.get();
	}

	public Integer getColocviu() {
		return colocviu.get();
	}

	public String getMaterie() {
		return materie.get();
	}

	public void setIdStudent(Integer valoare) {
		idStudent.set(valoare);
	}
	public void setNume(String valoare) {
		nume.set(valoare);
	}

	public void setPrenume(String valoare) {
		prenume.set(valoare);
	}

	public void setPartial(Integer valoare) {
		partial.set(valoare);
	}

	public void setExamen(Integer valoare) {
		examen.set(valoare);
	}

	public void setColocviu(Integer valoare) {
		colocviu.set(valoare);
	}

	public void setMaterie(String valoare) {
		materie.set(valoare);
	}

	public IntegerProperty idStudentProprietate() {
		return idStudent;
	}
	public StringProperty numeProprietate() {
		return nume;
	}

	public StringProperty prenumeProprietate() {
		return prenume;
	}

	public IntegerProperty partialProprietate() {
		return partial;
	}

	public IntegerProperty examenProprietate() {
		return examen;
	}

	public IntegerProperty colocviuProprietate() {
		return colocviu;
	}

	public StringProperty materieProprietate() {
		return materie;
	}

}