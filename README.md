## Описание
Заглушка для моделирования поведения интерфейса сервиса разбора документа

Принимает запрос POST
```
http://<host>:<port>/document-parser-stub/api/rest/services/llm/docverify
```
Данные в виде multipart/form-data

Заглушка возвращает всегда один и тот же ответ

Swagger-ui
```
http://<host>:<port>/document-parser-stub/swagger-ui/index.html
```
По умолчанию порт 8080, меняется переменной среды port

## Требования

1. Java 17
2. gradle 7.5 +
3. docker-compose 1.29+

## Сборка приложения

```
gradle clean build
```

## Запуск приложения

```
cd docker

docker-compose up --build
```

Открыть и проверить работоспособность

http://localhost:8080/document-parser-stub/swagger-ui/index.html
