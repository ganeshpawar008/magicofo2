Feature: featching user deatails
Scenario: testing the get call for user Detail

Given url 'https://reqres.in/api/users/2'
When method GET
Then status 200 