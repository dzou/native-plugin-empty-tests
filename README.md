# Native Maven Plugin Issues with Working Test Directory

The native-maven-plugin does not seem to correctly set the working directory used in tests in order to access resources.

Reproduction instructions:

1. First, run `mvn test -Pnative` in the project root directory. The test will fail due to not being able to find the resource file referenced in the test:

    ```
      java.nio.file.NoSuchFileException: src/test/resources/basic.txt
           sun.nio.fs.UnixFileSystemProvider.newByteChannel(UnixFileSystemProvider.java:219)
           java.nio.file.Files.newByteChannel(Files.java:371)
           java.nio.file.Files.newByteChannel(Files.java:422)
           java.nio.file.Files.readAllBytes(Files.java:3206)
           java.nio.file.Files.readString(Files.java:3284)
           java.nio.file.Files.readString(Files.java:3243)
           com.example.BasicTest.test(BasicTest.java:15)
           java.lang.reflect.Method.invoke(Method.java:566)
           org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:59)
           org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
           [...]

      ```

2. Then, change into the `child-module` directory (`cd child-module`) and then run `mvn test -Pnative`. It will pass.

3. Then, to compare with ordinary execution of tests in JVM mode by surefire, go back to the root directory (`cd ..`) and just run `mvn test` from the root directory. Tests should also pass in JVM mode from the root directory.

I think there is some issue with how the plugin chooses what the working directory is in relation to how it locates resources.

Note that this is not a problem solvable with `resources-config.json`.
