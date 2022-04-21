Email Marketing sample Application

Application uses following stack

Spring boot
Spring Resttemplate
Spring JPA data
Freemarker template
Flyway
H2

Use following command to create Database instance
mvn flyway:migrate

Api end points are :

/*
 ** End point to send a request for sending emails
 */
 
Post: localhost:8080/initiateEmail

Payload
{
  "segment_id": 2,
  "template_id": 1,
  "sender": "User1"
}

/*
 ** Sample end point to demonstrate triggering an email release in lieu of messaging implementation
*/

Post: localhost:8080/triggerEmail
