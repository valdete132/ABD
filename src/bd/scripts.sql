CREATE TABLE Emprestimo (
	id				INT SERIAL NOT NULL PRIMARY KEY,
	datadevolucao	TIMESTAMP,
	dataemprestimo	TIMESTAMP,
	matriculaaluno	INT FOREIGN KEY REFERENCES Aluno(matriculaaluno),
	codigopub		INT FOREIGN KEY REFERENCES Publicacao(codigopub)
);

CREATE TABLE Aluno (
	matriculaaluno	INT PRIMARY KEY,
	nome			VARCHAR
);

CREATE TABLE Publicacao (
	codigopub		INT PRIMARY KEY,
	titulo			VARCHAR,
	ano				INT,
	autor			VARCHAR,
	tipo			VARCHAR
);
