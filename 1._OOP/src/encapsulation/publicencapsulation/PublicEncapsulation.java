package encapsulation.publicencapsulation;

import encapsulation.Encapsulation;

// Klasse i anden en anden package end Encapsulation
// Kan kun tilgå public members

public class PublicEncapsulation {
    public static void main(String[] args) {

        Encapsulation encapsulation = new Encapsulation();

        encapsulation.publicField = 1;
        //encapsulation.protectedField = 2;
        //encapsulation.packagePrivateField = 3;
        //encapsulation.privateField = 4;
    }
}
