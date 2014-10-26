# A Simple LinkedIn Connections Rank Service 

This is a ranking implementation for LinkedIn connections. I have used scribe-java api for Oauth. (See https://github.com/fernandezpablo85/scribe-java).

The service will connect to your LinkedIn profile, get all your connections and sort them based on industry and location.

##Issues
There is a known issue with the JUnits, the JUnits have console input. They ask user to enter the verification code and this works fine if the JUnit runs in eclipse. Doesn't work when mvn test is executed from command line.