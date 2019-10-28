# Compilar los proyectos Java

Al descargar el proyecto será necesario compilar el proyecto SecretManagerApp y SpringConfigServer
Se compilan entrando a la carpeta principal del proyecto y lanzando el siguiente comando en una consola:
```gradle clean build```

-----------------
# Crear la Base de datos
Antes de ejecutar todos los servicios, es necesario configurar la BD, por lo tanto realizaremos las siguientes acciones:
```docker-compose up --build adminer```

Esperamos por lo menos 5 minutos que la base de datos mysql se termine de configurar correctamente.
Cuando esto ocurra ingresamos al adminer para administrar nuestra base de datos de la siguiente forma:

* url: http://localhost:8081/
* Motor de base de datos: MySQL
* Servidor: db
* Usuario: root
* Contraseña: example
* Base de datos: mysql

Aquí ingresamos al adminer si todo está OK, si sale algun error espera unos minutos más (hasta maximo 10) que podría ser porque la base de datos no ha terminado de subir.

En la parte superior izquierda encontraremos la opción *Comando SQL*, lo abrimos y copiamos y pegamos los comandos que encontrarás en el archivo *mysql/sources.sql*

Esperamos que todo se ejecute correctamente y entramos a ver que exista una nueva base de datos llamada *secrets*, una tabla dentro de esta BD llamda *PROPERTIES* y que esta tabla tenga un registro de ejemplo insertado.

----------------
# Ejecutar todo el proyecto

Para ejecutar el proyecto se requiere docker y docker-compose
```docker-compose up```

Detener los contenedores:
```docker-compose stop```