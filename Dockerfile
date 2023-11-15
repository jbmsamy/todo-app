FROM airhacks/glassfish
COPY ./target/dependency/mysql-connector-java-5.1.49.jar ${DEPLOYMENT_DIR}/../lib/ext
COPY ./target/todo-app.war ${DEPLOYMENT_DIR}
