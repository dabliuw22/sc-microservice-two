# Microservice Two

Microservicio que obtiene el refresh de sus propiedades con RabbitMQ (AMQP).

1. Pre-Requisitos:
	* Java >= 1.8.x
	* Spring Boot 2.1.3.RELEASE
	* Spring Cloud Greenwich.RELEASE
	* RabbitMQ

2. Dependencias:
	* Actuator.
	* Cloud Config: Config Client.
	* Cloud Discovery: Eureka Discovery. 
	* Spring Bus AMQP.
	* Spring Web.

3. Run RabbitMQ with Docker:
```
docker image pull rabbitmq:3-management
docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest rabbitmq:3-management
```

4. Anotar con `@EnableDiscoveryClient` a la clase de configuración.

5. Anotar bean o componente con `@RefreshScope` donde queremos que las propiedades se actualicen:
 
6.  Cambiar `application.properties` a `bootstrap.yml` y agregar:
 
 ```[yaml]
spring:  
  application:
    name: microservice-two
  cloud:
    config:
      discovery:
        enabled: true
        serviceId: config-server
 ```
 
 7. Para utilizar el refresh mediante colas de mensajes con RabitMQ debemos crear un WebHook con nuestro remoto, esto presenta dificultades cuando trabajamos con localhost. 
Primero verificaremos el estado actual de la propiedad consumiendo en `POST http://localhost:8080/greeting`, luego realizaremos un cambio en la propiedad `${properties.example}` en `microservice-one.yml` y subiremos los cambios al remoto, luego simularemos un petición de un WebHook de la siguiente forma:
 
 ```
 curl -H "X-Github-Event: push" -H "Content-Type: application/json" -X POST -d '{"commits": [{"modified": ["microservice-two.yml"]}]}' http://localhost:8888/monitor
 ```
Más tarde podremos verificar `POST http://localhost:8080/greeting` con nuestro cliente Postman que los cambios se realizaron.