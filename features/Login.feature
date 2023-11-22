Feature: Login

Scenario: Successful Login with Valid Credentials
Given User Launch Chrome Browser
When User Opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then Page Title Should be "Dashboard/nopCommerce administration"
When User click on Logout Link

And close browser
