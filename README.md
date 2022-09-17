# cqrs - event sourcing simple project

# Technical stack :
* Axon for event-sourced Java application
* Mapstruct for java bean mappings at compile-time.
* Lombok  for code generation and minimizing boilerplate
* Docker for containerize the application
* MySQL as a database.
* JaCoCo for test coverage report.

# Build project
To build the project, run the maven command
```
mvn clean install
```

# Run the project
```
docker-compose up --build
```

# Visualize and interact with the API's resources :

URL : http://localhost:9090/swagger-ui.html
