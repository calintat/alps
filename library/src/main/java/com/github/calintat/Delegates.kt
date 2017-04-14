package com.github.calintat

import android.content.Context
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
 * @throws ClassCastException if there is a preference with this name that is not a boolean.
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
 * @throws ClassCastException if there is a preference with this name that is not a float.
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
 * @throws ClassCastException if there is a preference with this name that is not an int.
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
 * @throws ClassCastException if there is a preference with this name that is not a long.
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
 * @throws ClassCastException if there is a preference with this name that is not a string.
 */
fun Context.stringPref(key: String, defValue: String = ""): PreferenceProperty<String> {
    
    return PreferenceProperty(key, defValue, Context::getString, Context::putString)
}

/**
 * A property delegate of properties that use a preference as a sort of backing field.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 */
class PreferenceProperty<T>(val key: String, val defValue: T, val get: Get<T>, val put: Put<T>) {

    operator fun getValue(thisRef: Context, property: KProperty<*>): T {

        return thisRef.get(key, defValue)
    }

    operator fun setValue(thisRef: Context, property: KProperty<*>, value: T) {

        thisRef.put(key, value)
    }
}