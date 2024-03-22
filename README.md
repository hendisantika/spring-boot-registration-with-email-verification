# spring-boot-registration-with-email-verification

### Things todo list:

1. Clone this
   repository: `git clone https://github.com/hendisantika/spring-boot-registration-with-email-verification.git`
2. Navigate to the folder: `cd spring-boot-registration-with-email-verification`
3. Run the application: `mvn clean spring-boot:run`
4. Open your REST API Client:
5. Run the command:
    ```shell
    POST /users/register HTTP/1.1
    Host: localhost:8085
    User-Agent: Apidog/1.0.0 (https://apidog.com)
    Content-Type: application/json
    Content-Length: 89
    
    {
      "userName": "yuji",
      "userEmail": "yuji@mailnesia.com",
      "userPassword": "123456"
    }
    ```

6. Open your Inbox then verify
