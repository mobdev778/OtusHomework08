package com.github.mobdev778.homework08.domain

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.github.mobdev778.homework08.R

data class MainListItem(
    @DrawableRes val iconId: Int,
    @StringRes val labelId: Int,
    @StringRes val iconTransitionId: Int,
    @StringRes val labelTransitionId: Int,
    @IdRes val actionId: Int,
) {

    class Builder {

        private var iconId: Int = R.drawable.baseline_language_24
        private var labelId = R.string.tour_title
        private var iconTransitionId: Int = R.string.transition_tour_logo
        private var labelTransitionId: Int = R.string.transition_tour_title
        private var actionId: Int = R.id.action_MainFragment_to_TourFragment

        fun icon(@DrawableRes iconId: Int) = apply {
            this.iconId = iconId
        }

        fun label(@StringRes labelId: Int) = apply {
            this.labelId = labelId
        }

        fun iconTransition(@StringRes iconTransitionId: Int) = apply {
            this.iconTransitionId = iconTransitionId
        }

        fun labelTransition(@StringRes labelTransitionId: Int) = apply {
            this.labelTransitionId = labelTransitionId
        }

        fun action(@IdRes actionId: Int): MainListItem {
            this.actionId = actionId
            return MainListItem(iconId, labelId, iconTransitionId, labelTransitionId, actionId)
        }
    }

    companion object {
        fun icon(@DrawableRes iconId: Int): Builder {
            return Builder().apply { icon(iconId) }
        }
    }
}
