#ДЗ_2 
#
#Training Diary. Домашнее задание JDBC и Миграции

Необходимо обновить сервис, который вы разработали в первом задании согласно следующим требованиям и ограничениям

Требования: 

- Репозитории теперь должны писать ВСЕ сущности в БД PostgreSQL

- Идентификаторы при сохранении в БД должны выдаваться через sequence

- DDL-скрипты на создание таблиц и скрипты на предзаполнение таблиц должны выполняться только инструментом миграции Liquibase

- Скрипты миграции Luiqbase должны быть написаны в нотации XML или YAML

- Скриптов миграции должно быть несколько. Как минимум один на создание всех таблиц, другой - на предзаполнение данными

- Служебные таблицы должны быть в отдельной схеме

- Таблицы сущностей хранить в схеме public запрещено

- В тестах необходимо использовать test-containers

- В приложении должен быть docker-compose.yml, в котором должны быть прописаны инструкции для развертывания postgre в докере. Логин, пароль и база должны быть отличными от тех, что прописаны в образе по-умолчанию. Приложение должно работать с БД, развернутой в докере с указанными параметрами.

- Приложение должно поддерживать конфиг-файлы. Всё, что относится к подключению БД, а также к миграциям, должно быть сконфигурировано через конфиг-файл.
#
#
#
