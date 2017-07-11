# Alps

[![](https://jitpack.io/v/calintat/alps.svg)](https://jitpack.io/#calintat/alps)

Alps is a minimal Android library for reading and writing shared preferences.

It aims to remove some boilerplate code when accessing your app's default preferences.

## Installation

Add JitPack to your list of repositories:

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
    compile 'com.github.calintat:alps:1.2.1'
}
```

## Features

You can use the get and put methods to access your app's settings:

```java
putBoolean("pref_boolean", false);
int n = getInt("pref_int", 28);
String str = getString("pref_string", "default");
```

You can also use the following to populate a container view with a preference fragment:

```java
populateWithPreferences(int containerViewId, int preferencesResId)
```

Since version 1.2, you can also use property delegates (in Kotlin only):

```kotlin
val str by stringPref("pref_string", "default")
```
