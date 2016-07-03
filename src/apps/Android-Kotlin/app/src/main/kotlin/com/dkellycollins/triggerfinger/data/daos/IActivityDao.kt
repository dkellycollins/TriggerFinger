package com.dkellycollins.triggerfinger.data.daos

import android.os.Bundle

/**
 * Provides the ability to save and restore dao data using the activity bundle.
 */
interface IActivityDao {

    /**
     * Saves the current dao state to the provided.

     * @param bundle The bundle to save the current state to.
     */
    fun saveState(bundle: Bundle)

    /**
     * Restores the dao state to the state saved in the provided bundle.

     * @param bundle The bundle to use to restore the dao state.
     */
    fun restoreState(bundle: Bundle)

}
