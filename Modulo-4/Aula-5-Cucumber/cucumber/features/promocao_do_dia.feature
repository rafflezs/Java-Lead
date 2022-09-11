#language:pt

Funcionalidade: Promoção do dia!
  Queremos saber qual a promoção do dia na loja XYZ

Cenário: Hoje é dia de desconto em eletrônicos
  # Dado que hoje é "quarta-feira"
  Dado que hoje é "sexta-feira"
  Quando eu pergunto qual é a promoção do dia
  # Então a resposta deve ser "desconto de 10% em monitores"
  Então a resposta deve ser "desconto de 30% em artigos esportivos"