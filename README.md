# Native Maven Plugin Issues with Module without tests

Run `mvn test -Pnative` in the root directory.

It will fail with error:

```
[ERROR] Test configuration file wasn't found. Make sure that test execution wasn't skipped.
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for native-junit-experiment 1.0-SNAPSHOT:
[INFO] 
[INFO] native-junit-experiment ............................ SUCCESS [  0.051 s]
[INFO] empty-test-module .................................. FAILURE [  0.544 s]
[INFO] simple-module ...................................... SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.860 s
[INFO] Finished at: 2022-01-06T10:09:52-05:00


```
