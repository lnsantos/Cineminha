package com.lnsantos.base

import android.content.Context


/** Activity binding delegate, may be used since onCreate up to onDestroy (inclusive) */
inline fun <T : Context> Context.loggger(crossinline factory: (Context) -> T) =
    lazy(LazyThreadSafetyMode.NONE) {
        factory(this.applicationContext)
    }

