package dependencies

import Libs

object AppDependencies {

    val appImplementation = arrayListOf(
        Libs.kotlinStdlib,
        Libs.material,
        Libs.constraintLayout,
        Libs.codeKtx,
        Libs.appcompat,
        Libs.lottie,
        Libs.viewModel,
        Libs.lifecyclesRuntime,
        Libs.liveData,
        Libs.testHamcrest
    )

    val appAndroidTestImplementation = arrayListOf(
        Libs.testJunitExt,
        Libs.testExpresso,
        Libs.testHamcrestLibrary
    )

    val appTestImplementation = arrayListOf(
        Libs.testJunit,
        Libs.testMockK

    )

}