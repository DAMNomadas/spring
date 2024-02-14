
-- Ciudades
INSERT INTO ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais)
VALUES ('tallin', 'Tallin es la capital de Estonia y una ciudad histórica con una rica cultura y arquitectura medieval.', true, 3000.50, NULL, 'Estonia');

INSERT INTO ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais)
VALUES ('aveiro', 'Aveiro es una ciudad costera en Portugal conocida por sus canales, barcos moliceiros coloridos y su deliciosa gastronomía.', false, 2500.75, NULL, 'Portugal');

INSERT INTO ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais)
VALUES ('nueva york', 'Nueva York es una ciudad cosmopolita y diversa conocida por su icónica skyline, sus numerosas atracciones turísticas y su vibrante vida cultural.', true, 5000.25, NULL, 'Estados Unidos');

--Usuario
INSERT INTO usuario (id, latitud, longuitud, diet, origin_country, sexual_interest, estudios, job, sports, religion, name, lastname, karma_level, karma_collected)
VALUES (1, 40.7128, -74.0060, 'Vegetarian', 'USA', 'Heterosexual', 'Bachelor', 'Software Engineer', 'Running', 'None', 'John', 'Doe', 2, 50);


-- Puntuacioes para Tallin
INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
VALUES (4, 3, 5, 4, 3, 4, 4, 3, 1,1);

INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
VALUES (5, 4, 4, 3, 4, 3, 5, 4,1,1);

INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
VALUES (2, 5, 3, 2, 1, 2, 5, 2,1,1);


--Categoria noticias
INSERT INTO categoria_noticias (categoria) VALUES ('Politica');
INSERT INTO categoria_noticias (categoria) VALUES ('Deportes');
INSERT INTO categoria_noticias (categoria) VALUES ('Tecnologia');
INSERT INTO categoria_noticias (categoria) VALUES ('Entretenimiento');
INSERT INTO categoria_noticias (categoria) VALUES ('Salud');


--Noticias

INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Elecciones Presidenciales', 'Hoy se llevaron a cabo las elecciones presidenciales con una participación histórica.', NULL, 1, 1);

INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Final de la Liga de Campeones', 'El equipo local se lleva la victoria en un emocionante partido final.', NULL, 2, 2);

INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Lanzamiento del Nuevo Smartphone', 'La empresa X presenta su último modelo de smartphone con características innovadoras.', NULL, 3, 3);

INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
VALUES ('Estreno de la Película', 'La esperada película "Título" finalmente llega a los cines y recibe críticas positivas.', NULL, 1, 4);




