Guide to installing 3rd party JARs
=====================================
```To install a JAR in the local repository use the following command:
mvn install:install-file -Dfile=<path-to-file> -DgroupId=<group-id> -DartifactId=<artifact-id> -Dversion=<version> -Dpackaging=<packaging>

```If there's a pom-file as well, you can install it with the following command:
mvn install:install-file -Dfile=<path-to-file> -DpomFile=<path-to-pomfile>

### Go to lib folder and run command as below to install jar file
``` Starting 
```1.Add Microsoft SQL JDBC driver to Maven
mvn install:install-file -Dfile=sqlserver\sqljdbc4.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0 -Dpackaging=jar


```2.Add DB2 JDBC driver to Maven
mvn install:install-file -Dfile=db2\db2jcc_license_cu.jar -DgroupId=com.ibm.db2.jcc -DartifactId=db2jcc_license_cu -Dversion=10.5 -Dpackaging=jar

mvn install:install-file -Dfile=db2\db2jcc4.jar -DgroupId=com.ibm.db2.jcc -DartifactId=db2jcc4 -Dversion=10.5 -Dpackaging=jar


```3.Add Oracle Driver to Maven
mvn install:install-file -Dfile=oracle\12cR2\ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.1.0.1 -Dpackaging=jar


```