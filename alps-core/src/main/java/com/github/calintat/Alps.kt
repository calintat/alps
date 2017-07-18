@file:Suppress("unused")

package com.github.calintat

import android.content.Context
import android.preference.PreferenceManager

/**
 * The default shared preferences of the given context.
 */
val Context.defaultPreferences get() = PreferenceManager.getDefaultSharedPreferences(this)!!

/**
 * Retrieves a boolean value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (false by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException If there is a preference with this name that is not a boolean.
 */
fun Context.getBoolean(key: String, defValue: Boolean = false): Boolean {

    return defaultPreferences.getBoolean(key, defValue)
}

/**
 * Sets a boolean value in the default preferences.
 * Note that if the value is null then this does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putBoolean(key: String, value: Boolean?) {

    value?.let { defaultPreferences.edit().putBoolean(key, it).apply() }
}

/**
 * Retrieves a float value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (0 by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException If there is a preference with this name that is not a float.
 */
fun Context.getFloat(key: String, defValue: Float = 0f): Float {

    return defaultPreferences.getFloat(key, defValue)
}

/**
 * Sets a float value in the default preferences.
 * Note that if the value is null then this does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putFloat(key: String, value: Float?) {

    value?.let { defaultPreferences.edit().putFloat(key, it).apply() }
}

/**
 * Retrieves an int value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (0 by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException If there is a preference with this name that is not an int.
 */
fun Context.getInt(key: String, defValue: Int = 0): Int {

    return defaultPreferences.getInt(key, defValue)
}

/**
 * Sets an int value in the default preferences.
 * Note that if the value is null then this does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putInt(key: String, value: Int?) {

    value?.let { defaultPreferences.edit().putInt(key, it).apply() }
}

/**
 * Retrieves a long value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (0 by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException If there is a preference with this name that is not a long.
 */
fun Context.getLong(key: String, defValue: Long = 0): Long {

    return defaultPreferences.getLong(key, defValue)
}

/**
 * Sets a long value in the default preferences.
 * Note that if the value is null then this does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putLong(key: String, value: Long?) {

    value?.let { defaultPreferences.edit().putLong(key, it).apply() }
}

/**
 * Retrieves a non-null string value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValue Value to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference value if it exists, or [defValue].
 *
 * @throws ClassCastException If there is a preference with this name that is not a string.
 */
fun Context.getString(key: String, defValue: String = ""): String {

    return defaultPreferences.getString(key, defValue)
}

/**
 * Retrieves a nullable string value from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 *
 * @return Returns the preference value if it exists, or null.
 *
 * @throws ClassCastException If there is a preference with this name that is not a string.
 */
fun Context.getStringOrNull(key: String): String? {

    return defaultPreferences.getString(key, null)
}

/**
 * Sets a string value in the default preferences.
 * Note that if the value is null then this does nothing.
 *
 * @param key The name of the preference to modify.
 * @param value The new value for the preference which is allowed to be null.
 */
fun Context.putString(key: String, value: String?) {

    value?.let { defaultPreferences.edit().putString(key, it).apply() }
}

/**
 * Retrieves a set of boolean values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or [defValues].
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.getBooleanSet(key: String, defValues: Set<Boolean> = emptySet()): Set<Boolean> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toBoolean)
}

/**
 * Sets a set of boolean values in the default preferences.
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putBooleanSet(key: String, values: Set<Boolean>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieves a set of float values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or [defValues].
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.getFloatSet(key: String, defValues: Set<Float> = emptySet()): Set<Float> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toFloatOrNull)
}

/**
 * Sets a set of float values in the default preferences.
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putFloatSet(key: String, values: Set<Float>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieves a set of int values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or defValues.
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.getIntSet(key: String, defValues: Set<Int> = emptySet()): Set<Int> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toIntOrNull)
}

/**
 * Sets a set of int values in the default preferences.
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putIntSet(key: String, values: Set<Int>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieves a set of long values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or defValues.
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.getLongSet(key: String, defValues: Set<Long> = emptySet()): Set<Long> {

    return convert(defaultPreferences.getStringSet(key, convert(defValues)), String::toLongOrNull)
}

/**
 * Sets a set of long values in the default preferences.
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putLongSet(key: String, values: Set<Long>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, convert(it)).apply() }
}

/**
 * Retrieves a set of string values from the default preferences.
 *
 * @param key The name of the preference to retrieve.
 * @param defValues Values to return if this preference does not exist (empty by default).
 *
 * @return Returns the preference values if they exist, or [defValues].
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.getStringSet(key: String, defValues: Set<String> = emptySet()): Set<String> {

    return defaultPreferences.getStringSet(key, defValues)
}

/**
 * Sets a set of string values in the default preferences.
 * Note that if this set is null then the method does nothing.
 *
 * @param key The name of the preference to modify.
 * @param values The set of new values for the preference which is allowed to be null.
 */
fun Context.putStringSet(key: String, values: Set<String>?) {

    values?.let { defaultPreferences.edit().putStringSet(key, it).apply() }
}

/**
 * Converts a set of strings to a set of values of type [T].
 * Note that [transform] must return null if it fails, and those values will be omitted.
 */
private fun <T : Any> convert(set: Set<String>, transform: (String) -> T?): Set<T> {

    return set.map(transform).filterNotNull().toSet()
}

/**
 * Converts a set of values of type [T] to a set of strings.
 */
private fun <T> convert(set: Set<T>) = set.map { it.toString() }.toSet()