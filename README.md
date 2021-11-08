# Native Maven Plugin Parent/Child Modules

To reproduce the issue:

1. Run `mvn clean test -Pnative` in the root of the project. It will fail.

```
Execution test-native of goal org.graalvm.buildtools:native-maven-plugin:0.9.7.1:test failed: Test configuration file wasn't found. ->
```

2. Then, try removing the `surefire-junit47` dependency to make the tests pass. Run `mvn clean test -Pnative` again.

```
  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M5</version>

        <!-- Remove this dependency to make it pass. -->
        <dependencies>
          <dependency>
            <groupId>org.apache.maven.surefire</groupId>
            <artifactId>surefire-junit47</artifactId>
            <version>3.0.0-M5</version>
          </dependency>
        </dependencies>
      </plugin>
    </plugins>
  </build>
```
