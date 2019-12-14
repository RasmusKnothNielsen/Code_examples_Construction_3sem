#Interfaces
Et interface er en kontrakt. En række minimumskrav som en implementerende 
klasse skal leve op til.
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

--- "Interface Instanser"

`Default Methods` er metoder med `default` keyword, hvor selve metoden 
alligevel er implementeret i interfacet. Dette kan være praktisk, 
hvis man har et omfattende program, og mange klasser implementerer 
interfacet, men interfacet skal opdateres med ny funktionalitet. 
Således kan man undgå at skulle ind i hver enkelt implementerende klasse 
og håndtere ændringerne.

####InterfaceExample

####InterfaceGenerics

---
---
---
#Generics