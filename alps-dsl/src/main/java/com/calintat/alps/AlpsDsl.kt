@file:Suppress("unused")

package com.calintat.alps

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.*

@DslMarker
@Target(AnnotationTarget.TYPE)
private annotation class AlpsDslMarker

/**
 * Initializer lambda for a given preference type T.
 */
private typealias Init<T> = (@AlpsDslMarker T).() -> Unit

/**
 * Set an url to be opened when this preference is clicked.
 */
@Deprecated(message = "Use url property instead", replaceWith = ReplaceWith("this.url = url"))
fun Preference.setUrl(url: String) {

    intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) }
}

/**
 * Populate the given preference fragment with preferences using the DSL.
 */
fun PreferenceFragment.populateWithPreferences(init: Init<PreferenceScreen>) {

    preferenceScreen = preferenceManager.createPreferenceScreen(activity).apply(init)
}

/**
 * Populate the given container with a preference fragment generated with the DSL.
 *
 * @param containerViewId Identifier of the container where the fragment will be added.
 */
fun Activity.populateWithPreferences(containerViewId: Int, init: Init<PreferenceScreen>) {

    class PreferenceFragmentDsl : PreferenceFragment() {

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState); populateWithPreferences(init)
        }
    }

    fragmentManager.beginTransaction().replace(containerViewId, PreferenceFragmentDsl()).commit()
}

@PublishedApi
internal inline fun <T : Preference> PreferenceGroup.pref(build: (Context) -> T, key: String? = null, init: Init<T>): T {

    return build(context).apply { if (key != null) this.key = key; addPreference(this); init() }
}

inline fun PreferenceGroup.checkBoxPreference(key: String? = null, init: Init<CheckBoxPreference>) = pref(::CheckBoxPreference, key, init)

inline fun PreferenceGroup.editTextPreference(key: String? = null, init: Init<EditTextPreference>) = pref(::EditTextPreference, key, init)

inline fun PreferenceGroup.ringtonePreference(key: String? = null, init: Init<RingtonePreference>) = pref(::RingtonePreference, key, init)

inline fun PreferenceGroup.switchPreference(key: String? = null, init: Init<SwitchPreference>) = pref(::SwitchPreference, key, init)

inline fun PreferenceGroup.listPreference(key: String? = null, init: Init<ListPreference>) = pref(::ListPreference, key, init)

inline fun PreferenceGroup.multiSelectListPreference(key: String? = null, init: Init<MultiSelectListPreference>) = pref(::MultiSelectListPreference, key, init)

inline fun PreferenceGroup.preference(key: String? = null, init: Init<Preference>) = pref(::Preference, key, init)

inline fun PreferenceGroup.preferenceCategory(key: String? = null, init: Init<PreferenceCategory>) = pref(::PreferenceCategory, key, init)

inline fun PreferenceGroup.preferenceScreen(key: String? = null, init: Init<PreferenceScreen>) = pref(preferenceManager::createPreferenceScreen, key, init)!!