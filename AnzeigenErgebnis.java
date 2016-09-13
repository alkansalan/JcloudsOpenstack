package openstack;
/*
 * Alkan Salan
 */
import java.util.Observable;

/**
 * Observable Patter Muster implementiert, damit Wenn der Thread beendet ist
 * die untere Anzeige aktualisiert wird 
 */

public class AnzeigenErgebnis extends Observable{
	
	public void aktualisieren(){
		setChanged();
		notifyObservers();
	}

}
