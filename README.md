# backend-upgrade-assessment

### Need to create a database named 'upgradeassessment' on MySQL

### If necessary change database port '3306' to your MySQL port

Route to change 'src/main/resources/aplication.properties'

### If necessary change password 'dev_carlos123' to your MySQL password

Route to change 'src/main/resources/aplication.properties'

### In case running port '8081' is not avalible change to any other port

Route to change 'src/main/resources/aplication.properties'

# No need to create tables and columns, aplications creates automatically

### You can use an aplication for 'HTTP Request', such as, Postman, Thunder Client, Insomnia, Advanced, etc.

## GET

http://localhost:8081/profiles
http://localhost:8081/users

http://localhost:8081/profiles/1
http://localhost:8081/users/1

## POST: Use Body => Raw => JSON

http://localhost:8081/profiles
{
"profile": "profile 1"
}

http://localhost:8081/users
{
"userName": "username 1",
"password": "password123",
"idProfile": {
"idProfile": 1
},
"idEmployee": 1,
"status": "status 1",
"createDate": "2022-02-08T06:00:00.000+00:00",
"updateDate": "2022-02-08T06:00:00.000+00:00",
"login": "login 1"
}

## PUT: Use Body => Raw => JSON

http://localhost:8081/profiles/1
{
"profile": "profile 2"
}

http://localhost:8081/users/1
{
"userName": "username 2",
"password": "password123",
"idProfile": {
"idProfile": 2
},
"idEmployee": 2,
"status": "status 2",
"createDate": "2022-02-08T06:00:00.000+00:00",
"updateDate": "2022-02-08T06:00:00.000+00:00",
"login": "login 2"
}

## DELETE

http://localhost:8081/profiles/1
http://localhost:8081/users/1
