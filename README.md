<h1>airlines</h1>
My second project in Java/Spring Boot, which responds to my curiosity about creating flight search engine. App's Homepage includes news section, weather widget, real-time flights table and search engine by flights number, departure, arrival, date, airlines. What is more, web-application shows flights details with pointing the current position of the planes on Google Map by its latitude and longitude using JavaScript (if available on api, default: Java island). Additionally, users can convert money from PLN to USD,GBP, EURO.


<h3>Installation</h3>
airlines is written with Spring Boot. To run:

compile it with maven and execute jar file
add your username and password for database in application.properties<br>
add api_key generated at https://aviationstack.com/ in AviationstackService class


<h3>Technologies</h3>
Java<br>
Spring Boot<br>
Polsat News rss<br>
NBP api<br>
Aviationstack api<br>
Spring DataJpa SpringSecurity<br>
JSP views<br>
Hibernate<br>
MySql<br>
HTML JavaScript CSS<br>

<h3>Usage</h3>
Register and Sign in. Get a view of news from rss with links to article, flight search engine by flights number, departure, arrival, date, airlines , flights list paginated with links to details of flight (all data from Aviationstack api) and booking a ticket(in progress). Sidebar menu gives access to users settings : personals update, list of flight tickets and currency converter with the current exchange rate from NBP api. I'm still developing application, that is why there will appear api endpoints. 



<h3>Views</h3>
Access: logged<br>
![Screenshot from 2022-01-05 11-44-30](https://user-images.githubusercontent.com/90089220/148206503-bad7d56c-f4d0-4e3c-8d9d-f1ffb56c7e2c.png)<br>
<small>After login, users can read news, convert money...</small><br>
![Screenshot from 2022-01-05 11-45-13](https://user-images.githubusercontent.com/90089220/148207552-8f0fd8f4-6c3c-4801-a41f-7b3f1ec31342.png)<br>
<small>search for flights, read flights list...</small><br>
![Screenshot from 2022-01-05 11-45-25](https://user-images.githubusercontent.com/90089220/148207669-20a07f59-f559-48f8-a1ac-246828d7bd8d.png)<br>
<small>read flight details and geoposition on map...</small><br>
![Screenshot from 2022-01-05 11-51-34](https://user-images.githubusercontent.com/90089220/148207846-f04701f3-90ba-4317-80ee-4b8095d8f2a4.png)<br>
<small>update personals</small><br><br>



<details>  
<summary><h3>Api endpoints (soon)<h3></summary>  
<p>Flight<br>
<strong>Method</strong>			<strong>URL</strong>			        <strong>Action(JSON)</strong><br><br>
GET        /api/			      Find All<br>
GET        /api/			      Find by id<br>
POST       /api/			      Create<br>
PUT        /api/			      Update with id<br>
DELETE     /api/			      Delete by id</p><br>
</details> 
<br><br>
<small>Please add suggestions or contact me if you like my project</small>
