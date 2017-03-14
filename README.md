# Android Library for Preferences and Settings

[![](https://jitpack.io/v/calintat/alps.svg)](https://jitpack.io/#calintat/alps)

Alps is a minimal Android library for reading and writing shared preferences.

It aims to remove some boilerplate code when accessing your app's default preferences.

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
    compile 'com.github.calintat:alps:1.0'
}
```

Initialize the object with a context (e.g. inside the `onCreate` method).

```java
Alps.init(this);
```

Now you can use the get and put methods to access your app's settings:

```java
Alps.putBoolean("pref_boolean", false);
int n = Alps.getInt("pref_int", 28);
String str = Alps.getString("pref_string", "default");
```
