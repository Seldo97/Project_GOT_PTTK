----------------------------------
----- GRUPA
----------------------------------

INSERT INTO dbo.grupa
([nazwa])
VALUES ('Tatry i Podtatrze');
GO

INSERT INTO dbo.grupa
([nazwa])
VALUES ('Tatry S�owackie');
GO

INSERT INTO dbo.grupa
([nazwa])
VALUES ('Beskidy Zachodnie');
GO

INSERT INTO dbo.grupa
([nazwa])
VALUES ('Beskidy wschodnie');
GO

INSERT INTO dbo.grupa
([nazwa])
VALUES ('G�ry �wi�tokrzyskie');
GO

INSERT INTO dbo.grupa
([nazwa])
VALUES ('Sudety');
GO

----------------------------------
----- PASMO
----------------------------------

----- Tatry i Podtatrze
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Tatry Wysokie', 1);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Tatry Zachodnie', 1);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Podtatrze', 1);
GO

----- Tatry S�owackie
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Zapadne Tatry', 2);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Vysoke Tatry', 2);
GO

----- Beskidy Zachodnie
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Beskid �l�ski', 3);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Beskid �ywiecki', 3);
GO

----- Beskidy Wschodnie
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Pog�rze Ci�kowickie', 4);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Beskid Niski cz�� zachodnia', 4);
GO

----- G�ry �wi�tokrzyskie
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('G�ry �wi�tokrzyskie', 5);
GO
----- Sudety
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('G�ry Izerskie', 6);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Karkonosze', 6);
GO

----------------------------------
----- PUNKT
----------------------------------

----- Tatry i Podtatrze - TATRY WYSOKIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Rusinowa Polana', 1);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('�ysa Polana', 1);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('G�sia Szyja', 1);
GO

----- Tatry i Podtatrze - TATRY ZACHODNIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Polana Bia�y Potok', 2);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Polana Huciska', 2);
GO

----- Tatry i Podtatrze - PODTATRZE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Palenica Ko�cieliska', 3);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Butorowy Wierch', 3);
GO

----- Tatry S�owackie - ZAPADNE TATRY
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Sivy Vrch', 4);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Jalovska Dolina Ustie', 4);
GO

----- Tatry S�owackie - VYSOKE TATRY
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Tatranska Magistrala', 5);
GO

----- Beskidy Zachodnie - BESKID �L�SKI
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Dzi�giel�w-Zamek', 6);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Jasieniowa', 6);
GO

----- Beskidy Zachodnie - BESKID �YWIECKI
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Rachowiec', 7);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('O�na', 7);
GO

----- Beskidy Wschodnie - PODG�RZE CIʯKOWICKIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('G�ra �w. Marcina', 8);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('S�ona G�ra', 8);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Trzemska G�ra', 8);
GO

----- Beskidy Wschodnie - BESKIG NISKI CZʌ� ZACHODNIA
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Margo� Wy�na', 9);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Tokarnia', 9);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Czerszla', 9);
GO

----- G�ry �wi�tokrzyskie - G�RY �WI�TOKRZYSKIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Guzdek', 10);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Sowia G�ra', 10);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Kamieniarska G�ra', 10);
GO

----- Sudety - G�RY IZERSKIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Smrek', 11);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Czerniawska Kopa', 11);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('��cznik', 11);
GO
----- Sudety - KARKONOSZE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Szrenica', 12);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Prze��cz Mokra', 12);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Wysoki Most', 12);
GO