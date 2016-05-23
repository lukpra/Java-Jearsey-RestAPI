# Simple APP for task management
## a table that does not require page refreshes with ability to add, modify, and update
## A simple demonstatrion of RESTfull API in Java with Jearsey framework.

This simple application was made for learning purposes. API is consumed by simple, one page, html website that builds a table that does not require refreshing for working properly. Implementet features are: Get, Add, Set, Post and Delete ( del is not implemented for client ).

DB used for it is rather naive 'memory db' based on list. 

##### Frameworks and libs:
###### Server:
1. Maven
2. Jetty Server
3. Jearsey framework 

###### Client:
1. jQuery
2. DataTables
3. Some Bootstrap for more modern look.

In order to run it, add to Maven run parameters ``` jetty:run ````.
