package dependencies

import Libs

object AppDependencies {

    val appImplementation = arrayListOf(
        Libs.kotlinStdlib,
        Libs.material,
        Libs.constraintLayout,
        Libs.codeKtx,
        Libs.appcompat
    )

    val appAndroidTestImplementation = arrayListOf(
        Libs.testJunitExt,
        Libs.testExpresso
    )

    val appTestImplementation = arrayListOf(
        Libs.testJunit
    )

}