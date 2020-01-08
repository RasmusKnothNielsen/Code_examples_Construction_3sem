#### Spring
Spring er et framework til at udvikle en web-applikation. Frameworket kommer med en masse
indbygget funktionalitet, som udvikleren hurtigt kan drage nytte af ved at bruge 
de indbyggede annotationer.

#### RESTful API
Når GET, PUT, POST, OG DELETE understøttes er der tale om et RESTful API
En RESTful API er et interface mellem to systemer. API skal forstås som det der tillader et system
at interagere med et andet system. 
I en web service vil det være klienten der kalder serveren vha. API'et.
#
###HTTP Verber
- TODO: Skal tænkes ind at postman skal bruges til andet end get. og browseren kun er til get
##### POST: 
- Bruges til at sende data til at oprette eller ændre en ressource.
- Data i en POST request sendes i body.

##### GET: 
- Bruges kun til at requeste data
- Kan ikke bruges til at ændre data.
- Du vil aldrig sende en body med en GET request da du ikke vil ændre eller oprette data.

##### DELETE: 
- En DELETE request sletter en enkelt ressource.

##### PUT:
- Data i en PUT request sendes i body.
- Bruges til at ændre data.
#
#### JPA (Java Persistence API)
JPA er et API til persistence, dvs. at med JPA kan du let koble din javakode sammen med fx SQL eller
andre databaser. Det er et API til at gemme dine objekter i en IKKE midlertidig database. (Persisting 
the objects).

#### CrudRepository 
Et interface til generelle CRUD (Create, Read, Update, Delete) operationer. Interfacet indeholder
meget funktionalitet der letter udviklerens arbejde, i form af at den stort set skriver dine SQL Queries 
for dig fx. `findById(Long id)` dette fortolker CrudRepository som en SQL query og skriver det til 
databasen - dette gøres ved brug af JPA.
#
###GenerationType
####GenerationType.AUTO
Default value, lets the persistence provider choose a generation strategy
Often this will be GenerationType.SEQUENCE, but not always.
It is dependent on the database specific dialect.

####GenerationType.IDENTITY
Relies on a auto-incremented collumn in the database, and is done one the database side.
A new value is generated at each new insert statement.
Not the best option from a performance point of view.
This is because, as the Id is used, it has to be made in the database.
This is done by doing the INSERT statement at the beginning, and SELECT the id from the table.
Thus it can not be used for JDBC batching.

####GenerationType.SEQUENCE
What is often selected by the GenerationType.AUTO annotation.
Is rather quick, since it only need to do a select statement on the database, to find out what the next number in
sequence is.
That is, id the last entry in our table has id = x, the new id has to b x+1.
It is also possible to use a @SequenceGenerator annotation to get a specific sequence of id's.

####GenerationType.TABLE
Rarely used. Slows down application.
Works by storing and updating its current value in a database table.
It has to use pesimistic locks which puts all transactions into sequential order.
Often better to use GenerationType.SEQUENCE.