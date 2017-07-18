package com.calintat.alps

import android.preference.*

inline fun CheckBoxPreference.onChange(crossinline listener: (Boolean) -> Boolean) {

    setOnPreferenceChangeListener { preference, newValue ->

        preference == this && newValue is Boolean && listener(newValue)
    }
}

inline fun EditTextPreference.onChange(crossinline listener: (String) -> Boolean) {

    setOnPreferenceChangeListener { preference, newValue ->

        preference == this && newValue is String && listener(newValue)
    }
}

inline fun RingtonePreference.onChange(crossinline listener: (String) -> Boolean) {

    setOnPreferenceChangeListener { preference, newValue ->

        preference == this && newValue is String && listener(newValue)
    }
}

inline fun SwitchPreference.onChange(crossinline listener: (Boolean) -> Boolean) {

    setOnPreferenceChangeListener { preference, newValue ->

        preference == this && newValue is Boolean && listener(newValue)
    }
}

inline fun ListPreference.onChange(crossinline listener: (String) -> Boolean) {

    setOnPreferenceChangeListener { preference, newValue ->

        preference == this && newValue is String && listener(newValue)
    }
}

@Suppress("UNCHECKED_CAST")
inline fun MultiSelectListPreference.onChange(crossinline listener: (Set<String>) -> Boolean) {

    setOnPreferenceChangeListener { preference, newValue ->

        preference == this && newValue is Set<*> && listener(newValue as Set<String>)
    }
}