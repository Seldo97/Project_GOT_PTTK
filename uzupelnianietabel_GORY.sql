----------------------------------
----- GRUPA
----------------------------------

INSERT INTO dbo.grupa
([nazwa])
VALUES ('Tatry i Podtatrze');
GO

INSERT INTO dbo.grupa
([nazwa])
VALUES ('Tatry S³owackie');
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
VALUES ('Góry Œwiêtokrzyskie');
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

----- Tatry S³owackie
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
VALUES ('Beskid Œl¹ski', 3);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Beskid ¯ywiecki', 3);
GO

----- Beskidy Wschodnie
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Pogórze Ciê¿kowickie', 4);
GO
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Beskid Niski czêœæ zachodnia', 4);
GO

----- Góry Œwiêtokrzyskie
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Góry Œwiêtokrzyskie', 5);
GO
----- Sudety
INSERT INTO dbo.pasmo
(nazwa, id_grupa)
VALUES ('Góry Izerskie', 6);
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
VALUES ('£ysa Polana', 1);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Gêsia Szyja', 1);
GO

----- Tatry i Podtatrze - TATRY ZACHODNIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Polana Bia³y Potok', 2);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Polana Huciska', 2);
GO

----- Tatry i Podtatrze - PODTATRZE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Palenica Koœcieliska', 3);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Butorowy Wierch', 3);
GO

----- Tatry S³owackie - ZAPADNE TATRY
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Sivy Vrch', 4);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Jalovska Dolina Ustie', 4);
GO

----- Tatry S³owackie - VYSOKE TATRY
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Tatranska Magistrala', 5);
GO

----- Beskidy Zachodnie - BESKID ŒL¥SKI
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Dziêgielów-Zamek', 6);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Jasieniowa', 6);
GO

----- Beskidy Zachodnie - BESKID ¯YWIECKI
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Rachowiec', 7);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('O¿na', 7);
GO

----- Beskidy Wschodnie - PODGÓRZE CIÊ¯KOWICKIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Góra œw. Marcina', 8);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('S³ona Góra', 8);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Trzemska Góra', 8);
GO

----- Beskidy Wschodnie - BESKIG NISKI CZÊŒÆ ZACHODNIA
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Margoñ Wy¿na', 9);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Tokarnia', 9);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Czerszla', 9);
GO

----- Góry Œwiêtokrzyskie - GÓRY ŒWIÊTOKRZYSKIE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Guzdek', 10);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Sowia Góra', 10);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Kamieniarska Góra', 10);
GO

----- Sudety - GÓRY IZERSKIE
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
VALUES ('£¹cznik', 11);
GO
----- Sudety - KARKONOSZE
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Szrenica', 12);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Prze³êcz Mokra', 12);
GO
INSERT INTO dbo.punkt
(nazwa, id_pasmo)
VALUES ('Wysoki Most', 12);
GO