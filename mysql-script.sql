CREATE USER library_administrator@localhost IDENTIFIED BY 'library';

CREATE DATABASE  IF NOT EXISTS `elibrary` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `elibrary`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: elibrary
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(35) NOT NULL,
  `last_name` varchar(35) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Ashlee','Ventz','Ashlee Vance is an award winning feature writer for Bloomberg Businessweek magazine. Vance is also the host of the \"Hello World\" TV show. Previously, he worked for The New York Times and The Register. '),(2,'J. R. R.','Tolken','J.R.R. Tolkien (1892.1973), beloved throughout the world as the creator of The Hobbit and The Lord of the Rings, was a professor of Anglo-Saxon at Oxford, a fellow of Pembroke College, and a fellow of Merton College until his retirement in 1959. His chief interest was the linguistic aspects of the early English written tradition, but even as he studied these classics he was creating a set of his own.'),(3,'Joanne','Rowling','.K. Rowling is the author of the record-breaking, multi-award-winning Harry Potter novels. Loved by fans around the world, the series has sold more than 450 million copies, been translated into 80 languages and made into eight blockbuster films. '),(4,'Paulo','Koelho','The Brazilian author PAULO COELHO is considered one of the most influential authors of our times. His books have sold more than 165 million copies worldwide, have been released in 170 countries and been translated into 80 languages.'),(5,'John','Steinbeck','John Steinbeck (1902-1968), winner of the Nobel Prize in Literature, achieved popular success in 1935 when he published Tortilla Flat. He went on to write more than twenty-five novels, including The Grapes of Wrath and Of Mice and Men.'),(7,'Viktor','Hugo','Victor Marie Hugo (/&#712;hju&#720;&#609;o&#650;/; French: [vikt&#596;&#641; ma&#641;i y&#609;o]; 26 February 1802  22 May 1885) was a French poet, novelist, and dramatist of the Romantic movement. He is considered one of the greatest and best-known French writers. In France, Hugo\'s literary fame comes first from his poetry and then from his novels and his dramatic achievements. Among many volumes of poetry, Les Contemplations and La Légende des siècles stand particularly high in critical esteem. Outside France, his best-known works are the novels Les Misérables, 1862, and Notre-Dame de Paris, 1831 (known in English as The Hunchback of Notre-Dame). He also produced more than 4,000 drawings, which have since been admired for their beauty, and earned widespread respect as a campaigner for social causes such as the abolition of capital punishment.'),(8,'Ana','Frank',NULL),(9,'Mikhail','Bulgakov','Mikhaíl Afanasyevich Bulgakov (/b&#650;l&#712;&#609;&#593;&#720;k&#601;f/; Russian: &#1052;&#1080;&#1093;&#1072;&#1080;&#769;&#1083; &#1040;&#1092;&#1072;&#1085;&#1072;&#769;&#1089;&#1100;&#1077;&#1074;&#1080;&#1095; &#1041;&#1091;&#1083;&#1075;&#1072;&#769;&#1082;&#1086;&#1074;, pronounced [m&#690;&#618;x&#592;&#712;il &#592;f&#592;&#712;nas&#690;j&#618;v&#690;&#618;t&#597; b&#650;l&#712;&#609;ak&#601;f]; May 15 [O.S. May 3] 1891  March 10, 1940) was a Russian writer and playwright active in the first half of the 20th century. He is best known for his novel The Master and Margarita, which has been called one of the masterpieces of the 20th century.'),(10,'Leo','Tolstoy','Leo Tolstoy (1828-1910) wrote two of the great novels of the nineteenth century, War and Peace and Anna Karenina.'),(11,'Fyodor','Dostoevsky','Fyodor Dostoyevsky, in full Fyodor Mikhaylovich Dostoyevsky, Dostoyevsky also spelled Dostoevsky, (born November 11 [October 30, Old Style], 1821, Moscow, Russiadied February 9 [January 28, Old Style], 1881, St. Petersburg), Russian novelist and short-story writer whose psychological penetration into the darkest recesses of the human heart, together with his unsurpassed moments of illumination, had an immense influence on 20th-century fiction.\r\n\r\nDostoyevsky is usually regarded as one of the finest novelists who ever lived. Literary modernism, existentialism, and various schools of psychology, theology, and literary criticism have been profoundly shaped by his ideas. His works are often called prophetic because he so accurately predicted how Russias revolutionaries would behave if they came to power. In his time he was also renowned for his activity as a journalist.'),(12,'F. Scott','Fitzgerald','Francis Scott Key Fitzgerald (known as F. Scott Fitzgerald) was a short story writer and novelist considered one of the pre-eminent authors in the history of American literature due almost entirely to the enormous posthumous success of his third book, The Great Gatsby. Perhaps the quintessential American novel, as well as a definitive social history of the Jazz Age, The Great Gatsby has become required reading for virtually every American high school student and has had a transportive effect on generation after generation of readers. At the age of 24, the success of his first novel, This Side of Paradise, made Fitzgerald famous. One week later, he married the woman he loved and his muse, Zelda Sayre. However by the end of the 1920s Fitzgerald descended into drinking, and Zelda had a mental breakdown. Following the unsuccessful Tender Is the Night, Fitzgerald moved to Hollywood and became a scriptwriter. He died of a heart attack in 1940, at age 44, his final novel only half completed.'),(13,'Dan','Brown','Dan Brown is the #1 New York Times bestselling author of The Da Vinci Code and, previously, Digital Fortress, Deception Point, and Angels and Demons. He is a graduate of Amherst College and Phillips Exeter Academy, where he spent time as an English teacher before turning his efforts fully to writing. He lives in New England with his wife.'),(18,'Alexandre','Dumas',NULL),(19,'Ivo','Andric',NULL);
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('chad.darby','ADMIN'),('sasa.gavric','ADMIN');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` text,
  `date_of_issue` date NOT NULL,
  `number_of_pages` int(11) NOT NULL,
  `language` varchar(35) NOT NULL,
  `image_url` text,
  `book_in_stock` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future','There are few industrialists in history who could match Elon Musk\'s relentless drive and ingenious vision. A modern alloy of Thomas Edison, Henry Ford, Howard Hughes, and Steve Jobs, Musk is the man behind PayPal, Tesla Motors, SpaceX, and SolarCity, each of which has sent shock waves throughout American business and industry. More than any other executive today, Musk has dedicated his energies and his own vast fortune to inventing a future that is as rich and far-reaching as a science fiction fantasy. In this lively, investigative account, veteran technology journalist Ashlee Vance offers an unprecedented look into the remarkable life and times of Silicon Valley\'s most audacious businessman. Written with exclusive access to Musk, his family, and his friends, the book traces his journey from his difficult upbringing in South Africa to his ascent to the pinnacle of the global business world\"--From publisher description.','2013-12-26',425,'English','https://images-na.ssl-images-amazon.com/images/I/5112YFsXIJL._SX330_BO1,204,203,200_.jpg',6),(2,'The Lord of the Rings','One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them\r\n\r\nIn ancient times the Rings of Power were crafted by the Elven-smiths, and Sauron, the Dark Lord, forged the One Ring, filling it with his own power so that he could rule all others. But the One Ring was taken from him, and though he sought it throughout Middle-earth, it remained lost to him. After many ages it fell by chance into the hands of the hobbit Bilbo Baggins.\r\n\r\nFrom Sauron\'s fastness in the Dark Tower of Mordor, his power spread far and wide. Sauron gathered all the Great Rings, but always he searched for the One Ring that would complete his dominion.\r\n\r\nWhen Bilbo reached his eleventy-first birthday he disappeared, bequeathing to his young cousin Frodo the Ruling Ring and a perilous quest: to journey across Middle-earth, deep into the shadow of the Dark Lord, and destroy the Ring by casting it into the Cracks of Doom.\r\n\r\nThe Lord of the Rings tells of the great quest undertaken by Frodo and the Fellowship of the Ring: Gandalf the Wizard; the hobbits Merry, Pippin, and Sam; Gimli the Dwarf; Legolas the Elf; Boromir of Gondor; and a tall, mysterious stranger called Strider.','2014-07-13',1212,'English','https://images-na.ssl-images-amazon.com/images/I/51EstVXM1UL._SX331_BO1,204,203,200_.jpg',9),(8,'The Grapes of Wrath','First published in 1939, Steinbecks Pulitzer Prize-winning epic of the Great Depression chronicles the Dust Bowl migration of the 1930s and tells the story of one Oklahoma farm family, the Joadsdriven from their homestead and forced to travel west to the promised land of California. Out of their trials and their repeated collisions against the hard realities of an America divided into Haves and Have-Nots evolves a drama that is intensely human yet majestic in its scale and moral vision, elemental yet plainspoken, tragic but ultimately stirring in its human dignity. A portrait of the conflict between the powerful and the powerless, of one mans fierce reaction to injustice, and of one womans stoical strength, the novel captures the horrors of the Great Depression and probes into the very nature of equality and justice in America. At once a naturalistic epic, captivity narrative, road novel, and transcendental gospel, Steinbecks powerful landmark novel is perhaps the most American of American Classics.','1938-12-30',625,'English','http://sites.psu.edu/hoffmanrclpassion/wp-content/uploads/sites/34445/2015/11/grapesofwrath.jpg',8),(10,'Les Miserables','Introducing one of the most famous characters in literature, Jean Valjeanthe noble peasant imprisoned for stealing a loaf of breadLes Misérables ranks among the greatest novels of all time. In it, Victor Hugo takes readers deep into the Parisian underworld, immerses them in a battle between good and evil, and carries them to the barricades during the uprising of 1832 with a breathtaking realism that is unsurpassed in modern prose.','2018-01-03',1288,'English','https://images-na.ssl-images-amazon.com/images/I/51P01h3DZtL._SX300_BO1,204,203,200_.jpg',7),(11,'The Master and Margarita','The underground masterpiece of twentieth-century Russian fiction, this classic novel was written during Stalins regime and could not be published until many years after its authors death.\r\n\r\nWhen the devil arrives in 1930s Moscow, consorting with a retinue of odd associatesincluding a talking black cat, an assassin, and a beautiful naked witchhis antics wreak havoc among the literary elite of the world capital of atheism. Meanwhile, the Master, author of an unpublished novel about Jesus and Pontius Pilate, languishes in despair in a pyschiatric hospital, while his devoted lover, Margarita, decides to sell her soul to save him. As Bulgakovs dazzlingly exuberant narrative weaves back and forth between Moscow and ancient Jerusalem, studded with scenes ranging from a giddy Satanic ball to the murder of Judas in Gethsemane, Margaritas enduring love for the Master joins the strands of plot across space and time.','1996-03-18',384,'English','https://images-na.ssl-images-amazon.com/images/I/410UJkJtmhL._SX323_BO1,204,203,200_.jpg',15),(12,'War and Peace','Often called the greatest novel ever written, War and Peace is at once an epic of the Napoleonic Wars, a philosophical study, and a celebration of the Russian spirit. Tolstoys genius is seen clearly in the multitude of characters in this massive chronicleall of them fully realized and equally memorable. Out of this complex narrative emerges a profound examination of the individuals place in the historical process, one that makes it clear why Thomas Mann praised Tolstoy for his Homeric powers and placed War and Peace in the same category as the Iliad: To read him . . . is to find ones way home . . . to everything within us that is fundamental and sane.','2009-07-07',1424,'English','https://images-na.ssl-images-amazon.com/images/I/51j4UrRkj3L._SX311_BO1,204,203,200_.jpg',24),(14,'The Brothers Karamazov','The Brothers Karamazov, Dostoevsky\'s crowning achievement, is a tale of patricide and family rivalry that embodies the moral and spiritual dissolution of an entire society (Russia in the 1870s). It created a national furor comparable only to the excitement stirred by the publication, in 1866, of Crime and Punishment. To Dostoevsky, The Brothers Karamazov captured the quintessence of Russian character in all its exaltation, compassion, and profligacy. Significantly, the book was on Tolstoy\'s bedside table when he died. Readers in every language have since accepted Dostoevsky\'s own evaluation of this work and have gone further by proclaiming it one of the few great novels of all ages and countries.','1996-01-03',912,'English','https://images-na.ssl-images-amazon.com/images/I/41egGqEd8rL._SX337_BO1,204,203,200_.jpg',35),(15,'The Great Gatsby','Invited to an extravagantly lavish party in a Long Island mansion, Nick Carraway, a young bachelor who has just settled in the neighbouring cottage, is intrigued by the mysterious host, Jay Gatsby, a flamboyant but reserved self-made man with murky business interests and a shadowy past. As the two men strike up an unlikely friendship, details of Gatsby\'s impossible love for a married woman emerge, until events spiral into tragedy.','2016-10-26',256,'English','https://images-na.ssl-images-amazon.com/images/I/51xL1-nBpUL._SX321_BO1,204,203,200_.jpg',4),(17,'The Inferno','Harvard professor of symbology Robert Langdon awakens in an Italian hospital, disoriented and with no recollection of the past thirty-six hours, including the origin of the macabre object hidden in his belongings. With a relentless female assassin trailing them through Florence, he and his resourceful doctor, Sienna Brooks, are forced to flee. Embarking on a harrowing journey, they must unravel a series of codes, which are the work of a brilliant scientist whose obsession with the end of the world is matched only by his passion for one of the most influential masterpieces ever written, Dante Alighieri\'s The Inferno.','2014-05-02',624,'English','https://images-na.ssl-images-amazon.com/images/I/51Z3qv%2BESqL._SX277_BO1,204,203,200_.jpg',5),(52,'The Count of Monte Cristo','With an Introduction and Notes by Keith Wren, University of Kent at Canterbury The story of Edmund Dantes, self-styled Count of Monte Cristo, is told with consummate skill. The victim of a miscarriage of justice, Dantes is fired by a desire for retribution and empowered by a stroke of providence. In his campaign of vengeance, he becomes an anonymous agent of fate. The sensational narrative of intrigue, betrayal, escape, and triumphant revenge moves at a cracking pace. Dumas\' novel presents a powerful conflict between good and evil embodied in an epic saga of rich diversity that is complicated by the hero\'s ultimate discomfort with the hubristic implication of his own actions.','1998-04-01',928,'English','https://images-na.ssl-images-amazon.com/images/I/51Hj7mV521L._SX317_BO1,204,203,200_.jpg',0),(56,'Na Drini cuprija','Kameni most iz XVI veka, zadubina Mehmed pae Sokolovi&#263;a, kao nemi svedok pamti prividno slaganje razli&#269;itih kultura, vera i naroda dok me&#273;u njima u stvari vlada antagonizam. Najvidljivija je razlika izme&#273;u dve civilizacije, isto&#269;ne i zapadne. Most je, izmedju gra&#273;enja i delimi&#269;nog ruenja po&#269;etkom XX veka, bio jedina postojana i nepromenljiva ta&#269;ka o koju se odbijaju sve napetosti i komeanja koja ra&#273;aju sukobe me&#273;u ljudima, kulturama, verama i tadanjim carstvima. Upravo tu &#269;injenicu Ivo Andri&#263; koristi da napravi fantasti&#269;an pripovijeda&#269;ki luk dug &#269;etiri stotine godina od gotovo kristalno &#269;istog literarnog stila, &#269;ine&#263;i da most postane deo naih sopstvenih ivota.','2007-06-13',352,'Serbian','https://images-na.ssl-images-amazon.com/images/I/51nV90%2BPkuL._SX356_BO1,204,203,200_.jpg',0);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_author` (
  `book_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`author_id`),
  KEY `AUTHOR_FK` (`author_id`),
  CONSTRAINT `AUTHOR_FK` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `BOOK_FK` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_author`
--

LOCK TABLES `book_author` WRITE;
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` VALUES (1,1),(2,1),(17,1),(8,5),(10,7),(11,9),(11,10),(12,10),(14,11),(15,12),(52,18),(56,19);
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(35) NOT NULL,
  `last_name` varchar(35) NOT NULL,
  `date_of_birth` date NOT NULL,
  `adress` varchar(80) NOT NULL,
  `city` varchar(30) NOT NULL,
  `phone` varchar(35) NOT NULL,
  `email` varchar(65) DEFAULT NULL,
  `image_url` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (2,'Robert','Doe','1995-01-22','First Aveny','NY','066258789','robert1234@gmail.com','https://s3.amazonaws.com/im-cms-uploads-prod/uploads/person-profile-80150.jpg?v=63661583473'),(9,'Mark','Anthony','1996-04-11','Blue Road 74','Chicago','212-212-2014','mark@antony.com',NULL),(14,'Alan','Ford','1997-04-01','Dusty Road 3','Las Vegas','212-589-789',NULL,NULL),(22,'Johnny','Depp','1975-01-01','Oak Street 13','Los Angeles','212-509-111',NULL,NULL),(30,'Sasa','Gavric','1996-06-06','Berlin Street 50','Berlin','212-509-478','salegavric@outlook.com','https://michaeldick.me/img/profile.jpg'),(31,'Robert','Doe','1995-01-22','First Aveny','NY','066258789','robert1234@gmail.com','https://s3.amazonaws.com/im-cms-uploads-prod/uploads/person-profile-80150.jpg?v=63661583473'),(32,'Sasa','Gavric','1996-06-06','Berlin Street 50','Berlin','212-509-478','salegavric@outlook.com','https://michaeldick.me/img/profile.jpg'),(34,'Rocky','Gavric','2018-01-31','Oak','NY','22589789',NULL,NULL),(356,'Rocky','Balboa','2016-05-05','Oak','Phily','212-509-1489',NULL,NULL),(357,'Chad','Darby','1985-02-13','Some Phily Street','Philadelphia','212-852-789','luv2code@luv2code.com','http://www.luv2code.com/wp-content/uploads/2010/05/darby_headshot.jpg'),(358,'Sasa','Mitrovic','2018-02-22','Rocky Road','Dublin','212-509-158',NULL,NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_book`
--

DROP TABLE IF EXISTS `member_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `date_of_borrowing` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index` (`member_id`,`book_id`),
  KEY `BOOK_MEMBER_FK` (`book_id`),
  CONSTRAINT `BOOK_MEMBER_FK` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `MEMBER_BOOK_FK` FOREIGN KEY (`member_id`) REFERENCES `member` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_book`
--

LOCK TABLES `member_book` WRITE;
/*!40000 ALTER TABLE `member_book` DISABLE KEYS */;
INSERT INTO `member_book` VALUES (32,2,8,'2018-03-06'),(33,2,17,'2018-03-06'),(34,9,17,'2018-03-06'),(35,9,10,'2018-03-06'),(39,14,17,'2018-03-06'),(41,358,56,'2018-03-06'),(42,357,1,'2018-03-06'),(43,357,15,'2018-03-06'),(54,31,1,'2018-03-06'),(55,34,56,'2018-03-07');
/*!40000 ALTER TABLE `member_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('chad.darby','{bcrypt}$2a$04$C9lA9WJsMr1odfPV0fQGSuVcj2eXkolq.YZG8QuM05U80J096mwem',1),('sasa.gavric','{bcrypt}$2a$04$OrpCh1STYM.ckoZD44Er5.4wIKMw5Dl470o9hTAmkXivxX8xwGYFi',1);
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

-- Dump completed on 2018-03-10 14:56:55
