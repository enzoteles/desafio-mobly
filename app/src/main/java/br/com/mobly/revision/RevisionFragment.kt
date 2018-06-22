package br.com.mobly.revision

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.mobly.Constant
import br.com.mobly.R
import br.com.mobly.selection.SelectionMVP
import br.com.mobly.selection.SelectionPresenter
import br.com.mobly.selection.adapter.SelectionAdapter
import br.com.sdk.webservice.domain.ArticlesItem
import br.com.sdk.webservice.domain.JsonArticles
import kotlinx.android.synthetic.main.revision.*


/**
 * create by enzo teles
 * */
class RevisionFragment: HelpFragment(), SelectionMVP.View, View.OnClickListener{

    lateinit var presenter: SelectionMVP.Presenter
    lateinit var adapterL: RevisionAdapterList
    lateinit var adapterG: RevisionAdapterGrip
    lateinit var layoutManager: LinearLayoutManager
    lateinit var gridLayoutManager: GridLayoutManager
    private val PAGE_SIZE = 5

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.revision, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = SelectionPresenter(this)
        initUI()
        initData()
    }

    /**
     * method to init UI
     * */
    override fun initUI() {
        bt_list.setOnClickListener(this)
        bt_grid.setOnClickListener(this)
    }

    /**
     * method load articles of the api
     * */
    override fun initData() {
        presenter.initData()
    }

    /**
     * method to load articles of the api
     * @param articles
     * */
    override fun getArticles(articles: JsonArticles?) {

        Constant.articles = articles

        adapterL = RevisionAdapterList(articles!!.embedded!!.articles as MutableList<ArticlesItem>, activity.baseContext)
        rv_revision.adapter = adapterL
        layoutManager = LinearLayoutManager(activity.baseContext, LinearLayoutManager.VERTICAL, false)
        rv_revision.layoutManager = layoutManager

    }

    /**
     * Onclick
     * */
    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.bt_list->{
                adapterL = RevisionAdapterList(Constant.articles!!.embedded!!.articles as MutableList<ArticlesItem>, activity.baseContext)
                rv_revision.adapter = adapterL
                layoutManager = LinearLayoutManager(activity.baseContext, LinearLayoutManager.VERTICAL, false)
                rv_revision.layoutManager = layoutManager
            }
            R.id.bt_grid->{
                adapterG = RevisionAdapterGrip(Constant.articles!!.embedded!!.articles as MutableList<ArticlesItem>, activity.baseContext)
                rv_revision.adapter = adapterG
                gridLayoutManager = GridLayoutManager(activity.baseContext, 2)
                rv_revision.layoutManager = gridLayoutManager
            }
        }
    }
}






















