# Alps

[![](https://jitpack.io/v/calintat/alps.svg)](https://jitpack.io/#calintat/alps)

Alps is a minimal Android library for reading and writing to your app's shared preferences.

## Installation

Add JitPack to the list of repositories:

```gradle
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Add Alps as a  dependency in the app build file:

```gradle
dependencies {
    compile "com.github.calintat.alps:alps-core:2.0"
}
```

## Features

### Get & put methods

The easiest way to access your app's preferences is with the `get` and `put` methods:

```java
String preference = getString("key", "default_value");
preference = "updated_value"; putString("key", preference);
```

### Property delegates

In Kotlin, you can instead use property delegates, for example:

```kotlin
var preference by stringPref("key", "default_value")
preference = "updated_value" // will also update the preference value
```

### Populate with preferences

Usually your settings activity will contain a `PreferenceFragment` inside a container.

With Alps, you can easily add a `PreferenceFragment` generated from an XML preference file:

```java
public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        populateWithPreferences(R.id.container, R.xml.preferences);
    }
}
```

### Define preferences with the Alps DSL

In Kotlin, you can also use a DSL to define your preferences and add them to your settings activity:

```gradle
dependencies {
    compile "com.github.calintat.alps:alps-dsl:2.0"
}
```

```kotlin
class SettingsActivity : Activity() {

    override onCreate(savedInstanceState: Bundle?) {
        ...
        populateWithPreferences(R.id.container) {
            preferenceCategory {
                title = "Alps"
                switchPreference(key = "pref_alps_dsl") {
                    defaultValue = true
                    title = "Use the Alps DSL"
                    summary = "Kotlin domain-specific language for defining preferences"
                }
            }
        }
    }
}
```