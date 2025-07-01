## Child Modules
* logback
* log4j2
* log4j2-masking-interceptor (library)
* log4j2-masking-interceptor-consumer


## log4j2-masking-interceptor (library)
A library through which all the log statements should go through and the library should intelligently mask the personal data in the log statements e.g. msisdn, landline, email etc.

### Masking Criteria:-

#### MSISDN
- '+' is optional in the start
- starts with the defined country codes
- excluding country code, minDigits = 7 and maxDigits = 12 (can be change)
- last 4 digits will not be masked e.g; 9613123456 → ******3456

#### LANDLINE
- starts with the digit '1'
- total digits would be 9
- last 4 digits will not be masked e.g; 148406656 → *****6656

#### EMAIL
- first and after the '@' will not be masked e.g; john.doe@xyz.co.sa → j*******@xyz.co.sa

### Note:-
- To use this module as library
  - Incase of decentralized/module specific "log4j2-spring.xml"
    - optional - remove Main.java
    - optional - remove log4j2-spring.xml
    - remove unnecessary dependencies OR set their scope to "provided"
  - Incase of centralized "log4j2-spring.xml" / "log4j2.xml"
    - library module dependencies scope should be "provided", if the consuming module will provide the required dependencies
    - consuming module should define the properties that is dynamically injected at runtime in the library module "log4j2-spring.xml"