package br.com.mobly.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.mobly.R
import kotlinx.android.synthetic.main.content.*

/**
 * create by enzo teles
 * */
class ContentFragment: HelpFragment(), View.OnClickListener, ContentMVP.View{

    //variable
    lateinit var presenter: ContentMVP.Presenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.content, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ContentPresenter(this)
        initUI()
    }

    /**
     * method to start UI of the content screen
     * */
    override fun initUI() {
        presenter.startAnimation(iv_logo, activity.baseContext)
        bt_start.setOnClickListener(this)
    }

    /**
     * onClick
     * */
    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.bt_start -> {
                presenter.callSelectionFragment()
            }
        }
    }


}

