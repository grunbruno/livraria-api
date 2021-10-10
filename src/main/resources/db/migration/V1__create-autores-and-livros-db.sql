CREATE TABLE `autores` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(255),
  `email` varchar(255),
  `data_nascimento` date,
  `mini_curriculo` TEXT
);

CREATE TABLE `livros` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `data_lancamento` varchar(255),
  `numero_de_paginas` int,
  `titulo` varchar(255),
  `id_autor` int
);
ALTER TABLE `livros` ADD FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id`);