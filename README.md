# multimodules
2 сервиса. 
<details>
  <summary>№1 сервис</summary>
Находиться в папке first-service.
Имеет 1 едпоинт на гет запрос и работает на 8081 port.
http://localhost:8081/
Внутри ендпоинта вызывает посторонний сервис, "client", который вызывает ендпоинт сервиса №2
</details>
<details>
  <summary>№2 сервис</summary>
Находиться в папке second-service
Имеет 1 едпоинт на гет запрос и работает на 8080 port.
http://localhost:8080/hello
</details>
