FROM mysql

# Environment variables
ENV MYSQL_ROOT_PASSWORD root

# Create Database
RUN	mkdir /usr/sql
RUN	chmod 644 /usr/sql

ADD ["sources.sql", "/usr/sql/sources.sql"]

RUN whereis mysql
RUN /etc/init.d/mysql start
RUN sleep 5
RUN mysql -u root -p${MYSQL_ROOT_PASSWORD} -e "CREATE DATABASE lba"
RUN mysql -u root -p${MYSQL_ROOT_PASSWORD} -D lba < /usr/sql/sources.sql

#PORT
EXPOSE 3306