-- Eliminar las tablas
DROP TABLE Cita;
DROP TABLE Paciente;
DROP TABLE Informe;
DROP TABLE Cliente;
DROP TABLE Veterinario;
DROP TABLE Administrador;
DROP TABLE Medicamento;
DROP TABLE Veterinaria;

CREATE TABLE Veterinaria (
	idVeterinaria NUMERIC(9),
	nombre VARCHAR (40),
	direccion VARCHAR(255),
	email VARCHAR(100),
	telefono NUMERIC(9),
	
	CONSTRAINT PK_Veterinaria PRIMARY KEY (idVeterinaria)
);

CREATE TABLE Medicamento (
	idMedicamento NUMERIC(9) NOT NULL,
    idVeterinaria numeric(9) NOT NULL,
	nombre VARCHAR (40),
	prospecto VARCHAR(255),
	caducidad DATE NOT NULL,
	existencias INTEGER,
	
	CONSTRAINT PK_Medicamento PRIMARY KEY (idMedicamento),
    CONSTRAINT FK_MedVeterinaria FOREIGN KEY(idVeterinaria) REFERENCES Veterinaria(idVeterinaria) on delete cascade
);

CREATE TABLE Veterinario (
	idVeterinario NUMERIC(9) NOT NULL,
    idVeterinaria NUMERIC(9) not null,
	dni VARCHAR (9),
	nombre VARCHAR (40),
	telefono VARCHAR (9),
	contrasena VARCHAR (32) NOT NULL,
	licencia NUMERIC(20) NOT NULL,
	especialidad VARCHAR(40),
	consulta NUMERIC(9),
    
    CONSTRAINT id_PK_Veterinario PRIMARY KEY (idVeterinario),
    CONSTRAINT FK_VetVeterinaria foreign key(idVeterinaria) references Veterinaria(idVeterinaria) ON DELETE CASCADE
);

CREATE TABLE Administrador (
	idAdmin NUMERIC(9) NOT NULL,
    idVeterinaria NUMERIC(9) NOT NULL,
	dni VARCHAR (9),
	nombre VARCHAR (40),
	telefono VARCHAR (9),
	contrasena VARCHAR (32) NOT NULL,
	numUsuario NUMERIC(9) NOT NULL,
    
    CONSTRAINT id_PK_Administrador PRIMARY KEY (idAdmin),
    CONSTRAINT FK_AdminVeterinaria FOREIGN KEY(idVeterinaria) REFERENCES Veterinaria(idVeterinaria) ON DELETE CASCADE
);

CREATE TABLE Cliente (
	idCliente NUMERIC(9) NOT NULL,
    idVeterinaria NUMERIC(9) NOT NULL,
	dni VARCHAR (30),
	nombre VARCHAR (40),
	telefono VARCHAR (9),
	contrasena VARCHAR (32) NOT NULL,
    
    CONSTRAINT PK_Cliente PRIMARY KEY (idCliente),
    constraint FK_CliVeterinaria FOREIGN KEY(idVeterinaria) REFERENCES Veterinaria(idVeterinaria) ON DELETE CASCADE
);

CREATE TABLE Paciente (
	idPaciente VARCHAR(9) NOT NULL,
	animal VARCHAR (9),
	raza VARCHAR (40),
	sexo VARCHAR (9),
	edad NUMERIC(9),
    idCliente NUMERIC(9),
    
    CONSTRAINT id_PK_Paciente PRIMARY KEY (idPaciente),
    CONSTRAINT FK_PacCliente FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE
);

CREATE TABLE Informe(
	idInforme NUMERIC(9),
    contenido VARCHAR(500),
    idCliente NUMERIC(9),
    
    constraint PK_idInforme primary key(idInforme),
    CONSTRAINT FK_InfCliente FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente) ON DELETE CASCADE
);

CREATE TABLE Cita (
	idCita NUMERIC(9) NOT NULL,
    idVeterinaria NUMERIC(9) NOT NULL,
	idVeterinario NUMERIC(9) NOT NULL,
	idCliente NUMERIC(9) NOT NULL,
	idMedicamento NUMERIC(9) NOT NULL,
	informe VARCHAR(250),
	fecha DATETIME NOT NULL,
	
	CONSTRAINT PK_Cita PRIMARY KEY (idCita),
    CONSTRAINT FK_Veterinario FOREIGN KEY(idVeterinario) REFERENCES Veterinario(idVeterinario) ON DELETE CASCADE,
    CONSTRAINT FK_CitaVeterinaria foreign key(idVeterinaria) references Veterinaria(idVeterinaria) ON DELETE CASCADE,
    CONSTRAINT FK_Cliente foreign key(idCliente) references cliente(idCliente) ON DELETE CASCADE,
    CONSTRAINT Fk_Medicamento foreign key(idMedicamento) references medicamento(idMedicamento) ON DELETE CASCADE
);

DROP TRIGGER idxUsuario;

-- Trigger que a cada usuario nuevo introducido le da un id unico
delimiter $$
CREATE TRIGGER idxUsuario BEFORE INSERT 
ON Usuario
FOR EACH ROW

BEGIN
	DECLARE idNew NUMERIC;
	
	SELECT MAX(id) + 1 INTO idNew
	FROM Usuario;

	IF idNew IS NULL THEN -- valor dado para tabla vacia es primer usuario
		SET idNew = 00000000;
    END IF;

	UPDATE Usuario
	SET id = idNew
	WHERE id IS NULL;
END;
$$
DELIMITER ;