# # Assignment2_DBD

**[Assignment Link](https://datsoftlyngby.github.io/soft2021spring/resources/1fd325b2-assignment_column_db.pdf)**  

#### Author
Morten Feldt
***
#### Task 1
NoSQL-databaser har mening fordi, de i modsætning til SQL-databaser – ikke kræver at du laver et fastsat skema inden brug med bestemte variabel typer, derudover er NoSQL også mulige at køre distribueret og fejl tolerant, hvilket betyder, at hvis en server går ned, kan databasen stadig køre. Derudover er NoSQL også mulig i horizontal scaling på flere servere.

Cap Theorem er en betegnelse af 3 teorier, hvor af 2 af dem kan danne betegnelse for bestemte typer af NoSQL. Consistency betyder at enten gennemføres en transaktion ellers gøres intet. Availability menes at der altid kan gives et response, men ikke altid med den seneste data. Partition tolerance betyder, at man ikke er sårbar overfor server fejl eller nedbrud. 

HBase er god til de områder, hvor der er meget trafik og store mængder data f.eks. Facebook Messenger, som vi så i slides, med 60 milliarder beskeder pr. måned.
***
#### Task 2
##### 1. What is a bloom filter?
Bloom filter er en propalistisk datastruktur, som kan tjekke om et objekt er i set eller ej. Det kan også give falske positiver, som f.eks. hvis flere bit er sat i forvejen, og man kommer med et objekt som matcher de satte bit, kan det give en falsk positiv. Dermed kan man sige, at jo flere objekter som er i et set – jo større chance for falske positiver. Man får en afklaring på om muligheden for at et element er i et set eller ikke er i et set.

##### 2. What is an advantage of bloom filters over hash tables?
Bloom filter består af flere hashfunktioner, mens en hash table kun består af en hash funktion.
Bloom filter implementerer flere hashfunktioner for at minimere kollisioner i et set.

##### 3. What is a disadvantage of bloom filters?
Der er falske positive, hvilket betyder, at du ikke altid kan være garanteret at det element du søger efter, er i et set. Du kan ikke få adgang til selve elementet, men blot en svar på om elementet er i et set eller ikke kan være i et set. Man kan ikke delete fra et Bloom Filter.

##### 4. Using your language of choice, implement a bloom filter with add and check functions. The backing bit-array can simply be a long (64 bit integer)
Se kode til denne task i mappen **[Task2](https://github.com/SOFT2021SPRING-Assignments-DBD-MF/Assignment2_DBD/tree/main/Task2)**.

##### 5. If you are to store one million ASCII strings with an average size of 10 characters in a hash set, what would be the approximate space consumption?
15.000.000 bits

##### 6. The following equation gives the required number of bits of space per inserted key, where E is the false positive rate
b = 1.44log2(1/E)

##### 7. How many bits per element are required for a 1% false positive rate?
10 bits – fordi ovenstående formel fra punkt 6 med følgende udregning:  
1.44*log2(1/0.01) – ”0.05” er lig med de 5%.

##### 8. How many bits per element are required for a 5% false positive rate?
7 bits – fordi ovenstående formel fra punkt 6 med følgende udregning:  
1.44*log2(1/0.05) – ”0.05” er lig med de 5%.

##### 9. If you are to store one million ASCII strings with an average size of 10 characters in a bloom filter, what would be the approximate space consumption, given an allowed false positive rate of 5%?
FORMEL: -(n * math.log(p))/(math.log(2)^2)  
n = antal elementer  
p = falsk positiv procent i decimal  
-(1000000*(-2,99) / 0,4761 = 6.280.193 bits

***
#### Task 3
##### 1. Generate Huffmann Code (and draw the Huffmann Tree) based on thefollowing string: “beebs beepps!!!!! their eerie ears hear pears”
Se billede og filer i mappen **[Task3](https://github.com/SOFT2021SPRING-Assignments-DBD-MF/Assignment2_DBD/tree/main/Task3)**.

##### 2. How many bits is the compressed string? How many bits is the raw ASCII string?
Compressed string = 146 bits  
ASCII string = 360 bits (45 tegn * 8 bit pr. tegn)

##### 3. Compress “pete is here” with the Huffmann tree from before
10110111110001110111101000110111110100101

##### 4. Write your own 10 word sentence. Generate the Huffmann Code (a new Huffmann Tree), and write a new compressed message (ie. in binary)
Se bits filer i mappen **[Task3](https://github.com/SOFT2021SPRING-Assignments-DBD-MF/Assignment2_DBD/tree/main/Task3)**.
***
#### Task 4
Se kode til denne task i mappen **[Task4](https://github.com/SOFT2021SPRING-Assignments-DBD-MF/Assignment2_DBD/tree/main/Task4)**.
***
