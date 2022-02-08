FROM mysql:8.0.25
ENV MYSQL_DATABASE=userdetails \
    MYSQL_ROOT_PASSWORD=password
COPY ./userdetails.sql /docker-entrypoint-initdb.d
EXPOSE 3306