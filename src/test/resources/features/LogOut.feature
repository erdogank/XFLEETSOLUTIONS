@XFLEET10-639
Feature: All users should be able to log out

  Background:
    Given The user is on the log in page

@XFLEET10-635
  Scenario Outline: All users can log out by using log out button inside profile info and ends up in login page.
    When user enters his or her "<userName>" and "<passWord>"
    And clicks the LogIn button
    And she or he clicks on profile name
    And clicks on Logout
    Then he or she should land on Login page

    Examples:
      | userName        | passWord    |
      | user1           | UserUser123 |
      | storemanager51  | UserUser123 |
      | salesmanager101 | UserUser123 |

@XFLEET10-636
    Scenario Outline:  The user can not go to the home page again by clicking the step back button after successfully logging out.
      When user enters his or her "<userName>" and "<passWord>"
      And clicks the LogIn button
      And she or he clicks on profile name
      And clicks on Logout
      And he or she should land on Login page
      And he or she clicks back button
      Then he or she can not go homepage again

      Examples:
        | userName        | passWord    |
        | user1           | UserUser123 |
        | storemanager51  | UserUser123 |
        | salesmanager101 | UserUser123 |

  @XFLEET10-637
      Scenario Outline: The user must be logged out if the user closes the open tab (all tabs if there are multiple open tabs)
        When user enters his or her "<userName>" and "<passWord>"
        And clicks the LogIn button
        And he or she opens a new window
        And he or she closes the program window
        And he or she opens program in the second window
        Then he or she should not be on the homepage
        Examples:
          | userName        | passWord    |
          | user1           | UserUser123 |
          | storemanager51  | UserUser123 |
          | salesmanager101 | UserUser123 |


@XFLEET10-638
        Scenario: The user must be logged out if the user is away from the keyboard for 3 minutes (AFK)
        (if the user does not do any mouse or keyboard action for 3 minutes)
          When user enters his or her "user1" and "UserUser123"
          And clicks the LogIn button
          And he or she does not touch the keyboard and mouse for 3 minutes
          Then he or she must be logged out




