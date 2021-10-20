# Native Maven Plugin Parent/Child Modules

To reproduce the issue:

1. Run `mvn clean test -Pnative` in the root of the project. It will fail.

2. Run `mvn clean test -Pnative` in the `child-module` of the project. It will pass.

Issue: If you try running tests in native mode in the root directory of the project, the plugin does not seem to detect the generated test-ids file and will enter **test discovery** mode (which does not work):

```
WARNING: Failed to find com.google.common.util.concurrent.AbstractFuture on the classpath for reflection.
Oct 20, 2021 5:37:13 PM com.google.cloud.nativeimage.features.NativeImageUtils registerClassForReflection
WARNING: Failed to find com.google.common.util.concurrent.AbstractFuture$Waiter on the classpath for reflection.
[junit-platform-native] Running in 'test discovery' mode. Note that this is a fallback mode.
Fatal error:org.junit.platform.commons.JUnitException: TestEngine with ID 'junit-vintage' failed to discover tests
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discoverEngineRoot(EngineDiscoveryOrchestrator.java:160)
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discoverSafely(EngineDiscoveryOrchestrator.java:134)
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discover(EngineDiscoveryOrchestrator.java:108)
	at org.junit.platform.launcher.core.EngineDiscoveryOrchestrator.discover(EngineDiscoveryOrchestrator.java:80)
	at org.junit.platform.launcher.core.DefaultLauncher.discover(DefaultLauncher.java:110)
	at org.junit.platform.launcher.core.DefaultLauncher.discover(DefaultLauncher.java:78)

```