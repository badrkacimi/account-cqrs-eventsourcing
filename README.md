# cqrs - event sourcing simple project

# Technical stack :
* Docker for containerize the application
* Mapstruct for java bean mappings at compile-time.
* MySQL as a database.
* JaCoCo for test coverage report.
* Axon for event-sourced Java application

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
