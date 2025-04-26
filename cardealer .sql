-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 26, 2025 alle 15:26
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cardealer`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `arrivo`
--

CREATE TABLE `arrivo` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `arrivo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `autentificazione`
--

CREATE TABLE `autentificazione` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `mail` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `autentificazione`
--

INSERT INTO `autentificazione` (`user_id`, `username`, `Password`, `mail`) VALUES
(1, 'Andrea', 'password', 'asd@gmail.com'),
(2, 'ciao', 'asd', 'cioa@gmail.com'),
(3, 'Giorgio', 'password', 'giorgio@impiegatiEvricar.com'),
(4, 'franco', 'password', 'franco@segreteriaEvricar.com');

-- --------------------------------------------------------

--
-- Struttura della tabella `automobili`
--

CREATE TABLE `automobili` (
  `car_id` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modello` varchar(50) NOT NULL,
  `descrizione` varchar(500) NOT NULL,
  `altezza` float NOT NULL,
  `lunghezza` float NOT NULL,
  `larghezza` float NOT NULL,
  `peso` float NOT NULL,
  `volume_bagagliaio` int(11) NOT NULL,
  `prezzo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `automobili`
--

INSERT INTO `automobili` (`car_id`, `categoria`, `marca`, `modello`, `descrizione`, `altezza`, `lunghezza`, `larghezza`, `peso`, `volume_bagagliaio`, `prezzo`) VALUES
(1, 'Sportiva', 'Audi', 'Rs3', 'La Audi RS3 è una berlina compatta ad alte prestazioni, equipaggiata con un motore turbo a 5 cilindri che eroga oltre 400 CV. È rinomata per la sua accelerazione rapida, la trazione integrale quattro e la guida sportiva, rendendola perfetta per gli appassionati di velocità.', 1.61, 4.36, 1.91, 1.595, 251, 35.008),
(2, 'Coupè', 'Audi', 'A5', 'L\'Audi A5 è una coupé elegante, disponibile anche in versione cabrio e sportback. Si distingue per il suo design raffinato, interni lussuosi e un\'esperienza di guida bilanciata che combina comfort e sportività.', 1.39, 4.76, 1.84, 1.591, 465, 56.659),
(3, 'Citycar', 'Audi', 'A1', 'L\'Audi A1 è una city car premium compatta e stilosa, ideale per la guida urbana. Offre un\'efficienza nei consumi eccellente, interni ben rifiniti e un\'ampia gamma di opzioni di personalizzazione per adattarsi a vari stili di vita.', 1.46, 4.05, 1.76, 1.211, 335, 27.799),
(4, 'Sportiva', 'Lamborghini', 'STO', 'La Lamborghini Huracán STO è una supercar ad alte prestazioni ispirata alle corse, dotata di un potente motore V10. Con un design aerodinamico aggressivo e componenti leggere, offre un\'esperienza di guida pura e entusiasmante.', 1.22, 4.54, 1.94, 1.339, 100, 310.099),
(5, 'Sportiva', 'Lamborghini', 'Huracan', 'La Lamborghini Huracán è una supercar iconica con un motore V10 aspirato che combina potenza e design mozzafiato. È perfetta per chi cerca emozioni forti e un look distintivo.', 1.17, 4.53, 1.93, 1.339, 100, 241.099),
(6, 'Sportiva', 'Lamborghini', 'Aventador', 'La Lamborghini Aventador è una supercar di lusso con un motore V12 potente, famosa per le sue prestazioni estreme e il design futuristico. Rappresenta il massimo della tecnologia e dell\'innovazione Lamborghini.', 1.14, 4.81, 2.03, 1.651, 140, 410.219),
(7, 'Sportiva', 'Mercedes', 'AmgGT', 'La Mercedes-AMG GT è una coupé sportiva di lusso con un motore V8 biturbo. Si distingue per il suo design elegante, prestazioni elevate e una guida emozionante, rendendola una scelta eccellente per gli amanti delle auto sportive.', 1.35, 4.73, 1.98, 1.971, 182, 198.561),
(8, 'Suv', 'Mercedes', 'GLC', 'Il Mercedes GLC è un SUV di medie dimensioni che unisce comfort, eleganza e versatilità. Offre interni spaziosi, tecnologie avanzate e capacità off-road, ideale per famiglie e avventure.', 1.61, 4.76, 1.89, 1.945, 390, 71.032),
(9, 'Citycar', 'Mercedes', 'ClasseA', 'La Mercedes Classe A è una berlina compatta e tecnologicamente avanzata, con interni lussuosi e una vasta gamma di sistemi di assistenza alla guida. È perfetta per chi cerca un\'auto elegante e agile per la città.', 1.41, 4.42, 1.81, 1.441, 311, 34.919),
(10, 'Suv', 'Mustang', 'MachE', 'La Mustang Mach-E è il primo SUV elettrico di Ford, che combina il DNA sportivo della Mustang con un\'anima ecologica. Offre un\'ampia autonomia, prestazioni vivaci e un design moderno e accattivante.\r\n\r\n', 1.61, 4.71, 1.88, 2.044, 402, 60.159),
(11, 'Sportiva', 'Mustang', 'GT500', 'La Mustang GT500 è una muscle car iconica dotata di un motore V8 sovralimentato che offre prestazioni incredibili. Con il suo design aggressivo e la sua potenza, è un\'auto per veri appassionati di guida.\r\n\r\n', 1.41, 4.78, 2.03, 1.822, 379, 76.599),
(12, 'Citycar', 'Opel', 'Corsa', 'La Opel Corsa è una berlina compatta e versatile, ideale per la città. Offre una guida confortevole, un buon rapporto qualità-prezzo e una gamma di motori efficienti.\r\n\r\n', 1.43, 4.06, 1.77, 1.055, 309, 19.909),
(13, 'Citycar', 'Opel', 'Karl', 'La Opel Karl è una city car economica e pratica, con dimensioni compatte che la rendono perfetta per la guida urbana. Offre un abitacolo funzionale e buoni consumi di carburante.\r\n\r\n', 1.48, 3.68, 1.61, 1.034, 206, 10.079),
(14, 'Suv', 'Opel', 'Mokka', 'La Opel Mokka è un SUV compatto e stiloso, che combina un design moderno con tecnologie avanzate. Offre una guida rialzata, un buon comfort e un\'ampia gamma di motori.', 1.52, 4.15, 1.79, 1.27, 311, 26.209),
(15, 'OffRoad', 'LandRover', 'RangeRover', 'Il Range Rover è un SUV di lusso, simbolo di eleganza e prestazioni off-road. Con un abitacolo opulento e tecnologie all\'avanguardia, offre un\'esperienza di guida raffinata sia in città che fuori strada.', 1.87, 5.05, 2.05, 2.505, 312, 137.909),
(16, 'OffRoad', 'LandRover', 'Defender', 'Il Land Rover Defender è un fuoristrada iconico, noto per la sua robustezza e capacità off-road. Recentemente rinnovato, combina tradizione e modernità con un design robusto e interni confortevoli.', 1.97, 4.32, 2.01, 2.259, 297, 47.419),
(17, 'Suv', 'LandRover', 'Discovery', 'Il Land Rover Discovery è un SUV spazioso e versatile, perfetto per famiglie e avventure. Offre una combinazione di lusso, comfort e capacità off-road, con tecnologie avanzate per la sicurezza e l\'infotainment.', 1.89, 4.96, 2.07, 2.386, 258, 72.509),
(18, 'Suv', 'Renault', 'Austral', 'La Renault Austral è un SUV di medie dimensioni, progettato per offrire comfort e versatilità. Con un design contemporaneo, interni spaziosi e tecnologie avanzate, è perfetto per le famiglie moderne.\r\n', 1.62, 4.51, 2.08, 1.421, 487, 33.499),
(19, 'Citycar', 'Renault', 'Clio', 'La Renault Clio è una berlina compatta famosa per il suo design accattivante, efficienza nei consumi e tecnologie moderne. È una scelta popolare per chi cerca una city car pratica e affidabile.', 1.44, 4.05, 1.81, 1.028, 301, 17.249),
(20, 'Sportiva', 'Tesla', 'ModelS', 'La Tesla Model S è una berlina elettrica di lusso, nota per la sua impressionante autonomia e prestazioni elevate. Con un\'accelerazione fulminea e un design elegante, rappresenta il futuro della mobilità sostenibile.', 1.45, 4.97, 1.86, 2.144, 745, 94.975),
(21, 'Citytcar', 'Tesla', 'Model3', 'La Tesla Model 3 è una berlina elettrica compatta che offre un eccellente rapporto qualità-prezzo. Con una lunga autonomia, prestazioni vivaci e tecnologie avanzate, è ideale per chi cerca un\'auto ecologica e innovativa.', 1.44, 4.71, 1.85, 1.836, 594, 41.475),
(22, 'Suv', 'Tesla', 'ModelY', 'La Tesla Model Y è un SUV elettrico che combina spazio, prestazioni e sostenibilità. Offre un\'ampia autonomia, interni moderni e una guida dinamica, rendendolo perfetto per famiglie e avventure.\r\n\r\n\r\n\r\n\r\n', 1.61, 4.75, 1.85, 1.909, 854, 43.675),
(23, 'Suv', 'Renault', 'MeganeE-Tech', 'La Renault Megane E-Tech è una berlina elettrica che combina un design moderno con prestazioni ecologiche. Offre un\'ampia autonomia, tecnologie avanzate e un\'esperienza di guida fluida e silenziosa.\r\n', 1.54, 4.21, 1.77, 1.699, 441, 38.049);

-- --------------------------------------------------------

--
-- Struttura della tabella `esitopreventivo`
--

CREATE TABLE `esitopreventivo` (
  `id_preventivo` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `esito` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `esitopreventivo`
--

INSERT INTO `esitopreventivo` (`id_preventivo`, `user_id`, `esito`) VALUES
(4, 1, 'false'),
(5, 1, 'true'),
(7, 2, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `motore`
--

CREATE TABLE `motore` (
  `id_motore` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `cavalli` int(11) NOT NULL,
  `coppia` int(11) NOT NULL,
  `consumo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `motore`
--

INSERT INTO `motore` (`id_motore`, `categoria`, `cavalli`, `coppia`, `consumo`) VALUES
(1, 'Gasolio', 350, 401, 6),
(2, 'Benzina', 200, 300, 8),
(3, 'Ibrida', 150, 200, 2),
(5, 'Elettrica', 500, 600, 14),
(6, 'Ibrida Plug_in', 300, 400, 7);

-- --------------------------------------------------------

--
-- Struttura della tabella `optionalextra`
--

CREATE TABLE `optionalextra` (
  `optional_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `optional` varchar(50) NOT NULL,
  `prezzo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `optionalextra`
--

INSERT INTO `optionalextra` (`optional_id`, `car_id`, `optional`, `prezzo`) VALUES
(1, 1, 'Cerchi£', 1),
(2, 10, 'Tettuccio apribile£', 1),
(3, 6, 'v12£', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `preventivi`
--

CREATE TABLE `preventivi` (
  `id_preventivo` int(11) NOT NULL,
  `contenutoPrev` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `preventivi`
--

INSERT INTO `preventivi` (`id_preventivo`, `contenutoPrev`) VALUES
(1, 'ciao'),
(2, 'Andrea£Rs3£40.008£Audi£Blu£[Interni in pelle, Vetri Oscurati]£Gasolio£2024-08-11£Bologna£asd£asd£modelloU£marcaU£2023£££'),
(3, 'Andrea£Rs3£41.008£Audi£Blu£[Vetri Oscurati, Retrocamera]£Benzina£2024-08-11£Bologna£546£saSA£ModelloU£MarcaU£2323£££'),
(5, 'Andrea£GT500£79.599£Mustang£Nero£[Vetri Oscurati]£Gasolio£2024-08-02£Bari£12312£asdads£££'),
(6, 'ciao£GT500£78.599£Mustang£Bianco£[Interni in pelle]£Gasolio£2025-06-05£Bologna£234£marcorigon7@gmail.com£'),
(7, 'ciao£GT500£79.599£Mustang£Verde£[Interni in pelle]£Gasolio£2025-06-05£Milano£234242432£asdad@gmail.com£');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente_preventivo`
--

CREATE TABLE `utente_preventivo` (
  `user_id` int(11) NOT NULL,
  `id_preventivo` int(11) NOT NULL,
  `Usato` varchar(50) NOT NULL,
  `Ritiro` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `utente_preventivo`
--

INSERT INTO `utente_preventivo` (`user_id`, `id_preventivo`, `Usato`, `Ritiro`) VALUES
(1, 5, 'false', 'Bari'),
(2, 7, 'false', 'Milano');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `autentificazione`
--
ALTER TABLE `autentificazione`
  ADD PRIMARY KEY (`user_id`);

--
-- Indici per le tabelle `automobili`
--
ALTER TABLE `automobili`
  ADD PRIMARY KEY (`car_id`);

--
-- Indici per le tabelle `optionalextra`
--
ALTER TABLE `optionalextra`
  ADD PRIMARY KEY (`optional_id`);

--
-- Indici per le tabelle `preventivi`
--
ALTER TABLE `preventivi`
  ADD PRIMARY KEY (`id_preventivo`);

--
-- Indici per le tabelle `utente_preventivo`
--
ALTER TABLE `utente_preventivo`
  ADD KEY `user_id` (`user_id`),
  ADD KEY `id_preventivo` (`id_preventivo`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `autentificazione`
--
ALTER TABLE `autentificazione`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `automobili`
--
ALTER TABLE `automobili`
  MODIFY `car_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT per la tabella `optionalextra`
--
ALTER TABLE `optionalextra`
  MODIFY `optional_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `preventivi`
--
ALTER TABLE `preventivi`
  MODIFY `id_preventivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `utente_preventivo`
--
ALTER TABLE `utente_preventivo`
  ADD CONSTRAINT `id_preventivo` FOREIGN KEY (`id_preventivo`) REFERENCES `preventivi` (`id_preventivo`),
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `autentificazione` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
