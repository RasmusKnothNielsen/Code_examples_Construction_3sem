package encapsulation.publicencapsulation;

import encapsulation.Encapsulation;

// Klasse der nedarver fra Encapsulation
// Kan tilgå public og protected members

public class ProtectedEncapsulation extends Encapsulation {

    public static void main(String[] args) {
        ProtectedEncapsulation encapsulation = new ProtectedEncapsulation();

        encapsulation.publicField = 1;
        encapsulation.protectedField = 2;
        //encapsulation.packagePrivateField = 3;
        //encapsulation.privateField = 4;

    }
}
