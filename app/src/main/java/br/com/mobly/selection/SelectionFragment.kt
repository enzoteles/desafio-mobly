package br.com.mobly.selection

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.enzoteles.quickhelp.fragment.HelpFragment
import br.com.enzoteles.quickhelp.log.HelpLog
import br.com.mobly.R
import br.com.mobly.selection.adapter.SelectionAdapter
import br.com.sdk.webservice.domain.ArticlesItem
import br.com.sdk.webservice.domain.JsonArticles
import kotlinx.android.synthetic.main.selection.*


/**
 * create by enzo teles
 * */
class SelectionFragment: HelpFragment(), SelectionMVP.View{

    lateinit var presenter: SelectionMVP.Presenter
    lateinit var adapter: SelectionAdapter
    lateinit var layoutManager: LinearLayoutManager
    private val PAGE_SIZE = 5

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.selection, container, false)
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
        bt_revision.alpha = 0.5f
        bt_revision.isEnabled = false
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
        HelpLog.info("${articles}")

        adapter = SelectionAdapter(articles!!.embedded!!.articles as MutableList<ArticlesItem>, activity.baseContext)
        recyclerview.adapter = adapter
        layoutManager = LinearLayoutManager(activity.baseContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerview.layoutManager = layoutManager
        recyclerview.addOnScrollListener(recyclerViewOnScrollListener)



    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (layoutManager == null) layoutManager = LinearLayoutManager(activity.baseContext, LinearLayoutManager.HORIZONTAL, false)
            val visibleItemCount = layoutManager!!.childCount
            val totalItemCount = layoutManager!!.itemCount
            val firstVisibleItemPosition = layoutManager!!.findFirstVisibleItemPosition()

            HelpLog.info("visible ${visibleItemCount} -- total ${totalItemCount} == ${visibleItemCount + totalItemCount} ")
            HelpLog.info("firtsV ${firstVisibleItemPosition} ")
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount == PAGE_SIZE) {
                HelpLog.info("count")
                bt_revision.alpha = 1f
                bt_revision.isEnabled = true
            }else{
                bt_revision.alpha = 0.5f
                bt_revision.isEnabled = true
            }
        }
    }
}






















