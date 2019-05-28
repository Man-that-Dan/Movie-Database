# Movie-Database
Java Spring Boot Rest API using jdbc mysql driver and clear db mysql database to store data on movies

Movie records have three fields: id, title, and director
Records are returned in JSON format

Backend currently deployed at https://krw-technical-test.herokuapp.com/movies

Endpoints:
GET: https://krw-technical-test.herokuapp.com/movies Retrieves all resources
GET: https://krw-technical-test.herokuapp.com/movies/{id} Retrieves a resource
POST: https://krw-technical-test.herokuapp.com/movies Creates a resource. Request body must contain JSON with title and director attributes
PUT: https://krw-technical-test.herokuapp.com/movies/{id} Updates or creates within an existing resource.  Request body must contain JSON with title and director attributes
DELETE: https://krw-technical-test.herokuapp.com/movies/{id} Removes the resource
