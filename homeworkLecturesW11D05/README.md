#JSON Client-Sever komunikacija

##Cilj:

Potrebno je napraviti Client-Server aplikacije (Client i Server), koje me�usobno komuniciraju.

Komunikacija se odvije putem JSON stringa.




Client �alje upit na Server, a Server na taj upit odgovara sa random re�enicom iz fajla.

Potrebno je u file upisati odre�eni broj re�enica, koje �e Server randomly �itati vra�ati na Client.

Server prvo instancira BitResponse objekat, koji nakon toga pretvara u JSON i vra�a na Client.




Odgovor Servera je u JSON formatu.

Client �ita JSON i pretvara ga u BitResponse objekat.




##Specifikacije:

BitRespones objekat se sastoji od:

- message (String)

- timestamp (Date)




JSON izgleda ovako:

{

"message": "Va�a poruka",

"timestamp": "2015-07-31 17:55:00"

}




Za ovaj zadatak, potrebno je korisiti Jackson biblioteku.
