# Android Library for Preferences and Settings

[![](https://jitpack.io/v/calintat/alps.svg)](https://jitpack.io/#calintat/alps)

Alps is a minimal Android library for reading and writing shared defaultPreferences.

It aims to remove some boilerplate code when accessing your app's default defaultPreferences.

How to use
----------

Add the JitPack maven repository to the list of repositories:

```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Add the dependency to the gradle build file:

```gradle
dependencies {
    compile 'com.github.calintat:alps:1.1'
}
```

Now you can use the get and put methods to access your app's settings:

```java
putBoolean("pref_boolean", false);
int n = getInt("pref_int", 28);
String str = getString("pref_string", "default");
```