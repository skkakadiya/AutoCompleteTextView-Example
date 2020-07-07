package com.test.autocompletetextviewexample

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Sanjay on 5/7/20.
 */
class AutoCompleteTextViewApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@AutoCompleteTextViewApplication))

        bind() from singleton { APIService() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { MainViewModelFactory(instance()) }
    }
}