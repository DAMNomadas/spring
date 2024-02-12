

INSERT INTO Ciudad (nombre, lgtbiq_friendly, pet_friendly, sports_life, armed_conflicts, universal_healthcare, climate_quality, female_friendly, internet_quality, cost_life, puntuacion_nomada, imagen, region, pais)
VALUES ('Tallin', 1, 1, 1, false, true, 8, 1, 9, 700, 8.5, NULL, 'Europa del Este', 'Estonia');

INSERT INTO Ciudad (nombre, lgtbiq_friendly, pet_friendly, sports_life, armed_conflicts, universal_healthcare, climate_quality, female_friendly, internet_quality, cost_life, puntuacion_nomada, imagen, region, pais)
VALUES ('Aveiro', 1, 1, 1, false, true, 7, 1, 8, 800, 8.0, NULL, 'Sudoeste de Europa', 'Portugal');

INSERT INTO Ciudad (nombre, lgtbiq_friendly, pet_friendly, sports_life, armed_conflicts, universal_healthcare, climate_quality, female_friendly, internet_quality, cost_life, puntuacion_nomada, imagen, region, pais)
VALUES ('Nueva York', 1, 1, 1, false, true, 7, 1, 8, 800, 8.0, NULL, 'Noreste', 'Estados Unidos');


INSERT INTO categoria_noticias (categoria) VALUES ('Política');
INSERT INTO categoria_noticias (categoria) VALUES ('Deportes');
INSERT INTO categoria_noticias (categoria) VALUES ('Tecnología');
INSERT INTO categoria_noticias (categoria) VALUES ('Entretenimiento');
INSERT INTO categoria_noticias (categoria) VALUES ('Salud');


INSERT INTO Noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Elecciones Presidenciales', 'Hoy se llevaron a cabo las elecciones presidenciales con una participación histórica.', NULL, 1, 1);

INSERT INTO Noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Final de la Liga de Campeones', 'El equipo local se lleva la victoria en un emocionante partido final.', NULL, 2, 2);

INSERT INTO Noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Lanzamiento del Nuevo Smartphone', 'La empresa X presenta su último modelo de smartphone con características innovadoras.', NULL, 3, 3);

INSERT INTO Noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Estreno de la Película', 'La esperada película "Título" finalmente llega a los cines y recibe críticas positivas.', NULL, 1, 4);




