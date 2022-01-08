<h1>airlines</h1>
My second project in Java/Spring Boot, which responds to my curiosity about creating flight search engine. App's Homepage includes news section, weather widget, real-time flights table and search engine by flights number, departure, arrival, date, airlines. What is more, web-application shows flights details with pointing the current position of the planes on Google Map by its latitude and longitude using JavaScript (if available on api, default: Java island). Additionally, users can convert money from PLN to USD,GBP, EURO.


<h3>Installation</h3>
airlines is written with Spring Boot with front in bootstrap template. To run:

compile it with maven and execute jar file
add your username and password for database in application.properties<br>
add api_key generated at <a href="https://aviationstack.com/">aviationstack</a> in AviationstackService class<br>
add your gmail and password. Follow this <a href="https://support.google.com/accounts/answer/185833">link</a> to see the details and to generate your Google App Password.


<h3>Technologies</h3>
Java<br>
Spring Boot<br>
Polsat News rss<br>
NBP api<br>
Aviationstack api<br>
Spring DataJpa SpringSecurity<br>
Hibernate<br>
MySql<br>
views: JSP HTML JavaScript CSS<br>

<h3>Usage</h3>
Register and Sign in. Get confirmation link on email. Use option Remember-me to storage cookie and token in data base. If forgot password, app will send an email with it. Get a view of news from rss with links to article, flight search engine by flights number, departure, arrival, date, airlines , flights list paginated with links to details of flight (all data from Aviationstack api) and booking a ticket. Booking form requires uploading file (certificate), after processing user can see file properties, app sends to user a xml or text file. Sidebar menu gives access to users settings : personals update, list of flight tickets and currency converter with the current exchange rate from NBP api. I'm still developing this app, that is why there will appear more api endpoints and tickets logics.



<h3>Views</h3>
Access: all<br>
<img src="https://user-images.githubusercontent.com/90089220/148656226-20ea0a89-38b9-4af8-8a0e-135c1d033be5.png"/>
<small>Register</small><br>
<img src="https://user-images.githubusercontent.com/90089220/148656227-be86284b-5e5c-46f8-8847-d0ac3bfc7dc3.png"/>
<small>Sign in, check Remember-me or ask for email with password reminder</small>
<br>
<br>
Access: logged<br>
<img src="https://user-images.githubusercontent.com/90089220/148206503-bad7d56c-f4d0-4e3c-8d9d-f1ffb56c7e2c.png"/>
<small>After login, users can read news, convert money...</small><br>
<img src="https://user-images.githubusercontent.com/90089220/148207552-8f0fd8f4-6c3c-4801-a41f-7b3f1ec31342.png"/>
<small>search for flights, read flights list...</small><br>
<img src="https://user-images.githubusercontent.com/90089220/148207669-20a07f59-f559-48f8-a1ac-246828d7bd8d.png"/>
<small>read flight details and geoposition on map...</small><br>
<img src="https://user-images.githubusercontent.com/90089220/148207846-f04701f3-90ba-4317-80ee-4b8095d8f2a4.png"/>
<small>update personals</small><br>
<img src="https://user-images.githubusercontent.com/90089220/148656285-e2009659-0186-443d-b245-525b1132b8df.png"/>
<small>upload file(certificate)</small><br>
<img src="https://user-images.githubusercontent.com/90089220/148656289-f2fd70af-59cc-437d-a3bd-c5ceec956dd4.png"/>
<small>download ticket</small>
<br>
<br>
<h3>Api</h3>
<details>  
<summary>show</summary> 
<table style="width: 447px;">
<tbody>
<tr>
<td style="width: 72px;"><strong>OBJECT</strong></td>
<td style="width: 102.312px;"><strong>HTTP Method</strong></td>
<td style="width: 91.6875px;"><strong>URL</strong></td>
<td style="width: 175px;"><strong>ACTION</strong></td>
</tr>
<tr>
<td style="width: 72px;">Flight</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/api/flight</em></td>
<td style="width: 175px;">Read All (limited 100)</td>
</tr>
<tr>
<td style="width: 72px;">Flight</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/api/flight/{number}</em></td>
<td style="width: 175px;">Read by flight number with details</td>
</tr>
<tr>
<td style="width: 72px;">Rss news</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/api/rss</em></td>
<td style="width: 175px;">Read news (limited 50)</td>
</tr>
<tr>
<td style="width: 72px;">Ticket</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/api/user/{id}/ticket</em></td>
<td style="width: 175px;">Read All tickets</td>
</tr>
<tr>
<td style="width: 72px;">Ticket</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/api/ticket/{id}</em></td>
<td style="width: 175px;">Read ticket by id</td>
</tr>
<tr>
<td style="width: 72px;">Certificate</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/user/{id}/download</em></td>
<td style="width: 175px;">Download file</td>
</tr>
<tr>
<td style="width: 72px;">Certificate</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/user/{id}/show</em></td>
<td style="width: 175px;">Read user's certificate</td>
</tr>
<tr>
<td style="width: 72px;">User</td>
<td style="width: 102.312px;">GET</td>
<td style="width: 91.6875px;"><em>/api/user/{id}</em></td>
<td style="width: 175px;">Read user with details</td>
</tr>
<tr>
<td style="width: 72px;">User</td>
<td style="width: 102.312px;">POST</td>
<td style="width: 91.6875px;"><em>/api/user</em></td>
<td style="width: 175px;">Create user</td>
</tr>
<tr>
<td style="width: 72px;">User</td>
<td style="width: 102.312px;">PUT</td>
<td style="width: 91.6875px;"><em>/api/user/{id}</em></td>
<td style="width: 175px;">Update user personals</td>
</tr>
<tr>
<td style="width: 72px;">User</td>
<td style="width: 102.312px;">POST</td>
<td style="width: 91.6875px;"><em>/forgot</em></td>
<td style="width: 175px;">Sending email with password if exist in db</td>
</tr>
</tbody>
</table>
</details> 
<br>
<br>
<h5>Please add suggestions or contact me if you like my project ✌️ </h5>




