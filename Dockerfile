# Start with a base image containing Java runtime (adoptopenjdk is open source and good for production)
FROM adoptopenjdk:11-jre-hotspot as builder

# The application's jar file
ARG JAR_FILE=build/libs/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Unpack the jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# Use a smaller base image to run the application
FROM adoptopenjdk:11-jre-hotspot

# Copy unpacked application to the new container
COPY --from=builder target/dependency/BOOT-INF/lib /app/lib
COPY --from=builder target/dependency/META-INF /app/META-INF
COPY --from=builder target/dependency/BOOT-INF/classes /app

# Run the application
ENTRYPOINT ["java","-cp","app:app/lib/*","com.educatif.api.analog_twitter.ApiAnalogTwitterApplication"]
