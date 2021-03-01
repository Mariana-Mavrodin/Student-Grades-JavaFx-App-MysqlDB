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
public class Materie {
	public static final String coloanaId = "idMaterie";
	public static final String coloanaDenumire = "Denumire";
	public static final String coloanaProfesor = "Profesor";
	public static final String coloanaPuncteCredit = "PuncteCredit";
	
	private final IntegerProperty id;
	private final StringProperty denumire;
	private final StringProperty profesor;
	private final IntegerProperty puncteCredit;

	public Materie() {
		this.id = new SimpleIntegerProperty();
		this.denumire = new SimpleStringProperty();
		this.profesor = new SimpleStringProperty();
		this.puncteCredit = new SimpleIntegerProperty();
	}

	public Integer getId() {
		return id.get();
	}

	public String getDenumire() {
		return denumire.get();
	}

	public String getProfesor() {
		return profesor.get();
	}

	public Integer getPuncteCredit() {
		return puncteCredit.get();
	}

	public void setId(Integer valoare) {
		id.set(valoare);
	}

	public void setDenumire(String valoare) {
		denumire.set(valoare);
	}

	public void setProfesor(String valoare) {
		profesor.set(valoare);
	}

	public void setPuncteCredit(Integer valoare) {
		puncteCredit.set(valoare);
	}


	public IntegerProperty idProprietate() {
		return id;
	}

	public StringProperty denumireProprietate() {
		return denumire;
	}

	public StringProperty profesorProprietate() {
		return profesor;
	}

	public IntegerProperty puncteCreditProprietate() {
		return puncteCredit;
	}

}