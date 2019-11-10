package encapsulation;

// Alle field kan tilgås fra samme klasse

public class Encapsulation {
    // Klasser kan være public eller package-private (default)

    // Members i en klasse kan have en access-modifier der viser hvilke andre klasser der har adgang.
    // Access modifiers kan være public, proctected, private og package-private (default).

    // Kan tilgås af alle
    public int publicField;

    // Kan tilgås af klasser i samme package og også af klasser der nedarver fra denne klasse.
    protected int protectedField;

    // Default (package-private) kan tilgås af klasser i samme package.
    int packagePrivateField;

    // Kan kun tilgås fra denne klasse
    private int privateField;

    public static void main(String[] args) {
        Encapsulation encapsulation = new Encapsulation();

        encapsulation.publicField = 1;
        encapsulation.protectedField = 2;
        encapsulation.packagePrivateField = 3;
        encapsulation.privateField = 4;
    }

}
