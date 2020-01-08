#Hvad er Spring?
Spring er et applikationsframework til Java platformen, og er bygget efter koncepterne med "Inversion of Control" og "Dependency Injection"\
IoC; "Når X sker - så gør Y". (Eks. Når der trykkes "Godkend" - så skrives der til databasen).\
DI; "Giv klasser instanser af deres dependencies i stedet for at de selv skal instantiere dem."
//TODO - FIND EKSEMPEL?

Spring er således meget velegnet til udvikling af web-applikationer.\
Desuden er Spring pakket med en masse indbygget funktionalitet, som udvikleren hurtigt kan drage nytte af ved at bruge de indbyggede annotationer.

#Spring MVC
Spring MVC følger Model-View-Controller design pattern, ved at gøre brug af `DispatcherServlet`.\
`DispatcherServlet` er en klasse der modtager requests, og sender dem til de korrekte ressourcer såsom Controllers, Models og Views.

![Spring Web MVC](spring-web-model-view-controller.png?raw=true "Spring Web MVC")

##Model
En model indeholder data tilhørende applikationen. Dette kan være enkelte objekter, eller samlinger af objekter.\
I kodeeksemplet er der `Student`-klassen. Typisk hænger model-klasserne meget sammen med, hvad man ønsker at gemme i database.

##View
Et view repræsenterer den givne information på et bestemt format. Til dette har vi lært at benytte HTML og JavaScript med Thymeleaf.\
I kodeeksemplet er sammenlagt 4 sider, der hver især viser lidt forskellig funktionalitet.

##Controller
En controller indeholder applikationens "business logic". Her benyttes `@Controller` annotationen til at markere at klassen er en controller.\
I kodeeksemplet findes `MainViewController`. Der håndteres HTTP requests. I eksemplet kun GET-requests. For POST requests se evt. GoatGrindr. 

##Front Controller
I Spring MVC er det klassen `DispatcherServlet` der fungerer som Front Controller. Den er ansvarlig for flowet igennem applikationen.

#Fordele ved Spring MVC
- Separate Roller: Klassernes opgaver er tydeligt opdelt. Således er det langt nemmere at holde overblik, og lave specialiserede objekter til hver opgave.
- Hurtigere udvikling: Det at alting er så tydeligt opdelt faciliterer hurtig og parallel udvikling.

#Thymeleaf
Thymeleaf er en Java template engine, der kan arbejde med HTML, XML, text, JavaScript og CSS filer.\
Det benyttes til dynamisk at kunne sætte indholdet af siderne alt efter informationer i resten af systemet.\
Der skal blot gives et `Model`-objekt med, og så kan man, med Thymeleaf, tilgå objektet og dets attributter fra eksempelvis HTML eller JavaScript filen. 
Thymeleaf giver mulighed for at have variabler og logic i HTML koden.

#jQuery - AJAX
jQuery er et JavaScript library, der gør en håndfuld ting meget lettere at håndtere.\
Ting som f.eks. HTML/DOM og CSS manipulation, HTML eventhåndtering og AJAX kald.\
DOM = Document Object Model.

AJAX = Asynchronous JavaScript and XML.\
AJAX omhandler loading og visning af data uden at hele siden behøver at blive opdateret.

For eksempler på POST-requests se GoatGrindr - ressources/static/js/MainPage.js - l. 347-386
//TODO - Smid koden ind her