package com.github.calintat

import android.app.Activity
import android.os.Bundle
import android.preference.PreferenceFragment

/**
 * Populates the given container with a preference fragment generated from an XML resource.
 *
 * @param containerViewId Identifier of the container where the fragment will be added.
 * @param preferencesResId The XML resource ID to inflate.
 */
fun Activity.populateWithPreferences(containerViewId: Int, preferencesResId: Int) {

    val preferencesFragment = PreferencesFragmentXml.build(preferencesResId)

    fragmentManager.beginTransaction().replace(containerViewId, preferencesFragment).commit()
}

/**
 * Implementation of the preference fragment which inflates a given XML resource.
 *
 * Note that you must pass the XML resource ID as a construction argument or use the builder.
 */
class PreferencesFragmentXml : PreferenceFragment() {

    companion object Builder {

        const val KEY_PREFERENCE_RES_ID = "com.calintat.github.KEY_PREFERENCE_RES_ID"

        fun build(preferencesResId: Int): PreferencesFragmentXml {

            val arguments = Bundle().apply { putInt(KEY_PREFERENCE_RES_ID, preferencesResId) }

            return PreferencesFragmentXml().apply { this.arguments = arguments }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState); addPreferencesFromResource(arguments.getInt(KEY_PREFERENCE_RES_ID))
    }
}