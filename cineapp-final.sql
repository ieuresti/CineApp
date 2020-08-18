-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: cineapp
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Banners`
--

DROP TABLE IF EXISTS `Banners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Banners` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `estatus` enum('Activo','Inactivo') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Banners`
--

LOCK TABLES `Banners` WRITE;
/*!40000 ALTER TABLE `Banners` DISABLE KEYS */;
INSERT INTO `Banners` VALUES (1,'Estreno - Kong La Isla Calavera','2017-07-27','slide1.jpg','Activo'),(2,'Proximo Mes - La bella y la bestia','2018-10-13','slide2.jpg','Inactivo'),(3,'Ya esta aquí - Spider Man, de regreso a casa','2017-07-28','slide3.jpg','Activo'),(4,'Por fin ha llegado el día - Cars 3 ','2017-07-29','slide4.jpg','Activo'),(5,'Star Wars: Episodio VIII - Los ultimos Jedi.','2017-11-17','slide5.jpg','Activo'),(6,'La monja - La pelicula mas esperada del verano!','2018-09-11','slide6.jpg','Activo'),(7,'Estrenos Verano:  Milla 22 | ALFA','2018-10-13','slide7.jpg','Activo');
/*!40000 ALTER TABLE `Banners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Detalles`
--

DROP TABLE IF EXISTS `Detalles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Detalles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `director` varchar(100) DEFAULT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `sinopsis` text,
  `trailer` varchar(255) DEFAULT NULL COMMENT 'URL del video en Youtube\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Detalles`
--

LOCK TABLES `Detalles` WRITE;
/*!40000 ALTER TABLE `Detalles` DISABLE KEYS */;
INSERT INTO `Detalles` VALUES (1,'Jordan Vogt-Roberts','Samuel L. Jackson,Tom Hiddleston,Brie Larson,Toby Kebbell','Kong: La Isla Calavera reimagina el origen del mítico Kong en una irresistible aventura original del director Jordan Vogt-Roberts. En la película, un diverso equipo de exploradores es reunido para aventurarse en el interior de una isla del Pacífico —tan bella como traicionera— que no aparece en los mapas, sin saber que están invadiendo los dominios del mítico Kong.','https://www.youtube.com/embed/86jhW2gPc84'),(2,'Daniel Espinosa','Jake Gyllenhaal, Ryan Reynolds, Rebecca Ferguson','Seis miembros de la tripulación de la Estación Espacial Internacional que están a punto de lograr uno de los descubrimientos más importantes en la historia humana: la primera evidencia de vida extraterrestre en Marte. A medida que el equipo comienza a investigar y sus métodos tienen consecuencias inesperadas, la forma viviente demostrará ser más inteligente de lo que cualquiera esperaba.','https://www.youtube.com/embed/_cq1XIVXdjU'),(3,'Bill Condon','Dan Stevens,Emma Watson,Luke Evans','LA BELLA Y LA BESTIA, de Disney, es una adaptación de acción real de la película animada, que revive a los queridos personajes del clásico cuento de Disney para una audiencia contemporánea, manteniendo la música original e incorporando varias nuevas canciones.','https://www.youtube.com/embed/4D8N06nx9rs'),(4,'Oriol Paulo','Mario Casas, Bárbara Lennie, José Coronado, Ana Wagener','Adrián Doria, un joven y exitoso empresario, despierta en la habitación de un hotel junto al cadáver de su amante. Acusado de asesinato, decide contratar los servicios de Virginia Goodman, la mejor preparadora de testigos del país. En el transcurso de una noche, asesora y cliente trabajarán para encontrar una duda razonable que le libre de la cárcel.','https://www.youtube.com/embed/sOxy2gtPY7A'),(5,'Dean Israelite','Bryan Cranston, Elizabeth Banks, Becky G, Dacre Montgomery','Cinco adolescentes deben convertirse en algo extraordinario al enterarse que su pueblo, Angel Grove, y el mundo están a punto de ser aniquilados por una amenaza extraterrestre. Escogidos por el destino, nuestros héroes pronto descubren que son los únicos que pueden salvar el planeta…pero para hacerlo, deberán superar sus problemas de la vida real y, antes que sea demasiado tarde, unirse como los PowerRangers.','https://www.youtube.com/embed/gemUEi0XMTg'),(6,'F. Gary Gray','Dwayne Johnson,Michelle Rodriguez,Charlize Theron,Jason Statham,Vin Diesel','Justo cuando Dom y Letty celebran su luna de miel, Brian y Mia se han retirado del juego y el resto del equipo se ha desintegrado en busca de una vida comun y corriente; una misteriosa mujer intentara seducir a Dom para convencerlo de regresar a la vida criminal que tanto lo acecha, traicionando a quienes lo rodean y enfrentandose a retos nunca antes vistos.','https://www.youtube.com/embed/3KuazYQ1JuE'),(7,'James Gunn','Dave Bautista,Bradley Cooper,Zoe Saldana,Vin Diesel,Chris Pratt','Ambientada en el nuevo contexto sonoro de \"Awesome Mixtape #2\", GUARDIANES DE LA GALAXIA VOL. 2, de Marvel, continua las aventuras del equipo en su travesia por los confines del cosmos. Los Guardianes deberan luchar para mantener unida a su nueva familia mientras intentan resolver el misterio del verdadero linaje de Peter Quill. Viejos rivales se convertiran en nuevos aliados y los personajes favoritos de los comics clasicos acudiran en ayuda de nuestros heroes a medida que el Universo Cinematografico de Marvel continua expandiendose.','https://www.youtube.com/embed/bBTtlcJwjSo'),(8,'Corin Hardy','Demian Bichir,Bonnie Aarons,Charlotte Hope,Jonny Coyne,August Maturo,Taissa Farmiga','Un sacerdote con un pasado que lo acosa y una novicia a punto de hacer sus votos definitivos son los enviados por el Vaticano a investigar el caso de una joven monja en un claustro de Rumania que se quita la vida. Ahi descubren el secreto impuro de la orden. No solo arriesgaran sus vidas sino tambien su fe y su alma misma al enfrentarse a una fuerza maligna que toma la forma demoniaca de la monja que anteriormente aterro a las audiencias en \"El Conjuro 2\" mientras que el claustro se vuelve un horrorizante campo de batalla entre los vivos y los condenados.','https://www.youtube.com/embed/eqVjGwYFVqQ');
/*!40000 ALTER TABLE `Detalles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Horarios`
--

DROP TABLE IF EXISTS `Horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Horarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `sala` varchar(100) NOT NULL,
  `precio` double NOT NULL DEFAULT '0',
  `idPelicula` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Horarios_Peliculas1_idx` (`idPelicula`),
  CONSTRAINT `fk_Horarios_Peliculas1` FOREIGN KEY (`idPelicula`) REFERENCES `Peliculas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Horarios`
--

LOCK TABLES `Horarios` WRITE;
/*!40000 ALTER TABLE `Horarios` DISABLE KEYS */;
INSERT INTO `Horarios` VALUES (1,'2018-10-13','18:00:00','Premium',55,1),(2,'2018-10-13','18:00:00','Premium',55,3),(3,'2018-10-13','21:00:00','Premium',55,3),(4,'2018-10-13','18:00:00','Premium',65,4),(5,'2018-10-13','21:00:00','Premium',65,4),(6,'2018-10-13','20:00:00','Premium',55,5),(7,'2018-10-13','16:30:00','Premium',60,7),(8,'2018-10-13','15:45:00','Premium',55,8),(9,'2018-10-13','14:00:00','Sala 1',55,1),(10,'2018-10-13','16:00:00','Sala 1',55,1),(11,'2018-10-13','14:00:00','Sala 1',60,2),(12,'2018-10-13','16:00:00','Sala 1',60,2),(13,'2018-10-13','14:00:00','Sala 1',55,3),(14,'2018-10-13','16:00:00','Sala 1',55,3),(15,'2018-10-13','14:00:00','Sala 1',65,4),(16,'2018-10-13','16:00:00','Sala 1',65,4),(17,'2018-10-13','17:00:00','Sala 1',55,5),(18,'2018-10-13','19:00:00','Sala 1',55,5),(19,'2018-10-13','21:00:00','Sala 1',55,5),(20,'2018-10-13','18:45:00','Sala 1',55,8),(21,'2018-10-13','21:45:00','Sala 1',55,8),(22,'2018-10-13','17:00:00','Sala 2',55,3),(23,'2018-10-13','17:00:00','Sala 2',65,4),(24,'2018-10-13','16:00:00','Sala 2',55,5),(25,'2018-10-13','18:30:00','Sala 2',60,7),(26,'2018-10-13','16:00:00','Sala 3',55,3),(27,'2018-10-13','16:00:00','Sala 3',65,4),(28,'2018-10-13','22:00:00','Sala 3',55,5),(29,'2018-10-13','20:45:00','Sala 3',60,7),(30,'2018-10-13','22:20:00','Sala 3',55,8),(31,'2018-10-14','18:00:00','Premium',55,1),(32,'2018-10-14','18:00:00','Premium',55,3),(33,'2018-10-14','21:00:00','Premium',55,3),(34,'2018-10-14','18:00:00','Premium',65,4),(35,'2018-10-14','21:00:00','Premium',65,4),(36,'2018-10-14','14:30:00','Premium',55,8),(37,'2018-10-14','17:00:00','Premium',55,8),(38,'2018-10-14','14:00:00','Sala 1',55,1),(39,'2018-10-14','16:00:00','Sala 1',55,1),(40,'2018-10-14','14:00:00','Sala 1',60,2),(41,'2018-10-14','16:00:00','Sala 1',60,2),(42,'2018-10-14','14:00:00','Sala 1',55,3),(43,'2018-10-14','16:00:00','Sala 1',55,3),(44,'2018-10-14','14:00:00','Sala 1',65,4),(45,'2018-10-14','16:00:00','Sala 1',65,4),(46,'2018-10-14','17:50:00','Sala 1',55,8),(47,'2018-10-14','17:00:00','Sala 2',55,3),(48,'2018-10-14','17:00:00','Sala 2',65,4),(49,'2018-10-14','17:00:00','Sala 2',55,8),(50,'2018-10-14','16:00:00','Sala 3',55,3),(51,'2018-10-14','16:00:00','Sala 3',65,4),(52,'2018-10-14','22:10:00','Sala 3',55,8),(53,'2018-10-15','18:00:00','Premium',55,5),(54,'2018-10-15','21:00:00','Premium',55,5),(55,'2018-10-15','20:00:00','Premium',60,2),(56,'2018-10-15','15:30:00','Premium',55,8),(57,'2018-10-15','14:00:00','Sala 1',55,5),(58,'2018-10-15','16:00:00','Sala 1',55,5),(59,'2018-10-15','17:00:00','Sala 1',60,2),(60,'2018-10-15','19:00:00','Sala 1',60,2),(61,'2018-10-15','21:00:00','Sala 1',60,2),(62,'2018-10-15','20:30:00','Sala 1',55,8),(63,'2018-10-15','13:30:00','Sala 1',60,7),(64,'2018-10-15','17:00:00','Sala 2',55,5),(65,'2018-10-15','16:00:00','Sala 2',60,2),(66,'2018-10-15','17:15:00','Sala 2',55,8),(67,'2018-10-15','13:30:00','Sala 2',60,7),(68,'2018-10-15','18:00:00','Sala 2',60,7),(69,'2018-10-15','21:30:00','Sala 2',60,7),(70,'2018-10-15','16:00:00','Sala 3',55,5),(71,'2018-10-15','22:00:00','Sala 3',60,2),(72,'2018-10-15','17:15:00','Sala 3',55,8),(73,'2018-10-15','14:00:00','Sala 3',60,7),(74,'2018-10-15','22:00:00','Sala 3',60,7),(75,'2018-10-16','22:15:00','Premium',55,5),(76,'2018-10-16','14:30:00','Premium',60,7),(77,'2018-10-16','17:00:00','Premium',60,7),(78,'2018-10-16','11:00:00','Premium',55,8),(79,'2018-10-16','14:30:00','Sala 1',60,7),(80,'2018-10-16','21:30:00','Sala 1',60,7),(81,'2018-10-16','15:30:00','Sala 1',55,8),(82,'2018-10-16','15:30:00','Sala 2',55,5),(83,'2018-10-16','21:30:00','Sala 2',60,7),(84,'2018-10-16','11:00:00','Sala 2',55,8),(85,'2018-10-16','17:55:00','Sala 2',55,8),(86,'2018-10-16','16:40:00','Sala 3',55,5),(87,'2018-10-16','14:30:00','Sala 3',60,7),(88,'2018-10-16','17:00:00','Sala 3',60,7),(89,'2018-10-16','21:30:00','Sala 3',60,7),(90,'2018-10-16','11:00:00','Sala 3',55,8),(91,'2018-10-16','22:10:00','Sala 3',55,8),(92,'2018-10-17','13:30:00','Premium',55,8),(93,'2018-10-17','15:30:00','Premium',55,8),(94,'2018-10-17','17:30:00','Premium',55,8),(95,'2018-10-17','21:00:00','Premium',55,8),(96,'2018-10-17','17:00:00','Premium',60,7),(97,'2018-10-17','20:45:00','Premium',60,7),(98,'2018-10-17','16:15:00','Sala 1',55,8),(99,'2018-10-17','18:30:00','Sala 1',55,8),(100,'2018-10-17','21:30:00','Sala 1',55,8),(101,'2018-10-17','16:15:00','Sala 2',60,7),(102,'2018-10-17','20:15:00','Sala 2',60,7),(103,'2018-10-17','22:50:00','Sala 2',60,7),(104,'2018-10-17','14:40:00','Sala 3',55,8),(105,'2018-10-17','20:10:00','Sala 3',55,8),(106,'2018-10-13','15:00:00','Premium',70,9),(107,'2018-10-13','17:50:00','Premium',70,9),(108,'2018-10-13','22:00:00','Sala 2',65,9),(109,'2018-10-13','18:50:00','Sala 3',70,9),(110,'2018-10-13','16:00:00','Sala 1',60,9),(111,'2018-10-14','18:20:00','Premium',75,9),(112,'2018-10-14','14:00:00','Sala 3',65,9),(113,'2018-10-14','21:10:00','Sala 2',70,9),(114,'2018-10-14','21:30:00','Premium',70,9),(115,'2018-10-14','18:50:00','Sala 2',60,9);
/*!40000 ALTER TABLE `Horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Noticias`
--

DROP TABLE IF EXISTS `Noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Noticias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `detalle` text NOT NULL,
  `estatus` enum('Activa','Inactiva') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Noticias`
--

LOCK TABLES `Noticias` WRITE;
/*!40000 ALTER TABLE `Noticias` DISABLE KEYS */;
INSERT INTO `Noticias` VALUES (1,'Bob Esponja: tercera pelicula y temporada 12','2018-10-10','<p><strong><span style=\"color: #ff0000;\">Nickelodeon y productor de SpongeBob Square Pants confirman temporada 12 de 52 episodios y tercera pel&iacute;cula pr&oacute;ximamente. </span></strong></p>\r\n<p><strong>&iexcl;Calamardo est&aacute; enojado!Bob Esponja: tercera pel&iacute;cula y temporada 12</strong></p>\r\n<p>Nickelodeon y productor de SpongeBob Square Pants confirman temporada 12 de 52 episodios y tercera pel&iacute;cula pr&oacute;ximamente. &iexcl;Calamardo est&aacute; enojado!.</p>\r\n<p>A lado de cierta Pi&ntilde;a (debajo del mar), Calamardo debe estar de muy mal humor, pues hay Bob Esponja para rato... &iexcl;y por partida doble!. Por un lado, Vincent Waller (The Ren &amp; Stimpy Show), artista, productor, escritor y supervisor creativo de SpongeBob Squarepants anunci&oacute; con un divertido dibujo desde su cuenta de Twitter que, antes de que se estrene siquiera la temporada 11 de la serie animada, se ha confirmado ya la n&uacute;mero 12, &iexcl;que constar&aacute; de 52 episodios (recuerden que cada emisi&oacute;n consta de 2 aventuras)!</p>','Activa'),(2,'Julia Roberts protagonizara. The Bookseller','2018-10-11','<p>La novela de Cynthia Swanson <span style=\"color: #0000ff;\"><strong>The Bookseller</strong></span> ser&aacute; llevada al cine con <span style=\"color: #0000ff;\">Julia Roberts (Los Pitufos: La aldea Escondida)</span> como protagonista.<br /><br />La historia est&aacute; ambientada en los sesenta y su protagonista es una mujer soltera, Kitty Miller, que lleva una librer&iacute;a. Sue&ntilde;a con una vida alternativa en la que ha encontrado el amor y est&aacute; casada y con hijos, pero la l&iacute;nea que separa realidad y ficci&oacute;n comienza a estar demasiado dispersa para que la distinga.<br /><br />Seg&uacute;n informa <span style=\"color: #ff0000;\"><strong>Moviehole</strong></span> Roberts tambi&eacute;n producir&aacute; la pel&iacute;cula junto a Lisa Gillan y Marisa Yeres Hill.</p>','Activa'),(3,'Rosamund Pike sera Marie Curie','2018-10-13','<p><strong>Rosamund Pike</strong> (<span style=\"color: #008000;\">Un Reino Unido</span>) dar&aacute; vida a la famosa cient&iacute;fica Marie Curie en la pel&iacute;cula de Studiocanal <strong>Radioactiv</strong>. Se trata de una adaptaci&oacute;n de la biograf&iacute;a escrita por Lauren Redniss, que se centra en el romance entre Marie y Pierre Curie y en el descubrimiento de la radiactividad.<br /><br />Seg&uacute;n informa <span style=\"color: #008000;\"><strong>Premiere</strong></span> el proceso de casting para los papeles de Pierre y de Paul Langevin, su joven amante, ya ha comenzado.<br /><br />Marjane Satrapi dirigir&aacute; a partir de un gui&oacute;n de Jack Thorne. Tim Bevan, Eric Fellner y Paul Webster producir&aacute;n la pel&iacute;cula.</p>','Activa'),(4,'Julianne Moore sera Gloria','2018-10-13','<p><strong><span style=\"color: #0000ff;\">Julianne Moore</span></strong> <span style=\"color: #808080;\">(Kingsman: El C&iacute;rculo de Oro)</span> protagonizar&aacute; el remake de FilmNation de la pel&iacute;cula chilena <em><strong>Gloria</strong></em>.<br /><br />Sebastian Lelio, director de la pel&iacute;cula original, escribir&aacute; el gui&oacute;n del remake, que todav&iacute;a no tiene t&iacute;tulo.<br /><br />Moore ser&aacute; Gloria, una mujer de 58 a&ntilde;os que est&aacute; sola en la vida. Para compensar el vac&iacute;o, llena sus d&iacute;as de actividades y por las noches busca el amor en el mundo de las fiestas para solteros adultos, donde solo consigue perderse en una serie de aventuras sin sentido. Esta fr&aacute;gil felicidad en la que vive se altera cuando conoce a Rodolfo, un hombre de 65 a&ntilde;os, recientemente separado, que se obsesiona con ella. Gloria comienza un romance, pero &eacute;ste se complica por la enfermiza dependencia de Rodolfo hacia sus hijos y su ex mujer. Esta relaci&oacute;n, a la que Gloria se entrega porque intuye que podr&iacute;a ser la &uacute;ltima, acabar&aacute; por hacerla estrellarse contra la cruel realidad del mundo. Gloria deber&aacute; reconstruirse para enfrentar con nuevas fuerzas su definitiva entrada a la vejez.<br /><br />Seg&uacute;n <span style=\"color: #008000;\"><strong>The Hollywood Reporter</strong> </span>Juan de Dios Larrain y Pablo Larrain producir&aacute;n la cinta, que comenzar&aacute; a rodarse a finales de mes.</p>','Activa');
/*!40000 ALTER TABLE `Noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Peliculas`
--

DROP TABLE IF EXISTS `Peliculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Peliculas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `duracion` int(11) NOT NULL,
  `clasificacion` enum('A','B','C') NOT NULL,
  `genero` varchar(45) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `fechaEstreno` date NOT NULL,
  `estatus` enum('Activa','Inactiva') NOT NULL DEFAULT 'Activa',
  `idDetalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Peliculas_Detalles1_idx` (`idDetalle`),
  CONSTRAINT `fk_Peliculas_Detalles1` FOREIGN KEY (`idDetalle`) REFERENCES `Detalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Peliculas`
--

LOCK TABLES `Peliculas` WRITE;
/*!40000 ALTER TABLE `Peliculas` DISABLE KEYS */;
INSERT INTO `Peliculas` VALUES (1,'Kong La Isla Calavera',118,'B','Accion y Aventura','kong.png','2018-10-08','Activa',1),(2,'Life: Vida Inteligente',104,'B','Drama','life.png','2018-10-08','Activa',2),(3,'La Bella y La Bestia',132,'A','Infantil','bella.png','2018-10-08','Activa',3),(4,'Contratiempo',106,'B','Thriller','contratiempo.png','2018-10-10','Activa',4),(5,'Power Rangers',120,'B','Aventura','power-rangers.png','2018-10-10','Activa',5),(7,'Rapidos y Furiosos 8',136,'B','Accion','rapidos-furiosos.png','2018-10-12','Activa',6),(8,'Guardianes de la Galaxia Vol 2',136,'B','Accion','guardianes-galaxia.png','2018-10-12','Activa',7),(9,'La Monja',96,'B','Terror','la-monja.jpg','2018-09-07','Activa',8);
/*!40000 ALTER TABLE `Peliculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Perfiles`
--

DROP TABLE IF EXISTS `Perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perfiles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuenta` varchar(100) NOT NULL,
  `perfil` varchar(70) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cuenta_perfil_UNIQUE` (`cuenta`,`perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Perfiles`
--

LOCK TABLES `Perfiles` WRITE;
/*!40000 ALTER TABLE `Perfiles` DISABLE KEYS */;
INSERT INTO `Perfiles` VALUES (3,'itinajero','GERENTE'),(1,'ivan','EDITOR'),(2,'marisol','GERENTE');
/*!40000 ALTER TABLE `Perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuarios`
--

DROP TABLE IF EXISTS `Usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuenta` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cuenta_UNIQUE` (`cuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuarios`
--

LOCK TABLES `Usuarios` WRITE;
/*!40000 ALTER TABLE `Usuarios` DISABLE KEYS */;
INSERT INTO `Usuarios` VALUES (1,'ivan','{noop}ivan123',1,'ivan@test.com','9856523'),(2,'marisol','$2a$10$UxLrgtD4NuglAQ3ah0z/7OGHDUKWW0NH5fPsHa8uMl4.y5HJwyN/u',1,'marisol@example.com','9856482'),(3,'itinajero','$2a$10$Q4mbRFK/fvDwifckOJi3au1.vE1qq6BAK8qBivN7My5t3Xdh7Ashu',1,'ivanetinajero@gmail.com','4789855223');
/*!40000 ALTER TABLE `Usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('ivan','EDITOR'),('marisol','GERENTE');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('ivan','{noop}ivan123',1),('marisol','{noop}mari123',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-12  9:20:22
