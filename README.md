#GET  
{dominio}/autores  
{dominio}/livros

#POST  
{dominio}/autores  
{dominio}/livros

**Para inserir um livro é necessário:  
- inserir um autor primeiro    

ex: {
    "nome": "Bruno",
    "email": "grunbruno@gmail.com",
    "dataNascimento": "2021-09-14",
    "miniCurriculo": "Bruno é um excelente autor de livros de terror"
}

- inserir um livro com um dos id's retornados no serviço GET de autores  
ex:

{
    "titulo": "O Morro dos Ventos Uivantes",
    "dataLancamento": "2021-09-01",
    "numeroDePaginas": 100,
    "autor": {
        "id": XXXXXX
    }
}
