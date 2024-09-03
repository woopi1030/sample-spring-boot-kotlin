# sample-spring-boot-kotlin
sample-spring-boot-kotlin


- gradle build
  - gradlew clean build -x test
- application start
  - gradlew bootrun --args='--spring.profiles.active=local'


- gradle build (멀티 모듈)
  - gradlew clean build -x test
- application start (멀티 모듈)
  - gradlew :module-app:bootrun --args='--spring.profiles.active=local'

