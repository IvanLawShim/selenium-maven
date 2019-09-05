# selenium-maven
Selenium java with Maven, TestNG and Extent Report


# Installation (For Eclipse)

### Creating Maven Project
1. Go to **File > New > Others > Maven > Maven Project** and click next.
2. Check **Use default Workspace location**.
3. Choose *Artifact ID*: **maven-archetype-quickstart**, *version*: **1.1**.
4. Input desired Group ID and Artifact ID. Click **Finish**.

### Adding dependency libraries
5. Open the project(the project name is the the Artifact ID which was added earlier.).
6. Open **pom.xml**. It should look like this:


        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
          <modelVersion>4.0.0</modelVersion>

          <groupId>tutorial_this</groupId>
          <artifactId>testing</artifactId>
          <version>0.0.1-SNAPSHOT</version>
          <packaging>jar</packaging>

          <name>testing</name>
          <url>http://maven.apache.org</url>

          <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
          </properties>

          <dependencies>
            <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>3.8.1</version>
              <scope>test</scope>
            </dependency>
          </dependencies>
        </project>

7. Go to https://mvnrepository.com/ . This site contains tons of Maven dependencies.
8. Search for *selenium*. 
9. Choose **Selenium Java**.
10. Choose the newer version or the previous final build version. 
11. Copy the Maven dependency syntax.
12. Paste in **pom.xml**. It should be pasted inside the `<dependencies>...</dependencies>`. For example:

        <dependencies>
            <dependency>
              <groupId>junit</groupId>
              <artifactId>junit</artifactId>
              <version>3.8.1</version>
              <scope>test</scope>
            </dependency>

            <dependency>
              <groupId>org.seleniumhq.selenium</groupId>
              <artifactId>selenium-java</artifactId>
              <version>3.141.59</version>
            </dependency>
        </dependencies>

13. Copy the other necessary dependencies.

        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.0.0</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>3.1.5</version>
        </dependency>

        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.6</version>
        </dependency>

14. Save the changes and wait for Eclipse to download and to install the dependencies.

# Notes
The project is now ready. Create your trial scripts in the `src/test/java` folder or create directly in the `src/main/java` folder.
