# premiumBackend
En este repositorio se está creando el sistema de información premium por el lado del backend, el cual se encarga de gestionar las prácticas empresariales en el programa de ingeniería en sistemas de la Universidad Mariana, aunque con un enfoque de escalabilidad para posteriormente aplicar los conocimientos adquiridos con este proyecto en los demás programas de demás facultades de la universidad.
1.	Para poder probar/desarrollar este proyecto debemos tener instalado el sistema gestor de base de datos PostgreSQL funcionando con la versión 13 pero podría variar en ediciones posteriores.
1.1.	Crearemos una base de datos llamada premiumBackend.
1.2.	Debemos tener en cuenta la contraseña y el/los usuarios que pueden utilizar esta base de datos.
2.	
2.1.	Luego de ello tendremos que editar el archivo application.properties, cambiamos la línea 1 y 2 del archivo dónde están los parámetros de logueo para la base de datos.
2.2.	La línea donde se encuentre spring.jpa.hibernate.ddl-auto= agregamos la palabra reservada create-drop.
3.	Tener en cuenta que estamos utilizando la versión de Java 11 y es la versión open source.
4.	El IDE de desarrollo no es relevante.
