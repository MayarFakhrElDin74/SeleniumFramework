Feature: User Registration
  I want to check that the user can register in our e-commerce website

  Scenario Outline: User Registration
   Given the user is on the home page
   When he clicks on register link
   And enters his data "<firstname>" , "<lastname>" , "<email>", "<password>"
   Then the registration page is displayed successfully
   
   Examples:
   
   | firstname | lastname | email | password |
   | Mayar | Fakhr Eldin | testt1@gmail.com | 123456 |
   | Esraa | AbdelWahab | testt2@gmail.com | 11335577 |
   