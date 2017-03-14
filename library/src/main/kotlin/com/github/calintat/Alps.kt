package com.github.calintat

import android.content.Context
import android.preference.PreferenceManager

object Alps {

    private lateinit var context: Context

    private val preferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }

    /**
     * Initialize the object with a context.
     *
     * Note that this must be called before any other methods.
     *
     * @param context The context of the preferences whose values this object will operate on.
     */
    fun init(context: Context) {

        this.context = context
    }

    /**
     * Retrieve a boolean value from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist (false by default).
     *
     * @return Returns the preference value if it exists, or defValue.
     *
     * @throws ClassCastException if there is a preference with this name that is not a boolean.
     */
    fun getBoolean(key: String, defValue: Boolean = false): Boolean {

        return preferences.getBoolean(key, defValue)
    }

    /**
     * Set a boolean value in the default preferences.
     *
     * Note that if this value is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference which is allowed to be null.
     */
    fun putBoolean(key: String, value: Boolean?) {

        value?.let { preferences.edit().putBoolean(key, it).apply() }
    }

    /**
     * Retrieve a float value from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist (0 by default).
     *
     * @return Returns the preference value if it exists, or defValue.
     *
     * @throws ClassCastException if there is a preference with this name that is not a float.
     */
    fun getFloat(key: String, defValue: Float = 0f): Float {

        return preferences.getFloat(key, defValue)
    }

    /**
     * Set a float value in the default preferences.
     *
     * Note that if this value is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference which is allowed to be null.
     */
    fun putFloat(key: String, value: Float?) {

        value?.let { preferences.edit().putFloat(key, it).apply() }
    }

    /**
     * Retrieve an int value from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist (0 by default).
     *
     * @return Returns the preference value if it exists, or defValue.
     *
     * @throws ClassCastException if there is a preference with this name that is not an int.
     */
    fun getInt(key: String, defValue: Int = 0): Int {

        return preferences.getInt(key, defValue)
    }

    /**
     * Set an int value in the default preferences.
     *
     * Note that if this value is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference which is allowed to be null.
     */
    fun putInt(key: String, value: Int?) {

        value?.let { preferences.edit().putInt(key, it).apply() }
    }

    /**
     * Retrieve a long value from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist (0 by default).
     *
     * @return Returns the preference value if it exists, or defValue.
     *
     * @throws ClassCastException if there is a preference with this name that is not a long.
     */
    fun getLong(key: String, defValue: Long = 0): Long {

        return preferences.getLong(key, defValue)
    }

    /**
     * Set a long value in the default preferences.
     *
     * Note that if this value is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference which is allowed to be null.
     */
    fun putLong(key: String, value: Long?) {

        value?.let { preferences.edit().putLong(key, it).apply() }
    }

    /**
     * Retrieve a non-null string value from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValue Value to return if this preference does not exist (empty by default).
     *
     * @return Returns the preference value if it exists, or defValue.
     *
     * @throws ClassCastException if there is a preference with this name that is not a string.
     */
    fun getString(key: String, defValue: String = ""): String {

        return preferences.getString(key, defValue)
    }

    /**
     * Retrieve a nullable string value from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     *
     * @return Returns the preference value if it exists, or null.
     *
     * @throws ClassCastException if there is a preference with this name that is not a string.
     */
    fun getStringOrNull(key: String): String? {

        return preferences.getString(key, null)
    }

    /**
     * Set a string value in the default preferences.
     *
     * Note that if this value is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param value The new value for the preference which is allowed to be null.
     */
    fun putString(key: String, value: String?) {

        value?.let { preferences.edit().putString(key, it).apply() }
    }

    /**
     * Retrieve a set of boolean values from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValues Values to return if this preference does not exist (empty by default).
     *
     * @return Returns the preference values if they exist, or defValues.
     *
     * @throws ClassCastException if there is a preference with this name that is not a set.
     */
    fun getBooleanSet(key: String, defValues: Set<Boolean> = emptySet()): Set<Boolean> {

        return convert(preferences.getStringSet(key, convert(defValues)), String::toBoolean)
    }

    /**
     * Set a set of boolean values in the default preferences.
     *
     * Note that if this set is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param values The set of new values for the preference which is allowed to be null.
     */
    fun putBooleanSet(key: String, values: Set<Boolean>?) {

        values?.let { preferences.edit().putStringSet(key, convert(it)).apply() }
    }

    /**
     * Retrieve a set of float values from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValues Values to return if this preference does not exist (empty by default).
     *
     * @return Returns the preference values if they exist, or defValues.
     *
     * @throws ClassCastException if there is a preference with this name that is not a set.
     */
    fun getFloatSet(key: String, defValues: Set<Float> = emptySet()): Set<Float> {

        return convert(preferences.getStringSet(key, convert(defValues)), String::toFloatOrNull)
    }

    /**
     * Set a set of float values in the default preferences.
     *
     * Note that if this set is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param values The set of new values for the preference which is allowed to be null.
     */
    fun putFloatSet(key: String, values: Set<Float>?) {

        values?.let { preferences.edit().putStringSet(key, convert(it)).apply() }
    }

    /**
     * Retrieve a set of int values from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValues Values to return if this preference does not exist (empty by default).
     *
     * @return Returns the preference values if they exist, or defValues.
     *
     * @throws ClassCastException if there is a preference with this name that is not a set.
     */
    fun getIntSet(key: String, defValues: Set<Int> = emptySet()): Set<Int> {

        return convert(preferences.getStringSet(key, convert(defValues)), String::toIntOrNull)
    }

    /**
     * Set a set of int values in the default preferences.
     *
     * Note that if this set is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param values The set of new values for the preference which is allowed to be null.
     */
    fun putIntSet(key: String, values: Set<Int>?) {

        values?.let { preferences.edit().putStringSet(key, convert(it)).apply() }
    }

    /**
     * Retrieve a set of long values from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValues Values to return if this preference does not exist (empty by default).
     *
     * @return Returns the preference values if they exist, or defValues.
     *
     * @throws ClassCastException if there is a preference with this name that is not a set.
     */
    fun getLongSet(key: String, defValues: Set<Long> = emptySet()): Set<Long> {

        return convert(preferences.getStringSet(key, convert(defValues)), String::toLongOrNull)
    }

    /**
     * Set a set of long values in the default preferences.
     *
     * Note that if this set is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param values The set of new values for the preference which is allowed to be null.
     */
    fun putLongSet(key: String, values: Set<Long>?) {

        values?.let { preferences.edit().putStringSet(key, convert(it)).apply() }
    }

    /**
     * Retrieve a set of string values from the default preferences.
     *
     * @param key The name of the preference to retrieve.
     * @param defValues Values to return if this preference does not exist (empty by default).
     *
     * @return Returns the preference values if they exist, or defValues.
     *
     * @throws ClassCastException if there is a preference with this name that is not a set.
     */
    fun getStringSet(key: String, defValues: Set<String> = emptySet()): Set<String> {

        return preferences.getStringSet(key, defValues)
    }

    /**
     * Set a set of string values in the default preferences.
     *
     * Note that if this set is null then the method does nothing.
     *
     * @param key The name of the preference to modify.
     * @param values The set of new values for the preference which is allowed to be null.
     */
    fun putStringSet(key: String, values: Set<String>?) {

        values?.let { preferences.edit().putStringSet(key, it).apply() }
    }

    /**
     * Convert a set of strings to a set of values of type [T].
     *
     * Note that [transform] must return null if it fails, and those values will be omitted.
     */
    private fun<T : Any> convert(set: Set<String>, transform: (String) -> T?): Set<T> {

        return set.map(transform).filterNotNull().toSet()
    }

    /**
     * Convert a set of values of type [T] to a set of strings.
     */
    private fun<T> convert(set: Set<T>): Set<String> {

        return set.map { it.toString() }.toSet()
    }
}