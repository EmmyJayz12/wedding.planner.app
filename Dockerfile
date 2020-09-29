From openjdk:8
Expose 8080:8080
Add /target/wedding.planner.app-0.0.1-SNAPSHOT.jar wedding.planner.app-0.0.1-SNAPSHOT.jar
Entrypoint ["java", "-jar" "wedding.planner.app-0.0.1-SNAPSHOT.jar"]