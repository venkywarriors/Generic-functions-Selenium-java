## How to create parameterized maven job in Jenkins 
### :dart:Configuration in pom.xml: <br> 
Reference <a href="https://github.com/MukeshOtwani/Framework/blob/master/Framework/pom.xml">pom file</a>
```	
<plugin>
 <groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-surefire-plugin</artifactId>
	<version>3.0.0-M3</version>
	 <configuration>				
	  <suiteXmlFiles>
			<suiteXmlFile>XMLFiles/${xmlFiles}</suiteXmlFile>
		</suiteXmlFiles>
					
		<systemPropertyVariables>
			<executionBrowser>${browser}</executionBrowser>
				</systemPropertyVariables>
	</configuration>
</plugin>
```
In Jenkins Build section under Goals and options add following value
```
clean install -Dbrowser=$Browser -DxmlFile=$XMLSuite
```
