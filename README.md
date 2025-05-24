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


![image](https://github.com/user-attachments/assets/baddf200-68ca-491e-9046-f1b593816100)
![image](https://github.com/user-attachments/assets/2579f36d-f061-4581-b3a7-7435f8fb7e19)
![image](https://github.com/user-attachments/assets/04666173-ae14-4243-b1b7-edb0b1ed6ed0)
![image](https://github.com/user-attachments/assets/a334d03d-f62b-45c4-bd39-38b6e0175a78)
![image](https://github.com/user-attachments/assets/2a2b5891-a01b-4876-a8d1-d7ef6a2acec2)
![image](https://github.com/user-attachments/assets/15e3fa30-3026-444d-9501-ed9dce6fb9f4)
![image](https://github.com/user-attachments/assets/141d1209-e783-42ed-bb95-95486e78d879)
![image](https://github.com/user-attachments/assets/47c4935f-608b-465d-b5d8-3fd09cc1a046)












