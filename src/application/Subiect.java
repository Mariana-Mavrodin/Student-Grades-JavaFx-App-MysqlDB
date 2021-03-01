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
public class Subiect {
	public static final String coloanaIdMaterie = "id";
	public static final String coloanaDenumireMaterie = "Denumire";
	public static final String coloanaPunctajPartial = "Partial";
	public static final String coloanaPunctajExamen = "Examen";
	public static final String coloanaPunctajColocviu = "Colocviu";
	
	private final IntegerProperty idMaterie;
	private final StringProperty denumireMaterie;
	private final IntegerProperty partial;
	private final IntegerProperty examen;
	private final IntegerProperty colocviu;
	
	
	public Subiect() {
		this.idMaterie = new SimpleIntegerProperty();
		this.denumireMaterie = new SimpleStringProperty();
		this.partial = new SimpleIntegerProperty();
		this.examen = new SimpleIntegerProperty();
		this.colocviu = new SimpleIntegerProperty();
	}

	public Integer getIdMaterie() {
		return idMaterie.get();
	}
	
	public String getDenumireMaterie() {
		return denumireMaterie.get();
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
	
	public void setIdMaterie(Integer valoare) {
		idMaterie.set(valoare);
	}

	public void setDenumireMaterie(String valoare) {
		denumireMaterie.set(valoare);
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
	
	 public IntegerProperty idMaterieProprietate() {
		 return idMaterie;
	 }
	
	 public StringProperty denumireMaterieProprietate() {
		 return denumireMaterie;
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
}
