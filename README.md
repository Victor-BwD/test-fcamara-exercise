O teste é para criar uma API REST para gerenciar um estacionamento de carros e motos.

Nesse projeto temos: 
- CRUD carros e motos
- CRUD estabelecimentos
- Controle de entradas e saídas
- Pequeno relatório de entradas e saídas

O projeto é feito em java 17 utilizando MongoDB como banco de dados e Spring Boot como framework.

Temos três tipos de rotas: A de veiculos, de estabelecimentos e sumário...

Veículos:
- get: localhost:8080/api/car, permite trazer todos os carros cadastrados junto com seus respectivos estalecimentos usados como estacionamentos
- post: localhost:8080/api/car, permite criar um veículo
- put: localhost:8080/api/car/:id, permite atualizar as informações do veículo
- del: localhost:8080/api/car/:id, permite deletar um veículo

Estabelecimentos: 
- get: localhost:8080/api/establishment, permite trazer todos os estabelecimentos cadastrados
- post: localhost:8080/api/establishment, permite cadastrar novos estabelecimentos que serão usados no cadastro de veículos
- put: localhost:8080/api/establishment/:id, permite atualizar informações sobre o estabelecimento
- del: localhost:8080/api/establishment/:id, permite deletar um estabelecimento

Sumário:
- get: localhost:8080/api/report, traz um resumo de entradas e saídas de veículos
