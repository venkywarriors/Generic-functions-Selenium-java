### :dart:Execute testng.xml using Maven : <br> 

We have to include, maven-compiler-plugin and maven-surefire-plugin to the configuration file Pom.xml

```
<!-- Maven-compiler-plugin -->
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<version>3.5.1</version>
			<configuration>
				<source>${jdk.level}</source>
				<target>${jdk.level}</target>
			</configuration>
	</plugin>
```
Maven-surefire-plugin: Surefire-plugin is responsible for running tests that are placed in test source directory /src/test/java.
```
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-surefire-plugin</artifactId>
		<version>2.19.1</version>
			<configuration>
				<suiteXmlFiles>
				<!-- TestNG suite XML files -->
					<suiteXmlFile>testng.xml</suiteXmlFile>
				</suiteXmlFiles>
			</configuration>
	</plugin>
```
### :dart:TestNG maven example : <br> 
Now execute above pom.xml file using command “mvn test” from command prompt
### :dart: Parametrize to Execute TestNG.xml using Maven: <br> 
```
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-surefire-plugin</artifactId>
		<version>2.19.1</version>
			<configuration>
				<suiteXmlFiles>
					 <!-- Need to pass testng.xml files as argument from command line -->
						<suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
				</suiteXmlFiles>
			</configuration>
	</plugin>
```
### :dart: Below is the command to execute only single testng.xml file: <br> 
```
mvn clean test -Dsurefire.suiteXmlFiles=mytestng.xml
```
command to parametrize multiple testng.xml files using Maven
```
mvn clean test -Dsurefire.suiteXmlFiles=mytestng1.xml,mytestng2.xml
```
### :dart: Run from batch file: <br> 
```
@ECHO ON

J:
cd "J:\test automation\selenium_project\project"
mvn compile test-Dsurefire.suiteXmlFiles=src/main/resources/lightRegrssion.xml
```
