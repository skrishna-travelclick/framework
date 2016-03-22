@login @all @US200
Feature: Logging into the SF website
  As a SF user
  I want to be able to log in to the SF website
  So that i can access the opportunities section of the site

@login-success @qa @smoke @regression
Scenario: valid credentials
  Given I am on the SF login page
  When I sign in with the email 'skrishna@travelclick.com' and password '123Password'  

@login-failure @US201 @qa @regression
Scenario: Unregistered user
  Given I am on the SF login page
  When I sign in with the email ' ' and password ' '
  Then I should se the message 'Sorry we could not log you in. Please try entering your account details again."

@login-failure @US202 @qa
Scenario: Incorrect password
  Given I am on the SF login page
  When I sign in with the email ' ' and password ' '
  Then I should see the message 'Please enter your password'  

@login-failure @US202 @qa
Scenario: Empty e-mail
  Given I am on the SF login page
  When I sign in with the email ' ' and password 'not_my_password'
  Then I should see the message 'Please ensure you have entered the correct email address'

@login-failure @US203 @qa
Scenario:Invalid e-mail format
  Given I am on the SF login page
  When I enter the email address 'nomail format'
  Then I should see the message 'Please use a valid email address in the format: same@site.domain'

@login-failure @US204 @qa 
Scenario: Forgotten password
  Given I am on the SF login page
  When I click the forgot my password function
  Then I should be prompted for my e-mail address
     
  