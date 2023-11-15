FROM airhacks/glassfish
COPY ./target/dependency/mysql-connector-j-8.0.31.jar ${DEPLOYMENT_DIR}/../lib/ext
COPY ./target/todo-app.war ${DEPLOYMENT_DIR}
