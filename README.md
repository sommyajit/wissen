RUN THE BELOW POSTMAN QUERIES:

curl --location --request GET 'http://localhost:8080/api/calendar/2025' \
--header 'Content-Type: application/json' \
--data '{
  "username": "admin",
  "password": "password"
}
'


curl --location 'http://localhost:8080/api/events' \
--header 'Content-Type: application/json' \
--data '{
  "title": "Team Meeting",
  "description": "Monthly sync-up",
  "dateTime": "2025-01-02T10:00:00"
}
'


curl --location 'http://localhost:8080/api/holidays' \
--header 'Content-Type: application/json' \
--data '{
  "name": "Break day",
  "date": "2025-02-01"
}'


curl --location 'http://localhost:8080/api/holidays/next'

curl --location 'http://localhost:8080/api/events'

curl --location 'http://localhost:8080/api/holidays'







