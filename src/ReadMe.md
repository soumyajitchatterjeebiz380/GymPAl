# GymPal APIs Powered Through SpringBoot

## About
 This API is a RESTful API whose purpose is to solve the challenges of connecting fitness enthusiasts with like-minded workout partners. In the coming years, this API will be integrated with a GymPal web application.

## Features

### 1. Spring Security Integration

- **Secure Authentication and Authorization**: Utilize Spring Security 6 to implement secured authentication and authorization mechanisms, ensuring that only authorized users can access the application's resources. For this application there exists two types of users mean't for this API - general user and admin. Please look under the folder called `security-config` for more details.

### 2. JPA Repository for Data Management

- **Efficient Data Management**: Leverage JPA (Java Persistence API) to interact with our database, simplifying data storage, retrieval, and manipulation.
- **Object-Relational Mapping (ORM)**: Seamlessly map Java objects to database tables, abstracting away the complexities of SQL queries. Although for upcoming updates to this repository, SQL Queries may be needed for more complex actions.

### 3. Prometheus Monitoring

- **Monitoring and Metrics**: Integrate Prometheus to collect detailed performance metrics and monitoring data from our application.
- **Customizable Dashboards**: Visualize Prometheus metrics using a tool called Grafana to create insightful dashboards that provide real-time insights into our application's health and performance.


## Getting Started
To set up and run the application locally, follow these steps:

1. Clone the repository to your computer.
2. Navigate to the project directory. 
3. Configure your mysql database connection in the application.properties file. There is already sample code to help you with this task. If you are not using docker containers replace `mysql_container` with `localhost`.
5. Use the mysql file to create the necessary tables.
6. Build the project. You can do this by typing `mvn package`. 
7. Run the application using  `mvn springboot:run`.

To add Prometheus and Grafana integration, please download them through using Docker or through their websites. Then apply the necessary configuration under `/target/prometheus/prometheus-config.yaml`.

If you have docker installed, you can simply run this api using the following commands assuming these ports aren't being used by any other application in your computer.

To run mysql container:
`docker run --name mysql_container  --network application_network -p 3306:3306 -d mysql_testdb_image`

To run springboot application in a container:
`docker run --name my-springboot-app  --network application_network -p 8082:8082 -d gympal:latest`

To run Prometheus:
`docker run -d --network application_network -p 9090:9090 -v ./target/prometheus/promethus-config.yaml:/etc/prometheus/prometheus.yml prom/prometheus`

To run Grafana:
`docker run -d --name grafana-container -p 3000:3000 grafana/grafana`


### Warnings
Please make sure you have the images built. In our docker commands listed above, the images **gympal:latest**, **mysql_testdb_image** should be built beforehand.

## Disclaimer

### Improvements On The Way
- **OAuth Integration**: The current method of security is not for the modern world. Thus real world security integration is needed and OAuth is a great provider.

- **Logging** : In order to debug and trace any problems with an application, logging is also essential. Currently developing integration with log4j2.


## Contributing

Contributions to this project are welcome! If you find any issues or want to add new features, feel free to submit pull requests.


## Ownership

  Name: Soumyajit Chatterjee
  
  linkedin profile: https://www.linkedin.com/in/soumyajit-chatterjee-b46758181/






