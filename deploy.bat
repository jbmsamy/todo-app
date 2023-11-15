mvn package
docker build -t training/todo-app:1.0 .
docker run -d --name todo_service -p 8080:8080 training/todo-app:1.0
