Feature: Automated E2E Tests
  The purpose of this feature is to test E2E integration

  
  Scenario Outline: Customer places an order by purchasing an item from search
    Given user is registered and loggedin "<firstname>" , "<lastname>" , "<email>", "<password>"
    When he searches for "<productname>"
    And chooses to buy 1 item
    And moves to checkout cart and enter personal details on chekout page and place the order "<countryname>" , "<cityname>" , "<adress1Txt>" , "<zipCodeTxt>" , "<phoneNumberTxt>" 
    Then he can view the order and download the invoice

    Examples: 
    
     | firstname | lastname | email | password | productname | countryname | cityname | adress1Txt | zipCodeTxt | phoneNumberTxt |
     
     | Mayar | Fakhr Eldin | testt1111111111111@gmail.com | 12345678 | Apple MacBook Pro 13-inch | Egypt | Cairo | 5 Tahrir Square | 1234 | 01067301204 |
      
