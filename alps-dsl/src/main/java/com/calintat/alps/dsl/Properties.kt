package com.calintat.alps.dsl

import android.content.Intent
import android.net.Uri
import android.preference.*

private const val NO_GETTER = "Property has no getter"

private fun noGetter(): Nothing = throw RuntimeException(NO_GETTER)

var CheckBoxPreference.defaultValue: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setDefaultValue(value)

var EditTextPreference.defaultValue: String
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setDefaultValue(value)

var RingtonePreference.defaultValue: String
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setDefaultValue(value)

var SwitchPreference.defaultValue: Boolean
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setDefaultValue(value)

var ListPreference.defaultValue: String
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setDefaultValue(value)

var MultiSelectListPreference.defaultValue: Set<String>
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setDefaultValue(value)

var Preference.iconResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setIcon(value)

var Preference.titleResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setTitle(value)

var Preference.summaryResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setSummary(value)

var ListPreference.entriesResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setEntries(value)

var ListPreference.entryValuesResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setEntryValues(value)

var ListPreference.pairs: List<Pair<Int, Any>>
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) {
        entries = value.map { context.getString(it.first) }.toTypedArray()
        entryValues = value.map { it.second.toString() }.toTypedArray()
    }

var MultiSelectListPreference.pairs: List<Pair<Int, Any>>
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) {
        entries = value.map { context.getString(it.first) }.toTypedArray()
        entryValues = value.map { it.second.toString() }.toTypedArray()
    }

var MultiSelectListPreference.entriesResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setEntries(value)

var MultiSelectListPreference.entryValuesResource: Int
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) = setEntryValues(value)

var Preference.url: String
    @Deprecated(NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
    set(value) { intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(value) } }