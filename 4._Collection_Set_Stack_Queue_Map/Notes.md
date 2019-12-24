**Collection**:\
Collection er et interface der repræsenterer en gruppe af Objekter, disse objekter er det pågældende Collection's 
elementer. Collection er root interface i Collection hierarkiet. Alle interfaces der implementerer Collection
eller implementerer sub-interfaces til Collection nedarver alle metoder fra Collection interfacet. Collection
nedarver fra superinterfacet Iterable som er det "højeste" interface i interface hierarkiet.

Alle Interfaces/klasser nedenfor nedarver alt funktionalitet fra Collection ved at enten extende eller implementerer 
Collection eller sub-interfaces til Collection.

**Set**:\
Set er en collection af elementer, hvoraf ingen duplicates er tilladte. Set extender Collection og er et interface.
Dvs. at Set ikke kan instantieres uden at blive implementeret af en klasse.\
Hvad bruges det til?
- Brugernavne er et godt eksempel på et Set. Du vil aldrig have to klienter med det samme brugernavn.

**Stack**:\
Stack er en klasse der følger LIFO princippet, Last In First Out. Ved en Stack kan du kun kigge på det øverste element, 
og ikke andre elementer i Stacken. Deque har samme funktionalitet, samt meget mere og kan stadig vedholde LIFO
princippet - Deque er at foretrække af de to.\
`TODO:`Hvad bruges det til?

**Queue**:\
Queue er et interface der følger FIFO princippet, First In First Out. Queue extender Collection.\
Hvad bruges det til?
- Det kan fx bruges hvis du vil være helt sikker på at du følger FIFO princippet og kun vil indsætte data i den ene 
ende af din queue og trække det ud i den anden ende af din queue.

**Deque** - Ikke nødvendigt at nævne Deque\
Deque = Double ended Queue. Deque er et interface der extender Queue. Deque kan både følge princippet FIFO og LIFO. Med
 deque kan der tages elementer ud af begge ender og sættes ind i begge ender.
Hvad bruges det til?
- Hvis man har flere processorer som kører simultant...... 

**Map**:\
Map er en del af Java Collections, men ikke en del af Collection interfacet.
Map er et interface hvor du kan mappe en key til en værdi. Et Map objekt kan ikke instantieres uden at 
blive instantieret som fx TreeMap eller HashMap (da det er et interface). Map kan ikke indeholde duplicate keys, 
men kan godt indeholde duplicate værdier. Det kan ikke indeholde null keys, men kan indeholde flere null værdier - 
dette kan være brugbart hvis man ved hvad man skal bruge den specifikke key, men endnu ikke ved hvad den tilhørende 
value skal være. 
Alt efter implementeringen kan rækkefølgen og dermed sorteringen ikke garanteres at være i den naturlige rækkefølge. 
Eksempelvis TreeMap sorterer keys'ne i den naturlige rækkefølge, hvorimod HashMap sorterer dem alt efter hvad Hash
værdien er. Hvis man vil garantere rækkefølgen kan man implementere en Comparator som sorterer Map'et. HashMap 
funktioner er *oftest* konstante O(1), men det kommer an på hvordan Hashingen er implementeret.\
Hvad bruges det til?
- Hvis vi vil gemme elementer som vi kan referere til via specifikke keys kan Map være idéelt. Et eksempel kunne være
et fornavn samt efternavn som værdi og et medarbejderID eller brugernavn som key. På denne måde kan alle medarbejdere 
have et unikt ID, men der kan godt være flere med det samme navn.