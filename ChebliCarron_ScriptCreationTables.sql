-- Titre :        Création base projet Congès
-- Version :      1.0
-- Date :         27 sept. 2014
-- Auteur :       Manfred CHEBLI, Hervé CARRON
-- Description :  Création des tables de la base Vacations

-- +----------------------------------------------------------------------------------------------+
-- | Suppression des tables (simulation externe)                                                  |
-- +----------------------------------------------------------------------------------------------+

DROP TABLE IF EXISTS Employees CASCADE;
DROP TABLE IF EXISTS Services CASCADE;

-- +----------------------------------------------------------------------------------------------+
-- | Suppression des tables (simulation interne)                                                  |
-- +----------------------------------------------------------------------------------------------+


DROP TABLE IF EXISTS Vacations CASCADE;
DROP TABLE IF EXISTS Comments CASCADE;

-- +----------------------------------------------------------------------------------------------+
-- | Création des tables (externe)                                                                |
-- +----------------------------------------------------------------------------------------------+
CREATE TABLE Services (
	id				SERIAL 				NOT NULL,
	name			VARCHAR(30) 		NOT NULL,
	CONSTRAINT 		servicesPK 			PRIMARY KEY (id)
);

CREATE TABLE Employees (
	id				SERIAL 				NOT NULL,
	lastName		VARCHAR(30) 		NOT NULL,
	firstName		VARCHAR(30) 		NOT NULL,
	serviceId		SERIAL 				NOT NULL,
	managerId		INTEGER,
	CONSTRAINT  employeePK 				PRIMARY KEY (id),
	CONSTRAINT  employeeFKService		FOREIGN KEY (serviceId)  REFERENCES Services(id),
	CONSTRAINT  employeeFKEmployee 		FOREIGN KEY (managerId)  REFERENCES Employees(id)
);

-- +----------------------------------------------------------------------------------------------+
-- | Création des tables (interne)                                                                |
-- +----------------------------------------------------------------------------------------------+
CREATE TABLE Vacations (
	id				SERIAL 				NOT NULL,
	begDate			DATE				NOT NULL,
	begTime			VARCHAR(20) 		NOT NULL,
	endDate			DATE				NOT NULL,
	endTime			VARCHAR(20)			NOT NULL,
	status			VARCHAR(20)			NOT NULL,
	employeeId		SERIAL 				NOT NULL,
	managerId		INTEGER,
	hrId			INTEGER,		
	CONSTRAINT	vacationPK 				PRIMARY KEY (id),
	CONSTRAINT	vacationFKemployeeEmp	FOREIGN KEY (employeeId) REFERENCES Employees(id),
	CONSTRAINT	vacationFKemployeeMgr	FOREIGN	KEY	(managerId)	 REFERENCES Employees(id),
	CONSTRAINT  vacationFKemployeeHR	FOREIGN KEY (hrId)		 REFERENCES Employees(id)
);

CREATE TABLE Comments (
	id				SERIAL				NOT NULL,
	creaDate		TIMESTAMP			NOT NULL DEFAULT LOCALTIMESTAMP,
	comments		VARCHAR(500)		NOT NULL,
	creatorId		INTEGER				NOT NULL,
	vacationId		INTEGER				NOT NULL,
	CONSTRAINT		commentsPK			PRIMARY KEY	(id),
	CONSTRAINT		commentsFKemployee	FOREIGN	KEY (creatorId)	 REFERENCES Employees(id),
	CONSTRAINT		commentsFKvac		FOREIGN KEY (vacationId) REFERENCES	Vacations(id)
);

-- +----------------------------------------------------------------------------------------------+
-- | Insertion de quelques données de pour les tests                                              |
-- +----------------------------------------------------------------------------------------------+

-- Insertion des Services
INSERT INTO Services VALUES (nextval('services_id_seq'),'CODIR');
INSERT INTO Services VALUES (nextval('services_id_seq'),'RH');
INSERT INTO Services VALUES (nextval('services_id_seq'),'Labo1');

-- Insertion des Employés
INSERT INTO Employees VALUES (nextval('employees_id_seq'),'Smith', 'John', 1, NULL );
INSERT INTO Employees VALUES (nextval('employees_id_seq'),'Cliff', 'Jimmy', 2, 1 );
INSERT INTO Employees VALUES (nextval('employees_id_seq'),'Denzey', 'Willy', 3, 1 );
INSERT INTO Employees VALUES (nextval('employees_id_seq'),'Snow', 'John', 2, 2 );
INSERT INTO Employees VALUES (nextval('employees_id_seq'),'Sand', 'Bobby', 3, 3 );



-- Insertion des congés
INSERT INTO Vacations VALUES (nextval('vacations_id_seq'), to_date('05 Dec 2014', 'DD Mon YYYY'), 'Matin', to_date('15 Dec 2014', 'DD Mon YYYY'), 'Aprem', 'ValidatedHR',  1, NULL, 4 );
INSERT INTO Vacations VALUES (nextval('vacations_id_seq'), to_date('10 Dec 2014', 'DD Mon YYYY'), 'Aprem', to_date('20 Dec 2014', 'DD Mon YYYY'), 'Aprem', 'ValidatedHR',  2, 1, 4 );
INSERT INTO Vacations VALUES (nextval('vacations_id_seq'), to_date('05 Dec 2014', 'DD Mon YYYY'), 'Matin', to_date('25 Dec 2014', 'DD Mon YYYY'), 'Matin', 'ValidatedHR',  4, 2, 4 );

--Insertion de commentaires
INSERT INTO Comments  VALUES (nextval('comments_id_seq'), LOCALTIMESTAMP , 'COUCOU HIBOUX', 1, 1 );