/*CREATE TABLE Grupa
(
	id_grupa INT PRIMARY KEY IDENTITY(1,1),
	nazwa varchar(255) NOT NULL
);
GO

CREATE TABLE Pasmo
(
	id_pasmo INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(255) NOT NULL,
	id_grupa INT
);
GO

CREATE TABLE Punkt
(
	id_punkt INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(255) NOT NULL,
);
GO

CREATE TABLE Odcinek
(
	id_odcinek INT PRIMARY KEY IDENTITY(1,1),
	id_punkt_poczatkowy INT NOT NULL,
	id_punkt_koncowy INT NOT NULL,
	punkty_od INT,
	punkty_do INT,
	id_pasmo INT,
	otwarty BIT
);
GO */
-------------GRUPA TATRY I PODTATRZE--------------------------------------
INSERT INTO Grupa (nazwa)
VALUES ('TATRY I PODTATRZE');
GO


-------------PASMO TATRY WYSOKIE--------------------------------

INSERT INTO Pasmo(nazwa, id_grupa)
VALUES ('Tatry Wysokie',IDENT_CURRENT('Grupa'));
GO

------------- PUNKTY


INSERT INTO Punkt (nazwa)
VALUES ('Dolina Filipka'); ---6/3

INSERT INTO Punkt (nazwa)
VALUES ('Wierch Poroñca (1036 m)'); ---6/4
INSERT INTO Punkt (nazwa)
VALUES ('Palenica Bia³czañska'); ---4/2
INSERT INTO Punkt (nazwa)
VALUES ('Polana pod Wo³oszynem (1245 ÷ 1320 m)'); ---3/3

INSERT INTO Punkt (nazwa)
VALUES ('Rusinowa Polana (1170 ÷ 1300 m)'); ---- CEL


-----------------------------TWORZENIE ODCINKÓW z celem Rusinowa Polana (1170 ÷ 1300 m)

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 3,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,2,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 6,4,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-4 , IDENT_CURRENT('Punkt'), 6,3,IDENT_CURRENT('Pasmo'),1);





----------------- £ysa Polana ------------------------------------



INSERT INTO Punkt (nazwa)
VALUES ('Palenica Bia³czañska'); ---1/1
INSERT INTO Punkt (nazwa)
VALUES ('Wierch Poroñca (1036 m)'); ---3/4

INSERT INTO Punkt (nazwa)
VALUES ('£ysa Polana'); ---- CEL


INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 3,4,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 1,1,IDENT_CURRENT('Pasmo'),1);


----------------------------------------------- Gêsia Szyja (1489 m)---------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Rusinowa Polana (1170 ÷ 1300 m)'); ---4/1
INSERT INTO Punkt (nazwa)
VALUES ('Rówieñ Waksmundzka'); ---2/1


INSERT INTO Punkt (nazwa)
VALUES ('Gêsia Szyja (1489 m)'); ---- CEL



INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 2,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,1,IDENT_CURRENT('Pasmo'),1);




--------------------------------- Rówieñ Waksmundzka---------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Psia Trawka'); ---5/3
INSERT INTO Punkt (nazwa)
VALUES ('Polana pod Wo³oszynem (1245 ÷ 1320 m)'); ---4/2
INSERT INTO Punkt (nazwa)
VALUES ('Czerwony Staw w Dolinie Pañszczycy (1654 m)'); ---4/6
INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK na Hali G¹sienicowej (1500 m)'); ---7/8





INSERT INTO Punkt (nazwa)
VALUES ('Rówieñ Waksmundzka'); ---- CEL


INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 7,8,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,6,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 4,2,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-4 , IDENT_CURRENT('Punkt'), 5,3,IDENT_CURRENT('Pasmo'),1);



---------------------- Psia Trawka-------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK na Hali G¹sienicowej (1500 m)'); ---4/7
INSERT INTO Punkt (nazwa)
VALUES ('Brzezin (T.03)'); ---5/3


INSERT INTO Punkt (nazwa)
VALUES ('Psia Trawka'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 5,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,7,IDENT_CURRENT('Pasmo'),1);



----------------------  Wodogrzmoty Mickiewicza-------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Palenica Bia³czañska'); ---4/3
INSERT INTO Punkt (nazwa)
VALUES ('Polana pod Wo³oszynem (1245 ÷ 1320 m)'); ---2/4
INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK w Roztoce'); ---2/1

INSERT INTO Punkt (nazwa)
VALUES ('Wodogrzmoty Mickiewicza'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 2,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 2,4,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 4,3,IDENT_CURRENT('Pasmo'),1);


  
----------------------  Schronisko PTTK nad Morskim Okiem (1410 m)-------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Wodogrzmoty Mickiewicza'); ---8/5
INSERT INTO Punkt (nazwa)
VALUES ('Wokó³ Morskiego Oka'); ---2/2


INSERT INTO Punkt (nazwa)
VALUES ('Psia Trawka'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 5,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,7,IDENT_CURRENT('Pasmo'),1);



----------------------   Czarny Staw nad Morskim Okiem (1583 m) -------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK nad Morskim Okiem (1410 m)'); ---4/2
INSERT INTO Punkt (nazwa)
VALUES ('Rysy (2499 m)'); ---4/13
INSERT INTO Punkt (nazwa)
VALUES ('Miêguszowiecka Prze³êcz pod Ch³opkiem (2307 m)'); ---3/10

INSERT INTO Punkt (nazwa)
VALUES ('Czarny Staw nad Morskim Okiem (1583 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 3,10,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,13,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 4,2,IDENT_CURRENT('Pasmo'),1);




----------------------  Dolina za Mnichem (1785 ÷ 2100 m)-------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK nad Morskim Okiem (1410 m)'); ---6/2
INSERT INTO Punkt (nazwa)
VALUES ('Wrota Cha³ubiñskiego (2022 m)'); ---1/3


INSERT INTO Punkt (nazwa)
VALUES ('Dolina za Mnichem (1785 ÷ 2100 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 1,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 6,2,IDENT_CURRENT('Pasmo'),1);




----------------------   Szpiglasowa Prze³êcz (2110 m) -------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Szpiglasowy Wierch (2172 m)'); ---1/1
INSERT INTO Punkt (nazwa)
VALUES ('tablica S. Bronikowskiego (1740m)'); ---8/3
INSERT INTO Punkt (nazwa)
VALUES ('Dolina za Mnichem (1785 ÷ 2100 m)'); ---4/1

INSERT INTO Punkt (nazwa)
VALUES ('Szpiglasowa Prze³êcz (2110 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 4,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 8,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 1,1,IDENT_CURRENT('Pasmo'),1);


----------------------   Schronisko PTTK w Dolinie Piêciu Stawów Polskich (1671 m) -------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('Siklawa'); ---1/1
INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK nad Morskim Okiem (1410 m)'); ---9/5
INSERT INTO Punkt (nazwa)
VALUES ('Szlak Zielonego'); ---3/1

INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK w Dolinie Piêciu Stawów Polskich (1671 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 3,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 9,5,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 1,1,IDENT_CURRENT('Pasmo'),1);



----------------------  Siklawa-------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('tablica S. Bronikowskiego (1740m)'); ---1/1
INSERT INTO Punkt (nazwa)
VALUES ('Wodogrzmoty Mickiewicza'); ---11/5


INSERT INTO Punkt (nazwa)
VALUES ('Siklawa'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 11,5,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 1,1,IDENT_CURRENT('Pasmo'),1);


----------------------  Kozi Wierch-------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Siklawa'); ---8/2
INSERT INTO Punkt (nazwa)
VALUES ('Kozia Prze³êcz (2137 m)'); ---3/0


INSERT INTO Punkt (nazwa)
VALUES ('Kozi Wierch (2291 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 3,0,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 8,2,IDENT_CURRENT('Pasmo'),1);



----------------------    Kozia Prze³êcz (2137 m) -------------------------------

INSERT INTO Punkt (nazwa)
VALUES ('tablica S. Bronikowskiego (1740m)'); ---6/2
INSERT INTO Punkt (nazwa)
VALUES ('Kozia Dolinka'); ---3/1
INSERT INTO Punkt (nazwa)
VALUES ('Prze³êcz Zawrat (2159 m)'); ---3/0

INSERT INTO Punkt (nazwa)
VALUES ('Kozia Prze³êcz (2137 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 3,0,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 3,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 6,2,IDENT_CURRENT('Pasmo'),1);




----------------------  Prze³êcz Zawrat (2159 m)-------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Czarny Staw G¹sienicowy (1624 m)'); ---8/3
INSERT INTO Punkt (nazwa)
VALUES ('tablica S. Bronikowskiego (1740m)'); ---7/3


INSERT INTO Punkt (nazwa)
VALUES ('Prze³êcz Zawrat (2159 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 7,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 8,3,IDENT_CURRENT('Pasmo'),1);


----------------------  Œwinica (2301 m)-------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Prze³êcz Zawrat (2159 m)'); ---4/3
INSERT INTO Punkt (nazwa)
VALUES ('Œwinicka Prze³êcz (2050 m)'); ---4/1


INSERT INTO Punkt (nazwa)
VALUES ('Œwinica (2301 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 4,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,3,IDENT_CURRENT('Pasmo'),1);


----------------------  Œwinicka Prze³êcz (2050 m)-------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Prze³êcz Liliowa (1952 m)'); ---3/2
INSERT INTO Punkt (nazwa)
VALUES ('Zielony Staw G¹sienicowy (1672 m)'); ---5/1


INSERT INTO Punkt (nazwa)
VALUES ('Œwinicka Prze³êcz (2050 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 5,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 3,2,IDENT_CURRENT('Pasmo'),1);


----------------------  Kozia Dolinka-------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Czarny Staw G¹sienicowy (1624 m)'); ---4/2
INSERT INTO Punkt (nazwa)
VALUES ('¯leb Kulczyñskiego przez Zadni Granat'); ---2/0


INSERT INTO Punkt (nazwa)
VALUES ('Kozia Dolinka'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 2,0,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 4,2,IDENT_CURRENT('Pasmo'),1);


----------------------  ¯leb Kulczyñskiego  -------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Kozi Wierch (2291 m)'); ---1/0
INSERT INTO Punkt (nazwa)
VALUES ('Kozia Dolinka'); ---4/1


INSERT INTO Punkt (nazwa)
VALUES ('¯leb Kulczyñskiego'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 4,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 1,0,IDENT_CURRENT('Pasmo'),1);


----------------------  Skrajny Granat (2225 m)  -------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Kozia Dolinka przez Zadni Granat'); ---6/0
INSERT INTO Punkt (nazwa)
VALUES ('¯leb Kulczyñskiego'); ---2/0
INSERT INTO Punkt (nazwa)
VALUES ('Czarny Staw G¹sienicowy (1624 m)'); ---8/2

INSERT INTO Punkt (nazwa)
VALUES ('Skrajny Granat (2225 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 8,2,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 2,0,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 6,0,IDENT_CURRENT('Pasmo'),1);




----------------------  Prze³êcz Krzy¿ne (2114 m)  -------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK w Dolinie Piêciu Stawów Polskich (1671 m)'); ---9/4
INSERT INTO Punkt (nazwa)
VALUES ('Czerwony Staw w Dolinie Pañszczycy (1654 m)'); ---8/3
INSERT INTO Punkt (nazwa)
VALUES ('Skrajny Granat (2225 m)'); ---6/0

INSERT INTO Punkt (nazwa)
VALUES ('Prze³êcz Krzy¿ne (2114 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 6,0,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 8,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 9,4,IDENT_CURRENT('Pasmo'),1);


----------------------  Prze³êcz Krab (1853 m)  -------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Koœcielec (2156 m)'); ---1/4
INSERT INTO Punkt (nazwa)
VALUES ('Zielony Staw G¹sienicowy (1672 m)'); ---3/1
INSERT INTO Punkt (nazwa)
VALUES ('Czarny Staw G¹sienicowy (1624 m)'); ---3/1

INSERT INTO Punkt (nazwa)
VALUES ('Prze³êcz Krab (1853 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 3,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 3,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 1,4,IDENT_CURRENT('Pasmo'),1);



----------------------  Dwoiœniak  -------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Prze³êcz Liliowa (1952 m)'); ---2/5
INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK na Hali G¹sienicowej (1500 m)'); ---2/1
INSERT INTO Punkt (nazwa)
VALUES ('Zielony Staw G¹sienicowy (1672 m)'); ---1/3

INSERT INTO Punkt (nazwa)
VALUES ('Dwoiœniak'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 1,3,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 2,1,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-3 , IDENT_CURRENT('Punkt'), 2,5,IDENT_CURRENT('Pasmo'),1);


----------------------  Schronisko PTTK na Hali G¹sienicowej (1500 m)  -------------------------------
INSERT INTO Punkt (nazwa)
VALUES ('Czarny Staw G¹sienicowy (1624 m)'); ---2/3
INSERT INTO Punkt (nazwa)
VALUES ('Czerwony Staw w Dolinie Pañszczycy (1654 m)'); ---4/6


INSERT INTO Punkt (nazwa)
VALUES ('Schronisko PTTK na Hali G¹sienicowej (1500 m)'); ---- CEL
 

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-1 , IDENT_CURRENT('Punkt'), 4,6,IDENT_CURRENT('Pasmo'),1);

INSERT INTO Odcinek (id_punkt_poczatkowy, id_punkt_koncowy, punkty_od, punkty_do, id_pasmo, otwarty)
VALUES ( IDENT_CURRENT('Punkt')-2 , IDENT_CURRENT('Punkt'), 2,3,IDENT_CURRENT('Pasmo'),1);



----------------- TO ROBI PORZ¥DEK Z DUPLIKATAMI, odpaliæ po kolei, bo na raz siê wysypie !!!!!!!!!!!!!!!!!! ----------

update Odcinek
set id_punkt_poczatkowy = final_id
from
  Odcinek
join
  Punkt 
on Punkt.id_punkt = Odcinek.id_punkt_poczatkowy
join
(
  select 
    nazwa,
    min (id_punkt) as final_id
  from Punkt
  group by nazwa
) min_ids
on min_ids.nazwa = Punkt.nazwa


update Odcinek
set id_punkt_koncowy = final_id
from
  Odcinek
join
  Punkt 
on Punkt.id_punkt = Odcinek.id_punkt_koncowy
join
(
  select 
    nazwa,
    min (id_punkt) as final_id
  from Punkt
  group by nazwa
) min_ids
on min_ids.nazwa = Punkt.nazwa

--deletes redundant ids from the Doubles table


delete 
from Punkt
where id_punkt not in
(
  select 
    min(id_punkt) as final_id
  from Punkt
  group by nazwa
)



SELECT * FROM Punkt
ORDER BY nazwa ASC;

SELECT o.id_punkt_poczatkowy, pp.nazwa, o.punkty_od, '>>>>>' , o.punkty_do, pk.nazwa, o.id_punkt_koncowy  FROM Odcinek AS o 
INNER JOIN Punkt AS pk ON pk.id_punkt = o.id_punkt_koncowy
INNER JOIN Punkt AS pp ON pp.id_punkt = o.id_punkt_poczatkowy
ORDER BY pk.nazwa;


SELECT pp.nazwa, o.punkty_od, '>>>>>' , o.punkty_do, pk.nazwa  FROM Odcinek AS o 
INNER JOIN Punkt AS pk ON pk.id_punkt = o.id_punkt_koncowy
INNER JOIN Punkt AS pp ON pp.id_punkt = o.id_punkt_poczatkowy
WHERE o.id_punkt_poczatkowy = 49 OR o.id_punkt_koncowy = 49
ORDER BY pk.nazwa;