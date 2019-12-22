package encapsulation;

// Klasse i samme package som Encapsulation
// Kan tilgå alt undtagen private members

public class PackageEncapsulation {

    public static void main(String[] args) {

        Encapsulation encapsulation = new Encapsulation();

        encapsulation.publicField = 1;
        encapsulation.protectedField = 2;
        encapsulation.packagePrivateField = 3;
        //encapsulation.privateField = 4;

    }

}
