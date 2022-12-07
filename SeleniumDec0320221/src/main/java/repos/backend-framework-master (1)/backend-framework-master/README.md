#  API Automation Test framework
API Automation Test is RestAssured framework to perform API testing.

## Tech Used
RestAssured, Java, testNg, gradle, logback etc. 

## Prerequisite
Maven or Gradle build tools should be installed and configured,
Java v1.8 should be installed and configured,

## Getting Started
```
1. git clone git@github.com:saurabh1mishra/backend-framework.git
2. Navigate to backend-framework
```

**In terminal from root project folder (backend-framework), run below commands as required**

Run Tests
- To run all features `./gradlew :runTest`
- To pass environment variable from command line `./gradlew :runTest -Dtag=SMOKE -DENV=enviornment`
  
  
Report Path  
- gradle Report: `{ROOT_PROJECT_FOLDER}/reports/gradleReport`
- tesnNG Report: `{ROOT_PROJECT_FOLDER}/reports/testNGReport`
- log: `{ROOT_PROJECT_FOLDER}/log`

### FRAMEWORK SHOULD CONTAIN TESTS AS MENTIONED BELOW:
````
Base URL: https://petstore.swagger.io/

Content type: application/json

Part I

1. Create multiple users with array

Call type: POST

Endpoint: /user/createWithArray

Body: [

{

"id": 0,

"username": "string",

"firstName": "string",

"lastName": "string",

"email": "string",

"password": "string",

"phone": "string",

"userStatus": 0

}

]

2. Update a user's username and other details

Call type: PUT

Endpoint: /user/{username}

Body: {

"id": 0,

"username": "string",

"firstName": "string",

"lastName": "string",

"email": "string",

"password": "string",

"phone": "string",

"userStatus": 0

}

3. Get user by the updated username

Call type: GET

Endpoint: /user/{username}

Part II

1. Create multiple pets

Call type: POST

Endpoint: /pet

Body: {

"id": 0,

"category": {

"id": 0,

"name": "string"

},

"name": "doggie",

"photoUrls": [

"string"

],

"tags": [

{

"id": 0,

"name": "string"

}

],

"status": "available"

}

2. Update pet's status and other details (Statuses to be considered: available, pending and sold)

Call type: PUT

Endpoint: /pet

Body: {

"id": 0,

"category": {

"id": 0,

"name": "string"

},

"name": "doggie",

"photoUrls": [

"string"

],

"tags": [

{

"id": 0,

"name": "string"

}

],

"status": "available"

}

3. Get pet by status and verify updated status of pet

Call type: GET

Endpoint: /pet/findByStatus?status=available (Statuses to be considered: available, pending and sold)
````

