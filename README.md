MongoDB es una de las bases de datos no relacionales más utilizadas. Es flexible y bastante fácil de empezar a trabajar con ella. De esta manera, este reto servirá para introducirnos en el mundo de las bases de datos no relacionales. El modelo de usuario con el que se trabajará es el siguiente:
```
 user  
 {  
   username: {unique, required}  
   age:{number}  
   city:{string}  
 } 
```

✅ El servidor se conecta a MongoDB (local)

Creará una BD llamada "nuweMongoDB"

✅ Hay un controlador para crear el usuario

POST localhost:8080/users

Body:
{
    "userName":"Cobi",
    "age":30,
    "city":"Barcelona"   
}

✅ Hay un controlador para borrar el usuario

DELETE localhost:8080/users/{id}

✅ Hay un controlador para devolver el usuario

GET localhost:8080/users/{id}

✅ Hay un controlador para actualizar el usuario

PUT localhost:8080/users/{id}

Body:
{
    "userName":"Petra",
    "age":29,
    "city":"Barcelona"   
}
