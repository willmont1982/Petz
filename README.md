# Teste Petz para consumo de APIs Rest em controle de produtos.
# Autor: Willian Roberto Montrezol

Utilize **docker-compose.yaml**.

## Tecnologias BackEnd

- Spring Boot 2
- Docker
- API-REST
- Hibernate
- JPA 
- MySQL
- Maven 
- JDK 8

```
- C:\Users\petz> docker-compose up -d
- docker container ps (copie o id do container do mysql)
- docker exec -it cf1fdae66620  bin/bash 
- mysql -uroot -p petz
- password: root
- show tables;
```

```
INSERT INTO `address` VALUES ('1', 'RIO DE JANEIRO', 'BRASIL');
INSERT INTO `address` VALUES ('2', 'MINAS GERAIS', 'BRASIL');

INSERT INTO `client` VALUES ('1', 'Luiz Antonio Correa das Costa', '1');
INSERT INTO `client` VALUES ('2', 'Marcos Evangelista de Moraes', '1');
INSERT INTO `client` VALUES ('3', 'Lucas Prato', '2');

INSERT INTO `document` VALUES ('1', '98176897272', 'CPF');
INSERT INTO `document` VALUES ('2', '583437965', 'RG');
INSERT INTO `document` VALUES ('3', '583437965', 'RG');

INSERT INTO `client_documents` VALUES ('1', '1');
INSERT INTO `client_documents` VALUES ('2', '2');
INSERT INTO `client_documents` VALUES ('3', '3');

INSERT INTO `pet` VALUES ('4', '9', 'Peppa', '1');
INSERT INTO `pet` VALUES ('5', '2', 'Madruguinha', '2');

```

find-all
```
curl -X GET 'http://localhost:8087/v1/client'
```

findBy-id
```
curl -X GET 'http://localhost:8087/v1/client/{id}'
```

update
```
curl -X PUT 'http://localhost:8087/v1/client/{id}'
{
    "id": 1,
    "name": "Luiz Antonio Correa das Costa",
    "address": {
        "id": 1,
        "country": "BRASIL",
        "city": "RIO DE JANEIRO"
    },
    "documents": [
        {
            "id": 1,
            "number": "98176897272",
            "type": "CPF"
        }
    ]
}
```
create
```
curl -X POST 'http://localhost:8087/v1/client'
{
    "id": null,
    "name": "Luiz Antonio Correa das Costa",
    "address": {
        "id": 1,
        "country": "BRASIL",
        "city": "RIO DE JANEIRO"
    },
    "documents": [
        {
            "id": 1,
            "number": "98176897272",
            "type": "CPF"
        }
    ]
}
```
delete
```
curl -X DELETE 'http://localhost:8087/v1/client/{id}'
```

Pet
```
curl -X GET 'http://localhost:8087/v1/petz'
```

