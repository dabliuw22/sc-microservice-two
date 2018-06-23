# Microservice Two

Microservicio que obtiene el refresh de sus propiedades con RabbitMQ (AMQP).

1. Pre-Requisitos:
	* Java >= 1.8.x
	* Spring Boot 2.0.3.RELEASE
	* Spring Cloud Finchley.RC2
	* RabbitMQ

2. Dependencias:
	* Actuator.
	* Cloud Config: Config Client.
	* Cloud Discovery: Eureka Discovery. 
	* Spring Bus AMQP.
	* Spring Web.

```
	dependencies {
		compile('org.springframework.boot:spring-boot-starter-actuator')
		compile('org.springframework.cloud:spring-cloud-starter-bus-amqp')
		compile('org.springframework.boot:spring-boot-starter-web')
		compile('org.springframework.cloud:spring-cloud-starter-config')
		compile('org.springframework.cloud:spring-cloud-starter-netflix-eureka-client')
		//compile('org.springframework.cloud:spring-cloud-starter-sleuth')
		//compile('org.springframework.cloud:spring-cloud-starter-zipkin')
		testCompile('org.springframework.boot:spring-boot-starter-test')
	}
```

3. Anotar con *@EnableDiscoveryClient* a la clase de configuración.

4. Anotar bean o componente con *@RefreshScope* donde queremos que las propiedades se actualicen:
 
5.  Cambiar *application.properties* a *bootstrap.yml* y agregar:
 
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
 
 6. Para utilizar el refresh mediante colas de mensajes con RabitMQ debemos crear un WebHook con nuestro remoto, esto presenta dificultades cuando trabajamos con localhost. 
Primero verificaremos el estado actual de la propiedad consumiendo en *POST http://localhost:8080/greeting*, luego realizaremos un cambio en la propiedad *${properties.example}* en *microservice-one.yml* y subiremos los cambios al remoto, luego simularemos un petición de un WebHook de la siguiente forma:
 
 ```
 curl -H "X-Github-Event: push" -H "Content-Type: application/json" -X POST -d '{"commits": [{"modified": ["microservice-two.yml"]}]}' http://localhost:8888/monitor
 ```
Más tarde podremos verificar *POST http://localhost:8080/greeting* con nuestro cliente Postman que los cambios se realizaron.