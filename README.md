# A Simple LinkedIn Connections Rank Service 

This is a ranking implementation for LinkedIn connections. I have used scribe-java api for Oauth. (See https://github.com/fernandezpablo85/scribe-java).

The service will connect to your LinkedIn profile, get all your connections and sort them based on industry and location.

## Instructions
1. Open command prompt and call "mvn test".
2. You should get a note explaining that I use scribe that the service is stateless and a URL.
3. Copy that URL and go to a browser window. Enter a valid LinkedIn username and password.
4. You should get a 5 digit code. Copy that code and paste it in the console window next to the ">>".
5. You will see an xml response. Copy that xml into a text editor and examine your results!
6. There are 3 such tests. One gets the profile, another gets your connections and the third gets the connections sorted by connection rank.

## Folder Structure
```
├── README.md
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           ├── constants
    │           │   ├── KeyConstants.java (Has the keys for scribe's oauth test)
    │           │   └── URLConstants.java (LinkedIn api rest urls)
    │           ├── model                 (This folder models the linkedin api)
    │           │   ├── Connections.java
    │           │   ├── Country.java
    │           │   ├── Location.java
    │           │   ├── Person.java
    │           │   └── utils             (JAXB marshalling/unmarshalling)
    │           │       ├── ConnectionsParser.java
    │           │       └── PersonParser.java
    │           ├── request               (Each request knows it's URL and the service authentication scope required)
    │           │   └── linkedin
    │           │       ├── LinkedInConnectionsRequest.java
    │           │       ├── LinkedInProfileRequest.java
    │           │       └── LinkedInRequest.java  (Abstract super)
    │           └── service
    │               ├── linkedin        (The service will build a LinkedIn service and get the authentication token)
    │               │   ├── LinkedInService.java
    │               │   └── LinkedInServiceBuilder.java (The builder build a LinkedInService with multiple requests.
    │               │      I need a builder so that I can combine the scopes for multiple requests and so that I can
    │               │      make multiple requests with the same token)
    │               ├── ranking (The ranking service implemented here. It depends only on model, not on service)
    │               │   ├── ConnectionRankService.java
    │               │   ├── DefaultProximityComparator.java
    │               │   └── ProximityBasedConnectionRankImpl.java
    │               └── token (The default implementation for getting LinkedIn api auth tokens using a console)
    │                   ├── ConsoleTokenService.java
    │                   └── TokenService.java (Extensible way of getting token, the LinkedInService doesn't know how
    │                       it will get a token. It only has a reference to the tokenService interface. 
    │                       In the tests I tell it to take a new ConsoleTokenService(), ideally one
    │                       would use some web based mechanism and implement this interface)
    └── test
        └── java
            └── com
                └── test
                    ├── TestLinkedInConnectionsAPI.java (test that I can get all your connections)
                    ├── TestLinkedInProfileAPI.java   (test that I can get your profile)
                    └── TestMyRanking.java (test that i can compare a profile with it's connections and sort using
                         my connection rank)
```
## Things to do
1. Improve the rank algorithm by pulling up full profiles for all connections and using information such as employment history, skills etc. and compare that to current user's profile.
2. See if previous communication with connections can be retrieved and if so add that to rank algo.
3. See if previous activity of user profile can be retrieved and if so use that to determine if colleagues are more importand or if recruiters are more important ;)
4. If not from activity see if the headline can be intelligently read to understand the user's current preference of seeing recruiters being more important or colleagues.
5. See if you can turn this into a service that finds recruiters in companies that fit your profile.

## Privacy Note/Disclaimer:
1. This service is standalone and stateless and doesn't send, store your the linkedin info (profile, username, password, token or anything! no.. nothing.. nada!) to anyone or anywhere.
2. In the tests, profile and connections are printed on the console and that's your environment and not my responsibility. The service by itself has no privacy footprint.
3. If you're using this on a public computer, I'd recommend that you clear your browser cache/history, console cache/history if possible. That way there is absolutely zero privacy impact.
4. IN ANY CASE. I AM NOT RESPONSIBLE FOR ANYTHING YOU DO WITH THIS CODE.


## Have fun! :)
