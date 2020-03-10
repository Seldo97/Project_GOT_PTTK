CREATE DATABASE GOT_PTTK;

USE GOT_PTTK;

CREATE TABLE Rola(
	id_rola INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(50) UNIQUE
);

CREATE TABLE Uzytkownik
(
	id_uzytkownik INT PRIMARY KEY IDENTITY(1,1),
	login VARCHAR(50) UNIQUE,
	haslo  VARCHAR(255),
	email VARCHAR(50) UNIQUE,
);


CREATE TABLE Przodownik
(
	id_przodownik INT PRIMARY KEY,
	imie VARCHAR(50),
	nazwisko VARCHAR(50),
	telefon VARCHAR(11),
	opis VARCHAR(255),
	id_uzytkownik INT UNIQUE
);

CREATE TABLE Turysta
(
	id_turysta INT PRIMARY KEY IDENTITY(1,1),
	imie VARCHAR(50),
	nazwisko VARCHAR(50),
	telefon VARCHAR(11),
	id_uzytkownik INT UNIQUE,
	opis VARCHAR(250),
	punkty INT
);


CREATE TABLE Grupa
(
	id_grupa INT PRIMARY KEY IDENTITY(1,1),
	nazwa varchar(50)
);

CREATE TABLE Grup_Przodownik
(
	id_grupa_przodownik INT PRIMARY KEY IDENTITY(1,1), 
	id_przodownik INT,
	id_grupa INT
);

CREATE TABLE Odznaka
(
	id_odznaka INT PRIMARY KEY,
	nazwa VARCHAR(50)
);

CREATE TABLE Pasmo
(
	id_pasmo INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(50),
	id_grupa INT
);

CREATE TABLE Punkt
(
	id_punkt INT PRIMARY KEY IDENTITY(1,1),
	nazwa VARCHAR(50),
	id_pasmo INT
);

CREATE TABLE Odcinek
(
	id_odcinek INT PRIMARY KEY IDENTITY(1,1),
	id_punkt_poczatkowy INT,
	id_punkt_koncowy INT,
	punkty_wejscie INT,
	punkty_powrot INT,
	otwarty BIT
);


CREATE TABLE Turysta_Odznaka
(
	id_turysta_odznaka INT PRIMARY KEY IDENTITY(1,1),
	id_turysta INT,
	id_odznaka INT
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