--Incluindo QUATRO Autores:
INSERT INTO AUTOR(nome, descricao) VALUES('Paulo Silveira', 'Bacharel e mestre em Ciência da Computação pela USP, possui mais de 10 anos de experiência com desenvolvimento, passando pela Alemanha e pelo IBOPE.');
INSERT INTO AUTOR(nome, descricao) VALUES('Adriano Almeida', 'Formado em Sistemas de Informação pela FIAP, começou sua carreira com Editoração Eletrônica e desenvolveu sistemas em Java, Ruby on Rails, PHP e VB.');
INSERT INTO AUTOR(nome, descricao) VALUES('Nelson Fabbri Gerbelli', 'Tecnólogo em Processamento de Dados pela faculdade FAINAM, pós-graduado em Análise de Sistemas pela faculdade ESAN.');
INSERT INTO AUTOR(nome, descricao) VALUES('Valéria Helena P. Gerbelli', 'Tecnóloga em Processamento de Dados pela faculdade IESA. Pedagoga e com licenciatura plena em Informática. Pós-graduanda em Educação Profissional e Tecnológica.');
INSERT INTO AUTOR(nome, descricao) VALUES('Lucas Mazza', 'faz parte da equipe de desenvolvedores da Plataformatec, empresa de desenvolvimento de São Paulo, especializada em Ruby on Rails. Combinando a linguagem Ruby com HTML, CSS e JavaScript.');


--Incluinco QUATRO Categorias:
INSERT INTO CATEGORIA(nome) VALUES('Programação');
INSERT INTO CATEGORIA(nome) VALUES('Mobile');
INSERT INTO CATEGORIA(nome) VALUES('Front-end');
INSERT INTO CATEGORIA(nome) VALUES('Infraestrutura');


--Incluindo SEIS SubCategorias:
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('Lógica', 1);
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('Java', 1);
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('Android', 2);
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('iOS', 2);
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('HTML e CSS', 3);
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('JavaScript', 3);
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('Web', 4);
INSERT INTO SUB_CATEGORIA(nome, categoria_id) VALUES('Dados', 4);


--Incluindo o PRIMEIRO Livro
INSERT INTO LIVRO(categoria_id, sub_categoria_id, titulo, sub_titulo, conteudo, autor_id, numero_paginas, isbn)
VALUES(1, 1, 'Lógica de Programação', 'Crie seus primeiros programas usando Javascript e HTML', 'O livro explora os recursos do HTML e Javascript, criando a familiaridade desde o começo dos estudos com a sintaxe da linguagem de programação, instruções, funções específicas e problemas corriqueiros da programação', 1, 180, '978-85-66250-22-0');


--Incluindo o SEGUNDO Livro
INSERT INTO LIVRO(categoria_id, sub_categoria_id, titulo, sub_titulo, conteudo, autor_id, numero_paginas, isbn)
VALUES(2, 2, 'App Inventor', 'Seus primeiros aplicativos Android', 'Após ser apresentado ao ambiente, você aprenderá na prática a desenvolver alguns aplicativos do zero, partindo de alguns cálculos, até chegar a resultados mais complexos, com um recurso de localização de GPS', 2, 311, '978-85-94188-30-4');
																	

--Incluindo o TERCEIRO Livro
INSERT INTO LIVRO(categoria_id, sub_categoria_id, titulo, sub_titulo, conteudo, autor_id, numero_paginas, isbn)
VALUES(3, 3, 'HTML5 e CSS3', 'Domine a web do futuro', 'Crie páginas elegantes de forma simples! HTML e CSS, quando bem utilizados, podem ser o sucesso de um projeto', 3, 228, '978-85-66250-05-3');