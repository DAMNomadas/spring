--
-- -- Ciudades
-- INSERT INTO Ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais)
-- VALUES ('tallin', 'Tallin es la capital de Estonia y una ciudad histórica con una rica cultura y arquitectura medieval.', true, 3000.50, NULL, 'Estonia');
--
-- INSERT INTO Ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais)
-- VALUES ('aveiro', 'Aveiro es una ciudad costera en Portugal conocida por sus canales, barcos moliceiros coloridos y su deliciosa gastronomía.', false, 2500.75, NULL, 'Portugal');
--
-- INSERT INTO Ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais)
-- VALUES ('nueva york', 'Nueva York es una ciudad cosmopolita y diversa conocida por su icónica skyline, sus numerosas atracciones turísticas y su vibrante vida cultural.', true, 5000.25, NULL, 'Estados Unidos');
--
-- --Usuario
-- INSERT INTO usuario (id, latitud, longuitud, diet, origin_country, sexual_interest, estudios, job, sports, religion, name, lastname, karma_level, karma_collected)
-- VALUES (1, 40.7128, -74.0060, 'Vegetarian', 'USA', 'Heterosexual', 'Bachelor', 'Software Engineer', 'Running', 'None', 'John', 'Doe', 2, 50);
--
-- INSERT INTO usuario (id, latitud, longuitud, diet, origin_country, sexual_interest, estudios, job, sports, religion, name, lastname, karma_level, karma_collected)
-- VALUES (2, 40.7128, -74.0060, 'Vegetarian', 'USA', 'Heterosexual', 'Bachelor', 'Software Engineer', 'Running', 'None', 'Peppa', 'Pig', 2, 50);
--
--
-- -- Puntuacioes para Tallin
-- INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
-- VALUES (4, 3, 5, 4, 3, 4, 4, 3, 1,1);
--
-- INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
-- VALUES (5, 4, 4, 3, 4, 3, 5, 4,2,1);
--
-- INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
-- VALUES (2, 5, 3, 2, 1, 2, 5, 2,1,2);
--
--
-- --Categoria noticias
-- INSERT INTO categoria_noticias (categoria) VALUES ('Politica');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Deportes');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Tecnologia');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Entretenimiento');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Salud');
--
--
-- --Noticias
--
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Elecciones Presidenciales', 'Hoy se llevaron a cabo las elecciones presidenciales con una participación histórica.', NULL, 1, 1);
--
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Final de la Liga de Campeones', 'El equipo local se lleva la victoria en un emocionante partido final.', NULL, 2, 2);
--
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Lanzamiento del Nuevo Smartphone', 'La empresa X presenta su último modelo de smartphone con características innovadoras.', NULL, 3, 3);
--
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Estreno de la Película', 'La esperada película "Título" finalmente llega a los cines y recibe críticas positivas.', NULL, 1, 4);






--miooooo
-- Ciudades
-- INSERT INTO Ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais, video, latitud, longitud)
-- VALUES ('Tallin', 'Tallin es la capital de Estonia y una ciudad histórica con una rica cultura y arquitectura medieval.', true, 3000.50, NULL, 'Estonia', NULL, 59.4370, 24.7536);

-- INSERT INTO Ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais, video, latitud, longitud)
-- VALUES ('Aveiro', 'Aveiro es una ciudad costera en Portugal conocida por sus canales, barcos moliceiros coloridos y su deliciosa gastronomía.', false, 2500.75, NULL, 'Portugal', NULL, 40.6443, -8.6455);
--
-- INSERT INTO Ciudad (nombre, descripcion, universal_healthcare, average_salary, imagen, pais, video, latitud, longitud)
-- VALUES ('Nueva York', 'Nueva York es una ciudad cosmopolita y diversa conocida por su icónica skyline, sus numerosas atracciones turísticas y su vibrante vida cultural.', true, 5000.25, NULL, 'Estados Unidos', NULL, 40.7128, -74.0060);
--
-- -- -- Usuario
-- INSERT INTO Usuario (latitud, longuitud, diet, origin_country, sexual_interest, estudios, job, sports, religion, name, lastname, karma_level, karma_collected,id)
-- VALUES (40.7128, -74.0060, 'Vegetarian', 'USA', 'Heterosexual', 'Bachelor', 'Software Engineer', 'Running', 'None', 'John', 'Doe', 2, 50,1);
--
-- INSERT INTO Usuario (latitud, longuitud, diet, origin_country, sexual_interest, estudios, job, sports, religion, name, lastname, karma_level, karma_collected,id)
-- VALUES (40.7128, -74.0060, 'Vegetarian', 'USA', 'Heterosexual', 'Bachelor', 'Software Engineer', 'Running', 'None', 'Peppa', 'Pig', 2, 50,2);
--
-- -- -- Puntuaciones para Tallin
-- INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
-- VALUES (4, 3, 5, 4, 3, 4, 4, 3, 1, 1);
--
-- INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
-- VALUES (5, 4, 4, 3, 4, 3, 5, 4, 2, 2);
--
INSERT INTO puntuacion_usuarios_ciudad (lgtbiq_friendly, pet_friendly, sports_life, safety_rate, climate_quality, female_friendly, internet_quality, cost_life, id, id_ciutat)
VALUES (2, 5, 3, 2, 1, 2, 5, 2, 1, 13);

-- Categoría de noticias
-- INSERT INTO categoria_noticias (categoria) VALUES ('Política');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Deportes');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Tecnología');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Entretenimiento');
-- INSERT INTO categoria_noticias (categoria) VALUES ('Salud');

-- -- Noticias
-- INSERT INTO Noticias (titulo, texto, imagen, idCiutat, idCategoria)
-- VALUES ('Elecciones Presidenciales', 'Hoy se llevaron a cabo las elecciones presidenciales con una participación histórica.', NULL, 1, 1);
--
-- INSERT INTO Noticias (titulo, texto, imagen, idCiutat, idCategoria)
-- VALUES ('Final de la Liga de Campeones', 'El equipo local se lleva la victoria en un emocionante partido final.', NULL, 2, 2);
--
-- INSERT INTO Noticias (titulo, texto, imagen, idCiutat, idCategoria)
-- VALUES ('Lanzamiento del Nuevo Smartphone', 'La empresa X presenta su último modelo de smartphone con características innovadoras.', NULL, 3, 3);
--
-- INSERT INTO Noticias (titulo, texto, imagen, idCiutat, idCategoria)
-- VALUES ('Estreno de la Película', 'La esperada película "Título" finalmente llega a los cines y recibe críticas positivas.', NULL, 1, 4);
-- Noticias
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Elecciones Presidenciales', 'Hoy se llevaron a cabo las elecciones presidenciales con una participación histórica. Los ciudadanos acudieron en masa a los centros de votación, expresando su derecho democrático y contribuyendo al futuro político del país. Los candidatos ofrecieron discursos apasionados, destacando sus plataformas y promesas electorales. La jornada estuvo marcada por la emoción y la expectativa, con resultados que impactarán en la dirección del país en los próximos años.
--
-- En las horas previas a la votación, las calles estaban llenas de actividad política, con mítines y manifestaciones en apoyo a los diferentes candidatos. Los medios de comunicación proporcionaron una cobertura exhaustiva del evento, analizando cada detalle y tendencia electoral. Los observadores internacionales estuvieron presentes para garantizar la transparencia y la integridad del proceso electoral.
--
-- A medida que se anunciaban los resultados parciales, la emoción crecía entre los partidarios de los diferentes candidatos. Los centros de conteo de votos estaban abarrotados de funcionarios electorales y observadores, trabajando incansablemente para garantizar la precisión y la imparcialidad del recuento. Finalmente, con el recuento completo, se declaró un ganador, marcando el comienzo de un nuevo capítulo en la historia política del país.', NULL, 1, 1);
--
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Final de la Liga de Campeones', 'El equipo local se lleva la victoria en un emocionante partido final. Los aficionados llenaron el estadio, creando un ambiente electrizante mientras los dos equipos luchaban por el título. Con jugadas espectaculares y momentos de suspenso, el partido mantuvo a todos al borde de sus asientos. Al final, el equipo local logró la victoria, desatando celebraciones masivas en las calles de la ciudad. Fue un momento inolvidable para los seguidores del equipo y un hito en la historia del deporte local.
--
-- El partido estuvo lleno de emociones desde el principio hasta el final. Ambos equipos mostraron un juego excepcional, con jugadas brillantes y una defensa sólida. Los aficionados no dejaron de animar a sus equipos, creando un ambiente único en el estadio. Cada gol fue recibido con júbilo y celebración, mientras los seguidores agitaban bufandas y pancartas en apoyo a sus jugadores favoritos.
--
-- Después del partido, las calles se llenaron de alegría y celebración. Los aficionados se congregaron en plazas y bares para seguir festejando la victoria de su equipo. Los cánticos y vítores resonaron en toda la ciudad, mientras la gente celebraba un momento histórico para su equipo y su comunidad. Fue una noche que quedará grabada en la memoria de todos los que tuvieron la suerte de presenciarla.', NULL, 2, 2);
--
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Lanzamiento del Nuevo Smartphone', 'La empresa X presenta su último modelo de smartphone con características innovadoras. El evento de lanzamiento atrajo a una multitud de entusiastas de la tecnología, ansiosos por conocer las últimas novedades en dispositivos móviles. El nuevo smartphone ofrece un diseño elegante, una cámara avanzada y una potente capacidad de procesamiento. Los asistentes al evento tuvieron la oportunidad de probar el dispositivo y quedaron impresionados por su rendimiento y funcionalidades. Con este lanzamiento, la empresa X continúa estableciendo estándares en el mundo de la tecnología móvil.
--
-- El evento de lanzamiento fue una experiencia única para todos los asistentes. La empresa X preparó una presentación espectacular, destacando las características innovadoras del nuevo smartphone. Los invitados tuvieron la oportunidad de interactuar con el dispositivo y explorar sus capacidades en detalle. Los expertos en tecnología ofrecieron demostraciones en vivo y compartieron sus impresiones sobre el rendimiento del dispositivo.
--
-- Tras el evento, el nuevo smartphone recibió elogios de la crítica y la comunidad de usuarios. Los expertos destacaron su diseño elegante, su pantalla de alta resolución y su rendimiento rápido y fluido. Los usuarios quedaron impresionados por la calidad de la cámara y las opciones de personalización del dispositivo. Con su lanzamiento, el nuevo smartphone se convirtió rápidamente en el centro de atención en el mundo de la tecnología móvil.', NULL, 3, 3);
--
-- INSERT INTO noticias (titulo, texto, imagen, id_ciutat, id_categoria)
-- VALUES ('Estreno de la Película', 'La esperada película "Título" finalmente llega a los cines y recibe críticas positivas. Después de meses de anticipación, los cinéfilos tienen la oportunidad de disfrutar de esta emocionante producción en la gran pantalla. La película cautiva a la audiencia con su trama intrigante, actuaciones estelares y efectos visuales impresionantes. Los críticos elogian la dirección del director y la calidad del guion, augurando un éxito de taquilla. Los fanáticos de todo el país se reúnen en los cines para ser testigos del estreno y comparten su entusiasmo en las redes sociales. Es un momento emocionante para la industria del cine y para los amantes del séptimo arte.
--
-- El estreno de la película fue un evento muy esperado para los amantes del cine. Los fanáticos se congregaron en los cines desde temprano, ansiosos por ser los primeros en ver la nueva película. La atmósfera en los cines era eléctrica, con anticipación y emoción en el aire. Los fanáticos comentaban entre ellos sobre sus expectativas para la película y compartían teorías sobre la trama y los personajes.
--
-- A medida que las luces se apagaban y la película comenzaba, la audiencia quedaba cautivada por la historia en la pantalla. Los momentos de suspenso mantenían a todos al borde de sus asientos, mientras que los giros inesperados sorprendían a la audiencia. Los aplausos resonaban en el cine cuando la película llegaba a su emotivo clímax, dejando a los espectadores con una sensación de asombro y satisfacción.
--
-- Después de la proyección, los fanáticos salían del cine con una sonrisa en el rostro, emocionados por lo que acababan de presenciar. Las redes sociales se inundaron con comentarios entusiastas y reseñas elogiosas, destacando los aspectos positivos de la película. Para muchos, el estreno de la película fue más que una simple experiencia cinematográfica, fue un momento para recordar y atesorar durante mucho tiempo.', NULL, 1, 4);
