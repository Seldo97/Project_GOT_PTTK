CREATE DATABASE GOT_PTTK;

USE GOT_PTTK;

CREATE TABLE Rola(
	id_rola INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Uzytkownik
(
	id_uzytkownik INT PRIMARY KEY IDENTITY(1,1),
	login VARCHAR(50) UNIQUE NOT NULL,
	haslo  VARCHAR(255) NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL,
	id_rola INT NOT NULL
);


CREATE TABLE Przodownik
(
	id_przodownik INT PRIMARY KEY,
	imie VARCHAR(50) NOT NULL,
	nazwisko VARCHAR(50) NOT NULL,
	telefon VARCHAR(11) NOT NULL,
	opis VARCHAR(255),
	id_uzytkownik INT UNIQUE
);

CREATE TABLE Turysta
(
	id_turysta INT PRIMARY KEY IDENTITY(1,1),
	imie VARCHAR(50) NOT NULL,
	nazwisko VARCHAR(50) NOT NULL,
	telefon VARCHAR(11) NOT NULL,
	id_uzytkownik INT UNIQUE,
	opis VARCHAR(250),
	punkty INT
);


CREATE TABLE Grupa
(
	id_grupa INT PRIMARY KEY IDENTITY(1,1),
	nazwa varchar(50) NOT NULL
);

CREATE TABLE Grupa_Przodownik
(
	id_grupa_przodownik INT PRIMARY KEY IDENTITY(1,1), 
	id_przodownik INT NOT NULL,
	id_grupa INT NOT NULL
);

CREATE TABLE Odznaka
(
	id_odznaka INT PRIMARY KEY,
	nazwa VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE Pasmo
(
	id_pasmo INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(50) NOT NULL,
	id_grupa INT
);

CREATE TABLE Punkt
(
	id_punkt INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(50) NOT NULL,
	id_pasmo INT
);

CREATE TABLE Odcinek
(
	id_odcinek INT PRIMARY KEY IDENTITY(1,1),
	id_punkt_poczatkowy INT NOT NULL,
	id_punkt_koncowy INT NOT NULL,
	punkty_wejscie INT,
	punkty_powrot INT,
	otwarty BIT
);


CREATE TABLE Turysta_Odznaka
(
	id_turysta_odznaka INT PRIMARY KEY IDENTITY(1,1),
	id_turysta INT NOT NULL,
	id_odznaka INT NOT NULL
);

CREATE TABLE Wycieczka
(
	id_wycieczka INT PRIMARY KEY IDENTITY(1,1),
	id_turysta INT NOT NULL,
	dataod DATE,
	datado DATE,
	punkty INT
);




CREATE TABLE Status_wycieczka
(
	id_status_wycieczka INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(50)

);


CREATE TABLE Wycieczka_odcinek
(
	id_wycieczka_odcinek INT PRIMARY KEY IDENTITY(1,1),
	id_wycieczka INT NOT NULL,
	id_odcinek INT NOT NULL,
	data DATETIME NOT NULL,
	id_status_wycieczka INT NOT NULL,
	liczba_punktow INT

);



CREATE TABLE Ksiazeczka
(
	id_ksiazeczka INT PRIMARY KEY IDENTITY(1,1),
	id_turysta INT NOT NULL
);





CREATE TABLE Ksiazeczka_wycieczka
(
	id_ksiazeczka_wycieczka INT PRIMARY KEY IDENTITY(1,1),
	id_ksiazeczka INT NOT NULL,
	id_wycieczka INT NOT NULL,
	zatwierdzono BIT
);




CREATE TABLE Zdjecie_wycieczka
(
	id_zdjecie_wycieczka INT PRIMARY KEY IDENTITY(1,1),
	id_wycieczka INT NOT NULL,
	sciezka VARCHAR(255),
	opis VARCHAR(255)

);


---------------------------------------------------------------------------------
-----------DEFINICJE KLUCZY OBCYCH-----------------------------------------------

ALTER TABLE dbo.Uzytkownik
ADD CONSTRAINT FK_Uzytkownik_Rola
FOREIGN KEY (id_rola)
REFERENCES dbo.Rola(id_rola)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Przodownik 
ADD CONSTRAINT FK_Przodownik_Uzytkownik
FOREIGN KEY (id_uzytkownik)
REFERENCES dbo.Uzytkownik(id_uzytkownik)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Turysta 
ADD CONSTRAINT FK_Turysta_Uzytkownik
FOREIGN KEY (id_uzytkownik)
REFERENCES dbo.Uzytkownik(id_uzytkownik)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Punkt 
ADD CONSTRAINT FK_Punkt_Pasmo
FOREIGN KEY (id_pasmo)
REFERENCES dbo.Pasmo(id_pasmo)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Grupa_Przodownik
ADD CONSTRAINT FK_Grupa_Przodownik_Przodownik
FOREIGN KEY (id_przodownik)
REFERENCES dbo.Przodownik(id_przodownik)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Grupa_Przodownik
ADD CONSTRAINT FK_Grupa_Przodownik_Grupa
FOREIGN KEY (id_grupa)
REFERENCES dbo.Grupa(id_grupa)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Pasmo
ADD CONSTRAINT FK_Pasmo_Grupa
FOREIGN KEY (id_grupa)
REFERENCES dbo.Grupa(id_grupa)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO


------------!!!!!!!!!!!!!-------------Trzeba zapewniæ unikalnoœæ odcinków!!!!!!!!!!

ALTER TABLE dbo.Odcinek
ADD CONSTRAINT FK_Odcinek_Punkt_Poczotkowy
FOREIGN KEY (id_punkt_poczatkowy)
REFERENCES dbo.Punkt(id_punkt)
ON DELETE CASCADE
ON UPDATE CASCADE;

GO

ALTER TABLE dbo.Odcinek
ADD CONSTRAINT FK_Odcinek_PunktKoncowy
FOREIGN KEY (id_punkt_koncowy)
REFERENCES dbo.Punkt(id_punkt);
GO


ALTER TABLE dbo.Turysta_Odznaka
ADD CONSTRAINT FK_TurystaO_dcznaka_Turysta
FOREIGN KEY (id_turysta)
REFERENCES dbo.Turysta(id_turysta)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO


ALTER TABLE dbo.Turysta_Odznaka
ADD CONSTRAINT FK_Turysta_Odcznaka_Odznaka
FOREIGN KEY (id_odznaka)
REFERENCES dbo.Odznaka(id_odznaka)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Wycieczka
ADD CONSTRAINT FK_Wycieczka_Turysta
FOREIGN KEY (id_turysta)
REFERENCES dbo.Turysta(id_turysta)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO


ALTER TABLE dbo.Wycieczka_odcinek
ADD CONSTRAINT FK_Wycieczka_odcinek_Wycieczka
FOREIGN KEY (id_wycieczka)
REFERENCES dbo.Wycieczka(id_wycieczka)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Wycieczka_odcinek
ADD CONSTRAINT FK_Wycieczka_odcinek_Odcinek
FOREIGN KEY (id_odcinek)
REFERENCES dbo.Odcinek(id_odcinek)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Ksiazeczka
ADD CONSTRAINT FK_Ksiazeczka_Turysta
FOREIGN KEY (id_turysta)
REFERENCES dbo.Turysta(id_turysta)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO

ALTER TABLE dbo.Ksiazeczka_wycieczka
ADD CONSTRAINT FK_Ksiazeczka_wycieczka_Wycieczka
FOREIGN KEY (id_wycieczka)
REFERENCES dbo.Wycieczka(id_wycieczka)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO


ALTER TABLE dbo.Ksiazeczka_wycieczka
ADD CONSTRAINT FK_Ksiazeczka_wycieczka_Ksiazeczka
FOREIGN KEY (id_ksiazeczka)
REFERENCES dbo.Ksiazeczka(id_ksiazeczka);
GO



ALTER TABLE dbo.Zdjecie_wycieczka
ADD CONSTRAINT FK_Zdjecie_wycieczka_Wycieczka
FOREIGN KEY (id_wycieczka)
REFERENCES dbo.Wycieczka(id_wycieczka)
ON DELETE CASCADE
ON UPDATE CASCADE;
GO





----------------------------



