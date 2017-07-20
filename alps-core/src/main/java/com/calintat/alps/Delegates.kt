@file:Suppress("unused")

package com.calintat.alps

import android.app.Fragment
import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * A preference getter such as [getBoolean] or [getString].
 */
private typealias Get<R, T> = R.(String, T) -> T

/**
 * A preference putter such as [putBoolean] or [putString].
 */
private typealias Put<R, T> = R.(String, T) -> Unit

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
fun Context.booleanPref(key: String, defValue: Boolean = false): PreferenceProperty<Context, Boolean> {

    return PreferenceProperty(key, defValue, Context::getBoolean, Context::putBoolean)
}

fun Fragment.booleanPref(key: String, defValue: Boolean = false): PreferenceProperty<Fragment, Boolean> {

    return PreferenceProperty(key, defValue, Fragment::getBoolean, Fragment::putBoolean)
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
fun Context.floatPref(key: String, defValue: Float = 0f): PreferenceProperty<Context, Float> {

    return PreferenceProperty(key, defValue, Context::getFloat, Context::putFloat)
}

fun Fragment.floatPref(key: String, defValue: Float = 0f): PreferenceProperty<Fragment, Float> {

    return PreferenceProperty(key, defValue, Fragment::getFloat, Fragment::putFloat)
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
fun Context.intPref(key: String, defValue: Int = 0): PreferenceProperty<Context, Int> {

    return PreferenceProperty(key, defValue, Context::getInt, Context::putInt)
}

fun Fragment.intPref(key: String, defValue: Int = 0): PreferenceProperty<Fragment, Int> {

    return PreferenceProperty(key, defValue, Fragment::getInt, Fragment::putInt)
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
fun Context.longPref(key: String, defValue: Long = 0): PreferenceProperty<Context, Long> {

    return PreferenceProperty(key, defValue, Context::getLong, Context::putLong)
}

fun Fragment.longPref(key: String, defValue: Long = 0): PreferenceProperty<Fragment, Long> {

    return PreferenceProperty(key, defValue, Fragment::getLong, Fragment::putLong)
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
fun Context.stringPref(key: String, defValue: String = ""): PreferenceProperty<Context, String> {

    return PreferenceProperty(key, defValue, Context::getString, Context::putString)
}

fun Fragment.stringPref(key: String, defValue: String = ""): PreferenceProperty<Fragment, String> {

    return PreferenceProperty(key, defValue, Fragment::getString, Fragment::putString)
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
fun Context.booleanSetPref(key: String, defValue: Set<Boolean> = emptySet()): PreferenceProperty<Context, Set<Boolean>> {

    return PreferenceProperty(key, defValue, Context::getBooleanSet, Context::putBooleanSet)
}

fun Fragment.booleanSetPref(key: String, defValue: Set<Boolean> = emptySet()): PreferenceProperty<Fragment, Set<Boolean>> {

    return PreferenceProperty(key, defValue, Fragment::getBooleanSet, Fragment::putBooleanSet)
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
fun Context.floatSetPref(key: String, defValue: Set<Float> = emptySet()): PreferenceProperty<Context, Set<Float>> {

    return PreferenceProperty(key, defValue, Context::getFloatSet, Context::putFloatSet)
}

fun Fragment.floatSetPref(key: String, defValue: Set<Float> = emptySet()): PreferenceProperty<Fragment, Set<Float>> {

    return PreferenceProperty(key, defValue, Fragment::getFloatSet, Fragment::putFloatSet)
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
fun Context.intSetPref(key: String, defValue: Set<Int> = emptySet()): PreferenceProperty<Context, Set<Int>> {

    return PreferenceProperty(key, defValue, Context::getIntSet, Context::putIntSet)
}

fun Fragment.intSetPref(key: String, defValue: Set<Int> = emptySet()): PreferenceProperty<Fragment, Set<Int>> {

    return PreferenceProperty(key, defValue, Fragment::getIntSet, Fragment::putIntSet)
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
fun Context.longSetPref(key: String, defValue: Set<Long> = emptySet()): PreferenceProperty<Context, Set<Long>> {

    return PreferenceProperty(key, defValue, Context::getLongSet, Context::putLongSet)
}

fun Fragment.longSetPref(key: String, defValue: Set<Long> = emptySet()): PreferenceProperty<Fragment, Set<Long>> {

    return PreferenceProperty(key, defValue, Fragment::getLongSet, Fragment::putLongSet)
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
fun Context.stringSetPref(key: String, defValue: Set<String> = emptySet()): PreferenceProperty<Context, Set<String>> {

    return PreferenceProperty(key, defValue, Context::getStringSet, Context::putStringSet)
}

fun Fragment.stringSetPref(key: String, defValue: Set<String> = emptySet()): PreferenceProperty<Fragment, Set<String>> {

    return PreferenceProperty(key, defValue, Fragment::getStringSet, Fragment::putStringSet)
}

/**
 * A property delegate that use a preference as a sort of backing field.
 *
 * @param key The name of the preference used as a backing field for the property.
 * @param defValue The default value of the property if the preference does not exist.
 */
class PreferenceProperty<in R, T>(val key: String, val defValue: T, val get: Get<R, T>, val put: Put<R, T>) : ReadWriteProperty<R, T> {

    override operator fun getValue(thisRef: R, property: KProperty<*>): T {

        return thisRef.get(key, defValue)
    }

    override operator fun setValue(thisRef: R, property: KProperty<*>, value: T) {

        thisRef.put(key, value)
    }
}