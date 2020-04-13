Run JsonComparatorApplication to start the project
Project will run on the port: 8086
Hit following swagger url after server start up: http://localhost:8086/swagger-ui.html#/
All end points are protected with Jwt token
Steps to generate token:
First register yourself
1. On swagger -> user-controller -> execute sign-up endpoint -> provide dummy text at Authorization -> provide payload keep id = 0

2. Use same userName and password to login to generate token

Log in:
1. On swagger -> auth-api-controller -> hit login endpoint -> provide Authorization any dummy text -> Provide username and password

2. After executing this api Token will get generate in Response header

3. Copy token e.g. authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huIiwiZXhwIjoxNTg3NDc1NDA5fQ.HRtxvCS8kX6WZAUhpatSG3BXrk1J99KH6sbR--NInVp5sh2rfAXhFr6WTdaZL_yVXliPS3DqwuAAzN5eLjUoeg

Copy from Bearer and use this token for every other endpoints

Up to this you have succesfully logged in the application
now to save base Json in DB, follow the steps:
1. Prvide Access token in Authorization section in swagger
2. On Swagger -> execute Post endpoint -> insert following base json, I have added escape characters in base json as well as made it in single line like:
I have provided it in base.txt file in the same project's resources folder
3. Base json will get successfully saved in db.
4. CRUD endpoints are available, you can see it in the Swagger's base-json controller

Compare JSON:
I have added input json file in the resources folder of the project, the contents are added escape characters and made in single line.
You can find all saved Base json by hitting get endpoint on swagger
1. provide Access Token
2. provide base json's id with whom we need to compare new json
3. provide new input json sample is added in resources folder
4. Execute the endpoint. you will get the desired result