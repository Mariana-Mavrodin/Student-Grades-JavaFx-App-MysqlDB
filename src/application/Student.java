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
public class Student {
	public static final String coloanaId = "idstudent";
	public static final String coloanaNume = "nume";
	public static final String coloanaPrenume = "prenume";
	public static final String coloanaGrupa = "grupa";
	public static final String coloanaSerie = "serie";
	public static final String coloanaAn = "an";
	public static final String coloanaSpecializare = "specializare";
	
	private final IntegerProperty id;
	private final StringProperty nume;
	private final StringProperty prenume;
	private final IntegerProperty grupa;
	private final StringProperty serie;
	private final IntegerProperty an;
	private final StringProperty specializare;
	
	@Override
	public String toString() {
		return String.format(" Id: %s Nume: %s Prenume: %s", getId().toString(), getNume(), Prenume());
	}
	
	public Student() {
		this.id = new SimpleIntegerProperty();
		this.nume = new SimpleStringProperty();
		this.prenume = new SimpleStringProperty();
		this.grupa = new SimpleIntegerProperty();
		this.serie = new SimpleStringProperty();
		this.an = new SimpleIntegerProperty();
		this.specializare = new SimpleStringProperty();
	}

	public Integer getId() {
		return id.get();
	}

	public String getNume() {
		return nume.get();
	}

	public String Prenume() {
		return prenume.get();
	}

	public Integer getGrupa() {
		return grupa.get();
	}

	public String getSerie() {
		return serie.get();
	}

	public Integer getAn() {
		return an.get();
	}

	public String getSpecializare() {
		return specializare.get();
	}

	// set eri

	public void setId(Integer valoare) {
		id.set(valoare);
	}

	public void setNume(String valoare) {
		nume.set(valoare);
	}

	public void setPrenume(String valoare) {
		prenume.set(valoare);
	}

	public void setGrupa(Integer valoare) {
		grupa.set(valoare);
	}

	public void setSerie(String valoare) {
		serie.set(valoare);
	}

	public void setAn(Integer valoare) {
		an.set(valoare);
	}

	public void setSpecializare(String valoare) {
		specializare.set(valoare);
	}
	
	
	
	
	public IntegerProperty idProprietate() {
		return id;
	}
	
	public StringProperty numeProprietate() {
		return nume;
	}
	
	public StringProperty prenumeProprietate() {
		return prenume;
	}
	
	public IntegerProperty grupaProprietate() {
		return grupa;
	}
	
	public StringProperty serieProprietate() {
		return serie;
	}
	
	public IntegerProperty anProprietate() {
		return an;
	}
	
	public StringProperty specializareProprietate() {
		return specializare;
	}
	
	

}