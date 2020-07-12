# Anywhr-covid19-solution Project

## How to use it?
1. Install [JDK](https://www.oracle.com/) [Node.js](https://nodejs.org/) and [PostgreSQL](https://www.postgresql.org/)
2. Create database called `anywhr_covid19_solution_db`
3. Install all dependencies both in `anywhr-covid19-solution-server` folder by typing `gradlew clean build`
4. Install all dependencies both in `anywhr-covid19-solution-web` folder by typing `npm install`
4. Run Server: type `java -jar build/libs/anywhr-covid19-solution-server.jar co.anywhr.AnywhrCovid19SolutionServer` in `anywhr-covid19-solution-server` folder
5. Run Web: type `npm start` in `anywhr-covid19-solution-web` folder

## Swagger:
http://localhost:8080/swagger-ui.html
Please check tab `hexagon-controller`

##UI:
http://localhost:3000/