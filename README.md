# Spring Boot CRUD - TP DevOps

Projet minimal pour un TP DevOps : CRUD (Products) en Spring Boot, tests (TDD/CDD), JaCoCo, CI/CD (GitHub Actions) et Docker.

## Structure
- src/main/java : code source
- src/test/java : tests unitaires et d'intégration
- pom.xml : build + JaCoCo
- Dockerfile
- .github/workflows/ci.yml

## Pour lancer localement
1. `mvn clean package`
2. `java -jar target/spring-crud-0.0.1-SNAPSHOT.jar`
3. API disponible sur `http://localhost:8080/api/products`

## Notes
- Base H2 en mémoire pour faciliter les tests et le TP.
