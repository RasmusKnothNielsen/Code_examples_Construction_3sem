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
klassen. 
- Yield() metoden kan benyttes hvis man har en thread der kører i en længere periode, men ikke konstant er 
vigtig. Hvis Yield() metoden køres på en Running Thread vil den lade andre Threads med højere prioritet køre og derefter
starte igen. \
- Sleep() metoden stopper tråden i en given periode eksempel: Thread.sleep(5000) stopper tråden i 5 sekunder
- Join() metoden sørger for at to threads ikke kan køre "simultant", men gør at den næste Thread først starter når den
igangværende Thread er færdig med at køre. Hvis Join() ikke kaldes ville vi ikke kunne garantere hvilken thread der
pt. kører.
`TODO:` 'Thread Race'
Hvad bruges det til?
- Hvis man har mange threads kørende på samme tid kan det bruges til at prioritere hvilken rækkefølge de forskellige
threads skal køres i.

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


Hvad bruges det til?

**Deadlock**:\

Hvad bruges det til?

**Semaphore**:\

Hvad bruges det til?

**Synchronization**:\
Synchronization bruges når man kun vil give én thread adgang af gangen til en specifik del af koden
Hvad bruges det til?