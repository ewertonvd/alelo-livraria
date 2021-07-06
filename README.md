# alelo-livraria

Teste Alelo - Desenvolvedor Back-end:

Essa é um API 'simples', com os métodos GET/POST/Delete e PUT. Utilizando Spring Boot, Java8 e BD em memória H2

===============================================================================================================================
Instruções para testar a API pelo Postman, após importar e subir o projeto na IDE:


Lista de Livros - GET => http://localhost:8080/livros 

-------------------------------------------------------------------------------------------------------------------------------
Listar os detalhes de um Livro: Parâmetro id{}

GET => http://localhost:8080/livros/3

-------------------------------------------------------------------------------------------------------------------------------
Cadastrar Livro - POST => http://localhost:8080/livros 
Content-Type - Application/Json
BODY:

{
"titulo": "DevOps na prática",
"conteudo": "Implementar práticas de DevOps e Entrega Contínua para aumentar a frequência de deploys na sua empresa.",
"nomeAutor": "Adriano Almeida",
"numeroPaginas": 284
}

-------------------------------------------------------------------------------------------------------------------------------
ATUALIZAR - PUT => http://localhost:8080/livros/3
Content-Type - Application/Json
BODY:

{
    "titulo": "HTML5 e CSS3 - Atualizado",
    "conteudo": "Crie páginas elegantes de forma simples! HTML e CSS, quando bem utilizados, podem ser o sucesso de um projeto",
    "nomeAutor": "Nelson Fabbri Gerbelli",
    "numeroPaginas": 228
}

-------------------------------------------------------------------------------------------------------------------------------
Parâmetro id{}

Deletar - DELETE => http://localhost:8080/livros/4

Exclui o livro com ID = 4;

