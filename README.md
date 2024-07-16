## Зависимости

**spring-boot-starter-data-jpa**

Добавляет поддержку Java Persistence API (JPA) для взаимодействия с базой данных.

**spring-boot-starter-web**

Добавляет поддержку для создания веб-приложений на базе Spring MVC.

**postgresql**

Представляет собой клиентскую библиотеку для взаимодействия с базой данных PostgreSQL.

**lombok**

Позволяет уменьшить количество шаблонного кода за счет использования аннотаций.

## Установка

1. #### Склонируйте репозиторий:
   ```sh
   git clone https://github.com/Lasky1010/blog-app.git

2. #### Настройте подключение к БД:

   В Environment Variables прописать DB_USERNAME, DB_PASSWORD и DB_URL

   Установить нужное значение ddl-auto
   [application.yml](src/main/resources/application.yml)

3. #### Установите зависимости и соберите проект:
    ```sh
   mvn clean install
4. #### Запустите приложение

## Postman

#### Импортируйте файл [Blog App](Blog App.postman_collection.json) в Postman для тестирования