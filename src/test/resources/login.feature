Feature: Login to HRM website
  Scenario Outline: Verified users can login to portal with valid credentials
    Given User visits HRM website
    When User enters invalid "<username>" and "<password>"
    Then User can't log in
    Examples:
      | username | password |
      | user1 | 1234 |
      | user2 | 2345 |
      | user3 | 4578 |
