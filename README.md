## First Camel Route Example
This project shows a simple example of a targeting collector using Apache Camel and the Spring DSL. 
The collector called "Customer Information" provides a selector to identify the category of the customer, as well as a selector 
to provide the annual income.

## Prerequisites
You must have a CXP project configured in your machine before performing this exercise. If you do not have one, please follow the instructions on the following site: https://my.backbase.com/docs/how-to-guides/getting-your-first-launchpad-based-portal-set-up/

### Installation & Configuration

- Copy **target-collector-exercise-01** into the **services** folder of your project. You can use the git command to clone the project: ```git clone https://github.com/marciofk/target-collector-exercise-01.git```

- Include **target-collector-exercise-01** module to the build.  Open `services/pom.xml` and add **target-collector-exercise-01** in the `<modules>` section: 
	```xml
	    <modules>
	        ...	    
	        <module>target-collector-exercise-01</module>
	        ...
	    </modules>
	```	
	Re-compile **services** by executing `mvn clean install` in the **services** folder.
	
- Enable newly created module in the Portalserver application. In the `<dependencies>` section of `webapps/portalserver/pom.xml`, add the following dependency:

	```xml
	    <dependency>
	        <groupId>com.backbase.training</groupId>
	        <artifactId>target-collector-exercise-01</artifactId>
	        <version>1.0-SNAPSHOT</version>
	    </dependency>
	```

### Build & Run

- You must restart your portal server if the application is already running. 
- Test the collector using the CXP Manager. Create a new page with a targeting container that uses your new collector (selecting customer category and/or income)
