#Interfaces
Et interface er en kontrakt. En række minimumskrav som en implementerende 
klasse skal leve op til.

Interfaces bruges til at mindske koblingen mellem klasser. 

Interfaces minder lidt om klasser - dog kan interfaces kun indeholde 
metodesignaturer og fields.
De indeholder altså ikke implementationen af metoderne. 

Klasser der implementerer et eller flere interfaces skal implementere 
alle interfacet's metoder. Således ved man, uden at kende noget yderligere til klassen,
hvad den som minimum har af funktionalitet.

Derudover kan interfaces nedarve (`extends`) andre interfaces. 
I sådanne tilfælde skal implementerende klasser implementere begge 
interfaces' metoder.

Interfaces anvendes til at opnå polymorfi. 
(Når flere klasser nedarver/implementerer de samme metoder, 
og håndterer dem forskelligt).

Alle fields og metoder i et interface er `public` uanset om keyword'et 
er der eller ej.

Der kan også være statiske metoder i et interface. 
Disse skal implementeres i selve interfacet.
De bruges typisk hvis der er behov for noget fast, overordnet funktionalitet. 
F.eks. kunne et `Vehicle`-interface have en statisk metode `printVehicle(Vechicle v)`.

"Interface instanser" findes ikke. Men interfaces kan bruges til at referere
til objekter af klasser der implementerer dem. F.eks:
```
Interface<Object> list = new Abstract<>();
```
Her instantieres en `Abstract`, men refereres til med `Interface`-interfacet.
Dette kan være smart da det giver let mulighed for at skrifte til andre 
datastrukturer uden at skulle omskrive ret meget. 
Hvis man opdager at `Abstract` ikke er det bedste valg længere,
så er det bare at udskifte selve instantieringen. Resten af koden vil stadig fungere.

`Default Methods` er metoder med `default` keyword, hvor selve metoden 
alligevel er implementeret i interfacet. Dette kan være praktisk, 
hvis man har et omfattende program, og mange klasser implementerer 
interfacet, men interfacet skal opdateres med ny funktionalitet. 
Således kan man undgå at skulle ind i hver enkelt implementerende klasse 
og håndtere ændringerne.


####InterfaceExample
Ovenstående er konkretiseret med kodeeksempler.

---
---
---

#Generics
Man bruger generics når man vil have funktionalitet der kan håndtere 
forskellige typer objekter, uden at man skal bekymre sig om typecasting.

Uden brug af generics vil man, uden begrænsninger, kunne alle typer 
objekter i en `Abstract`.
```
Interface v = new Abstract();
v.add("test");
v.add(10);
Integer i = (Integer) v.get(0); // Run time error
```
Som vist i ovenstående eksempel kræves der typecasting for at kunne tilgå
objekterne på original form igen. Og det er enormt svært konstant at 
kontrollere hvilken datatype man står med.

Ved brug af generics kan man begrænse hvilken type objekter man arbejder
med, og dermed også hvilken type objekter man trækker ud igen. 
```
Interface<String> v = new Abstract<>();
v.add("test");
//v.add(10); //Kan ikke længere lade sig gøre.
String s = v.get(0);
```
Således undgår man problemer med typecasting, og det bliver langt nemmere
at holde styr på ens datatyper.

####Generic Classes
En generic klasses deklaration ligner en almindelig klasses - den er bare 
efterfulgt af kommaseparerede type-parametre;
```
public class MyClass<T,U> {
    //Klassens indhold
}
``` 
Ved at instantiere en "generified" klasse med én eller flere typer, sætter man hvilke 
typer klassens generiske dele kommer til at arbejde med.
Typisk bruges `T` som navn for typen - men man kan kalde den hvad som helst.

####Generic Methods
En generic metodes deklaration kan se ud således;
```
public <T,U> void MyMethod(T input1, U input2) {
    // Metodens indehold
}
```

Selv når man arbejder med generics er det ikke sikkert at det er alle typer
objecter ens kode skal kunne håndtere. Så kan man begrænse adgangen således;
```
public <T extends Comparable<T>> void MyMethod(T input) {
    // Metodens indehold
}
```
Altså tillader man kun typer der nedarver fra `Comparable`-interfacet.\
Dette fungerer på samme måde for generic klasser.
