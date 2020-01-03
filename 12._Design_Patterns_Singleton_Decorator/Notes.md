#Decorator
Brugen af Decorator som design pattern løser en række af de samme
problemer der også ville kunne løses med nedarvning.
Decorators er dog smartere hvis der skal et stort antal nedarvninger
til, på objekter der har meget til fælles.

I kodeeksemplet er taget udgangspunkt i pizzaer.

Uden brug af decorators, vil det være nødvendigt med en specifik 
klasse til hver kombination af toppings på pizzaerne.

Det bliver hurtigt til rigtigt mange klasser, og rigtigt meget 
redundant kode - pizzaerne har ekstremt meget til fælles,
men hvis den ene har ekstra ost, så skal der en ny klasse til.

Ved brug af decorators laves der en klasse til hver dej og til hver 
topping, og så 'dekorerer' man dejen med det topping man ønsker.

Eftersom Decorators tillader at funktionalitet holdes specifikt der 
hvor der er behov for det, bruges de ofte for at holde 
"Single Responsibility"-Princippet,


---
---
---
#Singleton
Konceptet bag en Singleton er at der er tale om en klasse der kun 
bliver instantieret én gang. Denne ene instans er statisk, og kan 
tilgås mange steder fra.
Typisk har vi brugt Singletons når vi har tilgået databaser - en 
instans til at håndtere kommunikationen frem og tilbage.

FOR:
- Det er en nem måde at håndtere ting der skal være tilgængelige og 
strømlinede globalt i programmet.
- Det kan garanteres at der kun findes én instans - altså er værdier unikke.

IMOD:
- Singletons bliver ofte brugt som glorificerede globale variabler.
 Dette er skidt eftersom det skjuler dependencies i koden, i stedet for
 at fremhæve dem gennem interfaces.
- Singletons er skidt for memory management - hvis ingen bruger den,
 så forsvinder den ikke.
- Singletons er persistente, hvilket besværliggør unit tests.
 Noget af det smarte ved unit tests er at de er totalt uafhængige af
 hinanden. Ved brug af Singletons kan rækkefølgen af tests altså komme 
 til at have en betydning.

---
####ClassSingleton

Implementeringen af Singleton benyttet i ClassSingleton er nok den 
metode der er lettest af forstå.\
Vi har en statisk reference til instansen, og returnerer denne med den 
statiske `getInstance()` metode.\
Denne implementering benytter "lazy initialization" - singleton 
instansen bliver altså først oprettet det øjeblik der er brug for den.\
Dog er den ikke sikker når det kommer til multithreading. 
Dette skyldes følgende bid kode:
```
if (instance == null) {
    instance = new ClassSingleton();
}
```
Hvis to tråde kommer ind i if-blokken samtidig ender vi ud med to 
instanser af ClassSingleton, hvilket bryder med hele princippet for 
singletons.\
Dette kan omgås på flere måder. En kompleks måde ville være med brug af 
en kombination af `syncronized` og `volatile` keywords.\
Noget lettere er det at gøre som herunder, hvor der benyttes en privat 
statisk klasse til at holde instansen. Derved opnås både 
"lazy initialization" og "thread safety".
```
public class ClassSingleton {
    private static class SingletonHolder {
       public static ClassSingleton instance = new ClassSingleton();
    }
 
    public static ClassSingleton getInstance() {
        return SingletonHolder.instance;
    }

    ...
}
```
---
####EnumSingleton
De ovenstående løsninger har problemer når det kommer til 
`Serialization`/`Deserialization` og `Reflection`. 
(Dette ligger dog udenfor pensum, og bliver ikke fokuseret mere på).\
Denne implementering har ingen af disse problemer og thread-safety 
givet fra selve enum-implenteringen, der internt sikrer at kun én 
instans findes.\
Generelt anses denne implementation for for at være den bedste måde at 
lave Singletons i Java. 