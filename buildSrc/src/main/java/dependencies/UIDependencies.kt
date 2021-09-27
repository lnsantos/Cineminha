package dependencies

object UIDependencies {

    val implementation = arrayListOf(
        Libs.kotlinStdlib,
        Libs.material,
        Libs.constraintLayout,
        Libs.codeKtx,
        Libs.appcompat,
        Libs.lottie,
        Libs.viewModel,
        Libs.lifecyclesRuntime,
        Libs.liveData,
        Libs.fragmentKtx,
        Libs.testHamcrest
    )

    val androidTestImplementations = arrayListOf(
        Libs.testJunitExt,
        Libs.testExpresso,
        Libs.testMockkAndroid,
        Libs.testHamcrestLibrary

    )

    val testImplementations = arrayListOf(
        Libs.testJunit,
        Libs.testMockK
    )

}