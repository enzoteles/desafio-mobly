package br.com.mobly.content

import android.content.Context
import android.view.animation.AnimationUtils
import android.widget.ImageView
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.mobly.R
import br.com.mobly.selection.SelectionFragment

/**
 * create by enzo teles
 * */
class ContentPresenter(view: ContentMVP.View) : ContentMVP.Presenter {

    lateinit var selection: SelectionFragment

    /**
     * method to call the selection screen
     * */
    override fun callSelectionFragment() {
        selection = SelectionFragment()
        HelpSecurity.manager!!.replaceFragment(R.id.content, selection ,"selection", true)
    }

    /**
     * Animation of the logo of the start screen
     * */
    override fun startAnimation(iv_logo: ImageView, baseContext: Context) {
        var animation = AnimationUtils.loadAnimation(baseContext, R.anim.logo_animation)
        iv_logo.startAnimation(animation)
    }

}