# Use a lightweight base image for Java application runtime
FROM openjdk:17-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/simleasingback.jar ./app.jar


# Expose the port your application runs on (if needed)
EXPOSE 8080

	
# Command to run the application when the container starts
CMD ["java", "-jar", "app.jar"]