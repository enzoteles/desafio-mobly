package br.com.mobly.content

import android.content.Context
import android.widget.ImageView

interface ContentMVP {

    interface View{
        fun initUI()
    }
    interface Presenter{
        fun callSelectionFragment()
        fun startAnimation(iv_logo: ImageView, baseContext: Context)
    }
}