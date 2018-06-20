package br.com.mobly.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.enzoteles.quickhelp.fragment.HelpManagerFragment
import br.com.enzoteles.quickhelp.security.HelpSecurity
import br.com.mobly.R
import br.com.mobly.content.ContentFragment

class MainActivity : AppCompatActivity() {

    //variable
    lateinit var manager: HelpManagerFragment
    lateinit var content: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {

        manager = HelpManagerFragment(this)
        HelpSecurity.manager = manager
        content = ContentFragment()
        manager!!.addFragment(R.id.content, content, "content", false)
    }
}
