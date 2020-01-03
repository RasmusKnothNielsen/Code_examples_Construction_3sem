**Multithreading**:\
Threads er uafhængige. Dvs. at hvis man kører flere threads på én gang (multithreading) så vil hele programmet ikke
 lukke ned hvis én thread kaster en Exception. Det vil blot lukke den enkelte thread.
Thread-based multitasking (multithreading) deler den samme allokerede plads adresse i hukommelsen. Multithreading er 
er når man kører flere threads i det samme program. Fx. i en tekst editor kan vi skrive tekst i en thread, mens en 
anden thread tjekker ordbogen igennem for stavefejl. \
Hvad bruges det til?
- Vi bruger det til at sikre os, at selvom én del af applikationen (en thread) crasher, så er resten af applikationen
uberørt af dette. Det kræver færre CPU resourcer at håndtere flere Threads frem for at håndtere flere processer.
Et eksempel i en chatserver kunne være at hver gang socketen lytter til en port og får data ind, instantieres der en ny
Thread til klienten som lige har forbundet. På denne måde ville serveren være uberørt hvis den ene Thread crashede.

**Thread Scheduling**:\
Thread Scheduling er en måde hvorpå man kan prioritere threads. Det handler helt simpelt om hvilken rækkefølge de 
forskellige threads bliver kørt i, givet at den næste thread er i Runnable state hvilket betyder at den er klar til at 
starte så snart den få lov af "Thread Scheduleren". Threads kan i Java prioriteres med metoden setPriority fra Threads 
klassen, hvis maskinen som kører programmet er ved at løbe tør for ressourcer vil prioriteten tages højde for, men hvis
dette ikke er tilfældet kan rækkefølgen ikke garanteres. 
- yield() metoden kan benyttes hvis man har en thread der kører i en længere periode, men ikke konstant er 
vigtig. Hvis yield() metoden køres på en Running Thread vil den lade andre Threads med højere prioritet køre og derefter
starte igen. \
- sleep() metoden stopper tråden i en given periode eksempel: `Thread.sleep(5000)` stopper tråden i 5 sekunder
- join() metoden sørger for at to threads ikke kan køre "simultant", men gør at den næste Thread først starter når den
igangværende Thread er færdig med at køre. Hvis Join() ikke kaldes ville vi ikke kunne garantere hvilken thread der
pt. kører.\
Hvad bruges det til?
- Hvis man har mange threads kørende på samme tid kan det bruges til at prioritere hvilken rækkefølge de forskellige
threads skal køres i, hvornår de skal starte, hvornår de skal stoppe og hvornår de midlertidigt skal stoppe.

`TODO: DOBBELTTJEK DENNE`
**Thread Groups**:\
Grupperer threads så de kan behandles som én unit.
Hvad bruges det til?
- Hvis man eksempelvis vil stoppe en række threads på samme tid kan man gruppere dem med ThreadGroups og behandle dem
derefter.


**Multiprocessing**:\
Multiprocessing er når man kører flere processer på den samme CPU, Dvs. at de kører ikke på den samme core, men på 
hver deres core. Dette er modsat multithreading som kører på den samme core.
Hvad bruges det til?
- Bruges til at køre flere processer parallelt, dette øger mængden af arbejde som kan gøres på en units tid.

**Concurrency**:\
Concurrency indebærer det at kunne køre flere applikationer eller flere dele af en applikation simultant. I Java bliver
dette muligt med threads, da det at køre flere threads "concurrently" / på samme tid er concurrency. Concurrency kan 
både være multiproccessing og multithreading. \
Hvad bruges det til?
- Se Multiprocessing og multithreading

**Deadlock**:\
Deadlock er defineret ved at én eller flere threads venter på en anden thread og den thread aldrig bliver færdig.
Når to eller flere threads forsøger at tilgå den samme ressource på samme tid opstår der en deadlock. Dvs. at hvis 
ressourcen er optaget eller blokeret af en thread, er det ikke muligt for en anden thread at tilgå ressourcen, derfor 
er det vigtigt at hvis en lock er i brug og skal bruges senere er det vigtigt at den releases igen. Ellers er det netop 
at Deadlock opstår.\
Hvad bruges det til?
- Udviklere vil aldrig bevidst forsøge at opnå Deadlock, én af mange grunde er at det kan crashe applikationen i runtime.

**Semaphore**:\
Hvis udvikleren vil tildele én eller flere threads adgang til en vis ressource kan dette gøres med semaphore. Semaphore
fungerer næsten ligesom en synchronized lock. Før den givne thread kan tilgå ressourcen skal locken først acquires 
`semaphore.acquire()`. Når locken er acquired har threaden fuld tilgang til ressourcen, men andre threads kan først tilgå
ressourcen når locken er blevet released igen `semaphore.acquire()`. Det antal af threads som kan tilgå den givne
ressource bestemmes ved instantieringen af en semaphore `new Semaphore(1)`. Integeren i parameteren indikerer hvor mange
threads der kan tilgå ressourcen.\
Hvad bruges det til?
- Hvis udvikleren ønsker at et maks antal threads skal kunne tilgå en bestemt ressource, er Semaphore bestemt et godt valg.


**Synchronized**:\
Synchronized bruges når man kun vil give én thread adgang af gangen til en specifik del af koden. Synchronized kan 
gøre en klasse Thread-safe. Idet at kun én thread kan tilgå den givne ressource af gangen. For at bruge synchronization 
benytter man en "lock", denne lock skal være et objekt. Ved at benytte synchronized betyder det at kun én thread kan 
tilgå ressourcen, dette implementeres ved at denne lock kommer i brug og bruges af den specifikke thread som tilgår den.
For at denne lock kan bruges af andre Threads skal den releases igen, hvilket gøres når synchronized metoden er færdig.
Man kan både bruge synchronized på en hel metode eller bruge den på en del af funktionaliteten i metoden.
Hvad bruges det til?
- Det bruges til at gøre en klasse Thread-safe så der ikke opstår en race condition. En race condition er når to threads
forsøger at tilgå den samme data og de "racer" om at tilgå/ændre dataen på samme tid. Hvis du ikke har håndteret din
thread scheduling ordentligt kan det have uforudsigelige konsekvenser for din data. 
Et eksempel vil være hvis du har en thread der tjekker at et tal i en udregning er 'X' og efterfølgende eksekverer 
udregningen. Hvis en anden thread imellem den første threads tjek og udregning går ind og ændrer på 'X' ville dette 
resultere i et uforudsigeligt og upålideligt resultat.