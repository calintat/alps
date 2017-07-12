package com.github.calintat

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A preference getter such as [getBoolean] or [getString].
 */
private typealias Get<T> = Context.(String, T) -> T

/**
 * A preference putter such as [putBoolean] or [putString].
 */
private typealias Put<T> = Context.(String, T) -> Unit

/**
 * Returns a property delegate for a read/write property corresponding to a boolean preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a boolean.
 */
fun Context.booleanPref(key: String, defValue: Boolean = false): PreferenceProperty<Boolean> {

    return PreferenceProperty(key, defValue, Context::getBoolean, Context::putBoolean)
}

/**
 * Returns a property delegate for a read/write property corresponding to a float preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a float.
 */
fun Context.floatPref(key: String, defValue: Float = 0f): PreferenceProperty<Float> {
    
    return PreferenceProperty(key, defValue, Context::getFloat, Context::putFloat)
}

/**
 * Returns a property delegate for a read/write property corresponding to an int preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not an int.
 */
fun Context.intPref(key: String, defValue: Int = 0): PreferenceProperty<Int> {
    
    return PreferenceProperty(key, defValue, Context::getInt, Context::putInt)
}

/**
 * Returns a property delegate for a read/write property corresponding to a long preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a long.
 */
fun Context.longPref(key: String, defValue: Long = 0): PreferenceProperty<Long> {
    
    return PreferenceProperty(key, defValue, Context::getLong, Context::putLong)
}

/**
 * Returns a property delegate for a read/write property corresponding to a string preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a string.
 */
fun Context.stringPref(key: String, defValue: String = ""): PreferenceProperty<String> {
    
    return PreferenceProperty(key, defValue, Context::getString, Context::putString)
}

/**
 * Returns a property delegate for a read/write property corresponding to a boolean set preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.booleanSetPref(key: String, defValue: Set<Boolean> = emptySet()): PreferenceProperty<Set<Boolean>> {

    return PreferenceProperty(key, defValue, Context::getBooleanSet, Context::putBooleanSet)
}

/**
 * Returns a property delegate for a read/write property corresponding to a float set preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.floatSetPref(key: String, defValue: Set<Float> = emptySet()): PreferenceProperty<Set<Float>> {

    return PreferenceProperty(key, defValue, Context::getFloatSet, Context::putFloatSet)
}

/**
 * Returns a property delegate for a read/write property corresponding to an int set preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.intSetPref(key: String, defValue: Set<Int> = emptySet()): PreferenceProperty<Set<Int>> {

    return PreferenceProperty(key, defValue, Context::getIntSet, Context::putIntSet)
}

/**
 * Returns a property delegate for a read/write property corresponding to a long set preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.longSetPref(key: String, defValue: Set<Long> = emptySet()): PreferenceProperty<Set<Long>> {

    return PreferenceProperty(key, defValue, Context::getLongSet, Context::putLongSet)
}

/**
 * Returns a property delegate for a read/write property corresponding to a string set preference.
 * Note that this uses the default shared preferences of the receiver context.
 * Changing the value of the property will be reflected in the shared preferences.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 *
 * @throws ClassCastException If there is a preference with this name that is not a set.
 */
fun Context.stringSetPref(key: String, defValue: Set<String> = emptySet()): PreferenceProperty<Set<String>> {

    return PreferenceProperty(key, defValue, Context::getStringSet, Context::putStringSet)
}

/**
 * A property delegate that use a preference as a sort of backing field.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 */
class PreferenceProperty<T>(val key: String, val defValue: T, val get: Get<T>, val put: Put<T>) : ReadWriteProperty<Context, T> {

    override operator fun getValue(thisRef: Context, property: KProperty<*>): T {

        return thisRef.get(key, defValue)
    }

    override operator fun setValue(thisRef: Context, property: KProperty<*>, value: T) {

        thisRef.put(key, value)
    }
}