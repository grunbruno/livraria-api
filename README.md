#GET
{dominio}/autores
{dominio}/livros

#POST
{dominio}/autores
{dominio}/livros

#exemplo de AutorDTO para POST
{
    "nome": "Bruno",
    "email": "grunbruno@gmail.com",
    "dataNascimento": "2021-09-14",
    "miniCurriculo": "Bruno é um excelente autor de livros de terror"
}

#exemplo de LivroDTO para POST

{
    "titulo": "O Morro dos Ventos Uivantes",
    "dataLancamento": "2021-09-01",
    "numeroDePaginas": 100,
    "autor": {
        "nome": " Emily Bronte",
        "email": "emilly@gmail.com",
        "dataNascimento": "1985-09-14",
        "miniCurriculo": "Emily é um excelente autor de livros de terror"
    }
}
