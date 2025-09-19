# Spring Boot + Redis (Docker Compose)

Этот проект демонстрирует запуск Spring Boot приложения вместе с Redis в Docker с помощью `docker-compose`.

## 📦 Требования

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## ⚙️ Сборка приложения

Перед запуском необходимо собрать `.war` (или `.jar`, если у тебя self-executable) файл приложения:

bash
```
./mvnw clean package -DskipTests
```

После сборки файл окажется в папке target/.
🚀 Запуск через Docker Compose
В корне проекта есть docker-compose.yml. Чтобы запустить приложение и Redis, выполни:

```
docker-compose up --build
```

После запуска будут подняты 2 контейнера:
app — Spring Boot приложение (порт 8080)
redis — Redis база (порт 6379, доступен только внутри сети Docker)
🌐 Доступ к приложению
Приложение будет доступно по адресу:

```http://localhost:8080```

Redis доступен для приложения внутри сети Docker по адресу:

```redis:6379
```

🛑 Остановка контейнеров
Чтобы остановить и удалить контейнеры:
```docker-compose down
```

Если хочешь удалить также тома с данными Redis:
```docker-compose down -v
```

🔧 Полезные команды
Посмотреть логи приложения:
```docker-compose logs app
```
Посмотреть логи Redis:
```docker-compose logs redis
```
Зайти внутрь контейнера Redis:
```docker exec -it redis redis-cli
```
