# multimodules
2 сервиса. 
<details>
  <summary>№1 сервис</summary>
Находиться в папке first-service.
Имеет 2 едпоинта на гет запрос и работает на 8081 port.
http://localhost:8081/
Внутри ендпоинта вызывает сервис #2 и его ендпоинт "/hello"
http://localhost:8081/ex 
Внутри ендпоинта вызывает сервис #2 и его ендпоинт "/exception"
Так как ендпоинт /eception выдает ошибку, через Feign client и ErrorDecoder мы вызываем ошибку.
Отлов ошибки осуществляется с помощью ControllerExceptionHandler
</details>
<details>
  <summary>№2 сервис</summary>
Находиться в папке second-service
Имеет 2 едпоинтa на гет запрос и работает на 8080 port.
http://localhost:8080/hello
http://localhost:8080/exception
</details>
