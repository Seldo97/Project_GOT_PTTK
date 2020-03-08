CREATE DATABASE GOT_PTTK;

USE GOT_PTTK;

CREATE TABLE Uzytkownik
(
idUzytkownik INT PRIMARY KEY IDENTITY(1,1),
login VARCHAR(50) UNIQUE,
haslo  VARCHAR(255),
email VARCHAR(50) UNIQUE,
);


CREATE TABLE Przodownik
(
idPrzodownik INT PRIMARY KEY,
imie VARCHAR(50),
nazwisko VARCHAR(50),
telefon VARCHAR(11),
idUzytkownik INT
);

CREATE TABLE Turysta
(
idTurysta INT PRIMARY KEY,
imie VARCHAR(50),
nazwisko VARCHAR(50),
telefon VARCHAR(11),
idUzytkownik INT,
opis VARCHAR(250),
punkty INT
);


CREATE TABLE Grupa
(
idGrupa INT PRIMARY KEY,
nazwa varchar(50)
);

CREATE TABLE GrupaPrzodownik
(
idGrupaPrzodownik INT PRIMARY KEY, 
idPrzodownik INT,
idGrupa INT
);

CREATE TABLE Odznaka
(
idOdznaka INT PRIMARY KEY,
nazwa VARCHAR(50)
);

CREATE TABLE Pasmo
(
idPasmo INT PRIMARY KEY,
nazwa VARCHAR(50),
idGrupa INT
);

CREATE TABLE Punkt
(
idPunkt INT PRIMARY KEY,
nazwa VARCHAR(50),
idPasmo INT
);

CREATE TABLE Odcinek
(
idOdcinek INT PRIMARY KEY,
idPunktPoczatkowy INT,
IdPunktKoncowy INT,
punktyWejscie INT,
punktyPowrot INT,
odcinekStatus BIT
);


CREATE TABLE TurystaOdznaka
(
idTurystaOdznaka INT PRIMARY KEY,
idTurysta INT,
idOdznaka INT
);

---------------------------------------------------------------------------------
-----------DEFINICJE KLUCZY OBCYCH-----------------------------------------------

ALTER TABLE dbo.Przodownik 
ADD CONSTRAINT FK_Przodownik_Uzytkownik
FOREIGN KEY (idUzytkownik)
REFERENCES dbo.Uzytkownik(idUzytkownik);
GO

ALTER TABLE dbo.Turysta 
ADD CONSTRAINT FK_Turysta_Uzytkownik
FOREIGN KEY (idUzytkownik)
REFERENCES dbo.Uzytkownik(idUzytkownik);
GO


ALTER TABLE dbo.Punkt 
ADD CONSTRAINT FK_Punkt_Pasmo
FOREIGN KEY (idPasmo)
REFERENCES dbo.Pasmo(idPasmo);
GO


ALTER TABLE dbo.GrupaPrzodownik
ADD CONSTRAINT FK_GrupaPrzodownik_Przodownik
FOREIGN KEY (idPrzodownik)
REFERENCES dbo.Przodownik(idPrzodownik);
GO


ALTER TABLE dbo.GrupaPrzodownik
ADD CONSTRAINT FK_GrupaPrzodownik_Grupa
FOREIGN KEY (idGrupa)
REFERENCES dbo.Grupa(idGrupa);
GO


ALTER TABLE dbo.Pasmo
ADD CONSTRAINT FK_Pasmo_Grupa
FOREIGN KEY (idGrupa)
REFERENCES dbo.Grupa(idGrupa);
GO


------------!!!!!!!!!!!!!-------------Trzeba zapewniæ unikalnoœæ odcinków!!!!!!!!!!

ALTER TABLE dbo.Odcinek
ADD CONSTRAINT FK_Odcinek_PunktPoczotkowy
FOREIGN KEY (idPunktPoczatkowy)
REFERENCES dbo.Punkt(idPunkt);
GO

ALTER TABLE dbo.Odcinek
ADD CONSTRAINT FK_Odcinek_PunktKoncowy
FOREIGN KEY (idPunktKoncowy)
REFERENCES dbo.Punkt(idPunkt);
GO


ALTER TABLE dbo.TurystaOdznaka
ADD CONSTRAINT FK_TurystaOdcznaka_Turysta
FOREIGN KEY (idTurysta)
REFERENCES dbo.Turysta(idTurysta);
GO


ALTER TABLE dbo.TurystaOdznaka
ADD CONSTRAINT FK_TurystaOdcznaka_Odznaka
FOREIGN KEY (idOdznaka)
REFERENCES dbo.Odznaka(idOdznaka);
GO