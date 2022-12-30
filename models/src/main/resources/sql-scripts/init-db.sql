INSERT INTO izdelek (naziv, kategorija) VALUES ('Televizor Samsung 55TU7092', 'Avdio Video Foto');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Slušalke Anker Soundcore Life Note', 'Avdio Video Foto');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Slušalke Sony WH-CH710NL', 'Avdio Video Foto');

INSERT INTO izdelek (naziv, kategorija) VALUES ('Prenosnik Apple MacBook Air 13', 'Računalništvo');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Miška Logitech MX Master 3s', 'Računalništvo');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Monitor DELL U2722DE ', 'Računalništvo');

INSERT INTO izdelek (naziv, kategorija) VALUES ('Pametni telefon Samsung Galaxy S22 Ultra', 'Telefonija');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Apple iphone 14 256 GB', 'Telefonija');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Pametni telefon Xiaomi 12T 5G', 'Telefonija');

INSERT INTO izdelek (naziv, kategorija) VALUES ('Vgradna pečica Bosch HBA573BS1', 'Bela tehnika');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Mikrovalovna pečica VOX MWHMD20B', 'Bela tehnika');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Hladilnik z zamrzovalnikom VOX KG 2630 ', 'Bela tehnika');

INSERT INTO izdelek (naziv, kategorija) VALUES ('Električno mestno kolo RKS W6 ', 'Šport in prosti čas');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Sobno kolo Body Sculpture BC4618 ', 'Šport in prosti čas');
INSERT INTO izdelek (naziv, kategorija) VALUES ('Fitnes drog za dvigovanje telesa ', 'Šport in prosti čas');

INSERT INTO Trgovina (ime, lokacija, latitude, longitude) VALUES ('Big bang novo mesto', 'Otoška cesta 5, 8000 Novo mesto',45.8279647,15.1839536);
INSERT INTO Trgovina (ime, lokacija, latitude, longitude) VALUES ('ENAA', 'Savska cesta 3a, 1000 Ljubljana',46.0637614,14.5248386);
INSERT INTO Trgovina (ime, lokacija, latitude, longitude) VALUES ('Mimovrste', 'Šmartinska cesta 152, 1000 Ljubljana',46.0672429,14.5412972);
INSERT INTO Trgovina (ime, lokacija, latitude, longitude) VALUES ('Edigital', 'Tržaška cesta 88, 1000 Ljubljana',46.0416044,14.4762644);
INSERT INTO Trgovina (ime, lokacija, latitude, longitude) VALUES ('Harvey Norman', 'Ljubljanska cesta 95, 8000 Novo mesto',45.8296044,15.1569272);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (1,1,399.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (1,2,399.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (1,3,499.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (1,4,420.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (1,5,421.00, 0);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (2,1,50.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (2,2,48.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (2,3,53.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (2,4,45.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (2,5,46.00, 0);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (3,1,65.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (3,2,79.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (3,3,69.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (3,5,60.00, 0);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (4,1,1165.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (4,3,1200.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (4,4,1090.00, 0);

INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (5,1,100.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (5,2,101.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (5,3,102.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (5,4,103.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (5,4,105.00, 0);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (6,1,500.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (6,2,480.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (6,3,440.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (6,4,420.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (6,4,470.00, 0);

INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (7,1,1010.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (7,2,1000.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (7,3,1111.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (7,4,1222.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (7,4,999.00, 0);

INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (8,1,1610.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (8,2,1699.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (8,3,1550.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (8,4,1550.00, 0);

INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (9,4,230.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (9,2,250.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (9,5,260.00, 0);

INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (10,1,501.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (10,2,502.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (10,3,499.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (10,4,499.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (10,4,480.99, 0);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (11,1,50.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (11,2,49.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (11,3,60.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (11,4,52.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (11,5,40.99, 0);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (12,1,501.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (12,2,502.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (12,3,499.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (12,4,499.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (12,5,490.99, 0);


INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (13,1,1000.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (13,2,999.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (13,3,990.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (13,4,980.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (13,5,985.99, 0);

INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (14,1,1000.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (14,2,999.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (14,3,990.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (14,4,980.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (14,5,985.99, 0);

INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (15,1,20.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (15,2,22.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (15,3,23.00, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (15,4,25.99, 0);
INSERT INTO Cena (izdelek_id, trgovina_id, cena, discount) VALUES (15,5,19.99, 0);



INSERT INTO Uporabnik (firstname, lastname) VALUES ('David', 'Trafela');
INSERT INTO Uporabnik (firstname, lastname) VALUES ('Žiga', 'Drab');
INSERT INTO Uporabnik (firstname, lastname) VALUES ('Ime1', 'Priimek1');
INSERT INTO Uporabnik (firstname, lastname) VALUES ('Ime2', 'Priimek2');


INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (1, 1);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (1, 2);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (1, 3);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (1, 4);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (1, 5);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (2, 1);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (3, 1);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (2, 4);
INSERT INTO PriljubljenIzdelek (uporabnik_id, izdelek_id) VALUES (3, 4);

INSERT INTO Kosarica(user_id) VALUES (1);
INSERT INTO Kosarica(user_id) VALUES (2);

INSERT INTO Kosarica_izdelek(kosarica_kosarica_id, izdelki_izdelek_id) VALUES (1, 1);
INSERT INTO Kosarica_izdelek(kosarica_kosarica_id, izdelki_izdelek_id) VALUES (1, 2);
INSERT INTO Kosarica_izdelek(kosarica_kosarica_id, izdelki_izdelek_id) VALUES (2, 1);
INSERT INTO Kosarica_izdelek(kosarica_kosarica_id, izdelki_izdelek_id) VALUES (2, 2);