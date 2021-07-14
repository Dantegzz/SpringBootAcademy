**Save User**

curl --location --request POST 'localhost:8081/app/users' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "dante",
    "email": "dann97@mail.com",
    "birthDate": "1997-12-19"
}'

**Get user**

curl --location --request GET 'localhost:8081/app/users'

**Update User**

curl --location --request PUT 'localhost:8081/app/users/3' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Dante",
    "email": "dann97@mail.com",
    "birthDate": "1997-12-19"
}'

**Delete user**

curl --location --request DELETE 'localhost:8081/app/users/4' \
--data-raw ''