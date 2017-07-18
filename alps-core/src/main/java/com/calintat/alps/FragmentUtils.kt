@file:Suppress("unused")

package com.calintat.alps

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
 * Note that you must pass the XML resource ID using the builder.
 */
class PreferencesFragmentXml : PreferenceFragment() {

    companion object Builder {

        private const val key = "com.calintat.github.PreferencesFragmentXml.key"

        fun build(preferencesResId: Int): PreferencesFragmentXml {

            val arguments = Bundle().apply { putInt(key, preferencesResId) }

            return PreferencesFragmentXml().apply { this.arguments = arguments }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState); addPreferencesFromResource(arguments.getInt(key))
    }
}