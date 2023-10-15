CREATE DATABASE exploretour;
use exploretour;


CREATE TABLE usuarios (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nomeUsuario VARCHAR (255) NOT NULL COMMENT 'Nome Usuario' ,
    cpfUsuario VARCHAR (255) NOT NULL UNIQUE COMMENT 'Email de Usuario',
    emailUsuario  TEXT NOT NULL COMMENT 'Endereço do Usuario' ,
    telefoneUsuario VARCHAR (15) NOT NULL COMMENT'Telefone Usuario'
); 


CREATE TABLE destinos (
    idDestinos INT AUTO_INCREMENT PRIMARY KEY,
    nomeDestino VARCHAR (255) NOT NULL UNIQUE COMMENT 'Nome do destino' ,
    descricaoDestino VARCHAR (255) NOT NULL COMMENT 'DEscrição de Destino' ,
); 


CREATE TABLE reservas (
    idReserva INT COMMENT 'Identificador Unico da reserva',
    dataDestino DATETIME COMMENT 'Data da reserva',
    statusReserva VARCHAR(255) DEFAULT 'pendente' COMMENT 'Status da reserva(confirmada, pendente, cancelada, etc.)'
    idUsuario INT COMMENT 'Referente ao ID do usuario que fez a reserva' ,
    idDestinos INT COMMENT 'Referente ao ID do destino da reserva' ,
    FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario),
    FOREIGN KEY (idDestinos) REFERENCES destinos (idDestinos),
); 