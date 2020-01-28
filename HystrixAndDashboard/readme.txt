In this project we will see how to use hystrix - circuit - breaker
Bring both services up and run
http://localhost:9098/getSchoolDetails/abcschool

After that shutdown spring-hystrix-student-service and HIT again 
http://localhost:9098/getSchoolDetails/abcschool , the circuit breaker should be open.