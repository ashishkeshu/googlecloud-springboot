# googlecloud-springboot

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

4.Google Cloud Platform SDK

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/ashishkeshu/googlecloud-springboot
```

**2. Create Mysql database**
```bash
create database demo_db
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation or goole cloud sql

+ change `spring.cloud.gcp.project-id`, `spring.cloud.gcp.credentials.location` and `google.cloud.storage.bucket.name` 

**4. Setup the Google Cloud SDK**

Complete the setup by selecting google cloud platform project and region.

**5. Build and run the app using maven**

Go to the project directory and run:

```bash
mvn clean appengine:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

swagger is implemented with project so just hit http://localhost:8080/swagger-ui.html

## Learn more

You can find the more tutorial on

<https://codelabs.developers.google.com/codelabs/cloud-app-engine-springboot/#0/>
<https://codelabs.developers.google.com/codelabs/spring-cloud-gcp-gcs/#0/>
