CREATE TABLE `baza_lekarze` (
  `ID` int(11) NOT NULL,
  `lekarzType` int(11) NOT NULL,
  `agent` varchar(255) DEFAULT NULL,
  `lekarz` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `prezentacje-scoress` (
  `appId` int(11) NOT NULL,
  `lekarzType` int(11) NOT NULL,
  `agent` varchar(255) DEFAULT NULL,
  `lekarz` varchar(255) DEFAULT NULL,
  `serverDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `createDate` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;