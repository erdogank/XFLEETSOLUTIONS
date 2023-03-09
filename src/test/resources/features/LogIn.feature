Feature: All users should be able to log in

  Background:
    Given The user is on the log in page

  Scenario Outline: All users can log in with valid credentials
    When user enters his or her "<userName>" and "<passWord>"
    And clicks the LogIn button
    Then she or he should lands on the "<homePage>"

    Examples:
      | userName        | passWord    | homePage        |
      | user1           | UserUser123 | Quick Launchpad |
      | user2           | UserUser123 | Quick Launchpad |
      | user3           | UserUser123 | Quick Launchpad |
      | storemanager51  | UserUser123 | Dashboard       |
      | storemanager52  | UserUser123 | Dashboard       |
      | storemanager53  | UserUser123 | Dashboard       |
      | salesmanager101 | UserUser123 | Dashboard       |
      | salesmanager102 | UserUser123 | Dashboard       |
      | salesmanager103 | UserUser123 | Dashboard       |

  @smoke
  Scenario Outline: "Invalid username or password." should be displayed for invalid (valid username-invalid password and invalid username-valid password) credentials
    When user enters his or her "<userName>" and "<passWord>"
    And clicks the LogIn button
    Then she or he gets "<expectedMessage>" message

    Examples:
      | userName        | passWord    | expectedMessage                |
      | user1           | useruser123 | Invalid user name or password. |
      | aser1           | UserUser123 | Invalid user name or password. |
      | 123456          | useruser123 | Invalid user name or password. |
      | ??&%            | useruser123 | Invalid user name or password. |
      | storemanager51  | useruser123 | Invalid user name or password. |
      | salesmanager101 | useruser123 | Invalid user name or password. |
      | user1           | 123456      | Invalid user name or password. |
      | storemanager51  | 123%&?      | Invalid user name or password. |
      | salesmanager102 | ?_%&+/      | Invalid user name or password. |


  Scenario Outline: "Please fill out this field" message should be displayed from username field if the username or both username and password field are empty
    When user enters his or her "<userName>" and "<passWord>"
    And clicks the LogIn button
    Then she or he gets "<errorMessage>" message from Username field

    Examples:
      | userName | passWord    | errorMessage             |
      |          | UserUser123 | Please fill out this field. |
      |          |             | Please fill out this field. |


    Scenario: "Please fill out this field" message should be displayed from password field when this field is empty
      When user enters his or her username like "user1"
      And clicks the LogIn button
      Then she or he get "Please fill out this field." message from Password field


    Scenario: User land on the ‘Forgot Password’ page after clicking on the "Forgot your password?" link
        When user clicks on the Forgot your password? link
        Then she or he lands on "Forgot Password" page

      @smoke
      Scenario: User can see "Remember Me" link exists and is clickable on the login page,
        Then user should see and click on Remember me link


      @smoke
      Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
          When user types his or her "user1" and "UserUser123"
          And user press enter key
          Then user should land on "Quick Launchpad" dashboard.


      Scenario Outline: All users can see their own usernames in the profile menu, after successful login
          When user enters his or her "<userName>" and "<passWord>"
          And clicks the LogIn button
          Then user should see his or her "<userName>" in the profile menu
          Examples:

            | userName        | passWord    |
            | user1           | UserUser123 |
            | user2           | UserUser123 |
            | user3           | UserUser123 |
            | storemanager51  | UserUser123 |
            | storemanager52  | UserUser123 |
            | storemanager53  | UserUser123 |
            | salesmanager101 | UserUser123 |
            | salesmanager102 | UserUser123 |
            | salesmanager103 | UserUser123 |

















