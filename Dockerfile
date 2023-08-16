# Fetching latest version of Java
FROM openjdk:17
 
# Setting up work directory
WORKDIR /app

# Copy the jar file into our app
COPY ./target/gymPAL-0.0.1-SNAPSHOT.jar /app

# Exposing port 8080
EXPOSE 8082

# Starting the application
CMD ["java", "-jar", "gymPAL-0.0.1-SNAPSHOT.jar"]